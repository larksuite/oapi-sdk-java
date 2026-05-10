package com.lark.oapi.channel.normalize;

public final class MessageConverters {
    private static final ConverterRegistry REGISTRY = new ConverterRegistry();

    private MessageConverters() {
    }

    public static ConvertResult convert(String messageType, String rawContent, MentionState mentionState,
                                        NormalizeOptions options, String messageId) {
        return dispatchConvert(rawContent, messageType, new ConvertContext(messageId, mentionState, options));
    }

    /**
     * Dispatch a message content to the matching converter, with uniform error
     * containment. Any thrown error is trapped and the fallback converter is
     * invoked instead so normalization never fails catastrophically.
     */
    public static ConvertResult dispatchConvert(String rawContent, String messageType, ConvertContext context) {
        String type = messageType == null ? "unknown" : messageType;
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
