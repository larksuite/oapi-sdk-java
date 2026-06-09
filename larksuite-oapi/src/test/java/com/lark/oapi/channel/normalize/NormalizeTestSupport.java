package com.lark.oapi.channel.normalize;

import com.lark.oapi.event.cardcallback.model.CallBackAction;
import com.lark.oapi.event.cardcallback.model.CallBackContext;
import com.lark.oapi.event.cardcallback.model.CallBackOperator;
import com.lark.oapi.event.cardcallback.model.P2CardActionTrigger;
import com.lark.oapi.event.cardcallback.model.P2CardActionTriggerData;
import com.lark.oapi.service.im.v1.model.EventMessage;
import com.lark.oapi.service.im.v1.model.EventSender;
import com.lark.oapi.service.im.v1.model.I18nNames;
import com.lark.oapi.service.im.v1.model.MentionEvent;
import com.lark.oapi.service.im.v1.model.P2ChatMemberBotAddedV1;
import com.lark.oapi.service.im.v1.model.P2ChatMemberBotAddedV1Data;
import com.lark.oapi.service.im.v1.model.P2MessageReactionCreatedV1;
import com.lark.oapi.service.im.v1.model.P2MessageReactionCreatedV1Data;
import com.lark.oapi.service.im.v1.model.P2MessageReactionDeletedV1;
import com.lark.oapi.service.im.v1.model.P2MessageReactionDeletedV1Data;
import com.lark.oapi.service.im.v1.model.P2MessageReceiveV1;
import com.lark.oapi.service.im.v1.model.P2MessageReceiveV1Data;
import com.lark.oapi.service.im.v1.model.UserId;

import java.util.Map;

final class NormalizeTestSupport {
    private NormalizeTestSupport() {
    }

    static P2MessageReceiveV1 buildMessageEvent(String messageId, String chatId, String chatType,
                                                String messageType, String content, MentionEvent[] mentions) {
        EventMessage message = EventMessage.newBuilder()
                .messageId(messageId)
                .chatId(chatId)
                .chatType(chatType)
                .messageType(messageType)
                .content(content)
                .mentions(mentions)
                .createTime(String.valueOf(System.currentTimeMillis()))
                .build();
        EventSender sender = EventSender.newBuilder()
                .senderId(UserId.newBuilder().openId("ou_sender").userId("u_sender").build())
                .build();
        P2MessageReceiveV1Data data = new P2MessageReceiveV1Data();
        data.setMessage(message);
        data.setSender(sender);
        P2MessageReceiveV1 event = new P2MessageReceiveV1();
        event.setEvent(data);
        return event;
    }

    static MentionEvent mention(String key, String openId, String name) {
        return MentionEvent.newBuilder()
                .key(key)
                .name(name)
                .id(UserId.newBuilder().openId(openId).build())
                .build();
    }

    static P2CardActionTrigger buildCardAction(String messageId, String chatId, String openId, String tag, Map<String, Object> value) {
        P2CardActionTriggerData data = new P2CardActionTriggerData();
        CallBackContext context = new CallBackContext();
        context.setOpenMessageId(messageId);
        context.setOpenChatId(chatId);
        data.setContext(context);
        CallBackOperator operator = new CallBackOperator();
        operator.setOpenId(openId);
        data.setOperator(operator);
        CallBackAction action = new CallBackAction();
        action.setTag(tag);
        action.setValue(value);
        data.setAction(action);
        P2CardActionTrigger event = new P2CardActionTrigger();
        event.setEvent(data);
        return event;
    }

    static P2MessageReactionCreatedV1 buildReactionCreated(String messageId, String emojiType, String openId, String appId, String actionTime) {
        P2MessageReactionCreatedV1Data data = new P2MessageReactionCreatedV1Data();
        data.setMessageId(messageId);
        com.lark.oapi.service.im.v1.model.Emoji emoji = new com.lark.oapi.service.im.v1.model.Emoji();
        emoji.setEmojiType(emojiType);
        data.setReactionType(emoji);
        if (openId != null) {
            data.setUserId(UserId.newBuilder().openId(openId).build());
        }
        data.setAppId(appId);
        data.setActionTime(actionTime);
        P2MessageReactionCreatedV1 event = new P2MessageReactionCreatedV1();
        event.setEvent(data);
        return event;
    }

    static P2MessageReactionDeletedV1 buildReactionDeleted(String messageId, String emojiType, String openId, String appId, String actionTime) {
        P2MessageReactionDeletedV1Data data = new P2MessageReactionDeletedV1Data();
        data.setMessageId(messageId);
        com.lark.oapi.service.im.v1.model.Emoji emoji = new com.lark.oapi.service.im.v1.model.Emoji();
        emoji.setEmojiType(emojiType);
        data.setReactionType(emoji);
        if (openId != null) {
            data.setUserId(UserId.newBuilder().openId(openId).build());
        }
        data.setAppId(appId);
        data.setActionTime(actionTime);
        P2MessageReactionDeletedV1 event = new P2MessageReactionDeletedV1();
        event.setEvent(data);
        return event;
    }

    static P2ChatMemberBotAddedV1 buildBotAdded(String chatId, String openId, String name, String zhCn, String enUs, String jaJp) {
        P2ChatMemberBotAddedV1Data data = new P2ChatMemberBotAddedV1Data();
        data.setChatId(chatId);
        if (openId != null) {
            data.setOperatorId(UserId.newBuilder().openId(openId).build());
        }
        data.setName(name);
        if (zhCn != null || enUs != null || jaJp != null) {
            data.setI18nNames(I18nNames.newBuilder().zhCn(zhCn).enUs(enUs).jaJp(jaJp).build());
        }
        P2ChatMemberBotAddedV1 event = new P2ChatMemberBotAddedV1();
        event.setEvent(data);
        return event;
    }
}
