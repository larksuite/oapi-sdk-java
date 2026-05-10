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
import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
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

    void handleMessage(P2MessageReceiveV1 event) {
        try {
            NormalizedMessage normalized = normalizeMessage(event);
            if (normalized != null) {
                pushMessage(normalized);
            }
        } catch (Throwable error) {
            eventBus.emitError("message", error, event);
        }
    }

    private void pushMessage(NormalizedMessage normalized) {
        safetyPipeline.pushMessage(normalized);
    }

    void handleReactionCreated(P2MessageReactionCreatedV1 event) {
        try {
            handleReaction(normalizer.normalizeReaction(event, "added"));
        } catch (Throwable error) {
            eventBus.emitError("reaction", error, event);
        }
    }

    void handleReactionDeleted(P2MessageReactionDeletedV1 event) {
        try {
            handleReaction(normalizer.normalizeReaction(event, "removed"));
        } catch (Throwable error) {
            eventBus.emitError("reaction", error, event);
        }
    }

    void handleBotAdded(P2ChatMemberBotAddedV1 event) {
        try {
            BotAddedEvent normalized = normalizer.normalizeBotAdded(event);
            if (normalized != null) {
                eventBus.emit("botAdded", normalized);
            }
        } catch (Throwable error) {
            eventBus.emitError("botAdded", error, event);
        }
    }

    void handleCardAction(P2CardActionTrigger event) {
        try {
            CardActionEvent normalized = normalizer.normalizeCardAction(event);
            if (normalized == null) {
                return;
            }
            safetyPipeline.pushAction(normalizer.buildCardActionDedupKey(normalized), normalized.getChatId(),
                    () -> eventBus.emit("cardAction", normalized));
        } catch (Throwable error) {
            eventBus.emitError("cardAction", error, event);
        }
    }

    void handleComment(EventReq req) {
        try {
            if (req == null || req.getBody() == null) {
                return;
            }
            JsonObject root = JsonParser.parseString(new String(req.getBody(), StandardCharsets.UTF_8)).getAsJsonObject();
            JsonObject payload = root.has("event") && root.get("event").isJsonObject() ? root.getAsJsonObject("event") : root;
            CommentEvent normalized = normalizer.normalizeComment(payload, options.isIncludeRawInMessage() ? root : payload);
            if (normalized == null) {
                return;
            }
            safetyPipeline.pushAction(normalizer.buildCommentDedupKey(normalized), normalized.getFileToken(),
                    () -> eventBus.emit("comment", normalized));
        } catch (Throwable error) {
            eventBus.emitError("comment", error, req);
        }
    }

    private void handleReaction(ReactionEvent normalized) {
        if (normalized == null) {
            return;
        }
        safetyPipeline.pushLight(normalizer.buildReactionDedupKey(normalized),
                () -> eventBus.emit("reaction", normalized));
    }

    private NormalizedMessage normalizeMessage(P2MessageReceiveV1 event) {
        BotIdentity botIdentity = botIdentitySupplier.get();
        if (botIdentity == null) {
            throw new LarkChannelException(LarkChannelErrorCode.NOT_CONNECTED,
                    "channel must connect before processing inbound message events");
        }
        return normalizer.normalizeMessage(event, new NormalizeOptions(
                botIdentity,
                options.isIncludeRawInMessage(),
                true,
                messageId -> {
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
                },
                null));
    }
}
