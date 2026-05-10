package com.lark.oapi.channel.normalize;

import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.service.im.v1.model.Message;
import java.util.List;

public class NormalizeOptions {
    public interface SubMessageFetcher {
        List<Message> fetch(String messageId);
    }

    public interface UserNameResolver {
        String resolve(String senderId);
    }

    public interface SenderNameResolver extends UserNameResolver {
    }

    public interface BatchResolveNames {
        void resolve(List<String> openIds);
    }

    private final BotIdentity botIdentity;
    private final boolean includeRawInMessage;
    private final boolean stripBotMentions;
    private final SubMessageFetcher subMessageFetcher;
    private final UserNameResolver resolveUserName;
    private final UserNameResolver resolveSenderName;
    private final BatchResolveNames batchResolveNames;

    public NormalizeOptions(BotIdentity botIdentity, boolean includeRawInMessage, boolean stripBotMentions) {
        this(botIdentity, includeRawInMessage, stripBotMentions, null, null);
    }

    public NormalizeOptions(BotIdentity botIdentity, boolean includeRawInMessage, boolean stripBotMentions,
                            SubMessageFetcher subMessageFetcher, SenderNameResolver senderNameResolver) {
        this(botIdentity, includeRawInMessage, stripBotMentions, subMessageFetcher,
                senderNameResolver, senderNameResolver, null);
    }

    public NormalizeOptions(BotIdentity botIdentity, boolean includeRaw, boolean stripBotMentions,
                            SubMessageFetcher fetchSubMessages, UserNameResolver resolveUserName,
                            UserNameResolver resolveSenderName, BatchResolveNames batchResolveNames) {
        this.botIdentity = botIdentity;
        this.includeRawInMessage = includeRaw;
        this.stripBotMentions = stripBotMentions;
        this.subMessageFetcher = fetchSubMessages;
        this.resolveUserName = resolveUserName;
        this.resolveSenderName = resolveSenderName;
        this.batchResolveNames = batchResolveNames;
    }

    public BotIdentity getBotIdentity() {
        return botIdentity;
    }

    public boolean isIncludeRawInMessage() {
        return includeRawInMessage;
    }

    public boolean isIncludeRaw() {
        return includeRawInMessage;
    }

    public boolean isStripBotMentions() {
        return stripBotMentions;
    }

    public SubMessageFetcher getSubMessageFetcher() {
        return subMessageFetcher;
    }

    public SubMessageFetcher getFetchSubMessages() {
        return subMessageFetcher;
    }

    public UserNameResolver getSenderNameResolver() {
        return resolveSenderName;
    }

    public UserNameResolver getResolveUserName() {
        return resolveUserName;
    }

    public UserNameResolver getResolveSenderName() {
        return resolveSenderName;
    }

    public BatchResolveNames getBatchResolveNames() {
        return batchResolveNames;
    }
}
