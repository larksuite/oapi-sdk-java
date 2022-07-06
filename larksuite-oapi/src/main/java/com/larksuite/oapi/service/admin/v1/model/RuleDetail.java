// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.admin.v1.model;

import com.google.gson.annotations.SerializedName;

public class RuleDetail {
    @SerializedName("effective_time")
    private Long effectiveTime;
    @SerializedName("expiration_time")
    private Long expirationTime;
    @SerializedName("anniversary")
    private Integer anniversary;
    @SerializedName("effective_period")
    private Integer effectivePeriod;

    // builder 开始
    public RuleDetail() {
    }

    public RuleDetail(Builder builder) {
        this.effectiveTime = builder.effectiveTime;
        this.expirationTime = builder.expirationTime;
        this.anniversary = builder.anniversary;
        this.effectivePeriod = builder.effectivePeriod;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getEffectiveTime() {
        return this.effectiveTime;
    }

    public void setEffectiveTime(Long effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Long getExpirationTime() {
        return this.expirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Integer getAnniversary() {
        return this.anniversary;
    }

    public void setAnniversary(Integer anniversary) {
        this.anniversary = anniversary;
    }

    public Integer getEffectivePeriod() {
        return this.effectivePeriod;
    }

    public void setEffectivePeriod(Integer effectivePeriod) {
        this.effectivePeriod = effectivePeriod;
    }

    public static class Builder {
        private Long effectiveTime;
        private Long expirationTime;
        private Integer anniversary;
        private Integer effectivePeriod;

        public Builder effectiveTime(Long effectiveTime) {
            this.effectiveTime = effectiveTime;
            return this;
        }

        public Builder expirationTime(Long expirationTime) {
            this.expirationTime = expirationTime;
            return this;
        }

        public Builder anniversary(Integer anniversary) {
            this.anniversary = anniversary;
            return this;
        }

        public Builder effectivePeriod(Integer effectivePeriod) {
            this.effectivePeriod = effectivePeriod;
            return this;
        }

        public Builder effectivePeriod(com.larksuite.oapi.service.admin.v1.enums.EffectivePeriodEnum effectivePeriod) {
            this.effectivePeriod = effectivePeriod.getValue();
            return this;
        }


        public RuleDetail build() {
            return new RuleDetail(this);
        }
    }
}
