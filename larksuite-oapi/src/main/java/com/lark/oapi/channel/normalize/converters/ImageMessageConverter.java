package com.lark.oapi.channel.normalize.converters;

import com.google.gson.JsonObject;
import com.lark.oapi.channel.model.ResourceDescriptor;
import com.lark.oapi.channel.normalize.ChannelMessageConverter;
import com.lark.oapi.channel.normalize.ConvertContext;
import com.lark.oapi.channel.normalize.ConvertResult;
import com.lark.oapi.channel.normalize.NormalizeJsons;
import java.util.Collections;

public class ImageMessageConverter implements ChannelMessageConverter {
    @Override
    public ConvertResult convert(String rawContent, ConvertContext context) {
        JsonObject parsed = NormalizeJsons.parseObject(rawContent);
        String imageKey = NormalizeJsons.optString(parsed, "image_key");
        if (imageKey == null || imageKey.isEmpty()) {
            return new ConvertResult("[image]", Collections.<ResourceDescriptor>emptyList());
        }
        return new ConvertResult("![image](" + imageKey + ")",
                Collections.singletonList(new ResourceDescriptor("image", imageKey, null, null)));
    }
}
