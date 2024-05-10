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

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.contact.v3.enums.*;
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

public class RemoveGroupMemberReqBody {
    /**
     * 用户组成员的类型，取值为 user
     * <p> 示例值：user
     */
    @SerializedName("member_type")
    private String memberType;
    /**
     * 操作移除的用户组成员ID
     * <p> 示例值：xj82871k
     */
    @SerializedName("member_id")
    private String memberId;
    /**
     * 当member_type =user时候，member_id_type表示user_id_type，枚举值为open_id, union_id, user_id
     * <p> 示例值：open_id
     */
    @SerializedName("member_id_type")
    private String memberIdType;

    // builder 开始
    public RemoveGroupMemberReqBody() {
    }

    public RemoveGroupMemberReqBody(Builder builder) {
        /**
         * 用户组成员的类型，取值为 user
         * <p> 示例值：user
         */
        this.memberType = builder.memberType;
        /**
         * 操作移除的用户组成员ID
         * <p> 示例值：xj82871k
         */
        this.memberId = builder.memberId;
        /**
         * 当member_type =user时候，member_id_type表示user_id_type，枚举值为open_id, union_id, user_id
         * <p> 示例值：open_id
         */
        this.memberIdType = builder.memberIdType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getMemberType() {
        return this.memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberIdType() {
        return this.memberIdType;
    }

    public void setMemberIdType(String memberIdType) {
        this.memberIdType = memberIdType;
    }

    public static class Builder {
        /**
         * 用户组成员的类型，取值为 user
         * <p> 示例值：user
         */
        private String memberType;
        /**
         * 操作移除的用户组成员ID
         * <p> 示例值：xj82871k
         */
        private String memberId;
        /**
         * 当member_type =user时候，member_id_type表示user_id_type，枚举值为open_id, union_id, user_id
         * <p> 示例值：open_id
         */
        private String memberIdType;

        /**
         * 用户组成员的类型，取值为 user
         * <p> 示例值：user
         *
         * @param memberType
         * @return
         */
        public Builder memberType(String memberType) {
            this.memberType = memberType;
            return this;
        }

        /**
         * 用户组成员的类型，取值为 user
         * <p> 示例值：user
         *
         * @param memberType {@link com.lark.oapi.service.contact.v3.enums.RemoveGroupMemberMemberTypeEnum}
         * @return
         */
        public Builder memberType(com.lark.oapi.service.contact.v3.enums.RemoveGroupMemberMemberTypeEnum memberType) {
            this.memberType = memberType.getValue();
            return this;
        }


        /**
         * 操作移除的用户组成员ID
         * <p> 示例值：xj82871k
         *
         * @param memberId
         * @return
         */
        public Builder memberId(String memberId) {
            this.memberId = memberId;
            return this;
        }


        /**
         * 当member_type =user时候，member_id_type表示user_id_type，枚举值为open_id, union_id, user_id
         * <p> 示例值：open_id
         *
         * @param memberIdType
         * @return
         */
        public Builder memberIdType(String memberIdType) {
            this.memberIdType = memberIdType;
            return this;
        }

        /**
         * 当member_type =user时候，member_id_type表示user_id_type，枚举值为open_id, union_id, user_id
         * <p> 示例值：open_id
         *
         * @param memberIdType {@link com.lark.oapi.service.contact.v3.enums.RemoveGroupMemberMemberIdTypeEnum}
         * @return
         */
        public Builder memberIdType(com.lark.oapi.service.contact.v3.enums.RemoveGroupMemberMemberIdTypeEnum memberIdType) {
            this.memberIdType = memberIdType.getValue();
            return this;
        }


        public RemoveGroupMemberReqBody build() {
            return new RemoveGroupMemberReqBody(this);
        }
    }
}
