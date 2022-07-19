// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class UserId {

  @SerializedName("user_id")
  private String userId;
  @SerializedName("open_id")
  private String openId;
  @SerializedName("union_id")
  private String unionId;

  // builder 开始
  public UserId() {
  }

  public UserId(Builder builder) {
    this.userId = builder.userId;
    this.openId = builder.openId;
    this.unionId = builder.unionId;
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

  public String getOpenId() {
    return this.openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getUnionId() {
    return this.unionId;
  }

  public void setUnionId(String unionId) {
    this.unionId = unionId;
  }

  public static class Builder {

    private String userId;
    private String openId;
    private String unionId;

    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }

    public Builder openId(String openId) {
      this.openId = openId;
      return this;
    }

    public Builder unionId(String unionId) {
      this.unionId = unionId;
      return this;
    }


    public UserId build() {
      return new UserId(this);
    }
  }
}