package com.lark.oapi.event.cardcallback.model;

import com.google.gson.annotations.SerializedName;

public class URLPreviewGetInlineURL {
    @SerializedName("copy_url")
    private String copyUrl;
    @SerializedName("ios")
    private String ios;
    @SerializedName("android")
    private String android;
    @SerializedName("pc")
    private String pc;
    @SerializedName("web")
    private String web;

    public String getCopyUrl() {
        return this.copyUrl;
    }

    public void setCopyUrl(String copyUrl) {
        this.copyUrl = copyUrl;
    }

    public String getIos() {
        return this.ios;
    }

    public void setIos(String ios) {
        this.ios = ios;
    }

    public String getAndroid() {
        return this.android;
    }

    public void setAndroid(String android) {
        this.android = android;
    }

    public String getPc() {
        return this.pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getWeb() {
        return this.web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
