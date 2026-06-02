package com.lark.oapi.sample.channel;

import com.lark.oapi.channel.LarkChannel;
import com.lark.oapi.channel.LarkChannelFactory;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;

import java.nio.charset.StandardCharsets;

public class ChannelRawClientSample {
    public static void main(String[] args) throws Exception {
        LarkChannel channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder(requiredEnv("APP_ID"), requiredEnv("APP_SECRET")).build()
        );

        channel.connectSync();
        try {
            RawResponse response = channel.getRawClient().get(
                    "/open-apis/bot/v3/info",
                    null,
                    AccessTokenType.Tenant);
            System.out.println(new String(response.getBody(), StandardCharsets.UTF_8));
        } finally {
            channel.disconnectSync();
        }
    }

    private static String requiredEnv(String name) {
        String value = System.getenv(name);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Missing required env: " + name);
        }
        return value;
    }
}
