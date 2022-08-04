package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.GetPermissionPublicReq;
import com.lark.oapi.service.drive.v1.model.GetPermissionPublicResp;

// HTTP PATH: /open-apis/drive/v1/permissions/:token/public"
public class GetPermissionPublicSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    GetPermissionPublicReq req = GetPermissionPublicReq.newBuilder()
        .token("")
        .type("doc")
        .build();

    // 发起请求
    GetPermissionPublicResp resp = client.drive().permissionPublic().get(req);

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
