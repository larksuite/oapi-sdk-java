// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class GetUserFlowResp extends BaseResponse {

  @SerializedName("data")
  private GetUserFlow body;

  public GetUserFlow getGetUserFlow() {
    return this.body;
  }

  public void setGetUserFlow(GetUserFlow body) {
    this.body = body;
  }
}
