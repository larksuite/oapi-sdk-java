// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.vc.v1.model;

import com.google.gson.annotations.SerializedName;

public class PstnSipInfo {

  @SerializedName("nickname")
  private String nickname;
  @SerializedName("main_address")
  private String mainAddress;

  // builder 开始
  public PstnSipInfo() {
  }

  public PstnSipInfo(Builder builder) {
    this.nickname = builder.nickname;
    this.mainAddress = builder.mainAddress;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getNickname() {
    return this.nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getMainAddress() {
    return this.mainAddress;
  }

  public void setMainAddress(String mainAddress) {
    this.mainAddress = mainAddress;
  }

  public static class Builder {

    private String nickname;
    private String mainAddress;

    public Builder nickname(String nickname) {
      this.nickname = nickname;
      return this;
    }

    public Builder mainAddress(String mainAddress) {
      this.mainAddress = mainAddress;
      return this;
    }


    public PstnSipInfo build() {
      return new PstnSipInfo(this);
    }
  }
}