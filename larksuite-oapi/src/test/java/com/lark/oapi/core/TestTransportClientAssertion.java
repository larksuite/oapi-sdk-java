package com.lark.oapi.core;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
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
import com.lark.oapi.core.utils.Lists;
import com.lark.oapi.core.utils.Sets;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
    public void providerRetrieveFailureDoesNotRetryInsideTransport() throws Exception {
        TokenManager previous = GlobalTokenManager.getTokenManager();
        try {
            CapturingTransport transport = new CapturingTransport();
            Config config = config();
            config.setHttpTransport(transport);
            FlakyTokenManager tokenManager = new FlakyTokenManager();
            GlobalTokenManager.setTokenManager(tokenManager);

            try {
                Transport.send(config, null, "GET", "/resource", Sets.newHashSet(AccessTokenType.Tenant), null);
            } catch (ClientAssertionException e) {
                assertEquals(Constants.ERR_CODE_CLIENT_ASSERTION_RETRIEVE_FAILED, e.getCode());
                assertEquals(1, tokenManager.calls.get());
                assertNull(transport.lastRequest);
                return;
            }
            throw new AssertionError("expected ClientAssertionException");
        } finally {
            GlobalTokenManager.setTokenManager(previous);
        }
    }

    @Test
    public void debugRequestLogOmitsSensitiveHeadersAndBody() throws Exception {
        ch.qos.logback.classic.Logger logger =
                (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Transport.class);
        Level previousLevel = logger.getLevel();
        ListAppender<ILoggingEvent> appender = new ListAppender<>();
        appender.start();
        logger.addAppender(appender);
        logger.setLevel(Level.DEBUG);
        try {
            Config config = config();
            config.setLogReqAtDebug(true);
            config.setHttpTransport(new CapturingTransport());
            Map<String, java.util.List<String>> headers = new HashMap<>();
            headers.put("Authorization", Lists.newArrayList("Bearer raw-access-token"));
            RequestOptions options = RequestOptions.newBuilder()
                    .headers(headers)
                    .build();
            Map<String, Object> body = new HashMap<>();
            body.put("client_assertion", "raw-client-assertion");
            body.put("client_secret", "raw-client-secret");
            body.put("refresh_token", "raw-refresh-token");

            Transport.send(config, options, "POST", "/oauth/v3/token", Sets.newHashSet(AccessTokenType.None), body);

            String logs = appender.list.stream()
                    .map(ILoggingEvent::getFormattedMessage)
                    .collect(Collectors.joining("\n"));
            assertFalse(logs.contains("raw-client-assertion"));
            assertFalse(logs.contains("raw-client-secret"));
            assertFalse(logs.contains("raw-refresh-token"));
            assertFalse(logs.contains("raw-access-token"));
            assertTrue(logs.contains("body:<omitted>"));
        } finally {
            logger.detachAppender(appender);
            logger.setLevel(previousLevel);
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
