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

package com.lark.oapi.service.meeting_room.v1.model;

import com.google.gson.annotations.SerializedName;

public class UserInfo {

  /**
   * <p> 示例值：
   */
  @SerializedName("open_id")
  private String openId;
  /**
   * 用户在ISV下的唯一标识，申请了"获取用户 user ID"权限后才会返回
   * <p> 示例值：
   */
  @SerializedName("user_id")
  private String userId;

  // builder 开始
  public UserInfo() {
  }

  public UserInfo(Builder builder) {
    /**
     *
     * <p> 示例值：
     */
    this.openId = builder.openId;
    /**
     * 用户在ISV下的唯一标识，申请了"获取用户 user ID"权限后才会返回
     * <p> 示例值：
     */
    this.userId = builder.userId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getOpenId() {
    return this.openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public static class Builder {

    /**
     * <p> 示例值：
     */
    private String openId;
    /**
     * 用户在ISV下的唯一标识，申请了"获取用户 user ID"权限后才会返回
     * <p> 示例值：
     */
    private String userId;

    /**
     * <p> 示例值：
     *
     * @param openId
     * @return
     */
    public Builder openId(String openId) {
      this.openId = openId;
      return this;
    }


    /**
     * 用户在ISV下的唯一标识，申请了"获取用户 user ID"权限后才会返回
     * <p> 示例值：
     *
     * @param userId
     * @return
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }


    public UserInfo build() {
      return new UserInfo(this);
    }
  }
}