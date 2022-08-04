package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.DeleteUserReq;
import com.lark.oapi.service.contact.v3.model.DeleteUserReqBody;
import com.lark.oapi.service.contact.v3.model.DeleteUserResp;

// HTTP PATH: /open-apis/contact/v3/users/:user_id"
public class DeleteUserSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    DeleteUserReq req = DeleteUserReq.newBuilder()
        .userId("")
        .userIdType("open_id")
        .deleteUserReqBody(DeleteUserReqBody.newBuilder()
            .departmentChatAcceptorUserId("")
            .externalChatAcceptorUserId("")
            .docsAcceptorUserId("")
            .calendarAcceptorUserId("")
            .applicationAcceptorUserId("")
            .helpdeskAcceptorUserId("")
            .build())
        .build();

    // 发起请求
    DeleteUserResp resp = client.contact().user().delete(req);

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
