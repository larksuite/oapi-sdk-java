// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class GetFaqResp extends BaseResponse {

  @SerializedName("data")
  private GetFaq body;

  public GetFaq getGetFaq() {
    return this.body;
  }

  public void setGetFaq(GetFaq body) {
    this.body = body;
  }
}
