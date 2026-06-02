package com.lark.oapi.channel;

import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.model.ChannelErrorEvent;
import com.lark.oapi.channel.model.RejectReason;
import com.lark.oapi.channel.model.SendInput;
import com.lark.oapi.channel.model.SendResult;
import com.lark.oapi.channel.exception.LarkChannelException;
import com.lark.oapi.core.Config;
import com.lark.oapi.core.httpclient.IHttpTransport;
import com.lark.oapi.core.request.RawRequest;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.service.im.ImService;
import com.lark.oapi.service.im.v1.model.CreateMessageReactionResp;
import com.lark.oapi.service.im.v1.model.CreateMessageReactionRespBody;
import com.lark.oapi.service.im.v1.model.CreateMessageReq;
import com.lark.oapi.service.im.v1.model.CreateMessageResp;
import com.lark.oapi.service.im.v1.model.CreateMessageRespBody;
import com.lark.oapi.service.im.v1.model.DeleteMessageReq;
import com.lark.oapi.service.im.v1.model.GetFileReq;
import com.lark.oapi.service.im.v1.model.GetFileResp;
import com.lark.oapi.service.im.v1.model.GetChatReq;
import com.lark.oapi.service.im.v1.model.GetChatResp;
import com.lark.oapi.service.im.v1.model.GetChatRespBody;
import com.lark.oapi.service.im.v1.model.GetImageReq;
import com.lark.oapi.service.im.v1.model.GetImageResp;
import com.lark.oapi.service.im.v1.model.ListMessageReactionReq;
import com.lark.oapi.service.im.v1.model.ListMessageReactionResp;
import com.lark.oapi.service.im.v1.model.ListMessageReactionRespBody;
import com.lark.oapi.service.im.v1.model.Operator;
import com.lark.oapi.service.im.v1.model.PatchMessageResp;
import com.lark.oapi.service.im.v1.model.PatchMessageReq;
import com.lark.oapi.service.im.v1.model.ReplyMessageReq;
import com.lark.oapi.service.im.v1.model.ReplyMessageResp;
import com.lark.oapi.service.im.v1.model.ReplyMessageRespBody;
import com.lark.oapi.service.im.v1.model.UpdateMessageResp;
import com.lark.oapi.service.im.v1.model.UpdateMessageReq;
import com.lark.oapi.service.im.v1.resource.Chat;
import com.lark.oapi.service.im.v1.resource.File;
import com.lark.oapi.service.im.v1.resource.Image;
import com.lark.oapi.service.im.v1.resource.Message;
import com.lark.oapi.service.im.v1.resource.MessageReaction;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

public class TestLarkChannel {
    private static Object getField(Object target, String fieldName) throws Exception {
        Field field = null;
        Class<?> type = target.getClass();
        while (type != null) {
            try {
                field = type.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException ignored) {
                type = type.getSuperclass();
            }
        }
        if (field == null) {
            throw new IllegalStateException("field not found: " + fieldName);
        }
        field.setAccessible(true);
        return field.get(target);
    }

    private static void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = null;
        Class<?> type = target.getClass();
        while (type != null) {
            try {
                field = type.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException ignored) {
                type = type.getSuperclass();
            }
        }
        if (field == null) {
            throw new IllegalStateException("field not found: " + fieldName);
        }
        field.setAccessible(true);
        field.set(target, value);
    }

    private static void invokeNoArg(Object target, String methodName) throws Exception {
        java.lang.reflect.Method method = null;
        Class<?> type = target.getClass();
        while (type != null) {
            try {
                method = type.getDeclaredMethod(methodName);
                break;
            } catch (NoSuchMethodException ignored) {
                type = type.getSuperclass();
            }
        }
        if (method == null) {
            throw new IllegalStateException("method not found: " + methodName);
        }
        method.setAccessible(true);
        method.invoke(target);
    }

    @Test
    public void testEventBusOverrideBatchUnsubscribeAndErrorIsolation() {
        ChannelEventBus bus = new ChannelEventBus();
        final AtomicInteger messageCount = new AtomicInteger();
        final AtomicInteger errorCount = new AtomicInteger();

        bus.on("message", new ChannelEventHandler<String>() {
            @Override
            public void handle(String event) {
                messageCount.addAndGet(100);
            }
        });
        bus.on("message", new ChannelEventHandler<String>() {
            @Override
            public void handle(String event) {
                messageCount.incrementAndGet();
                throw new RuntimeException("boom");
            }
        });
        bus.on("error", new ChannelEventHandler<ChannelErrorEvent>() {
            @Override
            public void handle(ChannelErrorEvent event) {
                errorCount.incrementAndGet();
                Assert.assertEquals("message", event.getEventName());
                Assert.assertEquals("payload", event.getEvent());
            }
        });

        bus.emit("message", "payload");
        Assert.assertEquals(1, messageCount.get());
        Assert.assertEquals(1, errorCount.get());

        java.util.Map<String, ChannelEventHandler<?>> batch = new java.util.LinkedHashMap<String, ChannelEventHandler<?>>();
        batch.put("message", new ChannelEventHandler<String>() {
            @Override
            public void handle(String event) {
                messageCount.addAndGet(10);
            }
        });
        ChannelSubscription subscription = bus.on(batch);
        bus.emit("message", "payload");
        subscription.unsubscribe();
        bus.emit("message", "payload");
        Assert.assertEquals(11, messageCount.get());
    }

    @Test
    public void testCardActionDottedAliasDoesNotMapToCanonicalEventName() {
        ChannelEventBus bus = new ChannelEventBus();
        final AtomicInteger calls = new AtomicInteger();

        bus.on("card.action", new ChannelEventHandler<String>() {
            @Override
            public void handle(String event) {
                calls.incrementAndGet();
                Assert.assertEquals("payload", event);
            }
        });

        bus.emit("cardAction", "payload");

        Assert.assertEquals(0, calls.get());
    }

    @Test
    public void testIncludeRawEventAliasMatchesLegacyOption() {
        LarkChannelOptions options = LarkChannelOptions.newBuilder("cli_test", "secret")
                .includeRawEvent(true)
                .build();

        Assert.assertTrue(options.isIncludeRawEvent());
        Assert.assertTrue(options.isIncludeRawInMessage());
    }

    @Test
    public void testLarkChannelExceptionPreservesCause() {
        RuntimeException cause = new RuntimeException("root cause");
        LarkChannelException error = new LarkChannelException(
                com.lark.oapi.channel.exception.LarkChannelErrorCode.NOT_CONNECTED,
                "connect failed",
                cause);

        Assert.assertSame(cause, error.getCause());
    }

    @Test
    public void testEditMessageUsesUpdateNotPatch() throws Exception {
        StubMessage stubMessage = new StubMessage();
        LarkChannel channel = createChannel(stubMessage, new StubMessageReaction(), new StubImage(), new StubFile(), new StubChat());

        channel.editMessage("om_123", "new body").get();

        Assert.assertNotNull(stubMessage.updateReq);
        Assert.assertNull(stubMessage.patchReq);
        Assert.assertEquals("om_123", stubMessage.updateReq.getMessageId());
        Assert.assertEquals("text", stubMessage.updateReq.getUpdateMessageReqBody().getMsgType());
        Assert.assertEquals("{\"text\":\"new body\"}", stubMessage.updateReq.getUpdateMessageReqBody().getContent());
    }

    @Test
    public void testUpdateCardUsesPatchWithInteractiveContent() throws Exception {
        StubMessage stubMessage = new StubMessage();
        LarkChannel channel = createChannel(stubMessage, new StubMessageReaction(), new StubImage(), new StubFile(), new StubChat());
        java.util.Map<String, Object> card = new java.util.LinkedHashMap<String, Object>();
        card.put("elements", java.util.Collections.singletonList(java.util.Collections.singletonMap("tag", "markdown")));

        channel.updateCard("om_card", card).get();

        Assert.assertNotNull(stubMessage.patchReq);
        Assert.assertEquals("om_card", stubMessage.patchReq.getMessageId());
        Assert.assertTrue(stubMessage.patchReq.getPatchMessageReqBody().getContent().contains("markdown"));
    }

    @Test
    public void testDownloadResourceReturnsBytes() throws Exception {
        StubImage stubImage = new StubImage();
        GetImageResp imageResp = new GetImageResp();
        ByteArrayOutputStream imageBytes = new ByteArrayOutputStream();
        imageBytes.write("fake-png".getBytes(StandardCharsets.UTF_8));
        imageResp.setData(imageBytes);
        stubImage.resp = imageResp;

        StubFile stubFile = new StubFile();
        GetFileResp fileResp = new GetFileResp();
        ByteArrayOutputStream fileBytes = new ByteArrayOutputStream();
        fileBytes.write("hello-file".getBytes(StandardCharsets.UTF_8));
        fileResp.setData(fileBytes);
        stubFile.resp = fileResp;

        LarkChannel channel = createChannel(new StubMessage(), new StubMessageReaction(), stubImage, stubFile, new StubChat());

        Assert.assertArrayEquals("fake-png".getBytes(StandardCharsets.UTF_8), channel.downloadResource("img_x", "image").get());
        Assert.assertArrayEquals("hello-file".getBytes(StandardCharsets.UTF_8), channel.downloadResource("file_x", "file").get());
        Assert.assertEquals("img_x", stubImage.lastReq.getImageKey());
        Assert.assertEquals("file_x", stubFile.lastReq.getFileKey());
    }

    @Test
    public void testReactionRoundTrip() throws Exception {
        StubMessageReaction stubReaction = new StubMessageReaction();
        CreateMessageReactionResp createResp = new CreateMessageReactionResp();
        CreateMessageReactionRespBody createBody = new CreateMessageReactionRespBody();
        createBody.setReactionId("rx_1234");
        createResp.setData(createBody);
        stubReaction.createResp = createResp;

        ListMessageReactionResp listResp = new ListMessageReactionResp();
        ListMessageReactionRespBody listBody = new ListMessageReactionRespBody();
        com.lark.oapi.service.im.v1.model.MessageReaction appReaction = com.lark.oapi.service.im.v1.model.MessageReaction.newBuilder()
                .reactionId("rx_bot")
                .operator(Operator.newBuilder().operatorType("app").build())
                .build();
        listBody.setItems(new com.lark.oapi.service.im.v1.model.MessageReaction[]{appReaction});
        listResp.setData(listBody);
        stubReaction.listResp = listResp;

        LarkChannel channel = createChannel(new StubMessage(), stubReaction, new StubImage(), new StubFile(), new StubChat());

        Assert.assertEquals("rx_1234", channel.addReaction("om_1", "OK").get());
        Assert.assertEquals("om_1", stubReaction.createReq.getMessageId());
        Assert.assertEquals("OK", stubReaction.createReq.getCreateMessageReactionReqBody().getReactionType().getEmojiType());

        channel.removeReaction("om_1", "rx_manual").get();
        Assert.assertEquals("rx_manual", stubReaction.deleteReq.getReactionId());

        Assert.assertTrue(channel.removeReactionByEmoji("om_1", "OK").get());
        Assert.assertEquals("OK", stubReaction.listReq.getReactionType());
        Assert.assertEquals("rx_bot", stubReaction.deleteReq.getReactionId());
    }

    @Test
    public void testShareOutboundRoutes() throws Exception {
        StubMessage stubMessage = new StubMessage();
        CreateMessageResp createResp = new CreateMessageResp();
        CreateMessageRespBody createBody = new CreateMessageRespBody();
        createBody.setMessageId("om_ok");
        createResp.setData(createBody);
        stubMessage.createResp = createResp;

        LarkChannel channel = createChannel(stubMessage, new StubMessageReaction(), new StubImage(), new StubFile(), new StubChat());

        SendResult shareChat = channel.send("oc_chat", SendInput.shareChat("oc_target")).get();
        Assert.assertEquals("om_ok", shareChat.getMessageId());
        Assert.assertEquals("share_chat", stubMessage.createReq.getCreateMessageReqBody().getMsgType());
        Assert.assertEquals("{\"chat_id\":\"oc_target\"}", stubMessage.createReq.getCreateMessageReqBody().getContent());

        channel.send("oc_chat", SendInput.shareUser("ou_alice")).get();
        Assert.assertEquals("share_user", stubMessage.createReq.getCreateMessageReqBody().getMsgType());
        Assert.assertEquals("{\"user_id\":\"ou_alice\"}", stubMessage.createReq.getCreateMessageReqBody().getContent());

        channel.send("oc_chat", SendInput.sticker("sticker_abc")).get();
        Assert.assertEquals("sticker", stubMessage.createReq.getCreateMessageReqBody().getMsgType());
        Assert.assertEquals("{\"file_key\":\"sticker_abc\"}", stubMessage.createReq.getCreateMessageReqBody().getContent());
    }

    @Test
    public void testRecallMessageUsesDelete() throws Exception {
        StubMessage stubMessage = new StubMessage();
        LarkChannel channel = createChannel(stubMessage, new StubMessageReaction(), new StubImage(), new StubFile(), new StubChat());

        channel.recallMessage("om_recall").get();

        Assert.assertNotNull(stubMessage.deleteReq);
        Assert.assertEquals("om_recall", stubMessage.deleteReq.getMessageId());
    }

    @Test
    public void testDisconnectClosesWebSocketClient() throws Exception {
        LarkChannel channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder("cli_test", "secret").transport("websocket").build()
        );

        channel.disconnect().get();

        Assert.assertEquals(Boolean.TRUE, getField(channel.getRawWsClient(), "userClosed"));
    }

    @Test
    public void testRawClientUsesConfiguredHttpTransport() throws Exception {
        StubHttpTransport transport = new StubHttpTransport();
        LarkChannel channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder("cli_test", "secret")
                        .transport("webhook")
                        .httpTransport(transport)
                        .build()
        );

        Config config = (Config) getField(channel.getRawClient(), "config");
        Assert.assertSame(transport, config.getHttpTransport());
    }

    @Test
    public void testSourceAppendsSanitizedUserAgentToken() throws Exception {
        StubHttpTransport transport = new StubHttpTransport();
        LarkChannel channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder("cli_test", "secret")
                        .transport("webhook")
                        .httpTransport(transport)
                        .source("cursor bot")
                        .build()
        );

        channel.getRawClient().get("/open-apis/test", null, AccessTokenType.None);

        Assert.assertEquals("oapi-sdk-java/v2.0.0 source/cursor-bot",
                transport.lastRequest.getHeaders().get("User-Agent").get(0));
    }

    @Test
    public void testWebSocketClientReceivesConfiguredSource() throws Exception {
        LarkChannel channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder("cli_test", "secret")
                        .transport("websocket")
                        .source("cursor bot")
                        .build()
        );

        Assert.assertEquals("oapi-sdk-java/v2.0.0 source/cursor-bot",
                getField(channel.getRawWsClient(), "userAgent"));
    }

    @Test
    public void testInvalidSourceKeepsBaseUserAgent() throws Exception {
        StubHttpTransport transport = new StubHttpTransport();
        LarkChannel channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder("cli_test", "secret")
                        .transport("webhook")
                        .httpTransport(transport)
                        .source("!!!")
                        .build()
        );

        channel.getRawClient().get("/open-apis/test", null, AccessTokenType.None);

        Assert.assertEquals("oapi-sdk-java/v2.0.0",
                transport.lastRequest.getHeaders().get("User-Agent").get(0));
    }

    @Test
    public void testFetchBotIdentityAcceptsBotShape() throws Exception {
        LarkChannelOptions options = LarkChannelOptions.newBuilder("cli_test", "secret").transport("webhook").build();
        StubRawClient stubClient = new StubRawClient();
        RawResponse response = new RawResponse();
        response.setStatusCode(200);
        response.setBody("{\"code\":0,\"msg\":\"ok\",\"bot\":{\"open_id\":\"ou_bot_shape\",\"app_name\":\"Bot Shape\"}}"
                .getBytes(StandardCharsets.UTF_8));
        stubClient.getResp = response;

        com.lark.oapi.channel.model.BotIdentity identity = new BotIdentityResolver(stubClient, options).fetch();

        Assert.assertEquals("ou_bot_shape", identity.getOpenId());
        Assert.assertEquals("Bot Shape", identity.getName());
    }

    @Test
    public void testFetchBotIdentityStillAcceptsLegacyDataShape() throws Exception {
        LarkChannelOptions options = LarkChannelOptions.newBuilder("cli_test", "secret").transport("webhook").build();
        StubRawClient stubClient = new StubRawClient();
        RawResponse response = new RawResponse();
        response.setStatusCode(200);
        response.setBody("{\"code\":0,\"msg\":\"ok\",\"data\":{\"open_id\":\"ou_data_shape\",\"name\":\"Data Shape\"}}"
                .getBytes(StandardCharsets.UTF_8));
        stubClient.getResp = response;

        com.lark.oapi.channel.model.BotIdentity identity = new BotIdentityResolver(stubClient, options).fetch();

        Assert.assertEquals("ou_data_shape", identity.getOpenId());
        Assert.assertEquals("Data Shape", identity.getName());
    }

    @Test
    public void testConnectSetsBotIdentityAndCachesPromise() throws Exception {
        LarkChannelOptions options = LarkChannelOptions.newBuilder("cli_test", "secret").transport("webhook").build();
        StubRawClient stubClient = new StubRawClient();
        RawResponse response = new RawResponse();
        response.setStatusCode(200);
        response.setBody("{\"code\":0,\"msg\":\"ok\",\"bot\":{\"open_id\":\"ou_connect\",\"app_name\":\"Connect Bot\"}}"
                .getBytes(StandardCharsets.UTF_8));
        stubClient.getResp = response;
        LarkChannel channel = new LarkChannel(options, stubClient);

        CompletableFuture<com.lark.oapi.channel.model.BotIdentity> first = channel.connect();
        CompletableFuture<com.lark.oapi.channel.model.BotIdentity> second = channel.connect();
        com.lark.oapi.channel.model.BotIdentity identity = first.get(3, TimeUnit.SECONDS);

        Assert.assertSame(first, second);
        Assert.assertEquals("ou_connect", identity.getOpenId());
        Assert.assertEquals("Connect Bot", identity.getName());
        Assert.assertSame(identity, channel.getBotIdentity());
        Assert.assertTrue(channel.isConnected());
    }

    @Test
    public void testConnectSyncReturnsBotIdentity() throws Exception {
        LarkChannelOptions options = LarkChannelOptions.newBuilder("cli_test", "secret").transport("webhook").build();
        StubRawClient stubClient = new StubRawClient();
        RawResponse response = new RawResponse();
        response.setStatusCode(200);
        response.setBody("{\"code\":0,\"msg\":\"ok\",\"bot\":{\"open_id\":\"ou_sync\",\"app_name\":\"Sync Bot\"}}"
                .getBytes(StandardCharsets.UTF_8));
        stubClient.getResp = response;
        LarkChannel channel = new LarkChannel(options, stubClient);

        com.lark.oapi.channel.model.BotIdentity identity = channel.connectSync();

        Assert.assertEquals("ou_sync", identity.getOpenId());
        Assert.assertSame(identity, channel.getBotIdentity());
    }

    @Test
    public void testConnectInvalidCredentialsFailsAndCanRetry() throws Exception {
        LarkChannelOptions options = LarkChannelOptions.newBuilder("cli_test", "bad_secret").transport("webhook").build();
        StubRawClient stubClient = new StubRawClient();
        RawResponse denied = new RawResponse();
        denied.setStatusCode(403);
        denied.setBody("{\"code\":99991401,\"msg\":\"permission denied\"}".getBytes(StandardCharsets.UTF_8));
        stubClient.getResp = denied;
        LarkChannel channel = new LarkChannel(options, stubClient);

        try {
            channel.connect().get(3, TimeUnit.SECONDS);
            Assert.fail("expected permission denied");
        } catch (ExecutionException e) {
            Assert.assertTrue(e.getCause() instanceof LarkChannelException);
            Assert.assertEquals(com.lark.oapi.channel.exception.LarkChannelErrorCode.PERMISSION_DENIED.getValue(),
                    ((LarkChannelException) e.getCause()).getCode());
        }

        denied.setStatusCode(200);
        denied.setBody("{\"code\":0,\"msg\":\"ok\",\"bot\":{\"open_id\":\"ou_retry\",\"app_name\":\"Retry Bot\"}}"
                .getBytes(StandardCharsets.UTF_8));
        Assert.assertEquals("ou_retry", channel.connectSync().getOpenId());
        Assert.assertTrue(channel.isConnected());
    }

    @Test
    public void testWebSocketReconnectEventsAreForwarded() throws Exception {
        LarkChannel channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder("cli_test", "secret").transport("websocket").build()
        );
        final AtomicInteger reconnecting = new AtomicInteger();
        final AtomicInteger reconnected = new AtomicInteger();
        channel.on("reconnecting", new ChannelEventHandler<Object>() {
            @Override
            public void handle(Object event) {
                reconnecting.incrementAndGet();
            }
        });
        channel.on("reconnected", new ChannelEventHandler<Object>() {
            @Override
            public void handle(Object event) {
                reconnected.incrementAndGet();
            }
        });

        Runnable onReconnecting = (Runnable) getField(channel.getRawWsClient(), "onReconnecting");
        Runnable onReconnected = (Runnable) getField(channel.getRawWsClient(), "onReconnected");
        onReconnecting.run();
        onReconnected.run();

        Assert.assertEquals(1, reconnecting.get());
        Assert.assertEquals(1, reconnected.get());
    }

    @Test
    public void testWebSocketReconnectCallbacksOnlyFireAfterFirstSuccessfulConnect() throws Exception {
        final AtomicInteger reconnected = new AtomicInteger();
        com.lark.oapi.ws.Client wsClient = new com.lark.oapi.ws.Client.Builder("cli_test", "secret")
                .onReconnected(new Runnable() {
                    @Override
                    public void run() {
                        reconnected.incrementAndGet();
                    }
                })
                .build();

        setField(wsClient, "isReconnecting", Boolean.TRUE);
        invokeNoArg(wsClient, "markConnected");

        Assert.assertEquals(0, reconnected.get());

        setField(wsClient, "isReconnecting", Boolean.TRUE);
        invokeNoArg(wsClient, "markConnected");

        Assert.assertEquals(1, reconnected.get());
    }

    @Test
    public void testGetChatInfoMapsFields() throws Exception {
        StubChat stubChat = new StubChat();
        GetChatResp chatResp = new GetChatResp();
        GetChatRespBody body = new GetChatRespBody();
        body.setName("Channel Test");
        body.setDescription("chat description");
        body.setChatMode("group");
        body.setOwnerId("ou_owner");
        body.setUserCount("7");
        chatResp.setData(body);
        stubChat.resp = chatResp;

        LarkChannel channel = createChannel(new StubMessage(), new StubMessageReaction(), new StubImage(), new StubFile(), stubChat);

        com.lark.oapi.channel.model.ChatInfo chatInfo = channel.getChatInfo("oc_group").get();
        Assert.assertEquals("oc_group", chatInfo.getChatId());
        Assert.assertEquals("Channel Test", chatInfo.getName());
        Assert.assertEquals("chat description", chatInfo.getDescription());
        Assert.assertEquals("group", chatInfo.getChatType());
        Assert.assertEquals("ou_owner", chatInfo.getOwnerId());
        Assert.assertEquals(Integer.valueOf(7), chatInfo.getMemberCount());
        Assert.assertEquals("oc_group", stubChat.lastReq.getChatId());
        Assert.assertEquals("open_id", stubChat.lastReq.getUserIdType());
    }

    @Test
    public void testMentionAllRejectPrecedesRequireMention() throws Exception {
        LarkChannelOptions.PolicyConfig policy = new LarkChannelOptions.PolicyConfig();
        policy.setRequireMention(true);
        policy.setRespondToMentionAll(false);

        StubImService imService = new StubImService(new StubMessage(), new StubMessageReaction(), new StubImage(), new StubFile(), new StubChat());
        StubRawClient stubClient = new StubRawClient();
        stubClient.imService = imService;
        LarkChannel channel = new LarkChannel(
                LarkChannelOptions.newBuilder("cli_test", "secret")
                        .transport("webhook")
                        .policy(policy)
                        .build(),
                stubClient,
                new com.lark.oapi.channel.model.BotIdentity("ou_bot", "TestBot"));
        com.lark.oapi.channel.model.NormalizedMessage message = new com.lark.oapi.channel.model.NormalizedMessage(
                "om_mention_all",
                "oc_group",
                "group",
                "ou_sender",
                null,
                "@all hello",
                "text",
                java.util.Collections.<com.lark.oapi.channel.model.ResourceDescriptor>emptyList(),
                java.util.Collections.<com.lark.oapi.channel.model.MentionInfo>emptyList(),
                true,
                false,
                null,
                null,
                null,
                1L,
                null);

        Object result = channel.checkPolicy(message);
        Assert.assertEquals(RejectReason.MENTION_ALL_BLOCKED, result);
    }

    @Test
    public void testUpdatePolicyDelegatesToRuntimeConfig() throws Exception {
        LarkChannel channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder("cli_test", "secret").transport("webhook").build()
        );
        LarkChannelOptions.PolicyConfig partial = new LarkChannelOptions.PolicyConfig();
        partial.setGroupAllowlist("oc_allowed");
        partial.setDmMode("allowlist");
        partial.setDmAllowlist("ou_allowed");
        partial.setRequireMention(false);
        partial.setRespondToMentionAll(true);

        channel.updatePolicy(partial);
        LarkChannelOptions.PolicyConfig current = channel.getPolicy();

        Assert.assertEquals(java.util.Arrays.asList("oc_allowed"), current.getGroupAllowlist());
        Assert.assertEquals("allowlist", current.getDmMode());
        Assert.assertEquals(java.util.Arrays.asList("ou_allowed"), current.getDmAllowlist());
        Assert.assertFalse(current.isRequireMention());
        Assert.assertTrue(current.isRespondToMentionAll());
    }

    @Test
    public void testCommentEventIsDispatched() throws Throwable {
        LarkChannel channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder("cli_test", "secret").transport("webhook").build()
        );
        final CommentEventHolder holder = new CommentEventHolder();
        channel.on("comment", new ChannelEventHandler<com.lark.oapi.channel.model.CommentEvent>() {
            @Override
            public void handle(com.lark.oapi.channel.model.CommentEvent event) {
                holder.event = event;
            }
        });

        channel.createWebhookDispatcher().doWithoutValidation(("{"
                + "\"schema\":\"2.0\","
                + "\"header\":{\"event_type\":\"drive.notice.comment_add_v1\"},"
                + "\"event\":{"
                + "\"file_token\":\"docx_xyz\","
                + "\"file_type\":\"docx\","
                + "\"comment_id\":\"cmt_1\","
                + "\"reply_id\":\"reply_1\","
                + "\"notice_meta\":{"
                + "\"from_user_id\":{\"open_id\":\"ou_alice\"},"
                + "\"timestamp\":\"1700000000000\","
                + "\"is_mentioned\":true"
                + "}"
                + "}"
                + "}").getBytes(StandardCharsets.UTF_8));

        Assert.assertNotNull(holder.event);
        Assert.assertEquals("docx_xyz", holder.event.getFileToken());
        Assert.assertEquals("cmt_1", holder.event.getCommentId());
        Assert.assertEquals("ou_alice", holder.event.getOperatorId());
    }

    private LarkChannel createChannel(StubMessage message, StubMessageReaction messageReaction, StubImage image, StubFile file, StubChat chat) throws Exception {
        StubImService imService = new StubImService(message, messageReaction, image, file, chat);
        StubRawClient stubClient = new StubRawClient();
        stubClient.imService = imService;
        LarkChannel channel = new LarkChannel(
                LarkChannelOptions.newBuilder("cli_test", "secret").transport("webhook").build(),
                stubClient,
                new com.lark.oapi.channel.model.BotIdentity("ou_bot", "TestBot"));
        return channel;
    }

    private static class CommentEventHolder {
        private com.lark.oapi.channel.model.CommentEvent event;
    }

    private static class StubRawClient extends com.lark.oapi.Client {
        private RawResponse getResp;
        private StubImService imService;

        @Override
        public RawResponse get(String httpPath, Object body, com.lark.oapi.core.token.AccessTokenType accessTokenType,
                               com.lark.oapi.core.request.RequestOptions requestOptions) {
            return getResp;
        }

        @Override
        public ImService im() {
            return imService == null ? super.im() : imService;
        }
    }

    private static class StubHttpTransport implements IHttpTransport {
        private RawRequest lastRequest;

        @Override
        public RawResponse execute(RawRequest request) {
            this.lastRequest = request;
            return new RawResponse();
        }
    }

    private static class StubImService extends ImService {
        private final StubMessage message;
        private final StubMessageReaction messageReaction;
        private final StubImage image;
        private final StubFile file;
        private final StubChat chat;

        StubImService(StubMessage message, StubMessageReaction messageReaction, StubImage image, StubFile file, StubChat chat) {
            super(new Config());
            this.message = message;
            this.messageReaction = messageReaction;
            this.image = image;
            this.file = file;
            this.chat = chat;
        }

        @Override
        public Message message() {
            return message;
        }

        @Override
        public MessageReaction messageReaction() {
            return messageReaction;
        }

        @Override
        public Image image() {
            return image;
        }

        @Override
        public File file() {
            return file;
        }

        @Override
        public Chat chat() {
            return chat;
        }
    }

    private static class StubMessage extends Message {
        private CreateMessageReq createReq;
        private UpdateMessageReq updateReq;
        private PatchMessageReq patchReq;
        private ReplyMessageReq replyReq;
        private DeleteMessageReq deleteReq;
        private CreateMessageResp createResp;

        StubMessage() {
            super(new Config());
        }

        @Override
        public CreateMessageResp create(CreateMessageReq req) {
            this.createReq = req;
            return createResp;
        }

        @Override
        public UpdateMessageResp update(UpdateMessageReq req) {
            this.updateReq = req;
            return new UpdateMessageResp();
        }

        @Override
        public PatchMessageResp patch(PatchMessageReq req) {
            this.patchReq = req;
            return new PatchMessageResp();
        }

        @Override
        public ReplyMessageResp reply(ReplyMessageReq req) {
            this.replyReq = req;
            ReplyMessageResp resp = new ReplyMessageResp();
            ReplyMessageRespBody body = new ReplyMessageRespBody();
            body.setMessageId("om_reply");
            resp.setData(body);
            return resp;
        }

        @Override
        public com.lark.oapi.service.im.v1.model.DeleteMessageResp delete(DeleteMessageReq req) {
            this.deleteReq = req;
            return new com.lark.oapi.service.im.v1.model.DeleteMessageResp();
        }
    }

    private static class StubMessageReaction extends MessageReaction {
        private com.lark.oapi.service.im.v1.model.CreateMessageReactionReq createReq;
        private com.lark.oapi.service.im.v1.model.DeleteMessageReactionReq deleteReq;
        private ListMessageReactionReq listReq;
        private CreateMessageReactionResp createResp;
        private ListMessageReactionResp listResp;

        StubMessageReaction() {
            super(new Config());
        }

        @Override
        public CreateMessageReactionResp create(com.lark.oapi.service.im.v1.model.CreateMessageReactionReq req) {
            this.createReq = req;
            return createResp;
        }

        @Override
        public com.lark.oapi.service.im.v1.model.DeleteMessageReactionResp delete(com.lark.oapi.service.im.v1.model.DeleteMessageReactionReq req) {
            this.deleteReq = req;
            return new com.lark.oapi.service.im.v1.model.DeleteMessageReactionResp();
        }

        @Override
        public ListMessageReactionResp list(ListMessageReactionReq req) {
            this.listReq = req;
            return listResp;
        }
    }

    private static class StubImage extends Image {
        private GetImageReq lastReq;
        private GetImageResp resp;

        StubImage() {
            super(new Config());
        }

        @Override
        public GetImageResp get(GetImageReq req) {
            this.lastReq = req;
            return resp;
        }
    }

    private static class StubFile extends File {
        private GetFileReq lastReq;
        private GetFileResp resp;

        StubFile() {
            super(new Config());
        }

        @Override
        public GetFileResp get(GetFileReq req) {
            this.lastReq = req;
            return resp;
        }
    }

    private static class StubChat extends Chat {
        private GetChatReq lastReq;
        private GetChatResp resp;

        StubChat() {
            super(new Config());
        }

        @Override
        public GetChatResp get(GetChatReq req) {
            this.lastReq = req;
            return resp;
        }
    }

}
