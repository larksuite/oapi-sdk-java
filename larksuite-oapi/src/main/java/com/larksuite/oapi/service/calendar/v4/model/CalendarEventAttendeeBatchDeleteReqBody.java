// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.calendar.v4.model;
import com.google.gson.annotations.SerializedName;

public class CalendarEventAttendeeBatchDeleteReqBody {
    @SerializedName("attendee_ids")
    private String[] attendeeIds;
    @SerializedName("need_notification")
    private Boolean needNotification;

    public String[] getAttendeeIds() {
        return this.attendeeIds;
    }

    public void setAttendeeIds(String[] attendeeIds) {
        this.attendeeIds = attendeeIds;
    }

    public Boolean getNeedNotification() {
        return this.needNotification;
    }

    public void setNeedNotification(Boolean needNotification) {
        this.needNotification = needNotification;
    }

}
