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

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.corehr.v2.enums.*;
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

public class WorkExperienceInfo {
    /**
     * 公司 / 组织
     * <p> 示例值：
     */
    @SerializedName("company_organization")
    private I18n[] companyOrganization;
    /**
     * 部门
     * <p> 示例值：
     */
    @SerializedName("department")
    private I18n[] department;
    /**
     * 岗位
     * <p> 示例值：
     */
    @SerializedName("job")
    private I18n[] job;
    /**
     * 工作描述
     * <p> 示例值：
     */
    @SerializedName("description")
    private I18n[] description;
    /**
     * 开始日期
     * <p> 示例值：2020-01-01
     */
    @SerializedName("start_date")
    private String startDate;
    /**
     * 结束日期
     * <p> 示例值：2020-01-01
     */
    @SerializedName("end_date")
    private String endDate;
    /**
     * 自定义字段
     * <p> 示例值：
     */
    @SerializedName("custom_fields")
    private CustomFieldData[] customFields;

    // builder 开始
    public WorkExperienceInfo() {
    }

    public WorkExperienceInfo(Builder builder) {
        /**
         * 公司 / 组织
         * <p> 示例值：
         */
        this.companyOrganization = builder.companyOrganization;
        /**
         * 部门
         * <p> 示例值：
         */
        this.department = builder.department;
        /**
         * 岗位
         * <p> 示例值：
         */
        this.job = builder.job;
        /**
         * 工作描述
         * <p> 示例值：
         */
        this.description = builder.description;
        /**
         * 开始日期
         * <p> 示例值：2020-01-01
         */
        this.startDate = builder.startDate;
        /**
         * 结束日期
         * <p> 示例值：2020-01-01
         */
        this.endDate = builder.endDate;
        /**
         * 自定义字段
         * <p> 示例值：
         */
        this.customFields = builder.customFields;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public I18n[] getCompanyOrganization() {
        return this.companyOrganization;
    }

    public void setCompanyOrganization(I18n[] companyOrganization) {
        this.companyOrganization = companyOrganization;
    }

    public I18n[] getDepartment() {
        return this.department;
    }

    public void setDepartment(I18n[] department) {
        this.department = department;
    }

    public I18n[] getJob() {
        return this.job;
    }

    public void setJob(I18n[] job) {
        this.job = job;
    }

    public I18n[] getDescription() {
        return this.description;
    }

    public void setDescription(I18n[] description) {
        this.description = description;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public CustomFieldData[] getCustomFields() {
        return this.customFields;
    }

    public void setCustomFields(CustomFieldData[] customFields) {
        this.customFields = customFields;
    }

    public static class Builder {
        /**
         * 公司 / 组织
         * <p> 示例值：
         */
        private I18n[] companyOrganization;
        /**
         * 部门
         * <p> 示例值：
         */
        private I18n[] department;
        /**
         * 岗位
         * <p> 示例值：
         */
        private I18n[] job;
        /**
         * 工作描述
         * <p> 示例值：
         */
        private I18n[] description;
        /**
         * 开始日期
         * <p> 示例值：2020-01-01
         */
        private String startDate;
        /**
         * 结束日期
         * <p> 示例值：2020-01-01
         */
        private String endDate;
        /**
         * 自定义字段
         * <p> 示例值：
         */
        private CustomFieldData[] customFields;

        /**
         * 公司 / 组织
         * <p> 示例值：
         *
         * @param companyOrganization
         * @return
         */
        public Builder companyOrganization(I18n[] companyOrganization) {
            this.companyOrganization = companyOrganization;
            return this;
        }


        /**
         * 部门
         * <p> 示例值：
         *
         * @param department
         * @return
         */
        public Builder department(I18n[] department) {
            this.department = department;
            return this;
        }


        /**
         * 岗位
         * <p> 示例值：
         *
         * @param job
         * @return
         */
        public Builder job(I18n[] job) {
            this.job = job;
            return this;
        }


        /**
         * 工作描述
         * <p> 示例值：
         *
         * @param description
         * @return
         */
        public Builder description(I18n[] description) {
            this.description = description;
            return this;
        }


        /**
         * 开始日期
         * <p> 示例值：2020-01-01
         *
         * @param startDate
         * @return
         */
        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }


        /**
         * 结束日期
         * <p> 示例值：2020-01-01
         *
         * @param endDate
         * @return
         */
        public Builder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }


        /**
         * 自定义字段
         * <p> 示例值：
         *
         * @param customFields
         * @return
         */
        public Builder customFields(CustomFieldData[] customFields) {
            this.customFields = customFields;
            return this;
        }


        public WorkExperienceInfo build() {
            return new WorkExperienceInfo(this);
        }
    }
}
