package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.DeleteUserReq;
import com.lark.oapi.service.contact.v3.model.DeleteUserReqBody;
import com.lark.oapi.service.contact.v3.model.DeleteUserResp;
import com.lark.oapi.service.contact.v3.model.ResourceAcceptor;

// DELETE /open-apis/contact/v3/users/:user_id
public class DeleteUserSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    DeleteUserReq req = DeleteUserReq.newBuilder()
        .userId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
        .userIdType("open_id")
        .deleteUserReqBody(DeleteUserReqBody.newBuilder()
            .departmentChatAcceptorUserId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
            .externalChatAcceptorUserId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
            .docsAcceptorUserId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
            .calendarAcceptorUserId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
            .applicationAcceptorUserId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
            .helpdeskAcceptorUserId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
            .minutesAcceptorUserId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
            .surveyAcceptorUserId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
            .emailAcceptor(ResourceAcceptor.newBuilder().build())
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
