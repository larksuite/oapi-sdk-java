package com.lark.oapi.sample.channel;

import com.lark.oapi.channel.LarkChannel;
import com.lark.oapi.channel.LarkChannelFactory;
import com.lark.oapi.channel.config.LarkChannelOptions;
import java.util.Arrays;

public class ChannelPolicyHotUpdateSample {
    public static void main(String[] args) throws Exception {
        LarkChannelOptions.PolicyConfig policy = new LarkChannelOptions.PolicyConfig();
        policy.setRequireMention(true);

        LarkChannel channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder(requiredEnv("APP_ID"), requiredEnv("APP_SECRET"))
                        .policy(policy)
                        .build()
        );

        channel.connectSync();
        try {
            LarkChannelOptions.PolicyConfig update = new LarkChannelOptions.PolicyConfig();
            update.setGroupAllowlist(Arrays.asList(requiredEnv("CHANNEL_CHAT_ID")));
            update.setRequireMention(false);
            channel.updatePolicy(update);

            System.out.println("Policy updated. requireMention=" + channel.getPolicy().isRequireMention());
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
