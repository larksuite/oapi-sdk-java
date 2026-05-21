package com.lark.oapi.channel.model;

/**
 * Event emitted when an inbound message is rejected by the safety policy.
 */
public class RejectEvent {
    private final RejectReason reason;
    private final String messageId;
    private final String chatId;
    private final String senderId;
    private final Object raw;

    public RejectEvent(RejectReason reason, Object raw) {
        this(reason, null, null, null, raw);
    }

    public RejectEvent(RejectReason reason, String messageId, String chatId, String senderId, Object raw) {
        this.reason = reason;
        this.messageId = messageId;
        this.chatId = chatId;
        this.senderId = senderId;
        this.raw = raw;
    }

    /** Policy rejection reason. */
    public RejectReason getReason() { return reason; }
    /** Rejected message id, when available. */
    public String getMessageId() { return messageId; }
    /** Rejected chat id, when available. */
    public String getChatId() { return chatId; }
    /** Rejected sender id, when available. */
    public String getSenderId() { return senderId; }
    /** Original message/event that was rejected. */
    public Object getRaw() { return raw; }
}
