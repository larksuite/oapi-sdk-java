package com.lark.oapi.channel.normalize;

import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.channel.model.NormalizedMessage;
import com.lark.oapi.service.im.v1.model.Message;
import com.lark.oapi.service.im.v1.model.MessageBody;
import com.lark.oapi.service.im.v1.model.Sender;
import com.lark.oapi.service.im.v1.model.ext.MessageText;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TestNormalize {
    private final ChannelNormalizer normalizer = new ChannelNormalizer();
    private final BotIdentity botIdentity = new BotIdentity("ou_bot", "TestBot");

    @Test
    public void testBasicTextAndSenderNameFallback() {
        NormalizedMessage message = normalizer.normalizeMessage(
                NormalizeTestSupport.buildMessageEvent("om_x", "oc_test", "group", "text", "{\"text\":\"hello\"}", null),
                new NormalizeOptions(botIdentity, false, true, null, new NormalizeOptions.SenderNameResolver() {
                    @Override
                    public String resolve(String senderId) {
                        return "ou_sender".equals(senderId) ? "Alice" : null;
                    }
                }));

        Assert.assertEquals("om_x", message.getMessageId());
        Assert.assertEquals("oc_test", message.getChatId());
        Assert.assertEquals("ou_sender", message.getSenderId());
        Assert.assertEquals("Alice", message.getSenderName());
        Assert.assertEquals("hello", message.getContent());
    }

    @Test
    public void testPostAndImageResource() {
        NormalizedMessage message = normalizer.normalizeMessage(
                NormalizeTestSupport.buildMessageEvent("om_post", "oc_test", "group", "post",
                        "{\"zh_cn\":{\"title\":\"Greeting\",\"content\":[[{\"tag\":\"text\",\"text\":\"hi \"},{\"tag\":\"img\",\"image_key\":\"img_1\"}]]}}",
                        null),
                new NormalizeOptions(botIdentity, false, true));

        Assert.assertTrue(message.getContent().contains("**Greeting**"));
        Assert.assertTrue(message.getContent().contains("![image](img_1)"));
        Assert.assertEquals(1, message.getResources().size());
    }

    @Test
    public void testShareCardMessagesAndChatTypeAreNormalized() {
        NormalizedMessage shareChat = normalizer.normalizeMessage(
                NormalizeTestSupport.buildMessageEvent("om_share_chat", "oc_group", "group", "share_chat",
                        "{\"chat_id\":\"oc_target\"}", null),
                new NormalizeOptions(botIdentity, false, true));
        NormalizedMessage shareUser = normalizer.normalizeMessage(
                NormalizeTestSupport.buildMessageEvent("om_share_user", "oc_group", "group", "share_user",
                        "{\"user_id\":\"ou_target\"}", null),
                new NormalizeOptions(botIdentity, false, true));
        NormalizedMessage p2p = normalizer.normalizeMessage(
                NormalizeTestSupport.buildMessageEvent("om_dm", "oc_dm", "p2p", "text",
                        "{\"text\":\"direct\"}", null),
                new NormalizeOptions(botIdentity, false, true));
        NormalizedMessage group = normalizer.normalizeMessage(
                NormalizeTestSupport.buildMessageEvent("om_group", "oc_group", "group", "text",
                        "{\"text\":\"group\"}", null),
                new NormalizeOptions(botIdentity, false, true));

        Assert.assertEquals("<group_card id=\"oc_target\"/>", shareChat.getContent());
        Assert.assertEquals("<contact_card id=\"ou_target\"/>", shareUser.getContent());
        Assert.assertEquals("p2p", p2p.getChatType());
        Assert.assertEquals("group", group.getChatType());
    }

    @Test
    public void testUnknownAndUnparseableFallback() {
        NormalizedMessage unknown = normalizer.normalizeMessage(
                NormalizeTestSupport.buildMessageEvent("om_unknown", "oc_test", "group", "something_new", "{\"text\":\"sort of\"}", null),
                new NormalizeOptions(botIdentity, false, true));
        NormalizedMessage badPost = normalizer.normalizeMessage(
                NormalizeTestSupport.buildMessageEvent("om_bad", "oc_test", "group", "post", "not valid json", null),
                new NormalizeOptions(botIdentity, false, true));

        Assert.assertEquals("sort of", unknown.getContent());
        Assert.assertEquals("[rich text message]", badPost.getContent());
    }

    @Test
    public void testNormalizeMessageHandlesMentionAllAndMergeForward() {
        final List<Message> items = new ArrayList<Message>();
        items.add(apiMessage("om_root", null, "merge_forward", "{}", "ou_forwarder", "1776849870917"));
        items.add(apiMessage("om_child", "om_root", "text", "{\"text\":\"first child\"}", "ou_alice", "1776753549563"));

        NormalizedMessage merged = normalizer.normalizeMessage(
                NormalizeTestSupport.buildMessageEvent("om_root", "oc_test", "group", "merge_forward", "{}", null),
                new NormalizeOptions(botIdentity, false, true, new NormalizeOptions.SubMessageFetcher() {
                    @Override
                    public List<Message> fetch(String messageId) {
                        return items;
                    }
                }, null));
        NormalizedMessage mentionAll = normalizer.normalizeMessage(
                NormalizeTestSupport.buildMessageEvent("om_all", "oc_test", "group", "text", "{\"text\":\"@_all hello everyone\"}", null),
                new NormalizeOptions(botIdentity, false, true));
        NormalizedMessage mentionAllAtTag = normalizer.normalizeMessage(
                NormalizeTestSupport.buildMessageEvent("om_all_at_tag", "oc_test", "group", "text",
                        MessageText.newBuilder().atAll().text(" hello everyone").build(), null),
                new NormalizeOptions(botIdentity, false, true));

        Assert.assertTrue(merged.getContent().startsWith("<forwarded_messages>\n"));
        Assert.assertTrue(merged.getContent().contains("first child"));
        Assert.assertTrue(mentionAll.isMentionAll());
        Assert.assertTrue(mentionAllAtTag.isMentionAll());
    }

    @Test
    public void testNormalizeMessageReturnsNullForMissingPayload() {
        Assert.assertNull(normalizer.normalizeMessage(null, new NormalizeOptions(botIdentity, false, true)));
        Assert.assertNull(normalizer.normalizeMessage(new com.lark.oapi.service.im.v1.model.P2MessageReceiveV1(),
                new NormalizeOptions(botIdentity, false, true)));
    }

    private Message apiMessage(String messageId, String upperMessageId, String msgType, String content,
                               String senderId, String createTime) {
        return Message.newBuilder()
                .messageId(messageId)
                .upperMessageId(upperMessageId)
                .msgType(msgType)
                .body(MessageBody.newBuilder().content(content).build())
                .sender(Sender.newBuilder().id(senderId).build())
                .createTime(createTime)
                .build();
    }
}
