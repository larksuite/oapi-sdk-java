// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.event.model.BaseEventV2;

public class P2ChatMemberUserDeletedV1 extends BaseEventV2 {

  @SerializedName("event")
  private P2ChatMemberUserDeletedV1Data event;

  public P2ChatMemberUserDeletedV1Data getEvent() {
    return this.event;
  }

  public void setEvent(P2ChatMemberUserDeletedV1Data event) {
    this.event = event;
  }

}