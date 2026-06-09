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

public class CalendarMessageConverter implements ChannelMessageConverter {
    private final String tagName;

    public CalendarMessageConverter(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public ConvertResult convert(String rawContent, ConvertContext context) {
        return new ConvertResult("<" + tagName + ">\n" + formatCalendarInner(rawContent) + "\n</" + tagName + ">",
                Collections.<ResourceDescriptor>emptyList());
    }

    private String formatCalendarInner(String rawContent) {
        JsonObject parsed = NormalizeJsons.parseObject(rawContent);
        if (parsed == null) {
            return "[calendar event]";
        }
        List<String> lines = new ArrayList<String>();
        String summary = NormalizeJsons.optString(parsed, "summary");
        if (summary != null && !summary.isEmpty()) {
            lines.add("\uD83D\uDCC5 " + summary);
        }
        String start = NormalizeTexts.millisToDatetime(NormalizeJsons.optString(parsed, "start_time"));
        String end = NormalizeTexts.millisToDatetime(NormalizeJsons.optString(parsed, "end_time"));
        if (start != null && end != null) {
            lines.add("\uD83D\uDD59 " + start + " ~ " + end);
        } else if (start != null) {
            lines.add("\uD83D\uDD59 " + start);
        }
        return lines.isEmpty() ? "[calendar event]" : NormalizeTexts.joinLines(lines);
    }
}
