// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class UpdateAppTableRecordResp extends BaseResponse {

  @SerializedName("data")
  private UpdateAppTableRecord body;

  public UpdateAppTableRecord getUpdateAppTableRecord() {
    return this.body;
  }

  public void setUpdateAppTableRecord(UpdateAppTableRecord body) {
    this.body = body;
  }
}