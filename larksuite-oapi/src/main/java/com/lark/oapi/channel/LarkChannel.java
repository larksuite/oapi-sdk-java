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

/**
 * High-level conversation channel for Lark/Feishu bot and Agent integrations.
 *
 * <p>The channel is intentionally layered on top of the generated raw SDK:
 * it owns inbound event normalization, safety gates, outbound sending,
 * streaming replies, resource download/upload helpers and policy hot updates.
 * Use {@link #getRawClient()} as the escape hatch when an API is not yet
 * wrapped by this facade.
 */
public class LarkChannel {
    private final Client rawClient;
    private final com.lark.oapi.ws.Client rawWsClient;
    private final LarkChannelOptions options;
    private final SafetyPipeline safetyPipeline;
    private final OutboundSender outboundSender;
    private final ChannelEventBus eventBus;
    private final ChannelInboundProcessor inboundProcessor;
    private final EventDispatcher dispatcher;
    private final ChannelLowLevelApi lowLevelApi;
    private volatile BotIdentity botIdentity;
    private volatile CompletableFuture<BotIdentity> connectPromise;
    private volatile boolean connected;

    public LarkChannel(LarkChannelOptions options) {
        this(options, ChannelClientFactory.createRawClient(options), null);
    }

    LarkChannel(LarkChannelOptions options, Client rawClient) {
        this(options, rawClient, null);
    }

    LarkChannel(LarkChannelOptions options, Client rawClient, BotIdentity initialBotIdentity) {
        this.options = options;
        this.eventBus = new ChannelEventBus();

        this.rawClient = rawClient;
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
        if (initialBotIdentity != null) {
            this.botIdentity = initialBotIdentity;
            this.safetyPipeline.setBotIdentity(initialBotIdentity);
        }
    }

    // lifecycle

    /**
     * Resolve the current bot identity and start the WebSocket transport when
     * configured.
     *
     * <p>The Java facade returns {@link BotIdentity} so callers can read the
     * bot open_id immediately after connection. Once the future completes, bot
     * identity is known and the first WebSocket handshake has completed.
     */
    public synchronized CompletableFuture<BotIdentity> connect() {
        if (connectPromise != null) {
            return connectPromise;
        }
        // Publish the promise before the async work starts: a connect attempt
        // that fails synchronously fast would otherwise clear the field on the
        // worker thread first, only to be overwritten by this method's own
        // assignment — leaving a stale failed future that poisons every retry.
        CompletableFuture<BotIdentity> promise = new CompletableFuture<>();
        connectPromise = promise;
        CompletableFuture.runAsync(() -> {
            try {
                promise.complete(establishConnection());
            } catch (Throwable e) {
                // Clear before completing so that by the time a caller
                // observes the failure, calling connect() again starts a
                // fresh attempt instead of joining this dead future.
                clearConnectPromise(promise);
                promise.completeExceptionally(e);
            }
        });
        return promise;
    }

    private BotIdentity establishConnection() {
        // Feishu message normalization needs the bot open_id to strip
        // self-mentions and evaluate "must mention bot" policies.
        BotIdentity identity = fetchBotIdentity();
        botIdentity = identity;
        safetyPipeline.setBotIdentity(identity);
        if (rawWsClient != null) {
            rawWsClient.start();
            // Connect only resolves after the first WebSocket
            // handshake is actually ready, not merely after the client
            // has been constructed.
            awaitWebSocketReady(rawWsClient, 15000L);
        }
        connected = true;
        return identity;
    }

    private synchronized void clearConnectPromise(CompletableFuture<BotIdentity> promise) {
        // Identity check: never clobber state owned by disconnect() or a
        // newer connect attempt.
        if (connectPromise == promise) {
            connectPromise = null;
        }
    }

    /**
     * Blocking variant of {@link #connect()} for command-line tools and
     * traditional servlet applications that do not want to manage futures.
     */
    public BotIdentity connectSync() {
        return connect().join();
    }

    /**
     * Stop the underlying transport and release queued safety-pipeline work.
     */
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

    /**
     * Blocking variant of {@link #disconnect()}.
     */
    public void disconnectSync() {
        disconnect().join();
    }

    /**
     * Whether {@link #connect()} has completed and {@link #disconnect()} has
     * not been called.
     */
    public boolean isConnected() {
        return connected;
    }

    // event subscription

    /**
     * Register an event handler and replace any previous handler for the same
     * event name, matching the NodeJS channel subscription semantics.
     *
     * <p>The canonical card action event name is {@code cardAction}.
     */
    public <T> ChannelSubscription on(String eventName, ChannelEventHandler<T> handler) {
        return eventBus.on(eventName, handler);
    }

    /**
     * Register several handlers as one subscription.
     */
    public ChannelSubscription on(Map<String, ChannelEventHandler<?>> batchHandlers) {
        return eventBus.on(batchHandlers);
    }

    /**
     * Return the dispatcher that should be plugged into the user's HTTP
     * webhook endpoint when {@code transport("webhook")} is used.
     */
    public EventDispatcher createWebhookDispatcher() {
        return dispatcher;
    }

    /**
     * Raw SDK client used by the channel.
     */
    public Client getRawClient() {
        return rawClient;
    }

    /**
     * Raw WebSocket client used by websocket transport, or {@code null} for
     * webhook transport.
     */
    public com.lark.oapi.ws.Client getRawWsClient() {
        return rawWsClient;
    }

    /**
     * Bot identity resolved by {@link #connect()}, or {@code null} before the
     * channel is connected.
     */
    public BotIdentity getBotIdentity() {
        return botIdentity;
    }

    // outbound

    /**
     * Send a new message or reply according to {@link SendOptions}.
     */
    public CompletableFuture<SendResult> send(String to, SendInput input) {
        return send(to, input, null);
    }

    public CompletableFuture<SendResult> send(String to, SendInput input, SendOptions sendOptions) {
        return CompletableFuture.supplyAsync(() -> outboundSender.send(to, input, sendOptions));
    }

    /**
     * Blocking variant of {@link #send(String, SendInput)}.
     */
    public SendResult sendSync(String to, SendInput input) {
        return send(to, input).join();
    }

    /**
     * Blocking variant of {@link #send(String, SendInput, SendOptions)}.
     */
    public SendResult sendSync(String to, SendInput input, SendOptions sendOptions) {
        return send(to, input, sendOptions).join();
    }

    /**
     * Start a streaming reply. Markdown streams use cardkit streaming mode,
     * while card streams patch the card content progressively.
     */
    public CompletableFuture<SendResult> stream(String to, StreamInput input) {
        return stream(to, input, null);
    }

    public CompletableFuture<SendResult> stream(String to, StreamInput input, SendOptions sendOptions) {
        return CompletableFuture.supplyAsync(() -> outboundSender.stream(to, input, sendOptions));
    }

    /**
     * Blocking variant of {@link #stream(String, StreamInput)}.
     */
    public SendResult streamSync(String to, StreamInput input) {
        return stream(to, input).join();
    }

    /**
     * Blocking variant of {@link #stream(String, StreamInput, SendOptions)}.
     */
    public SendResult streamSync(String to, StreamInput input, SendOptions sendOptions) {
        return stream(to, input, sendOptions).join();
    }

    // low-level

    /**
     * Edit a text message using {@code im.v1.message.update}. Feishu only
     * supports editing text/post message content through this API; use
     * {@link #updateCard(String, Map)} for interactive cards.
     */
    public CompletableFuture<Void> editMessage(String messageId, String text) {
        return CompletableFuture.runAsync(() -> lowLevelApi.editMessage(messageId, text));
    }

    /**
     * Patch an interactive card message. This intentionally uses
     * {@code im.v1.message.patch}; {@link #editMessage(String, String)} would
     * hit the wrong Feishu endpoint for cards.
     */
    public CompletableFuture<Void> updateCard(String messageId, Map<String, Object> card) {
        return CompletableFuture.runAsync(() -> lowLevelApi.updateCard(messageId, card));
    }

    /**
     * Recall a message sent by the bot.
     */
    public CompletableFuture<Void> recallMessage(String messageId) {
        return CompletableFuture.runAsync(() -> lowLevelApi.recallMessage(messageId));
    }

    /**
     * Download an image or file resource as bytes.
     */
    public CompletableFuture<byte[]> downloadResource(String fileKey, String type) {
        return CompletableFuture.supplyAsync(() -> lowLevelApi.downloadResource(fileKey, type));
    }

    /**
     * Add a reaction and return the Feishu {@code reaction_id}. Store the id if
     * you need to remove this exact reaction later.
     */
    public CompletableFuture<String> addReaction(String messageId, String emojiType) {
        return CompletableFuture.supplyAsync(() -> lowLevelApi.addReaction(messageId, emojiType));
    }

    /**
     * Remove a reaction by {@code reaction_id}. Feishu only allows the bot to
     * remove reactions it created.
     */
    public CompletableFuture<Void> removeReaction(String messageId, String reactionId) {
        return CompletableFuture.runAsync(() -> lowLevelApi.removeReaction(messageId, reactionId));
    }

    /**
     * Convenience helper that lists reactions for an emoji, finds the bot's own
     * reaction and removes it.
     */
    public CompletableFuture<Boolean> removeReactionByEmoji(String messageId, String emojiType) {
        return CompletableFuture.supplyAsync(() -> lowLevelApi.removeReactionByEmoji(messageId, emojiType));
    }

    /**
     * Fetch basic chat metadata using open_id as user id type.
     */
    public CompletableFuture<ChatInfo> getChatInfo(String chatId) {
        return CompletableFuture.supplyAsync(() -> lowLevelApi.getChatInfo(chatId));
    }

    // runtime config

    /**
     * Hot-update policy settings used by the safety gate.
     */
    public void updatePolicy(LarkChannelOptions.PolicyConfig partial) {
        if (partial == null) {
            return;
        }
        LarkChannelOptions.PolicyConfig policy = options.getPolicy();
        if (policy == null) {
            return;
        }
        policy.setGroupAllowlist(partial.getGroupAllowlist());
        policy.setDmMode(partial.getDmMode());
        policy.setDmAllowlist(partial.getDmAllowlist());
        policy.setRequireMention(partial.isRequireMention());
        policy.setRespondToMentionAll(partial.isRespondToMentionAll());
    }

    /**
     * Current policy settings used by the safety gate.
     */
    public LarkChannelOptions.PolicyConfig getPolicy() {
        return options.getPolicy();
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

    RejectReason checkPolicy(NormalizedMessage message) {
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
