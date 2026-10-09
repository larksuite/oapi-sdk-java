package com.lark.oapi.sample.apiall.agentv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.agent.v1.model.*;

// GET /open-apis/agent/v1/sessions/:session_id/messages
public class ListSessionMessageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListSessionMessageReq req =
                ListSessionMessageReq.newBuilder()
                        .sessionId("7442600000000000001")
                        .pageSize(20)
                        .pageToken(
                                "GxmvlNRvP0NdQZpa7yIqf_Lv_QuBwTQ8tXkX7w-irAghVD_TvuYd1aoJ1LQph86O-XImC4X9j9FhUPhXQDvtrQ==")
                        .order("desc")
                        .build();

        // 发起请求
        ListSessionMessageResp resp = client.agent().v1().sessionMessage().list(req);

        // 处理服务端错误
        if (!resp.success()) {
            System.out.println(
                    String.format(
                            "code:%s,msg:%s,reqId:%s",
                            resp.getCode(), resp.getMsg(), resp.getRequestId()));
            return;
        }

        // 业务数据处理
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
    }
}
