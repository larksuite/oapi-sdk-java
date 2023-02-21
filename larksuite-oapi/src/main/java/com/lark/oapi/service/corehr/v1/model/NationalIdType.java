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

public class NationalIdType {
    /**
     * 证件类型 ID
     * <p> 示例值：6888198886960137735
     */
    @SerializedName("id")
    private String id;
    /**
     * 国家 / 地区
     * <p> 示例值：6862995747139225096
     */
    @SerializedName("country_region_id")
    private String countryRegionId;
    /**
     * 名称
     * <p> 示例值：
     */
    @SerializedName("name")
    private I18n[] name;
    /**
     * 是否启用
     * <p> 示例值：true
     */
    @SerializedName("active")
    private Boolean active;
    /**
     * 校验规则
     * <p> 示例值：^\d{9}$
     */
    @SerializedName("validation_rule")
    private String validationRule;
    /**
     * 校验规则描述
     * <p> 示例值：
     */
    @SerializedName("validation_rule_description")
    private I18n[] validationRuleDescription;
    /**
     * 编码
     * <p> 示例值：AUS-TFN
     */
    @SerializedName("code")
    private String code;
    /**
     * 证件类型
     * <p> 示例值：
     */
    @SerializedName("identification_type")
    private Enum identificationType;
    /**
     * 自定义字段
     * <p> 示例值：
     */
    @SerializedName("custom_fields")
    private ObjectFieldData[] customFields;

    // builder 开始
    public NationalIdType() {
    }

    public NationalIdType(Builder builder) {
        /**
         * 证件类型 ID
         * <p> 示例值：6888198886960137735
         */
        this.id = builder.id;
        /**
         * 国家 / 地区
         * <p> 示例值：6862995747139225096
         */
        this.countryRegionId = builder.countryRegionId;
        /**
         * 名称
         * <p> 示例值：
         */
        this.name = builder.name;
        /**
         * 是否启用
         * <p> 示例值：true
         */
        this.active = builder.active;
        /**
         * 校验规则
         * <p> 示例值：^\d{9}$
         */
        this.validationRule = builder.validationRule;
        /**
         * 校验规则描述
         * <p> 示例值：
         */
        this.validationRuleDescription = builder.validationRuleDescription;
        /**
         * 编码
         * <p> 示例值：AUS-TFN
         */
        this.code = builder.code;
        /**
         * 证件类型
         * <p> 示例值：
         */
        this.identificationType = builder.identificationType;
        /**
         * 自定义字段
         * <p> 示例值：
         */
        this.customFields = builder.customFields;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryRegionId() {
        return this.countryRegionId;
    }

    public void setCountryRegionId(String countryRegionId) {
        this.countryRegionId = countryRegionId;
    }

    public I18n[] getName() {
        return this.name;
    }

    public void setName(I18n[] name) {
        this.name = name;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getValidationRule() {
        return this.validationRule;
    }

    public void setValidationRule(String validationRule) {
        this.validationRule = validationRule;
    }

    public I18n[] getValidationRuleDescription() {
        return this.validationRuleDescription;
    }

    public void setValidationRuleDescription(I18n[] validationRuleDescription) {
        this.validationRuleDescription = validationRuleDescription;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Enum getIdentificationType() {
        return this.identificationType;
    }

    public void setIdentificationType(Enum identificationType) {
        this.identificationType = identificationType;
    }

    public ObjectFieldData[] getCustomFields() {
        return this.customFields;
    }

    public void setCustomFields(ObjectFieldData[] customFields) {
        this.customFields = customFields;
    }

    public static class Builder {
        /**
         * 证件类型 ID
         * <p> 示例值：6888198886960137735
         */
        private String id;
        /**
         * 国家 / 地区
         * <p> 示例值：6862995747139225096
         */
        private String countryRegionId;
        /**
         * 名称
         * <p> 示例值：
         */
        private I18n[] name;
        /**
         * 是否启用
         * <p> 示例值：true
         */
        private Boolean active;
        /**
         * 校验规则
         * <p> 示例值：^\d{9}$
         */
        private String validationRule;
        /**
         * 校验规则描述
         * <p> 示例值：
         */
        private I18n[] validationRuleDescription;
        /**
         * 编码
         * <p> 示例值：AUS-TFN
         */
        private String code;
        /**
         * 证件类型
         * <p> 示例值：
         */
        private Enum identificationType;
        /**
         * 自定义字段
         * <p> 示例值：
         */
        private ObjectFieldData[] customFields;

        /**
         * 证件类型 ID
         * <p> 示例值：6888198886960137735
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 国家 / 地区
         * <p> 示例值：6862995747139225096
         *
         * @param countryRegionId
         * @return
         */
        public Builder countryRegionId(String countryRegionId) {
            this.countryRegionId = countryRegionId;
            return this;
        }


        /**
         * 名称
         * <p> 示例值：
         *
         * @param name
         * @return
         */
        public Builder name(I18n[] name) {
            this.name = name;
            return this;
        }


        /**
         * 是否启用
         * <p> 示例值：true
         *
         * @param active
         * @return
         */
        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }


        /**
         * 校验规则
         * <p> 示例值：^\d{9}$
         *
         * @param validationRule
         * @return
         */
        public Builder validationRule(String validationRule) {
            this.validationRule = validationRule;
            return this;
        }


        /**
         * 校验规则描述
         * <p> 示例值：
         *
         * @param validationRuleDescription
         * @return
         */
        public Builder validationRuleDescription(I18n[] validationRuleDescription) {
            this.validationRuleDescription = validationRuleDescription;
            return this;
        }


        /**
         * 编码
         * <p> 示例值：AUS-TFN
         *
         * @param code
         * @return
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }


        /**
         * 证件类型
         * <p> 示例值：
         *
         * @param identificationType
         * @return
         */
        public Builder identificationType(Enum identificationType) {
            this.identificationType = identificationType;
            return this;
        }


        /**
         * 自定义字段
         * <p> 示例值：
         *
         * @param customFields
         * @return
         */
        public Builder customFields(ObjectFieldData[] customFields) {
            this.customFields = customFields;
            return this;
        }


        public NationalIdType build() {
            return new NationalIdType(this);
        }
    }
}