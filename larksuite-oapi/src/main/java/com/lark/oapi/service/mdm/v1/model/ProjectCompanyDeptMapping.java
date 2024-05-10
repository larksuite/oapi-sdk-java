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

package com.lark.oapi.service.mdm.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.mdm.v1.enums.*;
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

public class ProjectCompanyDeptMapping {
    /**
     * 项目unionId
     * <p> 示例值：U0012312312333
     */
    @SerializedName("project_union_id")
    private String projectUnionId;
    /**
     * 公司unionId
     * <p> 示例值：U1233123123
     */
    @SerializedName("company_union_id")
    private String companyUnionId;
    /**
     * 是否全部部门
     * <p> 示例值：true
     */
    @SerializedName("is_all_department")
    private Boolean isAllDepartment;
    /**
     * 部门unionId
     * <p> 示例值：U123123123
     */
    @SerializedName("department_union_id")
    private String departmentUnionId;

    // builder 开始
    public ProjectCompanyDeptMapping() {
    }

    public ProjectCompanyDeptMapping(Builder builder) {
        /**
         * 项目unionId
         * <p> 示例值：U0012312312333
         */
        this.projectUnionId = builder.projectUnionId;
        /**
         * 公司unionId
         * <p> 示例值：U1233123123
         */
        this.companyUnionId = builder.companyUnionId;
        /**
         * 是否全部部门
         * <p> 示例值：true
         */
        this.isAllDepartment = builder.isAllDepartment;
        /**
         * 部门unionId
         * <p> 示例值：U123123123
         */
        this.departmentUnionId = builder.departmentUnionId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getProjectUnionId() {
        return this.projectUnionId;
    }

    public void setProjectUnionId(String projectUnionId) {
        this.projectUnionId = projectUnionId;
    }

    public String getCompanyUnionId() {
        return this.companyUnionId;
    }

    public void setCompanyUnionId(String companyUnionId) {
        this.companyUnionId = companyUnionId;
    }

    public Boolean getIsAllDepartment() {
        return this.isAllDepartment;
    }

    public void setIsAllDepartment(Boolean isAllDepartment) {
        this.isAllDepartment = isAllDepartment;
    }

    public String getDepartmentUnionId() {
        return this.departmentUnionId;
    }

    public void setDepartmentUnionId(String departmentUnionId) {
        this.departmentUnionId = departmentUnionId;
    }

    public static class Builder {
        /**
         * 项目unionId
         * <p> 示例值：U0012312312333
         */
        private String projectUnionId;
        /**
         * 公司unionId
         * <p> 示例值：U1233123123
         */
        private String companyUnionId;
        /**
         * 是否全部部门
         * <p> 示例值：true
         */
        private Boolean isAllDepartment;
        /**
         * 部门unionId
         * <p> 示例值：U123123123
         */
        private String departmentUnionId;

        /**
         * 项目unionId
         * <p> 示例值：U0012312312333
         *
         * @param projectUnionId
         * @return
         */
        public Builder projectUnionId(String projectUnionId) {
            this.projectUnionId = projectUnionId;
            return this;
        }


        /**
         * 公司unionId
         * <p> 示例值：U1233123123
         *
         * @param companyUnionId
         * @return
         */
        public Builder companyUnionId(String companyUnionId) {
            this.companyUnionId = companyUnionId;
            return this;
        }


        /**
         * 是否全部部门
         * <p> 示例值：true
         *
         * @param isAllDepartment
         * @return
         */
        public Builder isAllDepartment(Boolean isAllDepartment) {
            this.isAllDepartment = isAllDepartment;
            return this;
        }


        /**
         * 部门unionId
         * <p> 示例值：U123123123
         *
         * @param departmentUnionId
         * @return
         */
        public Builder departmentUnionId(String departmentUnionId) {
            this.departmentUnionId = departmentUnionId;
            return this;
        }


        public ProjectCompanyDeptMapping build() {
            return new ProjectCompanyDeptMapping(this);
        }
    }
}
