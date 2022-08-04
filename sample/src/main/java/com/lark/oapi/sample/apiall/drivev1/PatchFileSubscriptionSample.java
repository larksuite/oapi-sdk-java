package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.PatchFileSubscriptionReq;
import com.lark.oapi.service.drive.v1.model.PatchFileSubscriptionReqBody;
import com.lark.oapi.service.drive.v1.model.PatchFileSubscriptionResp;

// HTTP PATH: /open-apis/drive/v1/files/:file_token/subscriptions/:subscription_id"
public class PatchFileSubscriptionSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    PatchFileSubscriptionReq req = PatchFileSubscriptionReq.newBuilder()
        .fileToken("doxcnxxxxxxxxxxxxxxxxxxxxxx")
        .subscriptionId("1234567890987654321")
        .patchFileSubscriptionReqBody(PatchFileSubscriptionReqBody.newBuilder()
            .isSubscribe(true)
            .fileType("doc")
            .build())
        .build();

    // 发起请求
    PatchFileSubscriptionResp resp = client.drive().fileSubscription().patch(req);

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
