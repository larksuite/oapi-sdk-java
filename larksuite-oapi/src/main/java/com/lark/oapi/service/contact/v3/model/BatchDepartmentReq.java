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

public class BatchDepartmentReq {
    /**
     * 查询的部门ID列表，类型需要与department_id_type对应
     * <p> 示例值：
     */
    @Query
    @SerializedName("department_ids")
    private String[] departmentIds;
    /**
     * 说明请求中department_id_list参数所使用的部门ID类型
     * <p> 示例值：open_department_id
     */
    @Query
    @SerializedName("department_id_type")
    private String departmentIdType;
    /**
     * 指定调用结果中包含用户（如部门leader）关联的用户ID类型
     * <p> 示例值：open_id
     */
    @Query
    @SerializedName("user_id_type")
    private String userIdType;

    // builder 开始
    public BatchDepartmentReq() {
    }

    public BatchDepartmentReq(Builder builder) {
        /**
         * 查询的部门ID列表，类型需要与department_id_type对应
         * <p> 示例值：
         */
        this.departmentIds = builder.departmentIds;
        /**
         * 说明请求中department_id_list参数所使用的部门ID类型
         * <p> 示例值：open_department_id
         */
        this.departmentIdType = builder.departmentIdType;
        /**
         * 指定调用结果中包含用户（如部门leader）关联的用户ID类型
         * <p> 示例值：open_id
         */
        this.userIdType = builder.userIdType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String[] getDepartmentIds() {
        return this.departmentIds;
    }

    public void setDepartmentIds(String[] departmentIds) {
        this.departmentIds = departmentIds;
    }

    public String getDepartmentIdType() {
        return this.departmentIdType;
    }

    public void setDepartmentIdType(String departmentIdType) {
        this.departmentIdType = departmentIdType;
    }

    public String getUserIdType() {
        return this.userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
    }

    public static class Builder {
        private String[] departmentIds; // 查询的部门ID列表，类型需要与department_id_type对应
        private String departmentIdType; // 说明请求中department_id_list参数所使用的部门ID类型
        private String userIdType; // 指定调用结果中包含用户（如部门leader）关联的用户ID类型


        /**
         * 查询的部门ID列表，类型需要与department_id_type对应
         * <p> 示例值：
         *
         * @param departmentIds
         * @return
         */
        public Builder departmentIds(String[] departmentIds) {
            this.departmentIds = departmentIds;
            return this;
        }


        /**
         * 说明请求中department_id_list参数所使用的部门ID类型
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
         * 说明请求中department_id_list参数所使用的部门ID类型
         * <p> 示例值：open_department_id
         *
         * @param departmentIdType {@link com.lark.oapi.service.contact.v3.enums.BatchDepartmentDepartmentIdTypeEnum}
         * @return
         */
        public Builder departmentIdType(com.lark.oapi.service.contact.v3.enums.BatchDepartmentDepartmentIdTypeEnum departmentIdType) {
            this.departmentIdType = departmentIdType.getValue();
            return this;
        }


        /**
         * 指定调用结果中包含用户（如部门leader）关联的用户ID类型
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
         * 指定调用结果中包含用户（如部门leader）关联的用户ID类型
         * <p> 示例值：open_id
         *
         * @param userIdType {@link com.lark.oapi.service.contact.v3.enums.BatchDepartmentUserIdTypeEnum}
         * @return
         */
        public Builder userIdType(com.lark.oapi.service.contact.v3.enums.BatchDepartmentUserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        public BatchDepartmentReq build() {
            return new BatchDepartmentReq(this);
        }
    }
}
