package com.lark.oapi.e2e;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lark.oapi.Client;
import com.lark.oapi.core.accesstoken.AccessTokenResp;
import com.lark.oapi.core.accesstoken.AccessTokenRespData;
import com.lark.oapi.core.accesstoken.AuthorizationCodeTokenRequest;
import com.lark.oapi.core.accesstoken.RefreshTokenRequest;
import com.lark.oapi.core.httpclient.OkHttpTransport;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.okhttp.OkHttpClient;
import com.lark.oapi.okhttp.Request;
import com.lark.oapi.okhttp.Response;
import com.lark.oapi.okhttp.WebSocket;
import com.lark.oapi.okhttp.WebSocketListener;
import org.junit.Assume;
import org.junit.Test;

import java.awt.Desktop;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestClientAssertionLiveE2E {

    @Test
    public void liveTenantTokenTatAndWebSocketMatrix() throws Exception {
        ClientAssertionLiveHarness.Env env = enabledEnv();
        ClientAssertionLiveHarness.DeployDomains domains = env.domains();
        int executed = 0;

        if (env.modeEnabled("app_secret")) {
            executed++;
            Client appSecretClient = buildAppSecretClient(env, domains);
            String secretMessageId = sendTenantMessage(appSecretClient, env,
                    ClientAssertionLiveHarness.caseId("SECRET-TAT"));
            printPass("SECRET-02", "tenant message_id=" + secretMessageId);
        }

        if (env.modeEnabled("zti")) {
            executed++;
            ClientAssertionLiveHarness.ModeEnvProvider ztiProvider =
                    new ClientAssertionLiveHarness.ModeEnvProvider("zti", env);
            Client ztiClient = buildClientAssertionClient(env, domains, ztiProvider, "");
            String ztiMessageId = sendTenantMessage(ztiClient, env,
                    ClientAssertionLiveHarness.caseId("ZTI-TAT"));
            assertProviderReceivedAud(ztiProvider, ClientAssertionLiveHarness.extractHost(domains.getOAuthBaseUrl()));
            printPass("ZTI-02", "tenant message_id=" + ztiMessageId);
        }

        if (env.modeEnabled("gdpr")) {
            executed++;
            ClientAssertionLiveHarness.ModeEnvProvider gdprProvider =
                    new ClientAssertionLiveHarness.ModeEnvProvider("gdpr", env);
            Client gdprClient = buildClientAssertionClient(env, domains, gdprProvider, "");
            String gdprMessageId = sendTenantMessage(gdprClient, env,
                    ClientAssertionLiveHarness.caseId("GDPR-TAT"));
            assertProviderReceivedAud(gdprProvider, ClientAssertionLiveHarness.extractHost(domains.getOAuthBaseUrl()));
            printPass("GDPR-TAT", "tenant message_id=" + gdprMessageId);
        }

        if (env.modeEnabled("zti")) {
            executed++;
            ClientAssertionLiveHarness.ModeEnvProvider precedenceProvider =
                    new ClientAssertionLiveHarness.ModeEnvProvider("zti", env);
            Client precedenceClient = buildClientAssertionClient(env, domains, precedenceProvider, env.require("LARK_APP_SECRET"));
            String precedenceMessageId = sendTenantMessage(precedenceClient, env,
                    ClientAssertionLiveHarness.caseId("ENV-PRECEDENCE"));
            assertProviderReceivedAud(precedenceProvider, ClientAssertionLiveHarness.extractHost(domains.getOAuthBaseUrl()));
            printPass("ENV-05", "provider precedence message_id=" + precedenceMessageId);
        }

        if (env.modeEnabled("app_secret")) {
            executed++;
            runWebSocketCase("SECRET-04", env, domains, env.require("LARK_APP_SECRET"), null);
        }

        if (env.modeEnabled("zti")) {
            executed++;
            ClientAssertionLiveHarness.ModeEnvProvider wsZtiProvider =
                    new ClientAssertionLiveHarness.ModeEnvProvider("zti", env);
            runWebSocketCase("WS-01/WS-03-ZTI", env, domains, "", wsZtiProvider);
            assertProviderReceivedAud(wsZtiProvider, ClientAssertionLiveHarness.extractHost(domains.getOpenApiDomain()));
        }

        if (env.modeEnabled("gdpr")) {
            executed++;
            ClientAssertionLiveHarness.ModeEnvProvider wsGdprProvider =
                    new ClientAssertionLiveHarness.ModeEnvProvider("gdpr", env);
            runWebSocketCase("WS-02/WS-03-GDPR", env, domains, "", wsGdprProvider);
            assertProviderReceivedAud(wsGdprProvider, ClientAssertionLiveHarness.extractHost(domains.getOpenApiDomain()));
        }
        Assume.assumeTrue("no live E2E mode selected by LARK_E2E_MODES", executed > 0);
    }

    @Test
    public void liveOAuthAuthorizationCodeRefreshAndBasicBatchMatrix() throws Exception {
        ClientAssertionLiveHarness.Env env = enabledEnv();
        ClientAssertionLiveHarness.DeployDomains domains = env.domains();
        int executed = 0;

        if (env.modeEnabled("app_secret")) {
            executed++;
            runOAuthCase("OAUTH-APPSECRET", buildAppSecretClient(env, domains), env);
        }

        if (env.modeEnabled("zti")) {
            executed++;
            ClientAssertionLiveHarness.ModeEnvProvider ztiProvider =
                    new ClientAssertionLiveHarness.ModeEnvProvider("zti", env);
            runOAuthCase("ZTI-03/04/05/06", buildClientAssertionClient(env, domains, ztiProvider, ""), env);
            assertProviderReceivedAud(ztiProvider, ClientAssertionLiveHarness.extractHost(domains.getOAuthBaseUrl()));
        }

        if (env.modeEnabled("gdpr")) {
            executed++;
            ClientAssertionLiveHarness.ModeEnvProvider gdprProvider =
                    new ClientAssertionLiveHarness.ModeEnvProvider("gdpr", env);
            runOAuthCase("GDPR-03/04/05", buildClientAssertionClient(env, domains, gdprProvider, ""), env);
            assertProviderReceivedAud(gdprProvider, ClientAssertionLiveHarness.extractHost(domains.getOAuthBaseUrl()));
        }
        Assume.assumeTrue("no live E2E mode selected by LARK_E2E_MODES", executed > 0);
    }

    private ClientAssertionLiveHarness.Env enabledEnv() throws Exception {
        ClientAssertionLiveHarness.Env env = ClientAssertionLiveHarness.loadEnv();
        Assume.assumeTrue("set LARK_CLIENT_ASSERTION_E2E=1 to run live ClientAssertion E2E", env.enabled());
        return env;
    }

    private Client buildAppSecretClient(ClientAssertionLiveHarness.Env env,
                                        ClientAssertionLiveHarness.DeployDomains domains) {
        return Client.newBuilder(env.require("LARK_APP_ID"), env.require("LARK_APP_SECRET"))
                .openBaseUrl(domains.getOpenApiDomain())
                .oauthBaseUrl(domains.getOAuthBaseUrl())
                .tokenCache(new ClientAssertionLiveHarness.NoopCache())
                .httpTransport(new OkHttpTransport(ClientAssertionLiveHarness.okHttpClient(env, 10, TimeUnit.SECONDS)))
                .requestTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    private Client buildClientAssertionClient(ClientAssertionLiveHarness.Env env,
                                             ClientAssertionLiveHarness.DeployDomains domains,
                                             ClientAssertionLiveHarness.ModeEnvProvider provider,
                                             String appSecret) {
        if ("gdpr".equals(provider.getMode())) {
            String deployEnv = env.get("LARK_DEPLOY_ENV");
            String normalized = deployEnv == null ? "online" : deployEnv.toLowerCase();
            if (!"online".equals(normalized) && !"prod".equals(normalized)
                    && !"production".equals(normalized) && !"cn".equals(normalized)) {
                throw new IllegalStateException("GDPR proxy E2E must use LARK_DEPLOY_ENV=online");
            }
        }
        return Client.newBuilder(env.require("LARK_APP_ID"), appSecret)
                .openBaseUrl(domains.getOpenApiDomain())
                .oauthBaseUrl(domains.getOAuthBaseUrl())
                .clientAssertionProvider(provider)
                .tokenCache(new ClientAssertionLiveHarness.NoopCache())
                .httpTransport(new OkHttpTransport(ClientAssertionLiveHarness.okHttpClient(env, 10, TimeUnit.SECONDS)))
                .requestTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    private String sendTenantMessage(Client client,
                                     ClientAssertionLiveHarness.Env env,
                                     String caseId) throws Exception {
        Map<String, Object> content = new HashMap<>();
        content.put("text", "ClientAssertion E2E TAT message: " + caseId);

        Map<String, Object> body = new HashMap<>();
        body.put("receive_id", env.require("LARK_OPEN_ID"));
        body.put("msg_type", "text");
        body.put("content", Jsons.DEFAULT.toJson(content));
        body.put("uuid", UUID.randomUUID().toString());

        RawResponse response = client.post(
                "/open-apis/im/v1/messages?receive_id_type=open_id",
                body,
                AccessTokenType.Tenant);
        JsonObject json = assertSuccessResponse(response, "send tenant message " + caseId);
        JsonObject data = json.getAsJsonObject("data");
        assertNotNull("send message response data", data);
        String messageId = getString(data, "message_id");
        assertTrue("message_id must not be empty", Strings.isNotEmpty(messageId));
        return messageId;
    }

    private void runOAuthCase(String caseId, Client client, ClientAssertionLiveHarness.Env env) throws Exception {
        AccessTokenResp token = authorizeAndExchangeCode(client, env, caseId);
        AccessTokenRespData tokenData = token.getData();
        assertTrue("authorization code exchange did not return access_token",
                Strings.isNotEmpty(tokenData.getAccessToken()));
        callBasicBatchWithUat(client, env, tokenData.getAccessToken(), caseId + "-initial");

        assertTrue("authorization code exchange did not return refresh_token; verify offline_access is enabled",
                Strings.isNotEmpty(tokenData.getRefreshToken()));
        AccessTokenResp refreshed = client.accessToken().refresh(
                RefreshTokenRequest.newBuilder()
                        .refreshToken(tokenData.getRefreshToken())
                        .scope(env.get("LARK_OAUTH_SCOPE"))
                        .build());
        assertTrue("refresh token exchange did not return access_token",
                Strings.isNotEmpty(refreshed.getData().getAccessToken()));
        callBasicBatchWithUat(client, env, refreshed.getData().getAccessToken(), caseId + "-refreshed");
        printPass(caseId, "oauth status=" + refreshed.getStatusCode());
    }

    private AccessTokenResp authorizeAndExchangeCode(Client client,
                                                    ClientAssertionLiveHarness.Env env,
                                                    String caseId) throws Exception {
        String redirectUri = env.require("LARK_OAUTH_REDIRECT_URI");
        String scope = env.require("LARK_OAUTH_SCOPE");
        String state = ClientAssertionLiveHarness.randomState();
        String codeVerifier = "";
        String codeChallenge = "";
        if (env.bool("LARK_OAUTH_PKCE_REQUIRED", false)) {
            codeVerifier = ClientAssertionLiveHarness.randomCodeVerifier();
            codeChallenge = ClientAssertionLiveHarness.codeChallenge(codeVerifier);
        }

        String authorizeUrl = ClientAssertionLiveHarness.buildAuthorizeUrl(
                env.authorizeBaseUrl(),
                env.require("LARK_APP_ID"),
                redirectUri,
                scope,
                state,
                codeChallenge);

        Map<String, String> params;
        try (ClientAssertionLiveHarness.OAuthCallbackServer callbackServer =
                     ClientAssertionLiveHarness.startCallbackServer(redirectUri, state)) {
            System.out.println("\n[E2E] Open this URL to authorize " + caseId
                    + " (OAuth code/token will not be logged):\n" + authorizeUrl);
            openBrowser(authorizeUrl);
            params = callbackServer.await(env.intValue("LARK_OAUTH_TIMEOUT_SECONDS", 180));
        }

        if (params == null) {
            fail("OAuth callback timed out for " + caseId);
        }
        if (params.containsKey("error")) {
            fail("OAuth callback failed for " + caseId + ": " + params.get("error"));
        }
        return client.accessToken().retrieveByAuthorizationCode(
                AuthorizationCodeTokenRequest.newBuilder()
                        .code(params.get("code"))
                        .redirectUri(redirectUri)
                        .codeVerifier(codeVerifier)
                        .scope(scope)
                        .build());
    }

    private void callBasicBatchWithUat(Client client,
                                       ClientAssertionLiveHarness.Env env,
                                       String userAccessToken,
                                       String caseId) throws Exception {
        Map<String, Object> body = new HashMap<>();
        body.put("user_ids", Collections.singletonList(env.require("LARK_OPEN_ID")));
        RequestOptions options = RequestOptions.newBuilder()
                .userAccessToken(userAccessToken)
                .build();
        RawResponse response = client.post(
                "/open-apis/contact/v3/users/basic_batch?user_id_type=open_id",
                body,
                AccessTokenType.User,
                options);
        JsonObject json = assertSuccessResponse(response, "basic_batch " + caseId);
        JsonObject data = json.getAsJsonObject("data");
        assertNotNull("basic_batch data", data);
        JsonArray users = data.getAsJsonArray("users");
        assertTrue("basic_batch users must not be empty", users != null && users.size() > 0);
    }

    private void runWebSocketCase(String caseId,
                                  ClientAssertionLiveHarness.Env env,
                                  ClientAssertionLiveHarness.DeployDomains domains,
                                  String appSecret,
                                  ClientAssertionLiveHarness.ModeEnvProvider provider) throws Exception {
        com.lark.oapi.ws.Client.Builder builder =
                new com.lark.oapi.ws.Client.Builder(env.require("LARK_APP_ID"), appSecret)
                        .domain(domains.getOpenApiDomain())
                        .httpClient(ClientAssertionLiveHarness.okHttpClient(env, 10, TimeUnit.SECONDS))
                        .autoReconnect(false);
        if (provider != null) {
            builder.clientAssertionProvider(provider);
        }
        com.lark.oapi.ws.Client client = builder.build();

        String connUrl = invokeGetConnUrl(client);
        assertTrue("websocket endpoint should return ws/wss url",
                connUrl.startsWith("ws://") || connUrl.startsWith("wss://"));
        if (env.bool("LARK_WS_CONNECT_E2E", false)) {
            connectWebSocketOnce(env, connUrl, env.intValue("LARK_WS_LISTEN_SECONDS", 30));
        }
        printPass(caseId, "ws_endpoint_host=" + URI.create(connUrl.replace("wss://", "https://").replace("ws://", "http://")).getHost());
    }

    private String invokeGetConnUrl(com.lark.oapi.ws.Client client) throws Exception {
        Method method = com.lark.oapi.ws.Client.class.getDeclaredMethod("getConnUrl");
        method.setAccessible(true);
        return (String) method.invoke(client);
    }

    private void connectWebSocketOnce(ClientAssertionLiveHarness.Env env,
                                      String connUrl,
                                      int listenSeconds) throws Exception {
        CountDownLatch opened = new CountDownLatch(1);
        AtomicReference<Throwable> failure = new AtomicReference<>();
        AtomicReference<WebSocket> socketRef = new AtomicReference<>();
        OkHttpClient httpClient = ClientAssertionLiveHarness.okHttpClient(env, 15, TimeUnit.SECONDS);
        try {
            Request request = new Request.Builder().url(connUrl).build();
            WebSocket socket = httpClient.newWebSocket(request, new WebSocketListener() {
                @Override
                public void onOpen(WebSocket webSocket, Response response) {
                    socketRef.set(webSocket);
                    opened.countDown();
                }

                @Override
                public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                    failure.set(t);
                    opened.countDown();
                }
            });
            socketRef.compareAndSet(null, socket);
            if (!opened.await(15, TimeUnit.SECONDS)) {
                fail("websocket handshake timed out");
            }
            if (failure.get() != null) {
                throw new AssertionError("websocket handshake failed: " + failure.get().getMessage(), failure.get());
            }
            Thread.sleep(Math.max(1, listenSeconds) * 1000L);
            WebSocket connected = socketRef.get();
            if (connected != null) {
                connected.close(1000, "client assertion live e2e done");
            }
        } finally {
            httpClient.dispatcher().executorService().shutdown();
            httpClient.connectionPool().evictAll();
        }
    }

    private JsonObject assertSuccessResponse(RawResponse response, String action) {
        String body = new String(response.getBody(), StandardCharsets.UTF_8);
        JsonObject json = JsonParser.parseString(body).getAsJsonObject();
        if (response.getStatusCode() < 200 || response.getStatusCode() >= 300) {
            fail(action + " failed, http_status=" + response.getStatusCode()
                    + ", request_id=" + response.getRequestID());
        }
        int code = json.has("code") && !json.get("code").isJsonNull() ? json.get("code").getAsInt() : 0;
        if (code != 0) {
            fail(action + " failed, code=" + code
                    + ", msg=" + getString(json, "msg")
                    + ", request_id=" + response.getRequestID());
        }
        return json;
    }

    private void assertProviderReceivedAud(ClientAssertionLiveHarness.ModeEnvProvider provider, String expectedAud) {
        assertTrue("provider did not receive aud " + expectedAud + ", actual=" + provider.getAuds(),
                provider.getAuds().contains(expectedAud));
    }

    private void openBrowser(String url) throws Exception {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(URI.create(url));
            return;
        }
        new ProcessBuilder("open", url).start();
    }

    private String getString(JsonObject json, String key) {
        if (json == null || !json.has(key) || json.get(key).isJsonNull()) {
            return "";
        }
        return json.get(key).getAsString();
    }

    private void printPass(String caseId, String detail) {
        System.out.println("[E2E] " + caseId + " PASS " + detail);
    }
}
