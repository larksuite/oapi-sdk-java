package com.lark.oapi.channel.model;

/**
 * Mention metadata extracted from message content.
 */
public class MentionInfo {
    private final String key;
    private final String openId;
    private final String userId;
    private final String name;
    private final boolean bot;

    public MentionInfo(String key, String openId, String name, boolean bot) {
        this(key, openId, null, name, bot);
    }

    public MentionInfo(String key, String openId, String userId, String name, boolean bot) {
        this.key = key;
        this.openId = openId;
        this.userId = userId;
        this.name = name;
        this.bot = bot;
    }

    /** Placeholder key used in raw Feishu message content. */
    public String getKey() {
        return key;
    }

    /** Mentioned user's open_id. */
    public String getOpenId() {
        return openId;
    }

    /** Mentioned user's user_id when available. */
    public String getUserId() {
        return userId;
    }

    /** Display name shown in the message. */
    public String getName() {
        return name;
    }

    /** Whether this mention points to the connected bot. */
    public boolean isBot() {
        return bot;
    }
}
