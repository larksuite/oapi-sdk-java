package com.lark.oapi.channel;

import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.core.request.EventReq;
import com.lark.oapi.event.CustomEventHandler;
import com.lark.oapi.event.EventDispatcher;
import com.lark.oapi.event.cardcallback.P2CardActionTriggerHandler;
import com.lark.oapi.event.cardcallback.model.CallBackToast;
import com.lark.oapi.event.cardcallback.model.P2CardActionTrigger;
import com.lark.oapi.event.cardcallback.model.P2CardActionTriggerResponse;
import com.lark.oapi.service.im.ImService;
import com.lark.oapi.service.im.v1.model.P2ChatMemberBotAddedV1;
import com.lark.oapi.service.im.v1.model.P2MessageReactionCreatedV1;
import com.lark.oapi.service.im.v1.model.P2MessageReactionDeletedV1;
import com.lark.oapi.service.im.v1.model.P2MessageReceiveV1;

final class ChannelEventDispatcherFactory {
    private ChannelEventDispatcherFactory() {
    }

    static EventDispatcher create(LarkChannelOptions options, final ChannelInboundProcessor processor) {
        LarkChannelOptions.WebhookOptions webhook = options.getWebhook();
        EventDispatcher.Builder builder = EventDispatcher.newBuilder(
                webhook == null || webhook.getVerificationToken() == null ? "" : webhook.getVerificationToken(),
                webhook == null || webhook.getEncryptKey() == null ? "" : webhook.getEncryptKey()
        );
        registerHandlers(builder, processor);
        return builder.build();
    }

    private static void registerHandlers(EventDispatcher.Builder builder, final ChannelInboundProcessor processor) {
        builder.onP2MessageReceiveV1(new ImService.P2MessageReceiveV1Handler() {
            @Override
            public void handle(P2MessageReceiveV1 event) {
                processor.handleMessage(event);
            }
        });
        builder.onP2MessageReactionCreatedV1(new ImService.P2MessageReactionCreatedV1Handler() {
            @Override
            public void handle(P2MessageReactionCreatedV1 event) {
                processor.handleReactionCreated(event);
            }
        });
        builder.onP2MessageReactionDeletedV1(new ImService.P2MessageReactionDeletedV1Handler() {
            @Override
            public void handle(P2MessageReactionDeletedV1 event) {
                processor.handleReactionDeleted(event);
            }
        });
        builder.onP2ChatMemberBotAddedV1(new ImService.P2ChatMemberBotAddedV1Handler() {
            @Override
            public void handle(P2ChatMemberBotAddedV1 event) {
                processor.handleBotAdded(event);
            }
        });
        builder.onP2CardActionTrigger(new P2CardActionTriggerHandler() {
            @Override
            public P2CardActionTriggerResponse handle(P2CardActionTrigger event) {
                processor.handleCardAction(event);
                P2CardActionTriggerResponse response = new P2CardActionTriggerResponse();
                CallBackToast toast = new CallBackToast();
                toast.setContent("");
                response.setToast(toast);
                return response;
            }
        });
        builder.onCustomizedEvent("drive.notice.comment_add_v1", new CustomEventHandler() {
            @Override
            public void handle(EventReq req) {
                processor.handleComment(req);
            }
        });
    }
}
