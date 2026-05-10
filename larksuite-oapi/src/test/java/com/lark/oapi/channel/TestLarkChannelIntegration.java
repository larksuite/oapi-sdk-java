package com.lark.oapi.channel;

import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.model.BotIdentity;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class TestLarkChannelIntegration {
    private LarkChannel channel;

    @After
    public void tearDown() throws Exception {
        if (channel != null) {
            channel.disconnect().get(10, TimeUnit.SECONDS);
        }
    }

    @Test
    public void testConnectWithRealFeishuApp() throws Exception {
        assumeIntegrationEnabled();

        channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder(requiredEnv("LARK_CHANNEL_IT_APP_ID"), requiredEnv("LARK_CHANNEL_IT_APP_SECRET"))
                        .transport("webhook")
                        .build()
        );

        BotIdentity identity = channel.connect().get(30, TimeUnit.SECONDS);

        Assert.assertNotNull(identity);
        Assert.assertNotNull(identity.getOpenId());
        Assert.assertFalse(identity.getOpenId().isEmpty());
        Assert.assertSame(identity, channel.getBotIdentity());
    }

    @Test
    public void testWebSocketConnectWithRealFeishuAppWhenEnabled() throws Exception {
        assumeIntegrationEnabled();
        Assume.assumeTrue("Set LARK_CHANNEL_IT_ENABLE_WS=true to run websocket integration test.",
                "true".equalsIgnoreCase(System.getenv("LARK_CHANNEL_IT_ENABLE_WS")));

        channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder(requiredEnv("LARK_CHANNEL_IT_APP_ID"), requiredEnv("LARK_CHANNEL_IT_APP_SECRET"))
                        .transport("websocket")
                        .build()
        );

        BotIdentity identity = channel.connect().get(45, TimeUnit.SECONDS);

        Assert.assertNotNull(identity);
        Assert.assertNotNull(identity.getOpenId());
        Assert.assertFalse(identity.getOpenId().isEmpty());
        Assert.assertSame(identity, channel.getBotIdentity());
    }

    private static void assumeIntegrationEnabled() {
        Assume.assumeTrue("Set LARK_CHANNEL_IT_ENABLED=true to run real Feishu integration tests.",
                "true".equalsIgnoreCase(System.getenv("LARK_CHANNEL_IT_ENABLED")));
        Assume.assumeTrue("Set LARK_CHANNEL_IT_APP_ID and LARK_CHANNEL_IT_APP_SECRET.",
                hasText(System.getenv("LARK_CHANNEL_IT_APP_ID")) && hasText(System.getenv("LARK_CHANNEL_IT_APP_SECRET")));
    }

    private static String requiredEnv(String name) {
        String value = System.getenv(name);
        if (!hasText(value)) {
            throw new IllegalStateException("Missing environment variable: " + name);
        }
        return value;
    }

    private static boolean hasText(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
