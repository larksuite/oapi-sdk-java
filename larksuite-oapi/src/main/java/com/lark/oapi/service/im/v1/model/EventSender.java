// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class EventSender {

  @SerializedName("sender_id")
  private UserId senderId;
  @SerializedName("sender_type")
  private String senderType;
  @SerializedName("tenant_key")
  private String tenantKey;

  // builder 开始
  public EventSender() {
  }

  public EventSender(Builder builder) {
    this.senderId = builder.senderId;
    this.senderType = builder.senderType;
    this.tenantKey = builder.tenantKey;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public UserId getSenderId() {
    return this.senderId;
  }

  public void setSenderId(UserId senderId) {
    this.senderId = senderId;
  }

  public String getSenderType() {
    return this.senderType;
  }

  public void setSenderType(String senderType) {
    this.senderType = senderType;
  }

  public String getTenantKey() {
    return this.tenantKey;
  }

  public void setTenantKey(String tenantKey) {
    this.tenantKey = tenantKey;
  }

  public static class Builder {

    private UserId senderId;
    private String senderType;
    private String tenantKey;

    public Builder senderId(UserId senderId) {
      this.senderId = senderId;
      return this;
    }

    public Builder senderType(String senderType) {
      this.senderType = senderType;
      return this;
    }

    public Builder tenantKey(String tenantKey) {
      this.tenantKey = tenantKey;
      return this;
    }


    public EventSender build() {
      return new EventSender(this);
    }
  }
}