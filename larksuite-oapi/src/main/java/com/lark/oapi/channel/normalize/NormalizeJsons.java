package com.lark.oapi.channel.normalize;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public final class NormalizeJsons {
    private NormalizeJsons() {
    }

    public static JsonElement parseElement(String rawContent) {
        if (rawContent == null || rawContent.isEmpty()) {
            return null;
        }
        try {
            return JsonParser.parseString(rawContent);
        } catch (Exception ignored) {
            return null;
        }
    }

    public static JsonObject parseObject(String rawContent) {
        JsonElement element = parseElement(rawContent);
        return element != null && element.isJsonObject() ? element.getAsJsonObject() : null;
    }

    public static String optString(JsonObject object, String key) {
        return optString(object, key, null);
    }

    public static String optString(JsonObject object, String key, String fallback) {
        if (object == null || !object.has(key) || object.get(key).isJsonNull()) {
            return fallback;
        }
        try {
            return object.get(key).getAsString();
        } catch (Exception ignored) {
            return fallback;
        }
    }

    public static JsonObject unwrapLocale(JsonObject parsed) {
        if (parsed == null) {
            return null;
        }
        if (parsed.has("title") || parsed.has("content")) {
            return parsed;
        }
        String[] priority = new String[]{"zh_cn", "en_us", "ja_jp"};
        for (String locale : priority) {
            if (parsed.has(locale) && parsed.get(locale).isJsonObject()) {
                return parsed.getAsJsonObject(locale);
            }
        }
        for (java.util.Map.Entry<String, JsonElement> entry : parsed.entrySet()) {
            if (entry.getValue().isJsonObject()) {
                return entry.getValue().getAsJsonObject();
            }
        }
        return null;
    }
}
