// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.application.v6.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.event.model.BaseEventV2;

public class P2ApplicationAppVersionPublishApplyV6 extends BaseEventV2 {

  @SerializedName("event")
  private P2ApplicationAppVersionPublishApplyV6Data event;

  public P2ApplicationAppVersionPublishApplyV6Data getEvent() {
    return this.event;
  }

  public void setEvent(P2ApplicationAppVersionPublishApplyV6Data event) {
    this.event = event;
  }

}