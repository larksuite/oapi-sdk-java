package com.lark.oapi.channel.model;

/**
 * Normalized message reaction event.
 */
public class ReactionEvent {
    private final String messageId;
    private final String operatorId;
    private final String operatorType;
    private final String emojiType;
    private final String action;
    private final long actionTime;
    private final Object raw;

    public ReactionEvent(String messageId, String operatorId, String operatorType, String emojiType,
                         String action, long actionTime, Object raw) {
        this.messageId = messageId;
        this.operatorId = operatorId;
        this.operatorType = operatorType;
        this.emojiType = emojiType;
        this.action = action;
        this.actionTime = actionTime;
        this.raw = raw;
    }

    /** Message id whose reaction changed. */
    public String getMessageId() { return messageId; }
    /** Operator id, usually open_id. */
    public String getOperatorId() { return operatorId; }
    /** Operator type from Feishu event payload. */
    public String getOperatorType() { return operatorType; }
    /** Emoji type such as {@code OK} or {@code THUMBSUP}. */
    public String getEmojiType() { return emojiType; }
    /** {@code created} or {@code deleted}. */
    public String getAction() { return action; }
    /** Feishu action time in milliseconds when present. */
    public long getActionTime() { return actionTime; }
    /** Raw event body when raw events are enabled. */
    public Object getRaw() { return raw; }
}
