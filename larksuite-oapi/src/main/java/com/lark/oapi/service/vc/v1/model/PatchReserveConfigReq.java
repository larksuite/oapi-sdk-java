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

package com.lark.oapi.service.vc.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class PatchReserveConfigReq {
    /**
     * 此次调用中使用的用户ID的类型
     * <p> 示例值：
     */
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    /**
     * 会议室或层级id
     * <p> 示例值：omm_3c5dd7e09bac0c1758fcf9511bd1a771
     */
    @Path
    @SerializedName("reserve_config_id")
    private String reserveConfigId;
    @Body
    private PatchReserveConfigReqBody body;

    // builder 开始
    public PatchReserveConfigReq() {
    }

    public PatchReserveConfigReq(Builder builder) {
        /**
         * 此次调用中使用的用户ID的类型
         * <p> 示例值：
         */
        this.userIdType = builder.userIdType;
        /**
         * 会议室或层级id
         * <p> 示例值：omm_3c5dd7e09bac0c1758fcf9511bd1a771
         */
        this.reserveConfigId = builder.reserveConfigId;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUserIdType() {
        return this.userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
    }

    public String getReserveConfigId() {
        return this.reserveConfigId;
    }

    public void setReserveConfigId(String reserveConfigId) {
        this.reserveConfigId = reserveConfigId;
    }

    public PatchReserveConfigReqBody getPatchReserveConfigReqBody() {
        return this.body;
    }

    public void setPatchReserveConfigReqBody(PatchReserveConfigReqBody body) {
        this.body = body;
    }

    public static class Builder {
        private String userIdType; // 此次调用中使用的用户ID的类型
        private String reserveConfigId; // 会议室或层级id
        private PatchReserveConfigReqBody body;

        /**
         * 此次调用中使用的用户ID的类型
         * <p> 示例值：
         *
         * @param userIdType
         * @return
         */
        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        /**
         * 此次调用中使用的用户ID的类型
         * <p> 示例值：
         *
         * @param userIdType {@link com.lark.oapi.service.vc.v1.enums.PatchReserveConfigUserIdTypeEnum}
         * @return
         */
        public Builder userIdType(com.lark.oapi.service.vc.v1.enums.PatchReserveConfigUserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        /**
         * 会议室或层级id
         * <p> 示例值：omm_3c5dd7e09bac0c1758fcf9511bd1a771
         *
         * @param reserveConfigId
         * @return
         */
        public Builder reserveConfigId(String reserveConfigId) {
            this.reserveConfigId = reserveConfigId;
            return this;
        }

        public PatchReserveConfigReqBody getPatchReserveConfigReqBody() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder patchReserveConfigReqBody(PatchReserveConfigReqBody body) {
            this.body = body;
            return this;
        }

        public PatchReserveConfigReq build() {
            return new PatchReserveConfigReq(this);
        }
    }
}
