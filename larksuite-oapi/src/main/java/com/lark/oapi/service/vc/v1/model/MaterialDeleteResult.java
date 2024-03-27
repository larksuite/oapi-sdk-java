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

package com.lark.oapi.service.vc.v1.model;

import com.google.gson.annotations.SerializedName;

public class MaterialDeleteResult {
    /**
     * 文件上传drive后的token
     * <p> 示例值：u8ajdjadau8wqu
     */
    @SerializedName("file_token")
    private String fileToken;
    /**
     * 删除结果
     * <p> 示例值：1
     */
    @SerializedName("result")
    private Integer result;

    // builder 开始
    public MaterialDeleteResult() {
    }

    public MaterialDeleteResult(Builder builder) {
        /**
         * 文件上传drive后的token
         * <p> 示例值：u8ajdjadau8wqu
         */
        this.fileToken = builder.fileToken;
        /**
         * 删除结果
         * <p> 示例值：1
         */
        this.result = builder.result;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getFileToken() {
        return this.fileToken;
    }

    public void setFileToken(String fileToken) {
        this.fileToken = fileToken;
    }

    public Integer getResult() {
        return this.result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public static class Builder {
        /**
         * 文件上传drive后的token
         * <p> 示例值：u8ajdjadau8wqu
         */
        private String fileToken;
        /**
         * 删除结果
         * <p> 示例值：1
         */
        private Integer result;

        /**
         * 文件上传drive后的token
         * <p> 示例值：u8ajdjadau8wqu
         *
         * @param fileToken
         * @return
         */
        public Builder fileToken(String fileToken) {
            this.fileToken = fileToken;
            return this;
        }


        /**
         * 删除结果
         * <p> 示例值：1
         *
         * @param result
         * @return
         */
        public Builder result(Integer result) {
            this.result = result;
            return this;
        }

        /**
         * 删除结果
         * <p> 示例值：1
         *
         * @param result {@link com.lark.oapi.service.vc.v1.enums.MaterialDeleteResultDeleteResultEnum}
         * @return
         */
        public Builder result(com.lark.oapi.service.vc.v1.enums.MaterialDeleteResultDeleteResultEnum result) {
            this.result = result.getValue();
            return this;
        }


        public MaterialDeleteResult build() {
            return new MaterialDeleteResult(this);
        }
    }
}
