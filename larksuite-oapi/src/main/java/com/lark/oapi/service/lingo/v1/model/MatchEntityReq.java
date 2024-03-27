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

package com.lark.oapi.service.lingo.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Query;

public class MatchEntityReq {
    /**
     * 词库ID
     * <p> 示例值：7202510112396640276
     */
    @Query
    @SerializedName("repo_id")
    private String repoId;
    @Body
    private MatchEntityReqBody body;

    // builder 开始
    public MatchEntityReq() {
    }

    public MatchEntityReq(Builder builder) {
        /**
         * 词库ID
         * <p> 示例值：7202510112396640276
         */
        this.repoId = builder.repoId;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getRepoId() {
        return this.repoId;
    }

    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    public MatchEntityReqBody getMatchEntityReqBody() {
        return this.body;
    }

    public void setMatchEntityReqBody(MatchEntityReqBody body) {
        this.body = body;
    }

    public static class Builder {
        private String repoId; // 词库ID
        private MatchEntityReqBody body;

        /**
         * 词库ID
         * <p> 示例值：7202510112396640276
         *
         * @param repoId
         * @return
         */
        public Builder repoId(String repoId) {
            this.repoId = repoId;
            return this;
        }

        public MatchEntityReqBody getMatchEntityReqBody() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder matchEntityReqBody(MatchEntityReqBody body) {
            this.body = body;
            return this;
        }

        public MatchEntityReq build() {
            return new MatchEntityReq(this);
        }
    }
}
