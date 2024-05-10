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

import com.lark.oapi.core.response.EmptyData;
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

public class AppliOfferOnboardProfileAdd {
    /**
     * ID
     * <p> 示例值：
     */
    @SerializedName("id")
    private String id;
    /**
     * 名字
     * <p> 示例值：
     */
    @SerializedName("name")
    private String name;
    /**
     * 英文名
     * <p> 示例值：
     */
    @SerializedName("en_name")
    private String enName;
    /**
     * 区
     * <p> 示例值：
     */
    @SerializedName("district")
    private AppliOfferOnboardProfileCity district;
    /**
     * 城市
     * <p> 示例值：
     */
    @SerializedName("city")
    private AppliOfferOnboardProfileCity city;
    /**
     * 省
     * <p> 示例值：
     */
    @SerializedName("state")
    private AppliOfferOnboardProfileCity state;
    /**
     * 国家
     * <p> 示例值：
     */
    @SerializedName("country")
    private AppliOfferOnboardProfileCity country;
    /**
     * 使用ID列表
     * <p> 示例值：
     */
    @SerializedName("usage_id_list")
    private String[] usageIdList;
    /**
     * 状态
     * <p> 示例值：
     */
    @SerializedName("active_status")
    private Integer activeStatus;

    // builder 开始
    public AppliOfferOnboardProfileAdd() {
    }

    public AppliOfferOnboardProfileAdd(Builder builder) {
        /**
         * ID
         * <p> 示例值：
         */
        this.id = builder.id;
        /**
         * 名字
         * <p> 示例值：
         */
        this.name = builder.name;
        /**
         * 英文名
         * <p> 示例值：
         */
        this.enName = builder.enName;
        /**
         * 区
         * <p> 示例值：
         */
        this.district = builder.district;
        /**
         * 城市
         * <p> 示例值：
         */
        this.city = builder.city;
        /**
         * 省
         * <p> 示例值：
         */
        this.state = builder.state;
        /**
         * 国家
         * <p> 示例值：
         */
        this.country = builder.country;
        /**
         * 使用ID列表
         * <p> 示例值：
         */
        this.usageIdList = builder.usageIdList;
        /**
         * 状态
         * <p> 示例值：
         */
        this.activeStatus = builder.activeStatus;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return this.enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public AppliOfferOnboardProfileCity getDistrict() {
        return this.district;
    }

    public void setDistrict(AppliOfferOnboardProfileCity district) {
        this.district = district;
    }

    public AppliOfferOnboardProfileCity getCity() {
        return this.city;
    }

    public void setCity(AppliOfferOnboardProfileCity city) {
        this.city = city;
    }

    public AppliOfferOnboardProfileCity getState() {
        return this.state;
    }

    public void setState(AppliOfferOnboardProfileCity state) {
        this.state = state;
    }

    public AppliOfferOnboardProfileCity getCountry() {
        return this.country;
    }

    public void setCountry(AppliOfferOnboardProfileCity country) {
        this.country = country;
    }

    public String[] getUsageIdList() {
        return this.usageIdList;
    }

    public void setUsageIdList(String[] usageIdList) {
        this.usageIdList = usageIdList;
    }

    public Integer getActiveStatus() {
        return this.activeStatus;
    }

    public void setActiveStatus(Integer activeStatus) {
        this.activeStatus = activeStatus;
    }

    public static class Builder {
        /**
         * ID
         * <p> 示例值：
         */
        private String id;
        /**
         * 名字
         * <p> 示例值：
         */
        private String name;
        /**
         * 英文名
         * <p> 示例值：
         */
        private String enName;
        /**
         * 区
         * <p> 示例值：
         */
        private AppliOfferOnboardProfileCity district;
        /**
         * 城市
         * <p> 示例值：
         */
        private AppliOfferOnboardProfileCity city;
        /**
         * 省
         * <p> 示例值：
         */
        private AppliOfferOnboardProfileCity state;
        /**
         * 国家
         * <p> 示例值：
         */
        private AppliOfferOnboardProfileCity country;
        /**
         * 使用ID列表
         * <p> 示例值：
         */
        private String[] usageIdList;
        /**
         * 状态
         * <p> 示例值：
         */
        private Integer activeStatus;

        /**
         * ID
         * <p> 示例值：
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 名字
         * <p> 示例值：
         *
         * @param name
         * @return
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }


        /**
         * 英文名
         * <p> 示例值：
         *
         * @param enName
         * @return
         */
        public Builder enName(String enName) {
            this.enName = enName;
            return this;
        }


        /**
         * 区
         * <p> 示例值：
         *
         * @param district
         * @return
         */
        public Builder district(AppliOfferOnboardProfileCity district) {
            this.district = district;
            return this;
        }


        /**
         * 城市
         * <p> 示例值：
         *
         * @param city
         * @return
         */
        public Builder city(AppliOfferOnboardProfileCity city) {
            this.city = city;
            return this;
        }


        /**
         * 省
         * <p> 示例值：
         *
         * @param state
         * @return
         */
        public Builder state(AppliOfferOnboardProfileCity state) {
            this.state = state;
            return this;
        }


        /**
         * 国家
         * <p> 示例值：
         *
         * @param country
         * @return
         */
        public Builder country(AppliOfferOnboardProfileCity country) {
            this.country = country;
            return this;
        }


        /**
         * 使用ID列表
         * <p> 示例值：
         *
         * @param usageIdList
         * @return
         */
        public Builder usageIdList(String[] usageIdList) {
            this.usageIdList = usageIdList;
            return this;
        }


        /**
         * 状态
         * <p> 示例值：
         *
         * @param activeStatus
         * @return
         */
        public Builder activeStatus(Integer activeStatus) {
            this.activeStatus = activeStatus;
            return this;
        }


        public AppliOfferOnboardProfileAdd build() {
            return new AppliOfferOnboardProfileAdd(this);
        }
    }
}
