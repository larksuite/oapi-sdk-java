// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.meeting_room.v1.model;
import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.event.model.BaseEventV2;

public class MeetingRoomUpdatedEvent extends BaseEventV2{
    @SerializedName("event")
    private MeetingRoomUpdatedEventData event;

    public MeetingRoomUpdatedEventData getEvent() {
        return this.event;
    }

    public void setEvent(MeetingRoomUpdatedEventData event) {
        this.event = event;
    }

}
