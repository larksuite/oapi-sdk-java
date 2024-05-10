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

public class ProfileSettingDependent {
    /**
     * 姓名
     * <p> 示例值：王大帅
     */
    @SerializedName("legal_name")
    private String legalName;
    /**
     * 生日
     * <p> 示例值：2006-01-02
     */
    @SerializedName("date_of_birth")
    private String dateOfBirth;
    /**
     * 关系，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "dependent" custom_api_name ="relationship_with_dependent"
     * <p> 示例值：parent
     */
    @SerializedName("relationship_with_dependent")
    private String relationshipWithDependent;
    /**
     * 性别，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "dependent" custom_api_name = "gender"
     * <p> 示例值：female
     */
    @SerializedName("gender")
    private String gender;
    /**
     * 电话
     * <p> 示例值：
     */
    @SerializedName("phone")
    private ProfileSettingPhone phone;
    /**
     * 岗位
     * <p> 示例值：岗位
     */
    @SerializedName("job")
    private String job;
    /**
     * 出生证明
     * <p> 示例值：
     */
    @SerializedName("child_birth_certificates")
    private ProfileSettingFile[] childBirthCertificates;
    /**
     * 工作单位
     * <p> 示例值：飞书
     */
    @SerializedName("employer")
    private String employer;
    /**
     * 自定义字段
     * <p> 示例值：
     */
    @SerializedName("custom_fields")
    private ProfileSettingCustomField[] customFields;
    /**
     * 联系地址
     * <p> 示例值：
     */
    @SerializedName("address")
    private ProfileSettingAddress address;

    // builder 开始
    public ProfileSettingDependent() {
    }

    public ProfileSettingDependent(Builder builder) {
        /**
         * 姓名
         * <p> 示例值：王大帅
         */
        this.legalName = builder.legalName;
        /**
         * 生日
         * <p> 示例值：2006-01-02
         */
        this.dateOfBirth = builder.dateOfBirth;
        /**
         * 关系，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "dependent" custom_api_name ="relationship_with_dependent"
         * <p> 示例值：parent
         */
        this.relationshipWithDependent = builder.relationshipWithDependent;
        /**
         * 性别，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "dependent" custom_api_name = "gender"
         * <p> 示例值：female
         */
        this.gender = builder.gender;
        /**
         * 电话
         * <p> 示例值：
         */
        this.phone = builder.phone;
        /**
         * 岗位
         * <p> 示例值：岗位
         */
        this.job = builder.job;
        /**
         * 出生证明
         * <p> 示例值：
         */
        this.childBirthCertificates = builder.childBirthCertificates;
        /**
         * 工作单位
         * <p> 示例值：飞书
         */
        this.employer = builder.employer;
        /**
         * 自定义字段
         * <p> 示例值：
         */
        this.customFields = builder.customFields;
        /**
         * 联系地址
         * <p> 示例值：
         */
        this.address = builder.address;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getLegalName() {
        return this.legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRelationshipWithDependent() {
        return this.relationshipWithDependent;
    }

    public void setRelationshipWithDependent(String relationshipWithDependent) {
        this.relationshipWithDependent = relationshipWithDependent;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ProfileSettingPhone getPhone() {
        return this.phone;
    }

    public void setPhone(ProfileSettingPhone phone) {
        this.phone = phone;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public ProfileSettingFile[] getChildBirthCertificates() {
        return this.childBirthCertificates;
    }

    public void setChildBirthCertificates(ProfileSettingFile[] childBirthCertificates) {
        this.childBirthCertificates = childBirthCertificates;
    }

    public String getEmployer() {
        return this.employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public ProfileSettingCustomField[] getCustomFields() {
        return this.customFields;
    }

    public void setCustomFields(ProfileSettingCustomField[] customFields) {
        this.customFields = customFields;
    }

    public ProfileSettingAddress getAddress() {
        return this.address;
    }

    public void setAddress(ProfileSettingAddress address) {
        this.address = address;
    }

    public static class Builder {
        /**
         * 姓名
         * <p> 示例值：王大帅
         */
        private String legalName;
        /**
         * 生日
         * <p> 示例值：2006-01-02
         */
        private String dateOfBirth;
        /**
         * 关系，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "dependent" custom_api_name ="relationship_with_dependent"
         * <p> 示例值：parent
         */
        private String relationshipWithDependent;
        /**
         * 性别，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "dependent" custom_api_name = "gender"
         * <p> 示例值：female
         */
        private String gender;
        /**
         * 电话
         * <p> 示例值：
         */
        private ProfileSettingPhone phone;
        /**
         * 岗位
         * <p> 示例值：岗位
         */
        private String job;
        /**
         * 出生证明
         * <p> 示例值：
         */
        private ProfileSettingFile[] childBirthCertificates;
        /**
         * 工作单位
         * <p> 示例值：飞书
         */
        private String employer;
        /**
         * 自定义字段
         * <p> 示例值：
         */
        private ProfileSettingCustomField[] customFields;
        /**
         * 联系地址
         * <p> 示例值：
         */
        private ProfileSettingAddress address;

        /**
         * 姓名
         * <p> 示例值：王大帅
         *
         * @param legalName
         * @return
         */
        public Builder legalName(String legalName) {
            this.legalName = legalName;
            return this;
        }


        /**
         * 生日
         * <p> 示例值：2006-01-02
         *
         * @param dateOfBirth
         * @return
         */
        public Builder dateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }


        /**
         * 关系，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "dependent" custom_api_name ="relationship_with_dependent"
         * <p> 示例值：parent
         *
         * @param relationshipWithDependent
         * @return
         */
        public Builder relationshipWithDependent(String relationshipWithDependent) {
            this.relationshipWithDependent = relationshipWithDependent;
            return this;
        }


        /**
         * 性别，枚举值。 可选项可通过【获取字段详情】接口查询，查询参数如下： object_api_name = "dependent" custom_api_name = "gender"
         * <p> 示例值：female
         *
         * @param gender
         * @return
         */
        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }


        /**
         * 电话
         * <p> 示例值：
         *
         * @param phone
         * @return
         */
        public Builder phone(ProfileSettingPhone phone) {
            this.phone = phone;
            return this;
        }


        /**
         * 岗位
         * <p> 示例值：岗位
         *
         * @param job
         * @return
         */
        public Builder job(String job) {
            this.job = job;
            return this;
        }


        /**
         * 出生证明
         * <p> 示例值：
         *
         * @param childBirthCertificates
         * @return
         */
        public Builder childBirthCertificates(ProfileSettingFile[] childBirthCertificates) {
            this.childBirthCertificates = childBirthCertificates;
            return this;
        }


        /**
         * 工作单位
         * <p> 示例值：飞书
         *
         * @param employer
         * @return
         */
        public Builder employer(String employer) {
            this.employer = employer;
            return this;
        }


        /**
         * 自定义字段
         * <p> 示例值：
         *
         * @param customFields
         * @return
         */
        public Builder customFields(ProfileSettingCustomField[] customFields) {
            this.customFields = customFields;
            return this;
        }


        /**
         * 联系地址
         * <p> 示例值：
         *
         * @param address
         * @return
         */
        public Builder address(ProfileSettingAddress address) {
            this.address = address;
            return this;
        }


        public ProfileSettingDependent build() {
            return new ProfileSettingDependent(this);
        }
    }
}
