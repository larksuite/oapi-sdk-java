package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.Event;
import com.lark.oapi.service.helpdesk.v1.model.SubscribeEventReq;
import com.lark.oapi.service.helpdesk.v1.model.SubscribeEventReqBody;
import com.lark.oapi.service.helpdesk.v1.model.SubscribeEventResp;

// POST /open-apis/helpdesk/v1/events/subscribe
public class SubscribeEventSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SubscribeEventReq req = SubscribeEventReq.newBuilder()
                .subscribeEventReqBody(SubscribeEventReqBody.newBuilder()
                        .events(new Event[]{})
                        .build())
                .build();

        // 发起请求
        SubscribeEventResp resp = client.helpdesk().v1().event().subscribe(req);

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
