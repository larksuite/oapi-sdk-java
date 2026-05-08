package com.lark.oapi.channel;

import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.core.enums.BaseUrlEnum;
import com.lark.oapi.event.EventDispatcher;

final class ChannelClientFactory {
    private ChannelClientFactory() {
    }

    static Client createRawClient(LarkChannelOptions options) {
        Client.Builder builder = Client.newBuilder(options.getAppId(), options.getAppSecret());
        if (options.getDomain() != null) {
            builder.openBaseUrl(options.getDomain());
        } else {
            builder.openBaseUrl(BaseUrlEnum.FeiShu);
        }
        if (options.getCache() != null) {
            builder.tokenCache(options.getCache());
        }
        if (options.getHttpTransport() != null) {
            builder.httpTransport(options.getHttpTransport());
        }
        if (options.getSource() != null) {
            builder.source(options.getSource());
        }
        return builder.build();
    }

    static com.lark.oapi.ws.Client createWebSocketClient(
            LarkChannelOptions options,
            EventDispatcher eventDispatcher,
            final ChannelEventBus eventBus) {
        if (!"websocket".equals(options.getTransport())) {
            return null;
        }
        return new com.lark.oapi.ws.Client.Builder(options.getAppId(), options.getAppSecret())
                .eventHandler(eventDispatcher)
                .domain(options.getDomain() == null ? BaseUrlEnum.FeiShu.getUrl() : options.getDomain())
                .onReconnecting(new Runnable() {
                    @Override
                    public void run() {
                        eventBus.emit("reconnecting", null);
                    }
                })
                .onReconnected(new Runnable() {
                    @Override
                    public void run() {
                        eventBus.emit("reconnected", null);
                    }
                })
                .build();
    }
}
