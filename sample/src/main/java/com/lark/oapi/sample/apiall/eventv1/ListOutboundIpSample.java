package com.lark.oapi.sample.apiall.eventv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.event.v1.model.ListOutboundIpReq;
import com.lark.oapi.service.event.v1.model.ListOutboundIpResp;

// GET /open-apis/event/v1/outbound_ip
public class ListOutboundIpSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListOutboundIpReq req = ListOutboundIpReq.newBuilder()
                .pageSize(10)
                .pageToken("xxx")
                .build();

        // 发起请求
        ListOutboundIpResp resp = client.event().outboundIp().list(req);

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
