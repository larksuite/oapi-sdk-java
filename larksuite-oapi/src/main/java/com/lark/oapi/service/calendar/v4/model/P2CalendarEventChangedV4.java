// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.event.model.BaseEventV2;

public class P2CalendarEventChangedV4 extends BaseEventV2 {

  @SerializedName("event")
  private P2CalendarEventChangedV4Data event;

  public P2CalendarEventChangedV4Data getEvent() {
    return this.event;
  }

  public void setEvent(P2CalendarEventChangedV4Data event) {
    this.event = event;
  }

}