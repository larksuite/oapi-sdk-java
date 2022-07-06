// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class TripGroup {
    @SerializedName("type")
    private String type;
    @SerializedName("instance_code")
    private String instanceCode;
    @SerializedName("start_user")
    private User startUser;
    @SerializedName("start_time")
    private String startTime;
    @SerializedName("end_time")
    private String endTime;
    @SerializedName("trip_interval")
    private String tripInterval;
    @SerializedName("trip_reason")
    private String tripReason;
    @SerializedName("schedules")
    private TripGroupSchedule[] schedules;
    @SerializedName("trip_peers")
    private User[] tripPeers;

    // builder 开始
    public TripGroup() {
    }

    public TripGroup(Builder builder) {
        this.type = builder.type;
        this.instanceCode = builder.instanceCode;
        this.startUser = builder.startUser;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.tripInterval = builder.tripInterval;
        this.tripReason = builder.tripReason;
        this.schedules = builder.schedules;
        this.tripPeers = builder.tripPeers;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInstanceCode() {
        return this.instanceCode;
    }

    public void setInstanceCode(String instanceCode) {
        this.instanceCode = instanceCode;
    }

    public User getStartUser() {
        return this.startUser;
    }

    public void setStartUser(User startUser) {
        this.startUser = startUser;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTripInterval() {
        return this.tripInterval;
    }

    public void setTripInterval(String tripInterval) {
        this.tripInterval = tripInterval;
    }

    public String getTripReason() {
        return this.tripReason;
    }

    public void setTripReason(String tripReason) {
        this.tripReason = tripReason;
    }

    public TripGroupSchedule[] getSchedules() {
        return this.schedules;
    }

    public void setSchedules(TripGroupSchedule[] schedules) {
        this.schedules = schedules;
    }

    public User[] getTripPeers() {
        return this.tripPeers;
    }

    public void setTripPeers(User[] tripPeers) {
        this.tripPeers = tripPeers;
    }

    public static class Builder {
        private String type;
        private String instanceCode;
        private User startUser;
        private String startTime;
        private String endTime;
        private String tripInterval;
        private String tripReason;
        private TripGroupSchedule[] schedules;
        private User[] tripPeers;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder instanceCode(String instanceCode) {
            this.instanceCode = instanceCode;
            return this;
        }

        public Builder startUser(User startUser) {
            this.startUser = startUser;
            return this;
        }

        public Builder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder tripInterval(String tripInterval) {
            this.tripInterval = tripInterval;
            return this;
        }

        public Builder tripReason(String tripReason) {
            this.tripReason = tripReason;
            return this;
        }

        public Builder schedules(TripGroupSchedule[] schedules) {
            this.schedules = schedules;
            return this;
        }

        public Builder tripPeers(User[] tripPeers) {
            this.tripPeers = tripPeers;
            return this;
        }


        public TripGroup build() {
            return new TripGroup(this);
        }
    }
}