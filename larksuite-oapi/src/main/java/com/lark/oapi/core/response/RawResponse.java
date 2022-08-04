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

package com.lark.oapi.core.response;

import com.lark.oapi.core.Constants;
import com.lark.oapi.core.utils.FileNameParser;
import com.lark.oapi.core.utils.Strings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RawResponse {

  private int statusCode;
  private String contentType;
  private Map<String, List<String>> headers = new HashMap<>();
  private byte[] body;

  public RawResponse() {
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
    List<String> ct = new ArrayList<>();
    ct.add(contentType);
    this.headers.put(Constants.CONTENT_TYPE, ct);
  }

  public Map<String, List<String>> getHeaders() {
    return headers;
  }

  public void setHeaders(Map<String, List<String>> headers) {
    this.headers = headers;
  }

  public byte[] getBody() {
    return body;
  }

  public void setBody(byte[] body) {
    this.body = body;
  }

  private String getHeaderFirstValue(String name) {
    List<String> values = this.headers.get(name);
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

  public String getFileName() {
    String contentDisposition = getHeaderFirstValue(Constants.CONTENT_DISPOSITION);
    return FileNameParser.parseFileName(contentDisposition);
  }

}
