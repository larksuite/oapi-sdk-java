package com.lark.oapi.event.model;

import com.google.gson.annotations.SerializedName;

public class Header {

  @SerializedName("event_id")
  private String eventId;
  @SerializedName("event_type")
  private String eventType;
  @SerializedName("app_id")
  private String appId;
  @SerializedName("tenant_key")
  private String tenantKey;
  @SerializedName("create_time")
  private String createTime;
  @SerializedName("token")
  private String token;

  public String getEventId() {
    return eventId;
  }

  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getTenantKey() {
    return tenantKey;
  }

  public void setTenantKey(String tenantKey) {
    this.tenantKey = tenantKey;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
