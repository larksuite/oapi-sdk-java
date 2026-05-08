package com.lark.oapi.channel.model;

import java.util.Collections;
import java.util.List;

public class NormalizedMessage {
    private final String messageId;
    private final String chatId;
    private final String chatType;
    private final String senderId;
    private final String senderName;
    private final String content;
    private final String rawContentType;
    private final List<ResourceDescriptor> resources;
    private final List<MentionInfo> mentions;
    private final boolean mentionAll;
    private final boolean mentionedBot;
    private final String rootId;
    private final String threadId;
    private final String replyToMessageId;
    private final long createTime;
    private final Object raw;

    public NormalizedMessage(String messageId, String chatId, String chatType, String senderId, String senderName,
                             String content, String rawContentType, List<ResourceDescriptor> resources,
                             List<MentionInfo> mentions, boolean mentionAll, boolean mentionedBot,
                             String rootId, String threadId, String replyToMessageId,
                             long createTime, Object raw) {
        this.messageId = messageId;
        this.chatId = chatId;
        this.chatType = chatType;
        this.senderId = senderId;
        this.senderName = senderName;
        this.content = content;
        this.rawContentType = rawContentType;
        this.resources = resources == null ? Collections.<ResourceDescriptor>emptyList() : resources;
        this.mentions = mentions == null ? Collections.<MentionInfo>emptyList() : mentions;
        this.mentionAll = mentionAll;
        this.mentionedBot = mentionedBot;
        this.rootId = rootId;
        this.threadId = threadId;
        this.replyToMessageId = replyToMessageId;
        this.createTime = createTime;
        this.raw = raw;
    }

    public String getMessageId() { return messageId; }
    public String getChatId() { return chatId; }
    public String getChatType() { return chatType; }
    public String getSenderId() { return senderId; }
    public String getSenderName() { return senderName; }
    public String getContent() { return content; }
    public String getRawContentType() { return rawContentType; }
    public List<ResourceDescriptor> getResources() { return resources; }
    public List<MentionInfo> getMentions() { return mentions; }
    public boolean isMentionAll() { return mentionAll; }
    public boolean isMentionedBot() { return mentionedBot; }
    public String getRootId() { return rootId; }
    public String getThreadId() { return threadId; }
    public String getReplyToMessageId() { return replyToMessageId; }
    public long getCreateTime() { return createTime; }
    public Object getRaw() { return raw; }
}
