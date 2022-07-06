// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;

public class Area {
    @SerializedName("type")
    private String type;
    @SerializedName("center")
    private Coordinate center;
    @SerializedName("radius")
    private Long radius;
    @SerializedName("coords")
    private Coordinate[] coords;

    // builder 开始
    public Area() {
    }

    public Area(Builder builder) {
        this.type = builder.type;
        this.center = builder.center;
        this.radius = builder.radius;
        this.coords = builder.coords;
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

    public Coordinate getCenter() {
        return this.center;
    }

    public void setCenter(Coordinate center) {
        this.center = center;
    }

    public Long getRadius() {
        return this.radius;
    }

    public void setRadius(Long radius) {
        this.radius = radius;
    }

    public Coordinate[] getCoords() {
        return this.coords;
    }

    public void setCoords(Coordinate[] coords) {
        this.coords = coords;
    }

    public static class Builder {
        private String type;
        private Coordinate center;
        private Long radius;
        private Coordinate[] coords;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder center(Coordinate center) {
            this.center = center;
            return this;
        }

        public Builder radius(Long radius) {
            this.radius = radius;
            return this;
        }

        public Builder coords(Coordinate[] coords) {
            this.coords = coords;
            return this;
        }


        public Area build() {
            return new Area(this);
        }
    }
}