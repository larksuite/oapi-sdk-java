// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class ListUserResp extends BaseResponse {

  @SerializedName("data")
  private ListUser body;

  public ListUser getListUser() {
    return this.body;
  }

  public void setListUser(ListUser body) {
    this.body = body;
  }
}
