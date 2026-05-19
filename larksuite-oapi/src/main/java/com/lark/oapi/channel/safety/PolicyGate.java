package com.lark.oapi.channel.safety;

import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.channel.model.NormalizedMessage;
import com.lark.oapi.channel.model.RejectReason;

public class PolicyGate {
    private final LarkChannelOptions.PolicyConfig policy;
    private volatile BotIdentity botIdentity;

    public PolicyGate(LarkChannelOptions.PolicyConfig policy) {
        this.policy = policy;
    }

    public BotIdentity getBotIdentity() {
        return botIdentity;
    }

    public void setBotIdentity(BotIdentity botIdentity) {
        this.botIdentity = botIdentity;
    }

    public RejectReason evaluate(NormalizedMessage message) {
        if (message == null || policy == null) {
            return null;
        }
        if ("group".equals(message.getChatType()) || "topic_group".equals(message.getChatType())) {
            System.err.println("[ChannelMentionDebug] policy messageId=" + message.getMessageId()
                    + ", chatType=" + message.getChatType()
                    + ", content=" + message.getContent()
                    + ", mentionAll=" + message.isMentionAll()
                    + ", mentionedBot=" + message.isMentionedBot()
                    + ", requireMention=" + policy.isRequireMention()
                    + ", respondToMentionAll=" + policy.isRespondToMentionAll());
            if (!policy.getGroupAllowlist().isEmpty() && !policy.getGroupAllowlist().contains(message.getChatId())) {
                return RejectReason.GROUP_NOT_ALLOWED;
            }
            if (message.isMentionAll()) {
                return policy.isRespondToMentionAll() ? null : RejectReason.MENTION_ALL_BLOCKED;
            }
            if (policy.isRequireMention() && !message.isMentionedBot()) {
                return RejectReason.NO_MENTION;
            }
            return null;
        }
        String dmMode = policy.getDmMode();
        if ("disabled".equals(dmMode)) {
            return RejectReason.DM_DISABLED;
        }
        if ("allowlist".equals(dmMode) && !policy.getDmAllowlist().contains(message.getSenderId())) {
            return RejectReason.SENDER_NOT_ALLOWED;
        }
        return null;
    }
}
