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

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.corehr.v1.enums.*;
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

public class FilterRuleValue {
    /**
     * 规则值类型
     * <p> 示例值：1
     */
    @SerializedName("type")
    private Integer type;
    /**
     * 规则值
     * <p> 示例值：a
     */
    @SerializedName("value")
    private String value;
    /**
     * 下钻值
     * <p> 示例值：1
     */
    @SerializedName("lookup_value")
    private String lookupValue;
    /**
     * 下钻类型
     * <p> 示例值：user
     */
    @SerializedName("lookup_type")
    private String lookupType;

    // builder 开始
    public FilterRuleValue() {
    }

    public FilterRuleValue(Builder builder) {
        /**
         * 规则值类型
         * <p> 示例值：1
         */
        this.type = builder.type;
        /**
         * 规则值
         * <p> 示例值：a
         */
        this.value = builder.value;
        /**
         * 下钻值
         * <p> 示例值：1
         */
        this.lookupValue = builder.lookupValue;
        /**
         * 下钻类型
         * <p> 示例值：user
         */
        this.lookupType = builder.lookupType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLookupValue() {
        return this.lookupValue;
    }

    public void setLookupValue(String lookupValue) {
        this.lookupValue = lookupValue;
    }

    public String getLookupType() {
        return this.lookupType;
    }

    public void setLookupType(String lookupType) {
        this.lookupType = lookupType;
    }

    public static class Builder {
        /**
         * 规则值类型
         * <p> 示例值：1
         */
        private Integer type;
        /**
         * 规则值
         * <p> 示例值：a
         */
        private String value;
        /**
         * 下钻值
         * <p> 示例值：1
         */
        private String lookupValue;
        /**
         * 下钻类型
         * <p> 示例值：user
         */
        private String lookupType;

        /**
         * 规则值类型
         * <p> 示例值：1
         *
         * @param type
         * @return
         */
        public Builder type(Integer type) {
            this.type = type;
            return this;
        }


        /**
         * 规则值
         * <p> 示例值：a
         *
         * @param value
         * @return
         */
        public Builder value(String value) {
            this.value = value;
            return this;
        }


        /**
         * 下钻值
         * <p> 示例值：1
         *
         * @param lookupValue
         * @return
         */
        public Builder lookupValue(String lookupValue) {
            this.lookupValue = lookupValue;
            return this;
        }


        /**
         * 下钻类型
         * <p> 示例值：user
         *
         * @param lookupType
         * @return
         */
        public Builder lookupType(String lookupType) {
            this.lookupType = lookupType;
            return this;
        }


        public FilterRuleValue build() {
            return new FilterRuleValue(this);
        }
    }
}
