// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;
import com.google.gson.annotations.SerializedName;

public class MessageReceiveEventData {
    @SerializedName("sender")
    private EventSender sender;
    @SerializedName("message")
    private EventMessage message;

    public EventSender getSender() {
        return this.sender;
    }

    public void setSender(EventSender sender) {
        this.sender = sender;
    }

    public EventMessage getMessage() {
        return this.message;
    }

    public void setMessage(EventMessage message) {
        this.message = message;
    }

}
