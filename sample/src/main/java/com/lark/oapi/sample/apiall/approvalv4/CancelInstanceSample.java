package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.CancelInstanceReq;
import com.lark.oapi.service.approval.v4.model.CancelInstanceResp;

// HTTP PATH: /open-apis/approval/v4/instances/cancel"
public class CancelInstanceSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CancelInstanceReq req = CancelInstanceReq.newBuilder()
        .userIdType("user_id")
        .build();

    // 发起请求
    CancelInstanceResp resp = client.approval().instance().cancel(req);

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
