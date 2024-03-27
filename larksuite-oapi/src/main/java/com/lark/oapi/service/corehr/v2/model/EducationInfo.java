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

public class EducationInfo {
    /**
     * 学校名称
     * <p> 示例值：长安大学
     */
    @SerializedName("school_name")
    private String schoolName;
    /**
     * 学历
     * <p> 示例值：phd
     */
    @SerializedName("education")
    private String education;
    /**
     * 开始时间
     * <p> 示例值：2017-04-01
     */
    @SerializedName("start_time")
    private String startTime;
    /**
     * 结束时间
     * <p> 示例值：2018-04-01
     */
    @SerializedName("end_time")
    private String endTime;
    /**
     * 专业
     * <p> 示例值：医学影像技术
     */
    @SerializedName("field_of_study")
    private String fieldOfStudy;

    // builder 开始
    public EducationInfo() {
    }

    public EducationInfo(Builder builder) {
        /**
         * 学校名称
         * <p> 示例值：长安大学
         */
        this.schoolName = builder.schoolName;
        /**
         * 学历
         * <p> 示例值：phd
         */
        this.education = builder.education;
        /**
         * 开始时间
         * <p> 示例值：2017-04-01
         */
        this.startTime = builder.startTime;
        /**
         * 结束时间
         * <p> 示例值：2018-04-01
         */
        this.endTime = builder.endTime;
        /**
         * 专业
         * <p> 示例值：医学影像技术
         */
        this.fieldOfStudy = builder.fieldOfStudy;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFieldOfStudy() {
        return this.fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public static class Builder {
        /**
         * 学校名称
         * <p> 示例值：长安大学
         */
        private String schoolName;
        /**
         * 学历
         * <p> 示例值：phd
         */
        private String education;
        /**
         * 开始时间
         * <p> 示例值：2017-04-01
         */
        private String startTime;
        /**
         * 结束时间
         * <p> 示例值：2018-04-01
         */
        private String endTime;
        /**
         * 专业
         * <p> 示例值：医学影像技术
         */
        private String fieldOfStudy;

        /**
         * 学校名称
         * <p> 示例值：长安大学
         *
         * @param schoolName
         * @return
         */
        public Builder schoolName(String schoolName) {
            this.schoolName = schoolName;
            return this;
        }


        /**
         * 学历
         * <p> 示例值：phd
         *
         * @param education
         * @return
         */
        public Builder education(String education) {
            this.education = education;
            return this;
        }


        /**
         * 开始时间
         * <p> 示例值：2017-04-01
         *
         * @param startTime
         * @return
         */
        public Builder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }


        /**
         * 结束时间
         * <p> 示例值：2018-04-01
         *
         * @param endTime
         * @return
         */
        public Builder endTime(String endTime) {
            this.endTime = endTime;
            return this;
        }


        /**
         * 专业
         * <p> 示例值：医学影像技术
         *
         * @param fieldOfStudy
         * @return
         */
        public Builder fieldOfStudy(String fieldOfStudy) {
            this.fieldOfStudy = fieldOfStudy;
            return this;
        }


        public EducationInfo build() {
            return new EducationInfo(this);
        }
    }
}
