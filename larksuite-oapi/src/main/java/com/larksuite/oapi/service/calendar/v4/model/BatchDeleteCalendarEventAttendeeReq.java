// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Body;
import com.larksuite.oapi.core.annotation.Path;
import com.larksuite.oapi.core.annotation.Query;

public class BatchDeleteCalendarEventAttendeeReq {
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    @Path
    @SerializedName("calendar_id")
    private String calendarId;
    @Path
    @SerializedName("event_id")
    private String eventId;
    @Body
    private BatchDeleteCalendarEventAttendeeReqBody body;

    // builder 开始
    public BatchDeleteCalendarEventAttendeeReq() {
    }

    public BatchDeleteCalendarEventAttendeeReq(Builder builder) {
        this.userIdType = builder.userIdType;
        this.calendarId = builder.calendarId;
        this.eventId = builder.eventId;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUserIdType() {
        return this.userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
    }

    public String getCalendarId() {
        return this.calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    public String getEventId() {
        return this.eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public BatchDeleteCalendarEventAttendeeReqBody getBatchDeleteCalendarEventAttendeeReqBody() {
        return this.body;
    }

    public void setBatchDeleteCalendarEventAttendeeReqBody(BatchDeleteCalendarEventAttendeeReqBody body) {
        this.body = body;
    }

    public static class Builder {
        private String userIdType;
        private String calendarId;
        private String eventId;
        private BatchDeleteCalendarEventAttendeeReqBody body;

        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        public Builder userIdType(com.larksuite.oapi.service.calendar.v4.enums.UserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        public Builder calendarId(String calendarId) {
            this.calendarId = calendarId;
            return this;
        }

        public Builder eventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public BatchDeleteCalendarEventAttendeeReqBody getBatchDeleteCalendarEventAttendeeReqBody() {
            return this.body;
        }

        public Builder batchDeleteCalendarEventAttendeeReqBody(BatchDeleteCalendarEventAttendeeReqBody body) {
            this.body = body;
            return this;
        }

        public BatchDeleteCalendarEventAttendeeReq build() {
            return new BatchDeleteCalendarEventAttendeeReq(this);
        }
    }
}
