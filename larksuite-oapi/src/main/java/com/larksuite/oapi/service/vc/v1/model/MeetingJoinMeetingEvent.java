// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.vc.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.event.model.BaseEventV2;

public class MeetingJoinMeetingEvent extends BaseEventV2 {
    @SerializedName("event")
    private MeetingJoinMeetingEventData event;

    public MeetingJoinMeetingEventData getEvent() {
        return this.event;
    }

    public void setEvent(MeetingJoinMeetingEventData event) {
        this.event = event;
    }

}
