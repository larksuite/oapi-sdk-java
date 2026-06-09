package com.lark.oapi.channel.normalize;

import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.channel.model.ResourceDescriptor;
import com.lark.oapi.service.im.v1.model.MentionEvent;
import org.junit.Assert;
import org.junit.Test;

public class TestNormalizeConverters {
    private final BotIdentity botIdentity = new BotIdentity("ou_bot", "TestBot");
    private final NormalizeOptions options = new NormalizeOptions(botIdentity, false, true);

    @Test
    public void testMediaConvertersProduceExpectedResources() {
        ConvertResult image = convert("image", "{\"image_key\":\"img_v3_1\"}", null);
        ConvertResult file = convert("file", "{\"file_key\":\"file_v3_1\",\"file_name\":\"doc.txt\"}", null);
        ConvertResult audio = convert("audio", "{\"file_key\":\"audio_v3_1\",\"duration\":\"1500\"}", null);
        ConvertResult video = convert("video", "{\"file_key\":\"video_v3_1\",\"file_name\":\"demo.mp4\",\"duration\":\"3200\",\"image_key\":\"img_cover\"}", null);
        ConvertResult sticker = convert("sticker", "{\"file_key\":\"stk_v3_1\"}", null);

        assertResource(image.getResources().get(0), "image", "img_v3_1", null, null, null);
        Assert.assertEquals("![image](img_v3_1)", image.getContent());
        assertResource(file.getResources().get(0), "file", "file_v3_1", "doc.txt", null, null);
        Assert.assertEquals("<file key=\"file_v3_1\" name=\"doc.txt\"/>", file.getContent());
        assertResource(audio.getResources().get(0), "audio", "audio_v3_1", null, 1500L, null);
        Assert.assertEquals("<audio key=\"audio_v3_1\" duration=\"1.5s\"/>", audio.getContent());
        assertResource(video.getResources().get(0), "video", "video_v3_1", "demo.mp4", 3200L, "img_cover");
        Assert.assertEquals("<video key=\"video_v3_1\" name=\"demo.mp4\" duration=\"3.2s\"/>", video.getContent());
        assertResource(sticker.getResources().get(0), "sticker", "stk_v3_1", null, null, null);
        Assert.assertEquals("<sticker key=\"stk_v3_1\"/>", sticker.getContent());
    }

    @Test
    public void testStructuredConvertersRenderExpectedText() {
        ConvertResult interactive = convert("interactive",
                "{\"elements\":[{\"tag\":\"markdown\",\"content\":\"hello\"},{\"tag\":\"plain_text\",\"content\":\"world\"}]}", null);
        ConvertResult shareChat = convert("share_chat", "{\"chat_id\":\"oc_target\"}", null);
        ConvertResult shareUser = convert("share_user", "{\"user_id\":\"ou_target\"}", null);
        ConvertResult location = convert("location", "{\"name\":\"Office\",\"latitude\":\"39.9\",\"longitude\":\"116.3\"}", null);
        ConvertResult system = convert("system", "{\"template\":\"{actor} invited {members}\",\"actor\":\"Alice\",\"members\":[\"Bob\",\"Carol\"]}", null);
        ConvertResult vote = convert("vote", "{\"topic\":\"Lunch?\",\"options\":[\"Yes\",\"No\"]}", null);
        ConvertResult todo = convert("todo",
                "{\"summary\":{\"title\":\"Ship\",\"content\":[[{\"tag\":\"text\",\"text\":\"Check docs\"}]]},\"due_time\":\"1710000000000\"}",
                null);
        ConvertResult calendar = convert("calendar",
                "{\"summary\":\"Demo\",\"start_time\":\"1710000000000\",\"end_time\":\"1710003600000\"}", null);
        ConvertResult folder = convert("folder", "{\"file_key\":\"fld_1\",\"file_name\":\"Specs\"}", null);
        ConvertResult hongbao = convert("hongbao", "{\"text\":\"Lucky money\"}", null);
        ConvertResult videoChat = convert("video_chat", "{\"topic\":\"Standup\",\"start_time\":\"1710000000000\"}", null);
        ConvertResult fallback = convert("unknown", "{\"text\":\"fallback text\"}", null);

        Assert.assertEquals("hello\nworld", interactive.getContent());
        Assert.assertEquals("<group_card id=\"oc_target\"/>", shareChat.getContent());
        Assert.assertEquals("<contact_card id=\"ou_target\"/>", shareUser.getContent());
        Assert.assertEquals("<location name=\"Office\" coords=\"lat:39.9,lng:116.3\"/>", location.getContent());
        Assert.assertEquals("Alice invited Bob, Carol", system.getContent());
        Assert.assertTrue(vote.getContent().contains("Lunch?"));
        Assert.assertTrue(vote.getContent().contains("\u2022 Yes"));
        Assert.assertTrue(todo.getContent().contains("<todo>"));
        Assert.assertTrue(todo.getContent().contains("Ship"));
        Assert.assertTrue(calendar.getContent().contains("<calendar_invite>"));
        Assert.assertTrue(calendar.getContent().contains("Demo"));
        Assert.assertEquals("<folder key=\"fld_1\" name=\"Specs\"/>", folder.getContent());
        Assert.assertEquals("<hongbao text=\"Lucky money\"/>", hongbao.getContent());
        Assert.assertTrue(videoChat.getContent().contains("<meeting>"));
        Assert.assertTrue(videoChat.getContent().contains("Standup"));
        Assert.assertEquals("fallback text", fallback.getContent());
    }

    @Test
    public void testPostConverterResolvesMentionsAndInlineAssets() {
        MentionEvent[] mentions = new MentionEvent[]{
                NormalizeTestSupport.mention("@_user_1", "ou_alice", "Alice")
        };
        ConvertResult post = convert("post",
                "{\"zh_cn\":{\"title\":\"Title\",\"content\":[[{\"tag\":\"at\",\"user_id\":\"ou_alice\"},{\"tag\":\"text\",\"text\":\" hi\"},{\"tag\":\"img\",\"image_key\":\"img_x\"},{\"tag\":\"a\",\"text\":\"docs\",\"href\":\"https://example.com\"}]]}}",
                mentions);

        Assert.assertTrue(post.getContent().contains("**Title**"));
        Assert.assertTrue(post.getContent().contains("@_user_1 hi"));
        Assert.assertTrue(post.getContent().contains("![image](img_x)"));
        Assert.assertTrue(post.getContent().contains("[docs](https://example.com)"));
        assertResource(post.getResources().get(0), "image", "img_x", null, null, null);
    }

    private ConvertResult convert(String messageType, String rawContent, MentionEvent[] mentions) {
        MentionState state = Mentions.extract(mentions, rawContent, botIdentity);
        return MessageConverters.convert(messageType, rawContent, state, options, "om_test");
    }

    private void assertResource(ResourceDescriptor descriptor, String type, String fileKey, String fileName,
                                Long durationMs, String coverImageKey) {
        Assert.assertEquals(type, descriptor.getType());
        Assert.assertEquals(fileKey, descriptor.getFileKey());
        Assert.assertEquals(fileName, descriptor.getFileName());
        Assert.assertEquals(durationMs, descriptor.getDurationMs());
        Assert.assertEquals(coverImageKey, descriptor.getCoverImageKey());
    }
}
