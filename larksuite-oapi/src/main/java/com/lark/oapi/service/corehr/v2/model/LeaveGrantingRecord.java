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

public class LeaveGrantingRecord {
    /**
     * 假期授予记录 ID
     * <p> 示例值：4718803945687580505
     */
    @SerializedName("id")
    private String id;
    /**
     * 员工 ID
     * <p> 示例值：4718803945687580505
     */
    @SerializedName("employment_id")
    private String employmentId;
    /**
     * 假期类型 ID
     * <p> 示例值：4718803945687580505
     */
    @SerializedName("leave_type_id")
    private String leaveTypeId;
    /**
     * 授予数量
     * <p> 示例值：4718803945687580505
     */
    @SerializedName("granting_quantity")
    private String grantingQuantity;
    /**
     * 授予时长单位
     * <p> 示例值：1
     */
    @SerializedName("granting_unit")
    private Integer grantingUnit;
    /**
     * 生效时间
     * <p> 示例值：2022-01-01
     */
    @SerializedName("effective_date")
    private String effectiveDate;
    /**
     * 失效时间（根据休假规则自动计算）
     * <p> 示例值：2022-01-01
     */
    @SerializedName("expiration_date")
    private String expirationDate;
    /**
     * 授予来源
     * <p> 示例值：1
     */
    @SerializedName("granted_by")
    private Integer grantedBy;
    /**
     * 授予原因
     * <p> 示例值：
     */
    @SerializedName("reason")
    private I18n[] reason;
    /**
     * 授予记录的创建时间，毫秒级unix时间戳
     * <p> 示例值：4718803945687580505
     */
    @SerializedName("created_at")
    private String createdAt;
    /**
     * 授予记录的创建人，值为创建人的员工 ID
     * <p> 示例值：1
     */
    @SerializedName("created_by")
    private String createdBy;
    /**
     * 授予记录的更新时间
     * <p> 示例值：2020-05-02 00:00:00
     */
    @SerializedName("updated_at")
    private String updatedAt;
    /**
     * 授予记录的更新人，值为更新人的员工 ID
     * <p> 示例值：123456789
     */
    @SerializedName("updated_by")
    private String updatedBy;
    /**
     * 是否参与折算
     * <p> 示例值：1
     */
    @SerializedName("section_type")
    private Integer sectionType;

    // builder 开始
    public LeaveGrantingRecord() {
    }

    public LeaveGrantingRecord(Builder builder) {
        /**
         * 假期授予记录 ID
         * <p> 示例值：4718803945687580505
         */
        this.id = builder.id;
        /**
         * 员工 ID
         * <p> 示例值：4718803945687580505
         */
        this.employmentId = builder.employmentId;
        /**
         * 假期类型 ID
         * <p> 示例值：4718803945687580505
         */
        this.leaveTypeId = builder.leaveTypeId;
        /**
         * 授予数量
         * <p> 示例值：4718803945687580505
         */
        this.grantingQuantity = builder.grantingQuantity;
        /**
         * 授予时长单位
         * <p> 示例值：1
         */
        this.grantingUnit = builder.grantingUnit;
        /**
         * 生效时间
         * <p> 示例值：2022-01-01
         */
        this.effectiveDate = builder.effectiveDate;
        /**
         * 失效时间（根据休假规则自动计算）
         * <p> 示例值：2022-01-01
         */
        this.expirationDate = builder.expirationDate;
        /**
         * 授予来源
         * <p> 示例值：1
         */
        this.grantedBy = builder.grantedBy;
        /**
         * 授予原因
         * <p> 示例值：
         */
        this.reason = builder.reason;
        /**
         * 授予记录的创建时间，毫秒级unix时间戳
         * <p> 示例值：4718803945687580505
         */
        this.createdAt = builder.createdAt;
        /**
         * 授予记录的创建人，值为创建人的员工 ID
         * <p> 示例值：1
         */
        this.createdBy = builder.createdBy;
        /**
         * 授予记录的更新时间
         * <p> 示例值：2020-05-02 00:00:00
         */
        this.updatedAt = builder.updatedAt;
        /**
         * 授予记录的更新人，值为更新人的员工 ID
         * <p> 示例值：123456789
         */
        this.updatedBy = builder.updatedBy;
        /**
         * 是否参与折算
         * <p> 示例值：1
         */
        this.sectionType = builder.sectionType;
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

    public String getEmploymentId() {
        return this.employmentId;
    }

    public void setEmploymentId(String employmentId) {
        this.employmentId = employmentId;
    }

    public String getLeaveTypeId() {
        return this.leaveTypeId;
    }

    public void setLeaveTypeId(String leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public String getGrantingQuantity() {
        return this.grantingQuantity;
    }

    public void setGrantingQuantity(String grantingQuantity) {
        this.grantingQuantity = grantingQuantity;
    }

    public Integer getGrantingUnit() {
        return this.grantingUnit;
    }

    public void setGrantingUnit(Integer grantingUnit) {
        this.grantingUnit = grantingUnit;
    }

    public String getEffectiveDate() {
        return this.effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getGrantedBy() {
        return this.grantedBy;
    }

    public void setGrantedBy(Integer grantedBy) {
        this.grantedBy = grantedBy;
    }

    public I18n[] getReason() {
        return this.reason;
    }

    public void setReason(I18n[] reason) {
        this.reason = reason;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getSectionType() {
        return this.sectionType;
    }

    public void setSectionType(Integer sectionType) {
        this.sectionType = sectionType;
    }

    public static class Builder {
        /**
         * 假期授予记录 ID
         * <p> 示例值：4718803945687580505
         */
        private String id;
        /**
         * 员工 ID
         * <p> 示例值：4718803945687580505
         */
        private String employmentId;
        /**
         * 假期类型 ID
         * <p> 示例值：4718803945687580505
         */
        private String leaveTypeId;
        /**
         * 授予数量
         * <p> 示例值：4718803945687580505
         */
        private String grantingQuantity;
        /**
         * 授予时长单位
         * <p> 示例值：1
         */
        private Integer grantingUnit;
        /**
         * 生效时间
         * <p> 示例值：2022-01-01
         */
        private String effectiveDate;
        /**
         * 失效时间（根据休假规则自动计算）
         * <p> 示例值：2022-01-01
         */
        private String expirationDate;
        /**
         * 授予来源
         * <p> 示例值：1
         */
        private Integer grantedBy;
        /**
         * 授予原因
         * <p> 示例值：
         */
        private I18n[] reason;
        /**
         * 授予记录的创建时间，毫秒级unix时间戳
         * <p> 示例值：4718803945687580505
         */
        private String createdAt;
        /**
         * 授予记录的创建人，值为创建人的员工 ID
         * <p> 示例值：1
         */
        private String createdBy;
        /**
         * 授予记录的更新时间
         * <p> 示例值：2020-05-02 00:00:00
         */
        private String updatedAt;
        /**
         * 授予记录的更新人，值为更新人的员工 ID
         * <p> 示例值：123456789
         */
        private String updatedBy;
        /**
         * 是否参与折算
         * <p> 示例值：1
         */
        private Integer sectionType;

        /**
         * 假期授予记录 ID
         * <p> 示例值：4718803945687580505
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 员工 ID
         * <p> 示例值：4718803945687580505
         *
         * @param employmentId
         * @return
         */
        public Builder employmentId(String employmentId) {
            this.employmentId = employmentId;
            return this;
        }


        /**
         * 假期类型 ID
         * <p> 示例值：4718803945687580505
         *
         * @param leaveTypeId
         * @return
         */
        public Builder leaveTypeId(String leaveTypeId) {
            this.leaveTypeId = leaveTypeId;
            return this;
        }


        /**
         * 授予数量
         * <p> 示例值：4718803945687580505
         *
         * @param grantingQuantity
         * @return
         */
        public Builder grantingQuantity(String grantingQuantity) {
            this.grantingQuantity = grantingQuantity;
            return this;
        }


        /**
         * 授予时长单位
         * <p> 示例值：1
         *
         * @param grantingUnit
         * @return
         */
        public Builder grantingUnit(Integer grantingUnit) {
            this.grantingUnit = grantingUnit;
            return this;
        }


        /**
         * 生效时间
         * <p> 示例值：2022-01-01
         *
         * @param effectiveDate
         * @return
         */
        public Builder effectiveDate(String effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }


        /**
         * 失效时间（根据休假规则自动计算）
         * <p> 示例值：2022-01-01
         *
         * @param expirationDate
         * @return
         */
        public Builder expirationDate(String expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }


        /**
         * 授予来源
         * <p> 示例值：1
         *
         * @param grantedBy
         * @return
         */
        public Builder grantedBy(Integer grantedBy) {
            this.grantedBy = grantedBy;
            return this;
        }


        /**
         * 授予原因
         * <p> 示例值：
         *
         * @param reason
         * @return
         */
        public Builder reason(I18n[] reason) {
            this.reason = reason;
            return this;
        }


        /**
         * 授予记录的创建时间，毫秒级unix时间戳
         * <p> 示例值：4718803945687580505
         *
         * @param createdAt
         * @return
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }


        /**
         * 授予记录的创建人，值为创建人的员工 ID
         * <p> 示例值：1
         *
         * @param createdBy
         * @return
         */
        public Builder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }


        /**
         * 授予记录的更新时间
         * <p> 示例值：2020-05-02 00:00:00
         *
         * @param updatedAt
         * @return
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }


        /**
         * 授予记录的更新人，值为更新人的员工 ID
         * <p> 示例值：123456789
         *
         * @param updatedBy
         * @return
         */
        public Builder updatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }


        /**
         * 是否参与折算
         * <p> 示例值：1
         *
         * @param sectionType
         * @return
         */
        public Builder sectionType(Integer sectionType) {
            this.sectionType = sectionType;
            return this;
        }


        public LeaveGrantingRecord build() {
            return new LeaveGrantingRecord(this);
        }
    }
}
