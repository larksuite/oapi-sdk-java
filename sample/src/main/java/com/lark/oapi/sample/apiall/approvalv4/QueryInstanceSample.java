package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.InstanceSearch;
import com.lark.oapi.service.approval.v4.model.QueryInstanceReq;
import com.lark.oapi.service.approval.v4.model.QueryInstanceResp;

// HTTP PATH: /open-apis/approval/v4/instances/query"
public class QueryInstanceSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    QueryInstanceReq req = QueryInstanceReq.newBuilder()
        .pageSize(100)
        .pageToken("nF1ZXJ5VGhlbkZldGNoCgAAAAAA6PZwFmUzSldvTC1yU")
        .userIdType("user_id")
        .instanceSearch(InstanceSearch.newBuilder()
            .userId("lwiu098wj")
            .approvalCode("EB828003-9FFE-4B3F-AA50-2E199E2ED942")
            .instanceCode("EB828003-9FFE-4B3F-AA50-2E199E2ED943")
            .instanceExternalId("EB828003-9FFE-4B3F-AA50-2E199E2ED976")
            .groupExternalId("1234567")
            .instanceTitle("test")
            .instanceStatus("PENDING")
            .instanceStartTimeFrom("1547654251506")
            .instanceStartTimeTo("1547654251506")
            .locale("zh-CN")
            .build())
        .build();

    // 发起请求
    QueryInstanceResp resp = client.approval().instance().query(req);

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
