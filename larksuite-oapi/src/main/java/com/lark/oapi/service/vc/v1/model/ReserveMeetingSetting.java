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

public class ReserveMeetingSetting {
    /**
     * 会议主题
     * <p> 示例值：my meeting
     */
    @SerializedName("topic")
    private String topic;
    /**
     * 会议权限配置列表，如果存在相同的权限配置项则它们之间为"逻辑或"的关系（即 有一个为true则拥有该权限）
     * <p> 示例值：
     */
    @SerializedName("action_permissions")
    private ReserveActionPermission[] actionPermissions;
    /**
     * 会议初始类型
     * <p> 示例值：1
     */
    @SerializedName("meeting_initial_type")
    private Integer meetingInitialType;
    /**
     * 1v1呼叫相关参数
     * <p> 示例值：
     */
    @SerializedName("call_setting")
    private ReserveCallSetting callSetting;
    /**
     * 使用飞书视频会议时，是否开启自动录制，默认false
     * <p> 示例值：true
     */
    @SerializedName("auto_record")
    private Boolean autoRecord;
    /**
     * 指定主持人列表
     * <p> 示例值：
     */
    @SerializedName("assign_host_list")
    private ReserveAssignHost[] assignHostList;

    // builder 开始
    public ReserveMeetingSetting() {
    }

    public ReserveMeetingSetting(Builder builder) {
        /**
         * 会议主题
         * <p> 示例值：my meeting
         */
        this.topic = builder.topic;
        /**
         * 会议权限配置列表，如果存在相同的权限配置项则它们之间为"逻辑或"的关系（即 有一个为true则拥有该权限）
         * <p> 示例值：
         */
        this.actionPermissions = builder.actionPermissions;
        /**
         * 会议初始类型
         * <p> 示例值：1
         */
        this.meetingInitialType = builder.meetingInitialType;
        /**
         * 1v1呼叫相关参数
         * <p> 示例值：
         */
        this.callSetting = builder.callSetting;
        /**
         * 使用飞书视频会议时，是否开启自动录制，默认false
         * <p> 示例值：true
         */
        this.autoRecord = builder.autoRecord;
        /**
         * 指定主持人列表
         * <p> 示例值：
         */
        this.assignHostList = builder.assignHostList;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public ReserveActionPermission[] getActionPermissions() {
        return this.actionPermissions;
    }

    public void setActionPermissions(ReserveActionPermission[] actionPermissions) {
        this.actionPermissions = actionPermissions;
    }

    public Integer getMeetingInitialType() {
        return this.meetingInitialType;
    }

    public void setMeetingInitialType(Integer meetingInitialType) {
        this.meetingInitialType = meetingInitialType;
    }

    public ReserveCallSetting getCallSetting() {
        return this.callSetting;
    }

    public void setCallSetting(ReserveCallSetting callSetting) {
        this.callSetting = callSetting;
    }

    public Boolean getAutoRecord() {
        return this.autoRecord;
    }

    public void setAutoRecord(Boolean autoRecord) {
        this.autoRecord = autoRecord;
    }

    public ReserveAssignHost[] getAssignHostList() {
        return this.assignHostList;
    }

    public void setAssignHostList(ReserveAssignHost[] assignHostList) {
        this.assignHostList = assignHostList;
    }

    public static class Builder {
        /**
         * 会议主题
         * <p> 示例值：my meeting
         */
        private String topic;
        /**
         * 会议权限配置列表，如果存在相同的权限配置项则它们之间为"逻辑或"的关系（即 有一个为true则拥有该权限）
         * <p> 示例值：
         */
        private ReserveActionPermission[] actionPermissions;
        /**
         * 会议初始类型
         * <p> 示例值：1
         */
        private Integer meetingInitialType;
        /**
         * 1v1呼叫相关参数
         * <p> 示例值：
         */
        private ReserveCallSetting callSetting;
        /**
         * 使用飞书视频会议时，是否开启自动录制，默认false
         * <p> 示例值：true
         */
        private Boolean autoRecord;
        /**
         * 指定主持人列表
         * <p> 示例值：
         */
        private ReserveAssignHost[] assignHostList;

        /**
         * 会议主题
         * <p> 示例值：my meeting
         *
         * @param topic
         * @return
         */
        public Builder topic(String topic) {
            this.topic = topic;
            return this;
        }


        /**
         * 会议权限配置列表，如果存在相同的权限配置项则它们之间为"逻辑或"的关系（即 有一个为true则拥有该权限）
         * <p> 示例值：
         *
         * @param actionPermissions
         * @return
         */
        public Builder actionPermissions(ReserveActionPermission[] actionPermissions) {
            this.actionPermissions = actionPermissions;
            return this;
        }


        /**
         * 会议初始类型
         * <p> 示例值：1
         *
         * @param meetingInitialType
         * @return
         */
        public Builder meetingInitialType(Integer meetingInitialType) {
            this.meetingInitialType = meetingInitialType;
            return this;
        }

        /**
         * 会议初始类型
         * <p> 示例值：1
         *
         * @param meetingInitialType {@link com.lark.oapi.service.vc.v1.enums.ReserveMeetingSettingMeetingInitialTypeEnum}
         * @return
         */
        public Builder meetingInitialType(com.lark.oapi.service.vc.v1.enums.ReserveMeetingSettingMeetingInitialTypeEnum meetingInitialType) {
            this.meetingInitialType = meetingInitialType.getValue();
            return this;
        }


        /**
         * 1v1呼叫相关参数
         * <p> 示例值：
         *
         * @param callSetting
         * @return
         */
        public Builder callSetting(ReserveCallSetting callSetting) {
            this.callSetting = callSetting;
            return this;
        }


        /**
         * 使用飞书视频会议时，是否开启自动录制，默认false
         * <p> 示例值：true
         *
         * @param autoRecord
         * @return
         */
        public Builder autoRecord(Boolean autoRecord) {
            this.autoRecord = autoRecord;
            return this;
        }


        /**
         * 指定主持人列表
         * <p> 示例值：
         *
         * @param assignHostList
         * @return
         */
        public Builder assignHostList(ReserveAssignHost[] assignHostList) {
            this.assignHostList = assignHostList;
            return this;
        }


        public ReserveMeetingSetting build() {
            return new ReserveMeetingSetting(this);
        }
    }
}
