// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Query;

public class CreateTimeoffEventReq {

  @Query
  @SerializedName("user_id_type")
  private String userIdType;
  @Body
  private TimeoffEvent body;

  // builder 开始
  public CreateTimeoffEventReq() {
  }

  public CreateTimeoffEventReq(Builder builder) {
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

  public TimeoffEvent getTimeoffEvent() {
    return this.body;
  }

  public void setTimeoffEvent(TimeoffEvent body) {
    this.body = body;
  }

  public static class Builder {

    private String userIdType;
    private TimeoffEvent body;

    public Builder userIdType(String userIdType) {
      this.userIdType = userIdType;
      return this;
    }

    public Builder userIdType(com.lark.oapi.service.calendar.v4.enums.UserIdTypeEnum userIdType) {
      this.userIdType = userIdType.getValue();
      return this;
    }

    public TimeoffEvent getTimeoffEvent() {
      return this.body;
    }

    public Builder timeoffEvent(TimeoffEvent body) {
      this.body = body;
      return this;
    }

    public CreateTimeoffEventReq build() {
      return new CreateTimeoffEventReq(this);
    }
  }
}