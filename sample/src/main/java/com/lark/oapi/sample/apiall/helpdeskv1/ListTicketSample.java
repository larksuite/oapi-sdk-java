package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.ListTicketReq;
import com.lark.oapi.service.helpdesk.v1.model.ListTicketResp;

// GET /open-apis/helpdesk/v1/tickets
public class ListTicketSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListTicketReq req = ListTicketReq.newBuilder()
                .ticketId("123456")
                .agentId("ou_b5de90429xxx")
                .closedById("ou_b5de90429xxx")
                .type(1)
                .channel(0)
                .solved(1)
                .score(1)
                .statusList(new Integer[]{})
                .guestName("abc")
                .guestId("ou_b5de90429xxx")
                .tags(new String[]{})
                .page(1)
                .pageSize(20)
                .createTimeStart(0)
                .createTimeEnd(0)
                .updateTimeStart(0)
                .updateTimeEnd(0)
                .build();

        // 发起请求
        ListTicketResp resp = client.helpdesk().v1().ticket().list(req);

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
