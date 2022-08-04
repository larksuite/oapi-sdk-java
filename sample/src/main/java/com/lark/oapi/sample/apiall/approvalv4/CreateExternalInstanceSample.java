package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.CreateExternalInstanceReq;
import com.lark.oapi.service.approval.v4.model.CreateExternalInstanceResp;

// HTTP PATH: /open-apis/approval/v4/external_instances"
public class CreateExternalInstanceSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateExternalInstanceReq req = CreateExternalInstanceReq.newBuilder()
        .build();

    // 发起请求
    CreateExternalInstanceResp resp = client.approval().externalInstance().create(req);

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
