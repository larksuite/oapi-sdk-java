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
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class PatchGroupReq {
    /**
     * 此次调用中使用的用户ID的类型
     * <p> 示例值：open_id
     */
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    /**
     * 此次调用中使用的部门ID的类型
     * <p> 示例值：open_department_id
     */
    @Query
    @SerializedName("department_id_type")
    private String departmentIdType;
    /**
     * 用户组ID
     * <p> 示例值：g187131
     */
    @Path
    @SerializedName("group_id")
    private String groupId;
    @Body
    private Group body;

    // builder 开始
    public PatchGroupReq() {
    }

    public PatchGroupReq(Builder builder) {
        /**
         * 此次调用中使用的用户ID的类型
         * <p> 示例值：open_id
         */
        this.userIdType = builder.userIdType;
        /**
         * 此次调用中使用的部门ID的类型
         * <p> 示例值：open_department_id
         */
        this.departmentIdType = builder.departmentIdType;
        /**
         * 用户组ID
         * <p> 示例值：g187131
         */
        this.groupId = builder.groupId;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUserIdType() {
        return this.userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
    }

    public String getDepartmentIdType() {
        return this.departmentIdType;
    }

    public void setDepartmentIdType(String departmentIdType) {
        this.departmentIdType = departmentIdType;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Group getGroup() {
        return this.body;
    }

    public void setGroup(Group body) {
        this.body = body;
    }

    public static class Builder {
        private String userIdType; // 此次调用中使用的用户ID的类型
        private String departmentIdType; // 此次调用中使用的部门ID的类型
        private String groupId; // 用户组ID
        private Group body;

        /**
         * 此次调用中使用的用户ID的类型
         * <p> 示例值：open_id
         *
         * @param userIdType
         * @return
         */
        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        /**
         * 此次调用中使用的用户ID的类型
         * <p> 示例值：open_id
         *
         * @param userIdType {@link com.lark.oapi.service.contact.v3.enums.PatchGroupUserIdTypeEnum}
         * @return
         */
        public Builder userIdType(com.lark.oapi.service.contact.v3.enums.PatchGroupUserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        /**
         * 此次调用中使用的部门ID的类型
         * <p> 示例值：open_department_id
         *
         * @param departmentIdType
         * @return
         */
        public Builder departmentIdType(String departmentIdType) {
            this.departmentIdType = departmentIdType;
            return this;
        }

        /**
         * 此次调用中使用的部门ID的类型
         * <p> 示例值：open_department_id
         *
         * @param departmentIdType {@link com.lark.oapi.service.contact.v3.enums.PatchGroupDepartmentIdTypeEnum}
         * @return
         */
        public Builder departmentIdType(com.lark.oapi.service.contact.v3.enums.PatchGroupDepartmentIdTypeEnum departmentIdType) {
            this.departmentIdType = departmentIdType.getValue();
            return this;
        }

        /**
         * 用户组ID
         * <p> 示例值：g187131
         *
         * @param groupId
         * @return
         */
        public Builder groupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public Group getGroup() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder group(Group body) {
            this.body = body;
            return this;
        }

        public PatchGroupReq build() {
            return new PatchGroupReq(this);
        }
    }
}
