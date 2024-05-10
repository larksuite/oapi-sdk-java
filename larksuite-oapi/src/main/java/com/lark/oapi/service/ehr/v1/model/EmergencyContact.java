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

package com.lark.oapi.service.ehr.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.ehr.v1.enums.*;
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

public class EmergencyContact {
    /**
     * 紧急联系人姓名
     * <p> 示例值：张三
     */
    @SerializedName("name")
    private String name;
    /**
     * 与紧急联系人的关系
     * <p> 示例值：1
     */
    @SerializedName("relationship")
    private Integer relationship;
    /**
     * 手机号
     * <p> 示例值：(+86) 13812345678
     */
    @SerializedName("mobile")
    private String mobile;

    // builder 开始
    public EmergencyContact() {
    }

    public EmergencyContact(Builder builder) {
        /**
         * 紧急联系人姓名
         * <p> 示例值：张三
         */
        this.name = builder.name;
        /**
         * 与紧急联系人的关系
         * <p> 示例值：1
         */
        this.relationship = builder.relationship;
        /**
         * 手机号
         * <p> 示例值：(+86) 13812345678
         */
        this.mobile = builder.mobile;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRelationship() {
        return this.relationship;
    }

    public void setRelationship(Integer relationship) {
        this.relationship = relationship;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public static class Builder {
        /**
         * 紧急联系人姓名
         * <p> 示例值：张三
         */
        private String name;
        /**
         * 与紧急联系人的关系
         * <p> 示例值：1
         */
        private Integer relationship;
        /**
         * 手机号
         * <p> 示例值：(+86) 13812345678
         */
        private String mobile;

        /**
         * 紧急联系人姓名
         * <p> 示例值：张三
         *
         * @param name
         * @return
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }


        /**
         * 与紧急联系人的关系
         * <p> 示例值：1
         *
         * @param relationship
         * @return
         */
        public Builder relationship(Integer relationship) {
            this.relationship = relationship;
            return this;
        }

        /**
         * 与紧急联系人的关系
         * <p> 示例值：1
         *
         * @param relationship {@link com.lark.oapi.service.ehr.v1.enums.EmergencyContactRelationshipEnum}
         * @return
         */
        public Builder relationship(com.lark.oapi.service.ehr.v1.enums.EmergencyContactRelationshipEnum relationship) {
            this.relationship = relationship.getValue();
            return this;
        }


        /**
         * 手机号
         * <p> 示例值：(+86) 13812345678
         *
         * @param mobile
         * @return
         */
        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }


        public EmergencyContact build() {
            return new EmergencyContact(this);
        }
    }
}
