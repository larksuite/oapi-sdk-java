package com.lark.oapi.event.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.request.EventReq;

public class BaseEventV2 {

  @SerializedName("schema")
  private String schema;
  @SerializedName("header")
  private Header header;
  private EventReq eventReq;

  public EventReq getEventReq() {
    return eventReq;
  }

  public void setEventReq(EventReq eventReq) {
    this.eventReq = eventReq;
  }

  public String getRequestId() {
    return eventReq == null ? "" : eventReq.getRequestID();
  }


  public String getTenantKey() {
    return header == null ? "" : header.getTenantKey();
  }

  public String getSchema() {
    return schema;
  }

  public void setSchema(String schema) {
    this.schema = schema;
  }

  public Header getHeader() {
    return header;
  }

  public void setHeader(Header header) {
    this.header = header;
  }
}
