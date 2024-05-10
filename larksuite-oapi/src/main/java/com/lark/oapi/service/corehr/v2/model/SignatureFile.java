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

public class SignatureFile {
    /**
     * 电子签文件ID
     * <p> 示例值：7147527056140813828
     */
    @SerializedName("signature_file_id")
    private String signatureFileId;
    /**
     * 名称
     * <p> 示例值：
     */
    @SerializedName("names")
    private I18n[] names;
    /**
     * 创建时间
     * <p> 示例值：2023-01-01 00:00:00
     */
    @SerializedName("create_time")
    private String createTime;
    /**
     * 更新时间
     * <p> 示例值：2023-01-01 00:00:00
     */
    @SerializedName("update_time")
    private String updateTime;
    /**
     * 雇员 id
     * <p> 示例值：ou_a294793e8fa21529f2a60e3e9de45520
     */
    @SerializedName("employment_id")
    private String employmentId;
    /**
     * 电子签文件状态，枚举值可通过文档【飞书人事枚举常量】电子签文件状态（signature_file_state）枚举定义部分获得
     * <p> 示例值：
     */
    @SerializedName("signature_file_state")
    private Enum signatureFileState;
    /**
     * 供应商侧的合同编号，作为幂等key
     * <p> 示例值：48793beea04f4e2583d50732e481d507
     */
    @SerializedName("contract_code")
    private String contractCode;

    // builder 开始
    public SignatureFile() {
    }

    public SignatureFile(Builder builder) {
        /**
         * 电子签文件ID
         * <p> 示例值：7147527056140813828
         */
        this.signatureFileId = builder.signatureFileId;
        /**
         * 名称
         * <p> 示例值：
         */
        this.names = builder.names;
        /**
         * 创建时间
         * <p> 示例值：2023-01-01 00:00:00
         */
        this.createTime = builder.createTime;
        /**
         * 更新时间
         * <p> 示例值：2023-01-01 00:00:00
         */
        this.updateTime = builder.updateTime;
        /**
         * 雇员 id
         * <p> 示例值：ou_a294793e8fa21529f2a60e3e9de45520
         */
        this.employmentId = builder.employmentId;
        /**
         * 电子签文件状态，枚举值可通过文档【飞书人事枚举常量】电子签文件状态（signature_file_state）枚举定义部分获得
         * <p> 示例值：
         */
        this.signatureFileState = builder.signatureFileState;
        /**
         * 供应商侧的合同编号，作为幂等key
         * <p> 示例值：48793beea04f4e2583d50732e481d507
         */
        this.contractCode = builder.contractCode;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getSignatureFileId() {
        return this.signatureFileId;
    }

    public void setSignatureFileId(String signatureFileId) {
        this.signatureFileId = signatureFileId;
    }

    public I18n[] getNames() {
        return this.names;
    }

    public void setNames(I18n[] names) {
        this.names = names;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getEmploymentId() {
        return this.employmentId;
    }

    public void setEmploymentId(String employmentId) {
        this.employmentId = employmentId;
    }

    public Enum getSignatureFileState() {
        return this.signatureFileState;
    }

    public void setSignatureFileState(Enum signatureFileState) {
        this.signatureFileState = signatureFileState;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public static class Builder {
        /**
         * 电子签文件ID
         * <p> 示例值：7147527056140813828
         */
        private String signatureFileId;
        /**
         * 名称
         * <p> 示例值：
         */
        private I18n[] names;
        /**
         * 创建时间
         * <p> 示例值：2023-01-01 00:00:00
         */
        private String createTime;
        /**
         * 更新时间
         * <p> 示例值：2023-01-01 00:00:00
         */
        private String updateTime;
        /**
         * 雇员 id
         * <p> 示例值：ou_a294793e8fa21529f2a60e3e9de45520
         */
        private String employmentId;
        /**
         * 电子签文件状态，枚举值可通过文档【飞书人事枚举常量】电子签文件状态（signature_file_state）枚举定义部分获得
         * <p> 示例值：
         */
        private Enum signatureFileState;
        /**
         * 供应商侧的合同编号，作为幂等key
         * <p> 示例值：48793beea04f4e2583d50732e481d507
         */
        private String contractCode;

        /**
         * 电子签文件ID
         * <p> 示例值：7147527056140813828
         *
         * @param signatureFileId
         * @return
         */
        public Builder signatureFileId(String signatureFileId) {
            this.signatureFileId = signatureFileId;
            return this;
        }


        /**
         * 名称
         * <p> 示例值：
         *
         * @param names
         * @return
         */
        public Builder names(I18n[] names) {
            this.names = names;
            return this;
        }


        /**
         * 创建时间
         * <p> 示例值：2023-01-01 00:00:00
         *
         * @param createTime
         * @return
         */
        public Builder createTime(String createTime) {
            this.createTime = createTime;
            return this;
        }


        /**
         * 更新时间
         * <p> 示例值：2023-01-01 00:00:00
         *
         * @param updateTime
         * @return
         */
        public Builder updateTime(String updateTime) {
            this.updateTime = updateTime;
            return this;
        }


        /**
         * 雇员 id
         * <p> 示例值：ou_a294793e8fa21529f2a60e3e9de45520
         *
         * @param employmentId
         * @return
         */
        public Builder employmentId(String employmentId) {
            this.employmentId = employmentId;
            return this;
        }


        /**
         * 电子签文件状态，枚举值可通过文档【飞书人事枚举常量】电子签文件状态（signature_file_state）枚举定义部分获得
         * <p> 示例值：
         *
         * @param signatureFileState
         * @return
         */
        public Builder signatureFileState(Enum signatureFileState) {
            this.signatureFileState = signatureFileState;
            return this;
        }


        /**
         * 供应商侧的合同编号，作为幂等key
         * <p> 示例值：48793beea04f4e2583d50732e481d507
         *
         * @param contractCode
         * @return
         */
        public Builder contractCode(String contractCode) {
            this.contractCode = contractCode;
            return this;
        }


        public SignatureFile build() {
            return new SignatureFile(this);
        }
    }
}
