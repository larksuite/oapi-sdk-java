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
import java.util.Map;

public class SystemMessageConverter implements ChannelMessageConverter {
    @Override
    public ConvertResult convert(String rawContent, ConvertContext context) {
        JsonObject parsed = NormalizeJsons.parseObject(rawContent);
        if (parsed == null || NormalizeJsons.optString(parsed, "template") == null) {
            return new ConvertResult("[system message]", Collections.<ResourceDescriptor>emptyList());
        }
        String output = NormalizeJsons.optString(parsed, "template", "");
        for (Map.Entry<String, JsonElement> entry : parsed.entrySet()) {
            String token = "{" + entry.getKey() + "}";
            JsonElement value = entry.getValue();
            String replacement;
            if (value == null || value.isJsonNull()) {
                replacement = "";
            } else if (value.isJsonArray()) {
                replacement = joinArray(value.getAsJsonArray());
            } else if (value.isJsonPrimitive() && value.getAsJsonPrimitive().isString()) {
                replacement = value.getAsString();
            } else {
                replacement = token;
            }
            output = output.replace(token, replacement);
        }
        output = output.trim();
        return new ConvertResult(output.isEmpty() ? "[system message]" : output, Collections.<ResourceDescriptor>emptyList());
    }

    private String joinArray(JsonArray array) {
        List<String> items = new ArrayList<String>();
        for (int i = 0; i < array.size(); i++) {
            items.add(array.get(i).getAsString());
        }
        return NormalizeTexts.joinWithComma(items);
    }
}
