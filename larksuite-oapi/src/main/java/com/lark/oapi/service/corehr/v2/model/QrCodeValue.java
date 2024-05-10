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

package com.lark.oapi.service.corehr.v2.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.corehr.v2.enums.*;
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

public class QrCodeValue {
    /**
     * 单选值
     * <p> 示例值：7147562782945478177
     */
    @SerializedName("select_value")
    private String selectValue;
    /**
     * 多选值
     * <p> 示例值：
     */
    @SerializedName("multi_select_value")
    private String[] multiSelectValue;
    /**
     * 布尔值
     * <p> 示例值：
     */
    @SerializedName("bool_value")
    private Boolean boolValue;

    // builder 开始
    public QrCodeValue() {
    }

    public QrCodeValue(Builder builder) {
        /**
         * 单选值
         * <p> 示例值：7147562782945478177
         */
        this.selectValue = builder.selectValue;
        /**
         * 多选值
         * <p> 示例值：
         */
        this.multiSelectValue = builder.multiSelectValue;
        /**
         * 布尔值
         * <p> 示例值：
         */
        this.boolValue = builder.boolValue;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getSelectValue() {
        return this.selectValue;
    }

    public void setSelectValue(String selectValue) {
        this.selectValue = selectValue;
    }

    public String[] getMultiSelectValue() {
        return this.multiSelectValue;
    }

    public void setMultiSelectValue(String[] multiSelectValue) {
        this.multiSelectValue = multiSelectValue;
    }

    public Boolean getBoolValue() {
        return this.boolValue;
    }

    public void setBoolValue(Boolean boolValue) {
        this.boolValue = boolValue;
    }

    public static class Builder {
        /**
         * 单选值
         * <p> 示例值：7147562782945478177
         */
        private String selectValue;
        /**
         * 多选值
         * <p> 示例值：
         */
        private String[] multiSelectValue;
        /**
         * 布尔值
         * <p> 示例值：
         */
        private Boolean boolValue;

        /**
         * 单选值
         * <p> 示例值：7147562782945478177
         *
         * @param selectValue
         * @return
         */
        public Builder selectValue(String selectValue) {
            this.selectValue = selectValue;
            return this;
        }


        /**
         * 多选值
         * <p> 示例值：
         *
         * @param multiSelectValue
         * @return
         */
        public Builder multiSelectValue(String[] multiSelectValue) {
            this.multiSelectValue = multiSelectValue;
            return this;
        }


        /**
         * 布尔值
         * <p> 示例值：
         *
         * @param boolValue
         * @return
         */
        public Builder boolValue(Boolean boolValue) {
            this.boolValue = boolValue;
            return this;
        }


        public QrCodeValue build() {
            return new QrCodeValue(this);
        }
    }
}
