// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class CreatePublicMailboxResp extends BaseResponse {

  @SerializedName("data")
  private CreatePublicMailbox body;

  public CreatePublicMailbox getCreatePublicMailbox() {
    return this.body;
  }

  public void setCreatePublicMailbox(CreatePublicMailbox body) {
    this.body = body;
  }
}
