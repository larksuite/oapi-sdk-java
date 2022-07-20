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
package com.lark.oapi.okhttp.internal.http;

import com.lark.oapi.okhttp.Headers;
import com.lark.oapi.okhttp.Request;
import com.lark.oapi.okhttp.Response;
import com.lark.oapi.okhttp.internal.connection.RealConnection;
import com.lark.oapi.okio.Sink;
import com.lark.oapi.okio.Source;
import java.io.IOException;
import javax.annotation.Nullable;

/**
 * Encodes HTTP requests and decodes HTTP responses.
 */
public interface ExchangeCodec {

  /**
   * The timeout to use while discarding a stream of input data. Since this is used for connection
   * reuse, this timeout should be significantly less than the time it takes to establish a new
   * connection.
   */
  int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

  /**
   * Returns the connection that carries this codec.
   */
  RealConnection connection();

  /**
   * Returns an output stream where the request body can be streamed.
   */
  Sink createRequestBody(Request request, long contentLength) throws IOException;

  /**
   * This should update the HTTP engine's sentRequestMillis field.
   */
  void writeRequestHeaders(Request request) throws IOException;

  /**
   * Flush the request to the underlying socket.
   */
  void flushRequest() throws IOException;

  /**
   * Flush the request to the underlying socket and signal no more bytes will be transmitted.
   */
  void finishRequest() throws IOException;

  /**
   * Parses bytes of a response header from an HTTP transport.
   *
   * @param expectContinue true to return null if this is an intermediate response with a "100"
   *                       response code. Otherwise this method never returns null.
   */
  @Nullable
  Response.Builder readResponseHeaders(boolean expectContinue) throws IOException;

  long reportedContentLength(Response response) throws IOException;

  Source openResponseBodySource(Response response) throws IOException;

  /**
   * Returns the trailers after the HTTP response. May be empty.
   */
  Headers trailers() throws IOException;

  /**
   * Cancel this stream. Resources held by this stream will be cleaned up, though not synchronously.
   * That may happen later by the connection pool thread.
   */
  void cancel();
}
