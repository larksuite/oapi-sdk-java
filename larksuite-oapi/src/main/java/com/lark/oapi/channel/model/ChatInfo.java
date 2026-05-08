package com.lark.oapi.channel.model;

public class ChatInfo {
    private final String chatId;
    private final String name;
    private final String description;
    private final String chatType;
    private final String ownerId;
    private final Integer memberCount;

    public ChatInfo(String chatId, String name, String description, String chatType, String ownerId, Integer memberCount) {
        this.chatId = chatId;
        this.name = name;
        this.description = description;
        this.chatType = chatType;
        this.ownerId = ownerId;
        this.memberCount = memberCount;
    }

    public String getChatId() {
        return chatId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getChatType() {
        return chatType;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public Integer getMemberCount() {
        return memberCount;
    }
}
