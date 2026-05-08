package com.lark.oapi.channel;

import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.channel.model.NormalizedMessage;
import com.lark.oapi.channel.model.RejectReason;
import com.lark.oapi.channel.normalize.ChannelNormalizer;
import com.lark.oapi.channel.normalize.NormalizeOptions;
import com.lark.oapi.channel.safety.SafetyPipeline;
import com.lark.oapi.service.im.v1.model.EventMessage;
import com.lark.oapi.service.im.v1.model.EventSender;
import com.lark.oapi.service.im.v1.model.MentionEvent;
import com.lark.oapi.service.im.v1.model.Message;
import com.lark.oapi.service.im.v1.model.MessageBody;
import com.lark.oapi.service.im.v1.model.P2MessageReceiveV1;
import com.lark.oapi.service.im.v1.model.P2MessageReceiveV1Data;
import com.lark.oapi.service.im.v1.model.Sender;
import com.lark.oapi.service.im.v1.model.UserId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Assert;
import org.junit.Test;

public class TestNormalizeAndSafety {
    @Test
    public void testNormalizeTextMentionsAndStripBotMention() {
        ChannelNormalizer normalizer = new ChannelNormalizer();
        P2MessageReceiveV1 event = buildMessageEvent(
                "om_text",
                "oc_group",
                "group",
                "text",
                "{\"text\":\"@_user_1 hello @_user_2\"}",
                new MentionEvent[] {
                        mention("@_user_1", "ou_alice", "Alice"),
                        mention("@_user_2", "ou_bot", "TestBot")
                });

        NormalizedMessage normalized = normalizer.normalizeMessage(
                event,
                new NormalizeOptions(new BotIdentity("ou_bot", "TestBot"), true, true));

        Assert.assertEquals("@Alice hello", normalized.getContent());
        Assert.assertEquals(2, normalized.getMentions().size());
        Assert.assertTrue(normalized.isMentionedBot());
        Assert.assertSame(event, normalized.getRaw());
    }

    @Test
    public void testNormalizeInteractiveExtractsText() {
        ChannelNormalizer normalizer = new ChannelNormalizer();
        P2MessageReceiveV1 event = buildMessageEvent(
                "om_card",
                "oc_group",
                "group",
                "interactive",
                "{\"header\":{\"title\":{\"tag\":\"plain_text\",\"content\":\"Card Title\"}},\"elements\":[{\"tag\":\"div\",\"text\":{\"tag\":\"plain_text\",\"content\":\"Card Body\"}}]}",
                null);

        NormalizedMessage normalized = normalizer.normalizeMessage(
                event,
                new NormalizeOptions(new BotIdentity("ou_bot", "TestBot"), false, true));

        Assert.assertTrue(normalized.getContent().contains("Card Title"));
        Assert.assertTrue(normalized.getContent().contains("Card Body"));
    }

    @Test
    public void testNormalizeLongTailMessageTypesMatchNodeTags() {
        ChannelNormalizer normalizer = new ChannelNormalizer();

        NormalizedMessage location = normalizer.normalizeMessage(
                buildMessageEvent("om_loc", "oc_group", "group", "location",
                        "{\"name\":\"Cafe\",\"latitude\":\"39.9\",\"longitude\":\"116.4\"}", null),
                new NormalizeOptions(new BotIdentity("ou_bot", "TestBot"), false, true));
        Assert.assertEquals("<location name=\"Cafe\" coords=\"lat:39.9,lng:116.4\"/>", location.getContent());

        NormalizedMessage vote = normalizer.normalizeMessage(
                buildMessageEvent("om_vote", "oc_group", "group", "vote",
                        "{\"topic\":\"Lunch?\",\"options\":[\"A\",\"B\"]}", null),
                new NormalizeOptions(new BotIdentity("ou_bot", "TestBot"), false, true));
        Assert.assertEquals("<vote>\nLunch?\n\u2022 A\n\u2022 B\n</vote>", vote.getContent());

        NormalizedMessage unknown = normalizer.normalizeMessage(
                buildMessageEvent("om_unknown", "oc_group", "group", "unknown",
                        "{\"random\":\"value\"}", null),
                new NormalizeOptions(new BotIdentity("ou_bot", "TestBot"), false, true));
        Assert.assertEquals("[unsupported message]", unknown.getContent());
    }

    @Test
    public void testNormalizeCalendarAndTodoMatchNodeFormat() {
        ChannelNormalizer normalizer = new ChannelNormalizer();

        NormalizedMessage calendar = normalizer.normalizeMessage(
                buildMessageEvent("om_calendar", "oc_group", "group", "calendar",
                        "{\"summary\":\"Weekly Sync\",\"start_time\":\"1710000000000\",\"end_time\":\"1710003600000\"}", null),
                new NormalizeOptions(new BotIdentity("ou_bot", "TestBot"), false, true));
        Assert.assertTrue(calendar.getContent().startsWith("<calendar_invite>\n"));
        Assert.assertTrue(calendar.getContent().contains("\uD83D\uDCC5 Weekly Sync"));
        Assert.assertTrue(calendar.getContent().contains("\uD83D\uDD59 "));

        NormalizedMessage todo = normalizer.normalizeMessage(
                buildMessageEvent("om_todo", "oc_group", "group", "todo",
                        "{\"summary\":{\"title\":\"Ship it\",\"content\":[[{\"tag\":\"text\",\"text\":\"Write tests\"}]]},\"due_time\":\"1710000000000\"}", null),
                new NormalizeOptions(new BotIdentity("ou_bot", "TestBot"), false, true));
        Assert.assertEquals("<todo>\nShip it\nWrite tests\nDue: 2024-03-10 00:00\n</todo>", todo.getContent());
    }

    @Test
    public void testNormalizeMergeForwardBuildsNestedForwardedMessages() {
        ChannelNormalizer normalizer = new ChannelNormalizer();
        final List<Message> items = new ArrayList<Message>();
        items.add(apiMessage("om_root", null, "merge_forward", "{}", "ou_forwarder", "1776849870917"));
        items.add(apiMessage("om_child_a", "om_root", "text", "{\"text\":\"first child\"}", "ou_alice", "1776753549563"));
        items.add(apiMessage("om_child_b", "om_root", "text", "{\"text\":\"second child\"}", "ou_bob", "1776753669281"));

        NormalizedMessage normalized = normalizer.normalizeMessage(
                buildMessageEvent("om_root", "oc_group", "group", "merge_forward", "{}", null),
                new NormalizeOptions(
                        new BotIdentity("ou_bot", "TestBot"),
                        false,
                        true,
                        new NormalizeOptions.SubMessageFetcher() {
                            @Override
                            public List<Message> fetch(String messageId) {
                                return items;
                            }
                        },
                        null));

        Assert.assertTrue(normalized.getContent().startsWith("<forwarded_messages>\n"));
        Assert.assertFalse(normalized.getContent().contains("Merged and Forwarded Message"));
        Assert.assertTrue(normalized.getContent().contains("first child"));
        Assert.assertTrue(normalized.getContent().contains("second child"));
        Assert.assertTrue(normalized.getContent().indexOf("first child") < normalized.getContent().indexOf("second child"));
    }

    @Test
    public void testSafetyPushMessageRejectsWithoutEmittingTask() {
        LarkChannelOptions.PolicyConfig policy = new LarkChannelOptions.PolicyConfig();
        policy.setRequireMention(true);
        LarkChannelOptions.SafetyConfig safety = new LarkChannelOptions.SafetyConfig();
        SafetyPipeline pipeline = new SafetyPipeline(safety, policy, null);
        final AtomicInteger executed = new AtomicInteger();
        final List<RejectReason> rejects = new ArrayList<RejectReason>();

        pipeline.pushMessage("message:1", "oc_group", new NormalizedMessage(
                        "om_1", "oc_group", "group", "ou_user", null, "hello", "text",
                        Collections.<com.lark.oapi.channel.model.ResourceDescriptor>emptyList(),
                        Collections.<com.lark.oapi.channel.model.MentionInfo>emptyList(),
                        false, false, null, null, null, System.currentTimeMillis(), null),
                new Runnable() {
                    @Override
                    public void run() {
                        executed.incrementAndGet();
                    }
                },
                new SafetyPipeline.RejectListener() {
                    @Override
                    public void onReject(RejectReason reason, Object raw) {
                        rejects.add(reason);
                    }
                });

        Assert.assertEquals(0, executed.get());
        Assert.assertEquals(Collections.singletonList(RejectReason.NO_MENTION), rejects);
    }

    @Test
    public void testSafetyPushActionDeduplicatesAndStaleMessageIsSilent() {
        LarkChannelOptions.SafetyConfig safety = new LarkChannelOptions.SafetyConfig();
        safety.setStaleMessageWindowMs(1000L);
        SafetyPipeline pipeline = new SafetyPipeline(safety, new LarkChannelOptions.PolicyConfig(), null);
        final AtomicInteger actionCount = new AtomicInteger();
        final AtomicInteger staleCount = new AtomicInteger();
        final AtomicInteger rejectCount = new AtomicInteger();

        pipeline.pushAction("card:1", "oc_group", new Runnable() {
            @Override
            public void run() {
                actionCount.incrementAndGet();
            }
        });
        pipeline.pushAction("card:1", "oc_group", new Runnable() {
            @Override
            public void run() {
                actionCount.incrementAndGet();
            }
        });

        pipeline.pushMessage("message:stale", "oc_group", new NormalizedMessage(
                        "om_old", "oc_group", "group", "ou_user", null, "@TestBot hi", "text",
                        Collections.<com.lark.oapi.channel.model.ResourceDescriptor>emptyList(),
                        Collections.<com.lark.oapi.channel.model.MentionInfo>emptyList(),
                        false, true, null, null, null, System.currentTimeMillis() - 5000L, null),
                new Runnable() {
                    @Override
                    public void run() {
                        staleCount.incrementAndGet();
                    }
                },
                new SafetyPipeline.RejectListener() {
                    @Override
                    public void onReject(RejectReason reason, Object raw) {
                        rejectCount.incrementAndGet();
                    }
                });

        Assert.assertEquals(1, actionCount.get());
        Assert.assertEquals(0, staleCount.get());
        Assert.assertEquals(0, rejectCount.get());
    }

    private P2MessageReceiveV1 buildMessageEvent(String messageId, String chatId, String chatType,
                                                 String messageType, String content, MentionEvent[] mentions) {
        EventMessage message = EventMessage.newBuilder()
                .messageId(messageId)
                .chatId(chatId)
                .chatType(chatType)
                .messageType(messageType)
                .content(content)
                .mentions(mentions)
                .createTime(String.valueOf(System.currentTimeMillis()))
                .build();
        EventSender sender = EventSender.newBuilder()
                .senderId(UserId.newBuilder().openId("ou_sender").build())
                .build();
        P2MessageReceiveV1Data data = new P2MessageReceiveV1Data();
        data.setMessage(message);
        data.setSender(sender);
        P2MessageReceiveV1 event = new P2MessageReceiveV1();
        event.setEvent(data);
        return event;
    }

    private MentionEvent mention(String key, String openId, String name) {
        return MentionEvent.newBuilder()
                .key(key)
                .name(name)
                .id(UserId.newBuilder().openId(openId).build())
                .build();
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
