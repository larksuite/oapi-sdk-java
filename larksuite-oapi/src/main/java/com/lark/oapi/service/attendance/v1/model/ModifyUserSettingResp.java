// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class ModifyUserSettingResp extends BaseResponse {

  @SerializedName("data")
  private ModifyUserSetting body;

  public ModifyUserSetting getModifyUserSetting() {
    return this.body;
  }

  public void setModifyUserSetting(ModifyUserSetting body) {
    this.body = body;
  }
}