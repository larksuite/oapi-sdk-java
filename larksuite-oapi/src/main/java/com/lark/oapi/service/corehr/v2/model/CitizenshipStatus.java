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

public class CitizenshipStatus {
    /**
     * 公民身份id
     * <p> 示例值：6891251722631890445
     */
    @SerializedName("id")
    private String id;
    /**
     * 国家/地区id
     * <p> 示例值：6891251722631890445
     */
    @SerializedName("country_region_id")
    private String countryRegionId;
    /**
     * 是否启用
     * <p> 示例值：true
     */
    @SerializedName("active")
    private Boolean active;
    /**
     * 名称
     * <p> 示例值：
     */
    @SerializedName("name")
    private I18n[] name;
    /**
     * 公民身份
     * <p> 示例值：
     */
    @SerializedName("citizenship_status")
    private I18n[] citizenshipStatus;
    /**
     * 排序
     * <p> 示例值：1
     */
    @SerializedName("view_order")
    private String viewOrder;

    // builder 开始
    public CitizenshipStatus() {
    }

    public CitizenshipStatus(Builder builder) {
        /**
         * 公民身份id
         * <p> 示例值：6891251722631890445
         */
        this.id = builder.id;
        /**
         * 国家/地区id
         * <p> 示例值：6891251722631890445
         */
        this.countryRegionId = builder.countryRegionId;
        /**
         * 是否启用
         * <p> 示例值：true
         */
        this.active = builder.active;
        /**
         * 名称
         * <p> 示例值：
         */
        this.name = builder.name;
        /**
         * 公民身份
         * <p> 示例值：
         */
        this.citizenshipStatus = builder.citizenshipStatus;
        /**
         * 排序
         * <p> 示例值：1
         */
        this.viewOrder = builder.viewOrder;
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

    public String getCountryRegionId() {
        return this.countryRegionId;
    }

    public void setCountryRegionId(String countryRegionId) {
        this.countryRegionId = countryRegionId;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public I18n[] getName() {
        return this.name;
    }

    public void setName(I18n[] name) {
        this.name = name;
    }

    public I18n[] getCitizenshipStatus() {
        return this.citizenshipStatus;
    }

    public void setCitizenshipStatus(I18n[] citizenshipStatus) {
        this.citizenshipStatus = citizenshipStatus;
    }

    public String getViewOrder() {
        return this.viewOrder;
    }

    public void setViewOrder(String viewOrder) {
        this.viewOrder = viewOrder;
    }

    public static class Builder {
        /**
         * 公民身份id
         * <p> 示例值：6891251722631890445
         */
        private String id;
        /**
         * 国家/地区id
         * <p> 示例值：6891251722631890445
         */
        private String countryRegionId;
        /**
         * 是否启用
         * <p> 示例值：true
         */
        private Boolean active;
        /**
         * 名称
         * <p> 示例值：
         */
        private I18n[] name;
        /**
         * 公民身份
         * <p> 示例值：
         */
        private I18n[] citizenshipStatus;
        /**
         * 排序
         * <p> 示例值：1
         */
        private String viewOrder;

        /**
         * 公民身份id
         * <p> 示例值：6891251722631890445
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 国家/地区id
         * <p> 示例值：6891251722631890445
         *
         * @param countryRegionId
         * @return
         */
        public Builder countryRegionId(String countryRegionId) {
            this.countryRegionId = countryRegionId;
            return this;
        }


        /**
         * 是否启用
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
         * 名称
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
         * 公民身份
         * <p> 示例值：
         *
         * @param citizenshipStatus
         * @return
         */
        public Builder citizenshipStatus(I18n[] citizenshipStatus) {
            this.citizenshipStatus = citizenshipStatus;
            return this;
        }


        /**
         * 排序
         * <p> 示例值：1
         *
         * @param viewOrder
         * @return
         */
        public Builder viewOrder(String viewOrder) {
            this.viewOrder = viewOrder;
            return this;
        }


        public CitizenshipStatus build() {
            return new CitizenshipStatus(this);
        }
    }
}
