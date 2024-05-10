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

import com.lark.oapi.core.response.EmptyData;
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.response.BaseResponse;

public class CombinedCreateJobReq {
    /**
     * 用户 ID 类型
     * <p> 示例值：open_id
     */
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    /**
     * 此次调用中使用的部门 ID 的类型
     * <p> 示例值：此次调用中使用的部门 ID 的类型
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
    @Body
    private CombinedJob body;

    // builder 开始
    public CombinedCreateJobReq() {
    }

    public CombinedCreateJobReq(Builder builder) {
        /**
         * 用户 ID 类型
         * <p> 示例值：open_id
         */
        this.userIdType = builder.userIdType;
        /**
         * 此次调用中使用的部门 ID 的类型
         * <p> 示例值：此次调用中使用的部门 ID 的类型
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

    public CombinedJob getCombinedJob() {
        return this.body;
    }

    public void setCombinedJob(CombinedJob body) {
        this.body = body;
    }

    public static class Builder {
        private String userIdType; // 用户 ID 类型
        private String departmentIdType; // 此次调用中使用的部门 ID 的类型
        private String jobLevelIdType; // 此次调用中使用的「职级 ID」的类型
        private String jobFamilyIdType; // 此次调用中使用的「序列 ID」的类型
        private CombinedJob body;

        /**
         * 用户 ID 类型
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
         * 此次调用中使用的部门 ID 的类型
         * <p> 示例值：此次调用中使用的部门 ID 的类型
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

        public CombinedJob getCombinedJob() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder combinedJob(CombinedJob body) {
            this.body = body;
            return this;
        }

        public CombinedCreateJobReq build() {
            return new CombinedCreateJobReq(this);
        }
    }
}
