package com.lark.oapi.channel.normalize.converters;

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

public class VideoChatMessageConverter implements ChannelMessageConverter {
    @Override
    public ConvertResult convert(String rawContent, ConvertContext context) {
        JsonObject parsed = NormalizeJsons.parseObject(rawContent);
        if (parsed == null) {
            return new ConvertResult("<meeting>\n[video chat]\n</meeting>", Collections.<ResourceDescriptor>emptyList());
        }
        List<String> lines = new ArrayList<String>();
        String topic = NormalizeJsons.optString(parsed, "topic");
        if (topic != null && !topic.isEmpty()) {
            lines.add("\uD83D\uDCF9 " + topic);
        }
        String start = NormalizeTexts.millisToDatetime(NormalizeJsons.optString(parsed, "start_time"));
        if (start != null) {
            lines.add("\uD83D\uDD59 " + start);
        }
        return new ConvertResult("<meeting>\n" + (lines.isEmpty() ? "[video chat]" : NormalizeTexts.joinLines(lines)) + "\n</meeting>",
                Collections.<ResourceDescriptor>emptyList());
    }
}
