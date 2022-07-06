// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class TripGroupSchedule {
    @SerializedName("trip_start_time")
    private String tripStartTime;
    @SerializedName("trip_end_time")
    private String tripEndTime;
    @SerializedName("trip_interval")
    private String tripInterval;
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

    // builder 开始
    public TripGroupSchedule() {
    }

    public TripGroupSchedule(Builder builder) {
        this.tripStartTime = builder.tripStartTime;
        this.tripEndTime = builder.tripEndTime;
        this.tripInterval = builder.tripInterval;
        this.departure = builder.departure;
        this.destination = builder.destination;
        this.transportation = builder.transportation;
        this.tripType = builder.tripType;
        this.remark = builder.remark;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getTripStartTime() {
        return this.tripStartTime;
    }

    public void setTripStartTime(String tripStartTime) {
        this.tripStartTime = tripStartTime;
    }

    public String getTripEndTime() {
        return this.tripEndTime;
    }

    public void setTripEndTime(String tripEndTime) {
        this.tripEndTime = tripEndTime;
    }

    public String getTripInterval() {
        return this.tripInterval;
    }

    public void setTripInterval(String tripInterval) {
        this.tripInterval = tripInterval;
    }

    public String getDeparture() {
        return this.departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTransportation() {
        return this.transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public String getTripType() {
        return this.tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static class Builder {
        private String tripStartTime;
        private String tripEndTime;
        private String tripInterval;
        private String departure;
        private String destination;
        private String transportation;
        private String tripType;
        private String remark;

        public Builder tripStartTime(String tripStartTime) {
            this.tripStartTime = tripStartTime;
            return this;
        }

        public Builder tripEndTime(String tripEndTime) {
            this.tripEndTime = tripEndTime;
            return this;
        }

        public Builder tripInterval(String tripInterval) {
            this.tripInterval = tripInterval;
            return this;
        }

        public Builder departure(String departure) {
            this.departure = departure;
            return this;
        }

        public Builder destination(String destination) {
            this.destination = destination;
            return this;
        }

        public Builder transportation(String transportation) {
            this.transportation = transportation;
            return this;
        }

        public Builder tripType(String tripType) {
            this.tripType = tripType;
            return this;
        }

        public Builder remark(String remark) {
            this.remark = remark;
            return this;
        }


        public TripGroupSchedule build() {
            return new TripGroupSchedule(this);
        }
    }
}
