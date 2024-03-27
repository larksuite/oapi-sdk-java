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

package com.lark.oapi.service.document_ai.v1.model;

import com.google.gson.annotations.SerializedName;

public class ResumeProject {
    /**
     * 项目名称
     * <p> 示例值：XX项目
     */
    @SerializedName("name")
    private String name;
    /**
     * 项目岗位
     * <p> 示例值：客户端研发
     */
    @SerializedName("title")
    private String title;
    /**
     * 开始时间,格式：YYYY-MM-DD
     * <p> 示例值：2023-01-03
     */
    @SerializedName("start_date")
    private String startDate;
    /**
     * 开始时间,格式：YYYY-MM-DD,跟start_date值一样
     * <p> 示例值：2023-01-03
     */
    @SerializedName("start_time")
    private String startTime;
    /**
     * 结束时间,格式：YYYY-MM-DD
     * <p> 示例值：2023-01-04
     */
    @SerializedName("end_date")
    private String endDate;
    /**
     * 结束时间,格式：YYYY-MM-DD 或 “至今”，当值为“至今”时，end_date=="",值
     * <p> 示例值：2023-01-04
     */
    @SerializedName("end_time")
    private String endTime;
    /**
     * 项目描述
     * <p> 示例值：XXX项目是一个...
     */
    @SerializedName("description")
    private String description;

    // builder 开始
    public ResumeProject() {
    }

    public ResumeProject(Builder builder) {
        /**
         * 项目名称
         * <p> 示例值：XX项目
         */
        this.name = builder.name;
        /**
         * 项目岗位
         * <p> 示例值：客户端研发
         */
        this.title = builder.title;
        /**
         * 开始时间,格式：YYYY-MM-DD
         * <p> 示例值：2023-01-03
         */
        this.startDate = builder.startDate;
        /**
         * 开始时间,格式：YYYY-MM-DD,跟start_date值一样
         * <p> 示例值：2023-01-03
         */
        this.startTime = builder.startTime;
        /**
         * 结束时间,格式：YYYY-MM-DD
         * <p> 示例值：2023-01-04
         */
        this.endDate = builder.endDate;
        /**
         * 结束时间,格式：YYYY-MM-DD 或 “至今”，当值为“至今”时，end_date=="",值
         * <p> 示例值：2023-01-04
         */
        this.endTime = builder.endTime;
        /**
         * 项目描述
         * <p> 示例值：XXX项目是一个...
         */
        this.description = builder.description;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder {
        /**
         * 项目名称
         * <p> 示例值：XX项目
         */
        private String name;
        /**
         * 项目岗位
         * <p> 示例值：客户端研发
         */
        private String title;
        /**
         * 开始时间,格式：YYYY-MM-DD
         * <p> 示例值：2023-01-03
         */
        private String startDate;
        /**
         * 开始时间,格式：YYYY-MM-DD,跟start_date值一样
         * <p> 示例值：2023-01-03
         */
        private String startTime;
        /**
         * 结束时间,格式：YYYY-MM-DD
         * <p> 示例值：2023-01-04
         */
        private String endDate;
        /**
         * 结束时间,格式：YYYY-MM-DD 或 “至今”，当值为“至今”时，end_date=="",值
         * <p> 示例值：2023-01-04
         */
        private String endTime;
        /**
         * 项目描述
         * <p> 示例值：XXX项目是一个...
         */
        private String description;

        /**
         * 项目名称
         * <p> 示例值：XX项目
         *
         * @param name
         * @return
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }


        /**
         * 项目岗位
         * <p> 示例值：客户端研发
         *
         * @param title
         * @return
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }


        /**
         * 开始时间,格式：YYYY-MM-DD
         * <p> 示例值：2023-01-03
         *
         * @param startDate
         * @return
         */
        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }


        /**
         * 开始时间,格式：YYYY-MM-DD,跟start_date值一样
         * <p> 示例值：2023-01-03
         *
         * @param startTime
         * @return
         */
        public Builder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }


        /**
         * 结束时间,格式：YYYY-MM-DD
         * <p> 示例值：2023-01-04
         *
         * @param endDate
         * @return
         */
        public Builder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }


        /**
         * 结束时间,格式：YYYY-MM-DD 或 “至今”，当值为“至今”时，end_date=="",值
         * <p> 示例值：2023-01-04
         *
         * @param endTime
         * @return
         */
        public Builder endTime(String endTime) {
            this.endTime = endTime;
            return this;
        }


        /**
         * 项目描述
         * <p> 示例值：XXX项目是一个...
         *
         * @param description
         * @return
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }


        public ResumeProject build() {
            return new ResumeProject(this);
        }
    }
}
