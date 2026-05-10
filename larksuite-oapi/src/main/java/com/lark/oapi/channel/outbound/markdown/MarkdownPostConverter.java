package com.lark.oapi.channel.outbound.markdown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class MarkdownPostConverter {
    private MarkdownPostConverter() {
    }

    public static Map<String, Object> markdownToPost(String markdown, List<?> mentions) {
        List<List<Map<String, Object>>> paragraphs = new ArrayList<List<Map<String, Object>>>();
        String[] lines = (markdown == null ? "" : markdown.replace("\r\n", "\n")).split("\n", -1);
        String fenceLang = null;
        List<String> fenceBuffer = new ArrayList<String>();
        for (String line : lines) {
            String trimmed = line.trim();
            if (trimmed.matches("^```\\w*\\s*$")) {
                if (fenceLang == null) {
                    fenceLang = trimmed.length() > 3 ? trimmed.substring(3).trim() : "";
                } else {
                    paragraphs.add(Arrays.asList(codeBlock(fenceLang, joinLines(fenceBuffer))));
                    fenceLang = null;
                    fenceBuffer.clear();
                }
                continue;
            }
            if (fenceLang != null) {
                fenceBuffer.add(line);
                continue;
            }
            if (trimmed.isEmpty()) {
                paragraphs.add(Arrays.asList(text("", null, false)));
                continue;
            }
            if (trimmed.matches("^(-{3,}|_{3,}|\\*{3,})\\s*$")) {
                paragraphs.add(Arrays.asList(text("\u2014\u2014\u2014", null, false)));
                continue;
            }
            paragraphs.add(parseInline(line));
        }
        if (fenceLang != null) {
            paragraphs.add(Arrays.asList(codeBlock(fenceLang, joinLines(fenceBuffer))));
        }

        List<Map<String, Object>> mentionElements = ComposeMentions.composePostMentionElements(mentions);
        if (!mentionElements.isEmpty()) {
            List<Map<String, Object>> first = new ArrayList<Map<String, Object>>();
            for (Map<String, Object> mention : mentionElements) {
                first.add(mention);
                first.add(text(" ", null, false));
            }
            paragraphs.add(0, first);
        }

        Map<String, Object> locale = new LinkedHashMap<String, Object>();
        locale.put("title", "");
        locale.put("content", paragraphs);
        Map<String, Object> post = new LinkedHashMap<String, Object>();
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
        List<String> lines = new ArrayList<String>();
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
                        line.append(String.valueOf(item.get("text")));
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
                        line.append(String.valueOf(language));
                    }
                    line.append('\n');
                    if (text != null) {
                        line.append(String.valueOf(text));
                    }
                    line.append("\n```");
                }
            }
            lines.add(line.toString());
        }
        return joinLines(lines).trim();
    }

    private static List<Map<String, Object>> parseInline(String line) {
        List<Map<String, Object>> output = new ArrayList<Map<String, Object>>();
        java.util.regex.Matcher heading = java.util.regex.Pattern.compile("^(#{1,6})\\s+(.*)$").matcher(line);
        if (heading.find()) {
            output.add(text(heading.group(2), Arrays.asList("bold"), false));
            return output;
        }
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(
                "(`[^`\\n]+`)|(\\[([^\\]]+)\\]\\(([^)]+)\\))|(\\*\\*[^*\\n]+\\*\\*)|(__[^_\\n]+__)|(\\*[^*\\n]+\\*)|(_[^_\\n]+_)");
        java.util.regex.Matcher matcher = pattern.matcher(line);
        int last = 0;
        while (matcher.find()) {
            if (matcher.start() > last) {
                output.add(text(line.substring(last, matcher.start()), null, false));
            }
            String token = matcher.group();
            if (token.startsWith("`")) {
                output.add(text(token.substring(1, token.length() - 1), Arrays.asList("code"), false));
            } else if (token.startsWith("[")) {
                output.add(link(matcher.group(3), matcher.group(4)));
            } else if (token.startsWith("**") || token.startsWith("__")) {
                output.add(text(token.substring(2, token.length() - 2), Arrays.asList("bold"), false));
            } else {
                output.add(text(token.substring(1, token.length() - 1), Arrays.asList("italic"), false));
            }
            last = matcher.end();
        }
        if (last < line.length()) {
            output.add(text(line.substring(last), null, false));
        }
        return output.isEmpty() ? Arrays.asList(text("", null, false)) : output;
    }

    private static Map<String, Object> text(String text, List<String> style, boolean unEscape) {
        Map<String, Object> element = new LinkedHashMap<String, Object>();
        element.put("tag", "text");
        element.put("text", text);
        if (style != null && !style.isEmpty()) {
            element.put("style", style);
        }
        if (unEscape) {
            element.put("un_escape", true);
        }
        return element;
    }

    private static Map<String, Object> codeBlock(String language, String code) {
        Map<String, Object> element = new LinkedHashMap<String, Object>();
        element.put("tag", "code_block");
        element.put("language", language == null ? "" : language);
        element.put("text", code == null ? "" : code);
        return element;
    }

    private static Map<String, Object> link(String text, String href) {
        Map<String, Object> element = new LinkedHashMap<String, Object>();
        element.put("tag", "a");
        element.put("text", text);
        element.put("href", href);
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
