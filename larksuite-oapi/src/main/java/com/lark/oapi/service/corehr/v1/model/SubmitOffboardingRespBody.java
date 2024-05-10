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

public class SubmitOffboardingRespBody {
    /**
     * 离职记录 id
     * <p> 示例值：7095671727698478604
     */
    @SerializedName("offboarding_id")
    private String offboardingId;
    /**
     * 雇员 id
     * <p> 示例值：6982509313466189342
     */
    @SerializedName("employment_id")
    private String employmentId;
    /**
     * 离职原因
     * <p> 示例值：reason_for_offboarding_option8
     */
    @SerializedName("offboarding_reason_unique_identifier")
    private String offboardingReasonUniqueIdentifier;
    /**
     * 离职日期
     * <p> 示例值：2022-05-18
     */
    @SerializedName("offboarding_date")
    private String offboardingDate;
    /**
     * 离职原因说明
     * <p> 示例值：离职原因说明
     */
    @SerializedName("offboarding_reason_explanation")
    private String offboardingReasonExplanation;
    /**
     * 是否加入离职屏蔽名单
     * <p> 示例值：false
     */
    @SerializedName("add_block_list")
    private Boolean addBlockList;
    /**
     * 屏蔽原因
     * <p> 示例值：红线
     */
    @SerializedName("block_reason")
    private String blockReason;
    /**
     * 屏蔽原因说明
     * <p> 示例值：xx 年 xx 月 xx 日因 xx 原因红线
     */
    @SerializedName("block_reason_explanation")
    private String blockReasonExplanation;
    /**
     * 创建时间
     * <p> 示例值：2022-05-09 17:50:17
     */
    @SerializedName("created_time")
    private String createdTime;

    public String getOffboardingId() {
        return this.offboardingId;
    }

    public void setOffboardingId(String offboardingId) {
        this.offboardingId = offboardingId;
    }

    public String getEmploymentId() {
        return this.employmentId;
    }

    public void setEmploymentId(String employmentId) {
        this.employmentId = employmentId;
    }

    public String getOffboardingReasonUniqueIdentifier() {
        return this.offboardingReasonUniqueIdentifier;
    }

    public void setOffboardingReasonUniqueIdentifier(String offboardingReasonUniqueIdentifier) {
        this.offboardingReasonUniqueIdentifier = offboardingReasonUniqueIdentifier;
    }

    public String getOffboardingDate() {
        return this.offboardingDate;
    }

    public void setOffboardingDate(String offboardingDate) {
        this.offboardingDate = offboardingDate;
    }

    public String getOffboardingReasonExplanation() {
        return this.offboardingReasonExplanation;
    }

    public void setOffboardingReasonExplanation(String offboardingReasonExplanation) {
        this.offboardingReasonExplanation = offboardingReasonExplanation;
    }

    public Boolean getAddBlockList() {
        return this.addBlockList;
    }

    public void setAddBlockList(Boolean addBlockList) {
        this.addBlockList = addBlockList;
    }

    public String getBlockReason() {
        return this.blockReason;
    }

    public void setBlockReason(String blockReason) {
        this.blockReason = blockReason;
    }

    public String getBlockReasonExplanation() {
        return this.blockReasonExplanation;
    }

    public void setBlockReasonExplanation(String blockReasonExplanation) {
        this.blockReasonExplanation = blockReasonExplanation;
    }

    public String getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

}
