/*
 * Copyright (c) 2016, PostgreSQL Global Development Group
 * See the LICENSE file in the project root for more information.
 */

package org.postgresql.core.v3.replication;

import org.postgresql.copy.CopyDual;
import org.postgresql.replication.LogSequenceNumber;
import org.postgresql.replication.PGReplicationStream;
import org.postgresql.replication.ReplicationType;
import org.postgresql.util.GT;
import org.postgresql.util.PSQLException;
import org.postgresql.util.PSQLState;
import org.postgresql.log.Logger;
import org.postgresql.log.Log;

import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class V3PGReplicationStream implements PGReplicationStream {

  private static Log LOGGER = Logger.getLogger(V3PGReplicationStream.class.getName());
  public static final long POSTGRES_EPOCH_2000_01_01 = 946684800000L;
  private final CopyDual copyDual;
  private final long updateInterval;
  private final ReplicationType replicationType;
  private long lastStatusUpdate;
  private boolean closeFlag = false;

  private LogSequenceNumber lastServerLSN = LogSequenceNumber.INVALID_LSN;
  /**
   * Last receive LSN + payload size.
   */
  private LogSequenceNumber lastReceiveLSN = LogSequenceNumber.INVALID_LSN;
  private LogSequenceNumber lastAppliedLSN = LogSequenceNumber.INVALID_LSN;
  private LogSequenceNumber lastFlushedLSN = LogSequenceNumber.INVALID_LSN;

  /**
   * @param copyDual         bidirectional copy protocol
   * @param startLSN         the position in the WAL that we want to initiate replication from
   *                         usually the currentLSN returned by calling pg_current_wal_lsn()for v10
   *                         above or pg_current_xlog_location() depending on the version of the
   *                         server
   * @param updateIntervalMs the number of millisecond between status packets sent back to the
   *                         server.  A value of zero disables the periodic status updates
   *                         completely, although an update will still be sent when requested by the
   *                         server, to avoid timeout disconnect.
   * @param replicationType  LOGICAL or PHYSICAL
   */
  public V3PGReplicationStream(CopyDual copyDual, LogSequenceNumber startLSN, long updateIntervalMs,
      ReplicationType replicationType
  ) {
    this.copyDual = copyDual;
    this.updateInterval = updateIntervalMs;
    this.lastStatusUpdate = System.currentTimeMillis() - updateIntervalMs;
    this.lastReceiveLSN = startLSN;
    this.replicationType = replicationType;
  }

  @Override
  public ByteBuffer read() throws SQLException {
    checkClose();

    ByteBuffer payload = null;
    while (payload == null && copyDual.isActive()) {
      payload = readInternal(true);
    }

    return payload;
  }

  public ByteBuffer readPending() throws SQLException {
    checkClose();
    return readInternal(false);
  }

  @Override
  public LogSequenceNumber getLastReceiveLSN() {
    return lastReceiveLSN;
  }

  @Override
  public LogSequenceNumber getLastFlushedLSN() {
    return lastFlushedLSN;
  }

  @Override
  public LogSequenceNumber getLastAppliedLSN() {
    return lastAppliedLSN;
  }

  @Override
  public void setFlushedLSN(LogSequenceNumber flushed) {
    this.lastFlushedLSN = flushed;
  }

  @Override
  public void setAppliedLSN(LogSequenceNumber applied) {
    this.lastAppliedLSN = applied;
  }

  @Override
  public void forceUpdateStatus() throws SQLException {
    checkClose();
    updateStatusInternal(lastReceiveLSN, lastFlushedLSN, lastAppliedLSN, true);
  }

  @Override
  public boolean isClosed() {
    return closeFlag || !copyDual.isActive();
  }

  private ByteBuffer readInternal(boolean block) throws SQLException {
    boolean updateStatusRequired = false;
    while (copyDual.isActive()) {
      if (updateStatusRequired || isTimeUpdate()) {
        timeUpdateStatus();
      }

      ByteBuffer buffer = receiveNextData(block);

      if (buffer == null) {
        return null;
      }

      int code = buffer.get();

      switch (code) {

        case 'k': //KeepAlive message
          updateStatusRequired = processKeepAliveMessage(buffer);
          updateStatusRequired |= updateInterval == 0;
          break;

        case 'w': //XLogData
          return processXLogData(buffer);

        default:
          throw new PSQLException(
              GT.tr("Unexpected packet type during replication: {0}", Integer.toString(code)),
              PSQLState.PROTOCOL_VIOLATION
          );
      }
    }

    return null;
  }

  private ByteBuffer receiveNextData(boolean block) throws SQLException {
    try {
      byte[] message = copyDual.readFromCopy(block);
      if (message != null) {
        return ByteBuffer.wrap(message);
      } else {
        return null;
      }
    } catch (PSQLException e) { //todo maybe replace on thread sleep?
      if (e.getCause() instanceof SocketTimeoutException) {
        //signal for keep alive
        return null;
      }

      throw e;
    }
  }

  private boolean isTimeUpdate() {
    /* a value of 0 disables automatic updates */
    if ( updateInterval == 0 ) {
      return false;
    }
    long diff = System.currentTimeMillis() - lastStatusUpdate;
    return diff >= updateInterval;
  }

  private void timeUpdateStatus() throws SQLException {
    updateStatusInternal(lastReceiveLSN, lastFlushedLSN, lastAppliedLSN, false);
  }

  private void updateStatusInternal(
      LogSequenceNumber received, LogSequenceNumber flushed, LogSequenceNumber applied,
      boolean replyRequired)
      throws SQLException {
    byte[] reply = prepareUpdateStatus(received, flushed, applied, replyRequired);
    copyDual.writeToCopy(reply, 0, reply.length);
    copyDual.flushCopy();

    lastStatusUpdate = System.currentTimeMillis();
  }

  private byte[] prepareUpdateStatus(LogSequenceNumber received, LogSequenceNumber flushed,
      LogSequenceNumber applied, boolean replyRequired) {
    ByteBuffer byteBuffer = ByteBuffer.allocate(1 + 8 + 8 + 8 + 8 + 8 + 4 + 4 + 8 + 1 + 7);
    //mark byte as litter endian
    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);

    long now = System.currentTimeMillis();
    long systemClock = TimeUnit.MICROSECONDS.convert((now - POSTGRES_EPOCH_2000_01_01),
        TimeUnit.MICROSECONDS);

    if (LOGGER.isTraceEnabled()) {
      LOGGER.trace(" FE=> StandbyStatusUpdate(received: " + received.asString() + ", flushed: " + flushed.asString() + ", applied: " + applied.asString() + ", clock: " + new Date(now) +")");
    }

    byteBuffer.put((byte) 'r');
    byteBuffer.putLong(Long.MAX_VALUE);
    byteBuffer.putLong(received.asLong());
    byteBuffer.putLong(flushed.asLong());
    byteBuffer.putLong(Long.MAX_VALUE);
    byteBuffer.putLong(applied.asLong());
    byteBuffer.putInt(Integer.MAX_VALUE);
    byteBuffer.putInt(Integer.MAX_VALUE);
    byteBuffer.putLong(systemClock);
    if (replyRequired) {
      byteBuffer.put((byte) 1);
    } else {
      byteBuffer.put(received == LogSequenceNumber.INVALID_LSN ? (byte) 1 : (byte) 0);
    }
    byteBuffer.putInt(0);
    byteBuffer.put((byte) 1);
    byteBuffer.put((byte) 1);
    byteBuffer.put((byte) 1);

    lastStatusUpdate = now;
    return byteBuffer.array();
  }

  private boolean processKeepAliveMessage(ByteBuffer buffer) {
    //to little endian
    buffer.order(ByteOrder.LITTLE_ENDIAN);
    lastServerLSN = LogSequenceNumber.valueOf(buffer.getLong());
    if (lastServerLSN.asLong() > lastReceiveLSN.asLong()) {
      lastReceiveLSN = lastServerLSN;
    }
    //ignore useless content from backend
    int serverMode = buffer.getInt();
    int dbState = buffer.getInt();

    long lastServerClock = buffer.getLong();

    boolean replyRequired = buffer.get() != 0;

    if (LOGGER.isTraceEnabled()) {
      Date clockTime = new Date(
          TimeUnit.MILLISECONDS.convert(lastServerClock, TimeUnit.MICROSECONDS)
          + POSTGRES_EPOCH_2000_01_01);
      LOGGER.trace("  <=BE Keepalive(lastServerWal: " + lastServerLSN.asString() + ", clock: " + clockTime + " needReply: " + replyRequired + ")");
    }

    return replyRequired;
  }

  private ByteBuffer processXLogData(ByteBuffer buffer) {
    long startLsn = buffer.getLong();
    lastServerLSN = LogSequenceNumber.valueOf(buffer.getLong());
    long systemClock = buffer.getLong();

    switch (replicationType) {
      case LOGICAL:
        lastReceiveLSN = LogSequenceNumber.valueOf(startLsn);
        break;
      case PHYSICAL:
        int payloadSize = buffer.limit() - buffer.position();
        lastReceiveLSN = LogSequenceNumber.valueOf(startLsn + payloadSize);
        break;
    }

    if (LOGGER.isTraceEnabled()) {
      LOGGER.trace("  <=BE XLogData(currWal: " + lastReceiveLSN.asString() + ", lastServerWal: " + lastServerLSN.asString() + ", clock: " + systemClock + ")");
    }

    return buffer.slice();
  }

  private void checkClose() throws PSQLException {
    if (isClosed()) {
      throw new PSQLException(GT.tr("This replication stream has been closed."),
          PSQLState.CONNECTION_DOES_NOT_EXIST);
    }
  }

  public void close() throws SQLException {
    if (isClosed()) {
      return;
    }

    LOGGER.trace(" FE=> StopReplication");

    copyDual.endCopy();

    closeFlag = true;
  }
}
