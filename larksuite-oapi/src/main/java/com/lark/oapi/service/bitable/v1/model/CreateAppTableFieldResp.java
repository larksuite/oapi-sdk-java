// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class CreateAppTableFieldResp extends BaseResponse {

  @SerializedName("data")
  private CreateAppTableField body;

  public CreateAppTableField getCreateAppTableField() {
    return this.body;
  }

  public void setCreateAppTableField(CreateAppTableField body) {
    this.body = body;
  }
}
