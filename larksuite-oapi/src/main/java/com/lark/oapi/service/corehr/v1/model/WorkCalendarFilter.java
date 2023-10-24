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

package com.lark.oapi.service.corehr.v1.model;

import com.google.gson.annotations.SerializedName;

public class WorkCalendarFilter {
    /**
     * 工作日历ID列表
     * <p> 示例值：
     */
    @SerializedName("wk_calendar_ids")
    private String[] wkCalendarIds;
    /**
     * 工作日历ID大于
     * <p> 示例值：12344
     */
    @SerializedName("wk_calendar_id_gt")
    private String wkCalendarIdGt;
    /**
     * 分页、排序等选项
     * <p> 示例值：
     */
    @SerializedName("wk_option")
    private WkOption wkOption;
    /**
     * 是否只返回启用的工作日历，不填默认true
     * <p> 示例值：true
     */
    @SerializedName("only_enable")
    private Boolean onlyEnable;

    // builder 开始
    public WorkCalendarFilter() {
    }

    public WorkCalendarFilter(Builder builder) {
        /**
         * 工作日历ID列表
         * <p> 示例值：
         */
        this.wkCalendarIds = builder.wkCalendarIds;
        /**
         * 工作日历ID大于
         * <p> 示例值：12344
         */
        this.wkCalendarIdGt = builder.wkCalendarIdGt;
        /**
         * 分页、排序等选项
         * <p> 示例值：
         */
        this.wkOption = builder.wkOption;
        /**
         * 是否只返回启用的工作日历，不填默认true
         * <p> 示例值：true
         */
        this.onlyEnable = builder.onlyEnable;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String[] getWkCalendarIds() {
        return this.wkCalendarIds;
    }

    public void setWkCalendarIds(String[] wkCalendarIds) {
        this.wkCalendarIds = wkCalendarIds;
    }

    public String getWkCalendarIdGt() {
        return this.wkCalendarIdGt;
    }

    public void setWkCalendarIdGt(String wkCalendarIdGt) {
        this.wkCalendarIdGt = wkCalendarIdGt;
    }

    public WkOption getWkOption() {
        return this.wkOption;
    }

    public void setWkOption(WkOption wkOption) {
        this.wkOption = wkOption;
    }

    public Boolean getOnlyEnable() {
        return this.onlyEnable;
    }

    public void setOnlyEnable(Boolean onlyEnable) {
        this.onlyEnable = onlyEnable;
    }

    public static class Builder {
        /**
         * 工作日历ID列表
         * <p> 示例值：
         */
        private String[] wkCalendarIds;
        /**
         * 工作日历ID大于
         * <p> 示例值：12344
         */
        private String wkCalendarIdGt;
        /**
         * 分页、排序等选项
         * <p> 示例值：
         */
        private WkOption wkOption;
        /**
         * 是否只返回启用的工作日历，不填默认true
         * <p> 示例值：true
         */
        private Boolean onlyEnable;

        /**
         * 工作日历ID列表
         * <p> 示例值：
         *
         * @param wkCalendarIds
         * @return
         */
        public Builder wkCalendarIds(String[] wkCalendarIds) {
            this.wkCalendarIds = wkCalendarIds;
            return this;
        }


        /**
         * 工作日历ID大于
         * <p> 示例值：12344
         *
         * @param wkCalendarIdGt
         * @return
         */
        public Builder wkCalendarIdGt(String wkCalendarIdGt) {
            this.wkCalendarIdGt = wkCalendarIdGt;
            return this;
        }


        /**
         * 分页、排序等选项
         * <p> 示例值：
         *
         * @param wkOption
         * @return
         */
        public Builder wkOption(WkOption wkOption) {
            this.wkOption = wkOption;
            return this;
        }


        /**
         * 是否只返回启用的工作日历，不填默认true
         * <p> 示例值：true
         *
         * @param onlyEnable
         * @return
         */
        public Builder onlyEnable(Boolean onlyEnable) {
            this.onlyEnable = onlyEnable;
            return this;
        }


        public WorkCalendarFilter build() {
            return new WorkCalendarFilter(this);
        }
    }
}
