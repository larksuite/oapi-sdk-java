package com.lark.oapi.ws;

import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.event.EventDispatcher;
import com.lark.oapi.okhttp.*;
import com.lark.oapi.ws.exception.ClientException;
import com.lark.oapi.ws.exception.ServerException;
import com.lark.oapi.ws.model.ClientConfig;
import com.lark.oapi.ws.model.Endpoint;
import com.lark.oapi.ws.model.EndpointResp;

import java.io.IOException;

import static com.lark.oapi.ws.Constant.*;

public class Client {
    private String appId;
    private String appSecret;
    private EventDispatcher eventHandler;
    private Boolean autoReconnect;
    private String domain;
    private WebSocket conn;
    private String connUrl;
    private String serviceId;
    private String connId;
    private Integer reconnectNonce;
    private Integer reconnectCount;
    private Integer reconnectInterval;
    private Integer pingInterval;
    private OkHttpClient httpClient;

    public String connUrl() {
        return connUrl;
    }

    private Client(Builder builder) {
        this.appId = builder.appId;
        this.appSecret = builder.appSecret;
        this.eventHandler = builder.eventHandler;
        this.autoReconnect = builder.autoReconnect;
        this.domain = builder.domain != null ? builder.domain : "https://open.feishu.cn/";
        this.reconnectNonce = 30;
        this.reconnectCount = -1;
        this.reconnectInterval = 120;
        this.pingInterval = 120;
        this.httpClient = new OkHttpClient();
    }

    public static class Builder {
        private String appId;
        private String appSecret;
        private EventDispatcher eventHandler;
        private Boolean autoReconnect;
        private String domain;

        public Builder(String appId, String appSecret) {
            this.appId = appId;
            this.appSecret = appSecret;
        }

        public Builder eventHandler(EventDispatcher eventHandler) {
            this.eventHandler = eventHandler;
            return this;
        }

        public Builder autoReconnect(Boolean autoReconnect) {
            this.autoReconnect = autoReconnect;
            return this;
        }

        public Builder domain(String domain) {
            this.domain = domain;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }


    public void start() {
        try {
            this.connect();
        } catch (Exception e) {

        }
    }

    private String getConnUrl() throws IOException {
        String body = String.format("{\"AppID\": \"%s\", \"AppSecret\": \"%s\"}", this.appId, this.appSecret);
        Request request = new Request.Builder()
                .url(this.domain + GEN_ENDPOINT_URI)
                .addHeader("locale", "zh")
                .post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body))
                .build();
        Response response = this.httpClient.newCall(request).execute();
        if (response.code() != 200 || response.body() == null) {
            throw new ServerException(response.code(), "system busy");
        }

        EndpointResp resp = Jsons.DEFAULT.fromJson(response.body().string(), EndpointResp.class);
        if (resp.getCode() == OK) {
            // do nothing
        } else if (resp.getCode() == SYSTEM_BUSY) {
            throw new ServerException(resp.getCode(), "system busy");
        } else if (resp.getCode() == INTERNAL_ERROR) {
            throw new ServerException(resp.getCode(), resp.getMsg());
        } else {
            throw new ClientException(resp.getCode(), resp.getMsg());
        }

        Endpoint data = resp.getData();
        if (data.getClientConfig() != null) {
            this.configure(data.getClientConfig());
        }

        return data.getUrl();
    }


    private synchronized void connect() throws IOException {
        if (this.conn != null) {
            return;
        }
        this.connUrl = this.getConnUrl();
        HttpUrl u = parseUrl(connUrl);
        this.connId = u.queryParameter(DEVICE_ID);
        this.serviceId = u.queryParameter(SERVICE_ID);

        Request request = new Request.Builder()
                .url(connUrl)
                .build();
        this.conn = this.httpClient.newWebSocket(request, new Listener(this));
    }

    private void configure(ClientConfig conf) {
        this.reconnectCount = conf.getReconnectCount();
        this.reconnectInterval = conf.getReconnectInterval();
        this.reconnectNonce = conf.getReconnectNonce();
        this.pingInterval = conf.getPingInterval();
    }

    private HttpUrl parseUrl(String url) {
        HttpUrl u = HttpUrl.parse(connUrl.replace("wss://", "https://"));
        if (u == null) {
            throw new ServerException(500, "connect url is invalid");
        }
        return u;
    }
}
