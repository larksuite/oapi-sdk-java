package com.lark.oapi.channel.model;

public interface MarkdownStreamController {
    void append(String chunk);

    void setContent(String full);

    String getMessageId();
}
