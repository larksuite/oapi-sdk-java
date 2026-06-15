package com.lark.oapi.e2e;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lark.oapi.Client;
import com.lark.oapi.core.Constants;
import com.lark.oapi.core.accesstoken.AuthorizationCodeTokenRequest;
import com.lark.oapi.core.accesstoken.RefreshTokenRequest;
import com.lark.oapi.core.auth.ClientAssertionToken;
import com.lark.oapi.core.auth.TargetInfo;
import com.lark.oapi.core.cache.ICache;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.ws.Constant;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpServer;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;

public class TestClientAssertionLocalE2E {

    @Test
    public void ordinaryOpenApiRequestAutoAuthenticatesWithLocalOAuthServer() throws Exception {
        LocalServer server = LocalServer.start();
        AtomicReference<String> audRef = new AtomicReference<>();
        try {
            Client client = Client.newBuilder("cli_a", "")
                    .openBaseUrl(server.domain())
                    .oauthBaseUrl(server.domain())
                    .clientAssertionProvider(aud -> {
                        audRef.set(aud);
                        return new ClientAssertionToken("client-assertion");
                    })
                    .tokenCache(new NoopCache())
                    .build();

            RawResponse response = client.get("/open-apis/e2e", null, AccessTokenType.Tenant);

            assertEquals(200, response.getStatusCode());
            assertEquals("127.0.0.1:" + server.port(), audRef.get());
            JsonObject oauthBody = server.jsonBody("/oauth/v3/token");
            assertEquals(Constants.GRANT_TYPE_JWT_BEARER, oauthBody.get("grant_type").getAsString());
            assertEquals("client-assertion", oauthBody.get("client_assertion").getAsString());
            assertEquals("Bearer tenant-token", server.headers("/open-apis/e2e").getFirst("Authorization"));
        } finally {
            server.stop();
        }
    }

    @Test
    public void accessTokenAuthorizationCodeAndRefreshUseLocalOAuthServer() throws Exception {
        LocalServer server = LocalServer.start();
        try {
            Client client = Client.newBuilder("cli_a", "")
                    .openBaseUrl(server.domain())
                    .oauthBaseUrl(server.domain())
                    .clientAssertionProvider(aud -> new ClientAssertionToken("client-assertion"))
                    .tokenCache(new NoopCache())
                    .build();

            client.accessToken().retrieveByAuthorizationCode(
                    AuthorizationCodeTokenRequest.newBuilder()
                            .code("auth-code")
                            .redirectUri("https://example.com/callback")
                            .codeVerifier("verifier")
                            .scope("contact:user.base:readonly")
                            .build());
            client.accessToken().refresh(
                    RefreshTokenRequest.newBuilder()
                            .refreshToken("refresh-token")
                            .scope("contact:user.base:readonly")
                            .build());

            JsonObject authCodeBody = JsonParser.parseString(server.bodies("/oauth/v3/token").get(0)).getAsJsonObject();
            JsonObject refreshBody = JsonParser.parseString(server.bodies("/oauth/v3/token").get(1)).getAsJsonObject();
            assertEquals(Constants.GRANT_TYPE_AUTHORIZATION_CODE, authCodeBody.get("grant_type").getAsString());
            assertEquals("auth-code", authCodeBody.get("code").getAsString());
            assertEquals(Constants.GRANT_TYPE_REFRESH_TOKEN, refreshBody.get("grant_type").getAsString());
            assertEquals("refresh-token", refreshBody.get("refresh_token").getAsString());
        } finally {
            server.stop();
        }
    }

    @Test
    public void websocketBootstrapUsesLocalProviderFlow() throws Exception {
        LocalServer server = LocalServer.start();
        try {
            com.lark.oapi.ws.Client client = new com.lark.oapi.ws.Client.Builder("cli_a", "")
                    .domain(server.domain())
                    .clientAssertionProvider(aud -> new ClientAssertionToken("client-assertion"))
                    .build();

            assertEquals("wss://example.test/callback?device_id=device&service_id=42", invokeGetConnUrl(client));
            JsonObject body = server.jsonBody(Constant.GEN_ENDPOINT_URI);
            assertEquals("cli_a", body.get("AppID").getAsString());
            assertEquals("", body.get("AppSecret").getAsString());
            assertEquals("client-assertion", body.get("ClientAssertion").getAsString());
        } finally {
            server.stop();
        }
    }

    @Test
    public void targetInfoProxyWorksForTenantTokenAndWebsocketBootstrap() throws Exception {
        LocalServer proxy = LocalServer.start();
        try {
            Client client = Client.newBuilder("cli_a", "")
                    .openBaseUrl(proxy.domain())
                    .oauthBaseUrl("https://accounts.feishu.cn")
                    .clientAssertionProvider(aud -> new ClientAssertionToken(
                            "client-assertion",
                            new TargetInfo(proxy.domain(), "/proxy")))
                    .tokenCache(new NoopCache())
                    .build();

            client.get("/open-apis/e2e", null, AccessTokenType.Tenant);

            assertEquals("accounts.feishu.cn", proxy.headers("/proxy/oauth/v3/token").getFirst(Constants.HEADER_X_TARGET_SERVICE));
            assertEquals("Bearer tenant-token", proxy.headers("/open-apis/e2e").getFirst("Authorization"));

            com.lark.oapi.ws.Client wsClient = new com.lark.oapi.ws.Client.Builder("cli_a", "")
                    .domain("https://open.feishu.cn")
                    .clientAssertionProvider(aud -> new ClientAssertionToken(
                            "client-assertion",
                            new TargetInfo(proxy.domain(), "/proxy")))
                    .build();

            invokeGetConnUrl(wsClient);

            assertEquals("open.feishu.cn", proxy.headers("/proxy" + Constant.GEN_ENDPOINT_URI).getFirst(Constants.HEADER_X_TARGET_SERVICE));
        } finally {
            proxy.stop();
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

    private static class LocalServer {
        private final HttpServer server;
        private final java.util.Map<String, List<String>> bodies = new java.util.concurrent.ConcurrentHashMap<>();
        private final java.util.Map<String, Headers> headers = new java.util.concurrent.ConcurrentHashMap<>();

        private LocalServer(HttpServer server) {
            this.server = server;
        }

        private static LocalServer start() throws IOException {
            HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
            LocalServer localServer = new LocalServer(server);
            localServer.createJsonContext("/oauth/v3/token", "{\"access_token\":\"tenant-token\",\"expires_in\":7200,\"token_type\":\"Bearer\",\"refresh_token\":\"new-refresh-token\",\"refresh_token_expires_in\":604800,\"scope\":\"contact:user.base:readonly\"}");
            localServer.createJsonContext("/proxy/oauth/v3/token", "{\"access_token\":\"tenant-token\",\"expires_in\":7200}");
            localServer.createJsonContext("/open-apis/e2e", "{\"code\":0,\"msg\":\"ok\"}");
            localServer.createJsonContext(Constant.GEN_ENDPOINT_URI, "{\"code\":0,\"data\":{\"URL\":\"wss://example.test/callback?device_id=device&service_id=42\"}}");
            localServer.createJsonContext("/proxy" + Constant.GEN_ENDPOINT_URI, "{\"code\":0,\"data\":{\"URL\":\"wss://example.test/callback?device_id=device&service_id=42\"}}");
            server.start();
            return localServer;
        }

        private void createJsonContext(String path, String responseBody) {
            server.createContext(path, exchange -> {
                headers.put(path, exchange.getRequestHeaders());
                bodies.computeIfAbsent(path, ignored -> new ArrayList<>()).add(readBody(exchange.getRequestBody()));
                byte[] response = responseBody.getBytes(StandardCharsets.UTF_8);
                exchange.sendResponseHeaders(200, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            });
        }

        private String readBody(java.io.InputStream inputStream) throws IOException {
            ByteArrayOutputStream requestBuffer = new ByteArrayOutputStream();
            byte[] requestChunk = new byte[1024];
            int read;
            while ((read = inputStream.read(requestChunk)) != -1) {
                requestBuffer.write(requestChunk, 0, read);
            }
            return new String(requestBuffer.toByteArray(), StandardCharsets.UTF_8);
        }

        private int port() {
            return server.getAddress().getPort();
        }

        private String domain() {
            return "http://127.0.0.1:" + port();
        }

        private JsonObject jsonBody(String path) {
            return JsonParser.parseString(bodies(path).get(bodies(path).size() - 1)).getAsJsonObject();
        }

        private List<String> bodies(String path) {
            return bodies.get(path);
        }

        private Headers headers(String path) {
            return headers.get(path);
        }

        private void stop() {
            server.stop(0);
        }
    }

    private static class NoopCache implements ICache {
        @Override
        public String get(String key) {
            return "";
        }

        @Override
        public void set(String key, String value, int expire, TimeUnit timeUnit) {
        }
    }
}
