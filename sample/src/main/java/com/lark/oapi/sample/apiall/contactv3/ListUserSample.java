package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.ListUserReq;
import com.lark.oapi.service.contact.v3.model.ListUserResp;

// HTTP PATH: /open-apis/contact/v3/users"
public class ListUserSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    ListUserReq req = ListUserReq.newBuilder()
        .userIdType("open_id")
        .departmentIdType("open_department_id")
        .departmentId("")
        .pageToken("")
        .pageSize(20)
        .build();

    // 发起请求
    ListUserResp resp = client.contact().user().list(req);

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
