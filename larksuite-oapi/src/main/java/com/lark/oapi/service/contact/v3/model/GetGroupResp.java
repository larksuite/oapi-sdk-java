// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class GetGroupResp extends BaseResponse {

  @SerializedName("data")
  private GetGroup body;

  public GetGroup getGetGroup() {
    return this.body;
  }

  public void setGetGroup(GetGroup body) {
    this.body = body;
  }
}