// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.wiki.v2.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class CreateSpaceMemberResp extends BaseResponse {

  @SerializedName("data")
  private CreateSpaceMember body;

  public CreateSpaceMember getCreateSpaceMember() {
    return this.body;
  }

  public void setCreateSpaceMember(CreateSpaceMember body) {
    this.body = body;
  }
}
