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

package com.lark.oapi.service.attendance.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.attendance.v1.enums.*;
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

public class ApprovalInfo {
    /**
     * 审批实例 ID
     * <p> 示例值：6737202939523236113
     */
    @SerializedName("approval_id")
    private String approvalId;
    /**
     * 审批类型
     * <p> 示例值：remedy
     */
    @SerializedName("approval_type")
    private String approvalType;
    /**
     * 审批状态
     * <p> 示例值：0
     */
    @SerializedName("status")
    private Integer status;

    // builder 开始
    public ApprovalInfo() {
    }

    public ApprovalInfo(Builder builder) {
        /**
         * 审批实例 ID
         * <p> 示例值：6737202939523236113
         */
        this.approvalId = builder.approvalId;
        /**
         * 审批类型
         * <p> 示例值：remedy
         */
        this.approvalType = builder.approvalType;
        /**
         * 审批状态
         * <p> 示例值：0
         */
        this.status = builder.status;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getApprovalId() {
        return this.approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }

    public String getApprovalType() {
        return this.approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static class Builder {
        /**
         * 审批实例 ID
         * <p> 示例值：6737202939523236113
         */
        private String approvalId;
        /**
         * 审批类型
         * <p> 示例值：remedy
         */
        private String approvalType;
        /**
         * 审批状态
         * <p> 示例值：0
         */
        private Integer status;

        /**
         * 审批实例 ID
         * <p> 示例值：6737202939523236113
         *
         * @param approvalId
         * @return
         */
        public Builder approvalId(String approvalId) {
            this.approvalId = approvalId;
            return this;
        }


        /**
         * 审批类型
         * <p> 示例值：remedy
         *
         * @param approvalType
         * @return
         */
        public Builder approvalType(String approvalType) {
            this.approvalType = approvalType;
            return this;
        }

        /**
         * 审批类型
         * <p> 示例值：remedy
         *
         * @param approvalType {@link com.lark.oapi.service.attendance.v1.enums.ApprovalInfoApprovalTypeEnum}
         * @return
         */
        public Builder approvalType(com.lark.oapi.service.attendance.v1.enums.ApprovalInfoApprovalTypeEnum approvalType) {
            this.approvalType = approvalType.getValue();
            return this;
        }


        /**
         * 审批状态
         * <p> 示例值：0
         *
         * @param status
         * @return
         */
        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        /**
         * 审批状态
         * <p> 示例值：0
         *
         * @param status {@link com.lark.oapi.service.attendance.v1.enums.ApprovalInfoApprovalStatusEnum}
         * @return
         */
        public Builder status(com.lark.oapi.service.attendance.v1.enums.ApprovalInfoApprovalStatusEnum status) {
            this.status = status.getValue();
            return this;
        }


        public ApprovalInfo build() {
            return new ApprovalInfo(this);
        }
    }
}
