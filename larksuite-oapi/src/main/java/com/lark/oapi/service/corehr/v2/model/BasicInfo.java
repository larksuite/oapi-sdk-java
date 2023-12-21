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

public class BasicInfo {
    /**
     * 描述
     * <p> 示例值：
     */
    @SerializedName("name")
    private Name name;
    /**
     * 手机号
     * <p> 示例值：31123127
     */
    @SerializedName("phone_number")
    private String phoneNumber;
    /**
     * 区号
     * <p> 示例值：86_china
     */
    @SerializedName("international_area_code")
    private String internationalAreaCode;
    /**
     * 个人邮箱
     * <p> 示例值：xx@xx.com
     */
    @SerializedName("email")
    private String email;
    /**
     * 生日
     * <p> 示例值：2011-99-99
     */
    @SerializedName("date_of_birth")
    private String dateOfBirth;
    /**
     * 证件号
     * <p> 示例值：31123127
     */
    @SerializedName("personal_id_number")
    private String personalIdNumber;
    /**
     * 参加工作日期
     * <p> 示例值：2100-09-09
     */
    @SerializedName("date_entered_workforce")
    private String dateEnteredWorkforce;
    /**
     * 性别
     * <p> 示例值：male
     */
    @SerializedName("gender_id")
    private String genderId;
    /**
     * 国籍
     * <p> 示例值：6862995757234914824
     */
    @SerializedName("nationality_id")
    private String nationalityId;
    /**
     * 家庭地址
     * <p> 示例值：home addr
     */
    @SerializedName("home_address")
    private String homeAddress;
    /**
     * 人员编号
     * <p> 示例值：6862995757234914824
     */
    @SerializedName("worker_id")
    private String workerId;

    // builder 开始
    public BasicInfo() {
    }

    public BasicInfo(Builder builder) {
        /**
         * 描述
         * <p> 示例值：
         */
        this.name = builder.name;
        /**
         * 手机号
         * <p> 示例值：31123127
         */
        this.phoneNumber = builder.phoneNumber;
        /**
         * 区号
         * <p> 示例值：86_china
         */
        this.internationalAreaCode = builder.internationalAreaCode;
        /**
         * 个人邮箱
         * <p> 示例值：xx@xx.com
         */
        this.email = builder.email;
        /**
         * 生日
         * <p> 示例值：2011-99-99
         */
        this.dateOfBirth = builder.dateOfBirth;
        /**
         * 证件号
         * <p> 示例值：31123127
         */
        this.personalIdNumber = builder.personalIdNumber;
        /**
         * 参加工作日期
         * <p> 示例值：2100-09-09
         */
        this.dateEnteredWorkforce = builder.dateEnteredWorkforce;
        /**
         * 性别
         * <p> 示例值：male
         */
        this.genderId = builder.genderId;
        /**
         * 国籍
         * <p> 示例值：6862995757234914824
         */
        this.nationalityId = builder.nationalityId;
        /**
         * 家庭地址
         * <p> 示例值：home addr
         */
        this.homeAddress = builder.homeAddress;
        /**
         * 人员编号
         * <p> 示例值：6862995757234914824
         */
        this.workerId = builder.workerId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Name getName() {
        return this.name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInternationalAreaCode() {
        return this.internationalAreaCode;
    }

    public void setInternationalAreaCode(String internationalAreaCode) {
        this.internationalAreaCode = internationalAreaCode;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPersonalIdNumber() {
        return this.personalIdNumber;
    }

    public void setPersonalIdNumber(String personalIdNumber) {
        this.personalIdNumber = personalIdNumber;
    }

    public String getDateEnteredWorkforce() {
        return this.dateEnteredWorkforce;
    }

    public void setDateEnteredWorkforce(String dateEnteredWorkforce) {
        this.dateEnteredWorkforce = dateEnteredWorkforce;
    }

    public String getGenderId() {
        return this.genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getNationalityId() {
        return this.nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getHomeAddress() {
        return this.homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getWorkerId() {
        return this.workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public static class Builder {
        /**
         * 描述
         * <p> 示例值：
         */
        private Name name;
        /**
         * 手机号
         * <p> 示例值：31123127
         */
        private String phoneNumber;
        /**
         * 区号
         * <p> 示例值：86_china
         */
        private String internationalAreaCode;
        /**
         * 个人邮箱
         * <p> 示例值：xx@xx.com
         */
        private String email;
        /**
         * 生日
         * <p> 示例值：2011-99-99
         */
        private String dateOfBirth;
        /**
         * 证件号
         * <p> 示例值：31123127
         */
        private String personalIdNumber;
        /**
         * 参加工作日期
         * <p> 示例值：2100-09-09
         */
        private String dateEnteredWorkforce;
        /**
         * 性别
         * <p> 示例值：male
         */
        private String genderId;
        /**
         * 国籍
         * <p> 示例值：6862995757234914824
         */
        private String nationalityId;
        /**
         * 家庭地址
         * <p> 示例值：home addr
         */
        private String homeAddress;
        /**
         * 人员编号
         * <p> 示例值：6862995757234914824
         */
        private String workerId;

        /**
         * 描述
         * <p> 示例值：
         *
         * @param name
         * @return
         */
        public Builder name(Name name) {
            this.name = name;
            return this;
        }


        /**
         * 手机号
         * <p> 示例值：31123127
         *
         * @param phoneNumber
         * @return
         */
        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }


        /**
         * 区号
         * <p> 示例值：86_china
         *
         * @param internationalAreaCode
         * @return
         */
        public Builder internationalAreaCode(String internationalAreaCode) {
            this.internationalAreaCode = internationalAreaCode;
            return this;
        }


        /**
         * 个人邮箱
         * <p> 示例值：xx@xx.com
         *
         * @param email
         * @return
         */
        public Builder email(String email) {
            this.email = email;
            return this;
        }


        /**
         * 生日
         * <p> 示例值：2011-99-99
         *
         * @param dateOfBirth
         * @return
         */
        public Builder dateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }


        /**
         * 证件号
         * <p> 示例值：31123127
         *
         * @param personalIdNumber
         * @return
         */
        public Builder personalIdNumber(String personalIdNumber) {
            this.personalIdNumber = personalIdNumber;
            return this;
        }


        /**
         * 参加工作日期
         * <p> 示例值：2100-09-09
         *
         * @param dateEnteredWorkforce
         * @return
         */
        public Builder dateEnteredWorkforce(String dateEnteredWorkforce) {
            this.dateEnteredWorkforce = dateEnteredWorkforce;
            return this;
        }


        /**
         * 性别
         * <p> 示例值：male
         *
         * @param genderId
         * @return
         */
        public Builder genderId(String genderId) {
            this.genderId = genderId;
            return this;
        }


        /**
         * 国籍
         * <p> 示例值：6862995757234914824
         *
         * @param nationalityId
         * @return
         */
        public Builder nationalityId(String nationalityId) {
            this.nationalityId = nationalityId;
            return this;
        }


        /**
         * 家庭地址
         * <p> 示例值：home addr
         *
         * @param homeAddress
         * @return
         */
        public Builder homeAddress(String homeAddress) {
            this.homeAddress = homeAddress;
            return this;
        }


        /**
         * 人员编号
         * <p> 示例值：6862995757234914824
         *
         * @param workerId
         * @return
         */
        public Builder workerId(String workerId) {
            this.workerId = workerId;
            return this;
        }


        public BasicInfo build() {
            return new BasicInfo(this);
        }
    }
}