package com.lark.oapi.channel.normalize;

import com.lark.oapi.channel.model.BotAddedEvent;
import com.lark.oapi.service.im.v1.model.I18nNames;
import com.lark.oapi.service.im.v1.model.P2ChatMemberBotAddedV1;
import com.lark.oapi.service.im.v1.model.UserId;

public class BotAddedNormalizer {
    public BotAddedEvent normalize(P2ChatMemberBotAddedV1 event) {
        if (event == null || event.getEvent() == null || isBlank(event.getEvent().getChatId())) {
            return null;
        }
        String operatorId = resolveUserId(event.getEvent().getOperatorId());
        if (isBlank(operatorId)) {
            return null;
        }
        String botName = resolveBotName(event.getEvent().getName(), event.getEvent().getI18nNames());
        return new BotAddedEvent(event.getEvent().getChatId(), operatorId, botName, event);
    }

    private String resolveBotName(String name, I18nNames i18nNames) {
        if (!isBlank(name)) {
            return name;
        }
        if (i18nNames == null) {
            return null;
        }
        if (!isBlank(i18nNames.getZhCn())) {
            return i18nNames.getZhCn();
        }
        if (!isBlank(i18nNames.getEnUs())) {
            return i18nNames.getEnUs();
        }
        return i18nNames.getJaJp();
    }

    private String resolveUserId(UserId userId) {
        if (userId == null) {
            return null;
        }
        if (!isBlank(userId.getOpenId())) {
            return userId.getOpenId();
        }
        if (!isBlank(userId.getUserId())) {
            return userId.getUserId();
        }
        return userId.getUnionId();
    }

    private boolean isBlank(String value) {
        return value == null || value.isEmpty();
    }
}
