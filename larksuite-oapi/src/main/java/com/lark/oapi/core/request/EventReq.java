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

package com.lark.oapi.core.request;

import com.lark.oapi.core.Constants;
import com.lark.oapi.core.utils.Strings;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventReq {

  private byte[] body;
  private String httpPath;
  private Map<String, List<String>> headers = new HashMap();

  public String getHttpPath() {
    return httpPath;
  }

  public void setHttpPath(String httpPath) {
    this.httpPath = httpPath;
  }

  public byte[] getBody() {
    return body;
  }

  public void setBody(byte[] body) {
    this.body = body;
  }

  public Map<String, List<String>> getHeaders() {
    return headers;
  }

  public void setHeaders(Map<String, List<String>> headers) {
    this.headers = headers;
  }

  private String normalizeKey(String name) {
    return name != null ? name.toLowerCase() : null;
  }

  public String getHeaderFirstValue(String name) {
    List<String> values = this.headers.get(normalizeKey(name));
    if (values != null && values.size() > 0) {
      return values.get(0);
    } else {
      return "";
    }
  }

  public String getRequestID() {
    String logID = getHeaderFirstValue(Constants.HTTP_HEADER_KEY_LOG_ID);
    if (!Strings.isEmpty(logID)) {
      return logID;
    }
    return getHeaderFirstValue(Constants.HTTP_HEADER_KEY_REQUEST_ID);
  }
}
