package com.lark.oapi.channel.outbound.markdown;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ComposeMentions {
    private ComposeMentions() {
    }

    public static String composeMentionsTextPrefix(List<String> mentions) {
        if (mentions == null || mentions.isEmpty()) {
            return "";
        }
        List<String> parts = new ArrayList<String>();
        for (String openId : mentions) {
            if (openId == null || openId.isEmpty()) {
                continue;
            }
            parts.add("<at user_id=\"" + escape(openId) + "\"></at>");
        }
        return parts.isEmpty() ? "" : join(parts, " ") + " ";
    }

    public static List<Map<String, Object>> composePostMentionElements(List<String> mentions) {
        List<Map<String, Object>> output = new ArrayList<Map<String, Object>>();
        if (mentions == null) {
            return output;
        }
        for (String openId : mentions) {
            if (openId == null || openId.isEmpty()) {
                continue;
            }
            Map<String, Object> element = new LinkedHashMap<String, Object>();
            element.put("tag", "at");
            element.put("user_id", openId);
            output.add(element);
        }
        return output;
    }

    private static String escape(String value) {
        return value.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;").replace(">", "&gt;");
    }

    private static String join(List<String> parts, String separator) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < parts.size(); i++) {
            if (i > 0) {
                builder.append(separator);
            }
            builder.append(parts.get(i));
        }
        return builder.toString();
    }
}
