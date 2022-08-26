package com.lark.oapi.sample.apiall.adminv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.admin.v1.model.Grant;
import com.lark.oapi.service.admin.v1.model.RuleDetail;
import com.lark.oapi.service.admin.v1.model.UpdateBadgeGrantReq;
import com.lark.oapi.service.admin.v1.model.UpdateBadgeGrantResp;

// PUT /open-apis/admin/v1/badges/:badge_id/grants/:grant_id
public class UpdateBadgeGrantSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    UpdateBadgeGrantReq req = UpdateBadgeGrantReq.newBuilder()
        .badgeId("m_DjMzaK")
        .grantId("g_uS4yux")
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
    UpdateBadgeGrantResp resp = client.admin().badgeGrant().update(req);

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
