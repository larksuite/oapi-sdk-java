// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.meeting_room.v1.model;
import com.google.gson.annotations.SerializedName;

public class SummaryBatchGetReqBody {
    @SerializedName("EventUids")
    private EventUid[] eventUids;

    public EventUid[] getEventUids() {
        return this.eventUids;
    }

    public void setEventUids(EventUid[] eventUids) {
        this.eventUids = eventUids;
    }

}