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

import com.lark.oapi.okhttp.Call;
import com.lark.oapi.okhttp.Connection;
import com.lark.oapi.okhttp.Interceptor;
import com.lark.oapi.okhttp.Request;
import com.lark.oapi.okhttp.Response;
import com.lark.oapi.okhttp.internal.Util;
import com.lark.oapi.okhttp.internal.connection.Exchange;
import com.lark.oapi.okhttp.internal.connection.Transmitter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/**
 * A concrete interceptor chain that carries the entire interceptor chain: all application
 * interceptors, the OkHttp core, all network interceptors, and finally the network caller.
 *
 * <p>If the chain is for an application interceptor then {@link #connection} must be null.
 * Otherwise it is for a network interceptor and {@link #connection} must be non-null.
 */
public final class RealInterceptorChain implements Interceptor.Chain {

  private final List<Interceptor> interceptors;
  private final Transmitter transmitter;
  private final @Nullable
  Exchange exchange;
  private final int index;
  private final Request request;
  private final Call call;
  private final int connectTimeout;
  private final int readTimeout;
  private final int writeTimeout;
  private int calls;

  public RealInterceptorChain(List<Interceptor> interceptors, Transmitter transmitter,
      @Nullable Exchange exchange, int index, Request request, Call call,
      int connectTimeout, int readTimeout, int writeTimeout) {
    this.interceptors = interceptors;
    this.transmitter = transmitter;
    this.exchange = exchange;
    this.index = index;
    this.request = request;
    this.call = call;
    this.connectTimeout = connectTimeout;
    this.readTimeout = readTimeout;
    this.writeTimeout = writeTimeout;
  }

  @Override
  public @Nullable
  Connection connection() {
    return exchange != null ? exchange.connection() : null;
  }

  @Override
  public int connectTimeoutMillis() {
    return connectTimeout;
  }

  @Override
  public Interceptor.Chain withConnectTimeout(int timeout, TimeUnit unit) {
    int millis = Util.checkDuration("timeout", timeout, unit);
    return new RealInterceptorChain(interceptors, transmitter, exchange, index, request, call,
        millis, readTimeout, writeTimeout);
  }

  @Override
  public int readTimeoutMillis() {
    return readTimeout;
  }

  @Override
  public Interceptor.Chain withReadTimeout(int timeout, TimeUnit unit) {
    int millis = Util.checkDuration("timeout", timeout, unit);
    return new RealInterceptorChain(interceptors, transmitter, exchange, index, request, call,
        connectTimeout, millis, writeTimeout);
  }

  @Override
  public int writeTimeoutMillis() {
    return writeTimeout;
  }

  @Override
  public Interceptor.Chain withWriteTimeout(int timeout, TimeUnit unit) {
    int millis = Util.checkDuration("timeout", timeout, unit);
    return new RealInterceptorChain(interceptors, transmitter, exchange, index, request, call,
        connectTimeout, readTimeout, millis);
  }

  public Transmitter transmitter() {
    return transmitter;
  }

  public Exchange exchange() {
    if (exchange == null) {
      throw new IllegalStateException();
    }
    return exchange;
  }

  @Override
  public Call call() {
    return call;
  }

  @Override
  public Request request() {
    return request;
  }

  @Override
  public Response proceed(Request request) throws IOException {
    return proceed(request, transmitter, exchange);
  }

  public Response proceed(Request request, Transmitter transmitter, @Nullable Exchange exchange)
      throws IOException {
    if (index >= interceptors.size()) {
      throw new AssertionError();
    }

    calls++;

    // If we already have a stream, confirm that the incoming request will use it.
    if (this.exchange != null && !this.exchange.connection().supportsUrl(request.url())) {
      throw new IllegalStateException("network interceptor " + interceptors.get(index - 1)
          + " must retain the same host and port");
    }

    // If we already have a stream, confirm that this is the only call to chain.proceed().
    if (this.exchange != null && calls > 1) {
      throw new IllegalStateException("network interceptor " + interceptors.get(index - 1)
          + " must call proceed() exactly once");
    }

    // Call the next interceptor in the chain.
    RealInterceptorChain next = new RealInterceptorChain(interceptors, transmitter, exchange,
        index + 1, request, call, connectTimeout, readTimeout, writeTimeout);
    Interceptor interceptor = interceptors.get(index);
    Response response = interceptor.intercept(next);

    // Confirm that the next interceptor made its required call to chain.proceed().
    if (exchange != null && index + 1 < interceptors.size() && next.calls != 1) {
      throw new IllegalStateException("network interceptor " + interceptor
          + " must call proceed() exactly once");
    }

    // Confirm that the intercepted response isn't null.
    if (response == null) {
      throw new NullPointerException("interceptor " + interceptor + " returned null");
    }

    if (response.body() == null) {
      throw new IllegalStateException(
          "interceptor " + interceptor + " returned a response with no body");
    }

    return response;
  }
}
