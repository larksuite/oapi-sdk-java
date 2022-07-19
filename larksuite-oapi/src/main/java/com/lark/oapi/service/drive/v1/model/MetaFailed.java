// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;

public class MetaFailed {

  @SerializedName("token")
  private String token;
  @SerializedName("code")
  private Integer code;

  // builder 开始
  public MetaFailed() {
  }

  public MetaFailed(Builder builder) {
    this.token = builder.token;
    this.code = builder.code;
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

  public Integer getCode() {
    return this.code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public static class Builder {

    private String token;
    private Integer code;

    public Builder token(String token) {
      this.token = token;
      return this;
    }

    public Builder code(Integer code) {
      this.code = code;
      return this;
    }

    public Builder code(com.lark.oapi.service.drive.v1.enums.CodeEnum code) {
      this.code = code.getValue();
      return this;
    }


    public MetaFailed build() {
      return new MetaFailed(this);
    }
  }
}