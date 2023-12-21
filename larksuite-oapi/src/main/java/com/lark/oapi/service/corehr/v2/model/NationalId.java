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

import com.google.gson.annotations.SerializedName;

public class NationalId {
    /**
     * 国家证件类型
     * <p> 示例值：6863330041896371725
     */
    @SerializedName("national_id_type_id")
    private String nationalIdTypeId;
    /**
     * 证件号码
     * <p> 示例值：1231131333
     */
    @SerializedName("national_id_number")
    private String nationalIdNumber;
    /**
     * 证件签发日期
     * <p> 示例值：2020-04-01
     */
    @SerializedName("issue_date")
    private String issueDate;
    /**
     * 证件到期日期
     * <p> 示例值：2020-05-21
     */
    @SerializedName("expiration_date")
    private String expirationDate;
    /**
     * 国家 / 地区
     * <p> 示例值：6862995757234914824
     */
    @SerializedName("country_region_id")
    private String countryRegionId;
    /**
     * 证件签发机构
     * <p> 示例值：北京市公安局
     */
    @SerializedName("issued_by")
    private String issuedBy;
    /**
     * 自定义字段
     * <p> 示例值：
     */
    @SerializedName("custom_fields")
    private CustomFieldData[] customFields;

    // builder 开始
    public NationalId() {
    }

    public NationalId(Builder builder) {
        /**
         * 国家证件类型
         * <p> 示例值：6863330041896371725
         */
        this.nationalIdTypeId = builder.nationalIdTypeId;
        /**
         * 证件号码
         * <p> 示例值：1231131333
         */
        this.nationalIdNumber = builder.nationalIdNumber;
        /**
         * 证件签发日期
         * <p> 示例值：2020-04-01
         */
        this.issueDate = builder.issueDate;
        /**
         * 证件到期日期
         * <p> 示例值：2020-05-21
         */
        this.expirationDate = builder.expirationDate;
        /**
         * 国家 / 地区
         * <p> 示例值：6862995757234914824
         */
        this.countryRegionId = builder.countryRegionId;
        /**
         * 证件签发机构
         * <p> 示例值：北京市公安局
         */
        this.issuedBy = builder.issuedBy;
        /**
         * 自定义字段
         * <p> 示例值：
         */
        this.customFields = builder.customFields;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getNationalIdTypeId() {
        return this.nationalIdTypeId;
    }

    public void setNationalIdTypeId(String nationalIdTypeId) {
        this.nationalIdTypeId = nationalIdTypeId;
    }

    public String getNationalIdNumber() {
        return this.nationalIdNumber;
    }

    public void setNationalIdNumber(String nationalIdNumber) {
        this.nationalIdNumber = nationalIdNumber;
    }

    public String getIssueDate() {
        return this.issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCountryRegionId() {
        return this.countryRegionId;
    }

    public void setCountryRegionId(String countryRegionId) {
        this.countryRegionId = countryRegionId;
    }

    public String getIssuedBy() {
        return this.issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public CustomFieldData[] getCustomFields() {
        return this.customFields;
    }

    public void setCustomFields(CustomFieldData[] customFields) {
        this.customFields = customFields;
    }

    public static class Builder {
        /**
         * 国家证件类型
         * <p> 示例值：6863330041896371725
         */
        private String nationalIdTypeId;
        /**
         * 证件号码
         * <p> 示例值：1231131333
         */
        private String nationalIdNumber;
        /**
         * 证件签发日期
         * <p> 示例值：2020-04-01
         */
        private String issueDate;
        /**
         * 证件到期日期
         * <p> 示例值：2020-05-21
         */
        private String expirationDate;
        /**
         * 国家 / 地区
         * <p> 示例值：6862995757234914824
         */
        private String countryRegionId;
        /**
         * 证件签发机构
         * <p> 示例值：北京市公安局
         */
        private String issuedBy;
        /**
         * 自定义字段
         * <p> 示例值：
         */
        private CustomFieldData[] customFields;

        /**
         * 国家证件类型
         * <p> 示例值：6863330041896371725
         *
         * @param nationalIdTypeId
         * @return
         */
        public Builder nationalIdTypeId(String nationalIdTypeId) {
            this.nationalIdTypeId = nationalIdTypeId;
            return this;
        }


        /**
         * 证件号码
         * <p> 示例值：1231131333
         *
         * @param nationalIdNumber
         * @return
         */
        public Builder nationalIdNumber(String nationalIdNumber) {
            this.nationalIdNumber = nationalIdNumber;
            return this;
        }


        /**
         * 证件签发日期
         * <p> 示例值：2020-04-01
         *
         * @param issueDate
         * @return
         */
        public Builder issueDate(String issueDate) {
            this.issueDate = issueDate;
            return this;
        }


        /**
         * 证件到期日期
         * <p> 示例值：2020-05-21
         *
         * @param expirationDate
         * @return
         */
        public Builder expirationDate(String expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }


        /**
         * 国家 / 地区
         * <p> 示例值：6862995757234914824
         *
         * @param countryRegionId
         * @return
         */
        public Builder countryRegionId(String countryRegionId) {
            this.countryRegionId = countryRegionId;
            return this;
        }


        /**
         * 证件签发机构
         * <p> 示例值：北京市公安局
         *
         * @param issuedBy
         * @return
         */
        public Builder issuedBy(String issuedBy) {
            this.issuedBy = issuedBy;
            return this;
        }


        /**
         * 自定义字段
         * <p> 示例值：
         *
         * @param customFields
         * @return
         */
        public Builder customFields(CustomFieldData[] customFields) {
            this.customFields = customFields;
            return this;
        }


        public NationalId build() {
            return new NationalId(this);
        }
    }
}