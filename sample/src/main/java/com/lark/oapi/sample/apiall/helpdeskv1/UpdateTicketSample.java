package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.*;

import java.util.HashMap;

// PUT /open-apis/helpdesk/v1/tickets/:ticket_id
public class UpdateTicketSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateTicketReq req = UpdateTicketReq.newBuilder()
                .ticketId("6945345902185807891")
                .updateTicketReqBody(UpdateTicketReqBody.newBuilder()
                        .status(1)
                        .tagNames(new String[]{})
                        .comment("good")
                        .customizedFields(new CustomizedFieldDisplayItem[]{})
                        .ticketType(1)
                        .solved(1)
                        .channel(1)
                        .build())
                .build();

        // 发起请求
        UpdateTicketResp resp = client.helpdesk().v1().ticket().update(req);

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
