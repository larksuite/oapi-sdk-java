// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.ehr.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Path;

public class GetAttachmentReq {

  @Path
  @SerializedName("token")
  private String token;

  // builder 开始
  public GetAttachmentReq() {
  }

  public GetAttachmentReq(Builder builder) {
    this.token = builder.token;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getToken() {
    return this.token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public static class Builder {

    private String token;

    public Builder token(String token) {
      this.token = token;
      return this;
    }

    public GetAttachmentReq build() {
      return new GetAttachmentReq(this);
    }
  }
}