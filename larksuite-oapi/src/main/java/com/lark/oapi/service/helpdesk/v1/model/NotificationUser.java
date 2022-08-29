// Code generated by lark suite oapi sdk gen
/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;

public class NotificationUser {

  /**
   * 非必填，用户id
   * <p> 示例值：ou_7277fd1262bfafc363d5b2a1f9c2ac90
   */
  @SerializedName("user_id")
  private String userId;
  /**
   * 非必填，头像地址
   * <p> 示例值：http://*.com/*.png
   */
  @SerializedName("avatar_url")
  private String avatarUrl;
  /**
   * 非必填，用户名称
   * <p> 示例值：test
   */
  @SerializedName("name")
  private String name;

  // builder 开始
  public NotificationUser() {
  }

  public NotificationUser(Builder builder) {
    /**
     * 非必填，用户id
     * <p> 示例值：ou_7277fd1262bfafc363d5b2a1f9c2ac90
     */
    this.userId = builder.userId;
    /**
     * 非必填，头像地址
     * <p> 示例值：http://*.com/*.png
     */
    this.avatarUrl = builder.avatarUrl;
    /**
     * 非必填，用户名称
     * <p> 示例值：test
     */
    this.name = builder.name;
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

  public String getAvatarUrl() {
    return this.avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static class Builder {

    /**
     * 非必填，用户id
     * <p> 示例值：ou_7277fd1262bfafc363d5b2a1f9c2ac90
     */
    private String userId;
    /**
     * 非必填，头像地址
     * <p> 示例值：http://*.com/*.png
     */
    private String avatarUrl;
    /**
     * 非必填，用户名称
     * <p> 示例值：test
     */
    private String name;

    /**
     * 非必填，用户id
     * <p> 示例值：ou_7277fd1262bfafc363d5b2a1f9c2ac90
     *
     * @param userId
     * @return
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }


    /**
     * 非必填，头像地址
     * <p> 示例值：http://*.com/*.png
     *
     * @param avatarUrl
     * @return
     */
    public Builder avatarUrl(String avatarUrl) {
      this.avatarUrl = avatarUrl;
      return this;
    }


    /**
     * 非必填，用户名称
     * <p> 示例值：test
     *
     * @param name
     * @return
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }


    public NotificationUser build() {
      return new NotificationUser(this);
    }
  }
}