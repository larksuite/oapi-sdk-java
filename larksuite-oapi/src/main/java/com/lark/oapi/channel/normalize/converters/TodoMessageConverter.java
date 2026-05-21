package com.lark.oapi.channel.normalize.converters;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lark.oapi.channel.model.ResourceDescriptor;
import com.lark.oapi.channel.normalize.ChannelMessageConverter;
import com.lark.oapi.channel.normalize.ConvertContext;
import com.lark.oapi.channel.normalize.ConvertResult;
import com.lark.oapi.channel.normalize.NormalizeJsons;
import com.lark.oapi.channel.normalize.NormalizeTexts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoMessageConverter implements ChannelMessageConverter {
    @Override
    public ConvertResult convert(String rawContent, ConvertContext context) {
        JsonObject parsed = NormalizeJsons.parseObject(rawContent);
        JsonObject summary = parsed != null && parsed.has("summary") && parsed.get("summary").isJsonObject() ? parsed.getAsJsonObject("summary") : null;
        if (summary == null) {
            return new ConvertResult("<todo>\n[todo]\n</todo>", Collections.<ResourceDescriptor>emptyList());
        }
        List<String> lines = new ArrayList<String>();
        String title = NormalizeJsons.optString(summary, "title");
        if (title != null && !title.isEmpty()) {
            lines.add(title);
        }
        JsonArray content = summary.has("content") && summary.get("content").isJsonArray() ? summary.getAsJsonArray("content") : null;
        String bodyText = extractTodoBody(content);
        if (!bodyText.isEmpty()) {
            lines.add(bodyText);
        }
        String due = NormalizeTexts.millisToDatetime(NormalizeJsons.optString(parsed, "due_time"));
        if (due != null) {
            lines.add("Due: " + due);
        }
        if (lines.isEmpty()) {
            return new ConvertResult("<todo>\n[todo]\n</todo>", Collections.<ResourceDescriptor>emptyList());
        }
        return new ConvertResult("<todo>\n" + NormalizeTexts.joinLines(lines) + "\n</todo>", Collections.<ResourceDescriptor>emptyList());
    }

    private String extractTodoBody(JsonArray blocks) {
        if (blocks == null) {
            return "";
        }
        List<String> lines = new ArrayList<String>();
        for (int i = 0; i < blocks.size(); i++) {
            JsonElement paragraphElement = blocks.get(i);
            if (!paragraphElement.isJsonArray()) {
                continue;
            }
            JsonArray paragraph = paragraphElement.getAsJsonArray();
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < paragraph.size(); j++) {
                if (!paragraph.get(j).isJsonObject()) {
                    continue;
                }
                JsonObject element = paragraph.get(j).getAsJsonObject();
                String tag = NormalizeJsons.optString(element, "tag");
                if ("text".equals(tag) || "a".equals(tag)) {
                    builder.append(NormalizeJsons.optString(element, "text", ""));
                }
            }
            if (builder.length() > 0) {
                lines.add(builder.toString());
            }
        }
        return NormalizeTexts.joinLines(lines);
    }
}
