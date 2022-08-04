package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.ListTicketReq;
import com.lark.oapi.service.helpdesk.v1.model.ListTicketResp;

// HTTP PATH: /open-apis/helpdesk/v1/tickets"
public class ListTicketSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    ListTicketReq req = ListTicketReq.newBuilder()
        .ticketId("")
        .agentId("")
        .closedById("")
        .type(0)
        .channel(0)
        .solved(0)
        .score(0)
        .statusList(new Integer[]{})
        .guestName("")
        .guestId("")
        .tags(new String[]{})
        .page(0)
        .pageSize(0)
        .createTimeStart(0)
        .createTimeEnd(0)
        .updateTimeStart(0)
        .updateTimeEnd(0)
        .build();

    // 发起请求
    ListTicketResp resp = client.helpdesk().ticket().list(req);

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
