package com.lark.oapi.ws;

import com.lark.oapi.card.CardActionHandler;
import com.lark.oapi.okhttp.Response;
import com.lark.oapi.okhttp.WebSocket;
import com.lark.oapi.okhttp.WebSocketListener;
import com.lark.oapi.okio.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;

public class Listener extends WebSocketListener {
    private static final Logger log = LoggerFactory.getLogger(Listener.class);
    private Client cli;

    public Listener(Client cli) {
        this.cli = cli;
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        log.info(String.format("connected to %s", this.cli.connUrl()));
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        super.onMessage(webSocket, text);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        super.onMessage(webSocket, bytes);
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        super.onClosing(webSocket, code, reason);
    }

    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
        super.onClosed(webSocket, code, reason);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, @Nullable Response response) {
        log.error("connect failed");
    }
}
