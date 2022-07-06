// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;

public class UserOvertimeWork {
    @SerializedName("approval_id")
    private String approvalId;
    @SerializedName("duration")
    private Double duration;
    @SerializedName("unit")
    private Integer unit;
    @SerializedName("category")
    private Integer category;
    @SerializedName("type")
    private Integer type;
    @SerializedName("start_time")
    private String startTime;
    @SerializedName("end_time")
    private String endTime;

    // builder 开始
    public UserOvertimeWork() {
    }

    public UserOvertimeWork(Builder builder) {
        this.approvalId = builder.approvalId;
        this.duration = builder.duration;
        this.unit = builder.unit;
        this.category = builder.category;
        this.type = builder.type;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getApprovalId() {
        return this.approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }

    public Double getDuration() {
        return this.duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Integer getUnit() {
        return this.unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getCategory() {
        return this.category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public static class Builder {
        private String approvalId;
        private Double duration;
        private Integer unit;
        private Integer category;
        private Integer type;
        private String startTime;
        private String endTime;

        public Builder approvalId(String approvalId) {
            this.approvalId = approvalId;
            return this;
        }

        public Builder duration(Double duration) {
            this.duration = duration;
            return this;
        }

        public Builder unit(Integer unit) {
            this.unit = unit;
            return this;
        }

        public Builder unit(com.larksuite.oapi.service.attendance.v1.enums.UnitEnum unit) {
            this.unit = unit.getValue();
            return this;
        }

        public Builder category(Integer category) {
            this.category = category;
            return this;
        }

        public Builder category(com.larksuite.oapi.service.attendance.v1.enums.CategoryEnum category) {
            this.category = category.getValue();
            return this;
        }

        public Builder type(Integer type) {
            this.type = type;
            return this;
        }

        public Builder type(com.larksuite.oapi.service.attendance.v1.enums.TypeEnum type) {
            this.type = type.getValue();
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


        public UserOvertimeWork build() {
            return new UserOvertimeWork(this);
        }
    }
}