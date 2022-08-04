package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.TicketImageTicketReq;
import com.lark.oapi.service.helpdesk.v1.model.TicketImageTicketResp;

// HTTP PATH: /open-apis/helpdesk/v1/ticket_images"
public class TicketImageTicketSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    TicketImageTicketReq req = TicketImageTicketReq.newBuilder()
        .ticketId("")
        .msgId("")
        .index(0)
        .build();

    // 发起请求
    TicketImageTicketResp resp = client.helpdesk().ticket().ticketImage(req);

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
