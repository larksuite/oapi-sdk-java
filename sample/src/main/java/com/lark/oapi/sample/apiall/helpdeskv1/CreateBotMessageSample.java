package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.BotMessage;
import com.lark.oapi.service.helpdesk.v1.model.CreateBotMessageReq;
import com.lark.oapi.service.helpdesk.v1.model.CreateBotMessageResp;

// POST /open-apis/helpdesk/v1/message
public class CreateBotMessageSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateBotMessageReq req = CreateBotMessageReq.newBuilder()
        .userIdType("user_id")
        .botMessage(BotMessage.newBuilder()
            .msgType("post")
            .content("")
            .receiverId("ou_7346484524")
            .receiveType("chat")
            .build())
        .build();

    // 发起请求
    CreateBotMessageResp resp = client.helpdesk().botMessage().create(req);

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
