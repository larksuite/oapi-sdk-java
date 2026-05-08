package com.lark.oapi.channel.normalize;

public interface ChannelMessageConverter {
    ConvertResult convert(String rawContent, ConvertContext context);
}
