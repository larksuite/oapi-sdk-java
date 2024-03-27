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

package com.lark.oapi.service.corehr.v2.model;

import com.google.gson.annotations.SerializedName;

public class CostCenter {
    /**
     * 成本中心ID
     * <p> 示例值：6969828847121885087
     */
    @SerializedName("cost_center_id")
    private String costCenterId;
    /**
     * 成本中心名称
     * <p> 示例值：
     */
    @SerializedName("name")
    private I18n[] name;
    /**
     * 编码
     * <p> 示例值：MDPD00000023
     */
    @SerializedName("code")
    private String code;
    /**
     * 上级成本中心ID
     * <p> 示例值：6862995757234914824
     */
    @SerializedName("parent_cost_center_id")
    private String parentCostCenterId;
    /**
     * 成本中心负责人ID 列表，可通过雇佣信息接口查询获得
     * <p> 示例值：
     */
    @SerializedName("managers")
    private String[] managers;
    /**
     * 成本中心描述
     * <p> 示例值：
     */
    @SerializedName("description")
    private I18n[] description;
    /**
     * 生效时间
     * <p> 示例值：2020-01-01
     */
    @SerializedName("effective_time")
    private String effectiveTime;
    /**
     * 过期时间
     * <p> 示例值：2020-01-01
     */
    @SerializedName("expiration_time")
    private String expirationTime;
    /**
     * 当前实体是否启用
     * <p> 示例值：2020-01-01
     */
    @SerializedName("active")
    private Boolean active;
    /**
     * 操作原因
     * <p> 示例值：过期作废
     */
    @SerializedName("operation_reason")
    private String operationReason;

    // builder 开始
    public CostCenter() {
    }

    public CostCenter(Builder builder) {
        /**
         * 成本中心ID
         * <p> 示例值：6969828847121885087
         */
        this.costCenterId = builder.costCenterId;
        /**
         * 成本中心名称
         * <p> 示例值：
         */
        this.name = builder.name;
        /**
         * 编码
         * <p> 示例值：MDPD00000023
         */
        this.code = builder.code;
        /**
         * 上级成本中心ID
         * <p> 示例值：6862995757234914824
         */
        this.parentCostCenterId = builder.parentCostCenterId;
        /**
         * 成本中心负责人ID 列表，可通过雇佣信息接口查询获得
         * <p> 示例值：
         */
        this.managers = builder.managers;
        /**
         * 成本中心描述
         * <p> 示例值：
         */
        this.description = builder.description;
        /**
         * 生效时间
         * <p> 示例值：2020-01-01
         */
        this.effectiveTime = builder.effectiveTime;
        /**
         * 过期时间
         * <p> 示例值：2020-01-01
         */
        this.expirationTime = builder.expirationTime;
        /**
         * 当前实体是否启用
         * <p> 示例值：2020-01-01
         */
        this.active = builder.active;
        /**
         * 操作原因
         * <p> 示例值：过期作废
         */
        this.operationReason = builder.operationReason;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCostCenterId() {
        return this.costCenterId;
    }

    public void setCostCenterId(String costCenterId) {
        this.costCenterId = costCenterId;
    }

    public I18n[] getName() {
        return this.name;
    }

    public void setName(I18n[] name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCostCenterId() {
        return this.parentCostCenterId;
    }

    public void setParentCostCenterId(String parentCostCenterId) {
        this.parentCostCenterId = parentCostCenterId;
    }

    public String[] getManagers() {
        return this.managers;
    }

    public void setManagers(String[] managers) {
        this.managers = managers;
    }

    public I18n[] getDescription() {
        return this.description;
    }

    public void setDescription(I18n[] description) {
        this.description = description;
    }

    public String getEffectiveTime() {
        return this.effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getExpirationTime() {
        return this.expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getOperationReason() {
        return this.operationReason;
    }

    public void setOperationReason(String operationReason) {
        this.operationReason = operationReason;
    }

    public static class Builder {
        /**
         * 成本中心ID
         * <p> 示例值：6969828847121885087
         */
        private String costCenterId;
        /**
         * 成本中心名称
         * <p> 示例值：
         */
        private I18n[] name;
        /**
         * 编码
         * <p> 示例值：MDPD00000023
         */
        private String code;
        /**
         * 上级成本中心ID
         * <p> 示例值：6862995757234914824
         */
        private String parentCostCenterId;
        /**
         * 成本中心负责人ID 列表，可通过雇佣信息接口查询获得
         * <p> 示例值：
         */
        private String[] managers;
        /**
         * 成本中心描述
         * <p> 示例值：
         */
        private I18n[] description;
        /**
         * 生效时间
         * <p> 示例值：2020-01-01
         */
        private String effectiveTime;
        /**
         * 过期时间
         * <p> 示例值：2020-01-01
         */
        private String expirationTime;
        /**
         * 当前实体是否启用
         * <p> 示例值：2020-01-01
         */
        private Boolean active;
        /**
         * 操作原因
         * <p> 示例值：过期作废
         */
        private String operationReason;

        /**
         * 成本中心ID
         * <p> 示例值：6969828847121885087
         *
         * @param costCenterId
         * @return
         */
        public Builder costCenterId(String costCenterId) {
            this.costCenterId = costCenterId;
            return this;
        }


        /**
         * 成本中心名称
         * <p> 示例值：
         *
         * @param name
         * @return
         */
        public Builder name(I18n[] name) {
            this.name = name;
            return this;
        }


        /**
         * 编码
         * <p> 示例值：MDPD00000023
         *
         * @param code
         * @return
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }


        /**
         * 上级成本中心ID
         * <p> 示例值：6862995757234914824
         *
         * @param parentCostCenterId
         * @return
         */
        public Builder parentCostCenterId(String parentCostCenterId) {
            this.parentCostCenterId = parentCostCenterId;
            return this;
        }


        /**
         * 成本中心负责人ID 列表，可通过雇佣信息接口查询获得
         * <p> 示例值：
         *
         * @param managers
         * @return
         */
        public Builder managers(String[] managers) {
            this.managers = managers;
            return this;
        }


        /**
         * 成本中心描述
         * <p> 示例值：
         *
         * @param description
         * @return
         */
        public Builder description(I18n[] description) {
            this.description = description;
            return this;
        }


        /**
         * 生效时间
         * <p> 示例值：2020-01-01
         *
         * @param effectiveTime
         * @return
         */
        public Builder effectiveTime(String effectiveTime) {
            this.effectiveTime = effectiveTime;
            return this;
        }


        /**
         * 过期时间
         * <p> 示例值：2020-01-01
         *
         * @param expirationTime
         * @return
         */
        public Builder expirationTime(String expirationTime) {
            this.expirationTime = expirationTime;
            return this;
        }


        /**
         * 当前实体是否启用
         * <p> 示例值：2020-01-01
         *
         * @param active
         * @return
         */
        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }


        /**
         * 操作原因
         * <p> 示例值：过期作废
         *
         * @param operationReason
         * @return
         */
        public Builder operationReason(String operationReason) {
            this.operationReason = operationReason;
            return this;
        }


        public CostCenter build() {
            return new CostCenter(this);
        }
    }
}
