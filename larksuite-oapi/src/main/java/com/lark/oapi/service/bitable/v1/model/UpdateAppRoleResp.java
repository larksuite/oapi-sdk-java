// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class UpdateAppRoleResp extends BaseResponse {

  @SerializedName("data")
  private UpdateAppRole body;

  public UpdateAppRole getUpdateAppRole() {
    return this.body;
  }

  public void setUpdateAppRole(UpdateAppRole body) {
    this.body = body;
  }
}