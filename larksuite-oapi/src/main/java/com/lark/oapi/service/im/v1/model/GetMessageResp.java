// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class GetMessageResp extends BaseResponse {

  @SerializedName("data")
  private GetMessage body;

  public GetMessage getGetMessage() {
    return this.body;
  }

  public void setGetMessage(GetMessage body) {
    this.body = body;
  }
}
