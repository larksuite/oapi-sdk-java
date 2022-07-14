package com.lark.oapi.event;

import com.lark.oapi.core.token.GlobalAppTicketManager;
import com.lark.oapi.event.model.AppTicketEvent;
import java.util.concurrent.TimeUnit;

public class AppTicketEventHandler implements IEventHandler<AppTicketEvent> {

  @Override
  public AppTicketEvent getEvent() {
    return new AppTicketEvent();
  }

  @Override
  public void handle(AppTicketEvent event) {
    GlobalAppTicketManager.getAppTicketManager().put(event.getEvent().getAppId()
        , event.getEvent().getAppTicket()
        , 12
        , TimeUnit.HOURS);
  }
}
