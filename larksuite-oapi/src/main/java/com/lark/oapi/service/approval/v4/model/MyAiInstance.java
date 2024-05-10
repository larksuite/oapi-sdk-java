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

package com.lark.oapi.service.approval.v4.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.approval.v4.enums.*;
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

public class MyAiInstance {
    /**
     * 审批名称
     * <p> 示例值：合同申请
     */
    @SerializedName("name")
    private String name;
    /**
     * 表单
     * <p> 示例值：金额500元
     */
    @SerializedName("form")
    private String form;
    /**
     * 审批记录
     * <p> 示例值：
     */
    @SerializedName("tasks")
    private MyAiTask[] tasks;
    /**
     * 审批评论
     * <p> 示例值：
     */
    @SerializedName("comments")
    private MyAiComment[] comments;

    // builder 开始
    public MyAiInstance() {
    }

    public MyAiInstance(Builder builder) {
        /**
         * 审批名称
         * <p> 示例值：合同申请
         */
        this.name = builder.name;
        /**
         * 表单
         * <p> 示例值：金额500元
         */
        this.form = builder.form;
        /**
         * 审批记录
         * <p> 示例值：
         */
        this.tasks = builder.tasks;
        /**
         * 审批评论
         * <p> 示例值：
         */
        this.comments = builder.comments;
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

    public String getForm() {
        return this.form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public MyAiTask[] getTasks() {
        return this.tasks;
    }

    public void setTasks(MyAiTask[] tasks) {
        this.tasks = tasks;
    }

    public MyAiComment[] getComments() {
        return this.comments;
    }

    public void setComments(MyAiComment[] comments) {
        this.comments = comments;
    }

    public static class Builder {
        /**
         * 审批名称
         * <p> 示例值：合同申请
         */
        private String name;
        /**
         * 表单
         * <p> 示例值：金额500元
         */
        private String form;
        /**
         * 审批记录
         * <p> 示例值：
         */
        private MyAiTask[] tasks;
        /**
         * 审批评论
         * <p> 示例值：
         */
        private MyAiComment[] comments;

        /**
         * 审批名称
         * <p> 示例值：合同申请
         *
         * @param name
         * @return
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }


        /**
         * 表单
         * <p> 示例值：金额500元
         *
         * @param form
         * @return
         */
        public Builder form(String form) {
            this.form = form;
            return this;
        }


        /**
         * 审批记录
         * <p> 示例值：
         *
         * @param tasks
         * @return
         */
        public Builder tasks(MyAiTask[] tasks) {
            this.tasks = tasks;
            return this;
        }


        /**
         * 审批评论
         * <p> 示例值：
         *
         * @param comments
         * @return
         */
        public Builder comments(MyAiComment[] comments) {
            this.comments = comments;
            return this;
        }


        public MyAiInstance build() {
            return new MyAiInstance(this);
        }
    }
}
