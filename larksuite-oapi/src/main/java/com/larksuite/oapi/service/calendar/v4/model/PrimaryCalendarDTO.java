// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;

public class PrimaryCalendarDTO {
    @SerializedName("calendars")
    private UserCalendar[] calendars;

    public UserCalendar[] getCalendars() {
        return this.calendars;
    }

    public void setCalendars(UserCalendar[] calendars) {
        this.calendars = calendars;
    }

}