package com.lark.oapi.channel.normalize;

public class ConvertContext {
    private final String messageId;
    private final MentionState mentionState;
    private final NormalizeOptions options;
    private final String botOpenId;

    public ConvertContext(String messageId, MentionState mentionState, NormalizeOptions options) {
        this.messageId = messageId;
        this.mentionState = mentionState;
        this.options = options;
        this.botOpenId = options == null || options.getBotIdentity() == null ? null : options.getBotIdentity().getOpenId();
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

    public String getBotOpenId() {
        return botOpenId;
    }

    public boolean isStripBotMentions() {
        return options == null || options.isStripBotMentions();
    }

    public NormalizeOptions.SubMessageFetcher getFetchSubMessages() {
        return options == null ? null : options.getFetchSubMessages();
    }

    public NormalizeOptions.UserNameResolver getResolveUserName() {
        return options == null ? null : options.getResolveUserName();
    }

    public NormalizeOptions.BatchResolveNames getBatchResolveNames() {
        return options == null ? null : options.getBatchResolveNames();
    }
}
