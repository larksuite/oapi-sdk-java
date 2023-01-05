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

public class P1TripApprovalV4Data {

    @SerializedName("type")
    private String type;
    @SerializedName("app_id")
    private String appId;
    @SerializedName("tenant_key")
    private String tenantKey;
    @SerializedName("instance_code")
    private String instanceCode;
    @SerializedName("open_id")
    private String openId;
    @SerializedName("employee_id")
    private String employeeId;
    @SerializedName("start_time")
    private long startTime;
    @SerializedName("end_time")
    private long endTime;
    @SerializedName("schedules")
    private P1TripApprovalScheduleV4[] schedules;
    @SerializedName("trip_interval")
    private long tripInterval;
    @SerializedName("trip_reason")
    private String tripReason;
    @SerializedName("trip_peers")
    private String[] tripPeers;

    public P1TripApprovalScheduleV4[] getSchedules() {
        return schedules;
    }

    public void setSchedules(
            P1TripApprovalScheduleV4[] schedules) {
        this.schedules = schedules;
    }

    public long getTripInterval() {
        return tripInterval;
    }

    public void setTripInterval(long tripInterval) {
        this.tripInterval = tripInterval;
    }

    public String getTripReason() {
        return tripReason;
    }

    public void setTripReason(String tripReason) {
        this.tripReason = tripReason;
    }

    public String[] getTripPeers() {
        return tripPeers;
    }

    public void setTripPeers(String[] tripPeers) {
        this.tripPeers = tripPeers;
    }

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public static class P1TripApprovalScheduleV4 {

        @SerializedName("trip_start_time")
        private String tripStartTime;
        @SerializedName("trip_end_time")
        private String tripEndTime;
        @SerializedName("trip_interval")
        private long tripInterval;
        @SerializedName("departure")
        private String departure;
        @SerializedName("destination")
        private String destination;
        @SerializedName("transportation")
        private String transportation;
        @SerializedName("trip_type")
        private String tripType;
        @SerializedName("remark")
        private String remark;

        public String getTripStartTime() {
            return tripStartTime;
        }

        public void setTripStartTime(String tripStartTime) {
            this.tripStartTime = tripStartTime;
        }

        public String getTripEndTime() {
            return tripEndTime;
        }

        public void setTripEndTime(String tripEndTime) {
            this.tripEndTime = tripEndTime;
        }

        public long getTripInterval() {
            return tripInterval;
        }

        public void setTripInterval(long tripInterval) {
            this.tripInterval = tripInterval;
        }

        public String getDeparture() {
            return departure;
        }

        public void setDeparture(String departure) {
            this.departure = departure;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getTransportation() {
            return transportation;
        }

        public void setTransportation(String transportation) {
            this.transportation = transportation;
        }

        public String getTripType() {
            return tripType;
        }

        public void setTripType(String tripType) {
            this.tripType = tripType;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

    }
}
