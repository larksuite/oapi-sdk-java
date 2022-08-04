package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.GetInstanceReq;
import com.lark.oapi.service.approval.v4.model.GetInstanceResp;

// HTTP PATH: /open-apis/approval/v4/instances/:instance_id"
public class GetInstanceSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    GetInstanceReq req = GetInstanceReq.newBuilder()
        .instanceId("81D31358-93AF-92D6-7425-01A5D67C4E71")
        .locale("zh-CN")
        .userId("f7cb567e")
        .userIdType("user_id")
        .build();

    // 发起请求
    GetInstanceResp resp = client.approval().instance().get(req);

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
