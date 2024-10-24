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

package com.lark.oapi.service.compensation.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.compensation.v1.enums.*;
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

public class LumpSumPaymentDetailForUpdate {
    /**
     * 一次性支付记录明细id。传入已有的id代表直接在原明细上进行更新，不传则代表创建新的明细
     * <p> 示例值：7395133551102200876
     */
    @SerializedName("id")
    private String id;
    /**
     * 一次性支付明细发放金额，可转数字的字符串
     * <p> 示例值：2000.00
     */
    @SerializedName("issuance_amount")
    private String issuanceAmount;
    /**
     * 发放状态
     * <p> 示例值：to_be_issued
     */
    @SerializedName("issuance_status")
    private String issuanceStatus;
    /**
     * 发放方式
     * <p> 示例值：with_salary
     */
    @SerializedName("issuance_way")
    private String issuanceWay;
    /**
     * 发放时间
     * <p> 示例值：2024-08-01
     */
    @SerializedName("issuance_time")
    private String issuanceTime;

    // builder 开始
    public LumpSumPaymentDetailForUpdate() {
    }

    public LumpSumPaymentDetailForUpdate(Builder builder) {
        /**
         * 一次性支付记录明细id。传入已有的id代表直接在原明细上进行更新，不传则代表创建新的明细
         * <p> 示例值：7395133551102200876
         */
        this.id = builder.id;
        /**
         * 一次性支付明细发放金额，可转数字的字符串
         * <p> 示例值：2000.00
         */
        this.issuanceAmount = builder.issuanceAmount;
        /**
         * 发放状态
         * <p> 示例值：to_be_issued
         */
        this.issuanceStatus = builder.issuanceStatus;
        /**
         * 发放方式
         * <p> 示例值：with_salary
         */
        this.issuanceWay = builder.issuanceWay;
        /**
         * 发放时间
         * <p> 示例值：2024-08-01
         */
        this.issuanceTime = builder.issuanceTime;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIssuanceAmount() {
        return this.issuanceAmount;
    }

    public void setIssuanceAmount(String issuanceAmount) {
        this.issuanceAmount = issuanceAmount;
    }

    public String getIssuanceStatus() {
        return this.issuanceStatus;
    }

    public void setIssuanceStatus(String issuanceStatus) {
        this.issuanceStatus = issuanceStatus;
    }

    public String getIssuanceWay() {
        return this.issuanceWay;
    }

    public void setIssuanceWay(String issuanceWay) {
        this.issuanceWay = issuanceWay;
    }

    public String getIssuanceTime() {
        return this.issuanceTime;
    }

    public void setIssuanceTime(String issuanceTime) {
        this.issuanceTime = issuanceTime;
    }

    public static class Builder {
        /**
         * 一次性支付记录明细id。传入已有的id代表直接在原明细上进行更新，不传则代表创建新的明细
         * <p> 示例值：7395133551102200876
         */
        private String id;
        /**
         * 一次性支付明细发放金额，可转数字的字符串
         * <p> 示例值：2000.00
         */
        private String issuanceAmount;
        /**
         * 发放状态
         * <p> 示例值：to_be_issued
         */
        private String issuanceStatus;
        /**
         * 发放方式
         * <p> 示例值：with_salary
         */
        private String issuanceWay;
        /**
         * 发放时间
         * <p> 示例值：2024-08-01
         */
        private String issuanceTime;

        /**
         * 一次性支付记录明细id。传入已有的id代表直接在原明细上进行更新，不传则代表创建新的明细
         * <p> 示例值：7395133551102200876
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 一次性支付明细发放金额，可转数字的字符串
         * <p> 示例值：2000.00
         *
         * @param issuanceAmount
         * @return
         */
        public Builder issuanceAmount(String issuanceAmount) {
            this.issuanceAmount = issuanceAmount;
            return this;
        }


        /**
         * 发放状态
         * <p> 示例值：to_be_issued
         *
         * @param issuanceStatus
         * @return
         */
        public Builder issuanceStatus(String issuanceStatus) {
            this.issuanceStatus = issuanceStatus;
            return this;
        }

        /**
         * 发放状态
         * <p> 示例值：to_be_issued
         *
         * @param issuanceStatus {@link com.lark.oapi.service.compensation.v1.enums.LumpSumPaymentDetailForUpdateIssuanceStatusEnum}
         * @return
         */
        public Builder issuanceStatus(com.lark.oapi.service.compensation.v1.enums.LumpSumPaymentDetailForUpdateIssuanceStatusEnum issuanceStatus) {
            this.issuanceStatus = issuanceStatus.getValue();
            return this;
        }


        /**
         * 发放方式
         * <p> 示例值：with_salary
         *
         * @param issuanceWay
         * @return
         */
        public Builder issuanceWay(String issuanceWay) {
            this.issuanceWay = issuanceWay;
            return this;
        }

        /**
         * 发放方式
         * <p> 示例值：with_salary
         *
         * @param issuanceWay {@link com.lark.oapi.service.compensation.v1.enums.LumpSumPaymentDetailForUpdateIssuanceWayEnum}
         * @return
         */
        public Builder issuanceWay(com.lark.oapi.service.compensation.v1.enums.LumpSumPaymentDetailForUpdateIssuanceWayEnum issuanceWay) {
            this.issuanceWay = issuanceWay.getValue();
            return this;
        }


        /**
         * 发放时间
         * <p> 示例值：2024-08-01
         *
         * @param issuanceTime
         * @return
         */
        public Builder issuanceTime(String issuanceTime) {
            this.issuanceTime = issuanceTime;
            return this;
        }


        public LumpSumPaymentDetailForUpdate build() {
            return new LumpSumPaymentDetailForUpdate(this);
        }
    }
}
