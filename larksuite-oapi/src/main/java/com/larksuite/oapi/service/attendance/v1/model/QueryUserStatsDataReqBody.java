// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;

public class QueryUserStatsDataReqBody {
    @SerializedName("locale")
    private String locale;
    @SerializedName("stats_type")
    private String statsType;
    @SerializedName("start_date")
    private Integer startDate;
    @SerializedName("end_date")
    private Integer endDate;
    @SerializedName("user_ids")
    private String[] userIds;
    @SerializedName("need_history")
    private Boolean needHistory;
    @SerializedName("current_group_only")
    private Boolean currentGroupOnly;
    @SerializedName("user_id")
    private String userId;

    // builder 开始
    public QueryUserStatsDataReqBody() {
    }

    public QueryUserStatsDataReqBody(Builder builder) {
        this.locale = builder.locale;
        this.statsType = builder.statsType;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.userIds = builder.userIds;
        this.needHistory = builder.needHistory;
        this.currentGroupOnly = builder.currentGroupOnly;
        this.userId = builder.userId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getStatsType() {
        return this.statsType;
    }

    public void setStatsType(String statsType) {
        this.statsType = statsType;
    }

    public Integer getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public String[] getUserIds() {
        return this.userIds;
    }

    public void setUserIds(String[] userIds) {
        this.userIds = userIds;
    }

    public Boolean getNeedHistory() {
        return this.needHistory;
    }

    public void setNeedHistory(Boolean needHistory) {
        this.needHistory = needHistory;
    }

    public Boolean getCurrentGroupOnly() {
        return this.currentGroupOnly;
    }

    public void setCurrentGroupOnly(Boolean currentGroupOnly) {
        this.currentGroupOnly = currentGroupOnly;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static class Builder {
        private String locale;
        private String statsType;
        private Integer startDate;
        private Integer endDate;
        private String[] userIds;
        private Boolean needHistory;
        private Boolean currentGroupOnly;
        private String userId;

        public Builder locale(String locale) {
            this.locale = locale;
            return this;
        }

        public Builder locale(com.larksuite.oapi.service.attendance.v1.enums.LocaleEnum locale) {
            this.locale = locale.getValue();
            return this;
        }

        public Builder statsType(String statsType) {
            this.statsType = statsType;
            return this;
        }

        public Builder statsType(com.larksuite.oapi.service.attendance.v1.enums.StatsTypeEnum statsType) {
            this.statsType = statsType.getValue();
            return this;
        }

        public Builder startDate(Integer startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(Integer endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder userIds(String[] userIds) {
            this.userIds = userIds;
            return this;
        }

        public Builder needHistory(Boolean needHistory) {
            this.needHistory = needHistory;
            return this;
        }

        public Builder currentGroupOnly(Boolean currentGroupOnly) {
            this.currentGroupOnly = currentGroupOnly;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }


        public QueryUserStatsDataReqBody build() {
            return new QueryUserStatsDataReqBody(this);
        }
    }
}
