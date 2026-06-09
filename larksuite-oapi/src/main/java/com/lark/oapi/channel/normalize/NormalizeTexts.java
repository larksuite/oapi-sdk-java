package com.lark.oapi.channel.normalize;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Locale;

public final class NormalizeTexts {
    private NormalizeTexts() {
    }

    public static Long parseLongObject(String value) {
        try {
            return value == null ? null : Long.valueOf(value);
        } catch (Exception ignored) {
            return null;
        }
    }

    public static long parseLong(String value) {
        try {
            return value == null ? 0L : Long.parseLong(value);
        } catch (Exception ignored) {
            return 0L;
        }
    }

    public static String formatDuration(Long ms) {
        if (ms == null || ms.longValue() < 0L) {
            return null;
        }
        if (ms.longValue() < 1000L) {
            return Math.round(ms.longValue()) + "ms";
        }
        if (ms.longValue() % 1000L == 0L) {
            return (ms.longValue() / 1000L) + "s";
        }
        return String.format(Locale.US, "%.1fs", ms.doubleValue() / 1000.0d);
    }

    public static String millisToDatetime(String value) {
        Long millis = parseLongObject(value);
        if (millis == null || millis.longValue() <= 0L) {
            return null;
        }
        ZonedDateTime dateTime = Instant.ofEpochMilli(millis.longValue()).atZone(ZoneOffset.UTC).plusHours(8L);
        return String.format(Locale.US, "%04d-%02d-%02d %02d:%02d",
                dateTime.getYear(), dateTime.getMonthValue(), dateTime.getDayOfMonth(),
                dateTime.getHour(), dateTime.getMinute());
    }

    public static String formatRfc3339Beijing(long millis) {
        ZonedDateTime dateTime = Instant.ofEpochMilli(millis).atZone(ZoneOffset.UTC).plusHours(8L);
        return String.format(Locale.US, "%04d-%02d-%02dT%02d:%02d:%02d+08:00",
                dateTime.getYear(), dateTime.getMonthValue(), dateTime.getDayOfMonth(),
                dateTime.getHour(), dateTime.getMinute(), dateTime.getSecond());
    }

    public static String joinLines(List<String> lines) {
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            if (builder.length() > 0) {
                builder.append('\n');
            }
            builder.append(line);
        }
        return builder.toString();
    }

    public static String joinWithComma(List<String> values) {
        StringBuilder builder = new StringBuilder();
        for (String value : values) {
            if (builder.length() > 0) {
                builder.append(", ");
            }
            builder.append(value);
        }
        return builder.toString();
    }

    public static String indentLines(String text, String indent) {
        String[] lines = text.split("\n", -1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            if (i > 0) {
                builder.append('\n');
            }
            builder.append(indent).append(lines[i]);
        }
        return builder.toString();
    }

    public static String escapeAttr(String text) {
        return text == null ? "" : text.replace("\"", "&quot;");
    }

    public static String firstNonBlank(String first, String second, String fallback) {
        if (first != null && !first.isEmpty()) return first;
        if (second != null && !second.isEmpty()) return second;
        return fallback;
    }

    public static String applyStyle(String text, JsonArray styleArray) {
        if (styleArray == null || styleArray.size() == 0) {
            return text;
        }
        String output = text;
        for (int i = 0; i < styleArray.size(); i++) {
            String style = styleArray.get(i).getAsString();
            if ("bold".equals(style)) output = "**" + output + "**";
            if ("italic".equals(style)) output = "*" + output + "*";
            if ("underline".equals(style)) output = "<u>" + output + "</u>";
            if ("lineThrough".equals(style) || "strikethrough".equals(style)) output = "~~" + output + "~~";
            if ("codeInline".equals(style) || "code".equals(style)) output = "`" + output + "`";
        }
        return output;
    }

    public static void collectInteractiveText(JsonElement element, List<String> parts) {
        if (element == null || element.isJsonNull()) {
            return;
        }
        if (element.isJsonPrimitive() && element.getAsJsonPrimitive().isString()) {
            return;
        }
        if (element.isJsonArray()) {
            JsonArray array = element.getAsJsonArray();
            for (int i = 0; i < array.size(); i++) {
                collectInteractiveText(array.get(i), parts);
            }
            return;
        }
        com.google.gson.JsonObject object = element.getAsJsonObject();
        for (java.util.Map.Entry<String, JsonElement> entry : object.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            if (("text".equals(key) || "content".equals(key) || "title".equals(key) || "alt".equals(key) || "placeholder".equals(key))
                    && value.isJsonPrimitive() && value.getAsJsonPrimitive().isString()) {
                parts.add(value.getAsString());
                continue;
            }
            collectInteractiveText(value, parts);
        }
    }
}
