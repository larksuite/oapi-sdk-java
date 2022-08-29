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

package com.lark.oapi.service.admin.v1.model;

import com.google.gson.annotations.SerializedName;

public class ResetPasswordReqBody {

  /**
   * 需要重置的密码参数，不少于8个字符，字母、数字和符号，至少三选二
   * <p> 示例值：1234abcd
   */
  @SerializedName("password")
  private Password password;
  /**
   * 待修改密码的用户ID，只针对邮箱登录凭证与企业邮箱(包括别名)相等的用户生效
   * <p> 示例值：abc123
   */
  @SerializedName("user_id")
  private String userId;

  // builder 开始
  public ResetPasswordReqBody() {
  }

  public ResetPasswordReqBody(Builder builder) {
    /**
     * 需要重置的密码参数，不少于8个字符，字母、数字和符号，至少三选二
     * <p> 示例值：1234abcd
     */
    this.password = builder.password;
    /**
     * 待修改密码的用户ID，只针对邮箱登录凭证与企业邮箱(包括别名)相等的用户生效
     * <p> 示例值：abc123
     */
    this.userId = builder.userId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Password getPassword() {
    return this.password;
  }

  public void setPassword(Password password) {
    this.password = password;
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public static class Builder {

    /**
     * 需要重置的密码参数，不少于8个字符，字母、数字和符号，至少三选二
     * <p> 示例值：1234abcd
     */
    private Password password;
    /**
     * 待修改密码的用户ID，只针对邮箱登录凭证与企业邮箱(包括别名)相等的用户生效
     * <p> 示例值：abc123
     */
    private String userId;

    /**
     * 需要重置的密码参数，不少于8个字符，字母、数字和符号，至少三选二
     * <p> 示例值：1234abcd
     *
     * @param password
     * @return
     */
    public Builder password(Password password) {
      this.password = password;
      return this;
    }


    /**
     * 待修改密码的用户ID，只针对邮箱登录凭证与企业邮箱(包括别名)相等的用户生效
     * <p> 示例值：abc123
     *
     * @param userId
     * @return
     */
    public Builder userId(String userId) {
      this.userId = userId;
      return this;
    }


    public ResetPasswordReqBody build() {
      return new ResetPasswordReqBody(this);
    }
  }
}