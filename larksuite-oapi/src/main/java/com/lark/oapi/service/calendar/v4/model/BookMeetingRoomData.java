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

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.calendar.v4.enums.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.response.BaseResponse;

public class BookMeetingRoomData {
    /**
     * 会议室ID
     * <p> 示例值：none
     */
    @SerializedName("meeting_room_id")
    private String meetingRoomId;
    /**
     * 返回给ai的会议室描述数据
     * <p> 示例值：none
     */
    @SerializedName("hint")
    private String hint;
    /**
     * 日历实体列表
     * <p> 示例值：
     */
    @SerializedName("rooms")
    private RoomMeta[] rooms;
    /**
     * 重复性日程规则
     * <p> 示例值：none
     */
    @SerializedName("recurrence_rule")
    private String recurrenceRule;

    // builder 开始
    public BookMeetingRoomData() {
    }

    public BookMeetingRoomData(Builder builder) {
        /**
         * 会议室ID
         * <p> 示例值：none
         */
        this.meetingRoomId = builder.meetingRoomId;
        /**
         * 返回给ai的会议室描述数据
         * <p> 示例值：none
         */
        this.hint = builder.hint;
        /**
         * 日历实体列表
         * <p> 示例值：
         */
        this.rooms = builder.rooms;
        /**
         * 重复性日程规则
         * <p> 示例值：none
         */
        this.recurrenceRule = builder.recurrenceRule;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getMeetingRoomId() {
        return this.meetingRoomId;
    }

    public void setMeetingRoomId(String meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }

    public String getHint() {
        return this.hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public RoomMeta[] getRooms() {
        return this.rooms;
    }

    public void setRooms(RoomMeta[] rooms) {
        this.rooms = rooms;
    }

    public String getRecurrenceRule() {
        return this.recurrenceRule;
    }

    public void setRecurrenceRule(String recurrenceRule) {
        this.recurrenceRule = recurrenceRule;
    }

    public static class Builder {
        /**
         * 会议室ID
         * <p> 示例值：none
         */
        private String meetingRoomId;
        /**
         * 返回给ai的会议室描述数据
         * <p> 示例值：none
         */
        private String hint;
        /**
         * 日历实体列表
         * <p> 示例值：
         */
        private RoomMeta[] rooms;
        /**
         * 重复性日程规则
         * <p> 示例值：none
         */
        private String recurrenceRule;

        /**
         * 会议室ID
         * <p> 示例值：none
         *
         * @param meetingRoomId
         * @return
         */
        public Builder meetingRoomId(String meetingRoomId) {
            this.meetingRoomId = meetingRoomId;
            return this;
        }


        /**
         * 返回给ai的会议室描述数据
         * <p> 示例值：none
         *
         * @param hint
         * @return
         */
        public Builder hint(String hint) {
            this.hint = hint;
            return this;
        }


        /**
         * 日历实体列表
         * <p> 示例值：
         *
         * @param rooms
         * @return
         */
        public Builder rooms(RoomMeta[] rooms) {
            this.rooms = rooms;
            return this;
        }


        /**
         * 重复性日程规则
         * <p> 示例值：none
         *
         * @param recurrenceRule
         * @return
         */
        public Builder recurrenceRule(String recurrenceRule) {
            this.recurrenceRule = recurrenceRule;
            return this;
        }


        public BookMeetingRoomData build() {
            return new BookMeetingRoomData(this);
        }
    }
}
