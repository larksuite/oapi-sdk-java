// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.calendar.v4.model;
import com.google.gson.annotations.SerializedName;

public class CalendarEventChangedEventData {
    @SerializedName("calendar_id")
    private String calendarId;
    @SerializedName("user_id_list")
    private UserId[] userIdList;

    public String getCalendarId() {
        return this.calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    public UserId[] getUserIdList() {
        return this.userIdList;
    }

    public void setUserIdList(UserId[] userIdList) {
        this.userIdList = userIdList;
    }

}