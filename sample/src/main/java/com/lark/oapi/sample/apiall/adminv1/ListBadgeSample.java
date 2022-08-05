package com.lark.oapi.sample.apiall.adminv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.admin.v1.model.ListBadgeReq;
import com.lark.oapi.service.admin.v1.model.ListBadgeResp;

// HTTP PATH: /open-apis/admin/v1/badges"
public class ListBadgeSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    ListBadgeReq req = ListBadgeReq.newBuilder()
        .pageSize(10)
        .pageToken("b1fmUz")
        .name("激励勋章")
        .build();

    // 发起请求
    ListBadgeResp resp = client.admin().badge().list(req);

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
