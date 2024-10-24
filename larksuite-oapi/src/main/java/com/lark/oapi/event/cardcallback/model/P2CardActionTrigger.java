package com.lark.oapi.event.cardcallback.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.event.model.BaseEventV2;

public class P2CardActionTrigger extends BaseEventV2 {

    @SerializedName("event")
    private P2CardActionTriggerData event;

    public P2CardActionTriggerData getEvent() {
        return this.event;
    }

    public void setEvent(P2CardActionTriggerData event) {
        this.event = event;
    }
}
