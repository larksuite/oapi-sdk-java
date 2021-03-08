package com.larksuite.oapi.core.event.v1;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.event.model.BaseEvent;
import com.larksuite.oapi.core.event.model.BaseEventData;

public class AppTicketEvent extends BaseEvent {
    @SerializedName("event")
    private AppTicketEventData event;

    public AppTicketEventData getEvent() {
        return event;
    }

    public void setEvent(AppTicketEventData event) {
        this.event = event;
    }

    public static class AppTicketEventData extends BaseEventData {

        @SerializedName("app_ticket")
        private String appTicket;

        public String getAppTicket() {
            return appTicket;
        }

        public void setAppTicket(String appTicket) {
            this.appTicket = appTicket;
        }
    }
}
