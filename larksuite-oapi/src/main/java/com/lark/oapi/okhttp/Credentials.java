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

import static java.nio.charset.StandardCharsets.ISO_8859_1;

import com.lark.oapi.okio.ByteString;
import java.nio.charset.Charset;

/**
 * Factory for HTTP authorization credentials.
 */
public final class Credentials {

  private Credentials() {
  }

  /**
   * Returns an auth credential for the Basic scheme.
   */
  public static String basic(String username, String password) {
    return basic(username, password, ISO_8859_1);
  }

  public static String basic(String username, String password, Charset charset) {
    String usernameAndPassword = username + ":" + password;
    String encoded = ByteString.encodeString(usernameAndPassword, charset).base64();
    return "Basic " + encoded;
  }
}
