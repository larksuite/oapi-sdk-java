// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.search.v2.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class PatchSchemaResp extends BaseResponse {

  @SerializedName("data")
  private PatchSchema body;

  public PatchSchema getPatchSchema() {
    return this.body;
  }

  public void setPatchSchema(PatchSchema body) {
    this.body = body;
  }
}