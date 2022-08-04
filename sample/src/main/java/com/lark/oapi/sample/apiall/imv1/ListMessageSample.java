package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.ListMessageReq;
import com.lark.oapi.service.im.v1.model.ListMessageResp;

// HTTP PATH: /open-apis/im/v1/messages"
public class ListMessageSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    ListMessageReq req = ListMessageReq.newBuilder()
        .containerIdType("chat")
        .containerId("oc_234jsi43d3ssi993d43545f")
        .startTime("1609296809")
        .endTime("1608594809")
        .pageToken("")
        .pageSize(20)
        .build();

    // 发起请求
    ListMessageResp resp = client.im().message().list(req);

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
