// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.calendar.v4.model;
import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.event.model.BaseEventV2;

public class CalendarEventChangedEvent extends BaseEventV2{
    @SerializedName("event")
    private CalendarEventChangedEventData event;

    public CalendarEventChangedEventData getEvent() {
        return this.event;
    }

    public void setEvent(CalendarEventChangedEventData event) {
        this.event = event;
    }

}
