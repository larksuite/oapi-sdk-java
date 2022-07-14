/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
