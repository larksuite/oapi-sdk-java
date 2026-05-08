package com.lark.oapi.sample.channel;

import com.lark.oapi.channel.LarkChannel;
import com.lark.oapi.channel.ChannelEventHandler;
import com.lark.oapi.channel.LarkChannelFactory;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.channel.model.SendInput;
import com.lark.oapi.channel.model.SendOptions;
import com.lark.oapi.channel.model.SendResult;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ChannelSample {
    public static void main(String[] args) throws Exception {
        String appId = requiredEnv("APP_ID");
        String appSecret = requiredEnv("APP_SECRET");
        String transport = envOrDefault("CHANNEL_TRANSPORT", "websocket");
        String receiveId = System.getenv("CHANNEL_RECEIVE_ID");
        String replyTo = System.getenv("CHANNEL_REPLY_TO");
        String mentionOpenId = System.getenv("CHANNEL_MENTION_OPEN_ID");
        long keepAliveSeconds = Long.parseLong(envOrDefault("CHANNEL_KEEP_ALIVE_SECONDS", "60"));

        LarkChannel channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder(appId, appSecret)
                        .transport(transport)
                        .build()
        );

        registerHandlers(channel);

        System.out.println("[channel] connecting with transport=" + transport);
        BotIdentity identity = channel.connect().get(30, TimeUnit.SECONDS);
        System.out.println("[channel] connected, bot openId=" + identity.getOpenId() + ", name=" + identity.getName());

        if (hasText(receiveId)) {
            SendResult text = channel.send(receiveId, SendInput.text("TC-001 Java Channel connect/send test")).get(30, TimeUnit.SECONDS);
            System.out.println("[channel] text sent, messageId=" + text.getMessageId());

            SendResult markdown = channel.send(receiveId, SendInput.markdown("# Java Channel Test\n\n- connect: ok\n- markdown: ok"))
                    .get(30, TimeUnit.SECONDS);
            System.out.println("[channel] markdown sent, messageId=" + markdown.getMessageId()
                    + ", chunks=" + markdown.getChunkIds());

            if (hasText(replyTo)) {
                SendResult reply = channel.send(receiveId, SendInput.text("Java Channel reply test"),
                        SendOptions.newBuilder().replyTo(replyTo).build()).get(30, TimeUnit.SECONDS);
                System.out.println("[channel] reply sent, messageId=" + reply.getMessageId());
            }

            if (hasText(mentionOpenId)) {
                SendResult mention = channel.send(receiveId, SendInput.text("Java Channel mention test"),
                        SendOptions.newBuilder().mentions(Arrays.asList(mentionOpenId)).build()).get(30, TimeUnit.SECONDS);
                System.out.println("[channel] mention sent, messageId=" + mention.getMessageId());
            }
        } else {
            System.out.println("[channel] CHANNEL_RECEIVE_ID is empty, skip sending messages.");
        }

        if ("websocket".equals(transport)) {
            System.out.println("[channel] listening for " + keepAliveSeconds + " seconds. Send a message to the bot to verify receive events.");
            Thread.sleep(TimeUnit.SECONDS.toMillis(keepAliveSeconds));
        }

        channel.disconnect().get(10, TimeUnit.SECONDS);
        System.out.println("[channel] disconnected");
    }

    private static void registerHandlers(LarkChannel channel) {
        channel.on("message", new ChannelEventHandler<Object>() {
            @Override
            public void handle(Object event) {
                System.out.println("[channel:on message] " + event);
            }
        });
        channel.on("cardAction", new ChannelEventHandler<Object>() {
            @Override
            public void handle(Object event) {
                System.out.println("[channel:on cardAction] " + event);
            }
        });
        channel.on("reaction", new ChannelEventHandler<Object>() {
            @Override
            public void handle(Object event) {
                System.out.println("[channel:on reaction] " + event);
            }
        });
        channel.on("botAdded", new ChannelEventHandler<Object>() {
            @Override
            public void handle(Object event) {
                System.out.println("[channel:on botAdded] " + event);
            }
        });
        channel.on("reject", new ChannelEventHandler<Object>() {
            @Override
            public void handle(Object event) {
                System.out.println("[channel:on reject] " + event);
            }
        });
        channel.on("error", new ChannelEventHandler<Object>() {
            @Override
            public void handle(Object event) {
                System.out.println("[channel:on error] " + event);
            }
        });
        channel.on("reconnecting", new ChannelEventHandler<Object>() {
            @Override
            public void handle(Object event) {
                System.out.println("[channel:on reconnecting]");
            }
        });
        channel.on("reconnected", new ChannelEventHandler<Object>() {
            @Override
            public void handle(Object event) {
                System.out.println("[channel:on reconnected]");
            }
        });
    }

    private static String requiredEnv(String name) {
        String value = System.getenv(name);
        if (!hasText(value)) {
            throw new IllegalArgumentException("Missing required env: " + name);
        }
        return value;
    }

    private static String envOrDefault(String name, String defaultValue) {
        String value = System.getenv(name);
        return hasText(value) ? value : defaultValue;
    }

    private static boolean hasText(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
