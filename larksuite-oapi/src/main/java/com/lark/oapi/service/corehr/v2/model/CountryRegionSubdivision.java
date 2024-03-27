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

public class CountryRegionSubdivision {
    /**
     * 省份/行政区 ID
     * <p> 示例值：6822114062122064111
     */
    @SerializedName("country_region_subdivision_id")
    private String countryRegionSubdivisionId;
    /**
     * 省份/行政区名称
     * <p> 示例值：
     */
    @SerializedName("name")
    private I18n[] name;
    /**
     * 所属国家/地区 ID，详细信息可通过【查询国家/地区信息】接口查询获得
     * <p> 示例值：6822114062122062211
     */
    @SerializedName("country_region_id")
    private String countryRegionId;
    /**
     * 行政区类型，枚举值可通过文档【飞书人事枚举常量】行政区类型（subdivision_type）枚举定义部分获得
     * <p> 示例值：
     */
    @SerializedName("subdivision_type")
    private Enum subdivisionType;
    /**
     * 省份/行政区三字码
     * <p> 示例值：PEK
     */
    @SerializedName("iso_code")
    private String isoCode;
    /**
     * 状态
     * <p> 示例值：1
     */
    @SerializedName("status")
    private Integer status;

    // builder 开始
    public CountryRegionSubdivision() {
    }

    public CountryRegionSubdivision(Builder builder) {
        /**
         * 省份/行政区 ID
         * <p> 示例值：6822114062122064111
         */
        this.countryRegionSubdivisionId = builder.countryRegionSubdivisionId;
        /**
         * 省份/行政区名称
         * <p> 示例值：
         */
        this.name = builder.name;
        /**
         * 所属国家/地区 ID，详细信息可通过【查询国家/地区信息】接口查询获得
         * <p> 示例值：6822114062122062211
         */
        this.countryRegionId = builder.countryRegionId;
        /**
         * 行政区类型，枚举值可通过文档【飞书人事枚举常量】行政区类型（subdivision_type）枚举定义部分获得
         * <p> 示例值：
         */
        this.subdivisionType = builder.subdivisionType;
        /**
         * 省份/行政区三字码
         * <p> 示例值：PEK
         */
        this.isoCode = builder.isoCode;
        /**
         * 状态
         * <p> 示例值：1
         */
        this.status = builder.status;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCountryRegionSubdivisionId() {
        return this.countryRegionSubdivisionId;
    }

    public void setCountryRegionSubdivisionId(String countryRegionSubdivisionId) {
        this.countryRegionSubdivisionId = countryRegionSubdivisionId;
    }

    public I18n[] getName() {
        return this.name;
    }

    public void setName(I18n[] name) {
        this.name = name;
    }

    public String getCountryRegionId() {
        return this.countryRegionId;
    }

    public void setCountryRegionId(String countryRegionId) {
        this.countryRegionId = countryRegionId;
    }

    public Enum getSubdivisionType() {
        return this.subdivisionType;
    }

    public void setSubdivisionType(Enum subdivisionType) {
        this.subdivisionType = subdivisionType;
    }

    public String getIsoCode() {
        return this.isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static class Builder {
        /**
         * 省份/行政区 ID
         * <p> 示例值：6822114062122064111
         */
        private String countryRegionSubdivisionId;
        /**
         * 省份/行政区名称
         * <p> 示例值：
         */
        private I18n[] name;
        /**
         * 所属国家/地区 ID，详细信息可通过【查询国家/地区信息】接口查询获得
         * <p> 示例值：6822114062122062211
         */
        private String countryRegionId;
        /**
         * 行政区类型，枚举值可通过文档【飞书人事枚举常量】行政区类型（subdivision_type）枚举定义部分获得
         * <p> 示例值：
         */
        private Enum subdivisionType;
        /**
         * 省份/行政区三字码
         * <p> 示例值：PEK
         */
        private String isoCode;
        /**
         * 状态
         * <p> 示例值：1
         */
        private Integer status;

        /**
         * 省份/行政区 ID
         * <p> 示例值：6822114062122064111
         *
         * @param countryRegionSubdivisionId
         * @return
         */
        public Builder countryRegionSubdivisionId(String countryRegionSubdivisionId) {
            this.countryRegionSubdivisionId = countryRegionSubdivisionId;
            return this;
        }


        /**
         * 省份/行政区名称
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
         * 所属国家/地区 ID，详细信息可通过【查询国家/地区信息】接口查询获得
         * <p> 示例值：6822114062122062211
         *
         * @param countryRegionId
         * @return
         */
        public Builder countryRegionId(String countryRegionId) {
            this.countryRegionId = countryRegionId;
            return this;
        }


        /**
         * 行政区类型，枚举值可通过文档【飞书人事枚举常量】行政区类型（subdivision_type）枚举定义部分获得
         * <p> 示例值：
         *
         * @param subdivisionType
         * @return
         */
        public Builder subdivisionType(Enum subdivisionType) {
            this.subdivisionType = subdivisionType;
            return this;
        }


        /**
         * 省份/行政区三字码
         * <p> 示例值：PEK
         *
         * @param isoCode
         * @return
         */
        public Builder isoCode(String isoCode) {
            this.isoCode = isoCode;
            return this;
        }


        /**
         * 状态
         * <p> 示例值：1
         *
         * @param status
         * @return
         */
        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        /**
         * 状态
         * <p> 示例值：1
         *
         * @param status {@link com.lark.oapi.service.corehr.v2.enums.CountryRegionSubdivisionBasicDataObjStatusEnum}
         * @return
         */
        public Builder status(com.lark.oapi.service.corehr.v2.enums.CountryRegionSubdivisionBasicDataObjStatusEnum status) {
            this.status = status.getValue();
            return this;
        }


        public CountryRegionSubdivision build() {
            return new CountryRegionSubdivision(this);
        }
    }
}
