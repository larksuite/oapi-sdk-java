package com.lark.oapi.service.ext.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;

public class AuthenAccessTokenReq {
  @Body
  @SerializedName("body")
  private AuthenAccessTokenReqBody body;

  private AuthenAccessTokenReq(Builder builder) {
    body = builder.body;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    private AuthenAccessTokenReqBody body;

    private Builder() {
    }

    public Builder body(AuthenAccessTokenReqBody body) {
      this.body = body;
      return this;
    }

    public AuthenAccessTokenReq build() {
      return new AuthenAccessTokenReq(this);
    }
  }
}
