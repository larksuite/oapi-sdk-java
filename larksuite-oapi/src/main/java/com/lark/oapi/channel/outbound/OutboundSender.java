package com.lark.oapi.channel.outbound;

import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
import com.lark.oapi.channel.model.SendInput;
import com.lark.oapi.channel.model.SendOptions;
import com.lark.oapi.channel.model.SendResult;
import com.lark.oapi.channel.model.StreamInput;
import com.lark.oapi.channel.outbound.media.MediaUploader;
import com.lark.oapi.channel.outbound.media.UploadResult;
import com.lark.oapi.core.response.BaseResponse;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.cardkit.v1.model.CreateCardReq;
import com.lark.oapi.service.cardkit.v1.model.CreateCardReqBody;
import com.lark.oapi.service.cardkit.v1.model.CreateCardResp;
import com.lark.oapi.service.cardkit.v1.model.IdConvertCardReq;
import com.lark.oapi.service.cardkit.v1.model.IdConvertCardReqBody;
import com.lark.oapi.service.cardkit.v1.model.IdConvertCardResp;
import com.lark.oapi.service.cardkit.v1.model.PatchCardElementReq;
import com.lark.oapi.service.cardkit.v1.model.PatchCardElementReqBody;
import com.lark.oapi.service.cardkit.v1.model.UpdateCardElementReq;
import com.lark.oapi.service.cardkit.v1.model.UpdateCardElementReqBody;
import com.lark.oapi.service.cardkit.v1.model.UpdateCardReq;
import com.lark.oapi.service.cardkit.v1.model.UpdateCardReqBody;
import com.lark.oapi.service.im.v1.model.CreateMessageReactionReq;
import com.lark.oapi.service.im.v1.model.CreateMessageReactionReqBody;
import com.lark.oapi.service.im.v1.model.CreateMessageResp;
import com.lark.oapi.service.im.v1.model.CreateMessageReq;
import com.lark.oapi.service.im.v1.model.CreateMessageReqBody;
import com.lark.oapi.service.im.v1.model.DeleteMessageReactionReq;
import com.lark.oapi.service.im.v1.model.DeleteMessageReq;
import com.lark.oapi.service.im.v1.model.Emoji;
import com.lark.oapi.service.im.v1.model.GetFileReq;
import com.lark.oapi.service.im.v1.model.GetFileResp;
import com.lark.oapi.service.im.v1.model.GetImageReq;
import com.lark.oapi.service.im.v1.model.GetImageResp;
import com.lark.oapi.service.im.v1.model.ListMessageReactionReq;
import com.lark.oapi.service.im.v1.model.ListMessageReactionResp;
import com.lark.oapi.service.im.v1.model.MessageReaction;
import com.lark.oapi.service.im.v1.model.PatchMessageReq;
import com.lark.oapi.service.im.v1.model.PatchMessageReqBody;
import com.lark.oapi.service.im.v1.model.ReplyMessageReq;
import com.lark.oapi.service.im.v1.model.ReplyMessageReqBody;
import com.lark.oapi.service.im.v1.model.UpdateMessageReq;
import com.lark.oapi.service.im.v1.model.UpdateMessageReqBody;
import com.lark.oapi.channel.outbound.markdown.ComposeMentions;
import com.lark.oapi.channel.outbound.markdown.MarkdownPostConverter;
import com.lark.oapi.channel.outbound.markdown.MarkdownSplitter;
import com.lark.oapi.channel.outbound.streaming.CardStreamControllerImpl;
import com.lark.oapi.channel.outbound.streaming.MarkdownStreamControllerImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OutboundSender {
    private static final int DEFAULT_CHUNK_LIMIT = 3500;

    private final Client client;
    private final LarkChannelOptions options;
    private final int chunkLimit;
    private final MediaUploader mediaUploader;

    public OutboundSender(Client client, LarkChannelOptions options) {
        this.client = client;
        this.options = options;
        this.chunkLimit = options == null || options.getOutbound() == null
                ? DEFAULT_CHUNK_LIMIT
                : options.getOutbound().getTextChunkLimit();
        this.mediaUploader = new MediaUploader(client, options == null ? null : options.getOutbound());
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
                return sendSingle(to, idType, "share_chat", input.getObject(), opts);
            case SHARE_USER:
                return sendSingle(to, idType, "share_user", input.getObject(), opts);
            case STICKER:
                return sendSingle(to, idType, "sticker", input.getObject(), opts);
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

    public void editMessage(String messageId, String text) {
        try {
            client.im().message().update(UpdateMessageReq.newBuilder()
                    .messageId(messageId)
                    .updateMessageReqBody(UpdateMessageReqBody.newBuilder()
                            .msgType("text")
                            .content(Jsons.DEFAULT.toJson(Collections.singletonMap("text", text)))
                            .build())
                    .build());
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "editMessage failed");
        }
    }

    public void updateCard(String messageId, Map<String, Object> card) {
        try {
            client.im().message().patch(PatchMessageReq.newBuilder()
                    .messageId(messageId)
                    .patchMessageReqBody(PatchMessageReqBody.newBuilder()
                            .content(Jsons.DEFAULT.toJson(card))
                            .build())
                    .build());
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "updateCard failed");
        }
    }

    public void recallMessage(String messageId) {
        try {
            client.im().message().delete(DeleteMessageReq.newBuilder().messageId(messageId).build());
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "recallMessage failed");
        }
    }

    public byte[] downloadResource(String fileKey, String type) {
        try {
            if ("image".equals(type)) {
                GetImageResp response = client.im().image().get(GetImageReq.newBuilder().imageKey(fileKey).build());
                return consumeDownloadResponse(response);
            }
            if ("file".equals(type)) {
                GetFileResp response = client.im().file().get(GetFileReq.newBuilder().fileKey(fileKey).build());
                return consumeDownloadResponse(response);
            }
            throw new LarkChannelException(LarkChannelErrorCode.UNKNOWN, "unsupported download resource type: " + type);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "downloadResource failed");
        }
    }

    public String addReaction(String messageId, String emojiType) {
        try {
            com.lark.oapi.service.im.v1.model.CreateMessageReactionResp response = client.im().messageReaction().create(
                    CreateMessageReactionReq.newBuilder()
                            .messageId(messageId)
                            .createMessageReactionReqBody(CreateMessageReactionReqBody.newBuilder()
                                    .reactionType(Emoji.newBuilder().emojiType(emojiType).build())
                                    .build())
                            .build());
            String reactionId = response != null && response.getData() != null ? response.getData().getReactionId() : null;
            if (reactionId == null || reactionId.isEmpty()) {
                throw new LarkChannelException(LarkChannelErrorCode.UNKNOWN, "addReaction response has no reaction_id");
            }
            return reactionId;
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "addReaction failed");
        }
    }

    public void removeReaction(String messageId, String reactionId) {
        try {
            client.im().messageReaction().delete(DeleteMessageReactionReq.newBuilder()
                    .messageId(messageId)
                    .reactionId(reactionId)
                    .build());
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "removeReaction failed");
        }
    }

    public boolean removeReactionByEmoji(String messageId, String emojiType) {
        try {
            ListMessageReactionResp response = client.im().messageReaction().list(ListMessageReactionReq.newBuilder()
                    .messageId(messageId)
                    .reactionType(emojiType)
                    .userIdType("open_id")
                    .build());
            if (response == null || response.getData() == null || response.getData().getItems() == null) {
                return false;
            }
            for (MessageReaction reaction : response.getData().getItems()) {
                if (reaction != null && reaction.getOperator() != null
                        && "app".equals(reaction.getOperator().getOperatorType())) {
                    client.im().messageReaction().delete(DeleteMessageReactionReq.newBuilder()
                            .messageId(messageId)
                            .reactionId(reaction.getReactionId())
                            .build());
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "removeReactionByEmoji failed");
        }
    }

    public String sendOneWithFallback(String to, OutboundRouting.ReceiveIdType idType, String msgType, Object content,
                                      SendOptions options) {
        return sendOneWithFallback(new RawSendArgs(to, idType, msgType, content, options.getReplyTo(),
                options.getReplyInThread()));
    }

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
            Map<String, Object> post = MarkdownPostConverter.markdownToPost(chunks.get(i), i == 0 ? options.getMentions() : null);
            ids.add(sendOneWithFallback(new RawSendArgs(to, idType, "post", post,
                    i == 0 ? options.getReplyTo() : null, options.getReplyInThread())));
        }
        return makeResult(ids);
    }

    private SendResult sendPost(String to, OutboundRouting.ReceiveIdType idType, Map<String, Object> post, SendOptions options) {
        Map<String, Object> content = post == null ? Collections.<String, Object>emptyMap() : prependPostMentions(post, options.getMentions());
        return sendSingle(to, idType, "post", content, options);
    }

    private SendResult sendUploadedMedia(String to, OutboundRouting.ReceiveIdType idType, String kind,
                                         Map<String, Object> payload, SendOptions options) {
        if (payload == null) {
            throw new LarkChannelException(LarkChannelErrorCode.UPLOAD_FAILED, "missing media payload");
        }
        Object source = payload.get("source");
        String fileName = asString(payload.get("fileName"));
        Integer duration = asInteger(payload.get("duration"));
        UploadResult uploaded = mediaUploader.upload(kind, source, fileName, duration);
        Map<String, Object> content = new LinkedHashMap<String, Object>();
        if ("image".equals(kind)) {
            content.put("image_key", uploaded.getFileKey());
            return sendSingle(to, idType, "image", content, options);
        }
        content.put("file_key", uploaded.getFileKey());
        if (fileName != null) {
            content.put("file_name", fileName);
        }
        if (uploaded.getDurationMs() != null) {
            content.put("duration", uploaded.getDurationMs());
        }
        if ("video".equals(kind) && payload.get("coverImageKey") != null) {
            content.put("image_key", payload.get("coverImageKey"));
        }
        return sendSingle(to, idType, kind, content, options);
    }

    private SendResult sendCard(String to, OutboundRouting.ReceiveIdType idType, Map<String, Object> card, SendOptions options) {
        return sendSingle(to, idType, "interactive", card, options);
    }

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

    private String sendOneWithFallback(RawSendArgs args) {
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
                if (plainText == null || plainText.isEmpty()) {
                    plainText = "[message]";
                }
                return rawSendWithRetry(new RawSendArgs(args.to, args.idType, "text",
                        Collections.<String, Object>singletonMap("text", plainText), args.replyTo, args.replyInThread));
            }
            throw error;
        }
    }

    private String rawSendWithRetry(final RawSendArgs args) {
        return OutboundRetry.retry(new OutboundRetry.RetryableOperation<String>() {
            @Override
            public String run(int attempt) throws Exception {
                return rawSend(args);
            }
        }, options == null || options.getOutbound() == null ? null : options.getOutbound().getRetry());
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

    public String createCardInstance(Map<String, Object> card) {
        try {
            CreateCardResp response = client.cardkit().v1().card().create(CreateCardReq.newBuilder()
                    .createCardReqBody(CreateCardReqBody.newBuilder()
                            .type("card_json")
                            .data(Jsons.DEFAULT.toJson(card))
                            .build())
                    .build());
            String cardId = response != null && response.getData() != null ? response.getData().getCardId() : null;
            if (cardId == null || cardId.isEmpty()) {
                throw new LarkChannelException(LarkChannelErrorCode.UNKNOWN, "card_id missing from create card response");
            }
            return cardId;
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "createCardInstance failed");
        }
    }

    public String sendCardByReference(String to, OutboundRouting.ReceiveIdType idType, String cardId, SendOptions options) {
        Map<String, Object> ref = new LinkedHashMap<String, Object>();
        ref.put("type", "card");
        ref.put("data", Collections.singletonMap("card_id", cardId));
        return sendOneWithFallback(to, idType, "interactive", ref, options);
    }

    public void updateCardElementContent(String cardId, String elementId, String content, int sequence) {
        try {
            Map<String, Object> element = new LinkedHashMap<String, Object>();
            element.put("tag", "markdown");
            element.put("element_id", elementId);
            element.put("content", content);
            client.cardkit().v1().cardElement().update(UpdateCardElementReq.newBuilder()
                    .cardId(cardId)
                    .elementId(elementId)
                    .updateCardElementReqBody(UpdateCardElementReqBody.newBuilder()
                            .uuid(UUID.randomUUID().toString())
                            .sequence(sequence)
                            .element(Jsons.DEFAULT.toJson(element))
                            .build())
                    .build());
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "updateCardElementContent failed");
        }
    }

    public void finishStreamingCard(String cardId, Map<String, Object> card, int sequence) {
        try {
            client.cardkit().v1().card().update(UpdateCardReq.newBuilder()
                    .cardId(cardId)
                    .updateCardReqBody(UpdateCardReqBody.newBuilder()
                            .uuid(UUID.randomUUID().toString())
                            .sequence(sequence)
                            .card(com.lark.oapi.service.cardkit.v1.model.Card.newBuilder()
                                    .type("card_json")
                                    .data(Jsons.DEFAULT.toJson(card))
                                    .build())
                            .build())
                    .build());
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "finishStreamingCard failed");
        }
    }

    public void patchCard(String messageId, Map<String, Object> card) {
        updateCard(messageId, card);
    }

    public String resolveCardId(String messageId) {
        try {
            IdConvertCardResp response = client.cardkit().v1().card().idConvert(IdConvertCardReq.newBuilder()
                    .idConvertCardReqBody(IdConvertCardReqBody.newBuilder().messageId(messageId).build())
                    .build());
            return response != null && response.getData() != null ? response.getData().getCardId() : null;
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "resolveCardId failed");
        }
    }

    private Map<String, Object> prependPostMentions(Map<String, Object> post, List<String> mentions) {
        if (mentions == null || mentions.isEmpty() || post == null) {
            return post;
        }
        Object localeObject = post.get("zh_cn");
        if (!(localeObject instanceof Map)) {
            return post;
        }
        Map<String, Object> cloned = new LinkedHashMap<String, Object>(post);
        Map<String, Object> locale = new LinkedHashMap<String, Object>((Map<String, Object>) localeObject);
        Object contentObject = locale.get("content");
        List<Object> content = new ArrayList<Object>();
        if (contentObject instanceof List) {
            content.addAll((List<?>) contentObject);
        }
        List<Map<String, Object>> mentionParagraph = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> mention : ComposeMentions.composePostMentionElements(mentions)) {
            mentionParagraph.add(mention);
            mentionParagraph.add(textElement(" "));
        }
        if (!mentionParagraph.isEmpty()) {
            content.add(0, mentionParagraph);
        }
        locale.put("content", content);
        cloned.put("zh_cn", locale);
        return cloned;
    }

    private Map<String, Object> textElement(String value) {
        Map<String, Object> element = new LinkedHashMap<String, Object>();
        element.put("tag", "text");
        element.put("text", value);
        return element;
    }

    public int getStreamThrottleMs() {
        return options == null || options.getOutbound() == null ? 100 : options.getOutbound().getStreamThrottleMs();
    }

    public int getStreamThrottleChars() {
        return options == null || options.getOutbound() == null ? 50 : options.getOutbound().getStreamThrottleChars();
    }

    public String getStreamInitialText() {
        return options == null || options.getOutbound() == null ? "Thinking..." : options.getOutbound().getStreamInitialText();
    }

    public String toJson(Object value) {
        return Jsons.DEFAULT.toJson(value);
    }

    public RuntimeException wrapStreamingException(String message, Exception e) {
        return OutboundErrors.classifyError(e, message);
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

    private byte[] consumeDownloadResponse(BaseResponse<?> response) {
        if (response == null) {
            throw new LarkChannelException(LarkChannelErrorCode.UNKNOWN, "unexpected download response type: null");
        }
        byte[] extracted = extractBytes(response.getData());
        if (extracted != null) {
            return extracted;
        }
        RawResponse rawResponse = response.getRawResponse();
        if (rawResponse != null && rawResponse.getBody() != null && rawResponse.getBody().length > 0) {
            return rawResponse.getBody();
        }
        Object data = response.getData();
        throw new LarkChannelException(LarkChannelErrorCode.UNKNOWN,
                "unexpected download response type: " + (data == null ? "null" : data.getClass().getName()));
    }

    private byte[] extractBytes(Object data) {
        if (data == null) {
            return null;
        }
        if (data instanceof ByteArrayOutputStream) {
            return ((ByteArrayOutputStream) data).toByteArray();
        }
        if (data instanceof byte[]) {
            return (byte[]) data;
        }
        if (data instanceof InputStream) {
            return readAll((InputStream) data);
        }
        if (data instanceof Map) {
            return extractBytes(((Map<?, ?>) data).get("data"));
        }
        try {
            Method method = data.getClass().getMethod("toByteArray");
            return extractBytes(method.invoke(data));
        } catch (Exception ignored) {
        }
        try {
            Method method = data.getClass().getMethod("getData");
            Object value = method.invoke(data);
            if (value != data) {
                return extractBytes(value);
            }
        } catch (Exception ignored) {
        }
        try {
            Method method = data.getClass().getMethod("getReadableStream");
            Object value = method.invoke(data);
            if (value instanceof InputStream) {
                return readAll((InputStream) value);
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    private byte[] readAll(InputStream inputStream) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int read;
            while ((read = inputStream.read(buffer)) >= 0) {
                outputStream.write(buffer, 0, read);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new LarkChannelException(LarkChannelErrorCode.UNKNOWN, "failed to read download stream", null, e);
        }
    }

    private static final class RawSendArgs {
        private final String to;
        private final OutboundRouting.ReceiveIdType idType;
        private final String msgType;
        private final Object content;
        private final String replyTo;
        private final Boolean replyInThread;

        private RawSendArgs(String to, OutboundRouting.ReceiveIdType idType, String msgType, Object content,
                            String replyTo, Boolean replyInThread) {
            this.to = to;
            this.idType = idType;
            this.msgType = msgType;
            this.content = content;
            this.replyTo = replyTo;
            this.replyInThread = replyInThread;
        }
    }
}
