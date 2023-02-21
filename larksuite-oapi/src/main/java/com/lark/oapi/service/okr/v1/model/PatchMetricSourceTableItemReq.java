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

package com.lark.oapi.service.okr.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class PatchMetricSourceTableItemReq {
    /**
     * 此次调用中使用的用户ID的类型
     * <p> 示例值：
     */
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    /**
     * okr指标库id
     * <p> 示例值：7041857032248410131
     */
    @Path
    @SerializedName("metric_source_id")
    private String metricSourceId;
    /**
     * okr指标表id
     * <p> 示例值：7041857032248410131
     */
    @Path
    @SerializedName("metric_table_id")
    private String metricTableId;
    /**
     * okr指标项id
     * <p> 示例值：7041857032248410131
     */
    @Path
    @SerializedName("metric_item_id")
    private String metricItemId;
    @Body
    private PatchMetricSourceTableItemReqBody body;
    // builder 开始
    public PatchMetricSourceTableItemReq() {
    }

    public PatchMetricSourceTableItemReq(Builder builder) {
        /**
         * 此次调用中使用的用户ID的类型
         * <p> 示例值：
         */
        this.userIdType = builder.userIdType;
        /**
         * okr指标库id
         * <p> 示例值：7041857032248410131
         */
        this.metricSourceId = builder.metricSourceId;
        /**
         * okr指标表id
         * <p> 示例值：7041857032248410131
         */
        this.metricTableId = builder.metricTableId;
        /**
         * okr指标项id
         * <p> 示例值：7041857032248410131
         */
        this.metricItemId = builder.metricItemId;
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

    public String getMetricSourceId() {
        return this.metricSourceId;
    }

    public void setMetricSourceId(String metricSourceId) {
        this.metricSourceId = metricSourceId;
    }

    public String getMetricTableId() {
        return this.metricTableId;
    }

    public void setMetricTableId(String metricTableId) {
        this.metricTableId = metricTableId;
    }

    public String getMetricItemId() {
        return this.metricItemId;
    }

    public void setMetricItemId(String metricItemId) {
        this.metricItemId = metricItemId;
    }

    public PatchMetricSourceTableItemReqBody getPatchMetricSourceTableItemReqBody() {
        return this.body;
    }

    public void setPatchMetricSourceTableItemReqBody(PatchMetricSourceTableItemReqBody body) {
        this.body = body;
    }

    public static class Builder {
        private String userIdType; // 此次调用中使用的用户ID的类型
        private String metricSourceId; // okr指标库id
        private String metricTableId; // okr指标表id
        private String metricItemId; // okr指标项id
        private PatchMetricSourceTableItemReqBody body;

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
         * @param userIdType {@link com.lark.oapi.service.okr.v1.enums.PatchMetricSourceTableItemUserIdTypeEnum}
         * @return
         */
        public Builder userIdType(com.lark.oapi.service.okr.v1.enums.PatchMetricSourceTableItemUserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        /**
         * okr指标库id
         * <p> 示例值：7041857032248410131
         *
         * @param metricSourceId
         * @return
         */
        public Builder metricSourceId(String metricSourceId) {
            this.metricSourceId = metricSourceId;
            return this;
        }

        /**
         * okr指标表id
         * <p> 示例值：7041857032248410131
         *
         * @param metricTableId
         * @return
         */
        public Builder metricTableId(String metricTableId) {
            this.metricTableId = metricTableId;
            return this;
        }

        /**
         * okr指标项id
         * <p> 示例值：7041857032248410131
         *
         * @param metricItemId
         * @return
         */
        public Builder metricItemId(String metricItemId) {
            this.metricItemId = metricItemId;
            return this;
        }

        public PatchMetricSourceTableItemReqBody getPatchMetricSourceTableItemReqBody() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder patchMetricSourceTableItemReqBody(PatchMetricSourceTableItemReqBody body) {
            this.body = body;
            return this;
        }

        public PatchMetricSourceTableItemReq build() {
            return new PatchMetricSourceTableItemReq(this);
        }
    }
}