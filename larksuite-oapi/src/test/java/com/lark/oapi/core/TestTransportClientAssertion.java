package com.lark.oapi.core;

import com.lark.oapi.core.auth.ClientAssertionToken;
import com.lark.oapi.core.cache.ICache;
import com.lark.oapi.core.enums.AppType;
import com.lark.oapi.core.exception.ClientAssertionException;
import com.lark.oapi.core.httpclient.IHttpTransport;
import com.lark.oapi.core.request.RawRequest;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.core.token.GlobalTokenManager;
import com.lark.oapi.core.token.TokenManager;
import com.lark.oapi.core.utils.Sets;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestTransportClientAssertion {

    @Test
    public void clientAssertionRejectsAppOnlyApi() throws Exception {
        Config config = config();

        try {
            Transport.send(config, null, "GET", "/resource", Sets.newHashSet(AccessTokenType.App), null);
        } catch (ClientAssertionException e) {
            assertEquals(Constants.ERR_CODE_CLIENT_ASSERTION_MODE_NOT_SUPPORTED, e.getCode());
            return;
        }
        throw new AssertionError("expected ClientAssertionException");
    }

    @Test
    public void clientAssertionAllowsEmptyAppSecretForNoneTokenRequests() throws Exception {
        CapturingTransport transport = new CapturingTransport();
        Config config = config();
        config.setHttpTransport(transport);

        RawResponse response = Transport.send(config, null, "POST", "/oauth/v3/token", Sets.newHashSet(AccessTokenType.None), new Object());

        assertEquals(200, response.getStatusCode());
        assertNull(transport.lastRequest.getHeaders().get("Authorization"));
    }

    @Test
    public void marketplaceClientAssertionModeFails() throws Exception {
        Config config = config();
        config.setAppType(AppType.MARKETPLACE);

        try {
            Transport.send(config, null, "GET", "/resource", Sets.newHashSet(AccessTokenType.Tenant), null);
        } catch (ClientAssertionException e) {
            assertEquals(Constants.ERR_CODE_CLIENT_ASSERTION_PROVIDER_NOT_CONFIGURED, e.getCode());
            return;
        }
        throw new AssertionError("expected ClientAssertionException");
    }

    @Test
    public void manualUserTokenWinsOverTenantInClientAssertionMode() throws Exception {
        CapturingTransport transport = new CapturingTransport();
        Config config = config();
        config.setHttpTransport(transport);
        AtomicInteger providerCalls = new AtomicInteger();
        config.setClientAssertionProvider(aud -> {
            providerCalls.incrementAndGet();
            return new ClientAssertionToken("assertion");
        });
        RequestOptions options = RequestOptions.newBuilder()
                .userAccessToken("user-token")
                .build();

        Transport.send(config, options, "GET", "/resource", Sets.newHashSet(AccessTokenType.User, AccessTokenType.Tenant), null);

        assertEquals("Bearer user-token", transport.lastRequest.getHeaders().get("Authorization").get(0));
        assertEquals(0, providerCalls.get());
    }

    @Test
    public void emptyAppSecretAllowedWithMatchingManualTenantToken() throws Exception {
        CapturingTransport transport = new CapturingTransport();
        Config config = config();
        config.setClientAssertionProvider(null);
        config.setDisableTokenCache(true);
        config.setHttpTransport(transport);
        RequestOptions options = RequestOptions.newBuilder()
                .tenantAccessToken("tenant-token")
                .build();

        Transport.send(config, options, "GET", "/resource", Sets.newHashSet(AccessTokenType.Tenant), null);

        assertEquals("Bearer tenant-token", transport.lastRequest.getHeaders().get("Authorization").get(0));
    }

    @Test
    public void providerRetrieveFailureRetriesOnce() throws Exception {
        TokenManager previous = GlobalTokenManager.getTokenManager();
        try {
            CapturingTransport transport = new CapturingTransport();
            Config config = config();
            config.setHttpTransport(transport);
            FlakyTokenManager tokenManager = new FlakyTokenManager();
            GlobalTokenManager.setTokenManager(tokenManager);

            Transport.send(config, null, "GET", "/resource", Sets.newHashSet(AccessTokenType.Tenant), null);

            assertEquals(2, tokenManager.calls.get());
            assertEquals("Bearer tenant-token", transport.lastRequest.getHeaders().get("Authorization").get(0));
        } finally {
            GlobalTokenManager.setTokenManager(previous);
        }
    }

    @Test
    public void emptyAssertionFailureDoesNotRetry() throws Exception {
        TokenManager previous = GlobalTokenManager.getTokenManager();
        try {
            Config config = config();
            EmptyAssertionTokenManager tokenManager = new EmptyAssertionTokenManager();
            GlobalTokenManager.setTokenManager(tokenManager);

            try {
                Transport.send(config, null, "GET", "/resource", Sets.newHashSet(AccessTokenType.Tenant), null);
            } catch (ClientAssertionException e) {
                assertEquals(Constants.ERR_CODE_CLIENT_ASSERTION_TOKEN_EMPTY, e.getCode());
                assertEquals(1, tokenManager.calls.get());
                return;
            }
            throw new AssertionError("expected ClientAssertionException");
        } finally {
            GlobalTokenManager.setTokenManager(previous);
        }
    }

    private Config config() {
        Config config = new Config();
        config.setAppId("cli_a");
        config.setAppSecret("");
        config.setClientAssertionProvider(aud -> new ClientAssertionToken("assertion"));
        config.setHttpTransport(new CapturingTransport());
        return config;
    }

    private static class CapturingTransport implements IHttpTransport {
        private RawRequest lastRequest;

        @Override
        public RawResponse execute(RawRequest request) {
            this.lastRequest = request;
            RawResponse response = new RawResponse();
            response.setStatusCode(200);
            response.setBody("{\"code\":0}".getBytes(StandardCharsets.UTF_8));
            return response;
        }
    }

    private static class FlakyTokenManager extends TokenManager {
        private final AtomicInteger calls = new AtomicInteger();

        private FlakyTokenManager() {
            super(new NoopCache());
        }

        @Override
        public String getTenantAccessToken(Config config, String tenantKey) {
            if (calls.incrementAndGet() == 1) {
                throw new ClientAssertionException(Constants.ERR_CODE_CLIENT_ASSERTION_RETRIEVE_FAILED, "kms down");
            }
            return "tenant-token";
        }
    }

    private static class EmptyAssertionTokenManager extends TokenManager {
        private final AtomicInteger calls = new AtomicInteger();

        private EmptyAssertionTokenManager() {
            super(new NoopCache());
        }

        @Override
        public String getTenantAccessToken(Config config, String tenantKey) {
            calls.incrementAndGet();
            throw new ClientAssertionException(Constants.ERR_CODE_CLIENT_ASSERTION_TOKEN_EMPTY, "client assertion token is empty");
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
