package com.lark.oapi.sample.apiall.adminv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.admin.v1.model.ListBadgeGrantReq;
import com.lark.oapi.service.admin.v1.model.ListBadgeGrantResp;

// GET /open-apis/admin/v1/badges/:badge_id/grants
public class ListBadgeGrantSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    ListBadgeGrantReq req = ListBadgeGrantReq.newBuilder()
        .badgeId("m_DjMzaK")
        .pageSize(10)
        .pageToken("om5fn1")
        .userIdType("open_id")
        .departmentIdType("open_department_id")
        .build();

    // 发起请求
    ListBadgeGrantResp resp = client.admin().badgeGrant().list(req);

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
