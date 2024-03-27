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

public class ReconciliationReferralAccountReqBody {
    /**
     * 按时间范围进行对账时 时间段的起始交易时间
     * <p> 示例值：1685416831621
     */
    @SerializedName("start_trans_time")
    private String startTransTime;
    /**
     * 按时间范围进行对账时 时间段的截止交易时间
     * <p> 示例值：1685416831622
     */
    @SerializedName("end_trans_time")
    private String endTransTime;
    /**
     * 交易信息
     * <p> 示例值：
     */
    @SerializedName("trade_details")
    private TradeDetail[] tradeDetails;

    // builder 开始
    public ReconciliationReferralAccountReqBody() {
    }

    public ReconciliationReferralAccountReqBody(Builder builder) {
        /**
         * 按时间范围进行对账时 时间段的起始交易时间
         * <p> 示例值：1685416831621
         */
        this.startTransTime = builder.startTransTime;
        /**
         * 按时间范围进行对账时 时间段的截止交易时间
         * <p> 示例值：1685416831622
         */
        this.endTransTime = builder.endTransTime;
        /**
         * 交易信息
         * <p> 示例值：
         */
        this.tradeDetails = builder.tradeDetails;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getStartTransTime() {
        return this.startTransTime;
    }

    public void setStartTransTime(String startTransTime) {
        this.startTransTime = startTransTime;
    }

    public String getEndTransTime() {
        return this.endTransTime;
    }

    public void setEndTransTime(String endTransTime) {
        this.endTransTime = endTransTime;
    }

    public TradeDetail[] getTradeDetails() {
        return this.tradeDetails;
    }

    public void setTradeDetails(TradeDetail[] tradeDetails) {
        this.tradeDetails = tradeDetails;
    }

    public static class Builder {
        /**
         * 按时间范围进行对账时 时间段的起始交易时间
         * <p> 示例值：1685416831621
         */
        private String startTransTime;
        /**
         * 按时间范围进行对账时 时间段的截止交易时间
         * <p> 示例值：1685416831622
         */
        private String endTransTime;
        /**
         * 交易信息
         * <p> 示例值：
         */
        private TradeDetail[] tradeDetails;

        /**
         * 按时间范围进行对账时 时间段的起始交易时间
         * <p> 示例值：1685416831621
         *
         * @param startTransTime
         * @return
         */
        public Builder startTransTime(String startTransTime) {
            this.startTransTime = startTransTime;
            return this;
        }


        /**
         * 按时间范围进行对账时 时间段的截止交易时间
         * <p> 示例值：1685416831622
         *
         * @param endTransTime
         * @return
         */
        public Builder endTransTime(String endTransTime) {
            this.endTransTime = endTransTime;
            return this;
        }


        /**
         * 交易信息
         * <p> 示例值：
         *
         * @param tradeDetails
         * @return
         */
        public Builder tradeDetails(TradeDetail[] tradeDetails) {
            this.tradeDetails = tradeDetails;
            return this;
        }


        public ReconciliationReferralAccountReqBody build() {
            return new ReconciliationReferralAccountReqBody(this);
        }
    }
}
