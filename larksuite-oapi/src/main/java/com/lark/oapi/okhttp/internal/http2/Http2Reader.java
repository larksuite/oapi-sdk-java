/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.lark.oapi.okhttp.internal.http2;

import static com.lark.oapi.okhttp.internal.Util.format;
import static com.lark.oapi.okio.ByteString.EMPTY;
import static java.util.logging.Level.FINE;

import com.lark.oapi.okio.Buffer;
import com.lark.oapi.okio.BufferedSource;
import com.lark.oapi.okio.ByteString;
import com.lark.oapi.okio.Source;
import com.lark.oapi.okio.Timeout;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Reads HTTP/2 transport frames.
 *
 * <p>This implementation assumes we do not send an increased {@link Settings#getMaxFrameSize frame
 * size setting} to the peer. Hence, we expect all frames to have a max length of {@link
 * Http2#INITIAL_MAX_FRAME_SIZE}.
 */
final class Http2Reader implements Closeable {

  static final Logger logger = Logger.getLogger(Http2.class.getName());
  // Visible for testing.
  final Hpack.Reader hpackReader;
  private final BufferedSource source;
  private final ContinuationSource continuation;
  private final boolean client;

  /**
   * Creates a frame reader with max header table size of 4096.
   */
  Http2Reader(BufferedSource source, boolean client) {
    this.source = source;
    this.client = client;
    this.continuation = new ContinuationSource(this.source);
    this.hpackReader = new Hpack.Reader(4096, continuation);
  }

  static int readMedium(BufferedSource source) throws IOException {
    return (source.readByte() & 0xff) << 16
        | (source.readByte() & 0xff) << 8
        | (source.readByte() & 0xff);
  }

  static int lengthWithoutPadding(int length, byte flags, short padding)
      throws IOException {
    if ((flags & Http2.FLAG_PADDED) != 0) {
      length--; // Account for reading the padding length.
    }
    if (padding > length) {
      throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", padding, length);
    }
    return (short) (length - padding);
  }

  public void readConnectionPreface(Handler handler) throws IOException {
    if (client) {
      // The client reads the initial SETTINGS frame.
      if (!nextFrame(true, handler)) {
        throw Http2.ioException("Required SETTINGS preface not received");
      }
    } else {
      // The server reads the CONNECTION_PREFACE byte string.
      ByteString connectionPreface = source.readByteString(Http2.CONNECTION_PREFACE.size());
      if (logger.isLoggable(FINE)) {
        logger.fine(format("<< CONNECTION %s", connectionPreface.hex()));
      }
      if (!Http2.CONNECTION_PREFACE.equals(connectionPreface)) {
        throw Http2.ioException("Expected a connection header but was %s",
            connectionPreface.utf8());
      }
    }
  }

  public boolean nextFrame(boolean requireSettings, Handler handler) throws IOException {
    try {
      source.require(9); // Frame header size
    } catch (EOFException e) {
      return false; // This might be a normal socket close.
    }

    //  0                   1                   2                   3
    //  0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
    // +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
    // |                 Length (24)                   |
    // +---------------+---------------+---------------+
    // |   Type (8)    |   Flags (8)   |
    // +-+-+-----------+---------------+-------------------------------+
    // |R|                 Stream Identifier (31)                      |
    // +=+=============================================================+
    // |                   Frame Payload (0...)                      ...
    // +---------------------------------------------------------------+
    int length = readMedium(source);
    if (length < 0 || length > Http2.INITIAL_MAX_FRAME_SIZE) {
      throw Http2.ioException("FRAME_SIZE_ERROR: %s", length);
    }
    byte type = (byte) (source.readByte() & 0xff);
    if (requireSettings && type != Http2.TYPE_SETTINGS) {
      throw Http2.ioException("Expected a SETTINGS frame but was %s", type);
    }
    byte flags = (byte) (source.readByte() & 0xff);
    int streamId = (source.readInt() & 0x7fffffff); // Ignore reserved bit.
    if (logger.isLoggable(FINE)) {
      logger.fine(Http2.frameLog(true, streamId, length, type, flags));
    }

    switch (type) {
      case Http2.TYPE_DATA:
        readData(handler, length, flags, streamId);
        break;

      case Http2.TYPE_HEADERS:
        readHeaders(handler, length, flags, streamId);
        break;

      case Http2.TYPE_PRIORITY:
        readPriority(handler, length, flags, streamId);
        break;

      case Http2.TYPE_RST_STREAM:
        readRstStream(handler, length, flags, streamId);
        break;

      case Http2.TYPE_SETTINGS:
        readSettings(handler, length, flags, streamId);
        break;

      case Http2.TYPE_PUSH_PROMISE:
        readPushPromise(handler, length, flags, streamId);
        break;

      case Http2.TYPE_PING:
        readPing(handler, length, flags, streamId);
        break;

      case Http2.TYPE_GOAWAY:
        readGoAway(handler, length, flags, streamId);
        break;

      case Http2.TYPE_WINDOW_UPDATE:
        readWindowUpdate(handler, length, flags, streamId);
        break;

      default:
        // Implementations MUST discard frames that have unknown or unsupported types.
        source.skip(length);
    }
    return true;
  }

  private void readHeaders(Handler handler, int length, byte flags, int streamId)
      throws IOException {
    if (streamId == 0) {
      throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
    }

    boolean endStream = (flags & Http2.FLAG_END_STREAM) != 0;

    short padding = (flags & Http2.FLAG_PADDED) != 0 ? (short) (source.readByte() & 0xff) : 0;

    if ((flags & Http2.FLAG_PRIORITY) != 0) {
      readPriority(handler, streamId);
      length -= 5; // account for above read.
    }

    length = lengthWithoutPadding(length, flags, padding);

    List<Header> headerBlock = readHeaderBlock(length, padding, flags, streamId);

    handler.headers(endStream, streamId, -1, headerBlock);
  }

  private List<Header> readHeaderBlock(int length, short padding, byte flags, int streamId)
      throws IOException {
    continuation.length = continuation.left = length;
    continuation.padding = padding;
    continuation.flags = flags;
    continuation.streamId = streamId;

    // TODO: Concat multi-value headers with 0x0, except COOKIE, which uses 0x3B, 0x20.
    // http://tools.ietf.org/html/draft-ietf-httpbis-http2-17#section-8.1.2.5
    hpackReader.readHeaders();
    return hpackReader.getAndResetHeaderList();
  }

  private void readData(Handler handler, int length, byte flags, int streamId)
      throws IOException {
    if (streamId == 0) {
      throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
    }

    // TODO: checkState open or half-closed (local) or raise STREAM_CLOSED
    boolean inFinished = (flags & Http2.FLAG_END_STREAM) != 0;
    boolean gzipped = (flags & Http2.FLAG_COMPRESSED) != 0;
    if (gzipped) {
      throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
    }

    short padding = (flags & Http2.FLAG_PADDED) != 0 ? (short) (source.readByte() & 0xff) : 0;
    length = lengthWithoutPadding(length, flags, padding);

    handler.data(inFinished, streamId, source, length);
    source.skip(padding);
  }

  private void readPriority(Handler handler, int length, byte flags, int streamId)
      throws IOException {
    if (length != 5) {
      throw Http2.ioException("TYPE_PRIORITY length: %d != 5", length);
    }
    if (streamId == 0) {
      throw Http2.ioException("TYPE_PRIORITY streamId == 0");
    }
    readPriority(handler, streamId);
  }

  private void readPriority(Handler handler, int streamId) throws IOException {
    int w1 = source.readInt();
    boolean exclusive = (w1 & 0x80000000) != 0;
    int streamDependency = (w1 & 0x7fffffff);
    int weight = (source.readByte() & 0xff) + 1;
    handler.priority(streamId, streamDependency, weight, exclusive);
  }

  private void readRstStream(Handler handler, int length, byte flags, int streamId)
      throws IOException {
    if (length != 4) {
      throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", length);
    }
    if (streamId == 0) {
      throw Http2.ioException("TYPE_RST_STREAM streamId == 0");
    }
    int errorCodeInt = source.readInt();
    ErrorCode errorCode = ErrorCode.fromHttp2(errorCodeInt);
    if (errorCode == null) {
      throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", errorCodeInt);
    }
    handler.rstStream(streamId, errorCode);
  }

  private void readSettings(Handler handler, int length, byte flags, int streamId)
      throws IOException {
    if (streamId != 0) {
      throw Http2.ioException("TYPE_SETTINGS streamId != 0");
    }
    if ((flags & Http2.FLAG_ACK) != 0) {
      if (length != 0) {
        throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!");
      }
      handler.ackSettings();
      return;
    }

    if (length % 6 != 0) {
      throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", length);
    }
    Settings settings = new Settings();
    for (int i = 0; i < length; i += 6) {
      int id = source.readShort() & 0xFFFF;
      int value = source.readInt();

      switch (id) {
        case 1: // SETTINGS_HEADER_TABLE_SIZE
          break;
        case 2: // SETTINGS_ENABLE_PUSH
          if (value != 0 && value != 1) {
            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
          }
          break;
        case 3: // SETTINGS_MAX_CONCURRENT_STREAMS
          id = 4; // Renumbered in draft 10.
          break;
        case 4: // SETTINGS_INITIAL_WINDOW_SIZE
          id = 7; // Renumbered in draft 10.
          if (value < 0) {
            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
          }
          break;
        case 5: // SETTINGS_MAX_FRAME_SIZE
          if (value < Http2.INITIAL_MAX_FRAME_SIZE || value > 16777215) {
            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", value);
          }
          break;
        case 6: // SETTINGS_MAX_HEADER_LIST_SIZE
          break; // Advisory only, so ignored.
        default:
          break; // Must ignore setting with unknown id.
      }
      settings.set(id, value);
    }
    handler.settings(false, settings);
  }

  private void readPushPromise(Handler handler, int length, byte flags, int streamId)
      throws IOException {
    if (streamId == 0) {
      throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }
    short padding = (flags & Http2.FLAG_PADDED) != 0 ? (short) (source.readByte() & 0xff) : 0;
    int promisedStreamId = source.readInt() & 0x7fffffff;
    length -= 4; // account for above read.
    length = lengthWithoutPadding(length, flags, padding);
    List<Header> headerBlock = readHeaderBlock(length, padding, flags, streamId);
    handler.pushPromise(streamId, promisedStreamId, headerBlock);
  }

  private void readPing(Handler handler, int length, byte flags, int streamId)
      throws IOException {
    if (length != 8) {
      throw Http2.ioException("TYPE_PING length != 8: %s", length);
    }
    if (streamId != 0) {
      throw Http2.ioException("TYPE_PING streamId != 0");
    }
    int payload1 = source.readInt();
    int payload2 = source.readInt();
    boolean ack = (flags & Http2.FLAG_ACK) != 0;
    handler.ping(ack, payload1, payload2);
  }

  private void readGoAway(Handler handler, int length, byte flags, int streamId)
      throws IOException {
    if (length < 8) {
      throw Http2.ioException("TYPE_GOAWAY length < 8: %s", length);
    }
    if (streamId != 0) {
      throw Http2.ioException("TYPE_GOAWAY streamId != 0");
    }
    int lastStreamId = source.readInt();
    int errorCodeInt = source.readInt();
    int opaqueDataLength = length - 8;
    ErrorCode errorCode = ErrorCode.fromHttp2(errorCodeInt);
    if (errorCode == null) {
      throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", errorCodeInt);
    }
    ByteString debugData = EMPTY;
    if (opaqueDataLength > 0) { // Must read debug data in order to not corrupt the connection.
      debugData = source.readByteString(opaqueDataLength);
    }
    handler.goAway(lastStreamId, errorCode, debugData);
  }

  private void readWindowUpdate(Handler handler, int length, byte flags, int streamId)
      throws IOException {
    if (length != 4) {
      throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", length);
    }
    long increment = (source.readInt() & 0x7fffffffL);
    if (increment == 0) {
      throw Http2.ioException("windowSizeIncrement was 0", increment);
    }
    handler.windowUpdate(streamId, increment);
  }

  @Override
  public void close() throws IOException {
    source.close();
  }

  interface Handler {

    void data(boolean inFinished, int streamId, BufferedSource source, int length)
        throws IOException;

    /**
     * Create or update incoming headers, creating the corresponding streams if necessary. Frames
     * that trigger this are HEADERS and PUSH_PROMISE.
     *
     * @param inFinished         true if the sender will not send further frames.
     * @param streamId           the stream owning these headers.
     * @param associatedStreamId the stream that triggered the sender to create this stream.
     */
    void headers(boolean inFinished, int streamId, int associatedStreamId,
        List<Header> headerBlock);

    void rstStream(int streamId, ErrorCode errorCode);

    void settings(boolean clearPrevious, Settings settings);

    /**
     * HTTP/2 only.
     */
    void ackSettings();

    /**
     * Read a connection-level ping from the peer. {@code ack} indicates this is a reply. The data
     * in {@code payload1} and {@code payload2} opaque binary, and there are no rules on the
     * content.
     */
    void ping(boolean ack, int payload1, int payload2);

    /**
     * The peer tells us to stop creating streams.  It is safe to replay streams with {@code ID >
     * lastGoodStreamId} on a new connection.  In- flight streams with {@code ID <=
     * lastGoodStreamId} can only be replayed on a new connection if they are idempotent.
     *
     * @param lastGoodStreamId the last stream ID the peer processed before sending this message. If
     *                         {@code lastGoodStreamId} is zero, the peer processed no frames.
     * @param errorCode        reason for closing the connection.
     * @param debugData        only valid for HTTP/2; opaque debug data to send.
     */
    void goAway(int lastGoodStreamId, ErrorCode errorCode, ByteString debugData);

    /**
     * Notifies that an additional {@code windowSizeIncrement} bytes can be sent on {@code
     * streamId}, or the connection if {@code streamId} is zero.
     */
    void windowUpdate(int streamId, long windowSizeIncrement);

    /**
     * Called when reading a headers or priority frame. This may be used to change the stream's
     * weight from the default (16) to a new value.
     *
     * @param streamId         stream which has a priority change.
     * @param streamDependency the stream ID this stream is dependent on.
     * @param weight           relative proportion of priority in [1..256].
     * @param exclusive        inserts this stream ID as the sole child of {@code
     *                         streamDependency}.
     */
    void priority(int streamId, int streamDependency, int weight, boolean exclusive);

    /**
     * HTTP/2 only. Receive a push promise header block. <p> A push promise contains all the headers
     * that pertain to a server-initiated request, and a {@code promisedStreamId} to which response
     * frames will be delivered. Push promise frames are sent as a part of the response to {@code
     * streamId}.
     *
     * @param streamId         client-initiated stream ID.  Must be an odd number.
     * @param promisedStreamId server-initiated stream ID.  Must be an even number.
     * @param requestHeaders   minimally includes {@code :method}, {@code :scheme}, {@code
     *                         :authority}, and (@code :path}.
     */
    void pushPromise(int streamId, int promisedStreamId, List<Header> requestHeaders)
        throws IOException;

    /**
     * HTTP/2 only. Expresses that resources for the connection or a client- initiated stream are
     * available from a different network location or protocol configuration.
     *
     * <p>See <a href="http://tools.ietf.org/html/draft-ietf-httpbis-alt-svc-01">alt-svc</a>
     *
     * @param streamId when a client-initiated stream ID (odd number), the origin of this alternate
     *                 service is the origin of the stream. When zero, the origin is specified in
     *                 the {@code origin} parameter.
     * @param origin   when present, the <a href="http://tools.ietf.org/html/rfc6454">origin</a> is
     *                 typically represented as a combination of scheme, host and port. When empty,
     *                 the origin is that of the {@code streamId}.
     * @param protocol an ALPN protocol, such as {@code h2}.
     * @param host     an IP address or hostname.
     * @param port     the IP port associated with the service.
     * @param maxAge   time in seconds that this alternative is considered fresh.
     */
    void alternateService(int streamId, String origin, ByteString protocol, String host, int port,
        long maxAge);
  }

  /**
   * Decompression of the header block occurs above the framing layer. This class lazily reads
   * continuation frames as they are needed by {@link Hpack.Reader#readHeaders()}.
   */
  static final class ContinuationSource implements Source {

    private final BufferedSource source;

    int length;
    byte flags;
    int streamId;

    int left;
    short padding;

    ContinuationSource(BufferedSource source) {
      this.source = source;
    }

    @Override
    public long read(Buffer sink, long byteCount) throws IOException {
      while (left == 0) {
        source.skip(padding);
        padding = 0;
        if ((flags & Http2.FLAG_END_HEADERS) != 0) {
          return -1;
        }
        readContinuationHeader();
        // TODO: test case for empty continuation header?
      }

      long read = source.read(sink, Math.min(byteCount, left));
      if (read == -1) {
        return -1;
      }
      left -= read;
      return read;
    }

    @Override
    public Timeout timeout() {
      return source.timeout();
    }

    @Override
    public void close() throws IOException {
    }

    private void readContinuationHeader() throws IOException {
      int previousStreamId = streamId;

      length = left = readMedium(source);
      byte type = (byte) (source.readByte() & 0xff);
      flags = (byte) (source.readByte() & 0xff);
      if (logger.isLoggable(FINE)) {
        logger.fine(Http2.frameLog(true, streamId, length, type, flags));
      }
      streamId = (source.readInt() & 0x7fffffff);
      if (type != Http2.TYPE_CONTINUATION) {
        throw Http2.ioException("%s != TYPE_CONTINUATION", type);
      }
      if (streamId != previousStreamId) {
        throw Http2.ioException("TYPE_CONTINUATION streamId changed");
      }
    }
  }
}
