package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.CustomizedFieldDisplayItem;
import com.lark.oapi.service.helpdesk.v1.model.UpdateTicketReq;
import com.lark.oapi.service.helpdesk.v1.model.UpdateTicketReqBody;
import com.lark.oapi.service.helpdesk.v1.model.UpdateTicketResp;

// HTTP PATH: /open-apis/helpdesk/v1/tickets/:ticket_id"
public class UpdateTicketSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    UpdateTicketReq req = UpdateTicketReq.newBuilder()
        .ticketId("")
        .updateTicketReqBody(UpdateTicketReqBody.newBuilder()
            .status(0)
            .tagNames(new String[]{})
            .comment("")
            .customizedFields(new CustomizedFieldDisplayItem[]{})
            .ticketType(0)
            .solved(0)
            .channel(0)
            .build())
        .build();

    // 发起请求
    UpdateTicketResp resp = client.helpdesk().ticket().update(req);

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
