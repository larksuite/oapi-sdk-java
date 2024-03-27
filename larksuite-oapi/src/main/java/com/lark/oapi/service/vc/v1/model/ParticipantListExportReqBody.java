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

package com.lark.oapi.service.vc.v1.model;

import com.google.gson.annotations.SerializedName;

public class ParticipantListExportReqBody {
    /**
     * 会议开始时间（unix时间，单位sec）
     * <p> 示例值：1655276858
     */
    @SerializedName("meeting_start_time")
    private String meetingStartTime;
    /**
     * 会议结束时间（unix时间，单位sec）
     * <p> 示例值：1655276858
     */
    @SerializedName("meeting_end_time")
    private String meetingEndTime;
    /**
     * 会议状态（不传默认为已结束会议）
     * <p> 示例值：2
     */
    @SerializedName("meeting_status")
    private Integer meetingStatus;
    /**
     * 9位会议号
     * <p> 示例值：123456789
     */
    @SerializedName("meeting_no")
    private String meetingNo;
    /**
     * 按参会Lark用户筛选（最多一个筛选条件）
     * <p> 示例值：ou_3ec3f6a28a0d08c45d895276e8e5e19b
     */
    @SerializedName("user_id")
    private String userId;
    /**
     * 按参会Rooms筛选（最多一个筛选条件）
     * <p> 示例值：omm_eada1d61a550955240c28757e7dec3af
     */
    @SerializedName("room_id")
    private String roomId;

    // builder 开始
    public ParticipantListExportReqBody() {
    }

    public ParticipantListExportReqBody(Builder builder) {
        /**
         * 会议开始时间（unix时间，单位sec）
         * <p> 示例值：1655276858
         */
        this.meetingStartTime = builder.meetingStartTime;
        /**
         * 会议结束时间（unix时间，单位sec）
         * <p> 示例值：1655276858
         */
        this.meetingEndTime = builder.meetingEndTime;
        /**
         * 会议状态（不传默认为已结束会议）
         * <p> 示例值：2
         */
        this.meetingStatus = builder.meetingStatus;
        /**
         * 9位会议号
         * <p> 示例值：123456789
         */
        this.meetingNo = builder.meetingNo;
        /**
         * 按参会Lark用户筛选（最多一个筛选条件）
         * <p> 示例值：ou_3ec3f6a28a0d08c45d895276e8e5e19b
         */
        this.userId = builder.userId;
        /**
         * 按参会Rooms筛选（最多一个筛选条件）
         * <p> 示例值：omm_eada1d61a550955240c28757e7dec3af
         */
        this.roomId = builder.roomId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getMeetingStartTime() {
        return this.meetingStartTime;
    }

    public void setMeetingStartTime(String meetingStartTime) {
        this.meetingStartTime = meetingStartTime;
    }

    public String getMeetingEndTime() {
        return this.meetingEndTime;
    }

    public void setMeetingEndTime(String meetingEndTime) {
        this.meetingEndTime = meetingEndTime;
    }

    public Integer getMeetingStatus() {
        return this.meetingStatus;
    }

    public void setMeetingStatus(Integer meetingStatus) {
        this.meetingStatus = meetingStatus;
    }

    public String getMeetingNo() {
        return this.meetingNo;
    }

    public void setMeetingNo(String meetingNo) {
        this.meetingNo = meetingNo;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public static class Builder {
        /**
         * 会议开始时间（unix时间，单位sec）
         * <p> 示例值：1655276858
         */
        private String meetingStartTime;
        /**
         * 会议结束时间（unix时间，单位sec）
         * <p> 示例值：1655276858
         */
        private String meetingEndTime;
        /**
         * 会议状态（不传默认为已结束会议）
         * <p> 示例值：2
         */
        private Integer meetingStatus;
        /**
         * 9位会议号
         * <p> 示例值：123456789
         */
        private String meetingNo;
        /**
         * 按参会Lark用户筛选（最多一个筛选条件）
         * <p> 示例值：ou_3ec3f6a28a0d08c45d895276e8e5e19b
         */
        private String userId;
        /**
         * 按参会Rooms筛选（最多一个筛选条件）
         * <p> 示例值：omm_eada1d61a550955240c28757e7dec3af
         */
        private String roomId;

        /**
         * 会议开始时间（unix时间，单位sec）
         * <p> 示例值：1655276858
         *
         * @param meetingStartTime
         * @return
         */
        public Builder meetingStartTime(String meetingStartTime) {
            this.meetingStartTime = meetingStartTime;
            return this;
        }


        /**
         * 会议结束时间（unix时间，单位sec）
         * <p> 示例值：1655276858
         *
         * @param meetingEndTime
         * @return
         */
        public Builder meetingEndTime(String meetingEndTime) {
            this.meetingEndTime = meetingEndTime;
            return this;
        }


        /**
         * 会议状态（不传默认为已结束会议）
         * <p> 示例值：2
         *
         * @param meetingStatus
         * @return
         */
        public Builder meetingStatus(Integer meetingStatus) {
            this.meetingStatus = meetingStatus;
            return this;
        }

        /**
         * 会议状态（不传默认为已结束会议）
         * <p> 示例值：2
         *
         * @param meetingStatus {@link com.lark.oapi.service.vc.v1.enums.ParticipantListExportMeetingStatusTypeEnum}
         * @return
         */
        public Builder meetingStatus(com.lark.oapi.service.vc.v1.enums.ParticipantListExportMeetingStatusTypeEnum meetingStatus) {
            this.meetingStatus = meetingStatus.getValue();
            return this;
        }


        /**
         * 9位会议号
         * <p> 示例值：123456789
         *
         * @param meetingNo
         * @return
         */
        public Builder meetingNo(String meetingNo) {
            this.meetingNo = meetingNo;
            return this;
        }


        /**
         * 按参会Lark用户筛选（最多一个筛选条件）
         * <p> 示例值：ou_3ec3f6a28a0d08c45d895276e8e5e19b
         *
         * @param userId
         * @return
         */
        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }


        /**
         * 按参会Rooms筛选（最多一个筛选条件）
         * <p> 示例值：omm_eada1d61a550955240c28757e7dec3af
         *
         * @param roomId
         * @return
         */
        public Builder roomId(String roomId) {
            this.roomId = roomId;
            return this;
        }


        public ParticipantListExportReqBody build() {
            return new ParticipantListExportReqBody(this);
        }
    }
}
