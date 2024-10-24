package com.lark.oapi.event.cardcallback.model;

import com.google.gson.annotations.SerializedName;

public class P2CardActionTriggerResponse {
    @SerializedName("toast")
    private CallBackToast toast;

    @SerializedName("card")
    private CallBackCard card;

    public CallBackToast getToast() {return this.toast;}

    public void setToast(CallBackToast toast) {this.toast = toast;}

    public CallBackCard getCard() {return this.card;}

    public void setCard(CallBackCard card) {this.card = card;}
}
