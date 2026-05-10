package com.lark.oapi.channel.model;

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

    public String getKey() {
        return key;
    }

    public String getOpenId() {
        return openId;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public boolean isBot() {
        return bot;
    }
}
