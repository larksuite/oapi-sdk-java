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
import javax.annotation.Nullable;

/**
 * Performs either <strong>preemptive</strong> authentication before connecting to a proxy server,
 * or <strong>reactive</strong> authentication after receiving a challenge from either an origin web
 * server or proxy server.
 *
 * <h3>Preemptive Authentication</h3>
 *
 * <p>To make HTTPS calls using an HTTP proxy server OkHttp must first negotiate a connection with
 * the proxy. This proxy connection is called a "TLS Tunnel" and is specified by <a
 * href="https://tools.ietf.org/html/rfc2817">RFC 2817</a>. The HTTP CONNECT request that creates
 * this tunnel connection is special: it does not participate in any {@linkplain Interceptor
 * interceptors} or {@linkplain EventListener event listeners}. It doesn't include the motivating
 * request's HTTP headers or even its full URL; only the target server's hostname is sent to the
 * proxy.
 *
 * <p>Prior to sending any CONNECT request OkHttp always calls the proxy authenticator so that it
 * may prepare preemptive authentication. OkHttp will call {@link #authenticate} with a fake {@code
 * HTTP/1.1 407 Proxy Authentication Required} response that has a {@code Proxy-Authenticate:
 * OkHttp-Preemptive} challenge. The proxy authenticator may return either either an authenticated
 * request, or null to connect without authentication.
 * <pre>   {@code
 *    for (Challenge challenge : response.challenges()) {
 *      // If this is preemptive auth, use a preemptive credential.
 *      if (challenge.scheme().equalsIgnoreCase("OkHttp-Preemptive")) {
 *        return response.request().newBuilder()
 *            .header("Proxy-Authorization", "secret")
 *            .build();
 *      }
 *    }
 *
 *    return null; // Didn't find a preemptive auth scheme.
 * }</pre>
 *
 * <h3>Reactive Authentication</h3>
 *
 * <p>Implementations authenticate by returning a follow-up request that includes an authorization
 * header, or they may decline the challenge by returning null. In this case the unauthenticated
 * response will be returned to the caller that triggered it.
 *
 * <p>Implementations should check if the initial request already included an attempt to
 * authenticate. If so it is likely that further attempts will not be useful and the authenticator
 * should give up.
 *
 * <p>When reactive authentication is requested by an origin web server, the response code is 401
 * and the implementation should respond with a new request that sets the "Authorization" header.
 * <pre>   {@code
 *
 *    if (response.request().header("Authorization") != null) {
 *      return null; // Give up, we've already failed to authenticate.
 *    }
 *
 *    String credential = Credentials.basic(...)
 *    return response.request().newBuilder()
 *        .header("Authorization", credential)
 *        .build();
 * }</pre>
 *
 * <p>When reactive authentication is requested by a proxy server, the response code is 407 and the
 * implementation should respond with a new request that sets the "Proxy-Authorization" header.
 * <pre>   {@code
 *
 *    if (response.request().header("Proxy-Authorization") != null) {
 *      return null; // Give up, we've already failed to authenticate.
 *    }
 *
 *    String credential = Credentials.basic(...)
 *    return response.request().newBuilder()
 *        .header("Proxy-Authorization", credential)
 *        .build();
 * }</pre>
 *
 * <p>The proxy authenticator may implement preemptive authentication, reactive authentication, or
 * both.
 *
 * <p>Applications may configure OkHttp with an authenticator for origin servers, or proxy servers,
 * or both.
 */
public interface Authenticator {

  /**
   * An authenticator that knows no credentials and makes no attempt to authenticate.
   */
  Authenticator NONE = (route, response) -> null;

  /**
   * Returns a request that includes a credential to satisfy an authentication challenge in {@code
   * response}. Returns null if the challenge cannot be satisfied.
   *
   * <p>The route is best effort, it currently may not always be provided even when logically
   * available. It may also not be provided when an authenticator is re-used manually in an
   * application interceptor, such as when implementing client-specific retries.
   */
  @Nullable
  Request authenticate(@Nullable Route route, Response response) throws IOException;
}
