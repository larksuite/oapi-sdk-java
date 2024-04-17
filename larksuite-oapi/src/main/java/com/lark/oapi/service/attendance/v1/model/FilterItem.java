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

public class FilterItem {
    /**
     * 筛选类型
     * <p> 示例值：
     */
    @SerializedName("filter_type")
    private String filterType;
    /**
     * 筛选的ID
     * <p> 示例值：
     */
    @SerializedName("filter_ids")
    private String[] filterIds;

    // builder 开始
    public FilterItem() {
    }

    public FilterItem(Builder builder) {
        /**
         * 筛选类型
         * <p> 示例值：
         */
        this.filterType = builder.filterType;
        /**
         * 筛选的ID
         * <p> 示例值：
         */
        this.filterIds = builder.filterIds;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getFilterType() {
        return this.filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String[] getFilterIds() {
        return this.filterIds;
    }

    public void setFilterIds(String[] filterIds) {
        this.filterIds = filterIds;
    }

    public static class Builder {
        /**
         * 筛选类型
         * <p> 示例值：
         */
        private String filterType;
        /**
         * 筛选的ID
         * <p> 示例值：
         */
        private String[] filterIds;

        /**
         * 筛选类型
         * <p> 示例值：
         *
         * @param filterType
         * @return
         */
        public Builder filterType(String filterType) {
            this.filterType = filterType;
            return this;
        }

        /**
         * 筛选类型
         * <p> 示例值：
         *
         * @param filterType {@link com.lark.oapi.service.attendance.v1.enums.FilterItemFilterTypeEnum}
         * @return
         */
        public Builder filterType(com.lark.oapi.service.attendance.v1.enums.FilterItemFilterTypeEnum filterType) {
            this.filterType = filterType.getValue();
            return this;
        }


        /**
         * 筛选的ID
         * <p> 示例值：
         *
         * @param filterIds
         * @return
         */
        public Builder filterIds(String[] filterIds) {
            this.filterIds = filterIds;
            return this;
        }


        public FilterItem build() {
            return new FilterItem(this);
        }
    }
}