// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class ListPublicMailboxMemberResp extends BaseResponse {

  @SerializedName("data")
  private ListPublicMailboxMember body;

  public ListPublicMailboxMember getListPublicMailboxMember() {
    return this.body;
  }

  public void setListPublicMailboxMember(ListPublicMailboxMember body) {
    this.body = body;
  }
}