/*
 * Copyright (c) 2004, PostgreSQL Global Development Group
 * See the LICENSE file in the project root for more information.
 */

package org.postgresql.ssl;

import org.postgresql.PGProperty;
import org.postgresql.jdbc.SslMode;
import org.postgresql.ssl.NonValidatingFactory.NonValidatingTM;
import org.postgresql.util.GT;
import org.postgresql.util.ObjectFactory;
import org.postgresql.util.PSQLException;
import org.postgresql.util.PSQLState;
import org.postgresql.log.Logger;
import org.postgresql.log.Log;


import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Properties;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 * Provide an SSLSocketFactory that is compatible with the libpq behaviour.
 */
public class LibPQFactory extends WrappedFactory {

  LazyKeyManager km;
  private static Log LOGGER = Logger.getLogger(LibPQFactory.class.getName());

  /**
   * @param info the connection parameters The following parameters are used:
   *        sslmode,sslcert,sslkey,sslrootcert,sslhostnameverifier,sslpasswordcallback,sslpassword
   * @throws PSQLException if security error appears when initializing factory
   */
  public LibPQFactory(Properties info) throws PSQLException {
    try {
      String contextConfig = PGProperty.SSL_CONTEXT.get(info);
      if (contextConfig == null || "".equals(contextConfig.trim())) {
        contextConfig = "TLS";
      }
      SSLContext ctx = SSLContext.getInstance(contextConfig); // or "SSL" ?

      // Determining the default file location
      String pathsep = System.getProperty("file.separator");
      String defaultdir;
      boolean defaultfile = false;
      if (System.getProperty("os.name").toLowerCase().contains("windows")) { // It is Windows
        defaultdir = System.getenv("APPDATA") + pathsep + "postgresql" + pathsep;
      } else {
        defaultdir = System.getProperty("user.home") + pathsep + ".postgresql" + pathsep;
      }

      // Load the client's certificate and key
      String sslcertfile = PGProperty.SSL_CERT.get(info);
      if (sslcertfile == null) { // Fall back to default
        defaultfile = true;
        sslcertfile = defaultdir + "postgresql.crt";
      }
      String sslkeyfile = PGProperty.SSL_KEY.get(info);
      if (sslkeyfile == null) { // Fall back to default
        defaultfile = true;
        sslkeyfile = defaultdir + "postgresql.pk8";
      }

      // Determine the callback handler
      CallbackHandler cbh;
      String sslpasswordcallback = PGProperty.SSL_PASSWORD_CALLBACK.get(info);
      if (sslpasswordcallback != null) {
        try {
          cbh = ObjectFactory.instantiate(CallbackHandler.class, sslpasswordcallback, info, false, null);
        } catch (Exception e) {
          throw new PSQLException(
              GT.tr("The password callback class provided {0} could not be instantiated.",
                  sslpasswordcallback),
              PSQLState.CONNECTION_FAILURE, e);
        }
      } else {
        cbh = new ConsoleCallbackHandler(PGProperty.SSL_PASSWORD.get(info));
      }

      // If the properties are empty, give null to prevent client key selection
      km = new LazyKeyManager(("".equals(sslcertfile) ? null : sslcertfile),
          ("".equals(sslkeyfile) ? null : sslkeyfile), cbh, defaultfile, PGProperty.SSL_PRIVATEKEY_FACTORY.get(info));

      TrustManager[] tm;
      SslMode sslMode = SslMode.of(info);
      if (!sslMode.verifyCertificate()) {
        // server validation is not required
        tm = new TrustManager[]{new NonValidatingTM()};
      } else {
        // Load the server certificate

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("PKIX");
        KeyStore ks;
        try {
          ks = KeyStore.getInstance("jks");
        } catch (KeyStoreException e) {
          // this should never happen
          throw new NoSuchAlgorithmException("jks KeyStore not available");
        }
        String sslrootcertfile = PGProperty.SSL_ROOT_CERT.get(info);
        if (sslrootcertfile == null) { // Fall back to default
          sslrootcertfile = defaultdir + "root.crt";
        }
        FileInputStream fis;
        try {
          fis = new FileInputStream(sslrootcertfile); // NOSONAR
        } catch (FileNotFoundException ex) {
          throw new PSQLException(
              GT.tr("Could not open SSL root certificate file {0}.", sslrootcertfile),
              PSQLState.CONNECTION_FAILURE, ex);
        }
        try {
          CertificateFactory cf = CertificateFactory.getInstance("X.509");
          // not work in java 1.4
          Object[] certs = cf.generateCertificates(fis).toArray(new Certificate[]{});
          ks.load(null, null);
          for (int i = 0; i < certs.length; i++) {
            ks.setCertificateEntry("cert" + i, (Certificate) certs[i]);
          }
          tmf.init(ks);
        } catch (IOException ioex) {
          throw new PSQLException(
              GT.tr("Could not read SSL root certificate file {0}.", sslrootcertfile),
              PSQLState.CONNECTION_FAILURE, ioex);
        } catch (GeneralSecurityException gsex) {
          throw new PSQLException(
              GT.tr("Loading the SSL root certificate {0} into a TrustManager failed.",
                      sslrootcertfile),
              PSQLState.CONNECTION_FAILURE, gsex);
        } finally {
          try {
            fis.close();
          } catch (IOException e) {
              /* ignore */
              LOGGER.trace("Catch IOException on close:", e);
          }
        }
        tm = tmf.getTrustManagers();
      }

      // finally we can initialize the context
      try {
        ctx.init(new KeyManager[]{km}, tm, null);
      } catch (KeyManagementException ex) {
        throw new PSQLException(GT.tr("Could not initialize SSL context."),
            PSQLState.CONNECTION_FAILURE, ex);
      }

      _factory = ctx.getSocketFactory();
    } catch (NoSuchAlgorithmException ex) {
      throw new PSQLException(GT.tr("Could not find a java cryptographic algorithm: {0}.",
              ex.getMessage()), PSQLState.CONNECTION_FAILURE, ex);
    }
  }

  /**
   * Propagates any exception from {@link LazyKeyManager}.
   *
   * @throws PSQLException if there is an exception to propagate
   */
  public void throwKeyManagerException() throws PSQLException {
    if (km != null) {
      km.throwKeyManagerException();
    }
  }

  /**
   * A CallbackHandler that reads the password from the console or returns the password given to its
   * constructor.
   */
  static class ConsoleCallbackHandler implements CallbackHandler {

    private char[] password = null;

    ConsoleCallbackHandler(String password) {
      if (password != null) {
        this.password = password.toCharArray();
      }
    }

    /**
     * Handles the callbacks.
     *
     * @param callbacks The callbacks to handle
     * @throws UnsupportedCallbackException If the console is not available or other than
     *         PasswordCallback is supplied
     */
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
      Console cons = System.console();
      if (cons == null && password == null) {
        throw new UnsupportedCallbackException(callbacks[0], "Console is not available");
      }
      for (Callback callback : callbacks) {
        if (!(callback instanceof PasswordCallback)) {
          throw new UnsupportedCallbackException(callback);
        }
        PasswordCallback pwdCallback = (PasswordCallback) callback;
        if (password != null) {
          pwdCallback.setPassword(password);
          continue;
        }
        // It is used instead of cons.readPassword(prompt), because the prompt may contain '%'
        // characters
        pwdCallback.setPassword(cons.readPassword("%s", pwdCallback.getPrompt()));
      }
    }
  }
}
