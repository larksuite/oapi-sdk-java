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

package com.lark.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;

public class AppWorkflow {
    /**
     * 自动化工作流的id
     * <p> 示例值：72934597xxxx9998484
     */
    @SerializedName("workflow_id")
    private String workflowId;
    /**
     * 自动化工作流的状态
     * <p> 示例值：Enable
     */
    @SerializedName("status")
    private String status;
    /**
     * 自动化工作流的名称
     * <p> 示例值：流程
     */
    @SerializedName("title")
    private String title;

    // builder 开始
    public AppWorkflow() {
    }

    public AppWorkflow(Builder builder) {
        /**
         * 自动化工作流的id
         * <p> 示例值：72934597xxxx9998484
         */
        this.workflowId = builder.workflowId;
        /**
         * 自动化工作流的状态
         * <p> 示例值：Enable
         */
        this.status = builder.status;
        /**
         * 自动化工作流的名称
         * <p> 示例值：流程
         */
        this.title = builder.title;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getWorkflowId() {
        return this.workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class Builder {
        /**
         * 自动化工作流的id
         * <p> 示例值：72934597xxxx9998484
         */
        private String workflowId;
        /**
         * 自动化工作流的状态
         * <p> 示例值：Enable
         */
        private String status;
        /**
         * 自动化工作流的名称
         * <p> 示例值：流程
         */
        private String title;

        /**
         * 自动化工作流的id
         * <p> 示例值：72934597xxxx9998484
         *
         * @param workflowId
         * @return
         */
        public Builder workflowId(String workflowId) {
            this.workflowId = workflowId;
            return this;
        }


        /**
         * 自动化工作流的状态
         * <p> 示例值：Enable
         *
         * @param status
         * @return
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }


        /**
         * 自动化工作流的名称
         * <p> 示例值：流程
         *
         * @param title
         * @return
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }


        public AppWorkflow build() {
            return new AppWorkflow(this);
        }
    }
}
