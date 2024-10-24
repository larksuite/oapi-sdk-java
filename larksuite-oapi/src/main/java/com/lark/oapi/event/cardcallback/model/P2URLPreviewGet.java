package com.lark.oapi.event.cardcallback.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.event.model.BaseEventV2;

public class P2URLPreviewGet extends BaseEventV2 {
    @SerializedName("event")
    private P2URLPreviewGetData event;

    public P2URLPreviewGetData getEvent() {return this.event;}

    public void setEvent(P2URLPreviewGetData event) {this.event = event;}
}
