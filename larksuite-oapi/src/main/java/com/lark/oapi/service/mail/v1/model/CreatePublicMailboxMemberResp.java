// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class CreatePublicMailboxMemberResp extends BaseResponse {

  @SerializedName("data")
  private CreatePublicMailboxMember body;

  public CreatePublicMailboxMember getCreatePublicMailboxMember() {
    return this.body;
  }

  public void setCreatePublicMailboxMember(CreatePublicMailboxMember body) {
    this.body = body;
  }
}
