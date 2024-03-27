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

package com.lark.oapi.service.corehr.v2.model;

import com.google.gson.annotations.SerializedName;

public class EmployeeJobData {
    /**
     * Employment ID
     * <p> 示例值：6893014062142064135
     */
    @SerializedName("employment_id")
    private String employmentId;
    /**
     * 实体在 CoreHR 内部的唯一键
     * <p> 示例值：6890452208593372679
     */
    @SerializedName("job_datas")
    private JobData[] jobDatas;

    // builder 开始
    public EmployeeJobData() {
    }

    public EmployeeJobData(Builder builder) {
        /**
         * Employment ID
         * <p> 示例值：6893014062142064135
         */
        this.employmentId = builder.employmentId;
        /**
         * 实体在 CoreHR 内部的唯一键
         * <p> 示例值：6890452208593372679
         */
        this.jobDatas = builder.jobDatas;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getEmploymentId() {
        return this.employmentId;
    }

    public void setEmploymentId(String employmentId) {
        this.employmentId = employmentId;
    }

    public JobData[] getJobDatas() {
        return this.jobDatas;
    }

    public void setJobDatas(JobData[] jobDatas) {
        this.jobDatas = jobDatas;
    }

    public static class Builder {
        /**
         * Employment ID
         * <p> 示例值：6893014062142064135
         */
        private String employmentId;
        /**
         * 实体在 CoreHR 内部的唯一键
         * <p> 示例值：6890452208593372679
         */
        private JobData[] jobDatas;

        /**
         * Employment ID
         * <p> 示例值：6893014062142064135
         *
         * @param employmentId
         * @return
         */
        public Builder employmentId(String employmentId) {
            this.employmentId = employmentId;
            return this;
        }


        /**
         * 实体在 CoreHR 内部的唯一键
         * <p> 示例值：6890452208593372679
         *
         * @param jobDatas
         * @return
         */
        public Builder jobDatas(JobData[] jobDatas) {
            this.jobDatas = jobDatas;
            return this;
        }


        public EmployeeJobData build() {
            return new EmployeeJobData(this);
        }
    }
}
