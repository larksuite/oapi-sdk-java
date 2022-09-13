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

package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class P1P2PChatCreatedV1Data {

  @SerializedName("type")
  private String type;
  @SerializedName("app_id")
  private String appId;
  @SerializedName("tenant_key")
  private String tenantKey;
  @SerializedName("chat_id")
  private String chatId;
  @SerializedName("operator")
  private P1OperatorV1 operator;
  @SerializedName("user")
  private P1UserV1 user;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getTenantKey() {
    return tenantKey;
  }

  public void setTenantKey(String tenantKey) {
    this.tenantKey = tenantKey;
  }

  public String getChatId() {
    return chatId;
  }

  public void setChatId(String chatId) {
    this.chatId = chatId;
  }

  public P1OperatorV1 getOperator() {
    return operator;
  }

  public void setOperator(P1OperatorV1 operator) {
    this.operator = operator;
  }

  public P1UserV1 getUser() {
    return user;
  }

  public void setUser(P1UserV1 user) {
    this.user = user;
  }

  public static class P1OperatorV1 {

    @SerializedName("open_id")
    private String openId;
    @SerializedName("user_id")
    private String userId;

    public String getOpenId() {
      return openId;
    }

    public void setOpenId(String openId) {
      this.openId = openId;
    }

    public String getUserId() {
      return userId;
    }

    public void setUserId(String userId) {
      this.userId = userId;
    }
  }

  public static class P1UserV1 {

    @SerializedName("user_id")
    private String userId;
    @SerializedName("open_id")
    private String openId;
    @SerializedName("name")
    private String name;

    public String getOpenId() {
      return openId;
    }

    public void setOpenId(String openId) {
      this.openId = openId;
    }

    public String getUserId() {
      return userId;
    }

    public void setUserId(String userId) {
      this.userId = userId;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}
