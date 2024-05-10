package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.*;

import java.util.HashMap;

// POST /open-apis/helpdesk/v1/start_service
public class StartServiceTicketSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        StartServiceTicketReq req = StartServiceTicketReq.newBuilder()
                .startServiceTicketReqBody(StartServiceTicketReqBody.newBuilder()
                        .humanService(false)
                        .appointedAgents(new String[]{})
                        .openId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
                        .customizedInfo("测试自定义字段信息")
                        .build())
                .build();

        // 发起请求
        StartServiceTicketResp resp = client.helpdesk().v1().ticket().startService(req);

        // 处理服务端错误
        if (!resp.success()) {
            System.out.println(String.format("code:%s,msg:%s,reqId:%s"
                    , resp.getCode(), resp.getMsg(), resp.getRequestId()));
            return;
        }

        // 业务数据处理
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
    }
}
