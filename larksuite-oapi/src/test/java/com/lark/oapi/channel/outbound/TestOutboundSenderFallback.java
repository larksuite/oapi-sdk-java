package com.lark.oapi.channel.outbound;

import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
import com.lark.oapi.channel.model.SendInput;
import com.lark.oapi.channel.model.SendOptions;
import com.lark.oapi.channel.model.SendResult;
import com.lark.oapi.service.im.v1.model.ReplyMessageResp;
import com.lark.oapi.service.im.v1.model.ReplyMessageRespBody;
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
