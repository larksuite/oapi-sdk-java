// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class CreatePublicMailboxAliasResp extends BaseResponse {

  @SerializedName("data")
  private CreatePublicMailboxAlias body;

  public CreatePublicMailboxAlias getCreatePublicMailboxAlias() {
    return this.body;
  }

  public void setCreatePublicMailboxAlias(CreatePublicMailboxAlias body) {
    this.body = body;
  }
}
