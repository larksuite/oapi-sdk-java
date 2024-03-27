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

public class ApplicationPrehireOptional {
    /**
     * 是否包含基础信息
     * <p> 示例值：
     */
    @SerializedName("with_talent_basic")
    private Boolean withTalentBasic;
    /**
     * 是否包含扩展信息
     * <p> 示例值：
     */
    @SerializedName("with_talent_extend")
    private Boolean withTalentExtend;
    /**
     * 是否包含岗位信息
     * <p> 示例值：
     */
    @SerializedName("with_job")
    private Boolean withJob;
    /**
     * 是否包含offer信息
     * <p> 示例值：
     */
    @SerializedName("with_offer")
    private Boolean withOffer;

    // builder 开始
    public ApplicationPrehireOptional() {
    }

    public ApplicationPrehireOptional(Builder builder) {
        /**
         * 是否包含基础信息
         * <p> 示例值：
         */
        this.withTalentBasic = builder.withTalentBasic;
        /**
         * 是否包含扩展信息
         * <p> 示例值：
         */
        this.withTalentExtend = builder.withTalentExtend;
        /**
         * 是否包含岗位信息
         * <p> 示例值：
         */
        this.withJob = builder.withJob;
        /**
         * 是否包含offer信息
         * <p> 示例值：
         */
        this.withOffer = builder.withOffer;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Boolean getWithTalentBasic() {
        return this.withTalentBasic;
    }

    public void setWithTalentBasic(Boolean withTalentBasic) {
        this.withTalentBasic = withTalentBasic;
    }

    public Boolean getWithTalentExtend() {
        return this.withTalentExtend;
    }

    public void setWithTalentExtend(Boolean withTalentExtend) {
        this.withTalentExtend = withTalentExtend;
    }

    public Boolean getWithJob() {
        return this.withJob;
    }

    public void setWithJob(Boolean withJob) {
        this.withJob = withJob;
    }

    public Boolean getWithOffer() {
        return this.withOffer;
    }

    public void setWithOffer(Boolean withOffer) {
        this.withOffer = withOffer;
    }

    public static class Builder {
        /**
         * 是否包含基础信息
         * <p> 示例值：
         */
        private Boolean withTalentBasic;
        /**
         * 是否包含扩展信息
         * <p> 示例值：
         */
        private Boolean withTalentExtend;
        /**
         * 是否包含岗位信息
         * <p> 示例值：
         */
        private Boolean withJob;
        /**
         * 是否包含offer信息
         * <p> 示例值：
         */
        private Boolean withOffer;

        /**
         * 是否包含基础信息
         * <p> 示例值：
         *
         * @param withTalentBasic
         * @return
         */
        public Builder withTalentBasic(Boolean withTalentBasic) {
            this.withTalentBasic = withTalentBasic;
            return this;
        }


        /**
         * 是否包含扩展信息
         * <p> 示例值：
         *
         * @param withTalentExtend
         * @return
         */
        public Builder withTalentExtend(Boolean withTalentExtend) {
            this.withTalentExtend = withTalentExtend;
            return this;
        }


        /**
         * 是否包含岗位信息
         * <p> 示例值：
         *
         * @param withJob
         * @return
         */
        public Builder withJob(Boolean withJob) {
            this.withJob = withJob;
            return this;
        }


        /**
         * 是否包含offer信息
         * <p> 示例值：
         *
         * @param withOffer
         * @return
         */
        public Builder withOffer(Boolean withOffer) {
            this.withOffer = withOffer;
            return this;
        }


        public ApplicationPrehireOptional build() {
            return new ApplicationPrehireOptional(this);
        }
    }
}
