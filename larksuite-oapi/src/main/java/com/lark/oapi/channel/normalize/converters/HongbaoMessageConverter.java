package com.lark.oapi.channel.normalize.converters;

import com.lark.oapi.channel.model.ResourceDescriptor;
import com.lark.oapi.channel.normalize.ChannelMessageConverter;
import com.lark.oapi.channel.normalize.ConvertContext;
import com.lark.oapi.channel.normalize.ConvertResult;
import com.lark.oapi.channel.normalize.NormalizeJsons;
import com.lark.oapi.channel.normalize.NormalizeTexts;

import java.util.Collections;

public class HongbaoMessageConverter implements ChannelMessageConverter {
    @Override
    public ConvertResult convert(String rawContent, ConvertContext context) {
        String text = NormalizeJsons.optString(NormalizeJsons.parseObject(rawContent), "text");
        String textAttr = text == null || text.isEmpty() ? "" : " text=\"" + NormalizeTexts.escapeAttr(text) + "\"";
        return new ConvertResult("<hongbao" + textAttr + "/>", Collections.<ResourceDescriptor>emptyList());
    }
}
