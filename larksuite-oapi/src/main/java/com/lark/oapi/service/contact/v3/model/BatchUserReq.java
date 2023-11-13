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
import com.lark.oapi.core.annotation.Query;

public class BatchUserReq {
    /**
     * 要查询的用户ID列表
     * <p> 示例值：
     */
    @Query
    @SerializedName("user_ids")
    private String[] userIds;
    /**
     * 指定请求中用户ID类型
     * <p> 示例值：open_id
     */
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    /**
     * 指定查询结果中用户关联的部门ID类型
     * <p> 示例值：open_department_id
     */
    @Query
    @SerializedName("department_id_type")
    private String departmentIdType;

    // builder 开始
    public BatchUserReq() {
    }

    public BatchUserReq(Builder builder) {
        /**
         * 要查询的用户ID列表
         * <p> 示例值：
         */
        this.userIds = builder.userIds;
        /**
         * 指定请求中用户ID类型
         * <p> 示例值：open_id
         */
        this.userIdType = builder.userIdType;
        /**
         * 指定查询结果中用户关联的部门ID类型
         * <p> 示例值：open_department_id
         */
        this.departmentIdType = builder.departmentIdType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String[] getUserIds() {
        return this.userIds;
    }

    public void setUserIds(String[] userIds) {
        this.userIds = userIds;
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

    public static class Builder {
        private String[] userIds; // 要查询的用户ID列表
        private String userIdType; // 指定请求中用户ID类型
        private String departmentIdType; // 指定查询结果中用户关联的部门ID类型


        /**
         * 要查询的用户ID列表
         * <p> 示例值：
         *
         * @param userIds
         * @return
         */
        public Builder userIds(String[] userIds) {
            this.userIds = userIds;
            return this;
        }


        /**
         * 指定请求中用户ID类型
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
         * 指定请求中用户ID类型
         * <p> 示例值：open_id
         *
         * @param userIdType {@link com.lark.oapi.service.contact.v3.enums.BatchUserUserIdTypeEnum}
         * @return
         */
        public Builder userIdType(com.lark.oapi.service.contact.v3.enums.BatchUserUserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }


        /**
         * 指定查询结果中用户关联的部门ID类型
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
         * 指定查询结果中用户关联的部门ID类型
         * <p> 示例值：open_department_id
         *
         * @param departmentIdType {@link com.lark.oapi.service.contact.v3.enums.BatchUserDepartmentIdTypeEnum}
         * @return
         */
        public Builder departmentIdType(com.lark.oapi.service.contact.v3.enums.BatchUserDepartmentIdTypeEnum departmentIdType) {
            this.departmentIdType = departmentIdType.getValue();
            return this;
        }

        public BatchUserReq build() {
            return new BatchUserReq(this);
        }
    }
}