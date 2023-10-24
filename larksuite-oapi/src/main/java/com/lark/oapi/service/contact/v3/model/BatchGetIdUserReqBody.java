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

package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;

public class BatchGetIdUserReqBody {
    /**
     * 要查询的用户邮箱，最多 50 条。;;注意，emails与mobiles相互独立，每条用户邮箱返回对应的用户ID。;;本接口返回的用户ID数量为emails数量与mobiles数量的和。
     * <p> 示例值：zhangsan@a.com
     */
    @SerializedName("emails")
    private String[] emails;
    /**
     * 要查询的用户手机号，最多 50 条。;;注意;1. emails与mobiles相互独立，每条用户手机号返回对应的用户ID。;2.  非中国大陆地区的手机号需要添加以 “+” 开头的国家 / 地区代码。
     * <p> 示例值：13812345678
     */
    @SerializedName("mobiles")
    private String[] mobiles;
    /**
     * 查询结果包含离职员工，可查询离职用户的ID
     * <p> 示例值：true
     */
    @SerializedName("include_resigned")
    private Boolean includeResigned;

    // builder 开始
    public BatchGetIdUserReqBody() {
    }

    public BatchGetIdUserReqBody(Builder builder) {
        /**
         * 要查询的用户邮箱，最多 50 条。;;注意，emails与mobiles相互独立，每条用户邮箱返回对应的用户ID。;;本接口返回的用户ID数量为emails数量与mobiles数量的和。
         * <p> 示例值：zhangsan@a.com
         */
        this.emails = builder.emails;
        /**
         * 要查询的用户手机号，最多 50 条。;;注意;1. emails与mobiles相互独立，每条用户手机号返回对应的用户ID。;2.  非中国大陆地区的手机号需要添加以 “+” 开头的国家 / 地区代码。
         * <p> 示例值：13812345678
         */
        this.mobiles = builder.mobiles;
        /**
         * 查询结果包含离职员工，可查询离职用户的ID
         * <p> 示例值：true
         */
        this.includeResigned = builder.includeResigned;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String[] getEmails() {
        return this.emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    public String[] getMobiles() {
        return this.mobiles;
    }

    public void setMobiles(String[] mobiles) {
        this.mobiles = mobiles;
    }

    public Boolean getIncludeResigned() {
        return this.includeResigned;
    }

    public void setIncludeResigned(Boolean includeResigned) {
        this.includeResigned = includeResigned;
    }

    public static class Builder {
        /**
         * 要查询的用户邮箱，最多 50 条。;;注意，emails与mobiles相互独立，每条用户邮箱返回对应的用户ID。;;本接口返回的用户ID数量为emails数量与mobiles数量的和。
         * <p> 示例值：zhangsan@a.com
         */
        private String[] emails;
        /**
         * 要查询的用户手机号，最多 50 条。;;注意;1. emails与mobiles相互独立，每条用户手机号返回对应的用户ID。;2.  非中国大陆地区的手机号需要添加以 “+” 开头的国家 / 地区代码。
         * <p> 示例值：13812345678
         */
        private String[] mobiles;
        /**
         * 查询结果包含离职员工，可查询离职用户的ID
         * <p> 示例值：true
         */
        private Boolean includeResigned;

        /**
         * 要查询的用户邮箱，最多 50 条。;;注意，emails与mobiles相互独立，每条用户邮箱返回对应的用户ID。;;本接口返回的用户ID数量为emails数量与mobiles数量的和。
         * <p> 示例值：zhangsan@a.com
         *
         * @param emails
         * @return
         */
        public Builder emails(String[] emails) {
            this.emails = emails;
            return this;
        }


        /**
         * 要查询的用户手机号，最多 50 条。;;注意;1. emails与mobiles相互独立，每条用户手机号返回对应的用户ID。;2.  非中国大陆地区的手机号需要添加以 “+” 开头的国家 / 地区代码。
         * <p> 示例值：13812345678
         *
         * @param mobiles
         * @return
         */
        public Builder mobiles(String[] mobiles) {
            this.mobiles = mobiles;
            return this;
        }


        /**
         * 查询结果包含离职员工，可查询离职用户的ID
         * <p> 示例值：true
         *
         * @param includeResigned
         * @return
         */
        public Builder includeResigned(Boolean includeResigned) {
            this.includeResigned = includeResigned;
            return this;
        }


        public BatchGetIdUserReqBody build() {
            return new BatchGetIdUserReqBody(this);
        }
    }
}
