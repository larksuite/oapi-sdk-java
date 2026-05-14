package com.lark.oapi.channel.model;

import java.util.Collections;
import java.util.List;

/**
 * Result returned by send and stream operations.
 */
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

    /** Feishu message id created or updated by the operation. */
    public String getMessageId() { return messageId; }
    /** Streaming chunk ids when the underlying cardkit API returns them. */
    public List<String> getChunkIds() { return chunkIds; }
}
