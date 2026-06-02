package com.lark.oapi.channel.model;

import java.util.Collections;
import java.util.List;

/**
 * Optional delivery controls for {@code LarkChannel.send(...)} and
 * {@code LarkChannel.stream(...)}.
 */
public class SendOptions {
    private final String replyTo;
    private final Boolean replyInThread;
    private final List<MentionInfo> mentions;

    private SendOptions(Builder builder) {
        this.replyTo = builder.replyTo;
        this.replyInThread = builder.replyInThread;
        this.mentions = builder.mentions == null ? Collections.<MentionInfo>emptyList() : builder.mentions;
    }

    /**
     * Create a builder with default create-message semantics.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Message id to reply to, or {@code null} to create a new message.
     */
    public String getReplyTo() {
        return replyTo;
    }

    /**
     * Whether Feishu should place the reply in the parent message thread.
     */
    public Boolean getReplyInThread() {
        return replyInThread;
    }

    /**
     * Mentions that should be composed into outgoing text/post content.
     */
    public List<MentionInfo> getMentions() {
        return mentions;
    }

    /**
     * Builder for send options.
     */
    public static final class Builder {
        private String replyTo;
        private Boolean replyInThread;
        private List<MentionInfo> mentions;

        /**
         * Reply to an existing message. If Feishu reports that the target
         * message disappeared, the outbound sender falls back to creating a new
         * message in the same chat.
         */
        public Builder replyTo(String replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        /**
         * Set Feishu's reply_in_thread flag for reply messages.
         */
        public Builder replyInThread(Boolean replyInThread) {
            this.replyInThread = replyInThread;
            return this;
        }

        /**
         * Convenience overload for mentioning open_ids.
         */
        public Builder mentions(List<String> mentions) {
            if (mentions == null) {
                this.mentions = null;
                return this;
            }
            java.util.ArrayList<MentionInfo> converted = new java.util.ArrayList<MentionInfo>();
            for (String openId : mentions) {
                if (openId != null && !openId.isEmpty()) {
                    converted.add(new MentionInfo(null, openId, null, null, false));
                }
            }
            this.mentions = converted;
            return this;
        }

        /**
         * Set fully described mention objects.
         */
        public Builder mentionInfos(List<MentionInfo> mentions) {
            this.mentions = mentions;
            return this;
        }

        /**
         * Build immutable send options.
         */
        public SendOptions build() {
            return new SendOptions(this);
        }
    }
}
