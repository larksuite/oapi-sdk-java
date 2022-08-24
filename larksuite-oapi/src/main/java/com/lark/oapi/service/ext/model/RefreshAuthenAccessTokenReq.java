package com.lark.oapi.service.ext.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;

public class RefreshAuthenAccessTokenReq {

  @Body
  @SerializedName("body")
  private RefreshAuthenAccessTokenReqBody body;

  private RefreshAuthenAccessTokenReq(Builder builder) {
    body = builder.body;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    private RefreshAuthenAccessTokenReqBody body;

    private Builder() {
    }

    public Builder body(RefreshAuthenAccessTokenReqBody body) {
      this.body = body;
      return this;
    }

    public RefreshAuthenAccessTokenReq build() {
      return new RefreshAuthenAccessTokenReq(this);
    }
  }
}
