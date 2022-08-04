package com.lark.oapi.sample.apiall.ehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.ehr.v1.model.GetAttachmentReq;
import com.lark.oapi.service.ehr.v1.model.GetAttachmentResp;

// HTTP PATH: /open-apis/ehr/v1/attachments/:token"
public class GetAttachmentSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    GetAttachmentReq req = GetAttachmentReq.newBuilder()
        .token("")
        .build();

    // 发起请求
    GetAttachmentResp resp = client.ehr().attachment().get(req);

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
