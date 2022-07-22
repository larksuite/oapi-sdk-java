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

package com.lark.oapi.core.request;

import com.google.gson.annotations.SerializedName;

public class MarketplaceAppAccessTokenReq {

  @SerializedName("app_id")
  private String appId;
  @SerializedName("app_secret")
  private String appSecret;
  @SerializedName("app_ticket")
  private String appTicket;

  public MarketplaceAppAccessTokenReq(Builder builder) {
    setAppId(builder.appId);
    setAppSecret(builder.appSecret);
    setAppTicket(builder.appTicket);
  }

  public MarketplaceAppAccessTokenReq() {
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getAppSecret() {
    return appSecret;
  }

  public void setAppSecret(String appSecret) {
    this.appSecret = appSecret;
  }

  public String getAppTicket() {
    return appTicket;
  }

  public void setAppTicket(String appTicket) {
    this.appTicket = appTicket;
  }

  public static final class Builder {

    private String appId;
    private String appSecret;
    private String appTicket;

    private Builder() {
    }

    public Builder appId(String appId) {
      this.appId = appId;
      return this;
    }

    public Builder appSecret(String appSecret) {
      this.appSecret = appSecret;
      return this;
    }

    public Builder appTicket(String appTicket) {
      this.appTicket = appTicket;
      return this;
    }

    public MarketplaceAppAccessTokenReq build() {
      return new MarketplaceAppAccessTokenReq(this);
    }
  }
}
