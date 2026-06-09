package com.lark.oapi.channel.model;

import java.util.Collections;
import java.util.List;

/**
 * Normalized inbound message delivered to {@code channel.on("message", ...)}.
 *
 * <p>The normalizer flattens Feishu message shapes into text content,
 * resource descriptors, mention metadata and reply/thread context so Agent
 * handlers do not need to parse raw message JSON for common cases.
 */
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

    /**
     * Current message id.
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Chat id that can be passed directly to {@code channel.send(...)}.
     */
    public String getChatId() {
        return chatId;
    }

    /**
     * Feishu chat type, for example {@code p2p} or {@code group}.
     */
    public String getChatType() {
        return chatType;
    }

    /**
     * Sender open_id when available.
     */
    public String getSenderId() {
        return senderId;
    }

    /**
     * Sender display name when provided by the event.
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * Text content after message-type conversion and bot-mention stripping.
     */
    public String getContent() {
        return content;
    }

    /**
     * Original Feishu message type such as {@code text}, {@code post}, {@code image}.
     */
    public String getRawContentType() {
        return rawContentType;
    }

    /**
     * Image, file, audio or video resources referenced by the message.
     */
    public List<ResourceDescriptor> getResources() {
        return resources;
    }

    /**
     * Parsed user mentions in message order.
     */
    public List<MentionInfo> getMentions() {
        return mentions;
    }

    /**
     * Whether the message mentions everyone.
     */
    public boolean isMentionAll() {
        return mentionAll;
    }

    /**
     * Whether the message mentions the connected bot.
     */
    public boolean isMentionedBot() {
        return mentionedBot;
    }

    /**
     * Root message id for threaded replies when Feishu provides it.
     */
    public String getRootId() {
        return rootId;
    }

    /**
     * Thread id when the message belongs to a topic/thread.
     */
    public String getThreadId() {
        return threadId;
    }

    /**
     * Parent message id for direct replies.
     */
    public String getReplyToMessageId() {
        return replyToMessageId;
    }

    /**
     * Feishu create_time in milliseconds when present.
     */
    public long getCreateTime() {
        return createTime;
    }

    /**
     * Raw event body when {@code includeRawEvent(true)} is enabled.
     */
    public Object getRaw() {
        return raw;
    }
}
