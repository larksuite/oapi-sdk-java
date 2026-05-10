package com.lark.oapi.channel.outbound;

import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
import com.lark.oapi.channel.model.SendOptions;
import com.lark.oapi.channel.outbound.markdown.MarkdownPostConverter;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.cardkit.v1.model.CreateCardReq;
import com.lark.oapi.service.cardkit.v1.model.CreateCardReqBody;
import com.lark.oapi.service.cardkit.v1.model.CreateCardResp;
import com.lark.oapi.service.cardkit.v1.model.IdConvertCardReq;
import com.lark.oapi.service.cardkit.v1.model.IdConvertCardReqBody;
import com.lark.oapi.service.cardkit.v1.model.IdConvertCardResp;
import com.lark.oapi.service.cardkit.v1.model.PatchCardElementReq;
import com.lark.oapi.service.cardkit.v1.model.PatchCardElementReqBody;
import com.lark.oapi.service.cardkit.v1.model.SettingsCardReq;
import com.lark.oapi.service.cardkit.v1.model.SettingsCardReqBody;
import com.lark.oapi.service.im.v1.model.CreateMessageReq;
import com.lark.oapi.service.im.v1.model.CreateMessageReqBody;
import com.lark.oapi.service.im.v1.model.CreateMessageResp;
import com.lark.oapi.service.im.v1.model.PatchMessageReq;
import com.lark.oapi.service.im.v1.model.PatchMessageReqBody;
import com.lark.oapi.service.im.v1.model.ReplyMessageReq;
import com.lark.oapi.service.im.v1.model.ReplyMessageReqBody;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

class RawMessageSender {
    private final Client client;
    private final LarkChannelOptions.OutboundConfig config;

    RawMessageSender(Client client, LarkChannelOptions.OutboundConfig config) {
        this.client = client;
        this.config = config;
    }

    /**
     * Send once with fallback for format errors (post -> text) and for
     * vanished reply targets (reply -> create).
     */
    String sendOneWithFallback(RawSendArgs args) {
        try {
            return rawSendWithRetry(args);
        } catch (Exception e) {
            LarkChannelException error = OutboundErrors.classifyError(e, "send failed");
            if (OutboundErrors.isReplyTargetGone(error) && args.replyTo != null) {
                return rawSendWithRetry(new RawSendArgs(args.to, args.idType, args.msgType, args.content, null,
                        args.replyInThread));
            }
            if (OutboundErrors.isFormatError(error) && "post".equals(args.msgType)) {
                String plainText = MarkdownPostConverter.postToPlainText(args.content);
                if (plainText.isEmpty()) {
                    plainText = "[message]";
                }
                return rawSendWithRetry(new RawSendArgs(args.to, args.idType, "text",
                        Collections.<String, Object>singletonMap("text", plainText), args.replyTo, args.replyInThread));
            }
            throw error;
        }
    }

    String rawSendWithRetry(RawSendArgs args) {
        return OutboundRetry.retry(attempt -> rawSend(args), config == null ? null : config.getRetry());
    }

    private String rawSend(RawSendArgs args) throws Exception {
        String contentJson = Jsons.DEFAULT.toJson(args.content);
        if (args.replyTo != null) {
            com.lark.oapi.service.im.v1.model.ReplyMessageResp response = client.im().message().reply(
                    ReplyMessageReq.newBuilder()
                            .messageId(args.replyTo)
                            .replyMessageReqBody(ReplyMessageReqBody.newBuilder()
                                    .msgType(args.msgType)
                                    .content(contentJson)
                                    .replyInThread(args.replyInThread)
                                    .uuid(UUID.randomUUID().toString())
                                    .build())
                            .build());
            String messageId = response != null && response.getData() != null ? response.getData().getMessageId() : null;
            if (messageId == null || messageId.isEmpty()) {
                throw new LarkChannelException(LarkChannelErrorCode.UNKNOWN, "message_id missing from reply response");
            }
            return messageId;
        }

        CreateMessageResp response = client.im().message().create(
                CreateMessageReq.newBuilder()
                        .receiveIdType(args.idType.getValue())
                        .createMessageReqBody(CreateMessageReqBody.newBuilder()
                                .receiveId(args.to)
                                .msgType(args.msgType)
                                .content(contentJson)
                                .uuid(UUID.randomUUID().toString())
                                .build())
                        .build());
        String messageId = response != null && response.getData() != null ? response.getData().getMessageId() : null;
        if (messageId == null || messageId.isEmpty()) {
            throw new LarkChannelException(LarkChannelErrorCode.UNKNOWN, "message_id missing from create response");
        }
        return messageId;
    }

    void patchCard(String messageId, Map<String, Object> card) {
        try {
            client.im().message().patch(PatchMessageReq.newBuilder()
                    .messageId(messageId)
                    .patchMessageReqBody(PatchMessageReqBody.newBuilder()
                            .content(Jsons.DEFAULT.toJson(card))
                            .build())
                    .build());
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "patchCard failed");
        }
    }

    /**
     * Create a card instance via cardkit.v1.card.create. Used to get a card_id
     * that can be referenced from messages and updated with native streaming APIs.
     */
    String createCardInstance(Map<String, Object> card) {
        try {
            CreateCardResp response = client.cardkit().v1().card().create(CreateCardReq.newBuilder()
                    .createCardReqBody(CreateCardReqBody.newBuilder()
                            .type("card_json")
                            .data(Jsons.DEFAULT.toJson(card))
                            .build())
                    .build());
            if (response == null) {
                throw new LarkChannelException(LarkChannelErrorCode.UNKNOWN, "create card returned null response");
            }
            if (!response.success()) {
                throw new LarkChannelException(LarkChannelErrorCode.UNKNOWN,
                        "create card failed: code=" + response.getCode() + ", msg=" + response.getMsg());
            }
            String cardId = response.getData() != null ? response.getData().getCardId() : null;
            if (cardId == null || cardId.isEmpty()) {
                throw new LarkChannelException(LarkChannelErrorCode.UNKNOWN, "card_id missing from create card response");
            }
            return cardId;
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "createCardInstance failed");
        }
    }

    /**
     * Send an interactive message that references a pre-created card instance by card_id.
     */
    String sendCardByReference(String to, OutboundRouting.ReceiveIdType idType, String cardId, SendOptions options) {
        Map<String, Object> ref = new LinkedHashMap<>();
        ref.put("type", "card");
        ref.put("data", Collections.singletonMap("card_id", cardId));
        return rawSendWithRetry(new RawSendArgs(to, idType, "interactive", ref,
                options.getReplyTo(), options.getReplyInThread()));
    }

    /**
     * Stream update: replace a card element's content. Sequence must be monotonically increasing.
     */
    void updateCardElementContent(String cardId, String elementId, String content, int sequence) {
        try {
            Map<String, Object> partial = new LinkedHashMap<>();
            partial.put("content", content);
            client.cardkit().v1().cardElement().patch(PatchCardElementReq.newBuilder()
                    .cardId(cardId)
                    .elementId(elementId)
                    .patchCardElementReqBody(PatchCardElementReqBody.newBuilder()
                            .uuid(UUID.randomUUID().toString())
                            .sequence(sequence)
                            .partialElement(Jsons.DEFAULT.toJson(partial))
                            .build())
                    .build());
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "updateCardElementContent failed");
        }
    }

    /**
     * Switch a streaming card to finalized state.
     */
    void finishStreamingCard(String cardId, Map<String, Object> card, int sequence) {
        try {
            Object configObject = card == null ? null : card.get("config");
            Map<String, Object> settings = new LinkedHashMap<>();
            settings.put("config", configObject == null ? Collections.<String, Object>emptyMap() : configObject);
            client.cardkit().v1().card().settings(SettingsCardReq.newBuilder()
                    .cardId(cardId)
                    .settingsCardReqBody(SettingsCardReqBody.newBuilder()
                            .uuid(UUID.randomUUID().toString())
                            .sequence(sequence)
                            .settings(Jsons.DEFAULT.toJson(settings))
                            .build())
                    .build());
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "finishStreamingCard failed");
        }
    }

    String resolveCardId(String messageId) {
        try {
            IdConvertCardResp response = client.cardkit().v1().card().idConvert(IdConvertCardReq.newBuilder()
                    .idConvertCardReqBody(IdConvertCardReqBody.newBuilder().messageId(messageId).build())
                    .build());
            return response != null && response.getData() != null ? response.getData().getCardId() : null;
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "resolveCardId failed");
        }
    }
}
