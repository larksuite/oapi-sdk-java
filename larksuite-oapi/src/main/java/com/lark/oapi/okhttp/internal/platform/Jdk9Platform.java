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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/**
 * OpenJDK 9+.
 */
final class Jdk9Platform extends Platform {

  final Method setProtocolMethod;
  final Method getProtocolMethod;

  Jdk9Platform(Method setProtocolMethod, Method getProtocolMethod) {
    this.setProtocolMethod = setProtocolMethod;
    this.getProtocolMethod = getProtocolMethod;
  }

  public static Jdk9Platform buildIfSupported() {
    // Find JDK 9 new methods, also present on JDK8 after build 252.
    try {
      Method setProtocolMethod =
          SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
      Method getProtocolMethod = SSLSocket.class.getMethod("getApplicationProtocol");

      return new Jdk9Platform(setProtocolMethod, getProtocolMethod);
    } catch (NoSuchMethodException ignored) {
      // pre JDK 9
    }

    return null;
  }

  @Override
  public void configureTlsExtensions(SSLSocket sslSocket, String hostname,
      List<Protocol> protocols) {
    try {
      SSLParameters sslParameters = sslSocket.getSSLParameters();

      List<String> names = alpnProtocolNames(protocols);

      setProtocolMethod.invoke(sslParameters,
          new Object[]{names.toArray(new String[names.size()])});

      sslSocket.setSSLParameters(sslParameters);
    } catch (IllegalAccessException | InvocationTargetException e) {
      throw new AssertionError("failed to set SSL parameters", e);
    }
  }

  @Override
  public @Nullable
  String getSelectedProtocol(SSLSocket socket) {
    try {
      String protocol = (String) getProtocolMethod.invoke(socket);

      // SSLSocket.getApplicationProtocol returns "" if application protocols values will not
      // be used. Observed if you didn't specify SSLParameters.setApplicationProtocols
      if (protocol == null || protocol.equals("")) {
        return null;
      }

      return protocol;
    } catch (InvocationTargetException e) {
      if (e.getCause() instanceof UnsupportedOperationException) {
        // Handle UnsupportedOperationException as it is defined in the getApplicationProtocol API.
        // https://docs.oracle.com/javase/9/docs/api/javax/net/ssl/SSLSocket.html
        return null;
      }

      throw new AssertionError("failed to get ALPN selected protocol", e);
    } catch (IllegalAccessException e) {
      throw new AssertionError("failed to get ALPN selected protocol", e);
    }
  }

  @Override
  public X509TrustManager trustManager(SSLSocketFactory sslSocketFactory) {
    // Not supported due to access checks on JDK 9+:
    // java.lang.reflect.InaccessibleObjectException: Unable to make member of class
    // sun.security.ssl.SSLSocketFactoryImpl accessible:  module java.base does not export
    // sun.security.ssl to unnamed module @xxx
    throw new UnsupportedOperationException(
        "clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
  }
}
