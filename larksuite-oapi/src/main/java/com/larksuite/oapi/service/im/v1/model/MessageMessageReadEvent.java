// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;
import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.event.model.BaseEventV2;

public class MessageMessageReadEvent extends BaseEventV2{
    @SerializedName("event")
    private MessageMessageReadEventData event;

    public MessageMessageReadEventData getEvent() {
        return this.event;
    }

    public void setEvent(MessageMessageReadEventData event) {
        this.event = event;
    }

}
