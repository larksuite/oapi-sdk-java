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

import com.lark.oapi.okhttp.internal.Util;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/**
 * A record of a TLS handshake. For HTTPS clients, the client is <i>local</i> and the remote server
 * is its <i>peer</i>.
 *
 * <p>This value object describes a completed handshake. Use {@link ConnectionSpec} to set policy
 * for new handshakes.
 */
public final class Handshake {

  private final TlsVersion tlsVersion;
  private final CipherSuite cipherSuite;
  private final List<Certificate> peerCertificates;
  private final List<Certificate> localCertificates;

  private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite,
      List<Certificate> peerCertificates, List<Certificate> localCertificates) {
    this.tlsVersion = tlsVersion;
    this.cipherSuite = cipherSuite;
    this.peerCertificates = peerCertificates;
    this.localCertificates = localCertificates;
  }

  public static Handshake get(SSLSession session) throws IOException {
    String cipherSuiteString = session.getCipherSuite();
    if (cipherSuiteString == null) {
      throw new IllegalStateException("cipherSuite == null");
    }
    if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuiteString)) {
      throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
    }
    CipherSuite cipherSuite = CipherSuite.forJavaName(cipherSuiteString);

    String tlsVersionString = session.getProtocol();
    if (tlsVersionString == null) {
      throw new IllegalStateException("tlsVersion == null");
    }
    if ("NONE".equals(tlsVersionString)) {
      throw new IOException("tlsVersion == NONE");
    }
    TlsVersion tlsVersion = TlsVersion.forJavaName(tlsVersionString);

    Certificate[] peerCertificates;
    try {
      peerCertificates = session.getPeerCertificates();
    } catch (SSLPeerUnverifiedException ignored) {
      peerCertificates = null;
    }
    List<Certificate> peerCertificatesList = peerCertificates != null
        ? Util.immutableList(peerCertificates)
        : Collections.emptyList();

    Certificate[] localCertificates = session.getLocalCertificates();
    List<Certificate> localCertificatesList = localCertificates != null
        ? Util.immutableList(localCertificates)
        : Collections.emptyList();

    return new Handshake(tlsVersion, cipherSuite, peerCertificatesList, localCertificatesList);
  }

  public static Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite,
      List<Certificate> peerCertificates, List<Certificate> localCertificates) {
    if (tlsVersion == null) {
      throw new NullPointerException("tlsVersion == null");
    }
    if (cipherSuite == null) {
      throw new NullPointerException("cipherSuite == null");
    }
    return new Handshake(tlsVersion, cipherSuite, Util.immutableList(peerCertificates),
        Util.immutableList(localCertificates));
  }

  /**
   * Returns the TLS version used for this connection. This value wasn't tracked prior to OkHttp
   * 3.0. For responses cached by preceding versions this returns {@link TlsVersion#SSL_3_0}.
   */
  public TlsVersion tlsVersion() {
    return tlsVersion;
  }

  /**
   * Returns the cipher suite used for the connection.
   */
  public CipherSuite cipherSuite() {
    return cipherSuite;
  }

  /**
   * Returns a possibly-empty list of certificates that identify the remote peer.
   */
  public List<Certificate> peerCertificates() {
    return peerCertificates;
  }

  /**
   * Returns the remote peer's principle, or null if that peer is anonymous.
   */
  public @Nullable
  Principal peerPrincipal() {
    return !peerCertificates.isEmpty()
        ? ((X509Certificate) peerCertificates.get(0)).getSubjectX500Principal()
        : null;
  }

  /**
   * Returns a possibly-empty list of certificates that identify this peer.
   */
  public List<Certificate> localCertificates() {
    return localCertificates;
  }

  /**
   * Returns the local principle, or null if this peer is anonymous.
   */
  public @Nullable
  Principal localPrincipal() {
    return !localCertificates.isEmpty()
        ? ((X509Certificate) localCertificates.get(0)).getSubjectX500Principal()
        : null;
  }

  @Override
  public boolean equals(@Nullable Object other) {
    if (!(other instanceof Handshake)) {
      return false;
    }
    Handshake that = (Handshake) other;
    return tlsVersion.equals(that.tlsVersion)
        && cipherSuite.equals(that.cipherSuite)
        && peerCertificates.equals(that.peerCertificates)
        && localCertificates.equals(that.localCertificates);
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + tlsVersion.hashCode();
    result = 31 * result + cipherSuite.hashCode();
    result = 31 * result + peerCertificates.hashCode();
    result = 31 * result + localCertificates.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Handshake{"
        + "tlsVersion="
        + tlsVersion
        + " cipherSuite="
        + cipherSuite
        + " peerCertificates="
        + names(peerCertificates)
        + " localCertificates="
        + names(localCertificates)
        + '}';
  }

  private List<String> names(List<Certificate> certificates) {
    ArrayList<String> strings = new ArrayList<>();

    for (Certificate cert : certificates) {
      if (cert instanceof X509Certificate) {
        strings.add(String.valueOf(((X509Certificate) cert).getSubjectDN()));
      } else {
        strings.add(cert.getType());
      }
    }

    return strings;
  }
}
