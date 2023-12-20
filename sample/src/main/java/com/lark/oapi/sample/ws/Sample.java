package com.lark.oapi.sample.ws;

import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.event.EventDispatcher;
import com.lark.oapi.service.im.ImService;
import com.lark.oapi.service.im.v1.model.P2MessageReceiveV1;
import com.lark.oapi.ws.Client;

public class Sample {

    private static final EventDispatcher EVENT_HANDLER = EventDispatcher.newBuilder("", "")
            .onP2MessageReceiveV1(new ImService.P2MessageReceiveV1Handler() {
                @Override
                public void handle(P2MessageReceiveV1 event) throws Exception {
                    System.out.println(Jsons.DEFAULT.toJson(event));
                }
            })
            .build();

    public static void main(String[] args) {
        Client client = new Client.Builder("cli_a435f588bd7e900b", "a0PbblLQRjHcVcbhHNpMAfIIsdSBXENQ")
                .eventHandler(EVENT_HANDLER)
                .build();
        client.start();
    }
}
