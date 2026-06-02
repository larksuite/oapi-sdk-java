package com.lark.oapi.channel;

import com.lark.oapi.Client;
import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
import com.lark.oapi.channel.model.ChatInfo;
import com.lark.oapi.channel.outbound.OutboundErrors;
import com.lark.oapi.channel.outbound.OutboundSender;
import com.lark.oapi.service.im.v1.model.GetChatReq;
import com.lark.oapi.service.im.v1.model.GetChatResp;

import java.util.Map;

final class ChannelLowLevelApi {
    private final Client client;
    private final OutboundSender outboundSender;

    ChannelLowLevelApi(Client client, OutboundSender outboundSender) {
        this.client = client;
        this.outboundSender = outboundSender;
    }

    void editMessage(String messageId, String text) {
        outboundSender.editMessage(messageId, text);
    }

    void updateCard(String messageId, Map<String, Object> card) {
        outboundSender.updateCard(messageId, card);
    }

    void recallMessage(String messageId) {
        outboundSender.recallMessage(messageId);
    }

    byte[] downloadResource(String fileKey, String type) {
        return outboundSender.downloadResource(fileKey, type);
    }

    String addReaction(String messageId, String emojiType) {
        return outboundSender.addReaction(messageId, emojiType);
    }

    void removeReaction(String messageId, String reactionId) {
        outboundSender.removeReaction(messageId, reactionId);
    }

    boolean removeReactionByEmoji(String messageId, String emojiType) {
        return outboundSender.removeReactionByEmoji(messageId, emojiType);
    }

    ChatInfo getChatInfo(String chatId) {
        try {
            GetChatResp resp = client.im().chat().get(GetChatReq.newBuilder()
                    .chatId(chatId)
                    .userIdType("open_id")
                    .build());
            if (resp == null || resp.getData() == null) {
                throw new LarkChannelException(LarkChannelErrorCode.UNKNOWN, "getChatInfo response has no data");
            }
            return new ChatInfo(
                    chatId,
                    resp.getData().getName(),
                    resp.getData().getDescription(),
                    resp.getData().getChatMode(),
                    resp.getData().getOwnerId(),
                    parseInteger(resp.getData().getUserCount()));
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw OutboundErrors.classifyError(e, "getChatInfo failed");
        }
    }

    private Integer parseInteger(String value) {
        try {
            return value == null ? null : Integer.valueOf(value);
        } catch (Exception ignored) {
            return null;
        }
    }
}
