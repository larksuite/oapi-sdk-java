package com.lark.oapi.channel.model;

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

    public String getMessageId() { return messageId; }
    public String getOperatorId() { return operatorId; }
    public String getOperatorType() { return operatorType; }
    public String getEmojiType() { return emojiType; }
    public String getAction() { return action; }
    public long getActionTime() { return actionTime; }
    public Object getRaw() { return raw; }
}
