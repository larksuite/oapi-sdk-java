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

public class SpecificRelationship {
    /**
     * 与候选人的关系
     * <p> 示例值：1
     */
    @SerializedName("relation_with_candidate")
    private Integer relationWithCandidate;
    /**
     * 附加信息
     * <p> 示例值：在前公司合作非常愉快～
     */
    @SerializedName("extra")
    private String extra;

    // builder 开始
    public SpecificRelationship() {
    }

    public SpecificRelationship(Builder builder) {
        /**
         * 与候选人的关系
         * <p> 示例值：1
         */
        this.relationWithCandidate = builder.relationWithCandidate;
        /**
         * 附加信息
         * <p> 示例值：在前公司合作非常愉快～
         */
        this.extra = builder.extra;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getRelationWithCandidate() {
        return this.relationWithCandidate;
    }

    public void setRelationWithCandidate(Integer relationWithCandidate) {
        this.relationWithCandidate = relationWithCandidate;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public static class Builder {
        /**
         * 与候选人的关系
         * <p> 示例值：1
         */
        private Integer relationWithCandidate;
        /**
         * 附加信息
         * <p> 示例值：在前公司合作非常愉快～
         */
        private String extra;

        /**
         * 与候选人的关系
         * <p> 示例值：1
         *
         * @param relationWithCandidate
         * @return
         */
        public Builder relationWithCandidate(Integer relationWithCandidate) {
            this.relationWithCandidate = relationWithCandidate;
            return this;
        }


        /**
         * 附加信息
         * <p> 示例值：在前公司合作非常愉快～
         *
         * @param extra
         * @return
         */
        public Builder extra(String extra) {
            this.extra = extra;
            return this;
        }


        public SpecificRelationship build() {
            return new SpecificRelationship(this);
        }
    }
}