package com.lark.oapi.channel.normalize;

import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.channel.model.MentionInfo;
import com.lark.oapi.service.im.v1.model.Mention;
import com.lark.oapi.service.im.v1.model.MentionEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Mentions {
    private static final java.util.regex.Pattern MENTION_ALL_PATTERN = java.util.regex.Pattern.compile("(^|[^A-Za-z0-9_])@_all([^A-Za-z0-9_]|$)");

    private Mentions() {
    }

    public static MentionState extract(MentionEvent[] mentionEvents, String rawContent, BotIdentity botIdentity) {
        List<MentionInfo> mentions = new ArrayList<MentionInfo>();
        Map<String, MentionInfo> byKey = new LinkedHashMap<String, MentionInfo>();
        Map<String, MentionInfo> byOpenId = new LinkedHashMap<String, MentionInfo>();
        boolean mentionAll = false;
        boolean mentionedBot = false;
        if (mentionEvents != null) {
            for (MentionEvent mentionEvent : mentionEvents) {
                if (mentionEvent == null) {
                    continue;
                }
                if ("@_all".equals(mentionEvent.getKey())) {
                    mentionAll = true;
                    continue;
                }
                String openId = mentionEvent.getId() == null ? null : mentionEvent.getId().getOpenId();
                boolean isBot = botIdentity != null && openId != null && openId.equals(botIdentity.getOpenId());
                MentionInfo info = new MentionInfo(mentionEvent.getKey(), openId, mentionEvent.getName(), isBot);
                mentions.add(info);
                if (info.getKey() != null && !info.getKey().isEmpty()) {
                    byKey.put(info.getKey(), info);
                }
                if (openId != null && !openId.isEmpty()) {
                    byOpenId.put(openId, info);
                }
                if (isBot) {
                    mentionedBot = true;
                }
            }
        }
        if (!mentionAll && containsMentionAll(rawContent)) {
            mentionAll = true;
        }
        if (!mentionedBot && botIdentity != null && rawContent != null && rawContent.contains(botIdentity.getOpenId())) {
            mentionedBot = true;
        }
        return new MentionState(mentions, byKey, byOpenId, mentionAll, mentionedBot);
    }

    public static MentionState extract(Mention[] mentionEvents, String rawContent, BotIdentity botIdentity) {
        List<MentionInfo> mentions = new ArrayList<MentionInfo>();
        Map<String, MentionInfo> byKey = new LinkedHashMap<String, MentionInfo>();
        Map<String, MentionInfo> byOpenId = new LinkedHashMap<String, MentionInfo>();
        boolean mentionAll = false;
        boolean mentionedBot = false;
        if (mentionEvents != null) {
            for (Mention mentionEvent : mentionEvents) {
                if (mentionEvent == null) {
                    continue;
                }
                if ("@_all".equals(mentionEvent.getKey())) {
                    mentionAll = true;
                    continue;
                }
                String openId = mentionEvent.getId();
                boolean isBot = botIdentity != null && openId != null && openId.equals(botIdentity.getOpenId());
                MentionInfo info = new MentionInfo(mentionEvent.getKey(), openId, mentionEvent.getName(), isBot);
                mentions.add(info);
                if (info.getKey() != null && !info.getKey().isEmpty()) {
                    byKey.put(info.getKey(), info);
                }
                if (openId != null && !openId.isEmpty()) {
                    byOpenId.put(openId, info);
                }
                if (isBot) {
                    mentionedBot = true;
                }
            }
        }
        if (!mentionAll && containsMentionAll(rawContent)) {
            mentionAll = true;
        }
        if (!mentionedBot && botIdentity != null && rawContent != null && rawContent.contains(botIdentity.getOpenId())) {
            mentionedBot = true;
        }
        return new MentionState(mentions, byKey, byOpenId, mentionAll, mentionedBot);
    }

    public static String replaceKeys(String text, MentionState mentionState, boolean stripBotMentions) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        String result = text;
        for (MentionInfo mentionInfo : mentionState.getMentions()) {
            if (mentionInfo.getKey() == null || mentionInfo.getKey().isEmpty()) {
                continue;
            }
            String replacement = mentionInfo.getName();
            if (replacement == null || replacement.isEmpty()) {
                replacement = mentionInfo.getOpenId();
            }
            if (replacement == null || replacement.isEmpty()) {
                replacement = mentionInfo.getKey();
            }
            replacement = "@" + replacement;
            if (stripBotMentions && mentionInfo.isBot()) {
                result = result.replace(mentionInfo.getKey(), "").replace(replacement, "");
            } else {
                result = result.replace(mentionInfo.getKey(), replacement);
            }
        }
        return normalizeSpaces(result);
    }

    private static String normalizeSpaces(String text) {
        String normalized = text.replace('\u00A0', ' ').trim();
        while (normalized.contains("  ")) {
            normalized = normalized.replace("  ", " ");
        }
        return normalized;
    }

    private static boolean containsMentionAll(String rawContent) {
        return rawContent != null && MENTION_ALL_PATTERN.matcher(rawContent).find();
    }
}
