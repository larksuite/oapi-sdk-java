package com.lark.oapi.sample.apiall.adminv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.admin.v1.model.GetBadgeGrantReq;
import com.lark.oapi.service.admin.v1.model.GetBadgeGrantResp;

// HTTP PATH: /open-apis/admin/v1/badges/:badge_id/grants/:grant_id"
public class GetBadgeGrantSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    GetBadgeGrantReq req = GetBadgeGrantReq.newBuilder()
        .badgeId("m_DjMzaK")
        .grantId("g_uS4yux")
        .userIdType("open_id")
        .departmentIdType("open_department_id")
        .build();

    // 发起请求
    GetBadgeGrantResp resp = client.admin().badgeGrant().get(req);

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
