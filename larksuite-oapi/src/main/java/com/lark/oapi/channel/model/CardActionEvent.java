package com.lark.oapi.channel.model;

import java.util.Collections;
import java.util.Map;

/**
 * Normalized interactive-card callback delivered by the {@code cardAction}
 * event.
 */
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

    /** Message id of the card message. */
    public String getMessageId() { return messageId; }
    /** Chat id that can be used for replies. */
    public String getChatId() { return chatId; }
    /** User open_id of the operator when available. */
    public String getOperatorId() { return operatorId; }
    /** Component tag, for example {@code button} or {@code select_static}. */
    public String getActionTag() { return actionTag; }
    /** Component name configured in card JSON. */
    public String getActionName() { return actionName; }
    /** Selected option value for selection components. */
    public String getActionOption() { return actionOption; }
    /** Callback value map from the card component. */
    public Map<String, Object> getActionValue() { return actionValue; }
    /** Raw callback body when raw events are enabled. */
    public Object getRaw() { return raw; }
}
