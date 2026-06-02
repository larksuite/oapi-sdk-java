package com.lark.oapi.channel;

import com.lark.oapi.Client;
import com.lark.oapi.channel.config.LarkChannelOptions;
import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;
import com.lark.oapi.channel.model.BotIdentity;
import com.lark.oapi.core.request.RequestOptions;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;

import java.nio.charset.StandardCharsets;

import org.junit.Assert;
import org.junit.Test;

public class TestConnectErrors {
    private static LarkChannelOptions options() {
        return LarkChannelOptions.newBuilder("cli_test", "secret").transport("webhook").build();
    }

    private static RawResponse response(int statusCode, String body) {
        RawResponse response = new RawResponse();
        response.setStatusCode(statusCode);
        response.setBody(body.getBytes(StandardCharsets.UTF_8));
        return response;
    }

    @Test
    public void testHttp401MapsToPermissionDenied() {
        assertConnectError(response(401, "{\"code\":99991401,\"msg\":\"invalid token\"}"),
                LarkChannelErrorCode.PERMISSION_DENIED);
    }

    @Test
    public void testHttp403MapsToPermissionDenied() {
        assertConnectError(response(403, "{\"code\":99991400,\"msg\":\"forbidden\"}"),
                LarkChannelErrorCode.PERMISSION_DENIED);
    }

    @Test
    public void testFeishuAuthCodeMapsToPermissionDenied() {
        assertConnectError(response(200, "{\"code\":99991401,\"msg\":\"auth failed\"}"),
                LarkChannelErrorCode.PERMISSION_DENIED);
    }

    @Test
    public void testHttp429MapsToRateLimited() {
        assertConnectError(response(429, "{\"code\":0,\"msg\":\"too many requests\"}"),
                LarkChannelErrorCode.RATE_LIMITED);
    }

    @Test
    public void testTimeoutKeepsTimeoutCode() {
        assertConnectError(new RuntimeException("ETIMEDOUT"), LarkChannelErrorCode.SEND_TIMEOUT);
    }

    @Test
    public void testUnknownFailureFallsBackToNotConnected() {
        assertConnectError(new RuntimeException("ECONNREFUSED: no route to host"), LarkChannelErrorCode.NOT_CONNECTED);
    }

    @Test
    public void testMissingOpenIdFallsBackToNotConnected() {
        assertConnectError(response(200, "{\"code\":0,\"bot\":{}}"), LarkChannelErrorCode.NOT_CONNECTED);
    }

    @Test
    public void testSuccessReturnsBotIdentity() {
        BotIdentity identity = new BotIdentityResolver(new StubBotInfoClient(
                response(200, "{\"code\":0,\"bot\":{\"open_id\":\"ou_abc\",\"app_name\":\"Test Bot\"}}")),
                options()).fetch();

        Assert.assertEquals("ou_abc", identity.getOpenId());
        Assert.assertEquals("Test Bot", identity.getName());
    }

    private void assertConnectError(Object result, LarkChannelErrorCode expected) {
        try {
            new BotIdentityResolver(new StubBotInfoClient(result), options()).fetch();
            Assert.fail("expected " + expected.getValue());
        } catch (LarkChannelException e) {
            Assert.assertEquals(expected.getValue(), e.getCode());
        }
    }

    private static final class StubBotInfoClient extends Client {
        private final Object result;

        private StubBotInfoClient(Object result) {
            this.result = result;
        }

        @Override
        public RawResponse get(String httpPath, Object body, AccessTokenType accessTokenType,
                               RequestOptions requestOptions) throws Exception {
            if (result instanceof RuntimeException) {
                throw (RuntimeException) result;
            }
            return (RawResponse) result;
        }
    }
}
