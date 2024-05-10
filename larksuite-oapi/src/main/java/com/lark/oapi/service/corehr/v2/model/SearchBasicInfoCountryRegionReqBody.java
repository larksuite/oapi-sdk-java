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

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.corehr.v2.enums.*;
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

public class SearchBasicInfoCountryRegionReqBody {
    /**
     * 国家/地区 ID 列表
     * <p> 示例值：
     */
    @SerializedName("country_region_id_list")
    private String[] countryRegionIdList;
    /**
     * 状态列表
     * <p> 示例值：
     */
    @SerializedName("status_list")
    private Integer[] statusList;

    // builder 开始
    public SearchBasicInfoCountryRegionReqBody() {
    }

    public SearchBasicInfoCountryRegionReqBody(Builder builder) {
        /**
         * 国家/地区 ID 列表
         * <p> 示例值：
         */
        this.countryRegionIdList = builder.countryRegionIdList;
        /**
         * 状态列表
         * <p> 示例值：
         */
        this.statusList = builder.statusList;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String[] getCountryRegionIdList() {
        return this.countryRegionIdList;
    }

    public void setCountryRegionIdList(String[] countryRegionIdList) {
        this.countryRegionIdList = countryRegionIdList;
    }

    public Integer[] getStatusList() {
        return this.statusList;
    }

    public void setStatusList(Integer[] statusList) {
        this.statusList = statusList;
    }

    public static class Builder {
        /**
         * 国家/地区 ID 列表
         * <p> 示例值：
         */
        private String[] countryRegionIdList;
        /**
         * 状态列表
         * <p> 示例值：
         */
        private Integer[] statusList;

        /**
         * 国家/地区 ID 列表
         * <p> 示例值：
         *
         * @param countryRegionIdList
         * @return
         */
        public Builder countryRegionIdList(String[] countryRegionIdList) {
            this.countryRegionIdList = countryRegionIdList;
            return this;
        }


        /**
         * 状态列表
         * <p> 示例值：
         *
         * @param statusList
         * @return
         */
        public Builder statusList(Integer[] statusList) {
            this.statusList = statusList;
            return this;
        }


        public SearchBasicInfoCountryRegionReqBody build() {
            return new SearchBasicInfoCountryRegionReqBody(this);
        }
    }
}
