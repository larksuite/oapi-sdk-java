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

public class AssignedOrganizationWithCode {
    /**
     * 管理对象key
     * <p> 示例值：department
     */
    @SerializedName("org_key")
    private String orgKey;
    /**
     * 管理对象id列表
     * <p> 示例值：
     */
    @SerializedName("org_ids")
    private String[] orgIds;
    /**
     * 管理对象code列表
     * <p> 示例值：
     */
    @SerializedName("org_codes")
    private String[] orgCodes;

    // builder 开始
    public AssignedOrganizationWithCode() {
    }

    public AssignedOrganizationWithCode(Builder builder) {
        /**
         * 管理对象key
         * <p> 示例值：department
         */
        this.orgKey = builder.orgKey;
        /**
         * 管理对象id列表
         * <p> 示例值：
         */
        this.orgIds = builder.orgIds;
        /**
         * 管理对象code列表
         * <p> 示例值：
         */
        this.orgCodes = builder.orgCodes;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getOrgKey() {
        return this.orgKey;
    }

    public void setOrgKey(String orgKey) {
        this.orgKey = orgKey;
    }

    public String[] getOrgIds() {
        return this.orgIds;
    }

    public void setOrgIds(String[] orgIds) {
        this.orgIds = orgIds;
    }

    public String[] getOrgCodes() {
        return this.orgCodes;
    }

    public void setOrgCodes(String[] orgCodes) {
        this.orgCodes = orgCodes;
    }

    public static class Builder {
        /**
         * 管理对象key
         * <p> 示例值：department
         */
        private String orgKey;
        /**
         * 管理对象id列表
         * <p> 示例值：
         */
        private String[] orgIds;
        /**
         * 管理对象code列表
         * <p> 示例值：
         */
        private String[] orgCodes;

        /**
         * 管理对象key
         * <p> 示例值：department
         *
         * @param orgKey
         * @return
         */
        public Builder orgKey(String orgKey) {
            this.orgKey = orgKey;
            return this;
        }


        /**
         * 管理对象id列表
         * <p> 示例值：
         *
         * @param orgIds
         * @return
         */
        public Builder orgIds(String[] orgIds) {
            this.orgIds = orgIds;
            return this;
        }


        /**
         * 管理对象code列表
         * <p> 示例值：
         *
         * @param orgCodes
         * @return
         */
        public Builder orgCodes(String[] orgCodes) {
            this.orgCodes = orgCodes;
            return this;
        }


        public AssignedOrganizationWithCode build() {
            return new AssignedOrganizationWithCode(this);
        }
    }
}
