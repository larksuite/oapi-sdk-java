package com.lark.oapi.sample.channel;

import com.lark.oapi.channel.LarkChannel;
import com.lark.oapi.channel.LarkChannelFactory;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.model.MarkdownStreamController;
import com.lark.oapi.channel.model.MarkdownStreamProducer;
import com.lark.oapi.channel.model.StreamInput;

public class ChannelStreamingSample {
    public static void main(String[] args) throws Exception {
        LarkChannel channel = LarkChannelFactory.createLarkChannel(
                LarkChannelOptions.newBuilder(requiredEnv("APP_ID"), requiredEnv("APP_SECRET")).build()
        );

        channel.connectSync();
        try {
            channel.streamSync(requiredEnv("CHANNEL_CHAT_ID"), StreamInput.markdown(new MarkdownStreamProducer() {
                @Override
                public void produce(MarkdownStreamController controller) throws Exception {
                    controller.append("Thinking...\n\n");
                    Thread.sleep(300L);
                    controller.append("This is a streaming response.\n\n");
                    Thread.sleep(300L);
                    controller.append("Done.");
                }
            }));
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
