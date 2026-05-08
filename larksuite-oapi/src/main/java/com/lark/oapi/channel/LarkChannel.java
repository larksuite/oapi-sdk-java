package com.lark.oapi.channel;

import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.channel.model.ChatInfo;
import com.lark.oapi.channel.model.NormalizedMessage;
import com.lark.oapi.channel.model.RejectReason;
import com.lark.oapi.channel.model.SendInput;
import com.lark.oapi.channel.model.SendOptions;
import com.lark.oapi.channel.model.SendResult;
import com.lark.oapi.channel.model.StreamInput;
import com.lark.oapi.channel.normalize.ChannelNormalizer;
import com.lark.oapi.channel.outbound.OutboundSender;
import com.lark.oapi.channel.safety.SafetyPipeline;
import com.lark.oapi.event.EventDispatcher;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class LarkChannel {
    public final Client rawClient;
    public final com.lark.oapi.ws.Client rawWsClient;
    public volatile BotIdentity botIdentity;

    private final LarkChannelOptions options;
    private final SafetyPipeline safetyPipeline;
    private final OutboundSender outboundSender;
    private final ChannelEventBus eventBus;
    private final ChannelInboundProcessor inboundProcessor;
    private final EventDispatcher dispatcher;
    private final ChannelLowLevelApi lowLevelApi;
    private final ChannelRuntimeConfig runtimeConfig;
    private volatile CompletableFuture<BotIdentity> connectPromise;
    private volatile boolean connected;

    public LarkChannel(LarkChannelOptions options) {
        this.options = options;
        this.eventBus = new ChannelEventBus();
        this.runtimeConfig = new ChannelRuntimeConfig(options);

        this.rawClient = ChannelClientFactory.createRawClient(options);
        this.safetyPipeline = new SafetyPipeline(options.getSafety(), options.getPolicy(), options.getCache());
        this.outboundSender = new OutboundSender(this.rawClient, options);
        this.inboundProcessor = createInboundProcessor();
        this.dispatcher = ChannelEventDispatcherFactory.create(options, inboundProcessor);
        this.lowLevelApi = new ChannelLowLevelApi(this.rawClient, this.outboundSender);
        this.rawWsClient = ChannelClientFactory.createWebSocketClient(options, dispatcher, eventBus);
    }

    // lifecycle

    public synchronized CompletableFuture<BotIdentity> connect() {
        if (connectPromise != null) {
            return connectPromise;
        }
        connectPromise = CompletableFuture.supplyAsync(new java.util.function.Supplier<BotIdentity>() {
            @Override
            public BotIdentity get() {
                try {
                    BotIdentity identity = fetchBotIdentity();
                    botIdentity = identity;
                    if (rawWsClient != null) {
                        rawWsClient.start();
                        awaitWebSocketReady(rawWsClient, 15000L);
                    }
                    connected = true;
                    return identity;
                } catch (RuntimeException e) {
                    connectPromise = null;
                    throw e;
                }
            }
        });
        return connectPromise;
    }

    public CompletableFuture<Void> disconnect() {
        return CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                connected = false;
                connectPromise = null;
                if (rawWsClient != null) {
                    rawWsClient.close();
                }
                safetyPipeline.dispose();
            }
        });
    }

    // event subscription

    public <T> ChannelSubscription on(String eventName, ChannelEventHandler<T> handler) {
        return eventBus.on(eventName, handler);
    }

    public void on(Map<String, ChannelEventHandler<?>> batchHandlers) {
        eventBus.on(batchHandlers);
    }

    public EventDispatcher createWebhookDispatcher() {
        return dispatcher;
    }

    // outbound

    public CompletableFuture<SendResult> send(String to, SendInput input) {
        return send(to, input, null);
    }

    public CompletableFuture<SendResult> send(final String to, final SendInput input, final SendOptions sendOptions) {
        return CompletableFuture.supplyAsync(new java.util.function.Supplier<SendResult>() {
            @Override
            public SendResult get() {
                return outboundSender.send(to, input, sendOptions);
            }
        });
    }

    public CompletableFuture<SendResult> stream(String to, StreamInput input) {
        return stream(to, input, null);
    }

    public CompletableFuture<SendResult> stream(final String to, final StreamInput input, final SendOptions sendOptions) {
        return CompletableFuture.supplyAsync(new java.util.function.Supplier<SendResult>() {
            @Override
            public SendResult get() {
                return outboundSender.stream(to, input, sendOptions);
            }
        });
    }

    // low-level

    public CompletableFuture<Void> editMessage(final String messageId, final String text) {
        return CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                lowLevelApi.editMessage(messageId, text);
            }
        });
    }

    public CompletableFuture<Void> updateCard(final String messageId, final Map<String, Object> card) {
        return CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                lowLevelApi.updateCard(messageId, card);
            }
        });
    }

    public CompletableFuture<Void> recallMessage(final String messageId) {
        return CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                lowLevelApi.recallMessage(messageId);
            }
        });
    }

    public CompletableFuture<byte[]> downloadResource(final String fileKey, final String type) {
        return CompletableFuture.supplyAsync(new java.util.function.Supplier<byte[]>() {
            @Override
            public byte[] get() {
                return lowLevelApi.downloadResource(fileKey, type);
            }
        });
    }

    public CompletableFuture<String> addReaction(final String messageId, final String emojiType) {
        return CompletableFuture.supplyAsync(new java.util.function.Supplier<String>() {
            @Override
            public String get() {
                return lowLevelApi.addReaction(messageId, emojiType);
            }
        });
    }

    public CompletableFuture<Void> removeReaction(final String messageId, final String reactionId) {
        return CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                lowLevelApi.removeReaction(messageId, reactionId);
            }
        });
    }

    public CompletableFuture<Boolean> removeReactionByEmoji(final String messageId, final String emojiType) {
        return CompletableFuture.supplyAsync(new java.util.function.Supplier<Boolean>() {
            @Override
            public Boolean get() {
                return lowLevelApi.removeReactionByEmoji(messageId, emojiType);
            }
        });
    }

    public CompletableFuture<ChatInfo> getChatInfo(final String chatId) {
        return CompletableFuture.supplyAsync(new java.util.function.Supplier<ChatInfo>() {
            @Override
            public ChatInfo get() {
                return lowLevelApi.getChatInfo(chatId);
            }
        });
    }

    // runtime config

    public void updatePolicy(LarkChannelOptions.PolicyConfig partial) {
        runtimeConfig.updatePolicy(partial);
    }

    public LarkChannelOptions.PolicyConfig getPolicy() {
        return runtimeConfig.getPolicy();
    }

    // internals: bot identity & dispatch wiring

    private BotIdentity fetchBotIdentity() {
        return new BotIdentityResolver(rawClient, options).fetch();
    }

    private ChannelInboundProcessor createInboundProcessor() {
        return new ChannelInboundProcessor(
                rawClient,
                options,
                new ChannelNormalizer(),
                safetyPipeline,
                eventBus,
                new Supplier<BotIdentity>() {
                    @Override
                    public BotIdentity get() {
                        return botIdentity;
                    }
                });
    }

    private RejectReason checkPolicy(NormalizedMessage message) {
        return safetyPipeline.checkPolicy(message);
    }

    private void awaitWebSocketReady(com.lark.oapi.ws.Client wsClient, long timeoutMs) {
        try {
            wsClient.awaitReady(timeoutMs);
        } catch (Exception e) {
            wsClient.close();
            throw new com.lark.oapi.channel.exception.LarkChannelException(
                    com.lark.oapi.channel.exception.LarkChannelErrorCode.NOT_CONNECTED,
                    "websocket handshake did not complete",
                    null,
                    e);
        }
    }
}
