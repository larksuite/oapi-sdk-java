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

public class P2EmploymentUpdatedV1Data {
    /**
     * 被更新的雇佣信息 ID
     * <p> 示例值：201571108
     */
    @SerializedName("employment_id")
    private String employmentId;
    /**
     * 用户 ID
     * <p> 示例值：
     */
    @SerializedName("target_user_id")
    private UserId targetUserId;
    /**
     * 发生变更的字段
     * <p> 示例值：
     */
    @SerializedName("field_changes")
    private String[] fieldChanges;

    public String getEmploymentId() {
        return this.employmentId;
    }

    public void setEmploymentId(String employmentId) {
        this.employmentId = employmentId;
    }

    public UserId getTargetUserId() {
        return this.targetUserId;
    }

    public void setTargetUserId(UserId targetUserId) {
        this.targetUserId = targetUserId;
    }

    public String[] getFieldChanges() {
        return this.fieldChanges;
    }

    public void setFieldChanges(String[] fieldChanges) {
        this.fieldChanges = fieldChanges;
    }

}