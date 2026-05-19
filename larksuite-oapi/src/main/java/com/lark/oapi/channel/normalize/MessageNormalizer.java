package com.lark.oapi.channel.normalize;

import com.lark.oapi.channel.model.NormalizedMessage;
import com.lark.oapi.service.im.v1.model.EventMessage;
import com.lark.oapi.service.im.v1.model.EventSender;
import com.lark.oapi.service.im.v1.model.MentionEvent;
import com.lark.oapi.service.im.v1.model.P2MessageReceiveV1;
import com.lark.oapi.service.im.v1.model.UserId;

/**
 * Normalize a raw Feishu message event into a NormalizedMessage.
 *
 * Pipeline:
 *   1. Extract mentions -> build key/openId maps + bot detection
 *   2. Build ConvertContext with injected capabilities
 *   3. Dispatch to the matching converter, with uniform error containment
 *   4. Run resolveMentions second pass, replacing placeholders with @name
 *   5. Assemble and return NormalizedMessage
 */
class MessageNormalizer {
    NormalizedMessage normalize(P2MessageReceiveV1 event, NormalizeOptions opts) {
        if (event == null || event.getEvent() == null || event.getEvent().getMessage() == null) {
            return null;
        }
        EventMessage msg = event.getEvent().getMessage();
        EventSender sender = event.getEvent().getSender();
        String botOpenId = opts.getBotIdentity() == null ? null : opts.getBotIdentity().getOpenId();

        MentionState mentionState = Mentions.extract(msg.getMentions(), msg.getContent(), opts.getBotIdentity());
        boolean mentionAllFromRaw = mentionState.isMentionAll();
        boolean mentionAllFromContent = Mentions.detectMentionAllInContent(msg.getContent());
        boolean mentionAll = mentionAllFromRaw || mentionAllFromContent;
        System.err.println("[ChannelMentionDebug] normalizer messageId=" + msg.getMessageId()
                + ", rawContent=" + msg.getContent()
                + ", mentionKeys=" + mentionKeys(msg.getMentions())
                + ", mentionAllFromRaw=" + mentionAllFromRaw
                + ", mentionAllFromContent=" + mentionAllFromContent
                + ", mentionAll=" + mentionAll
                + ", mentionedBotFromRaw=" + mentionState.isMentionedBot()
                + ", botOpenId=" + botOpenId);

        ConvertContext ctx = new ConvertContext(msg.getMessageId(), mentionState, opts);
        ConvertResult converted = MessageConverters.dispatchConvert(msg.getContent(), msg.getMessageType(), ctx);
        String content = Mentions.resolveMentions(converted.getContent(), ctx);

        String senderId = resolveUserId(sender == null ? null : sender.getSenderId());
        String senderName = opts.getResolveSenderName() == null || senderId == null
                ? null
                : opts.getResolveSenderName().resolve(senderId);

        return new NormalizedMessage(
                msg.getMessageId(),
                msg.getChatId(),
                msg.getChatType(),
                senderId,
                senderName,
                content,
                msg.getMessageType(),
                converted.getResources(),
                mentionState.getMentions(),
                mentionAll,
                mentionState.isMentionedBot() || (botOpenId != null && mentionState.getByOpenId().containsKey(botOpenId)),
                msg.getRootId(),
                msg.getThreadId(),
                msg.getParentId(),
                NormalizeTexts.parseLong(msg.getCreateTime()),
                opts.isIncludeRaw() ? event : null
        );
    }

    private String resolveUserId(UserId userId) {
        if (userId == null) {
            return null;
        }
        return NormalizeTexts.firstNonBlank(userId.getOpenId(), userId.getUserId(), userId.getUnionId());
    }

    private String mentionKeys(MentionEvent[] mentions) {
        if (mentions == null || mentions.length == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < mentions.length; i++) {
            if (i > 0) {
                builder.append(", ");
            }
            MentionEvent mention = mentions[i];
            builder.append(mention == null ? "null" : mention.getKey());
        }
        return builder.append(']').toString();
    }
}
