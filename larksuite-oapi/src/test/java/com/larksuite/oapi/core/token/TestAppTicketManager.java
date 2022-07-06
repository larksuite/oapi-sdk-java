package com.larksuite.oapi.core.token;

import com.larksuite.oapi.core.Config;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestAppTicketManager {
    @Test
    public void testAppTicketPutGet() throws Exception {
        AppTicketManager appTicketManager = GlobalAppTicketManager.getAppTicketManager();
        appTicketManager.put("appId", "value1", 1, TimeUnit.SECONDS);

        Config config = new Config();
        config.setAppId("appId");
        config.setAppSecret("appSecet");
        String value = appTicketManager.get(config);

        assert value.equals("value1");
    }

    @Test
    public void testAppTicketKeyTimeout() throws Exception {
        AppTicketManager appTicketManager = GlobalAppTicketManager.getAppTicketManager();
        appTicketManager.put("appId", "value1", 1, TimeUnit.MILLISECONDS);

        Thread.sleep(2);

        Config config = new Config();
        config.setAppId("appId");
        config.setAppSecret("appSecet");
        String value = appTicketManager.get(config);

        assert value.equals("");
    }
}
