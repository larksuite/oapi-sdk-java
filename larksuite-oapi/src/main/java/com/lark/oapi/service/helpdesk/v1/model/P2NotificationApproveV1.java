// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.event.model.BaseEventV2;

public class P2NotificationApproveV1 extends BaseEventV2 {

  @SerializedName("event")
  private P2NotificationApproveV1Data event;

  public P2NotificationApproveV1Data getEvent() {
    return this.event;
  }

  public void setEvent(P2NotificationApproveV1Data event) {
    this.event = event;
  }

}
