package com.larksuite.oapi.event;

import com.larksuite.oapi.core.token.GlobalAppTicketManager;

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
