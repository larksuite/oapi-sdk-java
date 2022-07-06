// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;

public class QueryUserStatsViewReqBody {
    @SerializedName("locale")
    private String locale;
    @SerializedName("stats_type")
    private String statsType;
    @SerializedName("user_id")
    private String userId;

    // builder 开始
    public QueryUserStatsViewReqBody() {
    }

    public QueryUserStatsViewReqBody(Builder builder) {
        this.locale = builder.locale;
        this.statsType = builder.statsType;
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

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static class Builder {
        private String locale;
        private String statsType;
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

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }


        public QueryUserStatsViewReqBody build() {
            return new QueryUserStatsViewReqBody(this);
        }
    }
}
