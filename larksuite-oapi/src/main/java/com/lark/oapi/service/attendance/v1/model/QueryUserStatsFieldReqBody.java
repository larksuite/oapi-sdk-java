// Code generated by lark suite oapi sdk gen
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

package com.lark.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;

public class QueryUserStatsFieldReqBody {
    /**
     * 语言类型
     * <p> 示例值：zh
     */
    @SerializedName("locale")
    private String locale;
    /**
     * 统计类型
     * <p> 示例值：daily
     */
    @SerializedName("stats_type")
    private String statsType;
    /**
     * 开始时间
     * <p> 示例值：20210316
     */
    @SerializedName("start_date")
    private Integer startDate;
    /**
     * 结束时间（时间间隔不超过 40 天）
     * <p> 示例值：20210323
     */
    @SerializedName("end_date")
    private Integer endDate;

    // builder 开始
    public QueryUserStatsFieldReqBody() {
    }

    public QueryUserStatsFieldReqBody(Builder builder) {
        /**
         * 语言类型
         * <p> 示例值：zh
         */
        this.locale = builder.locale;
        /**
         * 统计类型
         * <p> 示例值：daily
         */
        this.statsType = builder.statsType;
        /**
         * 开始时间
         * <p> 示例值：20210316
         */
        this.startDate = builder.startDate;
        /**
         * 结束时间（时间间隔不超过 40 天）
         * <p> 示例值：20210323
         */
        this.endDate = builder.endDate;
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

    public static class Builder {
        /**
         * 语言类型
         * <p> 示例值：zh
         */
        private String locale;
        /**
         * 统计类型
         * <p> 示例值：daily
         */
        private String statsType;
        /**
         * 开始时间
         * <p> 示例值：20210316
         */
        private Integer startDate;
        /**
         * 结束时间（时间间隔不超过 40 天）
         * <p> 示例值：20210323
         */
        private Integer endDate;

        /**
         * 语言类型
         * <p> 示例值：zh
         *
         * @param locale
         * @return
         */
        public Builder locale(String locale) {
            this.locale = locale;
            return this;
        }

        /**
         * 语言类型
         * <p> 示例值：zh
         *
         * @param locale {@link com.lark.oapi.service.attendance.v1.enums.QueryUserStatsFieldLocaleEnum}
         * @return
         */
        public Builder locale(com.lark.oapi.service.attendance.v1.enums.QueryUserStatsFieldLocaleEnum locale) {
            this.locale = locale.getValue();
            return this;
        }


        /**
         * 统计类型
         * <p> 示例值：daily
         *
         * @param statsType
         * @return
         */
        public Builder statsType(String statsType) {
            this.statsType = statsType;
            return this;
        }

        /**
         * 统计类型
         * <p> 示例值：daily
         *
         * @param statsType {@link com.lark.oapi.service.attendance.v1.enums.QueryUserStatsFieldStatsTypeEnum}
         * @return
         */
        public Builder statsType(com.lark.oapi.service.attendance.v1.enums.QueryUserStatsFieldStatsTypeEnum statsType) {
            this.statsType = statsType.getValue();
            return this;
        }


        /**
         * 开始时间
         * <p> 示例值：20210316
         *
         * @param startDate
         * @return
         */
        public Builder startDate(Integer startDate) {
            this.startDate = startDate;
            return this;
        }


        /**
         * 结束时间（时间间隔不超过 40 天）
         * <p> 示例值：20210323
         *
         * @param endDate
         * @return
         */
        public Builder endDate(Integer endDate) {
            this.endDate = endDate;
            return this;
        }


        public QueryUserStatsFieldReqBody build() {
            return new QueryUserStatsFieldReqBody(this);
        }
    }
}
