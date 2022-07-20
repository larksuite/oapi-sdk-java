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

/**
 * Protocols that OkHttp implements for <a href="http://tools.ietf.org/html/draft-ietf-tls-applayerprotoneg">ALPN</a>
 * selection.
 *
 * <h3>Protocol vs Scheme</h3> Despite its name, {@link java.net.URL#getProtocol()} returns the
 * {@linkplain java.net.URI#getScheme() scheme} (http, https, etc.) of the URL, not the protocol
 * (http/1.1, spdy/3.1, etc.). OkHttp uses the word <i>protocol</i> to identify how HTTP messages
 * are framed.
 */
public enum Protocol {
  /**
   * An obsolete plaintext framing that does not use persistent sockets by default.
   */
  HTTP_1_0("http/1.0"),

  /**
   * A plaintext framing that includes persistent connections.
   *
   * <p>This version of OkHttp implements <a href="https://tools.ietf.org/html/rfc7230">RFC
   * 7230</a>, and tracks revisions to that spec.
   */
  HTTP_1_1("http/1.1"),

  /**
   * Chromium's binary-framed protocol that includes header compression, multiplexing multiple
   * requests on the same socket, and server-push. HTTP/1.1 semantics are layered on SPDY/3.
   *
   * <p>Current versions of OkHttp do not support this protocol.
   *
   * @deprecated OkHttp has dropped support for SPDY. Prefer {@link #HTTP_2}.
   */
  SPDY_3("spdy/3.1"),

  /**
   * The IETF's binary-framed protocol that includes header compression, multiplexing multiple
   * requests on the same socket, and server-push. HTTP/1.1 semantics are layered on HTTP/2.
   *
   * <p>HTTP/2 requires deployments of HTTP/2 that use TLS 1.2 support {@linkplain
   * CipherSuite#TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256} , present in Java 8+ and Android 5+. Servers
   * that enforce this may send an exception message including the string {@code
   * INADEQUATE_SECURITY}.
   */
  HTTP_2("h2"),

  /**
   * Cleartext HTTP/2 with no "upgrade" round trip. This option requires the client to have prior
   * knowledge that the server supports cleartext HTTP/2.
   *
   * @see <a href="https://tools.ietf.org/html/rfc7540#section-3.4">Starting HTTP/2 with Prior
   * Knowledge</a>
   */
  H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),

  /**
   * QUIC (Quick UDP Internet Connection) is a new multiplexed and secure transport atop UDP,
   * designed from the ground up and optimized for HTTP/2 semantics. HTTP/1.1 semantics are layered
   * on HTTP/2.
   *
   * <p>QUIC is not natively supported by OkHttp, but provided to allow a theoretical
   * interceptor that provides support.
   */
  QUIC("quic");

  private final String protocol;

  Protocol(String protocol) {
    this.protocol = protocol;
  }

  /**
   * Returns the protocol identified by {@code protocol}.
   *
   * @throws IOException if {@code protocol} is unknown.
   */
  public static Protocol get(String protocol) throws IOException {
    // Unroll the loop over values() to save an allocation.
    if (protocol.equals(HTTP_1_0.protocol)) {
      return HTTP_1_0;
    }
    if (protocol.equals(HTTP_1_1.protocol)) {
      return HTTP_1_1;
    }
    if (protocol.equals(H2_PRIOR_KNOWLEDGE.protocol)) {
      return H2_PRIOR_KNOWLEDGE;
    }
    if (protocol.equals(HTTP_2.protocol)) {
      return HTTP_2;
    }
    if (protocol.equals(SPDY_3.protocol)) {
      return SPDY_3;
    }
    if (protocol.equals(QUIC.protocol)) {
      return QUIC;
    }
    throw new IOException("Unexpected protocol: " + protocol);
  }

  /**
   * Returns the string used to identify this protocol for ALPN, like "http/1.1", "spdy/3.1" or
   * "h2".
   *
   * @see <a href="https://www.iana.org/assignments/tls-extensiontype-values">IANA
   * tls-extensiontype-values</a>
   */
  @Override
  public String toString() {
    return protocol;
  }
}
