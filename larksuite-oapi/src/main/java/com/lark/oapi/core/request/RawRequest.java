package com.lark.oapi.core.request;

import com.lark.oapi.core.Config;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RawRequest {

  private int statusCode;
  private String contentType;
  private Map<String, List<String>> headers = new HashMap<>();
  private Object body;
  private String reqUrl;
  private String httpMethod;
  private Config config;
  private boolean supportDownLoad;

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
  }

  public Map<String, List<String>> getHeaders() {
    return headers;
  }

  public void setHeaders(Map<String, List<String>> headers) {
    this.headers = headers;
  }

  public Object getBody() {
    return body;
  }

  public void setBody(Object body) {
    this.body = body;
  }

  public String getReqUrl() {
    return reqUrl;
  }

  public void setReqUrl(String reqUrl) {
    this.reqUrl = reqUrl;
  }

  public String getHttpMethod() {
    return httpMethod;
  }

  public void setHttpMethod(String httpMethod) {
    this.httpMethod = httpMethod;
  }

  public Config getConfig() {
    return config;
  }

  public void setConfig(Config config) {
    this.config = config;
  }

  public boolean isSupportDownLoad() {
    return supportDownLoad;
  }

  public void setSupportDownLoad(boolean supportDownLoad) {
    this.supportDownLoad = supportDownLoad;
  }
}

