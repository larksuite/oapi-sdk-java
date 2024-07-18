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

public class SignatureTemplateCustomField {
    /**
     * 中英文描述
     * <p> 示例值：
     */
    @SerializedName("label")
    private I18n[] label;
    /**
     * 主数据apiname
     * <p> 示例值：status
     */
    @SerializedName("apiname")
    private String apiname;
    /**
     * 用户自定义字段类型
     * <p> 示例值：
     */
    @SerializedName("custom_field_type")
    private Enum customFieldType;
    /**
     * 是否使用到
     * <p> 示例值：
     */
    @SerializedName("used")
    private Boolean used;
    /**
     * 是否需要
     * <p> 示例值：
     */
    @SerializedName("is_required")
    private Boolean isRequired;
    /**
     * 自定义描述
     * <p> 示例值：desc
     */
    @SerializedName("custom_desc")
    private String customDesc;
    /**
     * 电子签模版公共字段信息
     * <p> 示例值：
     */
    @SerializedName("common_info")
    private SignatureTemplateCommonFieldInfo commonInfo;

    // builder 开始
    public SignatureTemplateCustomField() {
    }

    public SignatureTemplateCustomField(Builder builder) {
        /**
         * 中英文描述
         * <p> 示例值：
         */
        this.label = builder.label;
        /**
         * 主数据apiname
         * <p> 示例值：status
         */
        this.apiname = builder.apiname;
        /**
         * 用户自定义字段类型
         * <p> 示例值：
         */
        this.customFieldType = builder.customFieldType;
        /**
         * 是否使用到
         * <p> 示例值：
         */
        this.used = builder.used;
        /**
         * 是否需要
         * <p> 示例值：
         */
        this.isRequired = builder.isRequired;
        /**
         * 自定义描述
         * <p> 示例值：desc
         */
        this.customDesc = builder.customDesc;
        /**
         * 电子签模版公共字段信息
         * <p> 示例值：
         */
        this.commonInfo = builder.commonInfo;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public I18n[] getLabel() {
        return this.label;
    }

    public void setLabel(I18n[] label) {
        this.label = label;
    }

    public String getApiname() {
        return this.apiname;
    }

    public void setApiname(String apiname) {
        this.apiname = apiname;
    }

    public Enum getCustomFieldType() {
        return this.customFieldType;
    }

    public void setCustomFieldType(Enum customFieldType) {
        this.customFieldType = customFieldType;
    }

    public Boolean getUsed() {
        return this.used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public Boolean getIsRequired() {
        return this.isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public String getCustomDesc() {
        return this.customDesc;
    }

    public void setCustomDesc(String customDesc) {
        this.customDesc = customDesc;
    }

    public SignatureTemplateCommonFieldInfo getCommonInfo() {
        return this.commonInfo;
    }

    public void setCommonInfo(SignatureTemplateCommonFieldInfo commonInfo) {
        this.commonInfo = commonInfo;
    }

    public static class Builder {
        /**
         * 中英文描述
         * <p> 示例值：
         */
        private I18n[] label;
        /**
         * 主数据apiname
         * <p> 示例值：status
         */
        private String apiname;
        /**
         * 用户自定义字段类型
         * <p> 示例值：
         */
        private Enum customFieldType;
        /**
         * 是否使用到
         * <p> 示例值：
         */
        private Boolean used;
        /**
         * 是否需要
         * <p> 示例值：
         */
        private Boolean isRequired;
        /**
         * 自定义描述
         * <p> 示例值：desc
         */
        private String customDesc;
        /**
         * 电子签模版公共字段信息
         * <p> 示例值：
         */
        private SignatureTemplateCommonFieldInfo commonInfo;

        /**
         * 中英文描述
         * <p> 示例值：
         *
         * @param label
         * @return
         */
        public Builder label(I18n[] label) {
            this.label = label;
            return this;
        }


        /**
         * 主数据apiname
         * <p> 示例值：status
         *
         * @param apiname
         * @return
         */
        public Builder apiname(String apiname) {
            this.apiname = apiname;
            return this;
        }


        /**
         * 用户自定义字段类型
         * <p> 示例值：
         *
         * @param customFieldType
         * @return
         */
        public Builder customFieldType(Enum customFieldType) {
            this.customFieldType = customFieldType;
            return this;
        }


        /**
         * 是否使用到
         * <p> 示例值：
         *
         * @param used
         * @return
         */
        public Builder used(Boolean used) {
            this.used = used;
            return this;
        }


        /**
         * 是否需要
         * <p> 示例值：
         *
         * @param isRequired
         * @return
         */
        public Builder isRequired(Boolean isRequired) {
            this.isRequired = isRequired;
            return this;
        }


        /**
         * 自定义描述
         * <p> 示例值：desc
         *
         * @param customDesc
         * @return
         */
        public Builder customDesc(String customDesc) {
            this.customDesc = customDesc;
            return this;
        }


        /**
         * 电子签模版公共字段信息
         * <p> 示例值：
         *
         * @param commonInfo
         * @return
         */
        public Builder commonInfo(SignatureTemplateCommonFieldInfo commonInfo) {
            this.commonInfo = commonInfo;
            return this;
        }


        public SignatureTemplateCustomField build() {
            return new SignatureTemplateCustomField(this);
        }
    }
}