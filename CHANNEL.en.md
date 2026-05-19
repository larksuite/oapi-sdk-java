# Java Channel Guide

`LarkChannel` is the Java SDK facade for Agent and bot scenarios. It combines event intake, message normalization, safety gates, outbound sending, streaming replies, media upload/download, reactions and low-level escape hatches into one entry point.

## Quick Start

```java
LarkChannel channel = LarkChannelFactory.createLarkChannel(
        LarkChannelOptions.newBuilder(System.getenv("APP_ID"), System.getenv("APP_SECRET"))
                .transport("websocket")
                .build()
);

channel.on("message", new ChannelEventHandler<NormalizedMessage>() {
    @Override
    public void handle(NormalizedMessage message) {
        channel.send(
                message.getChatId(),
                SendInput.markdown("Received: " + message.getContent()),
                SendOptions.newBuilder().replyTo(message.getMessageId()).build()
        );
    }
});

BotIdentity identity = channel.connect().get();
```

`connect()` returns `CompletableFuture<BotIdentity>` so Java code can read the bot identity immediately after connection. After `connect()` completes, bot identity is resolved and the first WebSocket handshake has completed when websocket transport is used.

## Transport

- `websocket`: default mode, suitable for local development and Agent services.
- `webhook`: use `channel.createWebhookDispatcher()` and plug the dispatcher into your HTTP entry point.

Call `connect()` in both modes. Message normalization needs the bot `open_id` to strip self-mentions and evaluate mention policies.

## Configuration Reference

Top-level options:

| Field / Builder method | Default | Description |
| --- | --- | --- |
| `appId` | required | App ID |
| `appSecret` | required | App secret |
| `transport(...)` | `websocket` | Inbound transport: `websocket` or `webhook` |
| `webhook(...)` | empty | Webhook verification token and encrypt key |
| `policy(...)` | see table | Inbound message policy; can be updated at runtime |
| `safety(...)` | see table | Dedup, stale filtering, queue and batching settings |
| `outbound(...)` | see table | Sending, streaming, SSRF and retry settings |
| `cache(...)` | `null` | External `ICache` for cross-instance deduplication |
| `domain(...)` | SDK default | OpenAPI domain |
| `httpTransport(...)` | `null` | Underlying HTTP transport |
| `httpInstance(...)` | `null` | Raw request options for low-level calls |
| `source(...)` | `null` | Source token appended to User-Agent |
| `includeRawEvent(...)` | `false` | Attach raw Feishu event body to normalized events |

`PolicyConfig`:

| Field | Default | Description |
| --- | --- | --- |
| `groupAllowlist` | empty | Allowed group chats; empty means no group restriction |
| `dmMode` | `open` | Direct-message mode |
| `dmAllowlist` | empty | Allowed direct-message senders; empty means no sender restriction |
| `requireMention` | `true` | Require mentioning the bot in group chats |
| `respondToMentionAll` | `false` | Respond to mention-all messages, even when the bot is not directly mentioned |

`SafetyConfig`:

| Field | Default | Description |
| --- | --- | --- |
| `dedupTtlMs` | `43200000` | Dedup retention, default 12 hours |
| `dedupMaxEntries` | `5000` | Maximum in-memory dedup entries |
| `dedupSweepMs` | `300000` | In-memory dedup sweep interval |
| `staleMessageWindowMs` | `1800000` | Stale-message window, default 30 minutes |
| `chatQueueEnabled` | `true` | Enable chat-scoped serialized processing |
| `processingLockTtlMs` | `300000` | Processing lock TTL |
| `dedupNamespace` | `channel:seen` | External-cache dedup key namespace |
| `batchText` | see table | Short-text batching settings |

`BatchTextConfig`:

| Field | Default | Description |
| --- | --- | --- |
| `delayMs` | `600` | Normal short-text batch wait |
| `longThresholdChars` | `1000` | Long-text threshold |
| `longDelayMs` | `2000` | Long-text batch wait |
| `maxMessages` | `8` | Maximum messages per batch |
| `maxChars` | `4000` | Maximum characters per batch |

`OutboundConfig`:

| Field | Default | Description |
| --- | --- | --- |
| `textChunkLimit` | `3500` | Text/Markdown chunk size limit |
| `streamThrottleMs` | `100` | Minimum streaming update interval |
| `streamThrottleChars` | `50` | Minimum streaming character delta |
| `streamInitialText` | `Thinking...` | Initial streaming message text |
| `ssrfGuardEnabled` | `true` | Enable URL SSRF guard |
| `ssrfAllowlist` | empty | Trusted domains that may bypass SSRF blocking |
| `retry` | see table | Retry settings for retryable failures |
| `allowedFileDirs` | empty | Allowed local file directories |

`RetryConfig`:

| Field | Default | Description |
| --- | --- | --- |
| `maxAttempts` | `3` | Maximum attempts |
| `baseDelayMs` | `500` | Base retry delay; later attempts use exponential backoff |

## Events

| Event | Payload | Description |
| --- | --- | --- |
| `message` | `NormalizedMessage` | Normalized incoming message |
| `cardAction` | `CardActionEvent` | Interactive card action |
| `reaction` | `ReactionEvent` | Reaction added or removed |
| `botAdded` | `BotAddedEvent` | Bot added to a chat |
| `comment` | `CommentEvent` | Drive document comment event |
| `reject` | `RejectEvent` | Safety policy rejection |
| `error` | `ChannelErrorEvent` | Normalizer, handler or pipeline error |
| `reconnecting` | `Object` | WebSocket reconnecting |
| `reconnected` | `Object` | WebSocket reconnected |

`RejectEvent` carries `messageId`, `chatId`, `senderId`, `reason`, and the raw event when `includeRawEvent(true)` is enabled.

Use `cardAction` as the public event name. `card.action` is a shorthand for the raw Feishu event type, not a public subscription name.

`on(event, handler)` replaces the existing handler for that event, matching the NodeJS channel semantics.

## Raw Event Payload

Use `includeRawEvent(true)` when handlers need the original Feishu event body:

```java
LarkChannelOptions.newBuilder(appId, appSecret)
        .includeRawEvent(true)
        .build();
```

The old `includeRawInMessage(true)` name is still supported for compatibility, but new code should use `includeRawEvent(true)`.

## Sending

`send(to, input, options)` detects the receiver id type from `to`:

| Prefix or shape | Receiver type |
| --- | --- |
| `oc_...` | `chat_id` |
| `ou_...` | `open_id` |
| `on_...` | `union_id` |
| contains `@` | `email` |
| other | `user_id` |

Supported payloads include text, Markdown, post, image, file, audio, video, card, shared chat, shared user and sticker.

```java
channel.send("oc_xxx", SendInput.text("hello")).get();
channel.send("oc_xxx", SendInput.markdown("# hello")).get();
channel.send("oc_xxx", SendInput.image("/tmp/a.png")).get();
```

Reply and mention:

```java
SendOptions options = SendOptions.newBuilder()
        .replyTo("om_xxx")
        .mentions(java.util.Arrays.asList("ou_user_open_id"))
        .build();

channel.send("oc_xxx", SendInput.text("ack"), options).get();
```

Markdown is converted to Feishu post content first. If Feishu rejects the post structure, the channel falls back to plain text. If a reply target has disappeared, the channel falls back from reply to create.

## Streaming

Markdown streaming is suitable for LLM-style incremental answers:

```java
channel.stream("oc_xxx", StreamInput.markdown(controller -> {
    controller.append("Thinking...\n\n");
    controller.append("Done.");
})).get();
```

Card streaming can progressively update a card state:

```java
channel.stream("oc_xxx", StreamInput.card(initialCard, controller -> {
    Map<String, Object> next = new java.util.LinkedHashMap<String, Object>(controller.getCurrent());
    next.put("status", "done");
    controller.update(next);
})).get();
```

Blocking convenience methods are available for non-reactive Java applications:

```java
BotIdentity identity = channel.connectSync();
SendResult result = channel.sendSync("oc_xxx", SendInput.text("hello"));
channel.disconnectSync();
```

## Low-Level Helpers

- `editMessage(messageId, text)`: uses `im.v1.message.update` for text/post messages.
- `updateCard(messageId, card)`: uses `im.v1.message.patch` for interactive cards.
- `recallMessage(messageId)`: recalls a bot message.
- `downloadResource(fileKey, type)`: downloads image/file bytes.
- `addReaction`, `removeReaction`, `removeReactionByEmoji`: manage bot reactions.
- `getChatInfo(chatId)`: fetches chat metadata.

Use `getRawClient()`, `getRawWsClient()` and `getBotIdentity()` for raw SDK access and resolved bot identity.

## Safety

The default safety policy is Agent-oriented:

- Group chats require mentioning the bot.
- Mention-all is ignored unless explicitly enabled.
- Direct messages are open by default.
- Messages are deduplicated, stale events are dropped, and chat-scoped processing is serialized.

Policy can be updated at runtime:

```java
channel.updatePolicy(policy);
LarkChannelOptions.PolicyConfig current = channel.getPolicy();
```

## Error Codes

`LarkChannelException` exposes `getCode()` and preserves the underlying `getCause()`.

| Code | Typical reason |
| --- | --- |
| `format_error` | Invalid message/card/post content |
| `target_revoked` | Reply target disappeared |
| `rate_limited` | Feishu rate limit |
| `permission_denied` | Invalid credentials or missing permission |
| `upload_failed` | Media upload or source materialization failed |
| `ssrf_blocked` | URL blocked by SSRF guard |
| `send_timeout` | Network or send timeout |
| `not_connected` | Connect or bot identity resolution failed |
| `unknown` | Unclassified failure |

## FAQ

### Why does `connect()` return `BotIdentity`?

It is a Java convenience that lets callers read the bot `openId` immediately after connection.

### Should I use `cardAction` or `card.action`?

Use `cardAction`. `card.action` is a shorthand for the raw Feishu event type, not a public subscription name.

### When should I enable `includeRawEvent(true)`?

Enable it only when you need fields not exposed by the normalized models, such as tenant metadata or raw event headers.

### Why was a URL media source rejected?

The channel enables SSRF protection by default and blocks private, loopback, link-local, multicast and reserved ranges. Use `outbound.ssrfAllowlist` only for trusted domains.

## Samples

Sample sources are under `sample/src/main/java/com/lark/oapi/sample/channel/`.

| Class | Scenario |
| --- | --- |
| `ChannelSample` | Minimal Agent bot: listen for messages and reply |
| `ChannelStreamingSample` | Streaming Markdown replies |
| `ChannelPolicyHotUpdateSample` | Runtime safety-policy update |
| `ChannelRawClientSample` | Use `getRawClient()` for unwrapped OpenAPI calls |
