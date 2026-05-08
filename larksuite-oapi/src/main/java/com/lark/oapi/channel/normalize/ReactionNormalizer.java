package com.lark.oapi.channel.normalize;

import com.lark.oapi.channel.model.ReactionEvent;
import com.lark.oapi.service.im.v1.model.P2MessageReactionCreatedV1;
import com.lark.oapi.service.im.v1.model.P2MessageReactionDeletedV1;
import com.lark.oapi.service.im.v1.model.UserId;

public class ReactionNormalizer {
    public ReactionEvent normalize(P2MessageReactionCreatedV1 event, String action) {
        if (event == null || event.getEvent() == null) {
            return null;
        }
        String operatorId = resolveOperator(event.getEvent().getUserId(), event.getEvent().getAppId());
        String emojiType = event.getEvent().getReactionType() == null ? null : event.getEvent().getReactionType().getEmojiType();
        if (isBlank(event.getEvent().getMessageId()) || isBlank(operatorId) || isBlank(emojiType)) {
            return null;
        }
        return new ReactionEvent(
                event.getEvent().getMessageId(),
                operatorId,
                event.getEvent().getOperatorType(),
                emojiType,
                action,
                parseLong(event.getEvent().getActionTime()),
                event
        );
    }

    public ReactionEvent normalize(P2MessageReactionDeletedV1 event, String action) {
        if (event == null || event.getEvent() == null) {
            return null;
        }
        String operatorId = resolveOperator(event.getEvent().getUserId(), event.getEvent().getAppId());
        String emojiType = event.getEvent().getReactionType() == null ? null : event.getEvent().getReactionType().getEmojiType();
        if (isBlank(event.getEvent().getMessageId()) || isBlank(operatorId) || isBlank(emojiType)) {
            return null;
        }
        return new ReactionEvent(
                event.getEvent().getMessageId(),
                operatorId,
                event.getEvent().getOperatorType(),
                emojiType,
                action,
                parseLong(event.getEvent().getActionTime()),
                event
        );
    }

    private String resolveOperator(UserId userId, String appId) {
        if (userId != null) {
            if (!isBlank(userId.getOpenId())) {
                return userId.getOpenId();
            }
            if (!isBlank(userId.getUserId())) {
                return userId.getUserId();
            }
            if (!isBlank(userId.getUnionId())) {
                return userId.getUnionId();
            }
        }
        return appId;
    }

    private long parseLong(String value) {
        try {
            return value == null ? 0L : Long.parseLong(value);
        } catch (Exception ignored) {
            return 0L;
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.isEmpty();
    }
}
