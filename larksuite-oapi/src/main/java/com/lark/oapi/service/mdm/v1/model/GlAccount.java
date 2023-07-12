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

public class GlAccount {
    /**
     * 会计科目唯一ID
     * <p> 示例值：U1404732463745343488
     */
    @SerializedName("gl_account_uid")
    private String glAccountUid;
    /**
     * 会计科目编码
     * <p> 示例值：51012006
     */
    @SerializedName("gl_account")
    private String glAccount;
    /**
     * 会计科目名称
     * <p> 示例值：管理费用-电力工程
     */
    @SerializedName("gl_account_name")
    private String glAccountName;
    /**
     * 会计科目名称多语言
     * <p> 示例值：
     */
    @SerializedName("i18n_gl_account_name")
    private I18nStruct[] i18nGlAccountName;
    /**
     * 会计科目类型
     * <p> 示例值：101
     */
    @SerializedName("type")
    private String type;
    /**
     * 有效期至，格式：yyyy-MM-dd
     * <p> 示例值：9999-12-31
     */
    @SerializedName("valid_to")
    private String validTo;

    // builder 开始
    public GlAccount() {
    }

    public GlAccount(Builder builder) {
        /**
         * 会计科目唯一ID
         * <p> 示例值：U1404732463745343488
         */
        this.glAccountUid = builder.glAccountUid;
        /**
         * 会计科目编码
         * <p> 示例值：51012006
         */
        this.glAccount = builder.glAccount;
        /**
         * 会计科目名称
         * <p> 示例值：管理费用-电力工程
         */
        this.glAccountName = builder.glAccountName;
        /**
         * 会计科目名称多语言
         * <p> 示例值：
         */
        this.i18nGlAccountName = builder.i18nGlAccountName;
        /**
         * 会计科目类型
         * <p> 示例值：101
         */
        this.type = builder.type;
        /**
         * 有效期至，格式：yyyy-MM-dd
         * <p> 示例值：9999-12-31
         */
        this.validTo = builder.validTo;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getGlAccountUid() {
        return this.glAccountUid;
    }

    public void setGlAccountUid(String glAccountUid) {
        this.glAccountUid = glAccountUid;
    }

    public String getGlAccount() {
        return this.glAccount;
    }

    public void setGlAccount(String glAccount) {
        this.glAccount = glAccount;
    }

    public String getGlAccountName() {
        return this.glAccountName;
    }

    public void setGlAccountName(String glAccountName) {
        this.glAccountName = glAccountName;
    }

    public I18nStruct[] getI18nGlAccountName() {
        return this.i18nGlAccountName;
    }

    public void setI18nGlAccountName(I18nStruct[] i18nGlAccountName) {
        this.i18nGlAccountName = i18nGlAccountName;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValidTo() {
        return this.validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

    public static class Builder {
        /**
         * 会计科目唯一ID
         * <p> 示例值：U1404732463745343488
         */
        private String glAccountUid;
        /**
         * 会计科目编码
         * <p> 示例值：51012006
         */
        private String glAccount;
        /**
         * 会计科目名称
         * <p> 示例值：管理费用-电力工程
         */
        private String glAccountName;
        /**
         * 会计科目名称多语言
         * <p> 示例值：
         */
        private I18nStruct[] i18nGlAccountName;
        /**
         * 会计科目类型
         * <p> 示例值：101
         */
        private String type;
        /**
         * 有效期至，格式：yyyy-MM-dd
         * <p> 示例值：9999-12-31
         */
        private String validTo;

        /**
         * 会计科目唯一ID
         * <p> 示例值：U1404732463745343488
         *
         * @param glAccountUid
         * @return
         */
        public Builder glAccountUid(String glAccountUid) {
            this.glAccountUid = glAccountUid;
            return this;
        }


        /**
         * 会计科目编码
         * <p> 示例值：51012006
         *
         * @param glAccount
         * @return
         */
        public Builder glAccount(String glAccount) {
            this.glAccount = glAccount;
            return this;
        }


        /**
         * 会计科目名称
         * <p> 示例值：管理费用-电力工程
         *
         * @param glAccountName
         * @return
         */
        public Builder glAccountName(String glAccountName) {
            this.glAccountName = glAccountName;
            return this;
        }


        /**
         * 会计科目名称多语言
         * <p> 示例值：
         *
         * @param i18nGlAccountName
         * @return
         */
        public Builder i18nGlAccountName(I18nStruct[] i18nGlAccountName) {
            this.i18nGlAccountName = i18nGlAccountName;
            return this;
        }


        /**
         * 会计科目类型
         * <p> 示例值：101
         *
         * @param type
         * @return
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }


        /**
         * 有效期至，格式：yyyy-MM-dd
         * <p> 示例值：9999-12-31
         *
         * @param validTo
         * @return
         */
        public Builder validTo(String validTo) {
            this.validTo = validTo;
            return this;
        }


        public GlAccount build() {
            return new GlAccount(this);
        }
    }
}
