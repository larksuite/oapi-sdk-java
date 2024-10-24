package com.lark.oapi.event.cardcallback.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class CallBackToast {
    @SerializedName("type")
    private String type;

    @SerializedName("content")
    private String content;

    @SerializedName("i18n")
    private Map<String, String> i18n;

    public String getType() {return this.type;}

    public void setType(String type) {this.type = type;}

    public String getContent() {return this.content;}

    public void setContent(String content) {this.content = content;}

    public Map<String, String> getI18n() {return this.i18n;}

    public void setI18n(Map<String, String> i18n) {this.i18n = i18n;}
}
