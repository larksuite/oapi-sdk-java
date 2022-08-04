package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.DeleteTicketCustomizedFieldReq;
import com.lark.oapi.service.helpdesk.v1.model.DeleteTicketCustomizedFieldResp;

// HTTP PATH: /open-apis/helpdesk/v1/ticket_customized_fields/:ticket_customized_field_id"
public class DeleteTicketCustomizedFieldSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    DeleteTicketCustomizedFieldReq req = DeleteTicketCustomizedFieldReq.newBuilder()
        .ticketCustomizedFieldId("")
        .build();

    // 发起请求
    DeleteTicketCustomizedFieldResp resp = client.helpdesk().ticketCustomizedField().delete(req);

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
