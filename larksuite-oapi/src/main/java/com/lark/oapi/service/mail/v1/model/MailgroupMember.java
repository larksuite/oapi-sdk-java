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

package com.lark.oapi.service.mail.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.mail.v1.enums.*;
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

public class MailgroupMember {
    /**
     * 邮件组内成员唯一标识
     * <p> 示例值：xxxxxxxxxxxxxxx
     */
    @SerializedName("member_id")
    private String memberId;
    /**
     * 成员邮箱地址（当成员类型是EXTERNAL_USER/MAIL_GROUP/OTHER_MEMBER时有值）
     * <p> 示例值：test_memeber@xxx.xx
     */
    @SerializedName("email")
    private String email;
    /**
     * 租户内用户的唯一标识（当成员类型是USER时有值）
     * <p> 示例值：xxxxxxxxxx
     */
    @SerializedName("user_id")
    private String userId;
    /**
     * 租户内部门的唯一标识（当成员类型是DEPARTMENT时有值）
     * <p> 示例值：xxxxxxxxxx
     */
    @SerializedName("department_id")
    private String departmentId;
    /**
     * 成员类型
     * <p> 示例值：USER
     */
    @SerializedName("type")
    private String type;

    // builder 开始
    public MailgroupMember() {
    }

    public MailgroupMember(Builder builder) {
        /**
         * 邮件组内成员唯一标识
         * <p> 示例值：xxxxxxxxxxxxxxx
         */
        this.memberId = builder.memberId;
        /**
         * 成员邮箱地址（当成员类型是EXTERNAL_USER/MAIL_GROUP/OTHER_MEMBER时有值）
         * <p> 示例值：test_memeber@xxx.xx
         */
        this.email = builder.email;
        /**
         * 租户内用户的唯一标识（当成员类型是USER时有值）
         * <p> 示例值：xxxxxxxxxx
         */
        this.userId = builder.userId;
        /**
         * 租户内部门的唯一标识（当成员类型是DEPARTMENT时有值）
         * <p> 示例值：xxxxxxxxxx
         */
        this.departmentId = builder.departmentId;
        /**
         * 成员类型
         * <p> 示例值：USER
         */
        this.type = builder.type;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getMemberId() {
        return this.memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class Builder {
        /**
         * 邮件组内成员唯一标识
         * <p> 示例值：xxxxxxxxxxxxxxx
         */
        private String memberId;
        /**
         * 成员邮箱地址（当成员类型是EXTERNAL_USER/MAIL_GROUP/OTHER_MEMBER时有值）
         * <p> 示例值：test_memeber@xxx.xx
         */
        private String email;
        /**
         * 租户内用户的唯一标识（当成员类型是USER时有值）
         * <p> 示例值：xxxxxxxxxx
         */
        private String userId;
        /**
         * 租户内部门的唯一标识（当成员类型是DEPARTMENT时有值）
         * <p> 示例值：xxxxxxxxxx
         */
        private String departmentId;
        /**
         * 成员类型
         * <p> 示例值：USER
         */
        private String type;

        /**
         * 邮件组内成员唯一标识
         * <p> 示例值：xxxxxxxxxxxxxxx
         *
         * @param memberId
         * @return
         */
        public Builder memberId(String memberId) {
            this.memberId = memberId;
            return this;
        }


        /**
         * 成员邮箱地址（当成员类型是EXTERNAL_USER/MAIL_GROUP/OTHER_MEMBER时有值）
         * <p> 示例值：test_memeber@xxx.xx
         *
         * @param email
         * @return
         */
        public Builder email(String email) {
            this.email = email;
            return this;
        }


        /**
         * 租户内用户的唯一标识（当成员类型是USER时有值）
         * <p> 示例值：xxxxxxxxxx
         *
         * @param userId
         * @return
         */
        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }


        /**
         * 租户内部门的唯一标识（当成员类型是DEPARTMENT时有值）
         * <p> 示例值：xxxxxxxxxx
         *
         * @param departmentId
         * @return
         */
        public Builder departmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }


        /**
         * 成员类型
         * <p> 示例值：USER
         *
         * @param type
         * @return
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * 成员类型
         * <p> 示例值：USER
         *
         * @param type {@link com.lark.oapi.service.mail.v1.enums.MailgroupMemberTypeEnum}
         * @return
         */
        public Builder type(com.lark.oapi.service.mail.v1.enums.MailgroupMemberTypeEnum type) {
            this.type = type.getValue();
            return this;
        }


        public MailgroupMember build() {
            return new MailgroupMember(this);
        }
    }
}
