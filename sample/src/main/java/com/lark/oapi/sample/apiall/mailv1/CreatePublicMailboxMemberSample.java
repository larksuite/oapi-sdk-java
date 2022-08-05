package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.CreatePublicMailboxMemberReq;
import com.lark.oapi.service.mail.v1.model.CreatePublicMailboxMemberResp;
import com.lark.oapi.service.mail.v1.model.PublicMailboxMember;

// HTTP PATH: /open-apis/mail/v1/public_mailboxes/:public_mailbox_id/members"
public class CreatePublicMailboxMemberSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreatePublicMailboxMemberReq req = CreatePublicMailboxMemberReq.newBuilder()
        .publicMailboxId("xxxxxxxxxxxxxxx or test_public_mailbox@xxx.xx")
        .userIdType("user_id")
        .publicMailboxMember(PublicMailboxMember.newBuilder()
            .userId("xxxxxxxxxx")
            .type("USER")
            .build())
        .build();

    // 发起请求
    CreatePublicMailboxMemberResp resp = client.mail().publicMailboxMember().create(req);

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
