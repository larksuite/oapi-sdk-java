// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class CreateAppRoleResp extends BaseResponse {

  @SerializedName("data")
  private CreateAppRole body;

  public CreateAppRole getCreateAppRole() {
    return this.body;
  }

  public void setCreateAppRole(CreateAppRole body) {
    this.body = body;
  }
}