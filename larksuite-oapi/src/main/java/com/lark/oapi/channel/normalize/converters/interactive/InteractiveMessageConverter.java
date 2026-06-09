package com.lark.oapi.channel.normalize.converters.interactive;

import com.google.gson.JsonElement;
import com.lark.oapi.channel.model.ResourceDescriptor;
import com.lark.oapi.channel.normalize.ChannelMessageConverter;
import com.lark.oapi.channel.normalize.ConvertContext;
import com.lark.oapi.channel.normalize.ConvertResult;
import com.lark.oapi.channel.normalize.NormalizeJsons;
import com.lark.oapi.channel.normalize.NormalizeTexts;

import java.util.Collections;
import java.util.List;

public class InteractiveMessageConverter implements ChannelMessageConverter {
    @Override
    public ConvertResult convert(String rawContent, ConvertContext context) {
        JsonElement parsed = NormalizeJsons.parseElement(rawContent);
        if (parsed == null || !parsed.isJsonObject()) {
            return new ConvertResult("[interactive card]", Collections.<ResourceDescriptor>emptyList());
        }
        List<String> output = CardWalker.collectVisibleTexts(parsed);
        return new ConvertResult(output.isEmpty() ? "[interactive card]" : NormalizeTexts.joinLines(output),
                Collections.<ResourceDescriptor>emptyList());
    }
}
