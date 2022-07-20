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

import android.annotation.SuppressLint;
import android.net.ssl.SSLSockets;
import com.lark.oapi.okhttp.Protocol;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/**
 * Android 10+.
 */
@SuppressLint("NewApi")
class Android10Platform extends AndroidPlatform {

  Android10Platform(Class<?> sslParametersClass) {
    super(sslParametersClass, null, null, null, null, null);
  }

  public static @Nullable
  Platform buildIfSupported() {
    if (!isAndroid()) {
      return null;
    }

    try {
      if (getSdkInt() >= 29) {
        Class<?> sslParametersClass =
            Class.forName("com.android.org.conscrypt.SSLParametersImpl");

        return new Android10Platform(sslParametersClass);
      }
    } catch (ReflectiveOperationException ignored) {
    }

    return null; // Not an Android 10+ runtime.
  }

  @SuppressLint("NewApi")
  @IgnoreJRERequirement
  @Override
  public void configureTlsExtensions(
      SSLSocket sslSocket, String hostname, List<Protocol> protocols) throws IOException {
    try {
      enableSessionTickets(sslSocket);

      SSLParameters sslParameters = sslSocket.getSSLParameters();

      // Enable ALPN.
      String[] protocolsArray = alpnProtocolNames(protocols).toArray(new String[0]);
      sslParameters.setApplicationProtocols(protocolsArray);

      sslSocket.setSSLParameters(sslParameters);
    } catch (IllegalArgumentException iae) {
      // probably java.lang.IllegalArgumentException: Invalid input to toASCII from IDN.toASCII
      throw new IOException("Android internal error", iae);
    }
  }

  private void enableSessionTickets(SSLSocket sslSocket) {
    if (SSLSockets.isSupportedSocket(sslSocket)) {
      SSLSockets.setUseSessionTickets(sslSocket, true);
    }
  }

  @IgnoreJRERequirement
  @Override
  public @Nullable
  String getSelectedProtocol(SSLSocket socket) {
    String alpnResult = socket.getApplicationProtocol();

    if (alpnResult == null || alpnResult.isEmpty()) {
      return null;
    }

    return alpnResult;
  }
}
