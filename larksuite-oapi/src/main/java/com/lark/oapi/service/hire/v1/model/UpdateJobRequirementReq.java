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
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class UpdateJobRequirementReq {
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
     * 招聘需求ID
     * <p> 示例值：623455234
     */
    @Path
    @SerializedName("job_requirement_id")
    private String jobRequirementId;
    @Body
    private JobRequirement body;

    // builder 开始
    public UpdateJobRequirementReq() {
    }

    public UpdateJobRequirementReq(Builder builder) {
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
         * 招聘需求ID
         * <p> 示例值：623455234
         */
        this.jobRequirementId = builder.jobRequirementId;
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

    public String getJobRequirementId() {
        return this.jobRequirementId;
    }

    public void setJobRequirementId(String jobRequirementId) {
        this.jobRequirementId = jobRequirementId;
    }

    public JobRequirement getJobRequirement() {
        return this.body;
    }

    public void setJobRequirement(JobRequirement body) {
        this.body = body;
    }

    public static class Builder {
        private String userIdType; // 此次调用中使用的用户ID的类型
        private String departmentIdType; // 此次调用中使用的部门 ID 的类型
        private String jobRequirementId; // 招聘需求ID
        private JobRequirement body;

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
         * 招聘需求ID
         * <p> 示例值：623455234
         *
         * @param jobRequirementId
         * @return
         */
        public Builder jobRequirementId(String jobRequirementId) {
            this.jobRequirementId = jobRequirementId;
            return this;
        }

        public JobRequirement getJobRequirement() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder jobRequirement(JobRequirement body) {
            this.body = body;
            return this;
        }

        public UpdateJobRequirementReq build() {
            return new UpdateJobRequirementReq(this);
        }
    }
}
