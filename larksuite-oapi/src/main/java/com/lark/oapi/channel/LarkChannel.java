package com.lark.oapi.channel;

import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.channel.model.ChatInfo;
import com.lark.oapi.channel.model.NormalizedMessage;
import com.lark.oapi.channel.model.RejectEvent;
import com.lark.oapi.channel.model.RejectReason;
import com.lark.oapi.channel.model.SendInput;
import com.lark.oapi.channel.model.SendOptions;
import com.lark.oapi.channel.model.SendResult;
import com.lark.oapi.channel.model.StreamInput;
import com.lark.oapi.channel.normalize.ChannelNormalizer;
import com.lark.oapi.channel.outbound.OutboundSender;
import com.lark.oapi.channel.safety.SafetyPipeline;
import com.lark.oapi.channel.safety.SafetyPipelineOptions;
import com.lark.oapi.event.EventDispatcher;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

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
        this.safetyPipeline = new SafetyPipeline(new SafetyPipelineOptions(
                options.getSafety(),
                options.getPolicy(),
                options.getCache(),
                event -> eventBus.emit("reject", event),
                message -> eventBus.emit("message", message)));
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
        connectPromise = CompletableFuture.supplyAsync(() -> {
            try {
                BotIdentity identity = fetchBotIdentity();
                botIdentity = identity;
                safetyPipeline.setBotIdentity(identity);
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
        });
        return connectPromise;
    }

    public CompletableFuture<Void> disconnect() {
        return CompletableFuture.runAsync(() -> {
            connected = false;
            connectPromise = null;
            if (rawWsClient != null) {
                rawWsClient.close();
            }
            safetyPipeline.dispose();
        });
    }

    public boolean isConnected() {
        return connected;
    }

    // event subscription

    public <T> ChannelSubscription on(String eventName, ChannelEventHandler<T> handler) {
        return eventBus.on(eventName, handler);
    }

    public <T> ChannelSubscription onMany(String eventName, ChannelEventHandler<T> handler) {
        return eventBus.onMany(eventName, handler);
    }

    public ChannelSubscription on(Map<String, ChannelEventHandler<?>> batchHandlers) {
        return eventBus.on(batchHandlers);
    }

    public EventDispatcher createWebhookDispatcher() {
        return dispatcher;
    }

    // outbound

    public CompletableFuture<SendResult> send(String to, SendInput input) {
        return send(to, input, null);
    }

    public CompletableFuture<SendResult> send(String to, SendInput input, SendOptions sendOptions) {
        return CompletableFuture.supplyAsync(() -> outboundSender.send(to, input, sendOptions));
    }

    public CompletableFuture<SendResult> stream(String to, StreamInput input) {
        return stream(to, input, null);
    }

    public CompletableFuture<SendResult> stream(String to, StreamInput input, SendOptions sendOptions) {
        return CompletableFuture.supplyAsync(() -> outboundSender.stream(to, input, sendOptions));
    }

    // low-level

    public CompletableFuture<Void> editMessage(String messageId, String text) {
        return CompletableFuture.runAsync(() -> lowLevelApi.editMessage(messageId, text));
    }

    public CompletableFuture<Void> updateCard(String messageId, Map<String, Object> card) {
        return CompletableFuture.runAsync(() -> lowLevelApi.updateCard(messageId, card));
    }

    public CompletableFuture<Void> recallMessage(String messageId) {
        return CompletableFuture.runAsync(() -> lowLevelApi.recallMessage(messageId));
    }

    public CompletableFuture<byte[]> downloadResource(String fileKey, String type) {
        return CompletableFuture.supplyAsync(() -> lowLevelApi.downloadResource(fileKey, type));
    }

    public CompletableFuture<String> addReaction(String messageId, String emojiType) {
        return CompletableFuture.supplyAsync(() -> lowLevelApi.addReaction(messageId, emojiType));
    }

    public CompletableFuture<Void> removeReaction(String messageId, String reactionId) {
        return CompletableFuture.runAsync(() -> lowLevelApi.removeReaction(messageId, reactionId));
    }

    public CompletableFuture<Boolean> removeReactionByEmoji(String messageId, String emojiType) {
        return CompletableFuture.supplyAsync(() -> lowLevelApi.removeReactionByEmoji(messageId, emojiType));
    }

    public CompletableFuture<ChatInfo> getChatInfo(String chatId) {
        return CompletableFuture.supplyAsync(() -> lowLevelApi.getChatInfo(chatId));
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
                () -> botIdentity);
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
