package com.lark.oapi.sample.ws;

import com.lark.oapi.core.request.EventReq;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.event.CustomEventHandler;
import com.lark.oapi.event.EventDispatcher;
import com.lark.oapi.service.im.ImService;
import com.lark.oapi.service.im.v1.model.P2MessageReceiveV1;
import com.lark.oapi.ws.Client;

import java.nio.charset.StandardCharsets;

public class Sample {
    private static final EventDispatcher EVENT_HANDLER = EventDispatcher.newBuilder("", "")  // 长连接不需要这两个参数，请保持空字符串
            .onP2MessageReceiveV1(new ImService.P2MessageReceiveV1Handler() {
                @Override
                public void handle(P2MessageReceiveV1 event) throws Exception {
                    System.out.printf("[ onP2MessageReceiveV1 access ], data: %s\n", Jsons.DEFAULT.toJson(event.getEvent()));
                }
            })
            .onCustomizedEvent("这里填入你要自定义订阅的 event 的 key,例如 out_approval", new CustomEventHandler() {
                // 对于一些老事件、找不到上述结构化定义的事件，需要自行使用这种 onCustomizedEvent 的方式去订阅
                @Override
                public void handle(EventReq event) throws Exception {
                    System.out.printf("[ onCustomizedEvent access ], type: message, data: %s\n", new String(event.getBody(), StandardCharsets.UTF_8));
                }
            })
            .build();

    public static void main(String[] args) {
        Client client = new Client.Builder("YOUR_APP_ID", "YOUR_APP_SECRET")
                .eventHandler(EVENT_HANDLER)
                .build();
        client.start();
    }
}
