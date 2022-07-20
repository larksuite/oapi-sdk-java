// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Query;

public class CreateBotMessageReq {

  @Query
  @SerializedName("user_id_type")
  private String userIdType;
  @Body
  private BotMessage body;

  // builder 开始
  public CreateBotMessageReq() {
  }

  public CreateBotMessageReq(Builder builder) {
    this.userIdType = builder.userIdType;
    this.body = builder.body;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getUserIdType() {
    return this.userIdType;
  }

  public void setUserIdType(String userIdType) {
    this.userIdType = userIdType;
  }

  public BotMessage getBotMessage() {
    return this.body;
  }

  public void setBotMessage(BotMessage body) {
    this.body = body;
  }

  public static class Builder {

    private String userIdType;
    private BotMessage body;

    public Builder userIdType(String userIdType) {
      this.userIdType = userIdType;
      return this;
    }

    public Builder userIdType(com.lark.oapi.service.helpdesk.v1.enums.UserIdTypeEnum userIdType) {
      this.userIdType = userIdType.getValue();
      return this;
    }

    public BotMessage getBotMessage() {
      return this.body;
    }

    public Builder botMessage(BotMessage body) {
      this.body = body;
      return this;
    }

    public CreateBotMessageReq build() {
      return new CreateBotMessageReq(this);
    }
  }
}
