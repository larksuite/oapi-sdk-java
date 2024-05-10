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

package com.lark.oapi.service.sheets.v3.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.sheets.v3.enums.*;
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

public class FilterViewCondition {
    /**
     * 设置筛选条件的列，使用字母号
     * <p> 示例值：E
     */
    @SerializedName("condition_id")
    private String conditionId;
    /**
     * 筛选类型
     * <p> 示例值：number
     */
    @SerializedName("filter_type")
    private String filterType;
    /**
     * 比较类型
     * <p> 示例值：less
     */
    @SerializedName("compare_type")
    private String compareType;
    /**
     * 筛选参数
     * <p> 示例值：6
     */
    @SerializedName("expected")
    private String[] expected;

    // builder 开始
    public FilterViewCondition() {
    }

    public FilterViewCondition(Builder builder) {
        /**
         * 设置筛选条件的列，使用字母号
         * <p> 示例值：E
         */
        this.conditionId = builder.conditionId;
        /**
         * 筛选类型
         * <p> 示例值：number
         */
        this.filterType = builder.filterType;
        /**
         * 比较类型
         * <p> 示例值：less
         */
        this.compareType = builder.compareType;
        /**
         * 筛选参数
         * <p> 示例值：6
         */
        this.expected = builder.expected;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getConditionId() {
        return this.conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    public String getFilterType() {
        return this.filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getCompareType() {
        return this.compareType;
    }

    public void setCompareType(String compareType) {
        this.compareType = compareType;
    }

    public String[] getExpected() {
        return this.expected;
    }

    public void setExpected(String[] expected) {
        this.expected = expected;
    }

    public static class Builder {
        /**
         * 设置筛选条件的列，使用字母号
         * <p> 示例值：E
         */
        private String conditionId;
        /**
         * 筛选类型
         * <p> 示例值：number
         */
        private String filterType;
        /**
         * 比较类型
         * <p> 示例值：less
         */
        private String compareType;
        /**
         * 筛选参数
         * <p> 示例值：6
         */
        private String[] expected;

        /**
         * 设置筛选条件的列，使用字母号
         * <p> 示例值：E
         *
         * @param conditionId
         * @return
         */
        public Builder conditionId(String conditionId) {
            this.conditionId = conditionId;
            return this;
        }


        /**
         * 筛选类型
         * <p> 示例值：number
         *
         * @param filterType
         * @return
         */
        public Builder filterType(String filterType) {
            this.filterType = filterType;
            return this;
        }


        /**
         * 比较类型
         * <p> 示例值：less
         *
         * @param compareType
         * @return
         */
        public Builder compareType(String compareType) {
            this.compareType = compareType;
            return this;
        }


        /**
         * 筛选参数
         * <p> 示例值：6
         *
         * @param expected
         * @return
         */
        public Builder expected(String[] expected) {
            this.expected = expected;
            return this;
        }


        public FilterViewCondition build() {
            return new FilterViewCondition(this);
        }
    }
}
