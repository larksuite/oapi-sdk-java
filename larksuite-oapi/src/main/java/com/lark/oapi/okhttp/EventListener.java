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
package com.lark.oapi.okhttp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Listener for metrics events. Extend this class to monitor the quantity, size, and duration of
 * your application's HTTP calls.
 *
 * <p>All start/connect/acquire events will eventually receive a matching end/release event,
 * either successful (non-null parameters), or failed (non-null throwable).  The first common
 * parameters of each event pair are used to link the event in case of concurrent or repeated events
 * e.g. dnsStart(call, domainName) -&gt; dnsEnd(call, domainName, inetAddressList).
 *
 * <p>Nesting is as follows
 * <ul>
 *   <li>call -&gt; (dns -&gt; connect -&gt; secure connect)* -&gt; request events</li>
 *   <li>call -&gt; (connection acquire/release)*</li>
 * </ul>
 *
 * <p>Request events are ordered:
 * requestHeaders -&gt; requestBody -&gt; responseHeaders -&gt; responseBody
 *
 * <p>Since connections may be reused, the dns and connect events may not be present for a call,
 * or may be repeated in case of failure retries, even concurrently in case of happy eyeballs type
 * scenarios. A redirect cross domain, or to use https may cause additional connection and request
 * events.
 *
 * <p>All event methods must execute fast, without external locking, cannot throw exceptions,
 * attempt to mutate the event parameters, or be re-entrant back into the client.
 * Any IO - writing to files or network should be done asynchronously.
 */
public abstract class EventListener {

  public static final EventListener NONE = new EventListener() {
  };

  static EventListener.Factory factory(EventListener listener) {
    return call -> listener;
  }

  /**
   * Invoked as soon as a call is enqueued or executed by a client. In case of thread or stream
   * limits, this call may be executed well before processing the request is able to begin.
   *
   * <p>This will be invoked only once for a single {@link Call}. Retries of different routes
   * or redirects will be handled within the boundaries of a single callStart and {@link
   * #callEnd}/{@link #callFailed} pair.
   */
  public void callStart(Call call) {
  }

  /**
   * Invoked just prior to a DNS lookup. See {@link Dns#lookup(String)}.
   *
   * <p>This can be invoked more than 1 time for a single {@link Call}. For example, if the
   * response to the {@link Call#request()} is a redirect to a different host.
   *
   * <p>If the {@link Call} is able to reuse an existing pooled connection, this method will not be
   * invoked. See {@link ConnectionPool}.
   */
  public void dnsStart(Call call, String domainName) {
  }

  /**
   * Invoked immediately after a DNS lookup.
   *
   * <p>This method is invoked after {@link #dnsStart}.
   */
  public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
  }

  /**
   * Invoked just prior to initiating a socket connection.
   *
   * <p>This method will be invoked if no existing connection in the {@link ConnectionPool} can be
   * reused.
   *
   * <p>This can be invoked more than 1 time for a single {@link Call}. For example, if the
   * response to the {@link Call#request()} is a redirect to a different address, or a connection is
   * retried.
   */
  public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
  }

  /**
   * Invoked just prior to initiating a TLS connection.
   *
   * <p>This method is invoked if the following conditions are met:
   * <ul>
   * <li>The {@link Call#request()} requires TLS.</li>
   * <li>No existing connection from the {@link ConnectionPool} can be reused.</li>
   * </ul>
   *
   * <p>This can be invoked more than 1 time for a single {@link Call}. For example, if the response
   * to the {@link Call#request()} is a redirect to a different address, or a connection is retried.
   */
  public void secureConnectStart(Call call) {
  }

  /**
   * Invoked immediately after a TLS connection was attempted.
   *
   * <p>This method is invoked after {@link #secureConnectStart}.
   */
  public void secureConnectEnd(Call call, @Nullable Handshake handshake) {
  }

  /**
   * Invoked immediately after a socket connection was attempted.
   *
   * <p>If the {@code call} uses HTTPS, this will be invoked after
   * {@link #secureConnectEnd(Call, Handshake)}, otherwise it will invoked after {@link
   * #connectStart(Call, InetSocketAddress, Proxy)}.
   */
  public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy,
      @Nullable Protocol protocol) {
  }

  /**
   * Invoked when a connection attempt fails. This failure is not terminal if further routes are
   * available and failure recovery is enabled.
   *
   * <p>If the {@code call} uses HTTPS, this will be invoked after {@link #secureConnectEnd(Call,
   * Handshake)}, otherwise it will invoked after {@link #connectStart(Call, InetSocketAddress,
   * Proxy)}.
   */
  public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy,
      @Nullable Protocol protocol, IOException ioe) {
  }

  /**
   * Invoked after a connection has been acquired for the {@code call}.
   *
   * <p>This can be invoked more than 1 time for a single {@link Call}. For example, if the
   * response to the {@link Call#request()} is a redirect to a different address.
   */
  public void connectionAcquired(Call call, Connection connection) {
  }

  /**
   * Invoked after a connection has been released for the {@code call}.
   *
   * <p>This method is always invoked after {@link #connectionAcquired(Call, Connection)}.
   *
   * <p>This can be invoked more than 1 time for a single {@link Call}. For example, if the
   * response to the {@link Call#request()} is a redirect to a different address.
   */
  public void connectionReleased(Call call, Connection connection) {
  }

  /**
   * Invoked just prior to sending request headers.
   *
   * <p>The connection is implicit, and will generally relate to the last
   * {@link #connectionAcquired(Call, Connection)} event.
   *
   * <p>This can be invoked more than 1 time for a single {@link Call}. For example, if the
   * response to the {@link Call#request()} is a redirect to a different address.
   */
  public void requestHeadersStart(Call call) {
  }

  /**
   * Invoked immediately after sending request headers.
   *
   * <p>This method is always invoked after {@link #requestHeadersStart(Call)}.
   *
   * @param request the request sent over the network. It is an error to access the body of this
   *                request.
   */
  public void requestHeadersEnd(Call call, Request request) {
  }

  /**
   * Invoked just prior to sending a request body.  Will only be invoked for request allowing and
   * having a request body to send.
   *
   * <p>The connection is implicit, and will generally relate to the last
   * {@link #connectionAcquired(Call, Connection)} event.
   *
   * <p>This can be invoked more than 1 time for a single {@link Call}. For example, if the
   * response to the {@link Call#request()} is a redirect to a different address.
   */
  public void requestBodyStart(Call call) {
  }

  /**
   * Invoked immediately after sending a request body.
   *
   * <p>This method is always invoked after {@link #requestBodyStart(Call)}.
   */
  public void requestBodyEnd(Call call, long byteCount) {
  }

  /**
   * Invoked when a request fails to be written.
   *
   * <p>This method is invoked after {@link #requestHeadersStart} or {@link #requestBodyStart}.
   * Note that request failures do not necessarily fail the entire call.
   */
  public void requestFailed(Call call, IOException ioe) {
  }

  /**
   * Invoked just prior to receiving response headers.
   *
   * <p>The connection is implicit, and will generally relate to the last
   * {@link #connectionAcquired(Call, Connection)} event.
   *
   * <p>This can be invoked more than 1 time for a single {@link Call}. For example, if the
   * response to the {@link Call#request()} is a redirect to a different address.
   */
  public void responseHeadersStart(Call call) {
  }

  /**
   * Invoked immediately after receiving response headers.
   *
   * <p>This method is always invoked after {@link #responseHeadersStart}.
   *
   * @param response the response received over the network. It is an error to access the body of
   *                 this response.
   */
  public void responseHeadersEnd(Call call, Response response) {
  }

  /**
   * Invoked just prior to receiving the response body.
   *
   * <p>The connection is implicit, and will generally relate to the last
   * {@link #connectionAcquired(Call, Connection)} event.
   *
   * <p>This will usually be invoked only 1 time for a single {@link Call},
   * exceptions are a limited set of cases including failure recovery.
   */
  public void responseBodyStart(Call call) {
  }

  /**
   * Invoked immediately after receiving a response body and completing reading it.
   *
   * <p>Will only be invoked for requests having a response body e.g. won't be invoked for a
   * websocket upgrade.
   *
   * <p>This method is always invoked after {@link #requestBodyStart(Call)}.
   */
  public void responseBodyEnd(Call call, long byteCount) {
  }

  /**
   * Invoked when a response fails to be read.
   *
   * <p>This method is invoked after {@link #responseHeadersStart} or {@link #responseBodyStart}.
   * Note that response failures do not necessarily fail the entire call.
   */
  public void responseFailed(Call call, IOException ioe) {
  }

  /**
   * Invoked immediately after a call has completely ended.  This includes delayed consumption of
   * response body by the caller.
   *
   * <p>This method is always invoked after {@link #callStart(Call)}.
   */
  public void callEnd(Call call) {
  }

  /**
   * Invoked when a call fails permanently.
   *
   * <p>This method is always invoked after {@link #callStart(Call)}.
   */
  public void callFailed(Call call, IOException ioe) {
  }

  public interface Factory {

    /**
     * Creates an instance of the {@link EventListener} for a particular {@link Call}. The returned
     * {@link EventListener} instance will be used during the lifecycle of the {@code call}.
     *
     * <p>This method is invoked after the {@code call} is created. See
     * {@link OkHttpClient#newCall(Request)}.
     *
     * <p><strong>It is an error for implementations to issue any mutating operations on the
     * {@code call} instance from this method.</strong>
     */
    EventListener create(Call call);
  }
}
