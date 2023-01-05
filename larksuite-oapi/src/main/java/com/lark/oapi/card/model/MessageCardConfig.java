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

public class MessageCardConfig {

    @SerializedName("enable_forward")
    private Boolean enableForward;
    @SerializedName("update_multi")
    private Boolean updateMulti;
    @SerializedName("wide_screen_mode")
    private Boolean wideScreenMode;

    public MessageCardConfig(Builder builder) {
        this.enableForward = builder.enableForward;
        this.updateMulti = builder.updateMulti;
        this.wideScreenMode = builder.wideScreenMode;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Boolean getEnableForward() {
        return enableForward;
    }

    public void setEnableForward(Boolean enableForward) {
        this.enableForward = enableForward;
    }

    public Boolean getUpdateMulti() {
        return updateMulti;
    }

    public void setUpdateMulti(Boolean updateMulti) {
        this.updateMulti = updateMulti;
    }

    public Boolean getWideScreenMode() {
        return wideScreenMode;
    }

    public void setWideScreenMode(Boolean wideScreenMode) {
        this.wideScreenMode = wideScreenMode;
    }

    public static class Builder {

        private Boolean enableForward;
        private Boolean updateMulti;
        private Boolean wideScreenMode;

        public Builder enableForward(Boolean enableForward) {
            this.enableForward = enableForward;
            return this;
        }

        public Builder updateMulti(Boolean updateMulti) {
            this.updateMulti = updateMulti;
            return this;
        }

        public Builder wideScreenMode(Boolean wideScreenMode) {
            this.wideScreenMode = wideScreenMode;
            return this;
        }

        public MessageCardConfig build() {
            return new MessageCardConfig(this);
        }

    }
}
