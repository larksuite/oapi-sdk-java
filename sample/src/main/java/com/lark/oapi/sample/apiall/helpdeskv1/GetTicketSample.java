package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.GetTicketReq;
import com.lark.oapi.service.helpdesk.v1.model.GetTicketResp;

// GET /open-apis/helpdesk/v1/tickets/:ticket_id
public class GetTicketSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetTicketReq req = GetTicketReq.newBuilder()
                .ticketId("123456")
                .build();

        // 发起请求
        GetTicketResp resp = client.helpdesk().ticket().get(req);

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
