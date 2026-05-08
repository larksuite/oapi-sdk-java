package com.lark.oapi.channel.model;

import java.util.Collections;
import java.util.Map;

public class CardActionEvent {
    private final String messageId;
    private final String chatId;
    private final String operatorId;
    private final String actionTag;
    private final String actionName;
    private final String actionOption;
    private final Map<String, Object> actionValue;
    private final Object raw;

    public CardActionEvent(String messageId, String chatId, String operatorId, String actionTag,
                           String actionName, String actionOption, Map<String, Object> actionValue, Object raw) {
        this.messageId = messageId;
        this.chatId = chatId;
        this.operatorId = operatorId;
        this.actionTag = actionTag;
        this.actionName = actionName;
        this.actionOption = actionOption;
        this.actionValue = actionValue == null ? Collections.<String, Object>emptyMap() : actionValue;
        this.raw = raw;
    }

    public String getMessageId() { return messageId; }
    public String getChatId() { return chatId; }
    public String getOperatorId() { return operatorId; }
    public String getActionTag() { return actionTag; }
    public String getActionName() { return actionName; }
    public String getActionOption() { return actionOption; }
    public Map<String, Object> getActionValue() { return actionValue; }
    public Object getRaw() { return raw; }
}
