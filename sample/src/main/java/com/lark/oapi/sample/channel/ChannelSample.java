package com.lark.oapi.sample.channel;

import com.lark.oapi.channel.LarkChannel;
import com.lark.oapi.channel.ChannelEventHandler;
import com.lark.oapi.channel.LarkChannelFactory;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.channel.model.NormalizedMessage;
import com.lark.oapi.channel.model.SendInput;
import com.lark.oapi.channel.model.SendOptions;
import com.lark.oapi.channel.model.SendResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ChannelSample {
    private static final Map<String, String> DOT_ENV = loadDotEnv();

    public static void main(String[] args) throws Exception {
        String transport = envOrDefault("CHANNEL_TRANSPORT", "websocket");
        long keepAliveSeconds = Long.parseLong(envOrDefault("CHANNEL_KEEP_ALIVE_SECONDS", "60"));

        final LarkChannel channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder(requiredEnv("APP_ID"), requiredEnv("APP_SECRET"))
                        .transport(transport)
                        .build()
        );

        channel.on("message", new ChannelEventHandler<NormalizedMessage>() {
            @Override
            public void handle(NormalizedMessage message) {
                try {
                    String answer = callAgent(message.getContent());
                    sendReply(channel, message, SendInput.markdown(answer));
                } catch (Exception e) {
                    sendReply(channel, message, SendInput.text("Agent failed, please try again later."));
                }
            }
        });

        System.out.println("[channel] connecting with transport=" + transport);
        BotIdentity identity = channel.connect().get(30, TimeUnit.SECONDS);
        System.out.println("[channel] connected, bot openId=" + identity.getOpenId() + ", name=" + identity.getName());

        if ("websocket".equals(transport)) {
            if (keepAliveSeconds <= 0) {
                System.out.println("[channel] listening forever. Press Ctrl+C to stop.");
                Thread.currentThread().join();
            }
            System.out.println("[channel] listening for " + keepAliveSeconds + " seconds. Send a message to the bot to verify receive events.");
            Thread.sleep(TimeUnit.SECONDS.toMillis(keepAliveSeconds));
        }

        channel.disconnect().get(10, TimeUnit.SECONDS);
        System.out.println("[channel] disconnected");
    }

    private static String callAgent(String userInput) {
        return "Received: " + (hasText(userInput) ? userInput : "[empty message]");
    }

    private static void sendReply(LarkChannel channel, NormalizedMessage message, SendInput input) {
        try {
            SendResult result = channel.send(
                    message.getChatId(),
                    input,
                    SendOptions.newBuilder().replyTo(message.getMessageId()).build()
            ).get(30, TimeUnit.SECONDS);
            System.out.println("[channel] replied, messageId=" + result.getMessageId());
        } catch (Exception replyError) {
            try {
                SendResult result = channel.send(message.getChatId(), input).get(30, TimeUnit.SECONDS);
                System.out.println("[channel] sent fallback, messageId=" + result.getMessageId());
            } catch (Exception fallbackError) {
                System.out.println("[channel] failed to send agent response: " + fallbackError.getMessage());
            }
        }
    }

    private static String requiredEnv(String name) {
        String value = env(name);
        if (!hasText(value)) {
            throw new IllegalArgumentException("Missing required env: " + name);
        }
        return value;
    }

    private static String envOrDefault(String name, String defaultValue) {
        String value = env(name);
        return hasText(value) ? value : defaultValue;
    }

    private static String env(String name) {
        String value = DOT_ENV.get(name);
        if (hasText(value)) {
            return value;
        }
        return System.getenv(name);
    }

    private static Map<String, String> loadDotEnv() {
        File envFile = findDotEnvFile();
        Map<String, String> values = new LinkedHashMap<String, String>();
        if (envFile == null) {
            return values;
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(envFile));
            String line;
            while ((line = reader.readLine()) != null) {
                parseDotEnvLine(line, values);
            }
            System.out.println("[channel] loaded .env from " + envFile.getAbsolutePath());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read .env file: " + envFile.getAbsolutePath(), e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignore) {
                    // Ignore close failure in sample code.
                }
            }
        }
        return values;
    }

    private static File findDotEnvFile() {
        File current = new File(System.getProperty("user.dir"));
        while (current != null) {
            File candidate = new File(current, ".env");
            if (candidate.isFile()) {
                return candidate;
            }
            current = current.getParentFile();
        }
        return null;
    }

    private static void parseDotEnvLine(String rawLine, Map<String, String> values) {
        if (rawLine == null) {
            return;
        }
        String line = rawLine.trim();
        if (line.isEmpty() || line.startsWith("#")) {
            return;
        }
        if (line.startsWith("export ")) {
            line = line.substring("export ".length()).trim();
        }
        int separator = line.indexOf('=');
        if (separator <= 0) {
            return;
        }
        String key = line.substring(0, separator).trim();
        String value = stripQuotes(line.substring(separator + 1).trim());
        if (hasText(key)) {
            values.put(key, value);
        }
    }

    private static String stripQuotes(String value) {
        if (!hasText(value) || value.length() < 2) {
            return value;
        }
        char first = value.charAt(0);
        char last = value.charAt(value.length() - 1);
        if ((first == '"' && last == '"') || (first == '\'' && last == '\'')) {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }

    private static boolean hasText(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
