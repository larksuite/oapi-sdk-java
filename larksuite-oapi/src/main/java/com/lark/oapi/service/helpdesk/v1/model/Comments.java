// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;

public class Comments {

  @SerializedName("content")
  private String content;
  @SerializedName("created_at")
  private Integer createdAt;
  @SerializedName("id")
  private Integer id;
  @SerializedName("user_avatar_url")
  private String userAvatarUrl;
  @SerializedName("user_name")
  private String userName;
  @SerializedName("user_id")
  private Integer userId;

  // builder 开始
  public Comments() {
  }

  public Comments(Builder builder) {
    this.content = builder.content;
    this.createdAt = builder.createdAt;
    this.id = builder.id;
    this.userAvatarUrl = builder.userAvatarUrl;
    this.userName = builder.userName;
    this.userId = builder.userId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Integer createdAt) {
    this.createdAt = createdAt;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserAvatarUrl() {
    return this.userAvatarUrl;
  }

  public void setUserAvatarUrl(String userAvatarUrl) {
    this.userAvatarUrl = userAvatarUrl;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Integer getUserId() {
    return this.userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public static class Builder {

    private String content;
    private Integer createdAt;
    private Integer id;
    private String userAvatarUrl;
    private String userName;
    private Integer userId;

    public Builder content(String content) {
      this.content = content;
      return this;
    }

    public Builder createdAt(Integer createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    public Builder id(Integer id) {
      this.id = id;
      return this;
    }

    public Builder userAvatarUrl(String userAvatarUrl) {
      this.userAvatarUrl = userAvatarUrl;
      return this;
    }

    public Builder userName(String userName) {
      this.userName = userName;
      return this;
    }

    public Builder userId(Integer userId) {
      this.userId = userId;
      return this;
    }


    public Comments build() {
      return new Comments(this);
    }
  }
}
