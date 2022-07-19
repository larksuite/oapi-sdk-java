// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class ChatMember {

  @SerializedName("user_id")
  private String userId;

  // builder 开始
  public ChatMember() {
  }

  public ChatMember(Builder builder) {
    this.userId = builder.userId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public static class Builder {

    private String userId;

    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }


    public ChatMember build() {
      return new ChatMember(this);
    }
  }
}