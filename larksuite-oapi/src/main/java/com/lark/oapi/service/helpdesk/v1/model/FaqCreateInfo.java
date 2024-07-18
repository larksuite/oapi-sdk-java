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

package com.lark.oapi.service.helpdesk.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.helpdesk.v1.enums.*;
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

public class FaqCreateInfo {
    /**
     * faq category id
     * <p> 示例值：6836004780707807251
     */
    @SerializedName("category_id")
    private String categoryId;
    /**
     * faq question
     * <p> 示例值：问题
     */
    @SerializedName("question")
    private String question;
    /**
     * faq answer
     * <p> 示例值："答案"
     */
    @SerializedName("answer")
    private String answer;
    /**
     * faq answer in richtext
     * <p> 示例值："[{"content":"答案","type":"text"},{"content":"这只是一个测试，医保问题","type":"text"}]"
     */
    @SerializedName("answer_richtext")
    private String answerRichtext;
    /**
     * faq tags
     * <p> 示例值：
     */
    @SerializedName("tags")
    private String[] tags;

    // builder 开始
    public FaqCreateInfo() {
    }

    public FaqCreateInfo(Builder builder) {
        /**
         * faq category id
         * <p> 示例值：6836004780707807251
         */
        this.categoryId = builder.categoryId;
        /**
         * faq question
         * <p> 示例值：问题
         */
        this.question = builder.question;
        /**
         * faq answer
         * <p> 示例值："答案"
         */
        this.answer = builder.answer;
        /**
         * faq answer in richtext
         * <p> 示例值："[{"content":"答案","type":"text"},{"content":"这只是一个测试，医保问题","type":"text"}]"
         */
        this.answerRichtext = builder.answerRichtext;
        /**
         * faq tags
         * <p> 示例值：
         */
        this.tags = builder.tags;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerRichtext() {
        return this.answerRichtext;
    }

    public void setAnswerRichtext(String answerRichtext) {
        this.answerRichtext = answerRichtext;
    }

    public String[] getTags() {
        return this.tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public static class Builder {
        /**
         * faq category id
         * <p> 示例值：6836004780707807251
         */
        private String categoryId;
        /**
         * faq question
         * <p> 示例值：问题
         */
        private String question;
        /**
         * faq answer
         * <p> 示例值："答案"
         */
        private String answer;
        /**
         * faq answer in richtext
         * <p> 示例值："[{"content":"答案","type":"text"},{"content":"这只是一个测试，医保问题","type":"text"}]"
         */
        private String answerRichtext;
        /**
         * faq tags
         * <p> 示例值：
         */
        private String[] tags;

        /**
         * faq category id
         * <p> 示例值：6836004780707807251
         *
         * @param categoryId
         * @return
         */
        public Builder categoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }


        /**
         * faq question
         * <p> 示例值：问题
         *
         * @param question
         * @return
         */
        public Builder question(String question) {
            this.question = question;
            return this;
        }


        /**
         * faq answer
         * <p> 示例值："答案"
         *
         * @param answer
         * @return
         */
        public Builder answer(String answer) {
            this.answer = answer;
            return this;
        }


        /**
         * faq answer in richtext
         * <p> 示例值："[{"content":"答案","type":"text"},{"content":"这只是一个测试，医保问题","type":"text"}]"
         *
         * @param answerRichtext
         * @return
         */
        public Builder answerRichtext(String answerRichtext) {
            this.answerRichtext = answerRichtext;
            return this;
        }


        /**
         * faq tags
         * <p> 示例值：
         *
         * @param tags
         * @return
         */
        public Builder tags(String[] tags) {
            this.tags = tags;
            return this;
        }


        public FaqCreateInfo build() {
            return new FaqCreateInfo(this);
        }
    }
}