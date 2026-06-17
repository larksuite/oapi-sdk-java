package com.lark.oapi.channel.outbound.markdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class MarkdownPostConverter {
    private MarkdownPostConverter() {
    }

    public static Map<String, Object> markdownToPost(String markdown, List<?> mentions) {
        List<List<Map<String, Object>>> paragraphs = new ArrayList<>();

        // Prepend mentions as at elements for notification delivery.
        List<Map<String, Object>> mentionElements = ComposeMentions.composePostMentionElements(mentions);
        if (!mentionElements.isEmpty()) {
            List<Map<String, Object>> first = new ArrayList<>();
            for (Map<String, Object> mention : mentionElements) {
                first.add(mention);
                first.add(text(" ", null));
            }
            paragraphs.add(first);
        }

        // Wrap raw markdown in md tag.
        Map<String, Object> mdElement = new LinkedHashMap<>();
        mdElement.put("tag", "md");
        mdElement.put("text", markdown == null ? "" : markdown);
        paragraphs.add(Collections.singletonList(mdElement));

        Map<String, Object> locale = new LinkedHashMap<>();
        locale.put("title", "");
        locale.put("content", paragraphs);
        Map<String, Object> post = new LinkedHashMap<>();
        post.put("zh_cn", locale);
        return post;
    }

    public static String postToPlainText(Object post) {
        if (!(post instanceof Map)) {
            return "";
        }
        Object locale = ((Map<?, ?>) post).get("zh_cn");
        if (!(locale instanceof Map)) {
            return "";
        }
        Object content = ((Map<?, ?>) locale).get("content");
        if (!(content instanceof List)) {
            return "";
        }
        List<String> lines = new ArrayList<>();
        for (Object paragraph : (List<?>) content) {
            if (!(paragraph instanceof List)) {
                continue;
            }
            StringBuilder line = new StringBuilder();
            for (Object element : (List<?>) paragraph) {
                if (!(element instanceof Map)) {
                    continue;
                }
                Map<?, ?> item = (Map<?, ?>) element;
                Object tag = item.get("tag");
                if ("text".equals(tag) || "a".equals(tag)) {
                    if (item.get("text") != null) {
                        line.append(item.get("text"));
                    }
                } else if ("at".equals(tag)) {
                    Object userName = item.get("user_name");
                    Object userId = item.get("user_id");
                    line.append("@").append(userName == null ? String.valueOf(userId) : String.valueOf(userName));
                } else if ("code_block".equals(tag)) {
                    Object language = item.get("language");
                    Object text = item.get("text");
                    line.append("```");
                    if (language != null) {
                        line.append(language);
                    }
                    line.append('\n');
                    if (text != null) {
                        line.append(text);
                    }
                    line.append("\n```");
                } else if ("md".equals(tag)) {
                    if (item.get("text") != null) {
                        line.append(item.get("text"));
                    }
                }
            }
            lines.add(line.toString());
        }
        return joinLines(lines).trim();
    }

    private static Map<String, Object> text(String text, List<String> style) {
        Map<String, Object> element = new LinkedHashMap<>();
        element.put("tag", "text");
        element.put("text", text);
        if (style != null && !style.isEmpty()) {
            element.put("style", style);
        }
        return element;
    }

    private static String joinLines(List<String> lines) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            if (i > 0) {
                builder.append('\n');
            }
            builder.append(lines.get(i));
        }
        return builder.toString();
    }
}
