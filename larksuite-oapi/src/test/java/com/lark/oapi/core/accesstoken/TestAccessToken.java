package com.lark.oapi.core.accesstoken;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lark.oapi.core.Config;
import com.lark.oapi.core.Constants;
import com.lark.oapi.core.auth.ClientAssertionToken;
import com.lark.oapi.core.auth.TargetInfo;
import com.lark.oapi.core.exception.ClientAssertionException;
import com.lark.oapi.core.httpclient.IHttpTransport;
import com.lark.oapi.core.request.RawRequest;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.utils.Jsons;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestAccessToken {

    @Test
    public void authorizationCodeProviderRequestUsesJwtBearerFields() throws Exception {
        CapturingTransport transport = new CapturingTransport(successBody(), 200);
        AtomicReference<String> audRef = new AtomicReference<>();
        Config config = providerConfig(transport);
        config.setClientAssertionProvider(aud -> {
            audRef.set(aud);
            return new ClientAssertionToken("client-assertion");
        });

        AccessTokenResp resp = new AccessToken(config).retrieveByAuthorizationCode(
                AuthorizationCodeTokenRequest.newBuilder()
                        .code("auth-code")
                        .redirectUri("https://example.com/callback")
                        .codeVerifier("verifier")
                        .scope("contact:user.base:readonly")
                        .build());

        assertEquals("oauth-access-token", resp.getData().getAccessToken());
        assertEquals("accounts.feishu.cn", audRef.get());
        assertEquals("https://accounts.feishu.cn/oauth/v3/token", transport.request.getReqUrl());
        JsonObject body = requestBody(transport);
        assertEquals(Constants.GRANT_TYPE_AUTHORIZATION_CODE, body.get("grant_type").getAsString());
        assertEquals("cli_a", body.get("client_id").getAsString());
        assertEquals(Constants.CLIENT_ASSERTION_TYPE_JWT_BEARER, body.get("client_assertion_type").getAsString());
        assertEquals("client-assertion", body.get("client_assertion").getAsString());
        assertEquals("auth-code", body.get("code").getAsString());
        assertEquals("https://example.com/callback", body.get("redirect_uri").getAsString());
        assertEquals("verifier", body.get("code_verifier").getAsString());
        assertEquals("contact:user.base:readonly", body.get("scope").getAsString());
        assertFalse(body.has("client_secret"));
    }

    @Test
    public void refreshProviderRequestUsesRefreshTokenGrant() throws Exception {
        CapturingTransport transport = new CapturingTransport(successBody(), 200);
        Config config = providerConfig(transport);
        config.setClientAssertionProvider(aud -> new ClientAssertionToken("client-assertion"));

        new AccessToken(config).refresh(
                RefreshTokenRequest.newBuilder()
                        .refreshToken("refresh-token")
                        .scope("contact:user.base:readonly")
                        .build());

        JsonObject body = requestBody(transport);
        assertEquals(Constants.GRANT_TYPE_REFRESH_TOKEN, body.get("grant_type").getAsString());
        assertEquals("refresh-token", body.get("refresh_token").getAsString());
        assertEquals("contact:user.base:readonly", body.get("scope").getAsString());
        assertFalse(body.has("code"));
    }

    @Test
    public void appSecretFallbackUsesClientSecret() throws Exception {
        CapturingTransport transport = new CapturingTransport(successBody(), 200);
        Config config = new Config();
        config.setAppId("cli_a");
        config.setAppSecret("app-secret");
        config.setHttpTransport(transport);

        new AccessToken(config).refresh(
                RefreshTokenRequest.newBuilder()
                        .refreshToken("refresh-token")
                        .build());

        JsonObject body = requestBody(transport);
        assertEquals("app-secret", body.get("client_secret").getAsString());
        assertFalse(body.has("client_assertion"));
        assertFalse(body.has("client_assertion_type"));
    }

    @Test
    public void missingCredentialsFailWith7104() throws Exception {
        Config config = new Config();
        config.setAppId("cli_a");
        config.setAppSecret("");
        config.setHttpTransport(new CapturingTransport(successBody(), 200));

        try {
            new AccessToken(config).refresh(RefreshTokenRequest.newBuilder().refreshToken("refresh-token").build());
        } catch (ClientAssertionException e) {
            assertEquals(Constants.ERR_CODE_APP_SECRET_AND_CLIENT_ASSERTION_EMPTY, e.getCode());
            return;
        }
        throw new AssertionError("expected ClientAssertionException");
    }

    @Test
    public void targetInfoUsesProxyAndTargetServiceHeader() throws Exception {
        CapturingTransport transport = new CapturingTransport(successBody(), 200);
        Config config = providerConfig(transport);
        config.setClientAssertionProvider(aud -> new ClientAssertionToken(
                "client-assertion",
                new TargetInfo("proxy.example.com", "/proxy")));

        new AccessToken(config).refresh(RefreshTokenRequest.newBuilder().refreshToken("refresh-token").build());

        assertEquals("https://proxy.example.com/proxy/oauth/v3/token", transport.request.getReqUrl());
        assertEquals("accounts.feishu.cn", transport.request.getHeaders().get(Constants.HEADER_X_TARGET_SERVICE).get(0));
    }

    @Test
    public void targetInfoProviderIsCalledOnce() throws Exception {
        CapturingTransport transport = new CapturingTransport(successBody(), 200);
        Config config = providerConfig(transport);
        AtomicInteger calls = new AtomicInteger();
        config.setClientAssertionProvider(aud -> {
            calls.incrementAndGet();
            return new ClientAssertionToken("client-assertion", new TargetInfo("proxy.example.com", "/proxy"));
        });

        new AccessToken(config).refresh(RefreshTokenRequest.newBuilder().refreshToken("refresh-token").build());

        assertEquals(1, calls.get());
    }

    @Test
    public void non200OAuthErrorThrowsAccessTokenError() throws Exception {
        CapturingTransport transport = new CapturingTransport(
                "{\"code\":400,\"error\":\"invalid_client\",\"error_description\":\"bad assertion\"}",
                400);
        Config config = providerConfig(transport);
        config.setClientAssertionProvider(aud -> new ClientAssertionToken("client-assertion"));

        try {
            new AccessToken(config).refresh(RefreshTokenRequest.newBuilder().refreshToken("refresh-token").build());
        } catch (AccessTokenError e) {
            assertEquals(400, e.getStatusCode());
            assertEquals(400, e.getCode());
            assertEquals("invalid_client", e.getErrorType());
            assertEquals("bad assertion", e.getErrorDescription());
            assertTrue(e.getMessage().contains("bad assertion"));
            return;
        }
        throw new AssertionError("expected AccessTokenError");
    }

    @Test
    public void v3BusinessErrorWithHttp200ThrowsAccessTokenError() throws Exception {
        CapturingTransport transport = new CapturingTransport(
                "{\"code\":20050,\"error\":\"server_error\",\"error_description\":\"retry later\"}",
                200);
        Config config = providerConfig(transport);
        config.setClientAssertionProvider(aud -> new ClientAssertionToken("client-assertion"));

        try {
            new AccessToken(config).refresh(RefreshTokenRequest.newBuilder().refreshToken("refresh-token").build());
        } catch (AccessTokenError e) {
            assertEquals(200, e.getStatusCode());
            assertEquals(20050, e.getCode());
            assertEquals("server_error", e.getErrorType());
            assertEquals("retry later", e.getErrorDescription());
            return;
        }
        throw new AssertionError("expected AccessTokenError");
    }

    @Test
    public void v3SuccessCodeWithoutAccessTokenThrowsAccessTokenError() throws Exception {
        CapturingTransport transport = new CapturingTransport("{\"code\":0,\"expires_in\":7200}", 200);
        Config config = providerConfig(transport);
        config.setClientAssertionProvider(aud -> new ClientAssertionToken("client-assertion"));

        try {
            new AccessToken(config).refresh(RefreshTokenRequest.newBuilder().refreshToken("refresh-token").build());
        } catch (AccessTokenError e) {
            assertEquals(200, e.getStatusCode());
            assertEquals(0, e.getCode());
            assertTrue(e.getMessage().contains("access_token"));
            return;
        }
        throw new AssertionError("expected AccessTokenError");
    }

    @Test
    public void successResponseMapsAllTokenFields() throws Exception {
        CapturingTransport transport = new CapturingTransport(successBody(), 200);
        Config config = providerConfig(transport);
        config.setClientAssertionProvider(aud -> new ClientAssertionToken("client-assertion"));

        AccessTokenResp resp = new AccessToken(config).refresh(
                RefreshTokenRequest.newBuilder()
                        .refreshToken("refresh-token")
                        .build());

        assertEquals(200, resp.getStatusCode());
        assertEquals("oauth-access-token", resp.getData().getAccessToken());
        assertEquals("Bearer", resp.getData().getTokenType());
        assertEquals(7200, resp.getData().getExpiresIn());
        assertEquals("new-refresh-token", resp.getData().getRefreshToken());
        assertEquals(604800, resp.getData().getRefreshTokenExpiresIn());
        assertEquals("contact:user.base:readonly", resp.getData().getScope());
    }

    private Config providerConfig(IHttpTransport transport) {
        Config config = new Config();
        config.setAppId("cli_a");
        config.setAppSecret("");
        config.setBaseUrl("https://open.feishu.cn");
        config.setHttpTransport(transport);
        return config;
    }

    private JsonObject requestBody(CapturingTransport transport) {
        return JsonParser.parseString(Jsons.DEFAULT.toJson(transport.request.getBody())).getAsJsonObject();
    }

    private String successBody() {
        return "{\"code\":0,\"access_token\":\"oauth-access-token\",\"token_type\":\"Bearer\",\"expires_in\":7200,\"refresh_token\":\"new-refresh-token\",\"refresh_token_expires_in\":604800,\"scope\":\"contact:user.base:readonly\"}";
    }

    private static class CapturingTransport implements IHttpTransport {
        private final String body;
        private final int statusCode;
        private RawRequest request;

        private CapturingTransport(String body, int statusCode) {
            this.body = body;
            this.statusCode = statusCode;
        }

        @Override
        public RawResponse execute(RawRequest request) {
            this.request = request;
            RawResponse response = new RawResponse();
            response.setStatusCode(statusCode);
            response.setBody(body.getBytes(StandardCharsets.UTF_8));
            return response;
        }
    }
}
