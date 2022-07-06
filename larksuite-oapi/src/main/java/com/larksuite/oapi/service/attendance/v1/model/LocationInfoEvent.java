// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;

public class LocationInfoEvent {
    @SerializedName("coord")
    private Coordinate coord;

    // builder 开始
    public LocationInfoEvent() {
    }

    public LocationInfoEvent(Builder builder) {
        this.coord = builder.coord;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Coordinate getCoord() {
        return this.coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public static class Builder {
        private Coordinate coord;

        public Builder coord(Coordinate coord) {
            this.coord = coord;
            return this;
        }


        public LocationInfoEvent build() {
            return new LocationInfoEvent(this);
        }
    }
}