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

public class OpenApplyTimeRange {
    /**
     * 加班所属日期
     * <p> 示例值：2023-09-25
     */
    @SerializedName("overtime_attribution_date")
    private String overtimeAttributionDate;
    /**
     * 时段信息
     * <p> 示例值：
     */
    @SerializedName("time_range")
    private OvertimeTimeRange timeRange;

    // builder 开始
    public OpenApplyTimeRange() {
    }

    public OpenApplyTimeRange(Builder builder) {
        /**
         * 加班所属日期
         * <p> 示例值：2023-09-25
         */
        this.overtimeAttributionDate = builder.overtimeAttributionDate;
        /**
         * 时段信息
         * <p> 示例值：
         */
        this.timeRange = builder.timeRange;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getOvertimeAttributionDate() {
        return this.overtimeAttributionDate;
    }

    public void setOvertimeAttributionDate(String overtimeAttributionDate) {
        this.overtimeAttributionDate = overtimeAttributionDate;
    }

    public OvertimeTimeRange getTimeRange() {
        return this.timeRange;
    }

    public void setTimeRange(OvertimeTimeRange timeRange) {
        this.timeRange = timeRange;
    }

    public static class Builder {
        /**
         * 加班所属日期
         * <p> 示例值：2023-09-25
         */
        private String overtimeAttributionDate;
        /**
         * 时段信息
         * <p> 示例值：
         */
        private OvertimeTimeRange timeRange;

        /**
         * 加班所属日期
         * <p> 示例值：2023-09-25
         *
         * @param overtimeAttributionDate
         * @return
         */
        public Builder overtimeAttributionDate(String overtimeAttributionDate) {
            this.overtimeAttributionDate = overtimeAttributionDate;
            return this;
        }


        /**
         * 时段信息
         * <p> 示例值：
         *
         * @param timeRange
         * @return
         */
        public Builder timeRange(OvertimeTimeRange timeRange) {
            this.timeRange = timeRange;
            return this;
        }


        public OpenApplyTimeRange build() {
            return new OpenApplyTimeRange(this);
        }
    }
}
