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
import static java.util.Collections.singletonMap;
import static java.util.Collections.unmodifiableMap;
import static java.util.Locale.US;

import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/**
 * An RFC 7235 challenge.
 */
public final class Challenge {

  private final String scheme;
  private final Map<String, String> authParams;

  public Challenge(String scheme, Map<String, String> authParams) {
    if (scheme == null) {
      throw new NullPointerException("scheme == null");
    }
    if (authParams == null) {
      throw new NullPointerException("authParams == null");
    }
    this.scheme = scheme;
    Map<String, String> newAuthParams = new LinkedHashMap<>();
    for (Entry<String, String> authParam : authParams.entrySet()) {
      String key = (authParam.getKey() == null) ? null : authParam.getKey().toLowerCase(US);
      newAuthParams.put(key, authParam.getValue());
    }
    this.authParams = unmodifiableMap(newAuthParams);
  }

  public Challenge(String scheme, String realm) {
    if (scheme == null) {
      throw new NullPointerException("scheme == null");
    }
    if (realm == null) {
      throw new NullPointerException("realm == null");
    }
    this.scheme = scheme;
    this.authParams = singletonMap("realm", realm);
  }

  /**
   * Returns a copy of this charset that expects a credential encoded with {@code charset}.
   */
  public Challenge withCharset(Charset charset) {
    if (charset == null) {
      throw new NullPointerException("charset == null");
    }
    Map<String, String> authParams = new LinkedHashMap<>(this.authParams);
    authParams.put("charset", charset.name());
    return new Challenge(scheme, authParams);
  }

  /**
   * Returns the authentication scheme, like {@code Basic}.
   */
  public String scheme() {
    return scheme;
  }

  /**
   * Returns the auth params, including {@code realm} and {@code charset} if present, but as
   * strings. The map's keys are lowercase and should be treated case-insensitively.
   */
  public Map<String, String> authParams() {
    return authParams;
  }

  /**
   * Returns the protection space.
   */
  public String realm() {
    return authParams.get("realm");
  }

  /**
   * Returns the charset that should be used to encode the credentials.
   */
  public Charset charset() {
    String charset = authParams.get("charset");
    if (charset != null) {
      try {
        return Charset.forName(charset);
      } catch (Exception ignore) {
      }
    }
    return ISO_8859_1;
  }

  @Override
  public boolean equals(@Nullable Object other) {
    return other instanceof Challenge
        && ((Challenge) other).scheme.equals(scheme)
        && ((Challenge) other).authParams.equals(authParams);
  }

  @Override
  public int hashCode() {
    int result = 29;
    result = 31 * result + scheme.hashCode();
    result = 31 * result + authParams.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return scheme + " authParams=" + authParams;
  }
}
