package com.lark.oapi.channel.normalize;

public final class MessageConverters {
    private static final ConverterRegistry REGISTRY = new ConverterRegistry();

    private MessageConverters() {
    }

    public static ConvertResult convert(String messageType, String rawContent, MentionState mentionState,
                                        NormalizeOptions options, String messageId) {
        String type = messageType == null ? "unknown" : messageType;
        ConvertContext context = new ConvertContext(messageId, mentionState, options);
        ChannelMessageConverter converter = REGISTRY.get(type);
        if (converter == null) {
            converter = REGISTRY.get("unknown");
        }
        try {
            return converter.convert(rawContent, context);
        } catch (Exception ignored) {
            return REGISTRY.get("unknown").convert(rawContent, context);
        }
    }
}
