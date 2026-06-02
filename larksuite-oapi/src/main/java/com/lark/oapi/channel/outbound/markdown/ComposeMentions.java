package com.lark.oapi.channel.outbound.markdown;

import com.lark.oapi.channel.model.MentionInfo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ComposeMentions {
    private ComposeMentions() {
    }

    public static String composeMentionsTextPrefix(List<?> mentions) {
        if (mentions == null || mentions.isEmpty()) {
            return "";
        }
        List<String> parts = new ArrayList<>();
        for (Object item : mentions) {
            MentionInfo mention = toMentionInfo(item);
            String userId = mentionUserId(mention);
            if (userId == null || userId.isEmpty()) {
                continue;
            }
            String name = mention.getName() == null ? "" : escape(mention.getName());
            parts.add("<at user_id=\"" + escape(userId) + "\">" + name + "</at>");
        }
        return parts.isEmpty() ? "" : String.join(" ", parts) + " ";
    }

    public static List<Map<String, Object>> composePostMentionElements(List<?> mentions) {
        List<Map<String, Object>> output = new ArrayList<>();
        if (mentions == null) {
            return output;
        }
        for (Object item : mentions) {
            MentionInfo mention = toMentionInfo(item);
            String userId = mentionUserId(mention);
            if (userId == null || userId.isEmpty()) {
                continue;
            }
            Map<String, Object> element = new LinkedHashMap<>();
            element.put("tag", "at");
            element.put("user_id", userId);
            if (mention.getName() != null && !mention.getName().isEmpty()) {
                element.put("user_name", mention.getName());
            }
            output.add(element);
        }
        return output;
    }

    private static String mentionUserId(MentionInfo mention) {
        if (mention == null) {
            return null;
        }
        return mention.getUserId() == null || mention.getUserId().isEmpty() ? mention.getOpenId() : mention.getUserId();
    }

    private static MentionInfo toMentionInfo(Object item) {
        if (item instanceof MentionInfo) {
            return (MentionInfo) item;
        }
        if (item instanceof String) {
            return new MentionInfo(null, (String) item, null, null, false);
        }
        return null;
    }

    private static String escape(String value) {
        return value.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;").replace(">", "&gt;");
    }

}
