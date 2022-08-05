package com.lark.oapi.sample.apiall.adminv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.admin.v1.model.CreateBadgeGrantReq;
import com.lark.oapi.service.admin.v1.model.CreateBadgeGrantResp;
import com.lark.oapi.service.admin.v1.model.Grant;
import com.lark.oapi.service.admin.v1.model.RuleDetail;

// HTTP PATH: /open-apis/admin/v1/badges/:badge_id/grants"
public class CreateBadgeGrantSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateBadgeGrantReq req = CreateBadgeGrantReq.newBuilder()
        .badgeId("m_DjMzaK")
        .userIdType("open_id")
        .departmentIdType("open_department_id")
        .grant(Grant.newBuilder()
            .name("激励勋章的授予名单")
            .grantType(0)
            .timeZone("Asia/Shanghai")
            .ruleDetail(RuleDetail.newBuilder().build())
            .isGrantAll(false)
            .userIds(new String[]{})
            .departmentIds(new String[]{})
            .groupIds(new String[]{})
            .build())
        .build();

    // 发起请求
    CreateBadgeGrantResp resp = client.admin().badgeGrant().create(req);

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
