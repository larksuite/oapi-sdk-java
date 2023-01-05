/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.event;

import com.lark.oapi.core.Constants;
import com.lark.oapi.core.request.EventReq;
import com.lark.oapi.core.response.EventResp;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.ContactService;
import com.lark.oapi.service.contact.v3.model.P2UserCreatedV3;
import com.lark.oapi.service.im.v1.ImService;
import com.lark.oapi.service.im.v1.model.P1MessageReadV1;
import com.lark.oapi.service.im.v1.model.P2MessageReceiveV1;
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
                .onP2UserCreatedV3(new ContactService.P2UserCreatedV3Handler() {
                    @Override
                    public void handle(P2UserCreatedV3 event) {
                        System.out.println(Jsons.DEFAULT.toJson(event));
                    }
                })
                .onP2MessageReceiveV1(new ImService.P2MessageReceiveV1Handler() {
                    @Override
                    public void handle(P2MessageReceiveV1 event) {
                        System.out.println(Jsons.DEFAULT.toJson(event));
                        System.out.println(event.getRequestId());
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
                .onP2UserCreatedV3(new ContactService.P2UserCreatedV3Handler() {
                    @Override
                    public void handle(P2UserCreatedV3 event) {
                        System.out.println(Jsons.DEFAULT.toJson(event));
                    }
                })
                .onP2MessageReceiveV1(new ImService.P2MessageReceiveV1Handler() {
                    @Override
                    public void handle(P2MessageReceiveV1 event) {
                        System.out.println(Jsons.DEFAULT.toJson(event));
                    }
                })
                .onCustomizedEvent("custom_event_type", new CustomEventHandler() {
                    @Override
                    public void handle(EventReq event) {
                        System.out.println("headers:" + Jsons.DEFAULT.toJson(event.getHeaders()));
                        System.out.println("body:" + new String(event.getBody()));
                        System.out.println("reqId:" + event.getRequestID());
                        System.out.println("path:" + event.getHttpPath());
                    }
                })
                .onP1MessageReadV1(new ImService.P1MessageReadV1Handler() {
                    @Override
                    public void handle(P1MessageReadV1 event) {
                        System.out.println(Jsons.DEFAULT.toJson(event));
                    }
                })
                .build();

        String body = "{\"schema\":\"2.0\",\"header\":{\"event_id\":\"f7984f25108f8137722bb63cee927e66\",\"event_type\":\"custom_event_type\",\"app_id\":\"cli_xxxxxxxx\",\"tenant_key\":\"xxxxxxx\",\"create_time\":\"1603977298000000\",\"token\":\"v\"},\"event\":{\"object\":{\"open_id\":\"ou_7dab8a3d3cdcc9da365777c7ad535d62\",\"union_id\":\"on_576833b917gda3d939b9a3c2d53e72c8\",\"user_id\":\"e33ggbyz\",\"name\":\"张三\",\"employee_no\":\"employee_no\"}},\"challenge\":\"1212\",\"type\":\"\"}";

        Map<String, List<String>> map = new HashMap<>();
        map.put(Constants.X_LARK_REQUEST_TIMESTAMP.toLowerCase(), Arrays.asList("timestamp"));
        map.put(Constants.X_LARK_REQUEST_NONCE.toLowerCase(), Arrays.asList("nonce"));
        String signature = eventDispatcher.calculateSignature("timestamp", "nonce", "v", body);
        map.put(Constants.X_LARK_SIGNATURE.toLowerCase(), Arrays.asList(signature));
        map.put(Constants.HTTP_HEADER_KEY_LOG_ID.toLowerCase(), Arrays.asList("logixsssss"));

        EventReq req = new EventReq();
        req.setHeaders(map);
        req.setBody(body.getBytes(StandardCharsets.UTF_8));
        req.setHttpPath("wehook/event");

        EventResp resp = eventDispatcher.handle(req);
        assert resp != null;

    }

    @Test
    public void testPlainV1Event() throws Throwable {
        EventDispatcher eventDispatcher = EventDispatcher.newBuilder("v", "")
                .onP1MessageReadV1(new ImService.P1MessageReadV1Handler() {
                    @Override
                    public void handle(P1MessageReadV1 event) {
                        System.out.println(Jsons.DEFAULT.toJson(event));
                    }
                })
                .build();

        String body = "{\"ts\":\"ts\",\"uuid\":\"uuid\",\"token\":\"v\",\"type\":\"type\",\"event\":{\"message_id_list\":[\"ss\",\"dd\"],\"app_id\":\"appid\",\"open_chat_id\":\"openapiid\",\"open_id\":\"openid\",\"tenant_key\":\"tenkey\",\"type\":\"message_read\"}}";

        Map<String, List<String>> map = new HashMap<>();
        map.put(Constants.X_LARK_REQUEST_TIMESTAMP.toLowerCase(), Arrays.asList("timestamp"));
        map.put(Constants.X_LARK_REQUEST_NONCE.toLowerCase(), Arrays.asList("nonce"));
        String signature = eventDispatcher.calculateSignature("timestamp", "nonce", "v", body);
        map.put(Constants.X_LARK_SIGNATURE.toLowerCase(), Arrays.asList(signature));
        map.put(Constants.HTTP_HEADER_KEY_LOG_ID.toLowerCase(), Arrays.asList("logixsssss"));

        EventReq req = new EventReq();
        req.setHeaders(map);
        req.setBody(body.getBytes(StandardCharsets.UTF_8));
        req.setHttpPath("wehook/event");

        EventResp resp = eventDispatcher.handle(req);
        assert resp != null;

    }

    @Test
    public void testProcessEncyEvent() throws Throwable {
        EventDispatcher eventDispatcher = EventDispatcher.newBuilder("v", "1212121212")
                .onP2UserCreatedV3(new ContactService.P2UserCreatedV3Handler() {
                    @Override
                    public void handle(P2UserCreatedV3 event) {
                        System.out.println(Jsons.DEFAULT.toJson(event));
                    }
                })
                .onP2MessageReceiveV1(new ImService.P2MessageReceiveV1Handler() {
                    @Override
                    public void handle(P2MessageReceiveV1 event) {
                        System.out.println(Jsons.DEFAULT.toJson(event));
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
