// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class PatchAppTableFormFieldResp extends BaseResponse {

  @SerializedName("data")
  private PatchAppTableFormField body;

  public PatchAppTableFormField getPatchAppTableFormField() {
    return this.body;
  }

  public void setPatchAppTableFormField(PatchAppTableFormField body) {
    this.body = body;
  }
}
