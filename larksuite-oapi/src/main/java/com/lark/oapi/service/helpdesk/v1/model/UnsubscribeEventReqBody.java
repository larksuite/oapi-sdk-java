// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;

public class UnsubscribeEventReqBody {

  @SerializedName("events")
  private Event[] events;

  // builder 开始
  public UnsubscribeEventReqBody() {
  }

  public UnsubscribeEventReqBody(Builder builder) {
    this.events = builder.events;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Event[] getEvents() {
    return this.events;
  }

  public void setEvents(Event[] events) {
    this.events = events;
  }

  public static class Builder {

    private Event[] events;

    public Builder events(Event[] events) {
      this.events = events;
      return this;
    }


    public UnsubscribeEventReqBody build() {
      return new UnsubscribeEventReqBody(this);
    }
  }
}
