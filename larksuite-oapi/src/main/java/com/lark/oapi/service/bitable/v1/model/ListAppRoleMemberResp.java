// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class ListAppRoleMemberResp extends BaseResponse {

  @SerializedName("data")
  private ListAppRoleMember body;

  public ListAppRoleMember getListAppRoleMember() {
    return this.body;
  }

  public void setListAppRoleMember(ListAppRoleMember body) {
    this.body = body;
  }
}
