// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.event.model.BaseEventV2;

public class P2EmployeeTypeEnumDeletedV3 extends BaseEventV2 {

  @SerializedName("event")
  private P2EmployeeTypeEnumDeletedV3Data event;

  public P2EmployeeTypeEnumDeletedV3Data getEvent() {
    return this.event;
  }

  public void setEvent(P2EmployeeTypeEnumDeletedV3Data event) {
    this.event = event;
  }

}