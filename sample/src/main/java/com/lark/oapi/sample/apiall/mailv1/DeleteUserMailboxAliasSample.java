package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.DeleteUserMailboxAliasReq;
import com.lark.oapi.service.mail.v1.model.DeleteUserMailboxAliasResp;

// DELETE /open-apis/mail/v1/user_mailboxes/:user_mailbox_id/aliases/:alias_id
public class DeleteUserMailboxAliasSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    DeleteUserMailboxAliasReq req = DeleteUserMailboxAliasReq.newBuilder()
        .userMailboxId("user@xxx.xx")
        .aliasId("user_alias@xxx.xx")
        .build();

    // 发起请求
    DeleteUserMailboxAliasResp resp = client.mail().userMailboxAlias().delete(req);

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
