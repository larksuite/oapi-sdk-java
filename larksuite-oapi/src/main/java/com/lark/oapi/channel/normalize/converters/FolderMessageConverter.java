package com.lark.oapi.channel.normalize.converters;

import com.google.gson.JsonObject;
import com.lark.oapi.channel.model.ResourceDescriptor;
import com.lark.oapi.channel.normalize.ChannelMessageConverter;
import com.lark.oapi.channel.normalize.ConvertContext;
import com.lark.oapi.channel.normalize.ConvertResult;
import com.lark.oapi.channel.normalize.NormalizeJsons;
import com.lark.oapi.channel.normalize.NormalizeTexts;
import java.util.Collections;

public class FolderMessageConverter implements ChannelMessageConverter {
    @Override
    public ConvertResult convert(String rawContent, ConvertContext context) {
        JsonObject parsed = NormalizeJsons.parseObject(rawContent);
        String fileKey = NormalizeJsons.optString(parsed, "file_key");
        if (fileKey == null || fileKey.isEmpty()) {
            return new ConvertResult("[folder]", Collections.<ResourceDescriptor>emptyList());
        }
        String fileName = NormalizeJsons.optString(parsed, "file_name");
        String nameAttr = fileName == null || fileName.isEmpty() ? "" : " name=\"" + NormalizeTexts.escapeAttr(fileName) + "\"";
        return new ConvertResult("<folder key=\"" + fileKey + "\"" + nameAttr + "/>", Collections.<ResourceDescriptor>emptyList());
    }
}
