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

public class CreateOfferRespBody {
    /**
     * Offer ID
     * <p> 示例值：7016605170635213100
     */
    @SerializedName("offer_id")
    private String offerId;
    /**
     * 投递 ID
     * <p> 示例值：7013552389293279532
     */
    @SerializedName("application_id")
    private String applicationId;
    /**
     * 模板 ID
     * <p> 示例值：7013318077945596204
     */
    @SerializedName("schema_id")
    private String schemaId;
    /**
     * Offer 类型
     * <p> 示例值：1
     */
    @SerializedName("offer_type")
    private Integer offerType;
    /**
     * Offer 基本信息
     * <p> 示例值：
     */
    @SerializedName("basic_info")
    private OfferBasicInfo basicInfo;
    /**
     * Offer 薪资信息
     * <p> 示例值：
     */
    @SerializedName("salary_info")
    private OfferSalaryInfo salaryInfo;
    /**
     * 自定义信息
     * <p> 示例值：
     */
    @SerializedName("customized_info_list")
    private OfferCustomizedInfo[] customizedInfoList;

    public String getOfferId() {
        return this.offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getSchemaId() {
        return this.schemaId;
    }

    public void setSchemaId(String schemaId) {
        this.schemaId = schemaId;
    }

    public Integer getOfferType() {
        return this.offerType;
    }

    public void setOfferType(Integer offerType) {
        this.offerType = offerType;
    }

    public OfferBasicInfo getBasicInfo() {
        return this.basicInfo;
    }

    public void setBasicInfo(OfferBasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public OfferSalaryInfo getSalaryInfo() {
        return this.salaryInfo;
    }

    public void setSalaryInfo(OfferSalaryInfo salaryInfo) {
        this.salaryInfo = salaryInfo;
    }

    public OfferCustomizedInfo[] getCustomizedInfoList() {
        return this.customizedInfoList;
    }

    public void setCustomizedInfoList(OfferCustomizedInfo[] customizedInfoList) {
        this.customizedInfoList = customizedInfoList;
    }

}
