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

public class GlAccountCompanyRelationship {
    /**
     * 会计科目编码
     * <p> 示例值：U1404733114483220480
     */
    @SerializedName("gl_account_code")
    private String glAccountCode;
    /**
     * 公司编码
     * <p> 示例值：U1404700185187065856
     */
    @SerializedName("company_code")
    private String companyCode;
    /**
     * 会计科目公司关系唯一ID
     * <p> 示例值：U1404732747611643904
     */
    @SerializedName("gl_account_company_relationship_uid")
    private String glAccountCompanyRelationshipUid;
    /**
     * 有效期至，格式：yyyy-MM-dd
     * <p> 示例值：2021-12-31
     */
    @SerializedName("valid_to")
    private String validTo;

    // builder 开始
    public GlAccountCompanyRelationship() {
    }

    public GlAccountCompanyRelationship(Builder builder) {
        /**
         * 会计科目编码
         * <p> 示例值：U1404733114483220480
         */
        this.glAccountCode = builder.glAccountCode;
        /**
         * 公司编码
         * <p> 示例值：U1404700185187065856
         */
        this.companyCode = builder.companyCode;
        /**
         * 会计科目公司关系唯一ID
         * <p> 示例值：U1404732747611643904
         */
        this.glAccountCompanyRelationshipUid = builder.glAccountCompanyRelationshipUid;
        /**
         * 有效期至，格式：yyyy-MM-dd
         * <p> 示例值：2021-12-31
         */
        this.validTo = builder.validTo;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getGlAccountCode() {
        return this.glAccountCode;
    }

    public void setGlAccountCode(String glAccountCode) {
        this.glAccountCode = glAccountCode;
    }

    public String getCompanyCode() {
        return this.companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getGlAccountCompanyRelationshipUid() {
        return this.glAccountCompanyRelationshipUid;
    }

    public void setGlAccountCompanyRelationshipUid(String glAccountCompanyRelationshipUid) {
        this.glAccountCompanyRelationshipUid = glAccountCompanyRelationshipUid;
    }

    public String getValidTo() {
        return this.validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

    public static class Builder {
        /**
         * 会计科目编码
         * <p> 示例值：U1404733114483220480
         */
        private String glAccountCode;
        /**
         * 公司编码
         * <p> 示例值：U1404700185187065856
         */
        private String companyCode;
        /**
         * 会计科目公司关系唯一ID
         * <p> 示例值：U1404732747611643904
         */
        private String glAccountCompanyRelationshipUid;
        /**
         * 有效期至，格式：yyyy-MM-dd
         * <p> 示例值：2021-12-31
         */
        private String validTo;

        /**
         * 会计科目编码
         * <p> 示例值：U1404733114483220480
         *
         * @param glAccountCode
         * @return
         */
        public Builder glAccountCode(String glAccountCode) {
            this.glAccountCode = glAccountCode;
            return this;
        }


        /**
         * 公司编码
         * <p> 示例值：U1404700185187065856
         *
         * @param companyCode
         * @return
         */
        public Builder companyCode(String companyCode) {
            this.companyCode = companyCode;
            return this;
        }


        /**
         * 会计科目公司关系唯一ID
         * <p> 示例值：U1404732747611643904
         *
         * @param glAccountCompanyRelationshipUid
         * @return
         */
        public Builder glAccountCompanyRelationshipUid(String glAccountCompanyRelationshipUid) {
            this.glAccountCompanyRelationshipUid = glAccountCompanyRelationshipUid;
            return this;
        }


        /**
         * 有效期至，格式：yyyy-MM-dd
         * <p> 示例值：2021-12-31
         *
         * @param validTo
         * @return
         */
        public Builder validTo(String validTo) {
            this.validTo = validTo;
            return this;
        }


        public GlAccountCompanyRelationship build() {
            return new GlAccountCompanyRelationship(this);
        }
    }
}
