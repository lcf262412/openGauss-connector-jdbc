/* Automatically generated by GNU msgfmt.  Do not modify!  */
package org.postgresql.translation;
public class messages_sr extends java.util.ResourceBundle {
  private static final java.lang.String[] table;
  static {
    java.lang.String[] t = new java.lang.String[794];
    t[0] = "";
    t[1] = "Project-Id-Version: PostgreSQL 8.1\nReport-Msgid-Bugs-To: \nPO-Revision-Date: 2009-05-26 11:13+0100\nLast-Translator: Bojan Škaljac <skaljac (at) gmail.com>\nLanguage-Team: Srpski <skaljac@gmail.com>\nLanguage: \nMIME-Version: 1.0\nContent-Type: text/plain; charset=UTF-8\nContent-Transfer-Encoding: 8bit\nX-Poedit-Language: Serbian\nX-Poedit-Country: YUGOSLAVIA\n";
    t[4] = "DataSource has been closed.";
    t[5] = "DataSource je zatvoren.";
    t[8] = "Invalid flags {0}";
    t[9] = "Nevažeće zastavice {0}";
    t[18] = "Where: {0}";
    t[19] = "Gde: {0}";
    t[24] = "Unknown XML Source class: {0}";
    t[25] = "Nepoznata XML ulazna klasa: {0}";
    t[26] = "The connection attempt failed.";
    t[27] = "Pokušaj konektovanja propao.";
    t[28] = "Currently positioned after the end of the ResultSet.  You cannot call deleteRow() here.";
    t[29] = "Trenutna pozicija posle kraja ResultSet-a.  Ne možete pozvati deleteRow() na toj poziciji.";
    t[32] = "Can''t use query methods that take a query string on a PreparedStatement.";
    t[33] = "Ne možete da koristite metode za upit koji uzimaju string iz upita u PreparedStatement-u.";
    t[36] = "Multiple ResultSets were returned by the query.";
    t[37] = "Višestruki ResultSet-vi su vraćeni od strane upita.";
    t[50] = "Too many update results were returned.";
    t[51] = "Previše rezultata za ažuriranje je vraćeno.";
    t[58] = "Illegal UTF-8 sequence: initial byte is {0}: {1}";
    t[59] = "Ilegalna UTF-8 sekvenca: inicijalni bajt je {0}: {1}";
    t[66] = "The column name {0} was not found in this ResultSet.";
    t[67] = "Ime kolone {0} nije pronadjeno u ResultSet.";
    t[70] = "Fastpath call {0} - No result was returned and we expected an integer.";
    t[71] = "Fastpath poziv {0} - Nikakav rezultat nije vraćen a očekivan je integer.";
    t[74] = "Protocol error.  Session setup failed.";
    t[75] = "Greška protokola.  Zakazivanje sesije propalo.";
    t[76] = "A CallableStatement was declared, but no call to registerOutParameter(1, <some type>) was made.";
    t[77] = "CallableStatement jedeklarisan ali nije bilo poziva registerOutParameter (1, <neki_tip>).";
    t[78] = "ResultSets with concurrency CONCUR_READ_ONLY cannot be updated.";
    t[79] = "ResultSets sa osobinom CONCUR_READ_ONLY ne moeže biti ažuriran.";
    t[90] = "LOB positioning offsets start at 1.";
    t[91] = "LOB pozicija ofset počinje kod 1.";
    t[92] = "Internal Position: {0}";
    t[93] = "Interna pozicija: {0}";
    t[96] = "free() was called on this LOB previously";
    t[97] = "free() je pozvan na ovom LOB-u prethodno";
    t[100] = "Cannot change transaction read-only property in the middle of a transaction.";
    t[101] = "Nije moguće izmeniti read-only osobinu transakcije u sred izvršavanja transakcije.";
    t[102] = "The JVM claims not to support the {0} encoding.";
    t[103] = "JVM tvrdi da ne podržava {0} encoding.";
    t[108] = "{0} function doesn''t take any argument.";
    t[109] = "Funkcija {0} nema parametara.";
    t[112] = "xid must not be null";
    t[113] = "xid ne sme biti null";
    t[114] = "Connection has been closed.";
    t[115] = "Konekcija je već zatvorena.";
    t[122] = "The server does not support SSL.";
    t[123] = "Server ne podržava SSL.";
    t[124] = "Custom type maps are not supported.";
    t[125] = "Mape sa korisnički definisanim tipovima nisu podržane.";
    t[140] = "Illegal UTF-8 sequence: byte {0} of {1} byte sequence is not 10xxxxxx: {2}";
    t[141] = "Ilegalna UTF-8 sekvenca: bajt {0} od {1} bajtova sekvence nije 10xxxxxx: {2}";
    t[148] = "Hint: {0}";
    t[149] = "Nagovest: {0}";
    t[152] = "Unable to find name datatype in the system catalogs.";
    t[153] = "Nije moguće pronaći ime tipa podatka u sistemskom katalogu.";
    t[156] = "Unsupported Types value: {0}";
    t[157] = "Za tip nije podržana vrednost: {0}";
    t[158] = "Unknown type {0}.";
    t[159] = "Nepoznat tip {0}.";
    t[166] = "{0} function takes two and only two arguments.";
    t[167] = "Funkcija {0} prima dva i samo dva parametra.";
    t[170] = "Finalizing a Connection that was never closed:";
    t[171] = "Dovršavanje konekcije koja nikada nije zatvorena:";
    t[180] = "The maximum field size must be a value greater than or equal to 0.";
    t[181] = "Maksimalna vrednost veličine polja mora biti vrednost veća ili jednaka 0.";
    t[186] = "PostgreSQL LOBs can only index to: {0}";
    t[187] = "PostgreSQL LOB mogu jedino da označavaju: {0}";
    t[194] = "Method {0} is not yet implemented.";
    t[195] = "Metod {0} nije još impelemtiran.";
    t[198] = "Error loading default settings from driverconfig.properties";
    t[199] = "Greška u čitanju standardnih podešavanja iz driverconfig.properties";
    t[200] = "Results cannot be retrieved from a CallableStatement before it is executed.";
    t[201] = "Razultat nemože da se primi iz CallableStatement pre nego što se on izvrši.";
    t[202] = "Large Objects may not be used in auto-commit mode.";
    t[203] = "Veliki objekti (Large Object) se nemogu koristiti u auto-commit modu.";
    t[208] = "Expected command status BEGIN, got {0}.";
    t[209] = "Očekivan status komande je BEGIN, a dobijeno je {0}.";
    t[218] = "Invalid fetch direction constant: {0}.";
    t[219] = "Pogrešna konstanta za direkciju donošenja: {0}.";
    t[222] = "{0} function takes three and only three arguments.";
    t[223] = "Funkcija {0} prima tri i samo tri parametra.";
    t[226] = "This SQLXML object has already been freed.";
    t[227] = "Ovaj SQLXML je već obrisan.";
    t[228] = "Cannot update the ResultSet because it is either before the start or after the end of the results.";
    t[229] = "Nije moguće ažurirati ResultSet zato što je ili početak ili kraj rezultata.";
    t[230] = "The JVM claims not to support the encoding: {0}";
    t[231] = "JVM tvrdi da ne podržava encoding: {0}";
    t[232] = "Parameter of type {0} was registered, but call to get{1} (sqltype={2}) was made.";
    t[233] = "Parametar tipa {0} je registrovan,ali poziv za get{1} (sql tip={2}) je izvršen.";
    t[234] = "Error rolling back prepared transaction. rollback xid={0}, preparedXid={1}, currentXid={2}";
    t[235] = "Greška prilikom povratka na prethodo pripremljenu transakciju. rollback xid={0}, preparedXid={1}, currentXid={2}";
    t[240] = "Cannot establish a savepoint in auto-commit mode.";
    t[241] = "U auto-commit modu nije moguće podešavanje tački snimanja.";
    t[242] = "Cannot retrieve the id of a named savepoint.";
    t[243] = "Nije moguće primiti id imena tačke snimanja.";
    t[244] = "The column index is out of range: {0}, number of columns: {1}.";
    t[245] = "Indeks kolone van osega: {0}, broj kolona: {1}.";
    t[250] = "Something unusual has occurred to cause the driver to fail. Please report this exception.";
    t[251] = "Nešto neobično se dogodilo i drajver je zakazao. Molim prijavite ovaj izuzetak.";
    t[260] = "Cannot cast an instance of {0} to type {1}";
    t[261] = "Nije moguće kastovati instancu {0} u tip {1}";
    t[264] = "Unknown Types value.";
    t[265] = "Nepoznata vrednost za Types.";
    t[266] = "Invalid stream length {0}.";
    t[267] = "Nevažeća dužina toka {0}.";
    t[272] = "Cannot retrieve the name of an unnamed savepoint.";
    t[273] = "Nije moguće izvaditi ime tačke snimanja koja nema ime.";
    t[274] = "Unable to translate data into the desired encoding.";
    t[275] = "Nije moguće prevesti podatke u odabrani encoding format.";
    t[276] = "Expected an EOF from server, got: {0}";
    t[277] = "Očekivan EOF od servera, a dobijeno: {0}";
    t[278] = "Bad value for type {0} : {1}";
    t[279] = "Pogrešna vrednost za tip {0} : {1}";
    t[280] = "The server requested password-based authentication, but no password was provided.";
    t[281] = "Server zahteva autentifikaciju baziranu na šifri, ali šifra nije prosleđena.";
    t[286] = "Unable to create SAXResult for SQLXML.";
    t[287] = "Nije moguće kreirati SAXResult za SQLXML.";
    t[292] = "Error during recover";
    t[293] = "Greška prilikom oporavljanja.";
    t[294] = "tried to call end without corresponding start call. state={0}, start xid={1}, currentXid={2}, preparedXid={3}";
    t[295] = "Pokušaj pozivanja kraja pre odgovarajućeg početka. state={0}, start xid={1}, currentXid={2}, preparedXid={3}";
    t[296] = "Truncation of large objects is only implemented in 8.3 and later servers.";
    t[297] = "Skraćivanje velikih objekata je implementirano samo u 8.3 i novijim serverima.";
    t[298] = "This PooledConnection has already been closed.";
    t[299] = "PooledConnection je već zatvoren.";
    t[302] = "ClientInfo property not supported.";
    t[303] = "ClientInfo property nije podržan.";
    t[306] = "Fetch size must be a value greater to or equal to 0.";
    t[307] = "Doneta veličina mora biti vrednost veća ili jednaka 0.";
    t[312] = "A connection could not be made using the requested protocol {0}.";
    t[313] = "Konekciju nije moguće kreirati uz pomoć protokola {0}.";
    t[318] = "Unknown XML Result class: {0}";
    t[319] = "nepoznata XML klasa rezultata: {0}";
    t[322] = "There are no rows in this ResultSet.";
    t[323] = "U ResultSet-u nema redova.";
    t[324] = "Unexpected command status: {0}.";
    t[325] = "Neočekivan komandni status: {0}.";
    t[330] = "Heuristic commit/rollback not supported. forget xid={0}";
    t[331] = "Heuristički commit/rollback nije podržan. forget xid={0}";
    t[334] = "Not on the insert row.";
    t[335] = "Nije mod ubacivanja redova.";
    t[336] = "This SQLXML object has already been initialized, so you cannot manipulate it further.";
    t[337] = "SQLXML objekat je već inicijalizovan, tako da ga nije moguće dodatno menjati.";
    t[344] = "Server SQLState: {0}";
    t[345] = "SQLState servera: {0}";
    t[348] = "The server''s standard_conforming_strings parameter was reported as {0}. The JDBC driver expected on or off.";
    t[349] = "Serverov standard_conforming_strings parametar javlja {0}. JDBC drajver ocekuje on ili off.";
    t[360] = "The driver currently does not support COPY operations.";
    t[361] = "Drajver trenutno ne podržava COPY operacije.";
    t[364] = "The array index is out of range: {0}, number of elements: {1}.";
    t[365] = "Indeks niza je van opsega: {0}, broj elemenata: {1}.";
    t[374] = "suspend/resume not implemented";
    t[375] = "obustavljanje/nastavljanje nije implementirano.";
    t[378] = "Not implemented: one-phase commit must be issued using the same connection that was used to start it";
    t[379] = "Nije implementirano: Commit iz jedne faze mora biti izdat uz korištenje iste konekcije koja je korištena za startovanje.";
    t[380] = "Error during one-phase commit. commit xid={0}";
    t[381] = "Kreška prilikom commit-a iz jedne faze. commit xid={0}";
    t[398] = "Cannot call cancelRowUpdates() when on the insert row.";
    t[399] = "Nije moguće pozvati cancelRowUpdates() prilikom ubacivanja redova.";
    t[400] = "Cannot reference a savepoint after it has been released.";
    t[401] = "Nije moguće referenciranje tačke snimanja nakon njenog oslobađanja.";
    t[402] = "You must specify at least one column value to insert a row.";
    t[403] = "Morate specificirati barem jednu vrednost za kolonu da bi ste ubacili red.";
    t[404] = "Unable to determine a value for MaxIndexKeys due to missing system catalog data.";
    t[405] = "Nije moguće odrediti vrednost za MaxIndexKezs zbog nedostatka podataka u sistemskom katalogu.";
    t[412] = "Illegal UTF-8 sequence: final value is out of range: {0}";
    t[413] = "Ilegalna UTF-8 sekvenca: finalna vrednost je van opsega: {0}";
    t[414] = "{0} function takes two or three arguments.";
    t[415] = "Funkcija {0} prima dva ili tri parametra.";
    t[428] = "Unable to convert DOMResult SQLXML data to a string.";
    t[429] = "Nije moguće konvertovati DOMResult SQLXML podatke u string.";
    t[434] = "Unable to decode xml data.";
    t[435] = "Neuspešno dekodiranje XML podataka.";
    t[440] = "Unexpected error writing large object to database.";
    t[441] = "Neočekivana greška prilikom upisa velikog objekta u bazu podataka.";
    t[442] = "Zero bytes may not occur in string parameters.";
    t[443] = "Nula bajtovji se ne smeju pojavljivati u string parametrima.";
    t[444] = "A result was returned when none was expected.";
    t[445] = "Rezultat vraćen ali nikakav rezultat nije očekivan.";
    t[446] = "Not implemented: 2nd phase commit must be issued using an idle connection. commit xid={0}, currentXid={1}, state={2], transactionState={3}";
    t[447] = "Nije implementirano: Dvofazni commit mora biti izdat uz korištenje besposlene konekcije. commit xid={0}, currentXid={1}, state={2], transactionState={3}";
    t[450] = "ResultSet is not updateable.  The query that generated this result set must select only one table, and must select all primary keys from that table. See the JDBC 2.1 API Specification, section 5.6 for more details.";
    t[451] = "ResultSet nije moguće ažurirati. Upit koji je generisao ovaj razultat mora selektoati jedino tabelu,i mora selektovati sve primrne ključeve iz te tabele. Pogledajte API specifikaciju za JDBC 2.1, sekciju 5.6 za više detalja.";
    t[454] = "Bind message length {0} too long.  This can be caused by very large or incorrect length specifications on InputStream parameters.";
    t[455] = "Dužina vezivne poruke {0} prevelika.  Ovo je možda rezultat veoma velike ili pogrešne dužine specifikacije za InputStream parametre.";
    t[460] = "Statement has been closed.";
    t[461] = "Statemen je već zatvoren.";
    t[462] = "No value specified for parameter {0}.";
    t[463] = "Nije zadata vrednost za parametar {0}.";
    t[468] = "The array index is out of range: {0}";
    t[469] = "Indeks niza je van opsega: {0}";
    t[474] = "Unable to bind parameter values for statement.";
    t[475] = "Nije moguće naći vrednost vezivnog parametra za izjavu (statement).";
    t[476] = "Can''t refresh the insert row.";
    t[477] = "Nije moguće osvežiti ubačeni red.";
    t[480] = "No primary key found for table {0}.";
    t[481] = "Nije pronađen ključ za tabelu {0}.";
    t[482] = "Cannot change transaction isolation level in the middle of a transaction.";
    t[483] = "Nije moguće izmeniti nivo izolacije transakcije u sred izvršavanja transakcije.";
    t[498] = "Provided InputStream failed.";
    t[499] = "Pribaljeni InputStream zakazao.";
    t[500] = "The parameter index is out of range: {0}, number of parameters: {1}.";
    t[501] = "Index parametra je van opsega: {0}, broj parametara je: {1}.";
    t[502] = "The server''s DateStyle parameter was changed to {0}. The JDBC driver requires DateStyle to begin with ISO for correct operation.";
    t[503] = "Serverov DataStyle parametar promenjen u {0}. JDBC zahteva da DateStyle počinje sa ISO za uspešno završavanje operacije.";
    t[508] = "Connection attempt timed out.";
    t[509] = "Isteklo je vreme za pokušaj konektovanja.";
    t[512] = "Internal Query: {0}";
    t[513] = "Interni upit: {0}";
    t[514] = "Error preparing transaction. prepare xid={0}";
    t[515] = "Greška u pripremanju transakcije. prepare xid={0}";
    t[518] = "The authentication type {0} is not supported. Check that you have configured the pg_hba.conf file to include the client''s IP address or subnet, and that it is using an authentication scheme supported by the driver.";
    t[519] = "Tip autentifikacije {0} nije podržan. Proverite dali imate podešen pg_hba.conf fajl koji uključuje klijentovu IP adresu ili podmrežu, i da ta mreža koristi šemu autentifikacije koja je podržana od strane ovog drajvera.";
    t[526] = "Interval {0} not yet implemented";
    t[527] = "Interval {0} još nije implementiran.";
    t[532] = "Conversion of interval failed";
    t[533] = "Konverzija intervala propala.";
    t[540] = "Query timeout must be a value greater than or equals to 0.";
    t[541] = "Tajm-aut mora biti vrednost veća ili jednaka 0.";
    t[542] = "Connection has been closed automatically because a new connection was opened for the same PooledConnection or the PooledConnection has been closed.";
    t[543] = "Konekcija je zatvorena automatski zato što je nova konekcija otvorena za isti PooledConnection ili je PooledConnection zatvoren.";
    t[544] = "ResultSet not positioned properly, perhaps you need to call next.";
    t[545] = "ResultSet nije pravilno pozicioniran, možda je potrebno da pozovete next.";
    t[546] = "Prepare called before end. prepare xid={0}, state={1}";
    t[547] = "Pripremanje poziva pre kraja. prepare xid={0}, state={1}";
    t[548] = "Invalid UUID data.";
    t[549] = "Nevažeća UUID podatak.";
    t[550] = "This statement has been closed.";
    t[551] = "Statement je zatvoren.";
    t[552] = "Can''t infer the SQL type to use for an instance of {0}. Use setObject() with an explicit Types value to specify the type to use.";
    t[553] = "Nije moguće zaključiti SQL tip koji bi se koristio sa instancom {0}. Koristite setObject() sa zadatim eksplicitnim tipom vrednosti.";
    t[554] = "Cannot call updateRow() when on the insert row.";
    t[555] = "Nije moguće pozvati updateRow() prilikom ubacivanja redova.";
    t[562] = "Detail: {0}";
    t[563] = "Detalji: {0}";
    t[566] = "Cannot call deleteRow() when on the insert row.";
    t[567] = "Nije moguće pozvati deleteRow() prilikom ubacivanja redova.";
    t[568] = "Currently positioned before the start of the ResultSet.  You cannot call deleteRow() here.";
    t[569] = "Trenutna pozicija pre početka ResultSet-a.  Ne možete pozvati deleteRow() na toj poziciji.";
    t[576] = "Illegal UTF-8 sequence: final value is a surrogate value: {0}";
    t[577] = "Ilegalna UTF-8 sekvenca: finalna vrednost je zamena vrednosti: {0}";
    t[578] = "Unknown Response Type {0}.";
    t[579] = "Nepoznat tip odziva {0}.";
    t[582] = "Unsupported value for stringtype parameter: {0}";
    t[583] = "Vrednost za parametar tipa string nije podržana: {0}";
    t[584] = "Conversion to type {0} failed: {1}.";
    t[585] = "Konverzija u tip {0} propala: {1}.";
    t[586] = "This SQLXML object has not been initialized, so you cannot retrieve data from it.";
    t[587] = "SQLXML objekat nije inicijalizovan tako da nije moguće preuzimati podatke iz njega.";
    t[600] = "Unable to load the class {0} responsible for the datatype {1}";
    t[601] = "Nije moguće učitati kalsu {0} odgovornu za tip podataka {1}";
    t[604] = "The fastpath function {0} is unknown.";
    t[605] = "Fastpath funkcija {0} je nepoznata.";
    t[608] = "Malformed function or procedure escape syntax at offset {0}.";
    t[609] = "Pogrešna sintaksa u funkciji ili proceduri na poziciji {0}.";
    t[612] = "Provided Reader failed.";
    t[613] = "Pribavljeni čitač (Reader) zakazao.";
    t[614] = "Maximum number of rows must be a value grater than or equal to 0.";
    t[615] = "Maksimalni broj redova mora biti vrednosti veće ili jednake 0.";
    t[616] = "Failed to create object for: {0}.";
    t[617] = "Propao pokušaj kreiranja objekta za: {0}.";
    t[620] = "Conversion of money failed.";
    t[621] = "Konverzija novca (money) propala.";
    t[622] = "Premature end of input stream, expected {0} bytes, but only read {1}.";
    t[623] = "Prevremen završetak ulaznog toka podataka,očekivano {0} bajtova, a pročitano samo {1}.";
    t[626] = "An unexpected result was returned by a query.";
    t[627] = "Nepredviđen rezultat je vraćen od strane upita.";
    t[644] = "Invalid protocol state requested. Attempted transaction interleaving is not supported. xid={0}, currentXid={1}, state={2}, flags={3}";
    t[645] = "Preplitanje transakcija nije implementirano. xid={0}, currentXid={1}, state={2}, flags={3}";
    t[646] = "An error occurred while setting up the SSL connection.";
    t[647] = "Greška se dogodila prilikom podešavanja SSL konekcije.";
    t[654] = "Illegal UTF-8 sequence: {0} bytes used to encode a {1} byte value: {2}";
    t[655] = "Ilegalna UTF-8 sekvenca: {0} bytes used to encode a {1} byte value: {2}";
    t[656] = "Not implemented: Prepare must be issued using the same connection that started the transaction. currentXid={0}, prepare xid={1}";
    t[657] = "Nije implementirano: Spremanje mora biti pozvano uz korišćenje iste konekcije koja se koristi za startovanje transakcije. currentXid={0}, prepare xid={1}";
    t[658] = "The SSLSocketFactory class provided {0} could not be instantiated.";
    t[659] = "SSLSocketFactory klasa koju pruža {0} se nemože instancirati.";
    t[662] = "Failed to convert binary xml data to encoding: {0}.";
    t[663] = "Neuspešno konvertovanje binarnih XML podataka u kodnu stranu: {0}.";
    t[670] = "Position: {0}";
    t[671] = "Pozicija: {0}";
    t[676] = "Location: File: {0}, Routine: {1}, Line: {2}";
    t[677] = "Lokacija: Fajl: {0}, Rutina: {1}, Linija: {2}";
    t[684] = "Cannot tell if path is open or closed: {0}.";
    t[685] = "Nije moguće utvrditi dali je putanja otvorena ili zatvorena: {0}.";
    t[690] = "Unable to create StAXResult for SQLXML";
    t[691] = "Nije moguće kreirati StAXResult za SQLXML";
    t[700] = "Cannot convert an instance of {0} to type {1}";
    t[701] = "Nije moguće konvertovati instancu {0} u tip {1}";
    t[710] = "{0} function takes four and only four argument.";
    t[711] = "Funkcija {0} prima četiri i samo četiri parametra.";
    t[718] = "Interrupted while attempting to connect.";
    t[719] = "Prekinut pokušaj konektovanja.";
    t[722] = "Your security policy has prevented the connection from being attempted.  You probably need to grant the connect java.net.SocketPermission to the database server host and port that you wish to connect to.";
    t[723] = "Sigurnosna podešavanja su sprečila konekciju. Verovatno je potrebno da dozvolite konekciju klasi java.net.SocketPermission na bazu na serveru.";
    t[728] = "Failed to initialize LargeObject API";
    t[729] = "Propao pokušaj inicijalizacije LargeObject API-ja.";
    t[734] = "No function outputs were registered.";
    t[735] = "Nije registrovan nikakv izlaz iz funkcije.";
    t[736] = "{0} function takes one and only one argument.";
    t[737] = "Funkcija {0} prima jedan i samo jedan parametar.";
    t[744] = "This ResultSet is closed.";
    t[745] = "ResultSet je zatvoren.";
    t[746] = "Invalid character data was found.  This is most likely caused by stored data containing characters that are invalid for the character set the database was created in.  The most common example of this is storing 8bit data in a SQL_ASCII database.";
    t[747] = "Pronađeni su nevažeći karakter podaci. Uzrok je najverovatnije to što pohranjeni podaci sadrže karaktere koji su nevažeći u setu karaktera sa kojima je baza kreirana.  Npr. Čuvanje 8bit podataka u SQL_ASCII bazi podataka.";
    t[752] = "Error disabling autocommit";
    t[753] = "Greška u isključivanju autokomita";
    t[754] = "Ran out of memory retrieving query results.";
    t[755] = "Nestalo je memorije prilikom preuzimanja rezultata upita.";
    t[756] = "Returning autogenerated keys is not supported.";
    t[757] = "Vraćanje autogenerisanih ključeva nije podržano.";
    t[760] = "Operation requires a scrollable ResultSet, but this ResultSet is FORWARD_ONLY.";
    t[761] = "Operacija zahteva skrolabilan ResultSet,ali ovaj ResultSet je FORWARD_ONLY.";
    t[762] = "A CallableStatement function was executed and the out parameter {0} was of type {1} however type {2} was registered.";
    t[763] = "CallableStatement funkcija je izvršena dok je izlazni parametar {0} tipa {1} a tip {2} je registrovan kao izlazni parametar.";
    t[764] = "Unable to find server array type for provided name {0}.";
    t[765] = "Neuspešno nalaženje liste servera za zadato ime {0}.";
    t[768] = "Unknown ResultSet holdability setting: {0}.";
    t[769] = "Nepoznata ResultSet podešavanja za mogućnost držanja (holdability): {0}.";
    t[772] = "Transaction isolation level {0} not supported.";
    t[773] = "Nivo izolacije transakcije {0} nije podržan.";
    t[774] = "Zero bytes may not occur in identifiers.";
    t[775] = "Nula bajtovji se ne smeju pojavljivati u identifikatorima.";
    t[776] = "No results were returned by the query.";
    t[777] = "Nikakav rezultat nije vraćen od strane upita.";
    t[778] = "A CallableStatement was executed with nothing returned.";
    t[779] = "CallableStatement je izvršen ali ništa nije vrećeno kao rezultat.";
    t[780] = "wasNull cannot be call before fetching a result.";
    t[781] = "wasNull nemože biti pozvan pre zahvatanja rezultata.";
    t[784] = "Returning autogenerated keys by column index is not supported.";
    t[785] = "Vraćanje autogenerisanih ključeva po kloloni nije podržano.";
    t[786] = "This statement does not declare an OUT parameter.  Use '{' ?= call ... '}' to declare one.";
    t[787] = "Izraz ne deklariše izlazni parametar. Koristite '{' ?= poziv ... '}' za deklarisanje.";
    t[788] = "Can''t use relative move methods while on the insert row.";
    t[789] = "Ne može se koristiti metod relativnog pomeranja prilikom ubacivanja redova.";
    t[790] = "A CallableStatement was executed with an invalid number of parameters";
    t[791] = "CallableStatement je izvršen sa nevažećim brojem parametara";
    t[792] = "Connection is busy with another transaction";
    t[793] = "Konekcija je zauzeta sa drugom transakciom.";
    table = t;
  }
  public java.lang.Object handleGetObject (java.lang.String msgid) throws java.util.MissingResourceException {
    int hash_val = msgid.hashCode() & 0x7fffffff;
    int idx = (hash_val % 397) << 1;
    {
      java.lang.Object found = table[idx];
      if (found == null)
        return null;
      if (msgid.equals(found))
        return table[idx + 1];
    }
    int incr = ((hash_val % 395) + 1) << 1;
    for (;;) {
      idx += incr;
      if (idx >= 794)
        idx -= 794;
      java.lang.Object found = table[idx];
      if (found == null)
        return null;
      if (msgid.equals(found))
        return table[idx + 1];
    }
  }
  public java.util.Enumeration getKeys () {
    return
      new java.util.Enumeration() {
        private int idx = 0;
        { while (idx < 794 && table[idx] == null) idx += 2; }
        public boolean hasMoreElements () {
          return (idx < 794);
        }
        public java.lang.Object nextElement () {
          java.lang.Object key = table[idx];
          do idx += 2; while (idx < 794 && table[idx] == null);
          return key;
        }
      };
  }
  public java.util.ResourceBundle getParent () {
    return parent;
  }
}
