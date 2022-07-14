package com.lark.oapi.core.response;

import com.google.gson.annotations.SerializedName;

public class AppAccessTokenResp {

  @SerializedName("expire")
  private int expire;
  @SerializedName("app_access_token")
  private String appAccessToken;
  @SerializedName("code")
  private int code;
  @SerializedName("msg")
  private String msg;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public int getExpire() {
    return expire;
  }

  public void setExpire(int expire) {
    this.expire = expire;
  }

  public String getAppAccessToken() {
    return appAccessToken;
  }

  public void setAppAccessToken(String appAccessToken) {
    this.appAccessToken = appAccessToken;
  }
}
