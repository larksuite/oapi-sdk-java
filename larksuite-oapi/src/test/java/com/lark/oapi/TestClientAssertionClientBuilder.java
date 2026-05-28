package com.lark.oapi;

import com.lark.oapi.core.auth.ClientAssertionProvider;
import com.lark.oapi.core.auth.ClientAssertionToken;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestClientAssertionClientBuilder {

    @Test
    public void builderExposesClientAssertionOptionsAndAccessTokenService() {
        ClientAssertionProvider provider = aud -> new ClientAssertionToken("assertion");

        Client client = Client.newBuilder("cli_a", "")
                .oauthBaseUrl("https://accounts.feishu.cn")
                .clientAssertionProvider(provider)
                .build();

        assertNotNull(client.accessToken());
    }
}
