// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class GetChatMembersResp extends BaseResponse {

  @SerializedName("data")
  private GetChatMembers body;

  public GetChatMembers getGetChatMembers() {
    return this.body;
  }

  public void setGetChatMembers(GetChatMembers body) {
    this.body = body;
  }
}
