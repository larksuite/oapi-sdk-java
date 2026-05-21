package com.lark.oapi.channel.normalize;

import com.lark.oapi.channel.model.BotIdentity;
import org.junit.Assert;
import org.junit.Test;

public class TestNormalizeMentions {
    @Test
    public void testExtractMentionsDetectsBotAndAll() {
        MentionState state = Mentions.extract(new com.lark.oapi.service.im.v1.model.MentionEvent[] {
                NormalizeTestSupport.mention("@_user_1", "ou_alice", "Alice"),
                NormalizeTestSupport.mention("@_bot", "ou_bot", "Bot"),
                com.lark.oapi.service.im.v1.model.MentionEvent.newBuilder().key("@_all").name("所有人").build()
        }, null, new BotIdentity("ou_bot", "Bot"));

        Assert.assertEquals(2, state.getMentions().size());
        Assert.assertTrue(state.isMentionAll());
        Assert.assertTrue(state.isMentionedBot());
        Assert.assertNotNull(state.getByOpenId().get("ou_alice"));
    }

    @Test
    public void testExtractMentionsKeepsUserIdAndDoesNotScanRawBotOpenId() {
        com.lark.oapi.service.im.v1.model.MentionEvent event =
                com.lark.oapi.service.im.v1.model.MentionEvent.newBuilder()
                        .key("@_user_1")
                        .name("Alice")
                        .id(com.lark.oapi.service.im.v1.model.UserId.newBuilder()
                                .openId("ou_alice")
                                .userId("u_alice")
                                .build())
                        .build();

        MentionState state = Mentions.extract(new com.lark.oapi.service.im.v1.model.MentionEvent[] {event},
                "{\"text\":\"ou_bot appears as plain text\"}", new BotIdentity("ou_bot", "Bot"));

        Assert.assertEquals("u_alice", state.getMentions().get(0).getUserId());
        Assert.assertFalse(state.isMentionedBot());
    }

    @Test
    public void testResolveMentionsStripsBotByDefault() {
        MentionState state = Mentions.extract(new com.lark.oapi.service.im.v1.model.MentionEvent[] {
                NormalizeTestSupport.mention("@_bot", "ou_bot", "Bot")
        }, null, new BotIdentity("ou_bot", "Bot"));

        Assert.assertEquals("help me", Mentions.replaceKeys("@_bot help me", state, true));
        Assert.assertEquals("@Bot help me", Mentions.replaceKeys("@_bot help me", state, false));
    }

    @Test
    public void testMentionAllContentScanAvoidsFalsePositive() {
        MentionState positive = Mentions.extract((com.lark.oapi.service.im.v1.model.MentionEvent[]) null,
                "{\"text\":\"@_all hello\"}", new BotIdentity("ou_bot", "Bot"));
        MentionState negative = Mentions.extract((com.lark.oapi.service.im.v1.model.MentionEvent[]) null,
                "{\"text\":\"@_allies hello\"}", new BotIdentity("ou_bot", "Bot"));

        Assert.assertTrue(positive.isMentionAll());
        Assert.assertFalse(negative.isMentionAll());
    }
}
