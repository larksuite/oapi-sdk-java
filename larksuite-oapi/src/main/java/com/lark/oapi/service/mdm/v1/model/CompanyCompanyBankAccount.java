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

package com.lark.oapi.service.mdm.v1.model;

import com.google.gson.annotations.SerializedName;

public class CompanyCompanyBankAccount {
    /**
     * 公司银行账号唯一ID
     * <p> 示例值：U1409787258113892352
     */
    @SerializedName("company_bank_account_uid")
    private String companyBankAccountUid;
    /**
     * 公司唯一ID
     * <p> 示例值：U1409787216334430208
     */
    @SerializedName("company_uid")
    private String companyUid;
    /**
     * 银行账号
     * <p> 示例值：642*********423
     */
    @SerializedName("account")
    private String account;
    /**
     * 国际银行账号
     * <p> 示例值：ES7921000813610123456789
     */
    @SerializedName("iban")
    private String iban;
    /**
     * 开户名
     * <p> 示例值：xxx有限公司
     */
    @SerializedName("account_name")
    private String accountName;
    /**
     * 币种三字码
     * <p> 示例值：CNY
     */
    @SerializedName("currency_code")
    private String currencyCode;
    /**
     * 银行本地清算代码
     * <p> 示例值：308290003732
     */
    @SerializedName("local_routing_code")
    private String localRoutingCode;
    /**
     * 总账科目编码
     * <p> 示例值：10020102
     */
    @SerializedName("gl_account_code")
    private String glAccountCode;
    /**
     * 清算科目编码
     * <p> 示例值：10020102
     */
    @SerializedName("clearing_account_code")
    private String clearingAccountCode;
    /**
     * swift
     * <p> 示例值：95566
     */
    @SerializedName("swift")
    private String swift;
    /**
     * 账户属性描述
     * <p> 示例值：支出户
     */
    @SerializedName("account_attri_desc")
    private String accountAttriDesc;
    /**
     * 账户属性描述多语言
     * <p> 示例值：
     */
    @SerializedName("i18n_account_attri_desc")
    private I18nStruct[] i18nAccountAttriDesc;

    // builder 开始
    public CompanyCompanyBankAccount() {
    }

    public CompanyCompanyBankAccount(Builder builder) {
        /**
         * 公司银行账号唯一ID
         * <p> 示例值：U1409787258113892352
         */
        this.companyBankAccountUid = builder.companyBankAccountUid;
        /**
         * 公司唯一ID
         * <p> 示例值：U1409787216334430208
         */
        this.companyUid = builder.companyUid;
        /**
         * 银行账号
         * <p> 示例值：642*********423
         */
        this.account = builder.account;
        /**
         * 国际银行账号
         * <p> 示例值：ES7921000813610123456789
         */
        this.iban = builder.iban;
        /**
         * 开户名
         * <p> 示例值：xxx有限公司
         */
        this.accountName = builder.accountName;
        /**
         * 币种三字码
         * <p> 示例值：CNY
         */
        this.currencyCode = builder.currencyCode;
        /**
         * 银行本地清算代码
         * <p> 示例值：308290003732
         */
        this.localRoutingCode = builder.localRoutingCode;
        /**
         * 总账科目编码
         * <p> 示例值：10020102
         */
        this.glAccountCode = builder.glAccountCode;
        /**
         * 清算科目编码
         * <p> 示例值：10020102
         */
        this.clearingAccountCode = builder.clearingAccountCode;
        /**
         * swift
         * <p> 示例值：95566
         */
        this.swift = builder.swift;
        /**
         * 账户属性描述
         * <p> 示例值：支出户
         */
        this.accountAttriDesc = builder.accountAttriDesc;
        /**
         * 账户属性描述多语言
         * <p> 示例值：
         */
        this.i18nAccountAttriDesc = builder.i18nAccountAttriDesc;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCompanyBankAccountUid() {
        return this.companyBankAccountUid;
    }

    public void setCompanyBankAccountUid(String companyBankAccountUid) {
        this.companyBankAccountUid = companyBankAccountUid;
    }

    public String getCompanyUid() {
        return this.companyUid;
    }

    public void setCompanyUid(String companyUid) {
        this.companyUid = companyUid;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getIban() {
        return this.iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getLocalRoutingCode() {
        return this.localRoutingCode;
    }

    public void setLocalRoutingCode(String localRoutingCode) {
        this.localRoutingCode = localRoutingCode;
    }

    public String getGlAccountCode() {
        return this.glAccountCode;
    }

    public void setGlAccountCode(String glAccountCode) {
        this.glAccountCode = glAccountCode;
    }

    public String getClearingAccountCode() {
        return this.clearingAccountCode;
    }

    public void setClearingAccountCode(String clearingAccountCode) {
        this.clearingAccountCode = clearingAccountCode;
    }

    public String getSwift() {
        return this.swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getAccountAttriDesc() {
        return this.accountAttriDesc;
    }

    public void setAccountAttriDesc(String accountAttriDesc) {
        this.accountAttriDesc = accountAttriDesc;
    }

    public I18nStruct[] getI18nAccountAttriDesc() {
        return this.i18nAccountAttriDesc;
    }

    public void setI18nAccountAttriDesc(I18nStruct[] i18nAccountAttriDesc) {
        this.i18nAccountAttriDesc = i18nAccountAttriDesc;
    }

    public static class Builder {
        /**
         * 公司银行账号唯一ID
         * <p> 示例值：U1409787258113892352
         */
        private String companyBankAccountUid;
        /**
         * 公司唯一ID
         * <p> 示例值：U1409787216334430208
         */
        private String companyUid;
        /**
         * 银行账号
         * <p> 示例值：642*********423
         */
        private String account;
        /**
         * 国际银行账号
         * <p> 示例值：ES7921000813610123456789
         */
        private String iban;
        /**
         * 开户名
         * <p> 示例值：xxx有限公司
         */
        private String accountName;
        /**
         * 币种三字码
         * <p> 示例值：CNY
         */
        private String currencyCode;
        /**
         * 银行本地清算代码
         * <p> 示例值：308290003732
         */
        private String localRoutingCode;
        /**
         * 总账科目编码
         * <p> 示例值：10020102
         */
        private String glAccountCode;
        /**
         * 清算科目编码
         * <p> 示例值：10020102
         */
        private String clearingAccountCode;
        /**
         * swift
         * <p> 示例值：95566
         */
        private String swift;
        /**
         * 账户属性描述
         * <p> 示例值：支出户
         */
        private String accountAttriDesc;
        /**
         * 账户属性描述多语言
         * <p> 示例值：
         */
        private I18nStruct[] i18nAccountAttriDesc;

        /**
         * 公司银行账号唯一ID
         * <p> 示例值：U1409787258113892352
         *
         * @param companyBankAccountUid
         * @return
         */
        public Builder companyBankAccountUid(String companyBankAccountUid) {
            this.companyBankAccountUid = companyBankAccountUid;
            return this;
        }


        /**
         * 公司唯一ID
         * <p> 示例值：U1409787216334430208
         *
         * @param companyUid
         * @return
         */
        public Builder companyUid(String companyUid) {
            this.companyUid = companyUid;
            return this;
        }


        /**
         * 银行账号
         * <p> 示例值：642*********423
         *
         * @param account
         * @return
         */
        public Builder account(String account) {
            this.account = account;
            return this;
        }


        /**
         * 国际银行账号
         * <p> 示例值：ES7921000813610123456789
         *
         * @param iban
         * @return
         */
        public Builder iban(String iban) {
            this.iban = iban;
            return this;
        }


        /**
         * 开户名
         * <p> 示例值：xxx有限公司
         *
         * @param accountName
         * @return
         */
        public Builder accountName(String accountName) {
            this.accountName = accountName;
            return this;
        }


        /**
         * 币种三字码
         * <p> 示例值：CNY
         *
         * @param currencyCode
         * @return
         */
        public Builder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }


        /**
         * 银行本地清算代码
         * <p> 示例值：308290003732
         *
         * @param localRoutingCode
         * @return
         */
        public Builder localRoutingCode(String localRoutingCode) {
            this.localRoutingCode = localRoutingCode;
            return this;
        }


        /**
         * 总账科目编码
         * <p> 示例值：10020102
         *
         * @param glAccountCode
         * @return
         */
        public Builder glAccountCode(String glAccountCode) {
            this.glAccountCode = glAccountCode;
            return this;
        }


        /**
         * 清算科目编码
         * <p> 示例值：10020102
         *
         * @param clearingAccountCode
         * @return
         */
        public Builder clearingAccountCode(String clearingAccountCode) {
            this.clearingAccountCode = clearingAccountCode;
            return this;
        }


        /**
         * swift
         * <p> 示例值：95566
         *
         * @param swift
         * @return
         */
        public Builder swift(String swift) {
            this.swift = swift;
            return this;
        }


        /**
         * 账户属性描述
         * <p> 示例值：支出户
         *
         * @param accountAttriDesc
         * @return
         */
        public Builder accountAttriDesc(String accountAttriDesc) {
            this.accountAttriDesc = accountAttriDesc;
            return this;
        }


        /**
         * 账户属性描述多语言
         * <p> 示例值：
         *
         * @param i18nAccountAttriDesc
         * @return
         */
        public Builder i18nAccountAttriDesc(I18nStruct[] i18nAccountAttriDesc) {
            this.i18nAccountAttriDesc = i18nAccountAttriDesc;
            return this;
        }


        public CompanyCompanyBankAccount build() {
            return new CompanyCompanyBankAccount(this);
        }
    }
}
