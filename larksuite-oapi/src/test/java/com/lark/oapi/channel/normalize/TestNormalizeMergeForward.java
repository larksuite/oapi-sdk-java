package com.lark.oapi.channel.normalize;

import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.service.im.v1.model.Message;
import com.lark.oapi.service.im.v1.model.MessageBody;
import com.lark.oapi.service.im.v1.model.Sender;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TestNormalizeMergeForward {
    private final BotIdentity botIdentity = new BotIdentity("ou_bot", "TestBot");
    private final MentionState emptyMentionState =
            new MentionState(Collections.emptyList(), Collections.emptyMap(), Collections.emptyMap(), false, false);

    @Test
    public void testMergeForwardWithoutFetcherFallsBack() {
        ConvertResult result = MessageConverters.convert("merge_forward", "{}", emptyMentionState,
                new NormalizeOptions(botIdentity, false, true), "om_root");

        Assert.assertEquals("<forwarded_messages/>", result.getContent());
    }

    @Test
    public void testMergeForwardRendersNestedMessagesInTimeOrder() {
        final List<Message> items = new ArrayList<Message>();
        items.add(apiMessage("om_root", null, "merge_forward", "{}", "ou_forwarder", "1710000003000"));
        items.add(apiMessage("om_child_2", "om_root", "text", "{\"text\":\"second\"}", "ou_bob", "1710000002000"));
        items.add(apiMessage("om_nested", "om_root", "merge_forward", "{}", "ou_nested", "1710000002500"));
        items.add(apiMessage("om_grandchild", "om_nested", "text", "{\"text\":\"nested child\"}", "ou_carl", "1710000002600"));
        items.add(apiMessage("om_child_1", "om_root", "text", "{\"text\":\"first\"}", "ou_alice", "1710000001000"));

        ConvertResult result = MessageConverters.convert("merge_forward", "{}", emptyMentionState,
                new NormalizeOptions(botIdentity, false, true, new NormalizeOptions.SubMessageFetcher() {
                    @Override
                    public List<Message> fetch(String messageId) {
                        return items;
                    }
                }, new NormalizeOptions.SenderNameResolver() {
                    @Override
                    public String resolve(String senderId) {
                        if ("ou_alice".equals(senderId)) {
                            return "Alice";
                        }
                        if ("ou_bob".equals(senderId)) {
                            return "Bob";
                        }
                        if ("ou_carl".equals(senderId)) {
                            return "Carl";
                        }
                        return senderId;
                    }
                }), "om_root");

        Assert.assertTrue(result.getContent().startsWith("<forwarded_messages>\n"));
        Assert.assertTrue(result.getContent().contains("Alice:"));
        Assert.assertTrue(result.getContent().contains("Bob:"));
        Assert.assertTrue(result.getContent().contains("nested child"));
        Assert.assertTrue(result.getContent().indexOf("first") < result.getContent().indexOf("second"));
        Assert.assertTrue(result.getContent().contains("</forwarded_messages>"));
    }

    @Test
    public void testMergeForwardMarksTruncatedWhenTooManyChildren() {
        final List<Message> items = new ArrayList<Message>();
        items.add(apiMessage("om_root", null, "merge_forward", "{}", "ou_forwarder", "1710000000000"));
        for (int i = 1; i <= 55; i++) {
            items.add(apiMessage("om_child_" + i, "om_root", "text", "{\"text\":\"child-" + i + "\"}",
                    "ou_" + i, String.valueOf(1710000000000L + i)));
        }

        ConvertResult result = MessageConverters.convert("merge_forward", "{}", emptyMentionState,
                new NormalizeOptions(botIdentity, false, true, new NormalizeOptions.SubMessageFetcher() {
                    @Override
                    public List<Message> fetch(String messageId) {
                        return items;
                    }
                }, null), "om_root");

        Assert.assertTrue(result.getContent().contains("... (truncated)"));
        Assert.assertTrue(result.getContent().contains("child-1"));
        Assert.assertFalse(result.getContent().contains("child-55"));
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
