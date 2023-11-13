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

package com.lark.oapi.service.corehr.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Query;

public class QueryTransferTypeReq {
    /**
     * 异动类型状态
     * <p> 示例值：true
     */
    @Query
    @SerializedName("active")
    private Boolean active;
    /**
     * 异动类型唯一标识，多条时最多数量为10
     * <p> 示例值：job_status_change
     */
    @Query
    @SerializedName("transfer_type_unique_identifier")
    private String[] transferTypeUniqueIdentifier;

    // builder 开始
    public QueryTransferTypeReq() {
    }

    public QueryTransferTypeReq(Builder builder) {
        /**
         * 异动类型状态
         * <p> 示例值：true
         */
        this.active = builder.active;
        /**
         * 异动类型唯一标识，多条时最多数量为10
         * <p> 示例值：job_status_change
         */
        this.transferTypeUniqueIdentifier = builder.transferTypeUniqueIdentifier;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String[] getTransferTypeUniqueIdentifier() {
        return this.transferTypeUniqueIdentifier;
    }

    public void setTransferTypeUniqueIdentifier(String[] transferTypeUniqueIdentifier) {
        this.transferTypeUniqueIdentifier = transferTypeUniqueIdentifier;
    }

    public static class Builder {
        private Boolean active; // 异动类型状态
        private String[] transferTypeUniqueIdentifier; // 异动类型唯一标识，多条时最多数量为10


        /**
         * 异动类型状态
         * <p> 示例值：true
         *
         * @param active
         * @return
         */
        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }


        /**
         * 异动类型唯一标识，多条时最多数量为10
         * <p> 示例值：job_status_change
         *
         * @param transferTypeUniqueIdentifier
         * @return
         */
        public Builder transferTypeUniqueIdentifier(String[] transferTypeUniqueIdentifier) {
            this.transferTypeUniqueIdentifier = transferTypeUniqueIdentifier;
            return this;
        }

        public QueryTransferTypeReq build() {
            return new QueryTransferTypeReq(this);
        }
    }
}