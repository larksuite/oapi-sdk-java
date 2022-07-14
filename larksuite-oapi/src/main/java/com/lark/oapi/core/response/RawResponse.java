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
