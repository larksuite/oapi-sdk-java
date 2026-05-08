package com.lark.oapi.channel.model;

public class MentionInfo {
    private final String key;
    private final String openId;
    private final String name;
    private final boolean bot;

    public MentionInfo(String key, String openId, String name, boolean bot) {
        this.key = key;
        this.openId = openId;
        this.name = name;
        this.bot = bot;
    }

    public String getKey() {
        return key;
    }

    public String getOpenId() {
        return openId;
    }

    public String getName() {
        return name;
    }

    public boolean isBot() {
        return bot;
    }
}
