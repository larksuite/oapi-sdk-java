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

package com.lark.oapi.service.document_ai.v1.model;

import com.google.gson.annotations.SerializedName;

public class VehicleEntity {
    /**
     * 识别的字段种类
     * <p> 示例值：vehicle_type
     */
    @SerializedName("type")
    private String type;
    /**
     * 识别出字段的文本信息
     * <p> 示例值：小型普通客车
     */
    @SerializedName("value")
    private String value;

    // builder 开始
    public VehicleEntity() {
    }

    public VehicleEntity(Builder builder) {
        /**
         * 识别的字段种类
         * <p> 示例值：vehicle_type
         */
        this.type = builder.type;
        /**
         * 识别出字段的文本信息
         * <p> 示例值：小型普通客车
         */
        this.value = builder.value;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static class Builder {
        /**
         * 识别的字段种类
         * <p> 示例值：vehicle_type
         */
        private String type;
        /**
         * 识别出字段的文本信息
         * <p> 示例值：小型普通客车
         */
        private String value;

        /**
         * 识别的字段种类
         * <p> 示例值：vehicle_type
         *
         * @param type
         * @return
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * 识别的字段种类
         * <p> 示例值：vehicle_type
         *
         * @param type {@link com.lark.oapi.service.document_ai.v1.enums.VehicleEntityVehicleEntityTypeEnum}
         * @return
         */
        public Builder type(com.lark.oapi.service.document_ai.v1.enums.VehicleEntityVehicleEntityTypeEnum type) {
            this.type = type.getValue();
            return this;
        }


        /**
         * 识别出字段的文本信息
         * <p> 示例值：小型普通客车
         *
         * @param value
         * @return
         */
        public Builder value(String value) {
            this.value = value;
            return this;
        }


        public VehicleEntity build() {
            return new VehicleEntity(this);
        }
    }
}
