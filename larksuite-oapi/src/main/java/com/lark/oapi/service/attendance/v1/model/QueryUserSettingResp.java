// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class QueryUserSettingResp extends BaseResponse {

  @SerializedName("data")
  private QueryUserSetting body;

  public QueryUserSetting getQueryUserSetting() {
    return this.body;
  }

  public void setQueryUserSetting(QueryUserSetting body) {
    this.body = body;
  }
}