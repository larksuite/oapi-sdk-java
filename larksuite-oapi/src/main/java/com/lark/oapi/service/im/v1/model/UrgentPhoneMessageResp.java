// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class UrgentPhoneMessageResp extends BaseResponse {

  @SerializedName("data")
  private UrgentPhoneMessage body;

  public UrgentPhoneMessage getUrgentPhoneMessage() {
    return this.body;
  }

  public void setUrgentPhoneMessage(UrgentPhoneMessage body) {
    this.body = body;
  }
}