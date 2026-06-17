package com.lark.oapi.channel.normalize.converters;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lark.oapi.channel.model.MentionInfo;
import com.lark.oapi.channel.model.ResourceDescriptor;
import com.lark.oapi.channel.normalize.ChannelMessageConverter;
import com.lark.oapi.channel.normalize.ConvertContext;
import com.lark.oapi.channel.normalize.ConvertResult;
import com.lark.oapi.channel.normalize.NormalizeJsons;
import com.lark.oapi.channel.normalize.NormalizeTexts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostMessageConverter implements ChannelMessageConverter {
    private static final Pattern AT_MENTION_RE = Pattern.compile("<at(\\s+)user_id(\\s*)=(\\s*)\"(.*?)\">(.*?)</at>");
    private static final Pattern IMAGE_KEY_RE = Pattern.compile("!\\[(.*?)\\]\\(([^)]+)\\)");

    @Override
    public ConvertResult convert(String rawContent, ConvertContext context) {
        JsonObject rawParsed = NormalizeJsons.parseObject(rawContent);
        JsonObject body = NormalizeJsons.unwrapLocale(rawParsed);
        if (body == null) {
            return new ConvertResult("[rich text message]", Collections.<ResourceDescriptor>emptyList());
        }

        // Choose source paragraphs: prefer content_v2, fallback to content.
        JsonArray sourceParagraphs = null;
        if (body.has("content_v2") && body.get("content_v2").isJsonArray()) {
            JsonArray cv2 = body.getAsJsonArray("content_v2");
            if (cv2.size() > 0) {
                sourceParagraphs = cv2;
            }
        }
        if (sourceParagraphs == null && body.has("content") && body.get("content").isJsonArray()) {
            sourceParagraphs = body.getAsJsonArray("content");
        }
        if (sourceParagraphs == null || sourceParagraphs.size() == 0) {
            return new ConvertResult("[rich text message]", Collections.<ResourceDescriptor>emptyList());
        }

        List<ResourceDescriptor> resources = new ArrayList<ResourceDescriptor>();
        List<String> lines = new ArrayList<String>();
        String title = NormalizeJsons.optString(body, "title");
        if (title != null && !title.isEmpty()) {
            lines.add("**" + title + "**");
            lines.add("");
        }

        for (int i = 0; i < sourceParagraphs.size(); i++) {
            JsonElement paragraphElement = sourceParagraphs.get(i);
            if (!paragraphElement.isJsonArray()) {
                continue;
            }
            JsonArray paragraph = paragraphElement.getAsJsonArray();
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < paragraph.size(); j++) {
                if (!paragraph.get(j).isJsonObject()) {
                    continue;
                }
                line.append(renderElement(paragraph.get(j).getAsJsonObject(), context, resources));
            }
            lines.add(line.toString());
        }

        String contentText = NormalizeTexts.joinLines(lines).trim();
        return new ConvertResult(contentText.isEmpty() ? "[rich text message]" : contentText, resources);
    }

    /**
     * Post-process raw markdown text from an "md" element.
     * Splits by fenced code block delimiters (```) and only applies
     * transformations to text outside of properly paired code blocks.
     * Unclosed fences are treated as outside-code-block text.
     */
    private String processMdText(String text, List<ResourceDescriptor> resources) {
        String[] parts = text.split("```", -1);
        int total = parts.length;
        for (int i = 0; i < parts.length; i++) {
            // Odd-index segments are inside code blocks, UNLESS it's the last
            // segment of an even-length split (unclosed fence).
            boolean isInside = (i % 2 == 1);
            if (isInside && total % 2 == 0 && i == total - 1) {
                isInside = false;
            }
            if (!isInside) {
                // Outside code block: apply transformations.
                Matcher atMatcher = AT_MENTION_RE.matcher(parts[i]);
                StringBuffer sb = new StringBuffer();
                while (atMatcher.find()) {
                    String userId = atMatcher.group(4);
                    String name = atMatcher.group(5);
                    String replacement;
                    if ("all".equals(userId) || "all_members".equals(userId)) {
                        replacement = "@all";
                    } else if (name != null && !name.isEmpty()) {
                        replacement = "@" + name;
                    } else {
                        replacement = "@" + userId;
                    }
                    atMatcher.appendReplacement(sb, Matcher.quoteReplacement(replacement));
                }
                atMatcher.appendTail(sb);
                parts[i] = sb.toString();

                // Extract image keys from ![...](key) patterns.
                Matcher imgMatcher = IMAGE_KEY_RE.matcher(parts[i]);
                while (imgMatcher.find()) {
                    String key = imgMatcher.group(2);
                    if (key != null && !key.isEmpty()) {
                        resources.add(new ResourceDescriptor("image", key, null, null));
                    }
                }
            }
            // Inside code block: preserve as-is.
        }
        return String.join("```", parts);
    }

    private String renderElement(JsonObject element, ConvertContext context, List<ResourceDescriptor> resources) {
        String tag = NormalizeJsons.optString(element, "tag");
        if ("md".equals(tag)) {
            return processMdText(NormalizeJsons.optString(element, "text", ""), resources);
        }
        if ("text".equals(tag)) {
            JsonArray styles = element.has("style") && element.get("style").isJsonArray() ? element.getAsJsonArray("style") : null;
            return NormalizeTexts.applyStyle(NormalizeJsons.optString(element, "text", ""), styles);
        }
        if ("a".equals(tag)) {
            String label = NormalizeTexts.firstNonBlank(NormalizeJsons.optString(element, "text"), NormalizeJsons.optString(element, "href"), "");
            String href = NormalizeJsons.optString(element, "href");
            return href == null || href.isEmpty() ? label : "[" + label + "](" + href + ")";
        }
        if ("at".equals(tag)) {
            String userId = NormalizeJsons.optString(element, "user_id", "");
            if ("all".equals(userId) || "all_members".equals(userId)) {
                return "@all";
            }
            MentionInfo info = context.getMentionState().getByOpenId().get(userId);
            if (info != null) {
                return info.getKey();
            }
            String userName = NormalizeJsons.optString(element, "user_name");
            return userName == null || userName.isEmpty() ? "@" + userId : "@" + userName;
        }
        if ("img".equals(tag)) {
            String imageKey = NormalizeJsons.optString(element, "image_key");
            if (imageKey != null && !imageKey.isEmpty()) {
                resources.add(new ResourceDescriptor("image", imageKey, null, null));
                return "![image](" + imageKey + ")";
            }
            return "";
        }
        if ("media".equals(tag)) {
            String fileKey = NormalizeJsons.optString(element, "file_key");
            if (fileKey != null && !fileKey.isEmpty()) {
                resources.add(new ResourceDescriptor("file", fileKey, null, null));
                return "<file key=\"" + fileKey + "\"/>";
            }
            return "";
        }
        if ("code_block".equals(tag)) {
            String language = NormalizeJsons.optString(element, "language", "");
            String code = NormalizeJsons.optString(element, "text", "");
            return "\n```" + language + "\n" + code + "\n```\n";
        }
        if ("hr".equals(tag)) {
            return "\n---\n";
        }
        return NormalizeJsons.optString(element, "text", "");
    }
}
