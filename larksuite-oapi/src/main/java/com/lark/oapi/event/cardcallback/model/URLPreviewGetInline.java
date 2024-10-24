package com.lark.oapi.event.cardcallback.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class URLPreviewGetInline {
    @SerializedName("title")
    private String title;
    @SerializedName("i18n_title")
    private Map<String, String> i18nTitle;
    @SerializedName("image_key")
    private String imageKey;

    public String getTitle() {return this.title;}

    public void setTitle(String title) {this.title = title;}

    public Map<String, String> getI18nTitle() {return this.i18nTitle;}

    public void setI18nTitle(Map<String, String> i18nTitle) {this.i18nTitle = i18nTitle;}

    public String getImageKey() {return this.imageKey;}

    public void setImageKey(String imageKey) {this.imageKey = imageKey;}
}
