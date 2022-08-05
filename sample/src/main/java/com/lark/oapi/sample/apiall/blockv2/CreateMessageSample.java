package com.lark.oapi.sample.apiall.blockv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.block.v2.model.CreateMessageReq;
import com.lark.oapi.service.block.v2.model.CreateMessageResp;
import com.lark.oapi.service.block.v2.model.Message;

// HTTP PATH: /open-apis/block/v2/message"
public class CreateMessageSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateMessageReq req = CreateMessageReq.newBuilder()
        .message(Message.newBuilder()
            .body("")
            .version("1637565292196")
            .blockId("8116040162664047375")
            .resource("read_block")
            .openIds(new String[]{})
            .build())
        .build();

    // 发起请求
    CreateMessageResp resp = client.block().message().create(req);

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
