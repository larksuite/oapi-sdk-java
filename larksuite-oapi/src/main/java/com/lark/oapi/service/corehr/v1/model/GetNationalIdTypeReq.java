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
import com.lark.oapi.core.annotation.Path;

public class GetNationalIdTypeReq {
    /**
     * 证件类型 ID
     * <p> 示例值：121515
     */
    @Path
    @SerializedName("national_id_type_id")
    private String nationalIdTypeId;

    // builder 开始
    public GetNationalIdTypeReq() {
    }

    public GetNationalIdTypeReq(Builder builder) {
        /**
         * 证件类型 ID
         * <p> 示例值：121515
         */
        this.nationalIdTypeId = builder.nationalIdTypeId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getNationalIdTypeId() {
        return this.nationalIdTypeId;
    }

    public void setNationalIdTypeId(String nationalIdTypeId) {
        this.nationalIdTypeId = nationalIdTypeId;
    }

    public static class Builder {

        private String nationalIdTypeId; // 证件类型 ID

        /**
         * 证件类型 ID
         * <p> 示例值：121515
         *
         * @param nationalIdTypeId
         * @return
         */
        public Builder nationalIdTypeId(String nationalIdTypeId) {
            this.nationalIdTypeId = nationalIdTypeId;
            return this;
        }

        public GetNationalIdTypeReq build() {
            return new GetNationalIdTypeReq(this);
        }
    }
}