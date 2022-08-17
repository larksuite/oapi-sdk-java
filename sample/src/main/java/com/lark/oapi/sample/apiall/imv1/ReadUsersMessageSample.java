package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.ReadUsersMessageReq;
import com.lark.oapi.service.im.v1.model.ReadUsersMessageResp;

// HTTP PATH: /open-apis/im/v1/messages/:message_id/read_users"
public class ReadUsersMessageSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("cli_a1eccc36c278900d", "uvNOxS6mplA6Nf3YPt8rUbbShON1Ocj5").build();

    // 创建请求对象
    ReadUsersMessageReq req = ReadUsersMessageReq.newBuilder()
        .messageId("om_7f7592e6b9f130ff575a9da9c3d7d506")
        .userIdType("open_id")
        .pageSize(0)
        .build();

    // 发起请求
    ReadUsersMessageResp resp = client.im().message().readUsers(req);

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
