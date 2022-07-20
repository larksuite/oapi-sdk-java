// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;

public class CreateTicketMessageReqBody {

  @SerializedName("msg_type")
  private String msgType;
  @SerializedName("content")
  private String content;

  // builder 开始
  public CreateTicketMessageReqBody() {
  }

  public CreateTicketMessageReqBody(Builder builder) {
    this.msgType = builder.msgType;
    this.content = builder.content;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getMsgType() {
    return this.msgType;
  }

  public void setMsgType(String msgType) {
    this.msgType = msgType;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public static class Builder {

    private String msgType;
    private String content;

    public Builder msgType(String msgType) {
      this.msgType = msgType;
      return this;
    }

    public Builder content(String content) {
      this.content = content;
      return this;
    }


    public CreateTicketMessageReqBody build() {
      return new CreateTicketMessageReqBody(this);
    }
  }
}
