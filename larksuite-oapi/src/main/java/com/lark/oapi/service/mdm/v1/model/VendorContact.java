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

package com.lark.oapi.service.mdm.v1.model;

import com.google.gson.annotations.SerializedName;

public class VendorContact {
    /**
     * 交易方联系人id
     * <p> 示例值：1433488091906793474
     */
    @SerializedName("id")
    private String id;
    /**
     * 姓名
     * <p> 示例值：张三
     */
    @SerializedName("name")
    private String name;
    /**
     * 职位
     * <p> 示例值：董事长
     */
    @SerializedName("position")
    private String position;
    /**
     * 邮箱
     * <p> 示例值：haha@xxx.com
     */
    @SerializedName("email")
    private String email;
    /**
     * 手机号
     * <p> 示例值：13333323333
     */
    @SerializedName("phone")
    private String phone;
    /**
     * 备注
     * <p> 示例值：备注
     */
    @SerializedName("remark")
    private String remark;
    /**
     * 扩展字段相关信息列表
     * <p> 示例值：
     */
    @SerializedName("extend_info")
    private ExtendField[] extendInfo;

    // builder 开始
    public VendorContact() {
    }

    public VendorContact(Builder builder) {
        /**
         * 交易方联系人id
         * <p> 示例值：1433488091906793474
         */
        this.id = builder.id;
        /**
         * 姓名
         * <p> 示例值：张三
         */
        this.name = builder.name;
        /**
         * 职位
         * <p> 示例值：董事长
         */
        this.position = builder.position;
        /**
         * 邮箱
         * <p> 示例值：haha@xxx.com
         */
        this.email = builder.email;
        /**
         * 手机号
         * <p> 示例值：13333323333
         */
        this.phone = builder.phone;
        /**
         * 备注
         * <p> 示例值：备注
         */
        this.remark = builder.remark;
        /**
         * 扩展字段相关信息列表
         * <p> 示例值：
         */
        this.extendInfo = builder.extendInfo;
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

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public ExtendField[] getExtendInfo() {
        return this.extendInfo;
    }

    public void setExtendInfo(ExtendField[] extendInfo) {
        this.extendInfo = extendInfo;
    }

    public static class Builder {
        /**
         * 交易方联系人id
         * <p> 示例值：1433488091906793474
         */
        private String id;
        /**
         * 姓名
         * <p> 示例值：张三
         */
        private String name;
        /**
         * 职位
         * <p> 示例值：董事长
         */
        private String position;
        /**
         * 邮箱
         * <p> 示例值：haha@xxx.com
         */
        private String email;
        /**
         * 手机号
         * <p> 示例值：13333323333
         */
        private String phone;
        /**
         * 备注
         * <p> 示例值：备注
         */
        private String remark;
        /**
         * 扩展字段相关信息列表
         * <p> 示例值：
         */
        private ExtendField[] extendInfo;

        /**
         * 交易方联系人id
         * <p> 示例值：1433488091906793474
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 姓名
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
         * 职位
         * <p> 示例值：董事长
         *
         * @param position
         * @return
         */
        public Builder position(String position) {
            this.position = position;
            return this;
        }


        /**
         * 邮箱
         * <p> 示例值：haha@xxx.com
         *
         * @param email
         * @return
         */
        public Builder email(String email) {
            this.email = email;
            return this;
        }


        /**
         * 手机号
         * <p> 示例值：13333323333
         *
         * @param phone
         * @return
         */
        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }


        /**
         * 备注
         * <p> 示例值：备注
         *
         * @param remark
         * @return
         */
        public Builder remark(String remark) {
            this.remark = remark;
            return this;
        }


        /**
         * 扩展字段相关信息列表
         * <p> 示例值：
         *
         * @param extendInfo
         * @return
         */
        public Builder extendInfo(ExtendField[] extendInfo) {
            this.extendInfo = extendInfo;
            return this;
        }


        public VendorContact build() {
            return new VendorContact(this);
        }
    }
}
