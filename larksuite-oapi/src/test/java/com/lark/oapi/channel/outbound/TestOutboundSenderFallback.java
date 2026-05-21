package com.lark.oapi.channel.outbound;

import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
import com.lark.oapi.channel.model.SendInput;
import com.lark.oapi.channel.model.SendOptions;
import com.lark.oapi.channel.model.SendResult;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.ReplyMessageResp;
import com.lark.oapi.service.im.v1.model.ReplyMessageRespBody;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class TestOutboundSenderFallback {
    @Test
    public void testReplyWithRevokedTargetFallsBackToCreate() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.replyError = new LarkChannelException(LarkChannelErrorCode.TARGET_REVOKED, "reply target gone");
        message.createResp = OutboundTestSupport.okCreate("om_new");
        OutboundSender sender = createSender(message);

        SendResult result = sender.send("oc_abc", SendInput.text("hi"), SendOptions.newBuilder().replyTo("om_gone").build());

        Assert.assertEquals("om_new", result.getMessageId());
        Assert.assertNotNull(message.replyReq);
        Assert.assertNotNull(message.createReq);
        Assert.assertEquals("text", message.createReq.getCreateMessageReqBody().getMsgType());
    }

    @Test
    public void testSuccessfulReplyDoesNotFallBack() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        ReplyMessageResp replyResp = new ReplyMessageResp();
        ReplyMessageRespBody body = new ReplyMessageRespBody();
        body.setMessageId("om_reply");
        replyResp.setData(body);
        message.replyResp = replyResp;
        OutboundSender sender = createSender(message);

        SendResult result = sender.send("oc_abc", SendInput.text("hi"), SendOptions.newBuilder().replyTo("om_alive").build());

        Assert.assertEquals("om_reply", result.getMessageId());
        Assert.assertNotNull(message.replyReq);
        Assert.assertNull(message.createReq);
    }

    @Test
    public void testNonRevokeReplyErrorStillThrows() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.replyError = new LarkChannelException(LarkChannelErrorCode.PERMISSION_DENIED, "permission denied");
        OutboundSender sender = createSender(message);

        try {
            sender.send("oc_abc", SendInput.text("hi"), SendOptions.newBuilder().replyTo("om_x").build());
            Assert.fail("expected exception");
        } catch (LarkChannelException e) {
            Assert.assertEquals(LarkChannelErrorCode.PERMISSION_DENIED.getValue(), e.getCode());
            Assert.assertNull(message.createReq);
        }
    }

    @Test
    public void testPostFormatErrorFallsBackToText() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.createErrorOnce = new LarkChannelException(LarkChannelErrorCode.FORMAT_ERROR, "bad post");
        message.createResp = OutboundTestSupport.okCreate("om_text");
        OutboundSender sender = createSender(message);

        @SuppressWarnings("unchecked")
        Map<String, Object> badPost = (Map<String, Object>) com.lark.oapi.core.utils.Jsons.DEFAULT.fromJson(
                "{\"zh_cn\":{\"title\":\"bad\",\"content\":[[{\"tag\":\"text\",\"text\":\"hello\"}]]}}", Map.class);
        SendResult result = sender.send("oc_abc", SendInput.post(badPost), null);

        Assert.assertEquals("om_text", result.getMessageId());
        Assert.assertEquals("text", message.createReq.getCreateMessageReqBody().getMsgType());
        Assert.assertTrue(message.createReq.getCreateMessageReqBody().getContent().contains("hello"));
        Assert.assertEquals(2, message.createReqs.size());
        Assert.assertEquals("post", message.createReqs.get(0).getCreateMessageReqBody().getMsgType());
    }

    @Test
    public void testCreateBusinessErrorPreservesCodeAndMessage() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.createResp = OutboundTestSupport.okCreate(null);
        message.createResp.setCode(230001);
        message.createResp.setMsg("invalid content");
        OutboundSender sender = createSender(message);

        try {
            sender.send("oc_abc", SendInput.text("hi"), null);
            Assert.fail("expected create business error");
        } catch (LarkChannelException e) {
            Assert.assertEquals(LarkChannelErrorCode.FORMAT_ERROR.getValue(), e.getCode());
            Assert.assertTrue(e.getMessage().contains("create message failed: code=230001"));
            Assert.assertTrue(e.getMessage().contains("invalid content"));
        }
    }

    @Test
    public void testTextMentionsAndChunkingFlowThroughSender() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.createResp = OutboundTestSupport.okCreate("om_chunk_1");
        OutboundSender sender = createSender(message, 40);

        SendResult result = sender.send("oc_abc", SendInput.text("01234567890123456789"),
                SendOptions.newBuilder().mentions(java.util.Arrays.asList("ou_alice")).build());

        Assert.assertEquals("om_chunk_1", result.getMessageId());
        Assert.assertTrue(result.getChunkIds().size() >= 2);
        @SuppressWarnings("unchecked")
        Map<String, Object> body = (Map<String, Object>) com.lark.oapi.core.utils.Jsons.DEFAULT.fromJson(
                message.createReqs.get(0).getCreateMessageReqBody().getContent(), Map.class);
        Assert.assertTrue(String.valueOf(body.get("text")).contains("<at user_id=\"ou_alice\"></at>"));
    }

    @Test
    public void testCreateRoutesTextMarkdownPostAndCardMessages() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.createResp = OutboundTestSupport.okCreate("om_created");
        OutboundSender sender = createSender(message);

        sender.send("ou_alice", SendInput.text("hello dm"), null);
        Assert.assertEquals("open_id", message.createReq.getReceiveIdType());
        Assert.assertEquals("text", message.createReq.getCreateMessageReqBody().getMsgType());
        Assert.assertEquals("ou_alice", message.createReq.getCreateMessageReqBody().getReceiveId());

        sender.send("oc_group", SendInput.markdown("**hello**"), null);
        Assert.assertEquals("chat_id", message.createReq.getReceiveIdType());
        Assert.assertEquals("post", message.createReq.getCreateMessageReqBody().getMsgType());
        Assert.assertTrue(message.createReq.getCreateMessageReqBody().getContent().contains("hello"));

        @SuppressWarnings("unchecked")
        Map<String, Object> post = (Map<String, Object>) Jsons.DEFAULT.fromJson(
                "{\"zh_cn\":{\"title\":\"T\",\"content\":[[{\"tag\":\"text\",\"text\":\"rich\"}]]}}", Map.class);
        sender.send("oc_group", SendInput.post(post), null);
        Assert.assertEquals("post", message.createReq.getCreateMessageReqBody().getMsgType());
        Assert.assertTrue(message.createReq.getCreateMessageReqBody().getContent().contains("rich"));

        Map<String, Object> card = new LinkedHashMap<String, Object>();
        card.put("config", Collections.singletonMap("wide_screen_mode", true));
        card.put("elements", Collections.singletonList(Collections.singletonMap("tag", "markdown")));
        sender.send("oc_group", SendInput.card(card), null);
        Assert.assertEquals("interactive", message.createReq.getCreateMessageReqBody().getMsgType());
        Assert.assertTrue(message.createReq.getCreateMessageReqBody().getContent().contains("wide_screen_mode"));
    }

    @Test
    public void testReplyMarkdownAndThreadFlagFlowThroughRequest() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        ReplyMessageResp replyResp = new ReplyMessageResp();
        ReplyMessageRespBody body = new ReplyMessageRespBody();
        body.setMessageId("om_thread_reply");
        replyResp.setData(body);
        message.replyResp = replyResp;
        OutboundSender sender = createSender(message);

        SendResult result = sender.send("oc_group", SendInput.markdown("thread reply"),
                SendOptions.newBuilder().replyTo("om_parent").replyInThread(true).build());

        Assert.assertEquals("om_thread_reply", result.getMessageId());
        Assert.assertEquals("om_parent", message.replyReq.getMessageId());
        Assert.assertEquals("post", message.replyReq.getReplyMessageReqBody().getMsgType());
        Assert.assertEquals(Boolean.TRUE, message.replyReq.getReplyMessageReqBody().getReplyInThread());
    }

    @Test
    public void testRetryableCreateFailureRetriesBeforeSuccess() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.createErrorOnce = new LarkChannelException(LarkChannelErrorCode.RATE_LIMITED, "429 too many requests");
        message.createResp = OutboundTestSupport.okCreate("om_retry_ok");
        LarkChannelOptions options = OutboundTestSupport.options();
        options.getOutbound().getRetry().setMaxAttempts(2);
        options.getOutbound().getRetry().setBaseDelayMs(0L);
        Client client = OutboundTestSupport.createClient(message, new OutboundTestSupport.StubMessageReaction(),
                new OutboundTestSupport.StubImage(), new OutboundTestSupport.StubFile());
        OutboundSender sender = new OutboundSender(client, options);

        SendResult result = sender.send("oc_group", SendInput.text("retry me"), null);

        Assert.assertEquals("om_retry_ok", result.getMessageId());
        Assert.assertEquals(2, message.createReqs.size());
    }

    private OutboundSender createSender(OutboundTestSupport.StubMessage message) throws Exception {
        return createSender(message, 3500);
    }

    private OutboundSender createSender(OutboundTestSupport.StubMessage message, int chunkLimit) throws Exception {
        OutboundTestSupport.StubMessageReaction reaction = new OutboundTestSupport.StubMessageReaction();
        OutboundTestSupport.StubImage image = new OutboundTestSupport.StubImage();
        OutboundTestSupport.StubFile file = new OutboundTestSupport.StubFile();
        Client client = OutboundTestSupport.createClient(message, reaction, image, file);
        LarkChannelOptions options = OutboundTestSupport.options();
        options.getOutbound().setTextChunkLimit(chunkLimit);
        return new OutboundSender(client, options);
    }
}
