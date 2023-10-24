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

public class MyAiAvPluginPresentInfo {
    /**
     * present type
     * <p> 示例值：template_card
     */
    @SerializedName("type")
    private String type;
    /**
     * card template id
     * <p> 示例值：1232323232
     */
    @SerializedName("card_template_id")
    private String cardTemplateId;
    /**
     * body
     * <p> 示例值：text message
     */
    @SerializedName("body")
    private String body;
    /**
     * <p> 示例值：
     */
    @SerializedName("card_varibales")
    private MyAiAvPluginCardVaribales cardVaribales;
    /**
     * callback info
     * <p> 示例值：callback info
     */
    @SerializedName("callback_info")
    private String callbackInfo;

    // builder 开始
    public MyAiAvPluginPresentInfo() {
    }

    public MyAiAvPluginPresentInfo(Builder builder) {
        /**
         * present type
         * <p> 示例值：template_card
         */
        this.type = builder.type;
        /**
         * card template id
         * <p> 示例值：1232323232
         */
        this.cardTemplateId = builder.cardTemplateId;
        /**
         * body
         * <p> 示例值：text message
         */
        this.body = builder.body;
        /**
         *
         * <p> 示例值：
         */
        this.cardVaribales = builder.cardVaribales;
        /**
         * callback info
         * <p> 示例值：callback info
         */
        this.callbackInfo = builder.callbackInfo;
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

    public String getCardTemplateId() {
        return this.cardTemplateId;
    }

    public void setCardTemplateId(String cardTemplateId) {
        this.cardTemplateId = cardTemplateId;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public MyAiAvPluginCardVaribales getCardVaribales() {
        return this.cardVaribales;
    }

    public void setCardVaribales(MyAiAvPluginCardVaribales cardVaribales) {
        this.cardVaribales = cardVaribales;
    }

    public String getCallbackInfo() {
        return this.callbackInfo;
    }

    public void setCallbackInfo(String callbackInfo) {
        this.callbackInfo = callbackInfo;
    }

    public static class Builder {
        /**
         * present type
         * <p> 示例值：template_card
         */
        private String type;
        /**
         * card template id
         * <p> 示例值：1232323232
         */
        private String cardTemplateId;
        /**
         * body
         * <p> 示例值：text message
         */
        private String body;
        /**
         * <p> 示例值：
         */
        private MyAiAvPluginCardVaribales cardVaribales;
        /**
         * callback info
         * <p> 示例值：callback info
         */
        private String callbackInfo;

        /**
         * present type
         * <p> 示例值：template_card
         *
         * @param type
         * @return
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }


        /**
         * card template id
         * <p> 示例值：1232323232
         *
         * @param cardTemplateId
         * @return
         */
        public Builder cardTemplateId(String cardTemplateId) {
            this.cardTemplateId = cardTemplateId;
            return this;
        }


        /**
         * body
         * <p> 示例值：text message
         *
         * @param body
         * @return
         */
        public Builder body(String body) {
            this.body = body;
            return this;
        }


        /**
         * <p> 示例值：
         *
         * @param cardVaribales
         * @return
         */
        public Builder cardVaribales(MyAiAvPluginCardVaribales cardVaribales) {
            this.cardVaribales = cardVaribales;
            return this;
        }


        /**
         * callback info
         * <p> 示例值：callback info
         *
         * @param callbackInfo
         * @return
         */
        public Builder callbackInfo(String callbackInfo) {
            this.callbackInfo = callbackInfo;
            return this;
        }


        public MyAiAvPluginPresentInfo build() {
            return new MyAiAvPluginPresentInfo(this);
        }
    }
}
