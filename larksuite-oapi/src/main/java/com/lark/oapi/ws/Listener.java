package com.lark.oapi.ws;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.okhttp.Response;
import com.lark.oapi.okhttp.WebSocket;
import com.lark.oapi.okhttp.WebSocketListener;
import com.lark.oapi.okio.ByteString;
import com.lark.oapi.ws.exception.ClientException;
import com.lark.oapi.ws.exception.ServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;

import static com.lark.oapi.ws.Constant.*;

public class Listener extends WebSocketListener {
    private static final Logger log = LoggerFactory.getLogger(Listener.class);
    private Client cli;

    public Listener(Client cli) {
        this.cli = cli;
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        this.cli.conn = webSocket;
        log.info(cli.fmtLog("connected to %s", this.cli.connUrl));
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        super.onMessage(webSocket, text);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        this.cli.executor.execute(() -> cli.handleMessage(bytes.toByteArray()));
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        super.onClosing(webSocket, code, reason);
    }

    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
        this.cli.disconnect();
        if (this.cli.autoReconnect) {
            this.cli.reconnect();
        }
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, @Nullable Response response) {
        try {
            if (response == null) {
                throw t;
            }
            String code = response.header(HEADER_HANDSHAKE_STATUS);
            String msg = response.header(HEADER_HANDSHAKE_MSG);
            if (Strings.isEmpty(code) || Strings.isEmpty(msg)) {
                throw t;
            }

            int c = Integer.parseInt(code);
            switch (c) {
                case AUTH_FAILED:
                    String authCode = response.header(HEADER_HANDSHAKE_AUTH_ERRCODE);
                    if (String.valueOf(EXCEED_CONN_LIMIT).equals(authCode)) {
                        throw new ClientException(c, msg);
                    } else {
                        throw new ServerException(c, msg);
                    }
                case FORBIDDEN:
                    throw new ClientException(c, msg);
                default:
                    throw new ServerException(c, msg);
            }
        } catch (ClientException e) {
            log.error(e.toString());
        } catch (Throwable e) {
            log.error(e.toString());
            if (this.cli.isReconnecting) {
                return;
            }
            this.cli.disconnect();
            if (this.cli.autoReconnect) {
                this.cli.reconnect();
            }
        }
    }
}
