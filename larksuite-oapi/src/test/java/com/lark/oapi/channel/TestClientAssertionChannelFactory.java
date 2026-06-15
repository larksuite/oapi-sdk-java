package com.lark.oapi.channel;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.core.auth.ClientAssertionProvider;
import com.lark.oapi.core.auth.ClientAssertionToken;
import com.lark.oapi.core.cache.ICache;
import com.lark.oapi.core.httpclient.IHttpTransport;
import com.lark.oapi.core.request.RawRequest;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.event.EventDispatcher;
import com.sun.net.httpserver.HttpServer;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestClientAssertionChannelFactory {

    @Test
    public void optionsExposeClientAssertionProviderAndOAuthBaseUrl() {
        ClientAssertionProvider provider = aud -> new ClientAssertionToken("assertion");

        LarkChannelOptions options = LarkChannelOptions.newBuilder("cli_a", "")
                .clientAssertionProvider(provider)
                .oauthBaseUrl("https://accounts.feishu.cn")
                .domain("https://open.feishu.cn")
                .build();

        assertEquals(provider, options.getClientAssertionProvider());
        assertEquals("https://accounts.feishu.cn", options.getOAuthBaseUrl());
    }

    @Test
    public void rawClientReceivesClientAssertionOptions() throws Exception {
        CapturingTransport transport = new CapturingTransport();
        CapturingCache cache = new CapturingCache();
        AtomicReference<String> audRef = new AtomicReference<>();
        LarkChannelOptions options = LarkChannelOptions.newBuilder("cli_a", "")
                .clientAssertionProvider(aud -> {
                    audRef.set(aud);
                    return new ClientAssertionToken("client-assertion");
                })
                .oauthBaseUrl("http://accounts.local:8080")
                .domain("https://open.feishu.cn")
                .httpTransport(transport)
                .cache(cache)
                .build();

        Client rawClient = ChannelClientFactory.createRawClient(options);

        rawClient.get("/open-apis/test", null, AccessTokenType.Tenant);

        assertEquals("accounts.local:8080", audRef.get());
        assertEquals("http://accounts.local:8080/oauth/v3/token", transport.oauthRequest.getReqUrl());
        assertEquals("Bearer tenant-token", transport.apiRequest.getHeaders().get("Authorization").get(0));
    }

    @Test
    public void websocketClientReceivesClientAssertionProvider() throws Exception {
        CapturingServer server = CapturingServer.start();
        try {
            LarkChannelOptions options = LarkChannelOptions.newBuilder("cli_a", "")
                    .clientAssertionProvider(aud -> new ClientAssertionToken("client-assertion"))
                    .domain(server.domain())
                    .build();

            com.lark.oapi.ws.Client wsClient = ChannelClientFactory.createWebSocketClient(
                    options,
                    new EventDispatcher.Builder("", "").build(),
                    new ChannelEventBus());

            assertNotNull(wsClient);
            assertEquals("wss://example.test/callback?device_id=device&service_id=42", invokeGetConnUrl(wsClient));
            JsonObject body = server.requestBody();
            assertEquals("cli_a", body.get("AppID").getAsString());
            assertEquals("", body.get("AppSecret").getAsString());
            assertEquals("client-assertion", body.get("ClientAssertion").getAsString());
        } finally {
            server.stop();
        }
    }

    private static String invokeGetConnUrl(com.lark.oapi.ws.Client client) throws Exception {
        Method method = com.lark.oapi.ws.Client.class.getDeclaredMethod("getConnUrl");
        method.setAccessible(true);
        try {
            return (String) method.invoke(client);
        } catch (ReflectiveOperationException e) {
            Throwable cause = e.getCause();
            if (cause instanceof RuntimeException) {
                throw (RuntimeException) cause;
            }
            if (cause instanceof Exception) {
                throw (Exception) cause;
            }
            throw e;
        }
    }

    private static class CapturingTransport implements IHttpTransport {
        private RawRequest oauthRequest;
        private RawRequest apiRequest;

        @Override
        public RawResponse execute(RawRequest request) {
            RawResponse response = new RawResponse();
            response.setStatusCode(200);
            if (request.getReqUrl().contains("/oauth/v3/token")) {
                this.oauthRequest = request;
                response.setBody("{\"access_token\":\"tenant-token\",\"expires_in\":7200}".getBytes(StandardCharsets.UTF_8));
            } else {
                this.apiRequest = request;
                response.setBody("{\"code\":0}".getBytes(StandardCharsets.UTF_8));
            }
            return response;
        }
    }

    private static class CapturingCache implements ICache {
        @Override
        public String get(String key) {
            return "";
        }

        @Override
        public void set(String key, String value, int expire, TimeUnit timeUnit) {
        }
    }

    private static class CapturingServer {
        private final HttpServer server;
        private final AtomicReference<String> body = new AtomicReference<>();

        private CapturingServer(HttpServer server) {
            this.server = server;
        }

        private static CapturingServer start() throws IOException {
            HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
            CapturingServer capturingServer = new CapturingServer(server);
            server.createContext(com.lark.oapi.ws.Constant.GEN_ENDPOINT_URI, exchange -> {
                ByteArrayOutputStream requestBuffer = new ByteArrayOutputStream();
                byte[] requestChunk = new byte[1024];
                int read;
                while ((read = exchange.getRequestBody().read(requestChunk)) != -1) {
                    requestBuffer.write(requestChunk, 0, read);
                }
                capturingServer.body.set(new String(requestBuffer.toByteArray(), StandardCharsets.UTF_8));
                byte[] response = "{\"code\":0,\"data\":{\"URL\":\"wss://example.test/callback?device_id=device&service_id=42\"}}".getBytes(StandardCharsets.UTF_8);
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            });
            server.start();
            return capturingServer;
        }

        private String domain() {
            return "http://127.0.0.1:" + server.getAddress().getPort();
        }

        private JsonObject requestBody() {
            return JsonParser.parseString(body.get()).getAsJsonObject();
        }

        private void stop() {
            server.stop(0);
        }
    }
}
