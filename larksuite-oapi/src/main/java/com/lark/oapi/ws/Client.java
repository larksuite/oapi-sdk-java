package com.lark.oapi.ws;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.lark.oapi.google.protobuf.ByteString;
import com.lark.oapi.core.UserAgent;
import com.lark.oapi.core.enums.BaseUrlEnum;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.event.EventDispatcher;
import com.lark.oapi.event.exception.HandlerNotFoundException;
import com.lark.oapi.okhttp.*;
import com.lark.oapi.ws.enums.FrameType;
import com.lark.oapi.ws.enums.MessageType;
import com.lark.oapi.ws.exception.ClientException;
import com.lark.oapi.ws.exception.HeaderNotFoundException;
import com.lark.oapi.ws.exception.ServerException;
import com.lark.oapi.ws.exception.ServerUnreachableException;
import com.lark.oapi.ws.model.ClientConfig;
import com.lark.oapi.ws.model.Endpoint;
import com.lark.oapi.ws.model.EndpointResp;
import com.lark.oapi.ws.pb.Pbbp2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;

import static com.lark.oapi.ws.Constant.*;

public class Client {
    private static final Logger log = LoggerFactory.getLogger(Client.class);
    protected final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2 + 1);
    private final String appId;
    private final String appSecret;
    private final EventDispatcher eventHandler;
    private final String domain;
    private final String userAgent;
    private final Map<String, String> headers;
    private final OkHttpClient httpClient;
    private final Cache<String, byte[][]> cache;
    private final Runnable onReconnecting;
    private final Runnable onReconnected;
    protected Boolean autoReconnect;
    protected WebSocket conn;
    protected String connUrl;
    protected volatile Boolean isReconnecting;
    protected volatile boolean userClosed;
    private String serviceId;
    private String connId;
    private Integer reconnectNonce;
    private Integer reconnectCount;
    private Integer reconnectInterval;
    private Integer pingInterval;
    private volatile CompletableFuture<Void> readyFuture;
    private volatile boolean pingLoopRunning;
    private volatile boolean hasEverConnected;


    private Client(Builder builder) {
        this.appId = builder.appId;
        this.appSecret = builder.appSecret;
        this.eventHandler = builder.eventHandler;
        this.autoReconnect = builder.autoReconnect != null ? builder.autoReconnect : true;
        this.domain = builder.domain != null ? builder.domain : BaseUrlEnum.FeiShu.getUrl();
        this.userAgent = UserAgent.build(builder.source);
        this.headers = new HashMap<>();
        if (builder.headers != null) {
            this.headers.putAll(builder.headers);
        }
        this.reconnectNonce = 30;
        this.reconnectCount = -1;
        this.reconnectInterval = 120;
        this.pingInterval = 120;
        this.httpClient = new OkHttpClient();
        this.isReconnecting = false;
        this.userClosed = false;
        this.cache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build();
        this.readyFuture = new CompletableFuture<>();
        this.onReconnecting = builder.onReconnecting;
        this.onReconnected = builder.onReconnected;
        this.pingLoopRunning = false;
        this.hasEverConnected = false;
    }

    public void start() {
        this.userClosed = false;
        if (this.readyFuture.isDone()) {
            this.readyFuture = new CompletableFuture<>();
        }
        try {
            this.connect();
        } catch (ClientException e) {
            markFailed(e);
            log.error(e.toString());
            throw e;
        } catch (Throwable t) {
            log.error(t.toString());
            this.disconnect();
            if (shouldReconnect()) {
                try {
                    this.reconnect();
                } catch (Throwable reconnectError) {
                    markFailed(reconnectError);
                    if (reconnectError instanceof RuntimeException) {
                        throw (RuntimeException) reconnectError;
                    }
                    if (reconnectError instanceof Error) {
                        throw (Error) reconnectError;
                    }
                    throw new RuntimeException(reconnectError);
                }
            } else {
                markFailed(t);
            }
        }
        startPingLoop();
    }

    public void awaitReady(long timeoutMs) throws Exception {
        try {
            this.readyFuture.get(timeoutMs, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            throw new ServerUnreachableException(String.format("websocket handshake did not complete within %dms", timeoutMs));
        } catch (java.util.concurrent.ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Exception) {
                throw (Exception) cause;
            }
            throw new RuntimeException(cause);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw e;
        }
    }

    public void close() {
        this.userClosed = true;
        if (!this.readyFuture.isDone()) {
            this.readyFuture.completeExceptionally(new ServerUnreachableException("websocket client closed"));
        }
        this.disconnect();
    }

    private synchronized void startPingLoop() {
        if (this.pingLoopRunning) {
            return;
        }
        this.pingLoopRunning = true;
        this.executor.execute(this::pingLoop);
    }

    private void pingLoop() {
        try {
            this.sleep(2000);
            while (!this.userClosed) {
                try {
                    if (this.conn != null) {
                        Pbbp2.Frame frame = newPingFrame(Integer.parseInt(this.serviceId));
                        this.conn.send(com.lark.oapi.okio.ByteString.of(frame.toByteArray()));
                        log.debug(fmtLog("ping success"));
                    }
                } catch (Throwable t) {
                    log.warn(fmtLog("ping failed"), t);
                } finally {
                    this.sleep(this.pingInterval * 1000);
                }
            }
        } finally {
            this.pingLoopRunning = false;
        }
    }

    protected synchronized void disconnect() {
        try {
            if (this.conn == null) {
                return;
            }
            this.conn.close(1000, "client closed");
            log.info(fmtLog("disconnected to %s", this.connUrl));
        } finally {
            this.conn = null;
            this.connUrl = null;
            this.connId = null;
            this.serviceId = null;
        }
    }

    protected void reconnect() {
        this.isReconnecting = true;

        try {
            if (this.hasEverConnected) {
                safeRun(this.onReconnecting);
            }
            log.info("start reconnecting...");
            // 首次重连随机抖动
            if (this.reconnectNonce > 0) {
                Random rand = new Random();
                int nonce = rand.nextInt(this.reconnectNonce * 1000);
                this.sleep(nonce);
            }
            if (!shouldReconnect()) {
                return;
            }

            // 重连
            if (this.reconnectCount >= 0) {
                for (int i = 0; i < this.reconnectCount && shouldReconnect(); i++) {
                    if (this.conn != null) {
                        return;
                    }
                    if (tryConnect(i)) {
                        return;
                    }
                    this.sleep(this.reconnectInterval * 1000);
                }
                if (!shouldReconnect()) {
                    return;
                }
                throw new ServerUnreachableException(String.format("unable to connect to the server after trying %d times", this.reconnectCount));
            } else {
                int i = 0;
                while (shouldReconnect()) {
                    if (this.conn != null) {
                        return;
                    }
                    if (tryConnect(i)) {
                        return;
                    }
                    this.sleep(this.reconnectInterval * 1000);
                    i++;
                }
            }
        } finally {
            this.isReconnecting = false;
        }
    }

    private boolean tryConnect(int cnt) {
        if (!shouldReconnect()) {
            return false;
        }
        cnt++;
        String time;
        switch (cnt) {
            case 1:
                time = cnt + "st";
                break;
            case 2:
                time = cnt + "nd";
                break;
            case 3:
                time = cnt + "rd";
                break;
            default:
                time = cnt + "th";
                break;
        }

        log.info(fmtLog("trying to reconnect for the %s time", time));
        try {
            connect();
            return true;
        } catch (ClientException e) {
            log.error(e.toString());
            throw e;
        } catch (Throwable t) {
            log.error(t.toString());
            return false;
        }
    }

    protected void markConnected() {
        if (this.userClosed) {
            return;
        }
        if (this.readyFuture.isCompletedExceptionally()) {
            this.readyFuture = new CompletableFuture<>();
        }
        if (Boolean.TRUE.equals(this.isReconnecting) && this.hasEverConnected) {
            safeRun(this.onReconnected);
        }
        this.hasEverConnected = true;
        if (!this.readyFuture.isDone()) {
            this.readyFuture.complete(null);
        }
    }

    protected void markFailed(Throwable error) {
        if (!this.readyFuture.isDone()) {
            this.readyFuture.completeExceptionally(error);
        }
    }

    protected boolean shouldReconnect() {
        return this.autoReconnect && !this.userClosed;
    }

    private String getConnUrl() throws IOException {
        String body = String.format("{\"AppID\": \"%s\", \"AppSecret\": \"%s\"}", this.appId, this.appSecret);
        Request.Builder requestBuilder = new Request.Builder()
                .url(this.domain + GEN_ENDPOINT_URI);
        applyHeaders(requestBuilder);
        Request request = requestBuilder
                .header("locale", "zh")
                .header("User-Agent", resolvedUserAgent())
                .post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body))
                .build();
        try (Response response = this.httpClient.newCall(request).execute()) {
            if (response.code() != 200 || response.body() == null) {
                throw new ServerException(response.code(), "system busy");
            }

            EndpointResp resp = Jsons.DEFAULT.fromJson(response.body().string(), EndpointResp.class);
            if (resp.getCode() == SYSTEM_BUSY) {
                throw new ServerException(resp.getCode(), "system busy");
            } else if (resp.getCode() == INTERNAL_ERROR) {
                throw new ServerException(resp.getCode(), resp.getMsg());
            } else if (resp.getCode() != OK) {
                throw new ClientException(resp.getCode(), resp.getMsg());
            }

            Endpoint data = resp.getData();
            if (data.getClientConfig() != null) {
                this.configure(data.getClientConfig());
            }

            return data.getUrl();
        }
    }

    private synchronized void connect() throws IOException {
        if (this.conn != null) {
            return;
        }
        this.connUrl = this.getConnUrl();
        HttpUrl u = parseUrl(this.connUrl);
        this.connId = u.queryParameter(DEVICE_ID);
        this.serviceId = u.queryParameter(SERVICE_ID);

        Request request = new Request.Builder()
                .url(connUrl)
                .header("User-Agent", resolvedUserAgent())
                .build();
        this.httpClient.newWebSocket(request, new Listener(this));
    }

    protected void handleMessage(byte[] msg) {
        try {
            Pbbp2.Frame frame = Pbbp2.Frame.parseFrom(msg);
            FrameType ft = FrameType.of(frame.getMethod());

            switch (ft) {
                case CONTROL:
                    handleControlFrame(frame);
                    break;
                case DATA:
                    handleDataFrame(frame);
                    break;
            }
        } catch (Exception e) {
            log.error(fmtLog("handle message failed"), e);
        }
    }

    private void handleControlFrame(Pbbp2.Frame frame) {
        List<Pbbp2.Header> hs = frame.getHeadersList();
        MessageType mt = MessageType.of(getString(hs, HEADER_TYPE));

        switch (mt) {
            case PING:
                return;
            case PONG:
                log.debug(fmtLog("receive pong"));
                if (!frame.hasPayload()) {
                    return;
                }
                ClientConfig conf = Jsons.DEFAULT.fromJson(frame.getPayload().toStringUtf8(), ClientConfig.class);
                configure(conf);
                break;
        }
    }

    private void handleDataFrame(Pbbp2.Frame frame) {
        List<Pbbp2.Header> hs = frame.getHeadersList();
        String msgId = getString(hs, HEADER_MESSAGE_ID);
        String traceId = getString(hs, HEADER_TRACE_ID);
        Integer sum = getInteger(hs, HEADER_SUM);
        Integer seq = getInteger(hs, HEADER_SEQ);
        String type = getString(hs, HEADER_TYPE);

        byte[] pl = frame.getPayload().toByteArray();
        if (sum > 1) {
            // 合包
            pl = combine(msgId, sum, seq, pl);
            if (pl == null) {
                return;
            }
        }

        MessageType mt = MessageType.of(type);
        log.debug(fmtLog("receive message, message_type: %s, message_id: %s, trace_id: %s, payload: %s",
                mt.getName(), msgId, traceId, new String(pl, StandardCharsets.UTF_8)));

        com.lark.oapi.ws.model.Response response = new com.lark.oapi.ws.model.Response(200);
        long start = System.currentTimeMillis();
        try {
            switch (mt) {
                case EVENT:
                    Object r = this.eventHandler.doWithoutValidation(pl);
                    if (r != null) {
                        response.setData(Jsons.DEFAULT.toJson(r).getBytes(StandardCharsets.UTF_8));
                    }
                    break;
                case CARD:
                    return;
            }
        } catch (Throwable e) {
            if (e instanceof HandlerNotFoundException) {
                log.warn(fmtLog("handle message failed, message_type: %s, message_id: %s, trace_id: %s, err: %s",
                        mt.getName(), msgId, traceId, e.getMessage()));
            } else {
                log.error(fmtLog("handle message failed, message_type: %s, message_id: %s, trace_id: %s,",
                        mt.getName(), msgId, traceId), e);
            }
            response = new com.lark.oapi.ws.model.Response(500);
        }
        long end = System.currentTimeMillis();

        byte[] resp = Jsons.DEFAULT.toJson(response).getBytes(StandardCharsets.UTF_8);
        byte[] bs = frame.toBuilder()
                .setPayload(ByteString.copyFrom(resp))
                .addHeaders(Pbbp2.Header.newBuilder()
                        .setKey(HEADER_BIZ_RT)
                        .setValue(String.valueOf(end - start))
                        .build())
                .build()
                .toByteArray();
        this.conn.send(com.lark.oapi.okio.ByteString.of(bs));
    }

    private byte[] combine(String msgId, int sum, int seq, byte[] bs) {
        byte[][] val = this.cache.getIfPresent(msgId);
        if (val == null) {
            byte[][] buf = new byte[sum][];
            buf[seq] = bs;
            this.cache.put(msgId, buf);
            return null;
        }

        val[seq] = bs;
        ByteArrayOutputStream pl = new ByteArrayOutputStream();
        for (byte[] v : val) {
            if (v == null) {
                this.cache.put(msgId, val);
                return null;
            }
            try {
                pl.write(v);
            } catch (IOException ignored) {
            }
        }

        return pl.toByteArray();
    }

    private void configure(ClientConfig conf) {
        this.reconnectCount = conf.getReconnectCount();
        this.reconnectInterval = conf.getReconnectInterval();
        this.reconnectNonce = conf.getReconnectNonce();
        this.pingInterval = conf.getPingInterval();
    }

    private HttpUrl parseUrl(String url) {
        String httpUrl = url.replace("wss://", "https://").replace("ws://", "https://");
        HttpUrl u = HttpUrl.parse(httpUrl);
        if (u == null) {
            throw new ServerException(500, "connect url is invalid");
        }
        return u;
    }

    private String getString(List<Pbbp2.Header> headers, String key) {
        return headers.stream()
                .filter(o -> o.getKey().equals(key))
                .findFirst()
                .map(Pbbp2.Header::getValue)
                .orElseThrow(() -> new HeaderNotFoundException(key));
    }

    private Integer getInteger(List<Pbbp2.Header> headers, String key) {
        return headers.stream()
                .filter(o -> o.getKey().equals(key))
                .findFirst()
                .map(Pbbp2.Header::getValue)
                .map(Integer::parseInt)
                .orElseThrow(() -> new HeaderNotFoundException(key));
    }

    protected String fmtLog(String format, Object... args) {
        String log = String.format(format, args);

        if (this.connId != null) {
            log += String.format(" [conn_id=%s]", this.connId);
        }

        return log;
    }

    private Pbbp2.Frame newPingFrame(int serviceId) {
        return Pbbp2.Frame.newBuilder()
                .setService(serviceId)
                .setMethod(FrameType.CONTROL.getCode())
                .addHeaders(Pbbp2.Header.newBuilder()
                        .setKey(HEADER_TYPE)
                        .setValue(MessageType.PING.getName())
                        .build())
                .setSeqID(0)
                .setLogID(0)
                .build();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }

    private void safeRun(Runnable callback) {
        if (callback == null) {
            return;
        }
        try {
            callback.run();
        } catch (Throwable ignored) {
        }
    }

    private void applyHeaders(Request.Builder requestBuilder) {
        for (Map.Entry<String, String> header : this.headers.entrySet()) {
            if (header.getKey() != null && header.getValue() != null) {
                requestBuilder.addHeader(header.getKey(), header.getValue());
            }
        }
    }

    private String resolvedUserAgent() {
        for (Map.Entry<String, String> header : this.headers.entrySet()) {
            if (header.getKey() != null
                    && header.getValue() != null
                    && "User-Agent".equalsIgnoreCase(header.getKey())) {
                return header.getValue();
            }
        }
        return this.userAgent;
    }

    public static class Builder {
        private final String appId;
        private final String appSecret;
        private EventDispatcher eventHandler;
        private Boolean autoReconnect;
        private String domain;
        private Map<String, String> headers;
        private String source;
        private Runnable onReconnecting;
        private Runnable onReconnected;

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

        public Builder headers(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public Builder header(String key, String value) {
            if (this.headers == null) {
                this.headers = new HashMap<>();
            }
            this.headers.put(key, value);
            return this;
        }

        public Builder source(String source) {
            this.source = source;
            return this;
        }

        public Builder onReconnecting(Runnable onReconnecting) {
            this.onReconnecting = onReconnecting;
            return this;
        }

        public Builder onReconnected(Runnable onReconnected) {
            this.onReconnected = onReconnected;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }
}
