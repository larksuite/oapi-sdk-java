// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.event.model.BaseEventV2;

public class MessageReceiveEvent extends BaseEventV2 {
    @SerializedName("event")
    private MessageReceiveEventData event;

    public MessageReceiveEventData getEvent() {
        return this.event;
    }

    public void setEvent(MessageReceiveEventData event) {
        this.event = event;
    }

}
