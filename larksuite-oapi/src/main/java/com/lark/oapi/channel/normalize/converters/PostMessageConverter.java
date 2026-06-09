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

public class PostMessageConverter implements ChannelMessageConverter {
    @Override
    public ConvertResult convert(String rawContent, ConvertContext context) {
        JsonObject rawParsed = NormalizeJsons.parseObject(rawContent);
        JsonObject body = NormalizeJsons.unwrapLocale(rawParsed);
        if (body == null) {
            return new ConvertResult("[rich text message]", Collections.<ResourceDescriptor>emptyList());
        }
        List<ResourceDescriptor> resources = new ArrayList<ResourceDescriptor>();
        List<String> lines = new ArrayList<String>();
        String title = NormalizeJsons.optString(body, "title");
        if (title != null && !title.isEmpty()) {
            lines.add("**" + title + "**");
            lines.add("");
        }
        JsonArray content = body.has("content") && body.get("content").isJsonArray() ? body.getAsJsonArray("content") : null;
        if (content != null) {
            for (int i = 0; i < content.size(); i++) {
                JsonElement paragraphElement = content.get(i);
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
        }
        String contentText = NormalizeTexts.joinLines(lines).trim();
        return new ConvertResult(contentText.isEmpty() ? "[rich text message]" : contentText, resources);
    }

    private String renderElement(JsonObject element, ConvertContext context, List<ResourceDescriptor> resources) {
        String tag = NormalizeJsons.optString(element, "tag");
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
