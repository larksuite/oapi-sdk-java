package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.IsInChatChatMembersReq;
import com.lark.oapi.service.im.v1.model.IsInChatChatMembersResp;

// HTTP PATH: /open-apis/im/v1/chats/:chat_id/members/is_in_chat"
public class IsInChatChatMembersSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    IsInChatChatMembersReq req = IsInChatChatMembersReq.newBuilder()
        .chatId("oc_a0553eda9014c201e6969b478895c230")
        .build();

    // 发起请求
    IsInChatChatMembersResp resp = client.im().chatMembers().isInChat(req);

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