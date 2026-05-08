package com.lark.oapi.channel.model;

import java.util.Collections;
import java.util.List;

public class SendResult {
    private final String messageId;
    private final List<String> chunkIds;

    public SendResult(String messageId) {
        this(messageId, Collections.<String>emptyList());
    }

    public SendResult(String messageId, List<String> chunkIds) {
        this.messageId = messageId;
        this.chunkIds = chunkIds == null ? Collections.<String>emptyList() : chunkIds;
    }

    public String getMessageId() { return messageId; }
    public List<String> getChunkIds() { return chunkIds; }
}
