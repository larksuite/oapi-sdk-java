// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class DeleteTabsChatTabResp extends BaseResponse {

  @SerializedName("data")
  private DeleteTabsChatTab body;

  public DeleteTabsChatTab getDeleteTabsChatTab() {
    return this.body;
  }

  public void setDeleteTabsChatTab(DeleteTabsChatTab body) {
    this.body = body;
  }
}
