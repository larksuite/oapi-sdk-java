// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class CreateCalendarAclResp extends BaseResponse {

  @SerializedName("data")
  private CreateCalendarAcl body;

  public CreateCalendarAcl getCreateCalendarAcl() {
    return this.body;
  }

  public void setCreateCalendarAcl(CreateCalendarAcl body) {
    this.body = body;
  }
}
