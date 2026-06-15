package com.lark.oapi.e2e;

import com.lark.oapi.core.auth.ClientAssertionToken;
import com.lark.oapi.core.auth.TargetInfo;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TestClientAssertionLiveHarness {

    @Test
    public void parseBoolAcceptsCommonValues() {
        assertTrue(ClientAssertionLiveHarness.parseBool("true", false));
        assertTrue(ClientAssertionLiveHarness.parseBool("1", false));
        assertTrue(ClientAssertionLiveHarness.parseBool("yes", false));
        assertFalse(ClientAssertionLiveHarness.parseBool("false", true));
        assertFalse(ClientAssertionLiveHarness.parseBool("0", true));
        assertTrue(ClientAssertionLiveHarness.parseBool(null, true));
    }

    @Test
    public void deployDomainsSupportOnlineAndBoe() {
        assertEquals("https://open.feishu.cn",
                ClientAssertionLiveHarness.deployDomains("online").getOpenApiDomain());
        assertEquals("https://accounts.feishu.cn",
                ClientAssertionLiveHarness.deployDomains("cn").getOAuthBaseUrl());
        assertEquals("https://open.feishu-boe.cn",
                ClientAssertionLiveHarness.deployDomains("boe").getOpenApiDomain());
    }

    @Test
    public void loadEnvFilePreservesExistingEnvAndHandlesQuotedScope() throws Exception {
        File envFile = File.createTempFile("client-assertion-live", ".env");
        try {
            String content = "# comment\n"
                    + "export LARK_APP_ID=cli_file\n"
                    + "LARK_OAUTH_SCOPE=\"contact:user.basic_profile:readonly offline_access\"\n"
                    + "LARK_APP_SECRET=from_file # inline comment\n";
            try (FileOutputStream os = new FileOutputStream(envFile)) {
                os.write(content.getBytes(StandardCharsets.UTF_8));
            }

            Map<String, String> env = new HashMap<>();
            env.put("LARK_APP_ID", "cli_existing");

            ClientAssertionLiveHarness.loadEnvFile(envFile, env, false);

            assertEquals("cli_existing", env.get("LARK_APP_ID"));
            assertEquals("contact:user.basic_profile:readonly offline_access", env.get("LARK_OAUTH_SCOPE"));
            assertEquals("from_file", env.get("LARK_APP_SECRET"));
        } finally {
            envFile.delete();
        }
    }

    @Test
    public void modeEnvProviderReturnsZtiWithoutTargetInfo() throws Exception {
        Map<String, String> values = new HashMap<>();
        values.put("LARK_ZTI_CLIENT_ASSERTION", "zti-token");
        ClientAssertionLiveHarness.ModeEnvProvider provider =
                new ClientAssertionLiveHarness.ModeEnvProvider("zti", new ClientAssertionLiveHarness.Env(values));

        ClientAssertionToken token = provider.retrieveToken("accounts.feishu.cn");

        assertEquals("zti-token", token.getValue());
        assertNull(token.getTargetInfo());
        assertEquals("accounts.feishu.cn", provider.getAuds().get(0));
    }

    @Test
    public void modeEnvProviderReturnsGdprWithTargetInfo() throws Exception {
        Map<String, String> values = new HashMap<>();
        values.put("LARK_GDPR_CLIENT_ASSERTION", "gdpr-token");
        values.put("LARK_GDPR_PROXY_SERVICE", "proxy.example.com");
        values.put("LARK_GDPR_PROXY_PREFIX", "/proxy");
        ClientAssertionLiveHarness.ModeEnvProvider provider =
                new ClientAssertionLiveHarness.ModeEnvProvider("gdpr", new ClientAssertionLiveHarness.Env(values));

        ClientAssertionToken token = provider.retrieveToken("open.feishu.cn");
        TargetInfo targetInfo = token.getTargetInfo();

        assertEquals("gdpr-token", token.getValue());
        assertEquals("proxy.example.com", targetInfo.getTargetService());
        assertEquals("/proxy", targetInfo.getTargetPrefix());
        assertEquals("open.feishu.cn", provider.getAuds().get(0));
    }

    @Test
    public void buildAuthorizeUrlUsesLocalRedirectWithoutPkce() {
        String url = ClientAssertionLiveHarness.buildAuthorizeUrl(
                "https://accounts.feishu.cn",
                "cli_xxx",
                "http://127.0.0.1:8765/uat_e2e/callback",
                "contact:user.basic_profile:readonly offline_access",
                "state-123",
                "");

        assertTrue(url.startsWith("https://accounts.feishu.cn/open-apis/authen/v1/authorize?"));
        assertTrue(url.contains("app_id=cli_xxx"));
        assertTrue(url.contains("redirect_uri=http%3A%2F%2F127.0.0.1%3A8765%2Fuat_e2e%2Fcallback"));
        assertTrue(url.contains("scope=contact%3Auser.basic_profile%3Areadonly+offline_access"));
        assertTrue(url.contains("state=state-123"));
        assertFalse(url.contains("code_challenge"));
    }

    @Test
    public void modeEnabledSupportsCommaSeparatedAliases() {
        Map<String, String> values = new HashMap<>();
        values.put("LARK_E2E_MODES", "appsecret, gdpr");
        ClientAssertionLiveHarness.Env env = new ClientAssertionLiveHarness.Env(values);

        assertTrue(env.modeEnabled("app_secret"));
        assertTrue(env.modeEnabled("gdpr"));
        assertFalse(env.modeEnabled("zti"));
    }
}
