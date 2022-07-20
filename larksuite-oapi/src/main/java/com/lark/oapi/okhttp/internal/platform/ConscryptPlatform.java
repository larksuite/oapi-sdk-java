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
package com.lark.oapi.okhttp.internal.platform;

import com.lark.oapi.okhttp.Protocol;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;

/**
 * Platform using Conscrypt (conscrypt.org) if installed as the first Security Provider.
 * <p>
 * Requires org.conscrypt:conscrypt-openjdk-uber on the classpath.
 */
public class ConscryptPlatform extends Platform {

  private ConscryptPlatform() {
  }

  public static ConscryptPlatform buildIfSupported() {
    try {
      // Trigger an early exception over a fatal error, prefer a RuntimeException over Error.
      Class.forName("org.conscrypt.Conscrypt");

      if (!Conscrypt.isAvailable()) {
        return null;
      }

      return new ConscryptPlatform();
    } catch (ClassNotFoundException e) {
      return null;
    }
  }

  @SuppressWarnings("deprecation")
  private Provider getProvider() {
    // defaults to true, but allow for older versions of conscrypt if still compatible
    // new form with boolean is only present in >= 2.0.0
    return Conscrypt.newProviderBuilder().provideTrustManager().build();
  }

  @Override
  public @Nullable
  X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
    if (!Conscrypt.isConscrypt(sslSocketFactory)) {
      return super.trustManager(sslSocketFactory);
    }

    try {
      // org.conscrypt.SSLParametersImpl
      Object sp =
          readFieldOrNull(sslSocketFactory, Object.class, "sslParameters");

      if (sp != null) {
        return readFieldOrNull(sp, X509TrustManager.class, "x509TrustManager");
      }

      return null;
    } catch (Exception e) {
      throw new UnsupportedOperationException(
          "clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e);
    }
  }

  @Override
  public void configureTlsExtensions(
      SSLSocket sslSocket, String hostname, List<Protocol> protocols) throws IOException {
    if (Conscrypt.isConscrypt(sslSocket)) {
      // Enable SNI and session tickets.
      if (hostname != null) {
        Conscrypt.setUseSessionTickets(sslSocket, true);
        Conscrypt.setHostname(sslSocket, hostname);
      }

      // Enable ALPN.
      List<String> names = alpnProtocolNames(protocols);
      Conscrypt.setApplicationProtocols(sslSocket, names.toArray(new String[0]));
    } else {
      super.configureTlsExtensions(sslSocket, hostname, protocols);
    }
  }

  @Override
  public @Nullable
  String getSelectedProtocol(SSLSocket sslSocket) {
    if (Conscrypt.isConscrypt(sslSocket)) {
      return Conscrypt.getApplicationProtocol(sslSocket);
    } else {
      return super.getSelectedProtocol(sslSocket);
    }
  }

  @Override
  public SSLContext getSSLContext() {
    try {
      return SSLContext.getInstance("TLSv1.3", getProvider());
    } catch (NoSuchAlgorithmException e) {
      try {
        // Allow for Conscrypt 1.2
        return SSLContext.getInstance("TLS", getProvider());
      } catch (NoSuchAlgorithmException e2) {
        throw new IllegalStateException("No TLS provider", e);
      }
    }
  }

  @Override
  public void configureSslSocketFactory(SSLSocketFactory socketFactory) {
    if (Conscrypt.isConscrypt(socketFactory)) {
      Conscrypt.setUseEngineSocket(socketFactory, true);
    }
  }
}
