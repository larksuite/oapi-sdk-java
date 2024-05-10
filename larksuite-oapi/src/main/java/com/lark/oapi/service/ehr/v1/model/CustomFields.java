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

package com.lark.oapi.service.ehr.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.ehr.v1.enums.*;
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

public class CustomFields {
    /**
     * 自定义字段key
     * <p> 示例值：field_xxxxxxxx
     */
    @SerializedName("key")
    private String key;
    /**
     * 自定义字段名称
     * <p> 示例值：自定义字段 1
     */
    @SerializedName("label")
    private String label;
    /**
     * 自定义字段类型
     * <p> 示例值：date
     */
    @SerializedName("type")
    private String type;
    /**
     * 根据 type 不同，结构不同，不同 type 对应的数据结构在 type 的枚举值中有描述
     * <p> 示例值：2021-01-13
     */
    @SerializedName("value")
    private String value;

    // builder 开始
    public CustomFields() {
    }

    public CustomFields(Builder builder) {
        /**
         * 自定义字段key
         * <p> 示例值：field_xxxxxxxx
         */
        this.key = builder.key;
        /**
         * 自定义字段名称
         * <p> 示例值：自定义字段 1
         */
        this.label = builder.label;
        /**
         * 自定义字段类型
         * <p> 示例值：date
         */
        this.type = builder.type;
        /**
         * 根据 type 不同，结构不同，不同 type 对应的数据结构在 type 的枚举值中有描述
         * <p> 示例值：2021-01-13
         */
        this.value = builder.value;
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

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static class Builder {
        /**
         * 自定义字段key
         * <p> 示例值：field_xxxxxxxx
         */
        private String key;
        /**
         * 自定义字段名称
         * <p> 示例值：自定义字段 1
         */
        private String label;
        /**
         * 自定义字段类型
         * <p> 示例值：date
         */
        private String type;
        /**
         * 根据 type 不同，结构不同，不同 type 对应的数据结构在 type 的枚举值中有描述
         * <p> 示例值：2021-01-13
         */
        private String value;

        /**
         * 自定义字段key
         * <p> 示例值：field_xxxxxxxx
         *
         * @param key
         * @return
         */
        public Builder key(String key) {
            this.key = key;
            return this;
        }


        /**
         * 自定义字段名称
         * <p> 示例值：自定义字段 1
         *
         * @param label
         * @return
         */
        public Builder label(String label) {
            this.label = label;
            return this;
        }


        /**
         * 自定义字段类型
         * <p> 示例值：date
         *
         * @param type
         * @return
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * 自定义字段类型
         * <p> 示例值：date
         *
         * @param type {@link com.lark.oapi.service.ehr.v1.enums.CustomFieldsTypeEnum}
         * @return
         */
        public Builder type(com.lark.oapi.service.ehr.v1.enums.CustomFieldsTypeEnum type) {
            this.type = type.getValue();
            return this;
        }


        /**
         * 根据 type 不同，结构不同，不同 type 对应的数据结构在 type 的枚举值中有描述
         * <p> 示例值：2021-01-13
         *
         * @param value
         * @return
         */
        public Builder value(String value) {
            this.value = value;
            return this;
        }


        public CustomFields build() {
            return new CustomFields(this);
        }
    }
}
