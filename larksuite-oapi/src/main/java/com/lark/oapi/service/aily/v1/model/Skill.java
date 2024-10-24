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

package com.lark.oapi.service.aily.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.aily.v1.enums.*;
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

public class Skill {
    /**
     * 技能 ID
     * <p> 示例值：skill_6cc6166178ca
     */
    @SerializedName("id")
    private String id;
    /**
     * 技能名称
     * <p> 示例值：数据分析和问答
     */
    @SerializedName("label")
    private String label;
    /**
     * 技能描述
     * <p> 示例值：理解用户提出的问题，对当前助手已经配置的数据资产进行知识搜索、数据分析、文档阅读，总结并返回答案。
     */
    @SerializedName("description")
    private String description;
    /**
     * 用户提问示例
     * <p> 示例值：
     */
    @SerializedName("samples")
    private String[] samples;
    /**
     * 技能入参定义
     * <p> 示例值：[{"name":"custom_s","type":"String","required":true,"defaultValue":"qwert","description":"自定义字符串"},{"name":"custom_i","type":"Integer","required":true,"defaultValue":null,"description":""},{"name":"custom_b","type":"Boolean","required":true,"defaultValue":true,"description":""},{"name":"custom_f","type":"Float","required":true,"defaultValue":2.1,"description":""}]
     */
    @SerializedName("input_schema")
    private String inputSchema;
    /**
     * 技能出参定义
     * <p> 示例值：[{"name":"input","type":"String","required":false,"defaultValue":null},{"name":"custom","type":"Boolean","required":false,"defaultValue":null}]
     */
    @SerializedName("output_schema")
    private String outputSchema;

    // builder 开始
    public Skill() {
    }

    public Skill(Builder builder) {
        /**
         * 技能 ID
         * <p> 示例值：skill_6cc6166178ca
         */
        this.id = builder.id;
        /**
         * 技能名称
         * <p> 示例值：数据分析和问答
         */
        this.label = builder.label;
        /**
         * 技能描述
         * <p> 示例值：理解用户提出的问题，对当前助手已经配置的数据资产进行知识搜索、数据分析、文档阅读，总结并返回答案。
         */
        this.description = builder.description;
        /**
         * 用户提问示例
         * <p> 示例值：
         */
        this.samples = builder.samples;
        /**
         * 技能入参定义
         * <p> 示例值：[{"name":"custom_s","type":"String","required":true,"defaultValue":"qwert","description":"自定义字符串"},{"name":"custom_i","type":"Integer","required":true,"defaultValue":null,"description":""},{"name":"custom_b","type":"Boolean","required":true,"defaultValue":true,"description":""},{"name":"custom_f","type":"Float","required":true,"defaultValue":2.1,"description":""}]
         */
        this.inputSchema = builder.inputSchema;
        /**
         * 技能出参定义
         * <p> 示例值：[{"name":"input","type":"String","required":false,"defaultValue":null},{"name":"custom","type":"Boolean","required":false,"defaultValue":null}]
         */
        this.outputSchema = builder.outputSchema;
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

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getSamples() {
        return this.samples;
    }

    public void setSamples(String[] samples) {
        this.samples = samples;
    }

    public String getInputSchema() {
        return this.inputSchema;
    }

    public void setInputSchema(String inputSchema) {
        this.inputSchema = inputSchema;
    }

    public String getOutputSchema() {
        return this.outputSchema;
    }

    public void setOutputSchema(String outputSchema) {
        this.outputSchema = outputSchema;
    }

    public static class Builder {
        /**
         * 技能 ID
         * <p> 示例值：skill_6cc6166178ca
         */
        private String id;
        /**
         * 技能名称
         * <p> 示例值：数据分析和问答
         */
        private String label;
        /**
         * 技能描述
         * <p> 示例值：理解用户提出的问题，对当前助手已经配置的数据资产进行知识搜索、数据分析、文档阅读，总结并返回答案。
         */
        private String description;
        /**
         * 用户提问示例
         * <p> 示例值：
         */
        private String[] samples;
        /**
         * 技能入参定义
         * <p> 示例值：[{"name":"custom_s","type":"String","required":true,"defaultValue":"qwert","description":"自定义字符串"},{"name":"custom_i","type":"Integer","required":true,"defaultValue":null,"description":""},{"name":"custom_b","type":"Boolean","required":true,"defaultValue":true,"description":""},{"name":"custom_f","type":"Float","required":true,"defaultValue":2.1,"description":""}]
         */
        private String inputSchema;
        /**
         * 技能出参定义
         * <p> 示例值：[{"name":"input","type":"String","required":false,"defaultValue":null},{"name":"custom","type":"Boolean","required":false,"defaultValue":null}]
         */
        private String outputSchema;

        /**
         * 技能 ID
         * <p> 示例值：skill_6cc6166178ca
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 技能名称
         * <p> 示例值：数据分析和问答
         *
         * @param label
         * @return
         */
        public Builder label(String label) {
            this.label = label;
            return this;
        }


        /**
         * 技能描述
         * <p> 示例值：理解用户提出的问题，对当前助手已经配置的数据资产进行知识搜索、数据分析、文档阅读，总结并返回答案。
         *
         * @param description
         * @return
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }


        /**
         * 用户提问示例
         * <p> 示例值：
         *
         * @param samples
         * @return
         */
        public Builder samples(String[] samples) {
            this.samples = samples;
            return this;
        }


        /**
         * 技能入参定义
         * <p> 示例值：[{"name":"custom_s","type":"String","required":true,"defaultValue":"qwert","description":"自定义字符串"},{"name":"custom_i","type":"Integer","required":true,"defaultValue":null,"description":""},{"name":"custom_b","type":"Boolean","required":true,"defaultValue":true,"description":""},{"name":"custom_f","type":"Float","required":true,"defaultValue":2.1,"description":""}]
         *
         * @param inputSchema
         * @return
         */
        public Builder inputSchema(String inputSchema) {
            this.inputSchema = inputSchema;
            return this;
        }


        /**
         * 技能出参定义
         * <p> 示例值：[{"name":"input","type":"String","required":false,"defaultValue":null},{"name":"custom","type":"Boolean","required":false,"defaultValue":null}]
         *
         * @param outputSchema
         * @return
         */
        public Builder outputSchema(String outputSchema) {
            this.outputSchema = outputSchema;
            return this;
        }


        public Skill build() {
            return new Skill(this);
        }
    }
}
