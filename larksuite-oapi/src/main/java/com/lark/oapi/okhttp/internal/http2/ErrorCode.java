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
package com.lark.oapi.okhttp.internal.http2;

// http://tools.ietf.org/html/draft-ietf-httpbis-http2-17#section-7
public enum ErrorCode {
  /**
   * Not an error!
   */
  NO_ERROR(0),

  PROTOCOL_ERROR(1),

  INTERNAL_ERROR(2),

  FLOW_CONTROL_ERROR(3),

  REFUSED_STREAM(7),

  CANCEL(8),

  COMPRESSION_ERROR(9),

  CONNECT_ERROR(0xa),

  ENHANCE_YOUR_CALM(0xb),

  INADEQUATE_SECURITY(0xc),

  HTTP_1_1_REQUIRED(0xd);

  public final int httpCode;

  ErrorCode(int httpCode) {
    this.httpCode = httpCode;
  }

  public static ErrorCode fromHttp2(int code) {
    for (ErrorCode errorCode : ErrorCode.values()) {
      if (errorCode.httpCode == code) {
        return errorCode;
      }
    }
    return null;
  }
}
