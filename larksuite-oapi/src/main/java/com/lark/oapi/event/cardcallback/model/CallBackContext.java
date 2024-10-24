package com.lark.oapi.event.cardcallback.model;

import com.google.gson.annotations.SerializedName;

public class CallBackContext {
    @SerializedName("url")
    private String url;

    @SerializedName("preview_token")
    private String previewToken;

    @SerializedName("open_message_id")
    private String openMessageId;

    @SerializedName("open_chat_id")
    private String openChatId;

    public String getUrl() {return this.url;}

    public void setUrl(String url) {this.url = url;}

    public String getPreviewToken() {return this.previewToken;}

    public void setPreviewToken(String previewToken) {this.previewToken = previewToken;}

    public String getOpenMessageId() {return this.openMessageId;}

    public void setOpenMessageId(String openMessageId) {this.openMessageId = openMessageId;}

    public String getOpenChatId() {return this.openChatId;}

    public void setOpenChatId(String openChatId) {this.openChatId = openChatId;}
}
