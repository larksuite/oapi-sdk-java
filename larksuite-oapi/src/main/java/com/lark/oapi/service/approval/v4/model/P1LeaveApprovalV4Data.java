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

package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class P1LeaveApprovalV4Data {

    @SerializedName("type")
    private String type;
    @SerializedName("app_id")
    private String appId;
    @SerializedName("tenant_key")
    private String tenantKey;
    @SerializedName("instance_code")
    private String instanceCode;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("open_id")
    private String openId;
    @SerializedName("origin_instance_code")
    private String originInstanceCode;
    @SerializedName("start_time")
    private long startTime;
    @SerializedName("end_time")
    private long endTime;

    @SerializedName("leave_feeding_arrive_late")
    private long leaveFeedingArriveLate;
    @SerializedName("leave_feeding_leave_early")
    private long leaveFeedingLeaveEarly;
    @SerializedName("leave_feeding_rest_daily")
    private long leaveFeedingRestDaily;


    @SerializedName("leave_name")
    private String leaveName;
    @SerializedName("leave_unit")
    private String leaveUnit;
    @SerializedName("leave_start_time")
    private String leaveStartTime;
    @SerializedName("leave_end_time")
    private String leaveEndTime;
    @SerializedName("leave_interval")
    private long leaveInterval;
    @SerializedName("leave_reason")
    private String leaveReason;
    @SerializedName("i18n_resources")
    private P1LeaveApprovalI18nResourceV4[] i18nResources;

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

    public String getInstanceCode() {
        return instanceCode;
    }

    public void setInstanceCode(String instanceCode) {
        this.instanceCode = instanceCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOriginInstanceCode() {
        return originInstanceCode;
    }

    public void setOriginInstanceCode(String originInstanceCode) {
        this.originInstanceCode = originInstanceCode;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getLeaveFeedingArriveLate() {
        return leaveFeedingArriveLate;
    }

    public void setLeaveFeedingArriveLate(long leaveFeedingArriveLate) {
        this.leaveFeedingArriveLate = leaveFeedingArriveLate;
    }

    public long getLeaveFeedingLeaveEarly() {
        return leaveFeedingLeaveEarly;
    }

    public void setLeaveFeedingLeaveEarly(long leaveFeedingLeaveEarly) {
        this.leaveFeedingLeaveEarly = leaveFeedingLeaveEarly;
    }

    public long getLeaveFeedingRestDaily() {
        return leaveFeedingRestDaily;
    }

    public void setLeaveFeedingRestDaily(long leaveFeedingRestDaily) {
        this.leaveFeedingRestDaily = leaveFeedingRestDaily;
    }

    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    public String getLeaveUnit() {
        return leaveUnit;
    }

    public void setLeaveUnit(String leaveUnit) {
        this.leaveUnit = leaveUnit;
    }

    public String getLeaveStartTime() {
        return leaveStartTime;
    }

    public void setLeaveStartTime(String leaveStartTime) {
        this.leaveStartTime = leaveStartTime;
    }

    public String getLeaveEndTime() {
        return leaveEndTime;
    }

    public void setLeaveEndTime(String leaveEndTime) {
        this.leaveEndTime = leaveEndTime;
    }

    public long getLeaveInterval() {
        return leaveInterval;
    }

    public void setLeaveInterval(long leaveInterval) {
        this.leaveInterval = leaveInterval;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public P1LeaveApprovalI18nResourceV4[] getI18nResources() {
        return i18nResources;
    }

    public void setI18nResources(
            P1LeaveApprovalI18nResourceV4[] i18nResources) {
        this.i18nResources = i18nResources;
    }

    public static class P1LeaveApprovalI18nResourceV4 {

        @SerializedName("locale")
        private String locale;
        @SerializedName("is_default")
        private boolean isDefault;
        @SerializedName("texts")
        private Map<String, String> texts;

        public String getLocale() {
            return locale;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        public boolean isDefault() {
            return isDefault;
        }

        public void setDefault(boolean aDefault) {
            isDefault = aDefault;
        }

        public Map<String, String> getTexts() {
            return texts;
        }

        public void setTexts(Map<String, String> texts) {
            this.texts = texts;
        }
    }
}
