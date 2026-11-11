package com.lark.oapi.core.token;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lark.oapi.core.Config;
import com.lark.oapi.core.Constants;
import com.lark.oapi.core.Transport;
import com.lark.oapi.core.accesstoken.AccessToken;
import com.lark.oapi.core.accesstoken.AuthorizationCodeTokenRequest;
import com.lark.oapi.core.accesstoken.RefreshTokenRequest;
import com.lark.oapi.core.auth.ClientAssertionToken;
import com.lark.oapi.core.auth.TargetInfo;
import com.lark.oapi.core.cache.ICache;
import com.lark.oapi.core.enums.AppType;
import com.lark.oapi.core.exception.ClientAssertionException;
import com.lark.oapi.core.httpclient.IHttpTransport;
import com.lark.oapi.core.request.RawRequest;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.core.utils.Sets;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class TestIsvClientAssertion {
    private static final String SUCCESS = "{\"access_token\":\"test-token\",\"expires_in\":7200,\"token_type\":\"Bearer\"}";

    @Test
    public void exchangesOncePerTenantWithoutAppTickets() throws Exception {
        RecordingTransport transport = new RecordingTransport();
        Config config = config(transport);
        RecordingCache cache = new RecordingCache();
        TokenManager manager = new TokenManager(cache);
        AtomicInteger providerCalls = new AtomicInteger();
        config.setClientAssertionProvider(aud -> {
            assertEquals("accounts.feishu.cn", aud);
            providerCalls.incrementAndGet();
            return new ClientAssertionToken("test-assertion");
        });
        for (String tenant : new String[]{"tenant-A", "tenant-B", "tenant-A", "tenant-B"}) {
            assertEquals("test-token", manager.getTenantAccessToken(config, tenant));
        }
        assertEquals(2, transport.calls);
        assertEquals(2, providerCalls.get());
        assertEquals(2, cache.values.size());
        assertEquals(7020, cache.expire);
        JsonObject body = transport.body();
        assertEquals("client_credentials", body.get("grant_type").getAsString());
        assertEquals("tenant-B", body.get("tenant_key").getAsString());
        assertEquals("cli_isv", body.get("client_id").getAsString());
        assertEquals("test-assertion", body.get("client_assertion").getAsString());
        assertFalse(body.has("app_ticket"));
        assertFalse(body.has("client_secret"));
        assertEquals("https://accounts.feishu.cn/oauth/v3/token", transport.request.getReqUrl());
    }

    @Test
    public void missingTenantFailsBeforeProvider() throws Exception {
        Config config = config(new RecordingTransport());
        config.setClientAssertionProvider(aud -> { throw new AssertionError("provider must not be called"); });
        for (String tenant : new String[]{null, "", " "}) {
            try {
                new TokenManager(new RecordingCache()).getTenantAccessToken(config, tenant);
                fail("expected missing tenant error");
            } catch (IllegalArgumentException expected) {
                assertTrue(expected.getMessage().contains("tenant"));
            }
        }
    }

    @Test
    public void proxyKeepsAudienceAndCacheSeparatesEndpoints() throws Exception {
        RecordingTransport transport = new RecordingTransport();
        Config config = config(transport);
        config.setClientAssertionProvider(aud -> new ClientAssertionToken("test-assertion", new TargetInfo("proxy.example.com", "/proxy")));
        TokenManager manager = new TokenManager(new RecordingCache());
        for (String prefix : new String[]{"/region-A", "/region-B", "/region-A"}) {
            config.setOAuthBaseUrl("https://accounts.feishu.cn" + prefix);
            manager.getTenantAccessToken(config, "tenant-A");
        }
        assertEquals(2, transport.calls);
        assertEquals("https://proxy.example.com/proxy/oauth/v3/token", transport.request.getReqUrl());
        assertEquals("accounts.feishu.cn", transport.request.getHeaders().get(Constants.HEADER_X_TARGET_SERVICE).get(0));
    }

    @Test
    public void failedResponsesNeverEnterCache() throws Exception {
        for (String[] failure : new String[][]{
                {"{\"code\":400,\"error\":\"invalid_client\",\"error_description\":\"assertion rejected\"}", "ISV tenant token exchange failed (HTTP 200), error: invalid_client, error_description: assertion rejected"},
                {"{\"code\":400,\"error_description\":\"assertion rejected\"}", "ISV tenant token exchange failed (HTTP 200), error_description: assertion rejected"},
                {SUCCESS.replace("}", ",\"code\":400}"), "ISV tenant token exchange failed (HTTP 200)"},
                {SUCCESS.replace("}", ",\"error\":\"invalid_client\"}"), "ISV tenant token exchange failed (HTTP 200), error: invalid_client"},
                {SUCCESS.replace("test-token", ""), "access_token is empty"},
                {SUCCESS.replace("7200", "0"), "expires_in must be positive"},
                {SUCCESS.replace("Bearer", "Other"), "token_type must be Bearer"}}) {
            RecordingTransport transport = new RecordingTransport();
            transport.response = failure[0];
            RecordingCache cache = new RecordingCache();
            try {
                new TokenManager(cache).getTenantAccessToken(config(transport), "tenant-A");
                fail("expected invalid response error");
            } catch (ClientAssertionException expected) {
                assertTrue(expected.getMessage(), expected.getMessage().contains(failure[1]));
                assertTrue(cache.values.isEmpty());
            }
        }
        RecordingTransport transport = new RecordingTransport();
        transport.status = 400;
        transport.response = "{\"code\":20140,\"error\":\"invalid_client\",\"error_description\":\"assertion rejected\"}";
        try {
            new TokenManager(new RecordingCache()).getTenantAccessToken(config(transport), "tenant-A");
            fail("expected HTTP error");
        } catch (ClientAssertionException expected) {
            assertEquals(20140, expected.getCode());
            assertEquals("ISV tenant token exchange failed (HTTP 400), error: invalid_client, error_description: assertion rejected", expected.getMessage());
        }
    }

    @Test
    public void userTokenFlowsReuseExistingRequests() throws Exception {
        RecordingTransport transport = new RecordingTransport();
        Config config = config(transport);
        AccessToken accessToken = new AccessToken(config);
        accessToken.retrieveByAuthorizationCode(AuthorizationCodeTokenRequest.newBuilder().code("test-code").build());
        assertEquals("authorization_code", transport.body().get("grant_type").getAsString());
        assertFalse(transport.body().has("tenant_key"));
        accessToken.refresh(RefreshTokenRequest.newBuilder().refreshToken("test-refresh").build());
        assertEquals("refresh_token", transport.body().get("grant_type").getAsString());
        assertFalse(transport.body().has("tenant_key"));
        config.setClientAssertionProvider(aud -> { throw new AssertionError("explicit UAT must skip provider"); });
        Transport.send(config, RequestOptions.newBuilder().userAccessToken("test-uat").build(),
                "GET", "/resource", Sets.newHashSet(AccessTokenType.User, AccessTokenType.Tenant), null);
        assertEquals("Bearer test-uat", transport.request.getHeaders().get("Authorization").get(0));
    }

    @Test
    public void cacheWriteFailureStillPropagates() throws Exception {
        RecordingCache cache = new RecordingCache();
        IllegalStateException failure = new IllegalStateException("cache unavailable");
        cache.failure = failure;
        try {
            new TokenManager(cache).getTenantAccessToken(config(new RecordingTransport()), "tenant-A");
            fail("expected cache exception");
        } catch (IllegalStateException expected) {
            assertSame(failure, expected);
        }
    }

    @Test
    public void shortLivedTokensStillWriteCacheWithZeroTtl() throws Exception {
        RecordingTransport transport = new RecordingTransport();
        transport.response = SUCCESS.replace("7200", "60");
        RecordingCache cache = new RecordingCache();
        assertEquals("test-token", new TokenManager(cache).getTenantAccessToken(config(transport), "tenant-A"));
        assertEquals(1, cache.values.size());
        assertEquals(0, cache.expire);
    }

    private Config config(RecordingTransport transport) {
        Config config = new Config();
        config.setAppId("cli_isv");
        config.setAppSecret("unused-secret");
        config.setAppType(AppType.MARKETPLACE);
        config.setBaseUrl("https://open.feishu.cn");
        config.setHttpTransport(transport);
        config.setClientAssertionProvider(aud -> new ClientAssertionToken("test-assertion"));
        return config;
    }

    private static class RecordingTransport implements IHttpTransport {
        private RawRequest request;
        private int calls;
        private int status = 200;
        private String response = SUCCESS;

        public RawResponse execute(RawRequest request) {
            this.request = request;
            calls++;
            RawResponse raw = new RawResponse();
            raw.setStatusCode(status);
            raw.setBody(response.getBytes(StandardCharsets.UTF_8));
            return raw;
        }

        private JsonObject body() {
            return JsonParser.parseString(Jsons.DEFAULT.toJson(request.getBody())).getAsJsonObject();
        }
    }

    private static class RecordingCache implements ICache {
        private final Map<String, String> values = new HashMap<>();
        private int expire;
        private RuntimeException failure;

        public String get(String key) { return values.get(key); }

        public void set(String key, String value, int expire, TimeUnit unit) {
            if (failure != null) { throw failure; }
            values.put(key, value);
            this.expire = expire;
        }
    }
}
