package com.lark.oapi.channel.normalize;

import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.service.im.v1.model.Message;
import java.util.List;

public class NormalizeOptions {
    public interface SubMessageFetcher {
        List<Message> fetch(String messageId);
    }

    public interface SenderNameResolver {
        String resolve(String senderId);
    }

    private final BotIdentity botIdentity;
    private final boolean includeRawInMessage;
    private final boolean stripBotMentions;
    private final SubMessageFetcher subMessageFetcher;
    private final SenderNameResolver senderNameResolver;

    public NormalizeOptions(BotIdentity botIdentity, boolean includeRawInMessage, boolean stripBotMentions) {
        this(botIdentity, includeRawInMessage, stripBotMentions, null, null);
    }

    public NormalizeOptions(BotIdentity botIdentity, boolean includeRawInMessage, boolean stripBotMentions,
                            SubMessageFetcher subMessageFetcher, SenderNameResolver senderNameResolver) {
        this.botIdentity = botIdentity;
        this.includeRawInMessage = includeRawInMessage;
        this.stripBotMentions = stripBotMentions;
        this.subMessageFetcher = subMessageFetcher;
        this.senderNameResolver = senderNameResolver;
    }

    public BotIdentity getBotIdentity() {
        return botIdentity;
    }

    public boolean isIncludeRawInMessage() {
        return includeRawInMessage;
    }

    public boolean isStripBotMentions() {
        return stripBotMentions;
    }

    public SubMessageFetcher getSubMessageFetcher() {
        return subMessageFetcher;
    }

    public SenderNameResolver getSenderNameResolver() {
        return senderNameResolver;
    }
}
