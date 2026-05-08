package com.lark.oapi.channel.normalize;

import com.lark.oapi.channel.model.BotAddedEvent;
import com.lark.oapi.channel.model.CardActionEvent;
import com.lark.oapi.channel.model.CommentEvent;
import com.lark.oapi.channel.model.NormalizedMessage;
import com.lark.oapi.channel.model.ReactionEvent;
import com.lark.oapi.service.im.v1.model.EventMessage;
import com.lark.oapi.service.im.v1.model.EventSender;
import com.lark.oapi.service.im.v1.model.P2ChatMemberBotAddedV1;
import com.lark.oapi.service.im.v1.model.P2MessageReactionCreatedV1;
import com.lark.oapi.service.im.v1.model.P2MessageReactionDeletedV1;
import com.lark.oapi.service.im.v1.model.P2MessageReceiveV1;
import com.lark.oapi.service.im.v1.model.UserId;

public class ChannelNormalizer {
    private final CardActionNormalizer cardActionNormalizer = new CardActionNormalizer();
    private final ReactionNormalizer reactionNormalizer = new ReactionNormalizer();
    private final BotAddedNormalizer botAddedNormalizer = new BotAddedNormalizer();
    private final CommentNormalizer commentNormalizer = new CommentNormalizer();

    public NormalizedMessage normalizeMessage(P2MessageReceiveV1 event, NormalizeOptions options) {
        if (event == null || event.getEvent() == null || event.getEvent().getMessage() == null) {
            return null;
        }
        EventMessage message = event.getEvent().getMessage();
        EventSender sender = event.getEvent().getSender();
        String senderId = resolveUserId(sender == null ? null : sender.getSenderId());
        MentionState mentionState = Mentions.extract(message.getMentions(), message.getContent(), options.getBotIdentity());
        ConvertResult converted = MessageConverters.convert(
                message.getMessageType(),
                message.getContent(),
                mentionState,
                options,
                message.getMessageId());
        String content = Mentions.replaceKeys(converted.getContent(), mentionState, options.isStripBotMentions());
        String senderName = options.getSenderNameResolver() == null || senderId == null ? null : options.getSenderNameResolver().resolve(senderId);
        return new NormalizedMessage(
                message.getMessageId(),
                message.getChatId(),
                message.getChatType(),
                senderId,
                senderName,
                content,
                message.getMessageType(),
                converted.getResources(),
                mentionState.getMentions(),
                mentionState.isMentionAll(),
                mentionState.isMentionedBot(),
                message.getRootId(),
                message.getThreadId(),
                message.getParentId(),
                NormalizeTexts.parseLong(message.getCreateTime()),
                options.isIncludeRawInMessage() ? event : null
        );
    }

    public ReactionEvent normalizeReaction(P2MessageReactionCreatedV1 event, String action) {
        return reactionNormalizer.normalize(event, action);
    }

    public ReactionEvent normalizeReaction(P2MessageReactionDeletedV1 event, String action) {
        return reactionNormalizer.normalize(event, action);
    }

    public CardActionEvent normalizeCardAction(com.lark.oapi.event.cardcallback.model.P2CardActionTrigger event) {
        return cardActionNormalizer.normalize(event);
    }

    public BotAddedEvent normalizeBotAdded(P2ChatMemberBotAddedV1 event) {
        return botAddedNormalizer.normalize(event);
    }

    public CommentEvent normalizeComment(com.google.gson.JsonObject payload, Object raw) {
        return commentNormalizer.normalize(payload, raw);
    }

    public String buildCardActionDedupKey(CardActionEvent event) {
        String valueJson = com.lark.oapi.core.utils.Jsons.DEFAULT.toJson(event.getActionValue());
        return "card:" + safe(event.getMessageId()) + ":" + safe(event.getOperatorId()) + ":" + safe(event.getActionTag())
                + ":" + safe(event.getActionName()) + ":" + safe(event.getActionOption()) + ":" + safe(valueJson);
    }

    public String buildReactionDedupKey(ReactionEvent event) {
        return "reaction:" + safe(event.getMessageId()) + ":" + safe(event.getOperatorId()) + ":" + safe(event.getEmojiType()) + ":" + safe(event.getAction()) + ":" + event.getActionTime();
    }

    public String buildMessageDedupKey(NormalizedMessage event) {
        return "message:" + safe(event.getMessageId());
    }

    public String buildCommentDedupKey(CommentEvent event) {
        return "comment:" + safe(event.getFileToken()) + ":" + safe(event.getCommentId());
    }

    private String resolveUserId(UserId userId) {
        if (userId == null) {
            return null;
        }
        return NormalizeTexts.firstNonBlank(userId.getOpenId(), userId.getUserId(), userId.getUnionId());
    }

    private String safe(String value) {
        return value == null ? "" : value;
    }
}
