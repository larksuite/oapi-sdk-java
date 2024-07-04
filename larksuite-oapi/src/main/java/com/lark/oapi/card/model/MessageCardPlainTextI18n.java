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
    @SerializedName("zh_hk")
    private String zhHk;
    @SerializedName("zh_tw")
    private String zhTw;
    @SerializedName("id_id")
    private String idId;
    @SerializedName("vi_vn")
    private String viVn;
    @SerializedName("th_th")
    private String thTh;
    @SerializedName("pt_br")
    private String ptBr;
    @SerializedName("es_es")
    private String esEs;
    @SerializedName("ko_kr")
    private String koKr;
    @SerializedName("de_de")
    private String deDe;
    @SerializedName("fr_fr")
    private String frFr;
    @SerializedName("it_it")
    private String itIt;
    @SerializedName("ru_ru")
    private String ruRu;
    @SerializedName("ms_my")
    private String msMy;

    public MessageCardPlainTextI18n(Builder builder) {
        this.enUs = builder.enUs;
        this.zhCn = builder.zhCn;
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

    public String getDeDe() {
        return deDe;
    }

    public void setDeDe(String deDe) {
        this.deDe = deDe;
    }

    public String getEsEs() {
        return esEs;
    }

    public void setEsEs(String esEs) {
        this.esEs = esEs;
    }

    public String getFrFr() {
        return frFr;
    }

    public void setFrFr(String frFr) {
        this.frFr = frFr;
    }

    public String getIdId() {
        return idId;
    }

    public void setIdId(String idId) {
        this.idId = idId;
    }

    public String getItIt() {
        return itIt;
    }

    public void setItIt(String itIt) {
        this.itIt = itIt;
    }

    public String getKoKr() {
        return koKr;
    }

    public void setKoKr(String koKr) {
        this.koKr = koKr;
    }

    public String getMsMy() {
        return msMy;
    }

    public void setMsMy(String msMy) {
        this.msMy = msMy;
    }

    public String getPtBr() {
        return ptBr;
    }

    public void setPtBr(String ptBr) {
        this.ptBr = ptBr;
    }

    public String getRuRu() {
        return ruRu;
    }

    public void setRuRu(String ruRu) {
        this.ruRu = ruRu;
    }

    public String getThTh() {
        return thTh;
    }

    public void setThTh(String thTh) {
        this.thTh = thTh;
    }

    public String getViVn() {
        return viVn;
    }

    public void setViVn(String viVn) {
        this.viVn = viVn;
    }

    public String getZhHk() {
        return zhHk;
    }

    public void setZhHk(String zhHk) {
        this.zhHk = zhHk;
    }

    public String getZhTw() {
        return zhTw;
    }

    public void setZhTw(String zhTw) {
        this.zhTw = zhTw;
    }

    public static class Builder {

        private String zhCn;
        private String enUs;
        private String jaJp;
        private String zhHk;
        private String zhTw;
        private String idId;
        private String viVn;
        private String thTh;
        private String ptBr;
        private String esEs;
        private String koKr;
        private String deDe;
        private String frFr;
        private String itIt;
        private String ruRu;
        private String msMy;

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

        public Builder zhHk(String zhHk) {
            this.zhHk = zhHk;
            return this;
        }

        public Builder zhTw(String zhTw) {
            this.zhTw = zhTw;
            return this;
        }

        public Builder idId(String idId) {
            this.idId = idId;
            return this;
        }

        public Builder viVn(String viVn) {
            this.viVn = viVn;
            return this;
        }

        public Builder thTh(String thTh) {
            this.thTh = thTh;
            return this;
        }

        public Builder ptBr(String ptBr) {
            this.ptBr = ptBr;
            return this;
        }

        public Builder esEs(String esEs) {
            this.esEs = esEs;
            return this;
        }

        public Builder koKr(String koKr) {
            this.koKr = koKr;
            return this;
        }

        public Builder deDe(String deDe) {
            this.deDe = deDe;
            return this;
        }

        public Builder frFr(String frFr) {
            this.frFr = frFr;
            return this;
        }

        public Builder itIt(String itIt) {
            this.itIt = itIt;
            return this;
        }

        public Builder ruRu(String ruRu) {
            this.ruRu = ruRu;
            return this;
        }

        public Builder msMy(String msMy) {
            this.msMy = msMy;
            return this;
        }

        public MessageCardPlainTextI18n build() {
            return new MessageCardPlainTextI18n(this);
        }
    }
}
