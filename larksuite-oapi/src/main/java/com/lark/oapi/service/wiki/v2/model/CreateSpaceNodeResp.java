// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.wiki.v2.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class CreateSpaceNodeResp extends BaseResponse {

  @SerializedName("data")
  private CreateSpaceNode body;

  public CreateSpaceNode getCreateSpaceNode() {
    return this.body;
  }

  public void setCreateSpaceNode(CreateSpaceNode body) {
    this.body = body;
  }
}
