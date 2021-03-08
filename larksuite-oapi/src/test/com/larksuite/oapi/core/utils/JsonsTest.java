package com.larksuite.oapi.core.utils;

import com.larksuite.oapi.core.event.v1.AppTicketEvent;
import org.junit.Test;

import static com.larksuite.oapi.core.utils.Jsons.DEFAULT_GSON;

public class JsonsTest {


    @Test
    public void TestGSON() {
        AppTicketEvent appTicketEvent = new AppTicketEvent();
        appTicketEvent.setTs("ts");
        appTicketEvent.setUuid("uuid");
        appTicketEvent.setToken("token");
        appTicketEvent.setType("type");

        AppTicketEvent.AppTicketEventData appTicketEventData = new AppTicketEvent.AppTicketEventData();
        appTicketEventData.setAppId("appID");
        appTicketEventData.setType("type");
        appTicketEventData.setTenantKey("tenantKey");
        appTicketEventData.setAppTicket("AppTicket");
        appTicketEvent.setEvent(appTicketEventData);

        System.out.println(DEFAULT_GSON.toJson(appTicketEvent));

        String j = "{\"event\":{\"app_ticket\":\"AppTicket\",\"app_id\":\"appID\",\"type\":\"type\",\"tenant_key\":\"tenantKey\"},\"ts\":\"ts\",\"uuid\":\"uuid\",\"token\":\"token\",\"type\":\"type\"}";
        AppTicketEvent appTicketEvent1 = DEFAULT_GSON.fromJson(j, AppTicketEvent.class);
        System.out.println(DEFAULT_GSON.toJson(appTicketEvent1));
    }


}