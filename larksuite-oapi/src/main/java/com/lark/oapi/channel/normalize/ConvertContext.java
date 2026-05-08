package com.lark.oapi.channel.normalize;

public class ConvertContext {
    private final String messageId;
    private final MentionState mentionState;
    private final NormalizeOptions options;

    public ConvertContext(String messageId, MentionState mentionState, NormalizeOptions options) {
        this.messageId = messageId;
        this.mentionState = mentionState;
        this.options = options;
    }

    public String getMessageId() {
        return messageId;
    }

    public MentionState getMentionState() {
        return mentionState;
    }

    public NormalizeOptions getOptions() {
        return options;
    }
}
