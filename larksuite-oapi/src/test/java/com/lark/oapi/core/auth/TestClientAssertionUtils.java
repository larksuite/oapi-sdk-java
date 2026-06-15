package com.lark.oapi.core.auth;

import com.lark.oapi.core.Config;
import com.lark.oapi.core.Constants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClientAssertionUtils {

    @Test
    public void defaultFeishuOpenApiHostMapsToFeishuOAuthHost() {
        Config config = new Config();
        config.setBaseUrl("https://open.feishu.cn");

        assertEquals("https://accounts.feishu.cn", ClientAssertionUtils.resolveOAuthBaseUrl(config));
        assertEquals("accounts.feishu.cn", ClientAssertionUtils.resolveOAuthAud(config));
    }

    @Test
    public void defaultLarkOpenApiHostMapsToLarkOAuthHost() {
        Config config = new Config();
        config.setBaseUrl("https://open.larksuite.com");

        assertEquals("https://accounts.larksuite.com", ClientAssertionUtils.resolveOAuthBaseUrl(config));
        assertEquals("accounts.larksuite.com", ClientAssertionUtils.resolveOAuthAud(config));
    }

    @Test
    public void explicitOAuthBaseUrlIsNormalizedAndUsedAsAudience() {
        Config config = new Config();
        config.setBaseUrl("https://custom.example.com");
        config.setOAuthBaseUrl("accounts.example.com/");

        assertEquals("https://accounts.example.com", ClientAssertionUtils.resolveOAuthBaseUrl(config));
        assertEquals("accounts.example.com", ClientAssertionUtils.resolveOAuthAud(config));
    }

    @Test
    public void customOpenApiHostWithoutOAuthBaseUrlFails() {
        Config config = new Config();
        config.setBaseUrl("https://open.feishu-boe.cn");

        try {
            ClientAssertionUtils.resolveOAuthBaseUrl(config);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("OAuthBaseUrl is not configured"));
            return;
        }
        throw new AssertionError("expected IllegalArgumentException");
    }

    @Test
    public void audiencePreservesPort() {
        Config config = new Config();
        config.setOAuthBaseUrl("http://127.0.0.1:8080");

        assertEquals("127.0.0.1:8080", ClientAssertionUtils.resolveOAuthAud(config));
    }

    @Test
    public void proxyUrlAddsSchemeWhenMissing() {
        assertEquals(
                "https://proxy.example.com/proxy/oauth/v3/token",
                ClientAssertionUtils.buildProxyUrl("proxy.example.com", "/proxy", Constants.OAUTH_TOKEN_URL_PATH));
    }
}
