// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class ListDepartmentResp extends BaseResponse {

  @SerializedName("data")
  private ListDepartment body;

  public ListDepartment getListDepartment() {
    return this.body;
  }

  public void setListDepartment(ListDepartment body) {
    this.body = body;
  }
}