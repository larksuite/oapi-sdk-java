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

public class EcoBackgroundCheckReportFile {
    /**
     * 报告名称
     * <p> 示例值：阶段报告.pdf
     */
    @SerializedName("report_name")
    private String reportName;
    /**
     * 报告地址
     * <p> 示例值：https://xxxxx/xxxxxx/xxxx.pdf
     */
    @SerializedName("report_url")
    private String reportUrl;
    /**
     * 报告地址类型；枚举值 1 或为空时为可下载的 pdf 链接，2 为预览型链接
     * <p> 示例值：1
     */
    @SerializedName("report_url_type")
    private Integer reportUrlType;

    // builder 开始
    public EcoBackgroundCheckReportFile() {
    }

    public EcoBackgroundCheckReportFile(Builder builder) {
        /**
         * 报告名称
         * <p> 示例值：阶段报告.pdf
         */
        this.reportName = builder.reportName;
        /**
         * 报告地址
         * <p> 示例值：https://xxxxx/xxxxxx/xxxx.pdf
         */
        this.reportUrl = builder.reportUrl;
        /**
         * 报告地址类型；枚举值 1 或为空时为可下载的 pdf 链接，2 为预览型链接
         * <p> 示例值：1
         */
        this.reportUrlType = builder.reportUrlType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getReportName() {
        return this.reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportUrl() {
        return this.reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    public Integer getReportUrlType() {
        return this.reportUrlType;
    }

    public void setReportUrlType(Integer reportUrlType) {
        this.reportUrlType = reportUrlType;
    }

    public static class Builder {
        /**
         * 报告名称
         * <p> 示例值：阶段报告.pdf
         */
        private String reportName;
        /**
         * 报告地址
         * <p> 示例值：https://xxxxx/xxxxxx/xxxx.pdf
         */
        private String reportUrl;
        /**
         * 报告地址类型；枚举值 1 或为空时为可下载的 pdf 链接，2 为预览型链接
         * <p> 示例值：1
         */
        private Integer reportUrlType;

        /**
         * 报告名称
         * <p> 示例值：阶段报告.pdf
         *
         * @param reportName
         * @return
         */
        public Builder reportName(String reportName) {
            this.reportName = reportName;
            return this;
        }


        /**
         * 报告地址
         * <p> 示例值：https://xxxxx/xxxxxx/xxxx.pdf
         *
         * @param reportUrl
         * @return
         */
        public Builder reportUrl(String reportUrl) {
            this.reportUrl = reportUrl;
            return this;
        }


        /**
         * 报告地址类型；枚举值 1 或为空时为可下载的 pdf 链接，2 为预览型链接
         * <p> 示例值：1
         *
         * @param reportUrlType
         * @return
         */
        public Builder reportUrlType(Integer reportUrlType) {
            this.reportUrlType = reportUrlType;
            return this;
        }


        public EcoBackgroundCheckReportFile build() {
            return new EcoBackgroundCheckReportFile(this);
        }
    }
}
