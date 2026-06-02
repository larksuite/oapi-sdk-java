package com.lark.oapi.channel.safety;

import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.model.MentionInfo;
import com.lark.oapi.channel.model.NormalizedMessage;
import com.lark.oapi.channel.model.RejectEvent;
import com.lark.oapi.channel.model.RejectReason;
import com.lark.oapi.channel.model.ResourceDescriptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;

public class TestSafetyPipeline {
    @Test
    public void testPushMessageBatchesContentResourcesAndMentions() {
        LarkChannelOptions.SafetyConfig safety = new LarkChannelOptions.SafetyConfig();
        safety.getBatchText().setMaxMessages(2);
        LarkChannelOptions.PolicyConfig policy = new LarkChannelOptions.PolicyConfig();
        policy.setRequireMention(false);
        final List<NormalizedMessage> dispatched = new ArrayList<NormalizedMessage>();
        SafetyPipeline pipeline = new SafetyPipeline(new SafetyPipelineOptions(
                safety,
                policy,
                null,
                null,
                new OnMessageDispatch() {
                    @Override
                    public void onMessage(NormalizedMessage message) {
                        dispatched.add(message);
                    }
                }));

        pipeline.pushMessage(message(
                "om_1",
                "first",
                Collections.singletonList(new ResourceDescriptor("image", "file_a", null, null)),
                Collections.singletonList(new MentionInfo("@_u1", "ou_1", "Alice", false))));
        pipeline.pushMessage(message(
                "om_2",
                "second",
                Arrays.asList(
                        new ResourceDescriptor("image", "file_a", null, null),
                        new ResourceDescriptor("file", "file_b", "b.txt", null)),
                Collections.singletonList(new MentionInfo("@_u1", "ou_1", "Alice", false))));
        pipeline.dispose();

        Assert.assertEquals(1, dispatched.size());
        NormalizedMessage merged = dispatched.get(0);
        Assert.assertEquals("om_2", merged.getMessageId());
        Assert.assertEquals("first\n\nsecond", merged.getContent());
        Assert.assertEquals(2, merged.getResources().size());
        Assert.assertEquals(1, merged.getMentions().size());
    }

    @Test
    public void testPushActionDeduplicatesAndKeepsScopeSerial() {
        LarkChannelOptions.SafetyConfig safety = new LarkChannelOptions.SafetyConfig();
        final List<String> order = new ArrayList<String>();
        SafetyPipeline pipeline = new SafetyPipeline(new SafetyPipelineOptions(
                safety,
                new LarkChannelOptions.PolicyConfig(),
                null,
                null,
                new OnMessageDispatch() {
                    @Override
                    public void onMessage(NormalizedMessage message) {
                        order.add("message:" + message.getContent());
                    }
                }));

        pipeline.pushAction("card:1", "oc_group", new Runnable() {
            @Override
            public void run() {
                order.add("first");
            }
        });
        pipeline.pushAction("card:1", "oc_group", new Runnable() {
            @Override
            public void run() {
                order.add("duplicate");
            }
        });
        pipeline.pushAction("card:2", "oc_group", new Runnable() {
            @Override
            public void run() {
                order.add("second");
            }
        });

        Assert.assertEquals(Arrays.asList("first", "second"), order);
    }

    @Test
    public void testPolicyRejectInvokesOnRejectWithoutDispatch() {
        LarkChannelOptions.PolicyConfig policy = new LarkChannelOptions.PolicyConfig();
        policy.setRequireMention(true);
        final List<RejectEvent> rejects = new ArrayList<RejectEvent>();
        final AtomicInteger dispatched = new AtomicInteger();
        SafetyPipeline pipeline = new SafetyPipeline(new SafetyPipelineOptions(
                new LarkChannelOptions.SafetyConfig(),
                policy,
                null,
                new OnReject() {
                    @Override
                    public void onReject(RejectEvent event) {
                        rejects.add(event);
                    }
                },
                new OnMessageDispatch() {
                    @Override
                    public void onMessage(NormalizedMessage message) {
                        dispatched.incrementAndGet();
                    }
                }));

        pipeline.pushMessage(message("om_no_mention", "hello", Collections.<ResourceDescriptor>emptyList(),
                Collections.<MentionInfo>emptyList()));

        Assert.assertEquals(0, dispatched.get());
        Assert.assertEquals(1, rejects.size());
        Assert.assertEquals(RejectReason.NO_MENTION, rejects.get(0).getReason());
        Assert.assertEquals("no_mention", rejects.get(0).getReason().getValue());
        Assert.assertEquals("no_mention", rejects.get(0).getReason().toString());
        Assert.assertEquals("om_no_mention", rejects.get(0).getMessageId());
        Assert.assertEquals("oc_group", rejects.get(0).getChatId());
        Assert.assertEquals("ou_user", rejects.get(0).getSenderId());
    }

    @Test
    public void testGroupAllowlistRejectsOutsideAndAllowsInside() {
        LarkChannelOptions.PolicyConfig policy = new LarkChannelOptions.PolicyConfig();
        policy.setRequireMention(false);
        policy.setGroupAllowlist("oc_allowed");
        PolicyGate gate = new PolicyGate(policy);

        Assert.assertEquals(RejectReason.GROUP_NOT_ALLOWED,
                gate.evaluate(message("om_outside", "oc_outside", "group", "ou_user", "hello", false, false)));
        Assert.assertNull(gate.evaluate(message("om_inside", "oc_allowed", "group", "ou_user", "hello", false, false)));
    }

    @Test
    public void testDmDisabledAndAllowlistModes() {
        LarkChannelOptions.PolicyConfig disabled = new LarkChannelOptions.PolicyConfig();
        disabled.setDmMode("disabled");
        PolicyGate disabledGate = new PolicyGate(disabled);

        Assert.assertEquals(RejectReason.DM_DISABLED,
                disabledGate.evaluate(message("om_dm", "oc_dm", "p2p", "ou_alice", "hello", false, false)));

        LarkChannelOptions.PolicyConfig allowlist = new LarkChannelOptions.PolicyConfig();
        allowlist.setDmMode("allowlist");
        allowlist.setDmAllowlist("ou_allowed");
        PolicyGate allowlistGate = new PolicyGate(allowlist);

        Assert.assertEquals(RejectReason.SENDER_NOT_ALLOWED,
                allowlistGate.evaluate(message("om_dm_blocked", "oc_dm", "p2p", "ou_blocked", "hello", false, false)));
        Assert.assertNull(allowlistGate.evaluate(
                message("om_dm_allowed", "oc_dm", "p2p", "ou_allowed", "hello", false, false)));
    }

    @Test
    public void testMentionAllPolicyAllowsAllWhenRequireMentionDisabled() {
        LarkChannelOptions.PolicyConfig policy = new LarkChannelOptions.PolicyConfig();
        policy.setRequireMention(false);
        policy.setRespondToMentionAll(true);
        PolicyGate gate = new PolicyGate(policy);

        Assert.assertNull(gate.evaluate(message("om_all", "oc_group", "group", "ou_user", "@all hello", false, true)));
    }

    @Test
    public void testMentionAllPolicyAllowsAllWhenRequireMentionEnabled() {
        LarkChannelOptions.PolicyConfig policy = new LarkChannelOptions.PolicyConfig();
        policy.setRequireMention(true);
        policy.setRespondToMentionAll(true);
        PolicyGate gate = new PolicyGate(policy);

        Assert.assertNull(gate.evaluate(message("om_all", "oc_group", "group", "ou_user", "@all hello", false, true)));
    }

    @Test
    public void testMentionAllPolicyRejectsBeforeRequireMention() {
        LarkChannelOptions.PolicyConfig policy = new LarkChannelOptions.PolicyConfig();
        policy.setRequireMention(true);
        policy.setRespondToMentionAll(false);
        PolicyGate gate = new PolicyGate(policy);

        Assert.assertEquals(RejectReason.MENTION_ALL_BLOCKED,
                gate.evaluate(message("om_all_blocked", "oc_group", "group", "ou_user", "@all hello", false, true)));
    }

    private NormalizedMessage message(String id, String content, List<ResourceDescriptor> resources,
                                      List<MentionInfo> mentions) {
        return new NormalizedMessage(
                id,
                "oc_group",
                "group",
                "ou_user",
                null,
                content,
                "text",
                resources,
                mentions,
                false,
                false,
                null,
                null,
                null,
                System.currentTimeMillis(),
                null);
    }

    private NormalizedMessage message(String id, String chatId, String chatType, String senderId, String content,
                                      boolean mentionedBot, boolean mentionAll) {
        return new NormalizedMessage(
                id,
                chatId,
                chatType,
                senderId,
                null,
                content,
                "text",
                Collections.<ResourceDescriptor>emptyList(),
                mentionedBot
                        ? Collections.singletonList(new MentionInfo("@_bot", "ou_bot", "Bot", false))
                        : Collections.<MentionInfo>emptyList(),
                mentionAll,
                mentionedBot,
                null,
                null,
                null,
                System.currentTimeMillis(),
                null);
    }
}
