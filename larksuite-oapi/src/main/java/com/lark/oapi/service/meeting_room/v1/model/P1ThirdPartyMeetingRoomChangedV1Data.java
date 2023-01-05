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

package com.lark.oapi.service.meeting_room.v1.model;

import com.google.gson.annotations.SerializedName;

public class P1ThirdPartyMeetingRoomChangedV1Data {

    @SerializedName("type")
    private String type;
    @SerializedName("app_id")
    private String appId;
    @SerializedName("tenant_key")
    private String tenantKey;
    @SerializedName("event_time")
    private String eventTime;
    @SerializedName("uid")
    private String uid;
    @SerializedName("original_time")
    private int originalTime;
    @SerializedName("start")
    private P1EventTimeV1 start;
    @SerializedName("end")
    private P1EventTimeV1 end;
    @SerializedName("meeting_rooms")
    private P1MeetingRoomV1[] meetingRooms;
    @SerializedName("organizer")
    private P1OrganizerV1 organizer;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTenantKey() {
        return tenantKey;
    }

    public void setTenantKey(String tenantKey) {
        this.tenantKey = tenantKey;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getOriginalTime() {
        return originalTime;
    }

    public void setOriginalTime(int originalTime) {
        this.originalTime = originalTime;
    }

    public P1EventTimeV1 getStart() {
        return start;
    }

    public void setStart(
            P1EventTimeV1 start) {
        this.start = start;
    }

    public P1EventTimeV1 getEnd() {
        return end;
    }

    public void setEnd(
            P1EventTimeV1 end) {
        this.end = end;
    }

    public P1MeetingRoomV1[] getMeetingRooms() {
        return meetingRooms;
    }

    public void setMeetingRooms(
            P1MeetingRoomV1[] meetingRooms) {
        this.meetingRooms = meetingRooms;
    }

    public P1OrganizerV1 getOrganizer() {
        return organizer;
    }

    public void setOrganizer(
            P1OrganizerV1 organizer) {
        this.organizer = organizer;
    }

    public static class P1EventTimeV1 {

        @SerializedName("time_stamp")
        private String timeStamp;

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }
    }

    public static class P1MeetingRoomV1 {

        @SerializedName("open_id")
        private String openId;

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }
    }

    public static class P1OrganizerV1 {

        @SerializedName("open_id")
        private String openId;
        @SerializedName("user_id")
        private String userId;

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
