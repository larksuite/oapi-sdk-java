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

import com.google.gson.annotations.SerializedName;

public class PreviewInstanceReqBody {
    /**
     * 用户id
     * <p> 示例值：发起审批用户id，按照user_id_type类型填写
     */
    @SerializedName("user_id")
    private String userId;
    /**
     * 审批定义code
     * <p> 示例值：C2CAAA90-70D9-3214-906B-B6FFF947F00D
     */
    @SerializedName("approval_code")
    private String approvalCode;
    /**
     * 部门id
     * <p> 示例值：6982332863116876308
     */
    @SerializedName("department_id")
    private String departmentId;
    /**
     * 表单数据
     * <p> 示例值：[{\"id\":\"widget16256287451710001\", \"type\": \"number\", \"value\":\"43\"}]
     */
    @SerializedName("form")
    private String form;
    /**
     * 审批实例code
     * <p> 示例值：12345CA6-97AC-32BB-8231-47C33FFFCCFD
     */
    @SerializedName("instance_code")
    private String instanceCode;
    /**
     * 语言类型
     * <p> 示例值：zh-CN: 中文 en-US: 英文
     */
    @SerializedName("locale")
    private String locale;
    /**
     * 任务id
     * <p> 示例值：6982332863116876308
     */
    @SerializedName("task_id")
    private String taskId;

    // builder 开始
    public PreviewInstanceReqBody() {
    }

    public PreviewInstanceReqBody(Builder builder) {
        /**
         * 用户id
         * <p> 示例值：发起审批用户id，按照user_id_type类型填写
         */
        this.userId = builder.userId;
        /**
         * 审批定义code
         * <p> 示例值：C2CAAA90-70D9-3214-906B-B6FFF947F00D
         */
        this.approvalCode = builder.approvalCode;
        /**
         * 部门id
         * <p> 示例值：6982332863116876308
         */
        this.departmentId = builder.departmentId;
        /**
         * 表单数据
         * <p> 示例值：[{\"id\":\"widget16256287451710001\", \"type\": \"number\", \"value\":\"43\"}]
         */
        this.form = builder.form;
        /**
         * 审批实例code
         * <p> 示例值：12345CA6-97AC-32BB-8231-47C33FFFCCFD
         */
        this.instanceCode = builder.instanceCode;
        /**
         * 语言类型
         * <p> 示例值：zh-CN: 中文 en-US: 英文
         */
        this.locale = builder.locale;
        /**
         * 任务id
         * <p> 示例值：6982332863116876308
         */
        this.taskId = builder.taskId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApprovalCode() {
        return this.approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getForm() {
        return this.form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getInstanceCode() {
        return this.instanceCode;
    }

    public void setInstanceCode(String instanceCode) {
        this.instanceCode = instanceCode;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public static class Builder {
        /**
         * 用户id
         * <p> 示例值：发起审批用户id，按照user_id_type类型填写
         */
        private String userId;
        /**
         * 审批定义code
         * <p> 示例值：C2CAAA90-70D9-3214-906B-B6FFF947F00D
         */
        private String approvalCode;
        /**
         * 部门id
         * <p> 示例值：6982332863116876308
         */
        private String departmentId;
        /**
         * 表单数据
         * <p> 示例值：[{\"id\":\"widget16256287451710001\", \"type\": \"number\", \"value\":\"43\"}]
         */
        private String form;
        /**
         * 审批实例code
         * <p> 示例值：12345CA6-97AC-32BB-8231-47C33FFFCCFD
         */
        private String instanceCode;
        /**
         * 语言类型
         * <p> 示例值：zh-CN: 中文 en-US: 英文
         */
        private String locale;
        /**
         * 任务id
         * <p> 示例值：6982332863116876308
         */
        private String taskId;

        /**
         * 用户id
         * <p> 示例值：发起审批用户id，按照user_id_type类型填写
         *
         * @param userId
         * @return
         */
        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }


        /**
         * 审批定义code
         * <p> 示例值：C2CAAA90-70D9-3214-906B-B6FFF947F00D
         *
         * @param approvalCode
         * @return
         */
        public Builder approvalCode(String approvalCode) {
            this.approvalCode = approvalCode;
            return this;
        }


        /**
         * 部门id
         * <p> 示例值：6982332863116876308
         *
         * @param departmentId
         * @return
         */
        public Builder departmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }


        /**
         * 表单数据
         * <p> 示例值：[{\"id\":\"widget16256287451710001\", \"type\": \"number\", \"value\":\"43\"}]
         *
         * @param form
         * @return
         */
        public Builder form(String form) {
            this.form = form;
            return this;
        }


        /**
         * 审批实例code
         * <p> 示例值：12345CA6-97AC-32BB-8231-47C33FFFCCFD
         *
         * @param instanceCode
         * @return
         */
        public Builder instanceCode(String instanceCode) {
            this.instanceCode = instanceCode;
            return this;
        }


        /**
         * 语言类型
         * <p> 示例值：zh-CN: 中文 en-US: 英文
         *
         * @param locale
         * @return
         */
        public Builder locale(String locale) {
            this.locale = locale;
            return this;
        }


        /**
         * 任务id
         * <p> 示例值：6982332863116876308
         *
         * @param taskId
         * @return
         */
        public Builder taskId(String taskId) {
            this.taskId = taskId;
            return this;
        }


        public PreviewInstanceReqBody build() {
            return new PreviewInstanceReqBody(this);
        }
    }
}
