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
        String markdown = "# Title\nsee [here](https://x.com)\n`code`";
        Map<String, Object> post = MarkdownPostConverter.markdownToPost(markdown, Arrays.asList("ou_xxx"));
        String plain = MarkdownPostConverter.postToPlainText(post);

        Map<?, ?> zh = (Map<?, ?>) post.get("zh_cn");
        List<?> content = (List<?>) zh.get("content");
        List<?> firstParagraph = (List<?>) content.get(0);
        Map<?, ?> md = (Map<?, ?>) ((List<?>) content.get(1)).get(0);
        Assert.assertEquals("at", ((Map<?, ?>) firstParagraph.get(0)).get("tag"));
        Assert.assertEquals("md", md.get("tag"));
        Assert.assertEquals(markdown, md.get("text"));
        Assert.assertTrue(plain.contains("@ou_xxx"));
        Assert.assertTrue(plain.contains(markdown));
    }

    @Test
    public void testMarkdownCodeFenceIsPreservedAsRawMd() {
        String markdown = "before\n```java\npublic class Demo {\n    int value = 1;\n}\n```\nafter";
        Map<String, Object> post = MarkdownPostConverter.markdownToPost(markdown, null);
        String plain = MarkdownPostConverter.postToPlainText(post);

        Map<?, ?> zh = (Map<?, ?>) post.get("zh_cn");
        List<?> content = (List<?>) zh.get("content");
        Map<?, ?> md = (Map<?, ?>) ((List<?>) content.get(0)).get(0);
        Assert.assertEquals("md", md.get("tag"));
        Assert.assertEquals(markdown, md.get("text"));
        Assert.assertEquals(markdown, plain);
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

    @Test
    public void testSplitWithLongJavaCodeFenceNoTruncation() {
        String code = "public class Demo {\n"
                + "    String first = \"" + repeat('a', 80) + "\";\n"
                + "    String middle = \"" + repeat('b', 80) + "\";\n"
                + "    String last = \"" + repeat('c', 80) + "\";\n"
                + "}";
        String markdown = "```java\n" + code + "\n```";
        List<String> chunks = MarkdownSplitter.splitWithCodeFences(markdown, 120);

        Assert.assertTrue(chunks.size() > 1);
        StringBuilder rebuilt = new StringBuilder();
        for (String chunk : chunks) {
            int count = chunk.split("```", -1).length - 1;
            Assert.assertEquals(0, count % 2);
            if (rebuilt.length() > 0) {
                rebuilt.append('\n');
            }
            rebuilt.append(stripFenceWrapper(chunk));
        }
        Assert.assertEquals(code, rebuilt.toString());
        Assert.assertTrue(chunks.get(0).startsWith("```java\n"));
        Assert.assertTrue(chunks.get(chunks.size() - 1).endsWith("\n```"));
        Assert.assertTrue(rebuilt.toString().contains(repeat('a', 80)));
        Assert.assertTrue(rebuilt.toString().contains(repeat('b', 80)));
        Assert.assertTrue(rebuilt.toString().contains(repeat('c', 80)));
    }

    private String stripFenceWrapper(String chunk) {
        String value = chunk;
        if (value.startsWith("```")) {
            int newline = value.indexOf('\n');
            value = newline >= 0 ? value.substring(newline + 1) : "";
        }
        if (value.endsWith("\n```")) {
            value = value.substring(0, value.length() - 4);
        }
        return value;
    }

    private String repeat(char ch, int count) {
        char[] data = new char[count];
        java.util.Arrays.fill(data, ch);
        return new String(data);
    }
}
