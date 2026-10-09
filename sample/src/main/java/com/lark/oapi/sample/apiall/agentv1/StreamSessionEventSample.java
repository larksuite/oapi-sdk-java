package com.lark.oapi.sample.apiall.agentv1;

import com.lark.oapi.Client;
import com.lark.oapi.service.agent.v1.model.*;

// GET /open-apis/agent/v1/sessions/:session_id/events/:message_id
public class StreamSessionEventSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        StreamSessionEventReq req =
                StreamSessionEventReq.newBuilder()
                        .sessionId("7442600000000000001")
                        .messageId("7442600000000000002")
                        .build();

        // 发起请求
        com.lark.oapi.core.sse.SSEStream resp = client.agent().v1().sessionEvent().stream(req);

        try (com.lark.oapi.core.sse.SSEStream stream = resp) {
            com.lark.oapi.core.sse.SSEEvent event;
            while ((event = stream.readNext()) != null) {
                System.out.println(event.getData());
            }
        }
    }
}
