package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.UnbindDepartmentChatDepartmentReq;
import com.lark.oapi.service.contact.v3.model.UnbindDepartmentChatDepartmentReqBody;
import com.lark.oapi.service.contact.v3.model.UnbindDepartmentChatDepartmentResp;

// POST /open-apis/contact/v3/departments/unbind_department_chat
public class UnbindDepartmentChatDepartmentSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    UnbindDepartmentChatDepartmentReq req = UnbindDepartmentChatDepartmentReq.newBuilder()
        .departmentIdType("open_department_id")
        .unbindDepartmentChatDepartmentReqBody(UnbindDepartmentChatDepartmentReqBody.newBuilder()
            .departmentId("od-4e6ac4d14bcd5071a37a39de902c7141")
            .build())
        .build();

    // 发起请求
    UnbindDepartmentChatDepartmentResp resp = client.contact().department()
        .unbindDepartmentChat(req);

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