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

public class JobConfigRoundTypeResult {
    /**
     * 面试轮次类型
     * <p> 示例值：
     */
    @SerializedName("assessment_round")
    private IdNameObject assessmentRound;
    /**
     * 面试评价表
     * <p> 示例值：
     */
    @SerializedName("assessment_template")
    private IdNameObject assessmentTemplate;

    // builder 开始
    public JobConfigRoundTypeResult() {
    }

    public JobConfigRoundTypeResult(Builder builder) {
        /**
         * 面试轮次类型
         * <p> 示例值：
         */
        this.assessmentRound = builder.assessmentRound;
        /**
         * 面试评价表
         * <p> 示例值：
         */
        this.assessmentTemplate = builder.assessmentTemplate;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public IdNameObject getAssessmentRound() {
        return this.assessmentRound;
    }

    public void setAssessmentRound(IdNameObject assessmentRound) {
        this.assessmentRound = assessmentRound;
    }

    public IdNameObject getAssessmentTemplate() {
        return this.assessmentTemplate;
    }

    public void setAssessmentTemplate(IdNameObject assessmentTemplate) {
        this.assessmentTemplate = assessmentTemplate;
    }

    public static class Builder {
        /**
         * 面试轮次类型
         * <p> 示例值：
         */
        private IdNameObject assessmentRound;
        /**
         * 面试评价表
         * <p> 示例值：
         */
        private IdNameObject assessmentTemplate;

        /**
         * 面试轮次类型
         * <p> 示例值：
         *
         * @param assessmentRound
         * @return
         */
        public Builder assessmentRound(IdNameObject assessmentRound) {
            this.assessmentRound = assessmentRound;
            return this;
        }


        /**
         * 面试评价表
         * <p> 示例值：
         *
         * @param assessmentTemplate
         * @return
         */
        public Builder assessmentTemplate(IdNameObject assessmentTemplate) {
            this.assessmentTemplate = assessmentTemplate;
            return this;
        }


        public JobConfigRoundTypeResult build() {
            return new JobConfigRoundTypeResult(this);
        }
    }
}
