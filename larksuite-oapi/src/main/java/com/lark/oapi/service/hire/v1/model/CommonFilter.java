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

package com.lark.oapi.service.hire.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.response.BaseResponse;

public class CommonFilter {
    /**
     * 筛选项 key
     * <p> 示例值：degree
     */
    @SerializedName("key")
    private String key;
    /**
     * 筛选项值类型
     * <p> 示例值：1
     */
    @SerializedName("value_type")
    private Integer valueType;
    /**
     * 筛选项值列表
     * <p> 示例值：
     */
    @SerializedName("value_list")
    private String[] valueList;
    /**
     * 范围筛选
     * <p> 示例值：
     */
    @SerializedName("range_filter")
    private RangeFilter rangeFilter;

    // builder 开始
    public CommonFilter() {
    }

    public CommonFilter(Builder builder) {
        /**
         * 筛选项 key
         * <p> 示例值：degree
         */
        this.key = builder.key;
        /**
         * 筛选项值类型
         * <p> 示例值：1
         */
        this.valueType = builder.valueType;
        /**
         * 筛选项值列表
         * <p> 示例值：
         */
        this.valueList = builder.valueList;
        /**
         * 范围筛选
         * <p> 示例值：
         */
        this.rangeFilter = builder.rangeFilter;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValueType() {
        return this.valueType;
    }

    public void setValueType(Integer valueType) {
        this.valueType = valueType;
    }

    public String[] getValueList() {
        return this.valueList;
    }

    public void setValueList(String[] valueList) {
        this.valueList = valueList;
    }

    public RangeFilter getRangeFilter() {
        return this.rangeFilter;
    }

    public void setRangeFilter(RangeFilter rangeFilter) {
        this.rangeFilter = rangeFilter;
    }

    public static class Builder {
        /**
         * 筛选项 key
         * <p> 示例值：degree
         */
        private String key;
        /**
         * 筛选项值类型
         * <p> 示例值：1
         */
        private Integer valueType;
        /**
         * 筛选项值列表
         * <p> 示例值：
         */
        private String[] valueList;
        /**
         * 范围筛选
         * <p> 示例值：
         */
        private RangeFilter rangeFilter;

        /**
         * 筛选项 key
         * <p> 示例值：degree
         *
         * @param key
         * @return
         */
        public Builder key(String key) {
            this.key = key;
            return this;
        }


        /**
         * 筛选项值类型
         * <p> 示例值：1
         *
         * @param valueType
         * @return
         */
        public Builder valueType(Integer valueType) {
            this.valueType = valueType;
            return this;
        }


        /**
         * 筛选项值列表
         * <p> 示例值：
         *
         * @param valueList
         * @return
         */
        public Builder valueList(String[] valueList) {
            this.valueList = valueList;
            return this;
        }


        /**
         * 范围筛选
         * <p> 示例值：
         *
         * @param rangeFilter
         * @return
         */
        public Builder rangeFilter(RangeFilter rangeFilter) {
            this.rangeFilter = rangeFilter;
            return this;
        }


        public CommonFilter build() {
            return new CommonFilter(this);
        }
    }
}