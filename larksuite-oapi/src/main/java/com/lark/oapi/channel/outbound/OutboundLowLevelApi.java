package com.lark.oapi.channel.outbound;

import com.lark.oapi.Client;
import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
import com.lark.oapi.core.response.BaseResponse;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.CreateMessageReactionReq;
import com.lark.oapi.service.im.v1.model.CreateMessageReactionReqBody;
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
import com.lark.oapi.service.im.v1.model.UpdateMessageReq;
import com.lark.oapi.service.im.v1.model.UpdateMessageReqBody;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

class OutboundLowLevelApi {
    private final Client client;

    OutboundLowLevelApi(Client client) {
        this.client = client;
    }

    void editMessage(String messageId, String text) {
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

    void updateCard(String messageId, Map<String, Object> card) {
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

    void recallMessage(String messageId) {
        try {
            client.im().message().delete(DeleteMessageReq.newBuilder().messageId(messageId).build());
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "recallMessage failed");
        }
    }

    byte[] downloadResource(String fileKey, String type) {
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

    String addReaction(String messageId, String emojiType) {
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

    void removeReaction(String messageId, String reactionId) {
        try {
            client.im().messageReaction().delete(DeleteMessageReactionReq.newBuilder()
                    .messageId(messageId)
                    .reactionId(reactionId)
                    .build());
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "removeReaction failed");
        }
    }

    boolean removeReactionByEmoji(String messageId, String emojiType) {
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
}
