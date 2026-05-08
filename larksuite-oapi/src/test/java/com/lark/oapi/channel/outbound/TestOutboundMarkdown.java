package com.lark.oapi.channel.outbound;

import com.lark.oapi.channel.outbound.markdown.ComposeMentions;
import com.lark.oapi.channel.outbound.markdown.MarkdownPostConverter;
import com.lark.oapi.channel.outbound.markdown.MarkdownSplitter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class TestOutboundMarkdown {
    @Test
    public void testComposeMentionsTextPrefix() {
        Assert.assertEquals("", ComposeMentions.composeMentionsTextPrefix(Arrays.<String>asList()));
        Assert.assertEquals("<at user_id=\"ou_alice\"></at> ",
                ComposeMentions.composeMentionsTextPrefix(Arrays.asList("ou_alice")));
        Assert.assertEquals("<at user_id=\"ou_a\"></at> <at user_id=\"ou_b\"></at> ",
                ComposeMentions.composeMentionsTextPrefix(Arrays.asList("ou_a", "ou_b")));
    }

    @Test
    public void testMarkdownToPostAndBackToPlainText() {
        Map<String, Object> post = MarkdownPostConverter.markdownToPost("# Title\nsee [here](https://x.com)\n`code`",
                Arrays.asList("ou_xxx"));
        String plain = MarkdownPostConverter.postToPlainText(post);

        Map<?, ?> zh = (Map<?, ?>) post.get("zh_cn");
        List<?> firstParagraph = (List<?>) ((List<?>) zh.get("content")).get(0);
        Assert.assertEquals("at", ((Map<?, ?>) firstParagraph.get(0)).get("tag"));
        Assert.assertTrue(plain.contains("Title"));
        Assert.assertTrue(plain.contains("here"));
        Assert.assertTrue(plain.contains("code"));
    }

    @Test
    public void testSplitWithCodeFences() {
        List<String> shortText = MarkdownSplitter.splitWithCodeFences("hello", 100);
        List<String> splitText = MarkdownSplitter.splitWithCodeFences("```ts\n" + repeat('x', 60) + "\n" + repeat('y', 60) + "\n```", 40);

        Assert.assertEquals(1, shortText.size());
        Assert.assertTrue(splitText.size() > 1);
        for (String chunk : splitText) {
            int count = chunk.split("```", -1).length - 1;
            Assert.assertEquals(0, count % 2);
        }
        Assert.assertTrue(splitText.get(1).startsWith("```ts"));
    }

    private String repeat(char ch, int count) {
        char[] data = new char[count];
        java.util.Arrays.fill(data, ch);
        return new String(data);
    }
}
