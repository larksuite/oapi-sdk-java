// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class CreateChatTabResp extends BaseResponse {

  @SerializedName("data")
  private CreateChatTab body;

  public CreateChatTab getCreateChatTab() {
    return this.body;
  }

  public void setCreateChatTab(CreateChatTab body) {
    this.body = body;
  }
}