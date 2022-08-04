package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.SearchChatReq;
import com.lark.oapi.service.im.v1.model.SearchChatResp;

// HTTP PATH: /open-apis/im/v1/chats/search"
public class SearchChatSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    SearchChatReq req = SearchChatReq.newBuilder()
        .userIdType("user_id")
        .query("abc")
        .pageToken("")
        .pageSize(20)
        .build();

    // 发起请求
    SearchChatResp resp = client.im().chat().search(req);

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
