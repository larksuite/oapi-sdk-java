package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.UpdateUserReq;
import com.lark.oapi.service.contact.v3.model.UpdateUserResp;

// HTTP PATH: /open-apis/contact/v3/users/:user_id"
public class UpdateUserSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    UpdateUserReq req = UpdateUserReq.newBuilder()
        .userId("")
        .userIdType("open_id")
        .departmentIdType("open_department_id")
        .build();

    // 发起请求
    UpdateUserResp resp = client.contact().user().update(req);

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
