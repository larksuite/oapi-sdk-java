package com.lark.oapi.event.cardcallback.model;

import com.google.gson.annotations.SerializedName;

public class P2URLPreviewGetResponse {
    @SerializedName("inline")
    private URLPreviewGetInline inline;
    @SerializedName("card")
    private CallBackCard card;

    public URLPreviewGetInline getInline() {return this.inline;}

    public void setInline(URLPreviewGetInline inline) {this.inline = inline;}

    public CallBackCard getCard() {return this.card;}

    public void setCard(CallBackCard card) {this.card = card;}
}
