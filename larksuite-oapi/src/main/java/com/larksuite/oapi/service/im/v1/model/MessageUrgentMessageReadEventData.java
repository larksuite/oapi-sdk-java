// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;
import com.google.gson.annotations.SerializedName;

public class MessageUrgentMessageReadEventData {
    @SerializedName("reader")
    private EventMessageReader reader;
    @SerializedName("message_id")
    private String messageId;

    public EventMessageReader getReader() {
        return this.reader;
    }

    public void setReader(EventMessageReader reader) {
        this.reader = reader;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

}
