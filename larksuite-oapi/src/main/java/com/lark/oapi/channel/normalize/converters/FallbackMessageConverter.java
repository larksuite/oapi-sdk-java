package com.lark.oapi.channel.normalize.converters;

import com.lark.oapi.channel.model.ResourceDescriptor;
import com.lark.oapi.channel.normalize.ChannelMessageConverter;
import com.lark.oapi.channel.normalize.ConvertContext;
import com.lark.oapi.channel.normalize.ConvertResult;
import com.lark.oapi.channel.normalize.NormalizeJsons;

import java.util.Collections;

public class FallbackMessageConverter implements ChannelMessageConverter {
    @Override
    public ConvertResult convert(String rawContent, ConvertContext context) {
        String text = NormalizeJsons.optString(NormalizeJsons.parseObject(rawContent), "text");
        return new ConvertResult(text != null ? text : "[unsupported message]", Collections.<ResourceDescriptor>emptyList());
    }
}
