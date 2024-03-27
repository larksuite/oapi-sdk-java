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

package com.lark.oapi.service.hire.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Query;

public class ListByIdJobRequirementReq {
    /**
     * 此次调用中使用的用户ID的类型
     * <p> 示例值：
     */
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    /**
     * 此次调用中使用的部门 ID 的类型
     * <p> 示例值：
     */
    @Query
    @SerializedName("department_id_type")
    private String departmentIdType;
    /**
     * 此次调用中使用的「职级 ID」的类型
     * <p> 示例值：
     */
    @Query
    @SerializedName("job_level_id_type")
    private String jobLevelIdType;
    /**
     * 此次调用中使用的「序列 ID」的类型
     * <p> 示例值：
     */
    @Query
    @SerializedName("job_family_id_type")
    private String jobFamilyIdType;
    /**
     * 此次调用中使用的「人员类型 ID」的类型
     * <p> 示例值：
     */
    @Query
    @SerializedName("employee_type_id_type")
    private String employeeTypeIdType;
    @Body
    private ListByIdJobRequirementReqBody body;

    // builder 开始
    public ListByIdJobRequirementReq() {
    }

    public ListByIdJobRequirementReq(Builder builder) {
        /**
         * 此次调用中使用的用户ID的类型
         * <p> 示例值：
         */
        this.userIdType = builder.userIdType;
        /**
         * 此次调用中使用的部门 ID 的类型
         * <p> 示例值：
         */
        this.departmentIdType = builder.departmentIdType;
        /**
         * 此次调用中使用的「职级 ID」的类型
         * <p> 示例值：
         */
        this.jobLevelIdType = builder.jobLevelIdType;
        /**
         * 此次调用中使用的「序列 ID」的类型
         * <p> 示例值：
         */
        this.jobFamilyIdType = builder.jobFamilyIdType;
        /**
         * 此次调用中使用的「人员类型 ID」的类型
         * <p> 示例值：
         */
        this.employeeTypeIdType = builder.employeeTypeIdType;
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

    public String getJobLevelIdType() {
        return this.jobLevelIdType;
    }

    public void setJobLevelIdType(String jobLevelIdType) {
        this.jobLevelIdType = jobLevelIdType;
    }

    public String getJobFamilyIdType() {
        return this.jobFamilyIdType;
    }

    public void setJobFamilyIdType(String jobFamilyIdType) {
        this.jobFamilyIdType = jobFamilyIdType;
    }

    public String getEmployeeTypeIdType() {
        return this.employeeTypeIdType;
    }

    public void setEmployeeTypeIdType(String employeeTypeIdType) {
        this.employeeTypeIdType = employeeTypeIdType;
    }

    public ListByIdJobRequirementReqBody getListByIdJobRequirementReqBody() {
        return this.body;
    }

    public void setListByIdJobRequirementReqBody(ListByIdJobRequirementReqBody body) {
        this.body = body;
    }

    public static class Builder {
        private String userIdType; // 此次调用中使用的用户ID的类型
        private String departmentIdType; // 此次调用中使用的部门 ID 的类型
        private String jobLevelIdType; // 此次调用中使用的「职级 ID」的类型
        private String jobFamilyIdType; // 此次调用中使用的「序列 ID」的类型
        private String employeeTypeIdType; // 此次调用中使用的「人员类型 ID」的类型
        private ListByIdJobRequirementReqBody body;

        /**
         * 此次调用中使用的用户ID的类型
         * <p> 示例值：
         *
         * @param userIdType
         * @return
         */
        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        /**
         * 此次调用中使用的部门 ID 的类型
         * <p> 示例值：
         *
         * @param departmentIdType
         * @return
         */
        public Builder departmentIdType(String departmentIdType) {
            this.departmentIdType = departmentIdType;
            return this;
        }

        /**
         * 此次调用中使用的「职级 ID」的类型
         * <p> 示例值：
         *
         * @param jobLevelIdType
         * @return
         */
        public Builder jobLevelIdType(String jobLevelIdType) {
            this.jobLevelIdType = jobLevelIdType;
            return this;
        }

        /**
         * 此次调用中使用的「序列 ID」的类型
         * <p> 示例值：
         *
         * @param jobFamilyIdType
         * @return
         */
        public Builder jobFamilyIdType(String jobFamilyIdType) {
            this.jobFamilyIdType = jobFamilyIdType;
            return this;
        }

        /**
         * 此次调用中使用的「人员类型 ID」的类型
         * <p> 示例值：
         *
         * @param employeeTypeIdType
         * @return
         */
        public Builder employeeTypeIdType(String employeeTypeIdType) {
            this.employeeTypeIdType = employeeTypeIdType;
            return this;
        }

        public ListByIdJobRequirementReqBody getListByIdJobRequirementReqBody() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder listByIdJobRequirementReqBody(ListByIdJobRequirementReqBody body) {
            this.body = body;
            return this;
        }

        public ListByIdJobRequirementReq build() {
            return new ListByIdJobRequirementReq(this);
        }
    }
}
