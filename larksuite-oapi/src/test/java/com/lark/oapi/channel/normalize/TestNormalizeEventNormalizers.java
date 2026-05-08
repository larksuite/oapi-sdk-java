package com.lark.oapi.channel.normalize;

import com.google.gson.JsonObject;
import com.lark.oapi.core.request.EventReq;
import com.lark.oapi.channel.model.BotAddedEvent;
import com.lark.oapi.channel.model.CardActionEvent;
import com.lark.oapi.channel.model.CommentEvent;
import com.lark.oapi.channel.model.ReactionEvent;
import com.lark.oapi.event.cardcallback.model.CallBackAction;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class TestNormalizeEventNormalizers {
    @Test
    public void testCardActionRequiresContextAndDefaultsTag() {
        CardActionNormalizer normalizer = new CardActionNormalizer();
        CardActionEvent event = normalizer.normalize(
                NormalizeTestSupport.buildCardAction("om_1", "oc_1", "ou_alice", null, Collections.<String, Object>emptyMap()));

        Assert.assertNotNull(event);
        Assert.assertEquals("om_1", event.getMessageId());
        Assert.assertEquals("oc_1", event.getChatId());
        Assert.assertEquals("ou_alice", event.getOperatorId());
        Assert.assertEquals("unknown", event.getActionTag());
        Assert.assertNull(normalizer.normalize(new com.lark.oapi.event.cardcallback.model.P2CardActionTrigger()));
    }

    @Test
    public void testCardActionFallsBackToTopLevelPayloadFields() {
        CardActionNormalizer normalizer = new CardActionNormalizer();
        com.lark.oapi.event.cardcallback.model.P2CardActionTrigger raw = new com.lark.oapi.event.cardcallback.model.P2CardActionTrigger();
        EventReq req = new EventReq();
        req.setPlain("{\"open_message_id\":\"om_top\",\"open_chat_id\":\"oc_top\",\"operator\":{\"open_id\":\"ou_alice\",\"name\":\"Alice\"},\"action\":{\"tag\":\"button\",\"name\":\"approve\",\"option\":\"A\",\"value\":{\"cmd\":\"go\"}}}");
        raw.setEventReq(req);

        CardActionEvent event = normalizer.normalize(raw);

        Assert.assertNotNull(event);
        Assert.assertEquals("om_top", event.getMessageId());
        Assert.assertEquals("oc_top", event.getChatId());
        Assert.assertEquals("ou_alice", event.getOperatorId());
        Assert.assertEquals("button", event.getActionTag());
        Assert.assertEquals("approve", event.getActionName());
        Assert.assertEquals("A", event.getActionOption());
        Assert.assertEquals("go", event.getActionValue().get("cmd"));
    }

    @Test
    public void testCardActionDedupKeyIncludesNameAndOption() {
        CardActionNormalizer normalizer = new CardActionNormalizer();
        ChannelNormalizer channelNormalizer = new ChannelNormalizer();
        com.lark.oapi.event.cardcallback.model.P2CardActionTrigger firstRaw =
                NormalizeTestSupport.buildCardAction("om_1", "oc_1", "ou_alice", "button", Collections.<String, Object>singletonMap("cmd", "same"));
        CallBackAction firstAction = firstRaw.getEvent().getAction();
        firstAction.setName("approve");
        firstAction.setOption("A");
        com.lark.oapi.event.cardcallback.model.P2CardActionTrigger secondRaw =
                NormalizeTestSupport.buildCardAction("om_1", "oc_1", "ou_alice", "button", Collections.<String, Object>singletonMap("cmd", "same"));
        CallBackAction secondAction = secondRaw.getEvent().getAction();
        secondAction.setName("reject");
        secondAction.setOption("B");

        CardActionEvent first = normalizer.normalize(firstRaw);
        CardActionEvent second = normalizer.normalize(secondRaw);

        Assert.assertEquals("approve", first.getActionName());
        Assert.assertEquals("A", first.getActionOption());
        Assert.assertNotEquals(channelNormalizer.buildCardActionDedupKey(first),
                channelNormalizer.buildCardActionDedupKey(second));
    }

    @Test
    public void testReactionRequiresOperatorAndEmoji() {
        ReactionNormalizer normalizer = new ReactionNormalizer();
        ReactionEvent added = normalizer.normalize(
                NormalizeTestSupport.buildReactionCreated("om_1", "OK", "ou_alice", null, "1000000000000"), "added");

        Assert.assertNotNull(added);
        Assert.assertEquals("added", added.getAction());
        Assert.assertEquals("OK", added.getEmojiType());
        Assert.assertEquals(1000000000000L, added.getActionTime());
        Assert.assertNull(normalizer.normalize(
                NormalizeTestSupport.buildReactionCreated("om_1", null, "ou_alice", null, "1"), "added"));
        Assert.assertNull(normalizer.normalize(
                NormalizeTestSupport.buildReactionCreated("om_1", "OK", null, null, "1"), "added"));
    }

    @Test
    public void testBotAddedPrefersTopLevelThenI18nFallback() {
        BotAddedNormalizer normalizer = new BotAddedNormalizer();
        BotAddedEvent topLevel = normalizer.normalize(
                NormalizeTestSupport.buildBotAdded("oc_new", "ou_alice", "Top Level", "中文名", "English", null));
        BotAddedEvent zhCn = normalizer.normalize(
                NormalizeTestSupport.buildBotAdded("oc_new", "ou_alice", null, "测试Bot", "English", null));

        Assert.assertEquals("Top Level", topLevel.getBotName());
        Assert.assertEquals("测试Bot", zhCn.getBotName());
        Assert.assertNull(normalizer.normalize(
                NormalizeTestSupport.buildBotAdded("oc_new", null, "Bot", null, null, null)));
        Assert.assertNull(normalizer.normalize(
                NormalizeTestSupport.buildBotAdded(null, "ou_alice", "Bot", null, null, null)));
    }

    @Test
    public void testCommentNormalizerSupportsNoticeMetaAndLegacyFallback() {
        CommentNormalizer normalizer = new CommentNormalizer();
        Map<String, Object> nested = new HashMap<String, Object>();
        nested.put("file_token", "docx_xyz");
        nested.put("file_type", "docx");
        nested.put("comment_id", "cmt_1");
        nested.put("reply_id", "reply_1");
        Map<String, Object> noticeMeta = new HashMap<String, Object>();
        Map<String, Object> fromUser = new HashMap<String, Object>();
        fromUser.put("open_id", "ou_alice");
        noticeMeta.put("from_user_id", fromUser);
        noticeMeta.put("timestamp", "1700000000000");
        noticeMeta.put("is_mentioned", true);
        nested.put("notice_meta", noticeMeta);

        CommentEvent first = normalizer.normalize(nested);
        Assert.assertNotNull(first);
        Assert.assertEquals("docx_xyz", first.getFileToken());
        Assert.assertEquals("reply_1", first.getReplyId());
        Assert.assertTrue(first.isMentionedBot());

        JsonObject legacy = new JsonObject();
        legacy.addProperty("file_token", "docx_abc");
        legacy.addProperty("file_type", "docx");
        legacy.addProperty("comment_id", "cmt_2");
        legacy.addProperty("action_time", "1700000000001");
        legacy.addProperty("is_mention", false);
        JsonObject user = new JsonObject();
        user.addProperty("open_id", "ou_bob");
        legacy.add("user_id", user);
        CommentEvent second = normalizer.normalize(legacy);

        Assert.assertNotNull(second);
        Assert.assertEquals("ou_bob", second.getOperatorId());
        Assert.assertFalse(second.isMentionedBot());
    }
}
