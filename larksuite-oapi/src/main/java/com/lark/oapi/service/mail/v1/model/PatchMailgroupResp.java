// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class PatchMailgroupResp extends BaseResponse {

  @SerializedName("data")
  private PatchMailgroup body;

  public PatchMailgroup getPatchMailgroup() {
    return this.body;
  }

  public void setPatchMailgroup(PatchMailgroup body) {
    this.body = body;
  }
}