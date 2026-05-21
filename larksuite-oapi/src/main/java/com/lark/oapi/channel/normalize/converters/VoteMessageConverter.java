package com.lark.oapi.channel.normalize.converters;

import com.google.gson.JsonArray;
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

public class VoteMessageConverter implements ChannelMessageConverter {
    @Override
    public ConvertResult convert(String rawContent, ConvertContext context) {
        JsonObject parsed = NormalizeJsons.parseObject(rawContent);
        JsonArray options = parsed != null && parsed.has("options") && parsed.get("options").isJsonArray() ? parsed.getAsJsonArray("options") : null;
        String topic = NormalizeJsons.optString(parsed, "topic");
        if ((topic == null || topic.isEmpty()) && (options == null || options.size() == 0)) {
            return new ConvertResult("<vote>\n[vote]\n</vote>", Collections.<ResourceDescriptor>emptyList());
        }
        List<String> lines = new ArrayList<String>();
        if (topic != null && !topic.isEmpty()) {
            lines.add(topic);
        }
        if (options != null) {
            for (int i = 0; i < options.size(); i++) {
                lines.add("\u2022 " + options.get(i).getAsString());
            }
        }
        return new ConvertResult("<vote>\n" + NormalizeTexts.joinLines(lines) + "\n</vote>", Collections.<ResourceDescriptor>emptyList());
    }
}
