// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class MemberBelongGroupResp extends BaseResponse {

  @SerializedName("data")
  private MemberBelongGroup body;

  public MemberBelongGroup getMemberBelongGroup() {
    return this.body;
  }

  public void setMemberBelongGroup(MemberBelongGroup body) {
    this.body = body;
  }
}
