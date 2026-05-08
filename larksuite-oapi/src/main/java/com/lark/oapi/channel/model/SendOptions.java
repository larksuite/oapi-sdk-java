package com.lark.oapi.channel.model;

import java.util.Collections;
import java.util.List;

public class SendOptions {
    private final String replyTo;
    private final Boolean replyInThread;
    private final List<String> mentions;

    private SendOptions(Builder builder) {
        this.replyTo = builder.replyTo;
        this.replyInThread = builder.replyInThread;
        this.mentions = builder.mentions == null ? Collections.<String>emptyList() : builder.mentions;
    }

    public static Builder newBuilder() { return new Builder(); }
    public String getReplyTo() { return replyTo; }
    public Boolean getReplyInThread() { return replyInThread; }
    public List<String> getMentions() { return mentions; }

    public static final class Builder {
        private String replyTo;
        private Boolean replyInThread;
        private List<String> mentions;

        public Builder replyTo(String replyTo) { this.replyTo = replyTo; return this; }
        public Builder replyInThread(Boolean replyInThread) { this.replyInThread = replyInThread; return this; }
        public Builder mentions(List<String> mentions) { this.mentions = mentions; return this; }
        public SendOptions build() { return new SendOptions(this); }
    }
}
