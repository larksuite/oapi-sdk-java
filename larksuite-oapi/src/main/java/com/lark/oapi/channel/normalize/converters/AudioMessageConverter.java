package com.lark.oapi.channel.normalize.converters;

import com.google.gson.JsonObject;
import com.lark.oapi.channel.model.ResourceDescriptor;
import com.lark.oapi.channel.normalize.ChannelMessageConverter;
import com.lark.oapi.channel.normalize.ConvertContext;
import com.lark.oapi.channel.normalize.ConvertResult;
import com.lark.oapi.channel.normalize.NormalizeJsons;
import com.lark.oapi.channel.normalize.NormalizeTexts;
import java.util.Collections;

public class AudioMessageConverter implements ChannelMessageConverter {
    @Override
    public ConvertResult convert(String rawContent, ConvertContext context) {
        JsonObject parsed = NormalizeJsons.parseObject(rawContent);
        String fileKey = NormalizeJsons.optString(parsed, "file_key");
        if (fileKey == null || fileKey.isEmpty()) {
            return new ConvertResult("[audio]", Collections.<ResourceDescriptor>emptyList());
        }
        Long duration = NormalizeTexts.parseLongObject(NormalizeJsons.optString(parsed, "duration"));
        String durationAttr = NormalizeTexts.formatDuration(duration);
        String attr = durationAttr == null ? "" : " duration=\"" + durationAttr + "\"";
        return new ConvertResult("<audio key=\"" + fileKey + "\"" + attr + "/>",
                Collections.singletonList(new ResourceDescriptor("audio", fileKey, null, duration)));
    }
}
