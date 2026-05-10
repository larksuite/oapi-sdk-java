package com.lark.oapi.channel.outbound;

import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
import com.lark.oapi.channel.model.SendInput;
import com.lark.oapi.channel.model.SendOptions;
import com.lark.oapi.channel.model.SendResult;
import com.lark.oapi.channel.model.StreamInput;
import com.lark.oapi.channel.outbound.markdown.ComposeMentions;
import com.lark.oapi.channel.outbound.markdown.MarkdownPostConverter;
import com.lark.oapi.channel.outbound.markdown.MarkdownSplitter;
import com.lark.oapi.channel.outbound.media.MediaUploader;
import com.lark.oapi.channel.outbound.media.UploadResult;
import com.lark.oapi.channel.outbound.streaming.CardStreamControllerImpl;
import com.lark.oapi.channel.outbound.streaming.MarkdownStreamControllerImpl;
import com.lark.oapi.core.utils.Jsons;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutboundSender {
    private static final int DEFAULT_CHUNK_LIMIT = 3500;

    public final MediaUploader uploader;
    private final LarkChannelOptions.OutboundConfig config;
    private final int chunkLimit;
    private final RawMessageSender raw;
    private final OutboundLowLevelApi lowLevel;

    public OutboundSender(Client client, LarkChannelOptions options) {
        this.config = options == null ? null : options.getOutbound();
        this.chunkLimit = options == null || options.getOutbound() == null
                ? DEFAULT_CHUNK_LIMIT
                : options.getOutbound().getTextChunkLimit();
        this.uploader = new MediaUploader(client, config);
        this.raw = new RawMessageSender(client, config);
        this.lowLevel = new OutboundLowLevelApi(client);
    }

    public SendResult send(String to, SendInput input, SendOptions sendOptions) {
        SendOptions opts = sendOptions == null ? SendOptions.newBuilder().build() : sendOptions;
        OutboundRouting.ReceiveIdType idType = OutboundRouting.detectReceiveIdType(to);
        switch (input.getKind()) {
            case TEXT:
                return sendText(to, idType, input.getText(), opts);
            case MARKDOWN:
                return sendMarkdown(to, idType, input.getText(), opts);
            case POST:
                return sendPost(to, idType, input.getObject(), opts);
            case IMAGE:
                return sendUploadedMedia(to, idType, "image", input.getObject(), opts);
            case FILE:
                return sendUploadedMedia(to, idType, "file", input.getObject(), opts);
            case AUDIO:
                return sendUploadedMedia(to, idType, "audio", input.getObject(), opts);
            case VIDEO:
                return sendUploadedMedia(to, idType, "video", input.getObject(), opts);
            case CARD:
                return sendCard(to, idType, input.getObject(), opts);
            case SHARE_CHAT:
                return sendShareChat(to, idType, asString(input.getObject().get("chat_id")), opts);
            case SHARE_USER:
                return sendShareUser(to, idType, asString(input.getObject().get("user_id")), opts);
            case STICKER:
                return sendSticker(to, idType, asString(input.getObject().get("file_key")), opts);
            default:
                throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED,
                        "send type not implemented yet: " + input.getKind());
        }
    }

    public SendResult stream(String to, StreamInput input, SendOptions sendOptions) {
        SendOptions opts = sendOptions == null ? SendOptions.newBuilder().build() : sendOptions;
        OutboundRouting.ReceiveIdType idType = OutboundRouting.detectReceiveIdType(to);
        if (input.getKind() == StreamInput.Kind.MARKDOWN) {
            return new MarkdownStreamControllerImpl(this, to, idType, opts).run(input.getMarkdownProducer());
        }
        return new CardStreamControllerImpl(this, to, idType, opts, input.getInitialCard()).run(input.getCardProducer());
    }

    // text / markdown / post

    private SendResult sendText(String to, OutboundRouting.ReceiveIdType idType, String text, SendOptions options) {
        String prefix = ComposeMentions.composeMentionsTextPrefix(options.getMentions());
        List<String> chunks = MarkdownSplitter.splitPlain(prefix + (text == null ? "" : text), chunkLimit);
        List<String> ids = new ArrayList<String>();
        for (int i = 0; i < chunks.size(); i++) {
            ids.add(sendOneWithFallback(new RawSendArgs(to, idType, "text",
                    Collections.<String, Object>singletonMap("text", chunks.get(i)),
                    i == 0 ? options.getReplyTo() : null, options.getReplyInThread())));
        }
        return makeResult(ids);
    }

    private SendResult sendMarkdown(String to, OutboundRouting.ReceiveIdType idType, String markdown, SendOptions options) {
        List<String> chunks = MarkdownSplitter.splitWithCodeFences(markdown == null ? "" : markdown, chunkLimit);
        List<String> ids = new ArrayList<String>();
        for (int i = 0; i < chunks.size(); i++) {
            Map<String, Object> post = convertMarkdown(chunks.get(i), i == 0 ? options.getMentions() : null);
            ids.add(sendOneWithFallback(new RawSendArgs(to, idType, "post", post,
                    i == 0 ? options.getReplyTo() : null, options.getReplyInThread())));
        }
        return makeResult(ids);
    }

    private SendResult sendPost(String to, OutboundRouting.ReceiveIdType idType, Map<String, Object> post, SendOptions options) {
        Map<String, Object> content = post == null ? Collections.<String, Object>emptyMap() : post;
        return sendSingle(to, idType, "post", content, options);
    }

    private Map<String, Object> convertMarkdown(String markdown, List<com.lark.oapi.channel.model.MentionInfo> mentions) {
        return MarkdownPostConverter.markdownToPost(markdown, mentions);
    }

    // media

    private SendResult sendUploadedMedia(String to, OutboundRouting.ReceiveIdType idType, String kind,
                                         Map<String, Object> payload, SendOptions options) {
        if (payload == null) {
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED, "missing media payload");
        }
        Object source = payload.get("source");
        String fileName = asString(payload.get("fileName"));
        Integer duration = asInteger(payload.get("duration"));
        UploadResult uploaded = uploader.upload(kind, source, fileName, duration);
        Map<String, Object> content = new java.util.LinkedHashMap<String, Object>();
        if ("image".equals(kind)) {
            content.put("image_key", uploaded.getFileKey());
            return sendSingle(to, idType, "image", content, options);
        }
        content.put("file_key", uploaded.getFileKey());
        if ("file".equals(kind) && fileName != null) {
            content.put("file_name", fileName);
        }
        if (uploaded.getDurationMs() != null) {
            content.put("duration", uploaded.getDurationMs());
        }
        if ("video".equals(kind) && payload.get("coverImageKey") != null) {
            content.put("image_key", payload.get("coverImageKey"));
        }
        String msgType = "video".equals(kind) ? "media" : kind;
        return sendSingle(to, idType, msgType, content, options);
    }

    // card

    private SendResult sendCard(String to, OutboundRouting.ReceiveIdType idType, Map<String, Object> card, SendOptions options) {
        return sendSingle(to, idType, "interactive", card, options);
    }

    // share / sticker

    private SendResult sendShareChat(String to, OutboundRouting.ReceiveIdType idType, String chatId, SendOptions options) {
        return sendSingle(to, idType, "share_chat", Collections.singletonMap("chat_id", chatId), options);
    }

    private SendResult sendShareUser(String to, OutboundRouting.ReceiveIdType idType, String userId, SendOptions options) {
        return sendSingle(to, idType, "share_user", Collections.singletonMap("user_id", userId), options);
    }

    private SendResult sendSticker(String to, OutboundRouting.ReceiveIdType idType, String fileKey, SendOptions options) {
        return sendSingle(to, idType, "sticker", Collections.singletonMap("file_key", fileKey), options);
    }

    // low-level raw send with fallback & retry

    private SendResult sendSingle(String to, OutboundRouting.ReceiveIdType idType, String msgType, Object content,
                                  SendOptions options) {
        return new SendResult(sendOneWithFallback(to, idType, msgType, content, options));
    }

    private SendResult makeResult(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return new SendResult(null);
        }
        return new SendResult(ids.get(0), ids);
    }

    public String sendOneWithFallback(RawSendArgs args) {
        return raw.sendOneWithFallback(args);
    }

    public String sendOneWithFallback(String to, OutboundRouting.ReceiveIdType idType, String msgType, Object content,
                                      SendOptions options) {
        return sendOneWithFallback(new RawSendArgs(to, idType, msgType, content, options.getReplyTo(),
                options.getReplyInThread()));
    }

    public String rawSendWithRetry(RawSendArgs args) {
        return raw.rawSendWithRetry(args);
    }

    // helpers used by streaming

    public String createCardInstance(Map<String, Object> card) {
        return raw.createCardInstance(card);
    }

    public String sendCardByReference(String to, OutboundRouting.ReceiveIdType idType, String cardId, SendOptions options) {
        return raw.sendCardByReference(to, idType, cardId, options);
    }

    public void updateCardElementContent(String cardId, String elementId, String content, int sequence) {
        raw.updateCardElementContent(cardId, elementId, content, sequence);
    }

    public void finishStreamingCard(String cardId, Map<String, Object> card, int sequence) {
        raw.finishStreamingCard(cardId, card, sequence);
    }

    public void patchCard(String messageId, Map<String, Object> card) {
        raw.patchCard(messageId, card);
    }

    public String resolveCardId(String messageId) {
        return raw.resolveCardId(messageId);
    }

    public int getStreamThrottleMs() {
        return config == null ? 100 : config.getStreamThrottleMs();
    }

    public int getStreamThrottleChars() {
        return config == null ? 50 : config.getStreamThrottleChars();
    }

    public String getStreamInitialText() {
        return config == null ? "Thinking..." : config.getStreamInitialText();
    }

    public String toJson(Object value) {
        return Jsons.DEFAULT.toJson(value);
    }

    public RuntimeException wrapStreamingException(String message, Exception e) {
        return OutboundErrors.classifyError(e, message);
    }

    // low-level public helpers

    public void editMessage(String messageId, String text) {
        lowLevel.editMessage(messageId, text);
    }

    public void updateCard(String messageId, Map<String, Object> card) {
        lowLevel.updateCard(messageId, card);
    }

    public void recallMessage(String messageId) {
        lowLevel.recallMessage(messageId);
    }

    public byte[] downloadResource(String fileKey, String type) {
        return lowLevel.downloadResource(fileKey, type);
    }

    public String addReaction(String messageId, String emojiType) {
        return lowLevel.addReaction(messageId, emojiType);
    }

    public void removeReaction(String messageId, String reactionId) {
        lowLevel.removeReaction(messageId, reactionId);
    }

    public boolean removeReactionByEmoji(String messageId, String emojiType) {
        return lowLevel.removeReactionByEmoji(messageId, emojiType);
    }

    private String asString(Object value) {
        return value == null ? null : String.valueOf(value);
    }

    private Integer asInteger(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        try {
            return Integer.valueOf(String.valueOf(value));
        } catch (Exception ignored) {
            return null;
        }
    }

}
