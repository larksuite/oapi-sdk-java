package com.lark.oapi.channel.outbound;

import com.lark.oapi.Client;
import com.lark.oapi.channel.model.CardStreamController;
import com.lark.oapi.channel.model.CardStreamProducer;
import com.lark.oapi.channel.model.MarkdownStreamController;
import com.lark.oapi.channel.model.MarkdownStreamProducer;
import com.lark.oapi.channel.model.SendOptions;
import com.lark.oapi.channel.model.SendResult;
import com.lark.oapi.channel.model.StreamInput;
import com.lark.oapi.service.im.v1.model.ReplyMessageResp;
import com.lark.oapi.service.im.v1.model.ReplyMessageRespBody;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class TestOutboundStreaming {
    @Test
    public void testMarkdownStreamCreatesCardAndUpdatesElement() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.createResp = OutboundTestSupport.okCreate("om_stream");
        ReplyMessageResp replyResp = new ReplyMessageResp();
        ReplyMessageRespBody replyBody = new ReplyMessageRespBody();
        replyBody.setMessageId("om_stream");
        replyResp.setData(replyBody);
        message.replyResp = replyResp;
        OutboundTestSupport.StubCardResource card = new OutboundTestSupport.StubCardResource();
        card.createResp = OutboundTestSupport.okCard("card_1");
        OutboundTestSupport.StubCardElementResource cardElement = new OutboundTestSupport.StubCardElementResource();
        OutboundSender sender = createSender(message, card, cardElement);

        SendResult result = sender.stream("oc_abc", StreamInput.markdown(new MarkdownStreamProducer() {
            @Override
            public void produce(MarkdownStreamController controller) {
                controller.append("hello");
                controller.append(" world");
            }
        }), SendOptions.newBuilder().replyTo("om_parent").build());

        Assert.assertEquals("om_stream", result.getMessageId());
        Assert.assertNotNull(card.createReq);
        String cardData = card.createReq.getCreateCardReqBody().getData();
        Assert.assertTrue(cardData.contains("\"header\""));
        Assert.assertTrue(cardData.contains("\"body\""));
        Assert.assertFalse(cardData.contains("streaming_config"));
        Assert.assertNotNull(cardElement.patchReq);
        Assert.assertTrue(cardElement.patchReq.getPatchCardElementReqBody().getPartialElement().contains("hello world"));
        Assert.assertNotNull(card.settingsReq);
        Assert.assertEquals("om_parent", message.replyReq.getMessageId());
    }

    @Test
    public void testCardStreamSendsInteractiveAndPatches() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.createResp = OutboundTestSupport.okCreate("om_card_stream");
        OutboundSender sender = createSender(message, new OutboundTestSupport.StubCardResource(),
                new OutboundTestSupport.StubCardElementResource());

        Map<String, Object> initial = new LinkedHashMap<String, Object>();
        initial.put("schema", "2.0");
        initial.put("elements", Collections.singletonList(Collections.singletonMap("tag", "markdown")));

        SendResult result = sender.stream("oc_abc", StreamInput.card(initial, new CardStreamProducer() {
            @Override
            public void produce(CardStreamController controller) {
                Map<String, Object> next = new LinkedHashMap<String, Object>(controller.getCurrent());
                next.put("version", "2");
                controller.update(next);
            }
        }), null);

        Assert.assertEquals("om_card_stream", result.getMessageId());
        Assert.assertEquals("interactive", message.createReq.getCreateMessageReqBody().getMsgType());
        Assert.assertNotNull(message.patchReq);
        Assert.assertTrue(message.patchReq.getPatchMessageReqBody().getContent().contains("\"version\":\"2\""));
    }

    @Test
    public void testMarkdownStreamFailureFinalizesCard() throws Exception {
        OutboundTestSupport.StubMessage message = new OutboundTestSupport.StubMessage();
        message.createResp = OutboundTestSupport.okCreate("om_stream");
        OutboundTestSupport.StubCardResource card = new OutboundTestSupport.StubCardResource();
        card.createResp = OutboundTestSupport.okCard("card_1");
        OutboundTestSupport.StubCardElementResource cardElement = new OutboundTestSupport.StubCardElementResource();
        OutboundSender sender = createSender(message, card, cardElement);

        try {
            sender.stream("oc_abc", StreamInput.markdown(new MarkdownStreamProducer() {
                @Override
                public void produce(MarkdownStreamController controller) {
                    controller.append("partial");
                    throw new RuntimeException("boom");
                }
            }), null);
            Assert.fail("expected exception");
        } catch (RuntimeException e) {
            Assert.assertNotNull(cardElement.patchReq);
            Assert.assertTrue(cardElement.patchReq.getPatchCardElementReqBody().getPartialElement().contains("Generation interrupted"));
            Assert.assertNotNull(card.settingsReq);
        }
    }

    private OutboundSender createSender(OutboundTestSupport.StubMessage message, OutboundTestSupport.StubCardResource card,
                                        OutboundTestSupport.StubCardElementResource cardElement) throws Exception {
        Client client = OutboundTestSupport.createClient(message, new OutboundTestSupport.StubMessageReaction(),
                new OutboundTestSupport.StubImage(), new OutboundTestSupport.StubFile(), card, cardElement);
        return new OutboundSender(client, OutboundTestSupport.options());
    }
}
