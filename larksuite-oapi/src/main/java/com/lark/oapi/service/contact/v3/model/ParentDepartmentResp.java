// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class ParentDepartmentResp extends BaseResponse {

  @SerializedName("data")
  private ParentDepartment body;

  public ParentDepartment getParentDepartment() {
    return this.body;
  }

  public void setParentDepartment(ParentDepartment body) {
    this.body = body;
  }
}
