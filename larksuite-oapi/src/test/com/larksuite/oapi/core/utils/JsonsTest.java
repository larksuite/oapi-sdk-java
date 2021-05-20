package com.larksuite.oapi.core.utils;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.event.v1.AppTicketEvent;
import org.junit.Test;

import java.util.Arrays;

import static com.larksuite.oapi.core.utils.Jsons.DEFAULT_GSON;
import static com.larksuite.oapi.core.utils.Jsons.LONG_TO_STR_GSON;

public class JsonsTest {

    public static class User {
        @SerializedName("image_key")
        private String imageKey;

        @SerializedName("id")
        private Long id;

        @SerializedName("ids")
        private Long[] ids;

        public String getImageKey() {
            return imageKey;
        }

        public void setImageKey(String imageKey) {
            this.imageKey = imageKey;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long[] getIds() {
            return ids;
        }

        public void setIds(Long[] ids) {
            this.ids = ids;
        }
    }

    @Test
    public void TestUserGSON() {
        User user = new User();
        user.setId(999999999999999999L);
        user.setIds(new Long[]{999999999999999998L});
        user.setImageKey("setImageKey");
        String json = LONG_TO_STR_GSON.toJson(user);
        System.out.println(json);
        json = "{\"image_key\":\"setImageKey\",\"id\":\"999999999999999999\",\"ids\":[999999999999999998]}";
        user = LONG_TO_STR_GSON.fromJson(json, User.class);
        System.out.println(user.getId());
        System.out.println(user.getImageKey());
        System.out.println(Arrays.toString(user.getIds()));

        System.out.println("===================");

        json = "{\"image_key\":\"setImageKey\",\"id\":999999999999999997,\"ids\":[\"999999999999999998\"]}";
        user = DEFAULT_GSON.fromJson(json, User.class);
        System.out.println(user.getId());
        System.out.println(user.getImageKey());
        System.out.println(Arrays.toString(user.getIds()));
    }


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