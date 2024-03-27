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

public class ProfileSettingBankAccount {
    /**
     * 国家 / 地区ID
     * <p> 示例值：6862995757234914824
     */
    @SerializedName("country_region")
    private String countryRegion;
    /**
     * 银行名称
     * <p> 示例值：中国农业银行
     */
    @SerializedName("bank_name")
    private String bankName;
    /**
     * 支行名称
     * <p> 示例值：中国农业银行支行
     */
    @SerializedName("branch_name")
    private String branchName;
    /**
     * 开户人姓名
     * <p> 示例值：孟十五
     */
    @SerializedName("account_holder")
    private String accountHolder;
    /**
     * 银行账号
     * <p> 示例值：6231200000001223
     */
    @SerializedName("bank_account_number")
    private String bankAccountNumber;
    /**
     * 银行卡用途，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "bank_account" custom_api_name = "bank_account_usage"
     * <p> 示例值：payment
     */
    @SerializedName("bank_account_usages")
    private String[] bankAccountUsages;
    /**
     * 银行卡类型，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "bank_account" custom_api_name = "bank_account_type"
     * <p> 示例值：savings
     */
    @SerializedName("bank_account_type")
    private String bankAccountType;
    /**
     * 银行ID
     * <p> 示例值：6862995757234914832
     */
    @SerializedName("bank_id")
    private String bankId;
    /**
     * 银行支行ID
     * <p> 示例值：6862995757234914833
     */
    @SerializedName("branch_id")
    private String branchId;

    // builder 开始
    public ProfileSettingBankAccount() {
    }

    public ProfileSettingBankAccount(Builder builder) {
        /**
         * 国家 / 地区ID
         * <p> 示例值：6862995757234914824
         */
        this.countryRegion = builder.countryRegion;
        /**
         * 银行名称
         * <p> 示例值：中国农业银行
         */
        this.bankName = builder.bankName;
        /**
         * 支行名称
         * <p> 示例值：中国农业银行支行
         */
        this.branchName = builder.branchName;
        /**
         * 开户人姓名
         * <p> 示例值：孟十五
         */
        this.accountHolder = builder.accountHolder;
        /**
         * 银行账号
         * <p> 示例值：6231200000001223
         */
        this.bankAccountNumber = builder.bankAccountNumber;
        /**
         * 银行卡用途，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "bank_account" custom_api_name = "bank_account_usage"
         * <p> 示例值：payment
         */
        this.bankAccountUsages = builder.bankAccountUsages;
        /**
         * 银行卡类型，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "bank_account" custom_api_name = "bank_account_type"
         * <p> 示例值：savings
         */
        this.bankAccountType = builder.bankAccountType;
        /**
         * 银行ID
         * <p> 示例值：6862995757234914832
         */
        this.bankId = builder.bankId;
        /**
         * 银行支行ID
         * <p> 示例值：6862995757234914833
         */
        this.branchId = builder.branchId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCountryRegion() {
        return this.countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return this.branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAccountHolder() {
        return this.accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getBankAccountNumber() {
        return this.bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String[] getBankAccountUsages() {
        return this.bankAccountUsages;
    }

    public void setBankAccountUsages(String[] bankAccountUsages) {
        this.bankAccountUsages = bankAccountUsages;
    }

    public String getBankAccountType() {
        return this.bankAccountType;
    }

    public void setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public String getBankId() {
        return this.bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBranchId() {
        return this.branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public static class Builder {
        /**
         * 国家 / 地区ID
         * <p> 示例值：6862995757234914824
         */
        private String countryRegion;
        /**
         * 银行名称
         * <p> 示例值：中国农业银行
         */
        private String bankName;
        /**
         * 支行名称
         * <p> 示例值：中国农业银行支行
         */
        private String branchName;
        /**
         * 开户人姓名
         * <p> 示例值：孟十五
         */
        private String accountHolder;
        /**
         * 银行账号
         * <p> 示例值：6231200000001223
         */
        private String bankAccountNumber;
        /**
         * 银行卡用途，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "bank_account" custom_api_name = "bank_account_usage"
         * <p> 示例值：payment
         */
        private String[] bankAccountUsages;
        /**
         * 银行卡类型，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "bank_account" custom_api_name = "bank_account_type"
         * <p> 示例值：savings
         */
        private String bankAccountType;
        /**
         * 银行ID
         * <p> 示例值：6862995757234914832
         */
        private String bankId;
        /**
         * 银行支行ID
         * <p> 示例值：6862995757234914833
         */
        private String branchId;

        /**
         * 国家 / 地区ID
         * <p> 示例值：6862995757234914824
         *
         * @param countryRegion
         * @return
         */
        public Builder countryRegion(String countryRegion) {
            this.countryRegion = countryRegion;
            return this;
        }


        /**
         * 银行名称
         * <p> 示例值：中国农业银行
         *
         * @param bankName
         * @return
         */
        public Builder bankName(String bankName) {
            this.bankName = bankName;
            return this;
        }


        /**
         * 支行名称
         * <p> 示例值：中国农业银行支行
         *
         * @param branchName
         * @return
         */
        public Builder branchName(String branchName) {
            this.branchName = branchName;
            return this;
        }


        /**
         * 开户人姓名
         * <p> 示例值：孟十五
         *
         * @param accountHolder
         * @return
         */
        public Builder accountHolder(String accountHolder) {
            this.accountHolder = accountHolder;
            return this;
        }


        /**
         * 银行账号
         * <p> 示例值：6231200000001223
         *
         * @param bankAccountNumber
         * @return
         */
        public Builder bankAccountNumber(String bankAccountNumber) {
            this.bankAccountNumber = bankAccountNumber;
            return this;
        }


        /**
         * 银行卡用途，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "bank_account" custom_api_name = "bank_account_usage"
         * <p> 示例值：payment
         *
         * @param bankAccountUsages
         * @return
         */
        public Builder bankAccountUsages(String[] bankAccountUsages) {
            this.bankAccountUsages = bankAccountUsages;
            return this;
        }


        /**
         * 银行卡类型，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "bank_account" custom_api_name = "bank_account_type"
         * <p> 示例值：savings
         *
         * @param bankAccountType
         * @return
         */
        public Builder bankAccountType(String bankAccountType) {
            this.bankAccountType = bankAccountType;
            return this;
        }


        /**
         * 银行ID
         * <p> 示例值：6862995757234914832
         *
         * @param bankId
         * @return
         */
        public Builder bankId(String bankId) {
            this.bankId = bankId;
            return this;
        }


        /**
         * 银行支行ID
         * <p> 示例值：6862995757234914833
         *
         * @param branchId
         * @return
         */
        public Builder branchId(String branchId) {
            this.branchId = branchId;
            return this;
        }


        public ProfileSettingBankAccount build() {
            return new ProfileSettingBankAccount(this);
        }
    }
}
