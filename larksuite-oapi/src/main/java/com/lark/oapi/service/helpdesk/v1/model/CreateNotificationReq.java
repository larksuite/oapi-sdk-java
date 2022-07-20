// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Query;

public class CreateNotificationReq {

  @Query
  @SerializedName("user_id_type")
  private String userIdType;
  @Body
  private Notification body;

  // builder 开始
  public CreateNotificationReq() {
  }

  public CreateNotificationReq(Builder builder) {
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

  public Notification getNotification() {
    return this.body;
  }

  public void setNotification(Notification body) {
    this.body = body;
  }

  public static class Builder {

    private String userIdType;
    private Notification body;

    public Builder userIdType(String userIdType) {
      this.userIdType = userIdType;
      return this;
    }

    public Builder userIdType(com.lark.oapi.service.helpdesk.v1.enums.UserIdTypeEnum userIdType) {
      this.userIdType = userIdType.getValue();
      return this;
    }

    public Notification getNotification() {
      return this.body;
    }

    public Builder notification(Notification body) {
      this.body = body;
      return this;
    }

    public CreateNotificationReq build() {
      return new CreateNotificationReq(this);
    }
  }
}
