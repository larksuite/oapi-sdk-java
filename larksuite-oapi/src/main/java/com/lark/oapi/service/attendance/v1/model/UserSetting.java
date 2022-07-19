// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;

public class UserSetting {

  @SerializedName("user_id")
  private String userId;
  @SerializedName("face_key")
  private String faceKey;
  @SerializedName("face_key_update_time")
  private String faceKeyUpdateTime;

  // builder 开始
  public UserSetting() {
  }

  public UserSetting(Builder builder) {
    this.userId = builder.userId;
    this.faceKey = builder.faceKey;
    this.faceKeyUpdateTime = builder.faceKeyUpdateTime;
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

  public String getFaceKey() {
    return this.faceKey;
  }

  public void setFaceKey(String faceKey) {
    this.faceKey = faceKey;
  }

  public String getFaceKeyUpdateTime() {
    return this.faceKeyUpdateTime;
  }

  public void setFaceKeyUpdateTime(String faceKeyUpdateTime) {
    this.faceKeyUpdateTime = faceKeyUpdateTime;
  }

  public static class Builder {

    private String userId;
    private String faceKey;
    private String faceKeyUpdateTime;

    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }

    public Builder faceKey(String faceKey) {
      this.faceKey = faceKey;
      return this;
    }

    public Builder faceKeyUpdateTime(String faceKeyUpdateTime) {
      this.faceKeyUpdateTime = faceKeyUpdateTime;
      return this;
    }


    public UserSetting build() {
      return new UserSetting(this);
    }
  }
}