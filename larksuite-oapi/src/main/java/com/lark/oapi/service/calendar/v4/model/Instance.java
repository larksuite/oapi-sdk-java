// Code generated by lark suite oapi sdk gen
/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;

public class Instance {
    /**
     * 日程实例ID
     * <p> 示例值：75d28f9b-e35c-4230-8a83-4a661497db54_1602504000
     */
    @SerializedName("event_id")
    private String eventId;
    /**
     * 日程主题
     * <p> 示例值：日程主题
     */
    @SerializedName("summary")
    private String summary;
    /**
     * 日程描述
     * <p> 示例值：desc
     */
    @SerializedName("description")
    private String description;
    /**
     * 开始时间
     * <p> 示例值：
     */
    @SerializedName("start_time")
    private TimeInfo startTime;
    /**
     * 结束时间
     * <p> 示例值：
     */
    @SerializedName("end_time")
    private TimeInfo endTime;
    /**
     * 日程状态
     * <p> 示例值：confirmed
     */
    @SerializedName("status")
    private String status;
    /**
     * 是否是例外日程实例
     * <p> 示例值：false
     */
    @SerializedName("is_exception")
    private Boolean isException;
    /**
     * 日程的app_link,跳转到具体的某个日程
     * <p> 示例值：https://applink.larkoffice.com/client/calendar/event/detail?calendarId=7039673579105026066&key=aeac9c56-aeb1-4179-a21b-02f278f59048&originalTime=0&startTime=1700496000
     */
    @SerializedName("app_link")
    private String appLink;
    /**
     * 日程组织者日历ID
     * <p> 示例值：feishu.cn_HF9U2MbibE8PPpjro6xjqa@group.calendar.feishu.cn
     */
    @SerializedName("organizer_calendar_id")
    private String organizerCalendarId;
    /**
     * 视频会议信息，仅当日程至少有一位attendee时生效
     * <p> 示例值：
     */
    @SerializedName("vchat")
    private Vchat vchat;
    /**
     * 日程公开范围，新建日程默认为Default；仅新建日程时对所有参与人生效，之后修改该属性仅对当前身份生效
     * <p> 示例值：
     */
    @SerializedName("visibility")
    private String visibility;
    /**
     * 参与人权限
     * <p> 示例值：
     */
    @SerializedName("attendee_ability")
    private String attendeeAbility;
    /**
     * 日程占用的忙闲状态，新建日程默认为Busy；仅新建日程时对所有参与人生效，之后修改该属性仅对当前身份生效
     * <p> 示例值：
     */
    @SerializedName("free_busy_status")
    private String freeBusyStatus;
    /**
     * 日程地点
     * <p> 示例值：
     */
    @SerializedName("location")
    private EventLocation location;
    /**
     * 日程颜色，颜色RGB值的int32表示。仅对当前身份生效；客户端展示时会映射到色板上最接近的一种颜色；值为0或-1时默认跟随日历颜色。
     * <p> 示例值：0
     */
    @SerializedName("color")
    private Integer color;
    /**
     * 例外日程的原重复日程的event_id
     * <p> 示例值：75d28f9b-e35c-4230-8a83-4a661497db54_0
     */
    @SerializedName("recurring_event_id")
    private String recurringEventId;
    /**
     * 日程组织者信息
     * <p> 示例值：
     */
    @SerializedName("event_organizer")
    private EventOrganizer eventOrganizer;
    /**
     * 日程参与人信息
     * <p> 示例值：
     */
    @SerializedName("attendees")
    private CalendarEventAttendee[] attendees;

    // builder 开始
    public Instance() {
    }

    public Instance(Builder builder) {
        /**
         * 日程实例ID
         * <p> 示例值：75d28f9b-e35c-4230-8a83-4a661497db54_1602504000
         */
        this.eventId = builder.eventId;
        /**
         * 日程主题
         * <p> 示例值：日程主题
         */
        this.summary = builder.summary;
        /**
         * 日程描述
         * <p> 示例值：desc
         */
        this.description = builder.description;
        /**
         * 开始时间
         * <p> 示例值：
         */
        this.startTime = builder.startTime;
        /**
         * 结束时间
         * <p> 示例值：
         */
        this.endTime = builder.endTime;
        /**
         * 日程状态
         * <p> 示例值：confirmed
         */
        this.status = builder.status;
        /**
         * 是否是例外日程实例
         * <p> 示例值：false
         */
        this.isException = builder.isException;
        /**
         * 日程的app_link,跳转到具体的某个日程
         * <p> 示例值：https://applink.larkoffice.com/client/calendar/event/detail?calendarId=7039673579105026066&key=aeac9c56-aeb1-4179-a21b-02f278f59048&originalTime=0&startTime=1700496000
         */
        this.appLink = builder.appLink;
        /**
         * 日程组织者日历ID
         * <p> 示例值：feishu.cn_HF9U2MbibE8PPpjro6xjqa@group.calendar.feishu.cn
         */
        this.organizerCalendarId = builder.organizerCalendarId;
        /**
         * 视频会议信息，仅当日程至少有一位attendee时生效
         * <p> 示例值：
         */
        this.vchat = builder.vchat;
        /**
         * 日程公开范围，新建日程默认为Default；仅新建日程时对所有参与人生效，之后修改该属性仅对当前身份生效
         * <p> 示例值：
         */
        this.visibility = builder.visibility;
        /**
         * 参与人权限
         * <p> 示例值：
         */
        this.attendeeAbility = builder.attendeeAbility;
        /**
         * 日程占用的忙闲状态，新建日程默认为Busy；仅新建日程时对所有参与人生效，之后修改该属性仅对当前身份生效
         * <p> 示例值：
         */
        this.freeBusyStatus = builder.freeBusyStatus;
        /**
         * 日程地点
         * <p> 示例值：
         */
        this.location = builder.location;
        /**
         * 日程颜色，颜色RGB值的int32表示。仅对当前身份生效；客户端展示时会映射到色板上最接近的一种颜色；值为0或-1时默认跟随日历颜色。
         * <p> 示例值：0
         */
        this.color = builder.color;
        /**
         * 例外日程的原重复日程的event_id
         * <p> 示例值：75d28f9b-e35c-4230-8a83-4a661497db54_0
         */
        this.recurringEventId = builder.recurringEventId;
        /**
         * 日程组织者信息
         * <p> 示例值：
         */
        this.eventOrganizer = builder.eventOrganizer;
        /**
         * 日程参与人信息
         * <p> 示例值：
         */
        this.attendees = builder.attendees;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getEventId() {
        return this.eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TimeInfo getStartTime() {
        return this.startTime;
    }

    public void setStartTime(TimeInfo startTime) {
        this.startTime = startTime;
    }

    public TimeInfo getEndTime() {
        return this.endTime;
    }

    public void setEndTime(TimeInfo endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getIsException() {
        return this.isException;
    }

    public void setIsException(Boolean isException) {
        this.isException = isException;
    }

    public String getAppLink() {
        return this.appLink;
    }

    public void setAppLink(String appLink) {
        this.appLink = appLink;
    }

    public String getOrganizerCalendarId() {
        return this.organizerCalendarId;
    }

    public void setOrganizerCalendarId(String organizerCalendarId) {
        this.organizerCalendarId = organizerCalendarId;
    }

    public Vchat getVchat() {
        return this.vchat;
    }

    public void setVchat(Vchat vchat) {
        this.vchat = vchat;
    }

    public String getVisibility() {
        return this.visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getAttendeeAbility() {
        return this.attendeeAbility;
    }

    public void setAttendeeAbility(String attendeeAbility) {
        this.attendeeAbility = attendeeAbility;
    }

    public String getFreeBusyStatus() {
        return this.freeBusyStatus;
    }

    public void setFreeBusyStatus(String freeBusyStatus) {
        this.freeBusyStatus = freeBusyStatus;
    }

    public EventLocation getLocation() {
        return this.location;
    }

    public void setLocation(EventLocation location) {
        this.location = location;
    }

    public Integer getColor() {
        return this.color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public String getRecurringEventId() {
        return this.recurringEventId;
    }

    public void setRecurringEventId(String recurringEventId) {
        this.recurringEventId = recurringEventId;
    }

    public EventOrganizer getEventOrganizer() {
        return this.eventOrganizer;
    }

    public void setEventOrganizer(EventOrganizer eventOrganizer) {
        this.eventOrganizer = eventOrganizer;
    }

    public CalendarEventAttendee[] getAttendees() {
        return this.attendees;
    }

    public void setAttendees(CalendarEventAttendee[] attendees) {
        this.attendees = attendees;
    }

    public static class Builder {
        /**
         * 日程实例ID
         * <p> 示例值：75d28f9b-e35c-4230-8a83-4a661497db54_1602504000
         */
        private String eventId;
        /**
         * 日程主题
         * <p> 示例值：日程主题
         */
        private String summary;
        /**
         * 日程描述
         * <p> 示例值：desc
         */
        private String description;
        /**
         * 开始时间
         * <p> 示例值：
         */
        private TimeInfo startTime;
        /**
         * 结束时间
         * <p> 示例值：
         */
        private TimeInfo endTime;
        /**
         * 日程状态
         * <p> 示例值：confirmed
         */
        private String status;
        /**
         * 是否是例外日程实例
         * <p> 示例值：false
         */
        private Boolean isException;
        /**
         * 日程的app_link,跳转到具体的某个日程
         * <p> 示例值：https://applink.larkoffice.com/client/calendar/event/detail?calendarId=7039673579105026066&key=aeac9c56-aeb1-4179-a21b-02f278f59048&originalTime=0&startTime=1700496000
         */
        private String appLink;
        /**
         * 日程组织者日历ID
         * <p> 示例值：feishu.cn_HF9U2MbibE8PPpjro6xjqa@group.calendar.feishu.cn
         */
        private String organizerCalendarId;
        /**
         * 视频会议信息，仅当日程至少有一位attendee时生效
         * <p> 示例值：
         */
        private Vchat vchat;
        /**
         * 日程公开范围，新建日程默认为Default；仅新建日程时对所有参与人生效，之后修改该属性仅对当前身份生效
         * <p> 示例值：
         */
        private String visibility;
        /**
         * 参与人权限
         * <p> 示例值：
         */
        private String attendeeAbility;
        /**
         * 日程占用的忙闲状态，新建日程默认为Busy；仅新建日程时对所有参与人生效，之后修改该属性仅对当前身份生效
         * <p> 示例值：
         */
        private String freeBusyStatus;
        /**
         * 日程地点
         * <p> 示例值：
         */
        private EventLocation location;
        /**
         * 日程颜色，颜色RGB值的int32表示。仅对当前身份生效；客户端展示时会映射到色板上最接近的一种颜色；值为0或-1时默认跟随日历颜色。
         * <p> 示例值：0
         */
        private Integer color;
        /**
         * 例外日程的原重复日程的event_id
         * <p> 示例值：75d28f9b-e35c-4230-8a83-4a661497db54_0
         */
        private String recurringEventId;
        /**
         * 日程组织者信息
         * <p> 示例值：
         */
        private EventOrganizer eventOrganizer;
        /**
         * 日程参与人信息
         * <p> 示例值：
         */
        private CalendarEventAttendee[] attendees;

        /**
         * 日程实例ID
         * <p> 示例值：75d28f9b-e35c-4230-8a83-4a661497db54_1602504000
         *
         * @param eventId
         * @return
         */
        public Builder eventId(String eventId) {
            this.eventId = eventId;
            return this;
        }


        /**
         * 日程主题
         * <p> 示例值：日程主题
         *
         * @param summary
         * @return
         */
        public Builder summary(String summary) {
            this.summary = summary;
            return this;
        }


        /**
         * 日程描述
         * <p> 示例值：desc
         *
         * @param description
         * @return
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }


        /**
         * 开始时间
         * <p> 示例值：
         *
         * @param startTime
         * @return
         */
        public Builder startTime(TimeInfo startTime) {
            this.startTime = startTime;
            return this;
        }


        /**
         * 结束时间
         * <p> 示例值：
         *
         * @param endTime
         * @return
         */
        public Builder endTime(TimeInfo endTime) {
            this.endTime = endTime;
            return this;
        }


        /**
         * 日程状态
         * <p> 示例值：confirmed
         *
         * @param status
         * @return
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        /**
         * 日程状态
         * <p> 示例值：confirmed
         *
         * @param status {@link com.lark.oapi.service.calendar.v4.enums.InstanceEventStatusEnum}
         * @return
         */
        public Builder status(com.lark.oapi.service.calendar.v4.enums.InstanceEventStatusEnum status) {
            this.status = status.getValue();
            return this;
        }


        /**
         * 是否是例外日程实例
         * <p> 示例值：false
         *
         * @param isException
         * @return
         */
        public Builder isException(Boolean isException) {
            this.isException = isException;
            return this;
        }


        /**
         * 日程的app_link,跳转到具体的某个日程
         * <p> 示例值：https://applink.larkoffice.com/client/calendar/event/detail?calendarId=7039673579105026066&key=aeac9c56-aeb1-4179-a21b-02f278f59048&originalTime=0&startTime=1700496000
         *
         * @param appLink
         * @return
         */
        public Builder appLink(String appLink) {
            this.appLink = appLink;
            return this;
        }


        /**
         * 日程组织者日历ID
         * <p> 示例值：feishu.cn_HF9U2MbibE8PPpjro6xjqa@group.calendar.feishu.cn
         *
         * @param organizerCalendarId
         * @return
         */
        public Builder organizerCalendarId(String organizerCalendarId) {
            this.organizerCalendarId = organizerCalendarId;
            return this;
        }


        /**
         * 视频会议信息，仅当日程至少有一位attendee时生效
         * <p> 示例值：
         *
         * @param vchat
         * @return
         */
        public Builder vchat(Vchat vchat) {
            this.vchat = vchat;
            return this;
        }


        /**
         * 日程公开范围，新建日程默认为Default；仅新建日程时对所有参与人生效，之后修改该属性仅对当前身份生效
         * <p> 示例值：
         *
         * @param visibility
         * @return
         */
        public Builder visibility(String visibility) {
            this.visibility = visibility;
            return this;
        }

        /**
         * 日程公开范围，新建日程默认为Default；仅新建日程时对所有参与人生效，之后修改该属性仅对当前身份生效
         * <p> 示例值：
         *
         * @param visibility {@link com.lark.oapi.service.calendar.v4.enums.InstanceEventVisibilityEnum}
         * @return
         */
        public Builder visibility(com.lark.oapi.service.calendar.v4.enums.InstanceEventVisibilityEnum visibility) {
            this.visibility = visibility.getValue();
            return this;
        }


        /**
         * 参与人权限
         * <p> 示例值：
         *
         * @param attendeeAbility
         * @return
         */
        public Builder attendeeAbility(String attendeeAbility) {
            this.attendeeAbility = attendeeAbility;
            return this;
        }

        /**
         * 参与人权限
         * <p> 示例值：
         *
         * @param attendeeAbility {@link com.lark.oapi.service.calendar.v4.enums.InstanceEventAttendeeAbilityEnum}
         * @return
         */
        public Builder attendeeAbility(com.lark.oapi.service.calendar.v4.enums.InstanceEventAttendeeAbilityEnum attendeeAbility) {
            this.attendeeAbility = attendeeAbility.getValue();
            return this;
        }


        /**
         * 日程占用的忙闲状态，新建日程默认为Busy；仅新建日程时对所有参与人生效，之后修改该属性仅对当前身份生效
         * <p> 示例值：
         *
         * @param freeBusyStatus
         * @return
         */
        public Builder freeBusyStatus(String freeBusyStatus) {
            this.freeBusyStatus = freeBusyStatus;
            return this;
        }

        /**
         * 日程占用的忙闲状态，新建日程默认为Busy；仅新建日程时对所有参与人生效，之后修改该属性仅对当前身份生效
         * <p> 示例值：
         *
         * @param freeBusyStatus {@link com.lark.oapi.service.calendar.v4.enums.InstanceEventFreeBusyStatusEnum}
         * @return
         */
        public Builder freeBusyStatus(com.lark.oapi.service.calendar.v4.enums.InstanceEventFreeBusyStatusEnum freeBusyStatus) {
            this.freeBusyStatus = freeBusyStatus.getValue();
            return this;
        }


        /**
         * 日程地点
         * <p> 示例值：
         *
         * @param location
         * @return
         */
        public Builder location(EventLocation location) {
            this.location = location;
            return this;
        }


        /**
         * 日程颜色，颜色RGB值的int32表示。仅对当前身份生效；客户端展示时会映射到色板上最接近的一种颜色；值为0或-1时默认跟随日历颜色。
         * <p> 示例值：0
         *
         * @param color
         * @return
         */
        public Builder color(Integer color) {
            this.color = color;
            return this;
        }


        /**
         * 例外日程的原重复日程的event_id
         * <p> 示例值：75d28f9b-e35c-4230-8a83-4a661497db54_0
         *
         * @param recurringEventId
         * @return
         */
        public Builder recurringEventId(String recurringEventId) {
            this.recurringEventId = recurringEventId;
            return this;
        }


        /**
         * 日程组织者信息
         * <p> 示例值：
         *
         * @param eventOrganizer
         * @return
         */
        public Builder eventOrganizer(EventOrganizer eventOrganizer) {
            this.eventOrganizer = eventOrganizer;
            return this;
        }


        /**
         * 日程参与人信息
         * <p> 示例值：
         *
         * @param attendees
         * @return
         */
        public Builder attendees(CalendarEventAttendee[] attendees) {
            this.attendees = attendees;
            return this;
        }


        public Instance build() {
            return new Instance(this);
        }
    }
}
