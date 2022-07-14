package com.lark.oapi.event;

import com.lark.oapi.core.request.EventReq;

public abstract class CustomEventHandler implements IEventHandler<EventReq> {

  @Override
  public EventReq getEvent() {
    return new EventReq();
  }
}
