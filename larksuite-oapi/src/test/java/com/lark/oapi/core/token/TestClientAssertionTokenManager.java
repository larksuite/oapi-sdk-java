package com.lark.oapi.core.token;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lark.oapi.core.Config;
import com.lark.oapi.core.Constants;
import com.lark.oapi.core.auth.ClientAssertionToken;
import com.lark.oapi.core.auth.TargetInfo;
import com.lark.oapi.core.cache.ICache;
import com.lark.oapi.core.exception.ClientAssertionException;
import com.lark.oapi.core.httpclient.IHttpTransport;
import com.lark.oapi.core.request.RawRequest;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.utils.Jsons;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TestClientAssertionTokenManager {

    @Test
    public void tenantTokenUsesOAuthJwtBearerRequestAndCachesToken() throws Exception {
        CapturingCache cache = new CapturingCache();
        CapturingTransport transport = new CapturingTransport("{\"access_token\":\"tenant-token\",\"expires_in\":7200}");
        AtomicReference<String> audRef = new AtomicReference<>();
        Config config = config(transport);
        config.setClientAssertionProvider(aud -> {
            audRef.set(aud);
            return new ClientAssertionToken("client-assertion");
        });

        String token = new TokenManager(cache).getTenantAccessToken(config, "");

        assertEquals("tenant-token", token);
        assertEquals("accounts.feishu.cn", audRef.get());
        assertEquals("https://accounts.feishu.cn/oauth/v3/token", transport.request.getReqUrl());
        JsonObject body = JsonParser.parseString(Jsons.DEFAULT.toJson(transport.request.getBody())).getAsJsonObject();
        assertEquals(Constants.GRANT_TYPE_JWT_BEARER, body.get("grant_type").getAsString());
        assertEquals(Constants.CLIENT_ASSERTION_TYPE_JWT_BEARER, body.get("client_assertion_type").getAsString());
        assertEquals("client-assertion", body.get("client_assertion").getAsString());
        assertEquals("cli_a", body.get("client_id").getAsString());
        assertEquals("tenant_token:client_assertion:cli_a::accounts.feishu.cn", cache.key);
        assertEquals("tenant-token", cache.value);
        assertEquals(7020, cache.expire);
    }

    @Test
    public void targetInfoUsesProxyUrlAndTargetServiceHeader() throws Exception {
        CapturingTransport transport = new CapturingTransport("{\"access_token\":\"tenant-token\",\"expires_in\":7200}");
        Config config = config(transport);
        config.setClientAssertionProvider(aud -> new ClientAssertionToken(
                "client-assertion",
                new TargetInfo("proxy.example.com", "/proxy")));

        new TokenManager(new CapturingCache()).getTenantAccessToken(config, "");

        assertEquals("https://proxy.example.com/proxy/oauth/v3/token", transport.request.getReqUrl());
        assertEquals("accounts.feishu.cn", transport.request.getHeaders().get(Constants.HEADER_X_TARGET_SERVICE).get(0));
    }

    @Test
    public void appSecretTenantTokenUsesModeSpecificCacheKey() throws Exception {
        CapturingCache cache = new CapturingCache();
        CapturingTransport transport = new CapturingTransport(
                "{\"code\":0,\"tenant_access_token\":\"app-secret-token\",\"expire\":7200}");
        Config config = config(transport);
        config.setAppSecret("app-secret");

        String token = new TokenManager(cache).getTenantAccessToken(config, "tenant-key");

        assertEquals("app-secret-token", token);
        assertEquals("tenant_token:app_secret:cli_a:tenant-key", cache.getKey);
        assertEquals("tenant_token:app_secret:cli_a:tenant-key", cache.key);
        assertEquals(7020, cache.expire);
    }

    @Test
    public void clientAssertionCacheHitUsesModeSpecificKeyBeforeProviderAndAvoidsTransport() throws Exception {
        CapturingCache cache = new CapturingCache();
        cache.values.put("tenant_token:client_assertion:cli_a:tenant-key:accounts.feishu.cn", "tenant-token");
        CapturingTransport transport = new CapturingTransport("{}");
        AtomicInteger calls = new AtomicInteger();
        Config config = config(transport);
        config.setClientAssertionProvider(aud -> {
            calls.incrementAndGet();
            return new ClientAssertionToken("client-assertion");
        });

        String token = new TokenManager(cache).getTenantAccessToken(config, "tenant-key");

        assertEquals("tenant-token", token);
        assertEquals("tenant_token:client_assertion:cli_a:tenant-key:accounts.feishu.cn", cache.getKey);
        assertEquals(0, calls.get());
        assertNull(transport.request);
    }

    @Test
    public void legacyAppSecretCacheDoesNotBypassClientAssertionProvider() throws Exception {
        CapturingCache cache = new CapturingCache();
        cache.values.put("tenant_token:app_secret:cli_a:tenant-key", "legacy-appsecret-token");
        CapturingTransport transport = new CapturingTransport("{\"access_token\":\"client-assertion-token\",\"expires_in\":7200}");
        AtomicInteger calls = new AtomicInteger();
        Config config = config(transport);
        config.setClientAssertionProvider(aud -> {
            calls.incrementAndGet();
            return new ClientAssertionToken("client-assertion");
        });

        String token = new TokenManager(cache).getTenantAccessToken(config, "tenant-key");

        assertEquals("client-assertion-token", token);
        assertEquals(1, calls.get());
        assertEquals("tenant_token:client_assertion:cli_a:tenant-key:accounts.feishu.cn", cache.getKey);
        assertEquals("tenant_token:client_assertion:cli_a:tenant-key:accounts.feishu.cn", cache.key);
    }

    @Test
    public void targetInfoDoesNotChangeClientAssertionCacheKey() throws Exception {
        CapturingCache cache = new CapturingCache();
        cache.values.put("tenant_token:client_assertion:cli_a::accounts.feishu.cn", "cached-token");
        CapturingTransport transport = new CapturingTransport("{\"access_token\":\"proxy-token\",\"expires_in\":7200}");
        AtomicInteger calls = new AtomicInteger();
        Config config = config(transport);
        config.setClientAssertionProvider(aud -> {
            calls.incrementAndGet();
            return new ClientAssertionToken(
                    "client-assertion",
                    new TargetInfo("proxy.example.com", "/proxy"));
        });

        String token = new TokenManager(cache).getTenantAccessToken(config, "");

        assertEquals("cached-token", token);
        assertEquals("tenant_token:client_assertion:cli_a::accounts.feishu.cn", cache.getKey);
        assertEquals(0, calls.get());
        assertNull(transport.request);
    }

    @Test
    public void disableTokenCacheSkipsCacheReadAndWrite() throws Exception {
        CapturingCache cache = new CapturingCache();
        CapturingTransport transport = new CapturingTransport("{\"access_token\":\"tenant-token\",\"expires_in\":7200}");
        Config config = config(transport);
        config.setDisableTokenCache(true);
        config.setClientAssertionProvider(aud -> new ClientAssertionToken("client-assertion"));

        String token = new TokenManager(cache).getTenantAccessToken(config, "");

        assertEquals("tenant-token", token);
        assertEquals(0, cache.getCount);
        assertEquals(0, cache.setCount);
        assertEquals("https://accounts.feishu.cn/oauth/v3/token", transport.request.getReqUrl());
    }

    @Test
    public void emptyAssertionFailsWith7101() throws Exception {
        Config config = config(new CapturingTransport("{}"));
        config.setClientAssertionProvider(aud -> new ClientAssertionToken(""));

        try {
            new TokenManager(new CapturingCache()).getTenantAccessToken(config, "");
        } catch (ClientAssertionException e) {
            assertEquals(Constants.ERR_CODE_CLIENT_ASSERTION_TOKEN_EMPTY, e.getCode());
            return;
        }
        throw new AssertionError("expected ClientAssertionException");
    }

    @Test
    public void providerExceptionIsWrappedWith7102() throws Exception {
        Config config = config(new CapturingTransport("{}"));
        config.setClientAssertionProvider(aud -> {
            throw new IllegalStateException("kms down");
        });

        try {
            new TokenManager(new CapturingCache()).getTenantAccessToken(config, "");
        } catch (ClientAssertionException e) {
            assertEquals(Constants.ERR_CODE_CLIENT_ASSERTION_RETRIEVE_FAILED, e.getCode());
            assertTrue(e.getMessage().contains("kms down"));
            return;
        }
        throw new AssertionError("expected ClientAssertionException");
    }

    @Test
    public void appTokenIsBlockedInClientAssertionMode() throws Exception {
        Config config = config(new CapturingTransport("{}"));
        config.setClientAssertionProvider(aud -> new ClientAssertionToken("client-assertion"));

        try {
            new TokenManager(new CapturingCache()).getAppAccessToken(config);
        } catch (ClientAssertionException e) {
            assertEquals(Constants.ERR_CODE_CLIENT_ASSERTION_PROVIDER_NOT_CONFIGURED, e.getCode());
            return;
        }
        throw new AssertionError("expected ClientAssertionException");
    }

    @Test
    public void missingAccessTokenUsesServerMessage() throws Exception {
        CapturingTransport transport = new CapturingTransport("{\"code\":400,\"error\":\"invalid_client\",\"error_description\":\"bad assertion\"}");
        Config config = config(transport);
        config.setClientAssertionProvider(aud -> new ClientAssertionToken("client-assertion"));

        try {
            new TokenManager(new CapturingCache()).getTenantAccessToken(config, "");
        } catch (ClientAssertionException e) {
            assertEquals(400, e.getCode());
            assertTrue(e.getMessage().contains("bad assertion"));
            return;
        }
        throw new AssertionError("expected ClientAssertionException");
    }

    private Config config(IHttpTransport transport) {
        Config config = new Config();
        config.setAppId("cli_a");
        config.setAppSecret("");
        config.setBaseUrl("https://open.feishu.cn");
        config.setHttpTransport(transport);
        return config;
    }

    private static class CapturingTransport implements IHttpTransport {
        private final String body;
        private RawRequest request;

        private CapturingTransport(String body) {
            this.body = body;
        }

        @Override
        public RawResponse execute(RawRequest request) {
            this.request = request;
            RawResponse response = new RawResponse();
            response.setStatusCode(200);
            response.setBody(body.getBytes(StandardCharsets.UTF_8));
            return response;
        }
    }

    private static class CapturingCache implements ICache {
        private final Map<String, String> values = new HashMap<>();
        private String getKey;
        private String key;
        private String value;
        private int expire;
        private int getCount;
        private int setCount;

        @Override
        public String get(String key) {
            this.getKey = key;
            this.getCount++;
            String value = values.get(key);
            return value == null ? "" : value;
        }

        @Override
        public void set(String key, String value, int expire, TimeUnit timeUnit) {
            this.key = key;
            this.value = value;
            this.expire = expire;
            this.setCount++;
        }
    }
}
