// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.vc.v1.model;
import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.event.model.BaseEventV2;

public class MeetingSendMeetingImEvent extends BaseEventV2{
    @SerializedName("event")
    private MeetingSendMeetingImEventData event;

    public MeetingSendMeetingImEventData getEvent() {
        return this.event;
    }

    public void setEvent(MeetingSendMeetingImEventData event) {
        this.event = event;
    }

}