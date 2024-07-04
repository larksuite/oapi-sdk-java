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

public class MessageCardI18nElements {

    @SerializedName("zh_cn")
    private MessageCardElement[] zhCn;
    @SerializedName("en_us")
    private MessageCardElement[] enUs;
    @SerializedName("ja_jp")
    private MessageCardElement[] jaJp;
    @SerializedName("zh_hk")
    private MessageCardElement[] zhHk;
    @SerializedName("zh_tw")
    private MessageCardElement[] zhTw;
    @SerializedName("id_id")
    private MessageCardElement[] idId;
    @SerializedName("vi_vn")
    private MessageCardElement[] viVn;
    @SerializedName("th_th")
    private MessageCardElement[] thTh;
    @SerializedName("pt_br")
    private MessageCardElement[] ptBr;
    @SerializedName("es_es")
    private MessageCardElement[] esEs;
    @SerializedName("ko_kr")
    private MessageCardElement[] koKr;
    @SerializedName("de_de")
    private MessageCardElement[] deDe;
    @SerializedName("fr_fr")
    private MessageCardElement[] frFr;
    @SerializedName("it_it")
    private MessageCardElement[] itIt;
    @SerializedName("ru_ru")
    private MessageCardElement[] ruRu;
    @SerializedName("ms_my")
    private MessageCardElement[] msMy;

    public MessageCardI18nElements(Builder builder) {
        this.zhCn = builder.zhCn;
        this.enUs = builder.enUs;
        this.jaJp = builder.jaJp;
        this.zhHk = builder.zhHk;
        this.zhTw = builder.zhTw;
        this.idId = builder.idId;
        this.viVn = builder.viVn;
        this.thTh = builder.thTh;
        this.ptBr = builder.ptBr;
        this.esEs = builder.esEs;
        this.koKr = builder.koKr;
        this.deDe = builder.deDe;
        this.frFr = builder.frFr;
        this.itIt = builder.itIt;
        this.ruRu = builder.ruRu;
        this.msMy = builder.msMy;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static void main(String[] ar) {
        MessageCardI18nElements.newBuilder()
                .zhCn(new MessageCardElement[]{new MessageCardEmbedButton()})
                .build();
    }

    public static class Builder {

        private MessageCardElement[] zhCn;
        private MessageCardElement[] enUs;
        private MessageCardElement[] jaJp;
        private MessageCardElement[] zhHk;
        private MessageCardElement[] zhTw;
        private MessageCardElement[] idId;
        private MessageCardElement[] viVn;
        private MessageCardElement[] thTh;
        private MessageCardElement[] ptBr;
        private MessageCardElement[] esEs;
        private MessageCardElement[] koKr;
        private MessageCardElement[] deDe;
        private MessageCardElement[] frFr;
        private MessageCardElement[] itIt;
        private MessageCardElement[] ruRu;
        private MessageCardElement[] msMy;

        public Builder zhCn(MessageCardElement[] zhCn) {
            this.zhCn = zhCn;
            return this;
        }

        public Builder enUs(MessageCardElement[] enUs) {
            this.enUs = enUs;
            return this;
        }

        public Builder jaJp(MessageCardElement[] jaJp) {
            this.jaJp = jaJp;
            return this;
        }

        public Builder zhHk(MessageCardElement[] zhHk) {
            this.zhHk = zhHk;
            return this;
        }

        public Builder zhTw(MessageCardElement[] zhTw) {
            this.zhTw = zhTw;
            return this;
        }

        public Builder idId(MessageCardElement[] idId) {
            this.idId = idId;
            return this;
        }

        public Builder viVn(MessageCardElement[] viVn) {
            this.viVn = viVn;
            return this;
        }

        public Builder thTh(MessageCardElement[] thTh) {
            this.thTh = thTh;
            return this;
        }

        public Builder ptBr(MessageCardElement[] ptBr) {
            this.ptBr = ptBr;
            return this;
        }

        public Builder esEs(MessageCardElement[] esEs) {
            this.esEs = esEs;
            return this;
        }

        public Builder koKr(MessageCardElement[] koKr) {
            this.koKr = koKr;
            return this;
        }

        public Builder deDe(MessageCardElement[] deDe) {
            this.deDe = deDe;
            return this;
        }

        public Builder frFr(MessageCardElement[] frFr) {
            this.frFr = frFr;
            return this;
        }

        public Builder itIt(MessageCardElement[] itIt) {
            this.itIt = itIt;
            return this;
        }

        public Builder ruRu(MessageCardElement[] ruRu) {
            this.ruRu = ruRu;
            return this;
        }

        public Builder msMy(MessageCardElement[] msMy) {
            this.msMy = msMy;
            return this;
        }

        public MessageCardI18nElements build() {
            return new MessageCardI18nElements(this);
        }
    }

}
