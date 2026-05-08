package com.lark.oapi.channel;

import com.lark.oapi.channel.config.LarkChannelOptions;

public final class LarkChannelFactory {
    private LarkChannelFactory() {
    }

    public static LarkChannel createLarkChannel(LarkChannelOptions options) {
        return new LarkChannel(options);
    }
}
