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
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.response.BaseResponse;

public class AgencyInfo {
    /**
     * 猎头基本信息
     * <p> 示例值：
     */
    @SerializedName("basic_info")
    private AgencyBasicInfo basicInfo;
    /**
     * 猎头评价信息
     * <p> 示例值：
     */
    @SerializedName("comment_info")
    private ReportCustomData[] commentInfo;
    /**
     * 薪酬信息
     * <p> 示例值：
     */
    @SerializedName("salary_info")
    private ReportCustomData[] salaryInfo;

    // builder 开始
    public AgencyInfo() {
    }

    public AgencyInfo(Builder builder) {
        /**
         * 猎头基本信息
         * <p> 示例值：
         */
        this.basicInfo = builder.basicInfo;
        /**
         * 猎头评价信息
         * <p> 示例值：
         */
        this.commentInfo = builder.commentInfo;
        /**
         * 薪酬信息
         * <p> 示例值：
         */
        this.salaryInfo = builder.salaryInfo;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public AgencyBasicInfo getBasicInfo() {
        return this.basicInfo;
    }

    public void setBasicInfo(AgencyBasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public ReportCustomData[] getCommentInfo() {
        return this.commentInfo;
    }

    public void setCommentInfo(ReportCustomData[] commentInfo) {
        this.commentInfo = commentInfo;
    }

    public ReportCustomData[] getSalaryInfo() {
        return this.salaryInfo;
    }

    public void setSalaryInfo(ReportCustomData[] salaryInfo) {
        this.salaryInfo = salaryInfo;
    }

    public static class Builder {
        /**
         * 猎头基本信息
         * <p> 示例值：
         */
        private AgencyBasicInfo basicInfo;
        /**
         * 猎头评价信息
         * <p> 示例值：
         */
        private ReportCustomData[] commentInfo;
        /**
         * 薪酬信息
         * <p> 示例值：
         */
        private ReportCustomData[] salaryInfo;

        /**
         * 猎头基本信息
         * <p> 示例值：
         *
         * @param basicInfo
         * @return
         */
        public Builder basicInfo(AgencyBasicInfo basicInfo) {
            this.basicInfo = basicInfo;
            return this;
        }


        /**
         * 猎头评价信息
         * <p> 示例值：
         *
         * @param commentInfo
         * @return
         */
        public Builder commentInfo(ReportCustomData[] commentInfo) {
            this.commentInfo = commentInfo;
            return this;
        }


        /**
         * 薪酬信息
         * <p> 示例值：
         *
         * @param salaryInfo
         * @return
         */
        public Builder salaryInfo(ReportCustomData[] salaryInfo) {
            this.salaryInfo = salaryInfo;
            return this;
        }


        public AgencyInfo build() {
            return new AgencyInfo(this);
        }
    }
}