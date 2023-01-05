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

package com.lark.oapi.card.model;

import com.google.gson.annotations.SerializedName;

public class MessageCardPlainTextI18n {

    @SerializedName("zh_cn")
    private String zhCn;
    @SerializedName("en_us")
    private String enUs;
    @SerializedName("ja_jp")
    private String jaJp;

    public MessageCardPlainTextI18n(Builder builder) {
        this.enUs = builder.enUs;
        this.zhCn = builder.zhCn;
        this.jaJp = builder.jaJp;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getZhCn() {
        return zhCn;
    }

    public void setZhCn(String zhCn) {
        this.zhCn = zhCn;
    }

    public String getEnUs() {
        return enUs;
    }

    public void setEnUs(String enUs) {
        this.enUs = enUs;
    }

    public String getJaJp() {
        return jaJp;
    }

    public void setJaJp(String jaJp) {
        this.jaJp = jaJp;
    }

    public static class Builder {

        private String zhCn;
        private String enUs;
        private String jaJp;

        public Builder zhCn(String zhCn) {
            this.zhCn = zhCn;
            return this;
        }

        public Builder enUs(String enUs) {
            this.enUs = enUs;
            return this;
        }

        public Builder jaJp(String jaJp) {
            this.jaJp = jaJp;
            return this;
        }

        public MessageCardPlainTextI18n build() {
            return new MessageCardPlainTextI18n(this);
        }
    }
}
