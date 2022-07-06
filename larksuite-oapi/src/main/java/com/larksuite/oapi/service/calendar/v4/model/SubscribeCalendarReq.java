// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;

public class SubscribeCalendarReq {
    @Path
    @SerializedName("calendar_id")
    private String calendarId;

    // builder 开始
    public SubscribeCalendarReq() {
    }

    public SubscribeCalendarReq(Builder builder) {
        this.calendarId = builder.calendarId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCalendarId() {
        return this.calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    public static class Builder {

        private String calendarId;

        public Builder calendarId(String calendarId) {
            this.calendarId = calendarId;
            return this;
        }

        public SubscribeCalendarReq build() {
            return new SubscribeCalendarReq(this);
        }
    }
}
