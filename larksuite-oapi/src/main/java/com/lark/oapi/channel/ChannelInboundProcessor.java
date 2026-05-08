package com.lark.oapi.channel;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.model.BotAddedEvent;
import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.channel.model.CardActionEvent;
import com.lark.oapi.channel.model.CommentEvent;
import com.lark.oapi.channel.model.NormalizedMessage;
import com.lark.oapi.channel.model.ReactionEvent;
import com.lark.oapi.channel.model.RejectEvent;
import com.lark.oapi.channel.model.RejectReason;
import com.lark.oapi.channel.normalize.ChannelNormalizer;
import com.lark.oapi.channel.normalize.NormalizeOptions;
import com.lark.oapi.channel.safety.SafetyPipeline;
import com.lark.oapi.core.request.EventReq;
import com.lark.oapi.service.im.v1.model.GetMessageReq;
import com.lark.oapi.service.im.v1.model.GetMessageResp;
import com.lark.oapi.service.im.v1.model.P2ChatMemberBotAddedV1;
import com.lark.oapi.service.im.v1.model.P2MessageReactionCreatedV1;
import com.lark.oapi.service.im.v1.model.P2MessageReactionDeletedV1;
import com.lark.oapi.service.im.v1.model.P2MessageReceiveV1;
import com.lark.oapi.event.cardcallback.model.P2CardActionTrigger;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

final class ChannelInboundProcessor {
    private final Client client;
    private final LarkChannelOptions options;
    private final ChannelNormalizer normalizer;
    private final SafetyPipeline safetyPipeline;
    private final ChannelEventBus eventBus;
    private final Supplier<BotIdentity> botIdentitySupplier;

    ChannelInboundProcessor(Client client, LarkChannelOptions options, ChannelNormalizer normalizer,
                            SafetyPipeline safetyPipeline, ChannelEventBus eventBus,
                            Supplier<BotIdentity> botIdentitySupplier) {
        this.client = client;
        this.options = options;
        this.normalizer = normalizer;
        this.safetyPipeline = safetyPipeline;
        this.eventBus = eventBus;
        this.botIdentitySupplier = botIdentitySupplier;
    }

    void handleMessage(final P2MessageReceiveV1 event) {
        final NormalizedMessage normalized = normalizeMessage(event);
        pushMessage(normalized, event);
    }

    private void pushMessage(final NormalizedMessage normalized, final Object rawEvent) {
        safetyPipeline.pushMessage(
                normalizer.buildMessageDedupKey(normalized),
                normalized.getChatId(),
                normalized,
                new Runnable() {
                    @Override
                    public void run() {
                        eventBus.emit("message", normalized);
                    }
                },
                new SafetyPipeline.RejectListener() {
                    @Override
                    public void onReject(RejectReason reason, Object raw) {
                        eventBus.emit("reject", new RejectEvent(reason, raw == null ? rawEvent : raw));
                    }
                });
    }

    void handleReactionCreated(P2MessageReactionCreatedV1 event) {
        handleReaction(normalizer.normalizeReaction(event, "added"));
    }

    void handleReactionDeleted(P2MessageReactionDeletedV1 event) {
        handleReaction(normalizer.normalizeReaction(event, "removed"));
    }

    void handleBotAdded(P2ChatMemberBotAddedV1 event) {
        BotAddedEvent normalized = normalizer.normalizeBotAdded(event);
        if (normalized != null) {
            eventBus.emit("botAdded", normalized);
        }
    }

    void handleCardAction(P2CardActionTrigger event) {
        final CardActionEvent normalized = normalizer.normalizeCardAction(event);
        if (normalized == null) {
            return;
        }
        safetyPipeline.pushAction(normalizer.buildCardActionDedupKey(normalized), normalized.getChatId(), new Runnable() {
            @Override
            public void run() {
                eventBus.emit("cardAction", normalized);
            }
        });
    }

    void handleComment(EventReq req) {
        if (req == null || req.getBody() == null) {
            return;
        }
        JsonObject root = JsonParser.parseString(new String(req.getBody(), StandardCharsets.UTF_8)).getAsJsonObject();
        JsonObject payload = root.has("event") && root.get("event").isJsonObject() ? root.getAsJsonObject("event") : root;
        final CommentEvent normalized = normalizer.normalizeComment(payload, options.isIncludeRawInMessage() ? root : payload);
        if (normalized == null) {
            return;
        }
        safetyPipeline.pushAction(normalizer.buildCommentDedupKey(normalized), normalized.getFileToken(), new Runnable() {
            @Override
            public void run() {
                eventBus.emit("comment", normalized);
            }
        });
    }

    private void handleReaction(final ReactionEvent normalized) {
        if (normalized == null) {
            return;
        }
        safetyPipeline.pushLight(normalizer.buildReactionDedupKey(normalized), new Runnable() {
            @Override
            public void run() {
                eventBus.emit("reaction", normalized);
            }
        });
    }

    private NormalizedMessage normalizeMessage(P2MessageReceiveV1 event) {
        return normalizer.normalizeMessage(event, new NormalizeOptions(
                botIdentitySupplier.get(),
                options.isIncludeRawInMessage(),
                true,
                new NormalizeOptions.SubMessageFetcher() {
                    @Override
                    public List<com.lark.oapi.service.im.v1.model.Message> fetch(String messageId) {
                        try {
                            GetMessageResp response = client.im().message().get(GetMessageReq.newBuilder()
                                    .messageId(messageId)
                                    .userIdType("open_id")
                                    .build());
                            return response == null || response.getData() == null || response.getData().getItems() == null
                                    ? Collections.<com.lark.oapi.service.im.v1.model.Message>emptyList()
                                    : java.util.Arrays.asList(response.getData().getItems());
                        } catch (Exception e) {
                            return Collections.emptyList();
                        }
                    }
                },
                null));
    }
}
