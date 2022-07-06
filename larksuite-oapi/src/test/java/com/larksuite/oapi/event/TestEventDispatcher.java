package com.larksuite.oapi.event;

import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.request.EventReq;
import com.larksuite.oapi.core.response.EventResp;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.service.contact.v3.ContactService;
import com.larksuite.oapi.service.contact.v3.model.UserCreatedEvent;
import com.larksuite.oapi.service.im.v1.ImService;
import com.larksuite.oapi.service.im.v1.model.MessageReceiveEvent;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEventDispatcher {
    @Test
    public void testVerifyUrlOK() throws Throwable {
        EventDispatcher eventDispatcher = EventDispatcher.newBuilder("v", "")
                .onUserCreatedV3(new ContactService.UserCreatedEventHandler() {
                    @Override
                    public void handle(UserCreatedEvent event) throws Exception {
                        System.out.println(Jsons.LONG_TO_STR_GSON.toJson(event));
                    }
                })
                .onMessageReceiveV1(new ImService.MessageReceiveEventHandler() {
                    @Override
                    public void handle(MessageReceiveEvent event) throws Exception {
                        System.out.println(Jsons.LONG_TO_STR_GSON.toJson(event));
                    }
                })
                .build();

        String body = "{\"schema\":\"2.0\",\"header\":{\"event_id\":\"f7984f25108f8137722bb63cee927e66\",\"event_type\":\"contact.user.created_v3\",\"app_id\":\"cli_xxxxxxxx\",\"tenant_key\":\"xxxxxxx\",\"create_time\":\"1603977298000000\",\"token\":\"v\"},\"event\":{\"object\":{\"open_id\":\"ou_7dab8a3d3cdcc9da365777c7ad535d62\",\"union_id\":\"on_576833b917gda3d939b9a3c2d53e72c8\",\"user_id\":\"e33ggbyz\",\"name\":\"张三\",\"employee_no\":\"employee_no\"}},\"challenge\":\"1212\",\"type\":\"url_verification\"}";

        Map<String, List<String>> map = new HashMap<>();
        map.put(Constants.X_LARK_REQUEST_TIMESTAMP.toLowerCase(), Arrays.asList("timestamp"));
        map.put(Constants.X_LARK_REQUEST_NONCE.toLowerCase(), Arrays.asList("nonce"));
        String signature = eventDispatcher.calculateSignature("timestamp", "nonce", "v", body);
        map.put(Constants.X_LARK_SIGNATURE.toLowerCase(), Arrays.asList(signature));

        EventReq req = new EventReq();
        req.setHeaders(map);
        req.setBody(body.getBytes(StandardCharsets.UTF_8));

        EventResp resp = eventDispatcher.handle(req);
        assert resp != null;

    }

    @Test
    public void testProcessPlainEvent() throws Throwable {
        EventDispatcher eventDispatcher = EventDispatcher.newBuilder("v", "")
                .onUserCreatedV3(new ContactService.UserCreatedEventHandler() {
                    @Override
                    public void handle(UserCreatedEvent event) throws Exception {
                        System.out.println(Jsons.LONG_TO_STR_GSON.toJson(event));
                    }
                })
                .onMessageReceiveV1(new ImService.MessageReceiveEventHandler() {
                    @Override
                    public void handle(MessageReceiveEvent event) throws Exception {
                        System.out.println(Jsons.LONG_TO_STR_GSON.toJson(event));
                    }
                })
                .build();

        String body = "{\"schema\":\"2.0\",\"header\":{\"event_id\":\"f7984f25108f8137722bb63cee927e66\",\"event_type\":\"contact.user.created_v3\",\"app_id\":\"cli_xxxxxxxx\",\"tenant_key\":\"xxxxxxx\",\"create_time\":\"1603977298000000\",\"token\":\"v\"},\"event\":{\"object\":{\"open_id\":\"ou_7dab8a3d3cdcc9da365777c7ad535d62\",\"union_id\":\"on_576833b917gda3d939b9a3c2d53e72c8\",\"user_id\":\"e33ggbyz\",\"name\":\"张三\",\"employee_no\":\"employee_no\"}},\"challenge\":\"1212\",\"type\":\"\"}";

        Map<String, List<String>> map = new HashMap<>();
        map.put(Constants.X_LARK_REQUEST_TIMESTAMP.toLowerCase(), Arrays.asList("timestamp"));
        map.put(Constants.X_LARK_REQUEST_NONCE.toLowerCase(), Arrays.asList("nonce"));
        String signature = eventDispatcher.calculateSignature("timestamp", "nonce", "v", body);
        map.put(Constants.X_LARK_SIGNATURE.toLowerCase(), Arrays.asList(signature));

        EventReq req = new EventReq();
        req.setHeaders(map);
        req.setBody(body.getBytes(StandardCharsets.UTF_8));

        EventResp resp = eventDispatcher.handle(req);
        assert resp != null;

    }


    @Test
    public void testProcessEncyEvent() throws Throwable {
        EventDispatcher eventDispatcher = EventDispatcher.newBuilder("v", "1212121212")
                .onUserCreatedV3(new ContactService.UserCreatedEventHandler() {
                    @Override
                    public void handle(UserCreatedEvent event) throws Exception {
                        System.out.println(Jsons.LONG_TO_STR_GSON.toJson(event));
                    }
                })
                .onMessageReceiveV1(new ImService.MessageReceiveEventHandler() {
                    @Override
                    public void handle(MessageReceiveEvent event) throws Exception {
                        System.out.println(Jsons.LONG_TO_STR_GSON.toJson(event));
                    }
                })
                .build();

        String body = "{\"encrypt\":\"4T4ivT/PR2APX9OYkhRKtu54s1rtIpj9xJU69Hs1yWQ/1RutbufsBs9xjx5YC3u/0hMRF49sN0kevQiEL8iB3bVEdpfyJXzXGDfKUjvKQTmG64GbMdTW6qRpadVPem3f32jHuT6fc+4TRg4BigwoUId+l/D+vcIwu3mDgAEbaqzWfmvccmpiRMfQbh9JhdK/akmrRjo/CXPLM+hZciFXJMSpKueV3SjZJoSls5y0ZTHC8zak/Mp/DSl1wa4mYe5laP367Lnl4ylGiXBKx3Ku29oWv79rYcO/5QT63H4rkl8bwYmAzScpb2KNnV11L3xiDzJp3hFdfXczUvm93FXu4Lw8eDAsRzIWCccKrqHh0UvtDJD95tNn6LvYew4+Xbk1RD4k7UzWJS9AMobOK778NLNxfQ+Kn7MKzBHilXnSIVY5V+dcsOOdfqJviW4yWmT73JHYKq1qJip7Cw7lbkmRMUmettUwdVFWxeXH6iTex3YXCgqoriCx/MzeQhdNEycipooB/vHItRt1CF44uFWj9tf8n3TdbdH4dNMD0hw8ejHJSbEHb9HAGCugUniN8BzL9wxE959JU4cu3BKjDuIk5oS9hLR1mSc3vKBuSa3VKOE=\"}";

        Map<String, List<String>> map = new HashMap<>();
        map.put(Constants.X_LARK_REQUEST_TIMESTAMP.toLowerCase(), Arrays.asList("timestamp"));
        map.put(Constants.X_LARK_REQUEST_NONCE.toLowerCase(), Arrays.asList("nonce"));
        String signature = eventDispatcher.calculateSignature("timestamp", "nonce", "1212121212", body);
        map.put(Constants.X_LARK_SIGNATURE.toLowerCase(), Arrays.asList(signature));

        EventReq req = new EventReq();
        req.setHeaders(map);
        req.setBody(body.getBytes(StandardCharsets.UTF_8));

        EventResp resp = eventDispatcher.handle(req);
        assert resp != null;

    }
}
