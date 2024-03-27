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

public class Instance {
    /**
     * 审批实例code
     * <p> 示例值：
     */
    @SerializedName("instance_code")
    private String instanceCode;
    /**
     * 审批名称
     * <p> 示例值：
     */
    @SerializedName("approval_name")
    private String approvalName;
    /**
     * 审批实例发起时间戳
     * <p> 示例值：
     */
    @SerializedName("start_time")
    private String startTime;
    /**
     * 审批实例结束时间戳
     * <p> 示例值：
     */
    @SerializedName("end_time")
    private String endTime;
    /**
     * 发起人
     * <p> 示例值：
     */
    @SerializedName("user_id")
    private String userId;
    /**
     * 申请编号
     * <p> 示例值：
     */
    @SerializedName("serial_id")
    private String serialId;

    // builder 开始
    public Instance() {
    }

    public Instance(Builder builder) {
        /**
         * 审批实例code
         * <p> 示例值：
         */
        this.instanceCode = builder.instanceCode;
        /**
         * 审批名称
         * <p> 示例值：
         */
        this.approvalName = builder.approvalName;
        /**
         * 审批实例发起时间戳
         * <p> 示例值：
         */
        this.startTime = builder.startTime;
        /**
         * 审批实例结束时间戳
         * <p> 示例值：
         */
        this.endTime = builder.endTime;
        /**
         * 发起人
         * <p> 示例值：
         */
        this.userId = builder.userId;
        /**
         * 申请编号
         * <p> 示例值：
         */
        this.serialId = builder.serialId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getInstanceCode() {
        return this.instanceCode;
    }

    public void setInstanceCode(String instanceCode) {
        this.instanceCode = instanceCode;
    }

    public String getApprovalName() {
        return this.approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
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

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSerialId() {
        return this.serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public static class Builder {
        /**
         * 审批实例code
         * <p> 示例值：
         */
        private String instanceCode;
        /**
         * 审批名称
         * <p> 示例值：
         */
        private String approvalName;
        /**
         * 审批实例发起时间戳
         * <p> 示例值：
         */
        private String startTime;
        /**
         * 审批实例结束时间戳
         * <p> 示例值：
         */
        private String endTime;
        /**
         * 发起人
         * <p> 示例值：
         */
        private String userId;
        /**
         * 申请编号
         * <p> 示例值：
         */
        private String serialId;

        /**
         * 审批实例code
         * <p> 示例值：
         *
         * @param instanceCode
         * @return
         */
        public Builder instanceCode(String instanceCode) {
            this.instanceCode = instanceCode;
            return this;
        }


        /**
         * 审批名称
         * <p> 示例值：
         *
         * @param approvalName
         * @return
         */
        public Builder approvalName(String approvalName) {
            this.approvalName = approvalName;
            return this;
        }


        /**
         * 审批实例发起时间戳
         * <p> 示例值：
         *
         * @param startTime
         * @return
         */
        public Builder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }


        /**
         * 审批实例结束时间戳
         * <p> 示例值：
         *
         * @param endTime
         * @return
         */
        public Builder endTime(String endTime) {
            this.endTime = endTime;
            return this;
        }


        /**
         * 发起人
         * <p> 示例值：
         *
         * @param userId
         * @return
         */
        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }


        /**
         * 申请编号
         * <p> 示例值：
         *
         * @param serialId
         * @return
         */
        public Builder serialId(String serialId) {
            this.serialId = serialId;
            return this;
        }


        public Instance build() {
            return new Instance(this);
        }
    }
}
