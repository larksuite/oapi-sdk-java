package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.GetExportReq;
import com.lark.oapi.service.vc.v1.model.GetExportResp;

// GET /open-apis/vc/v1/exports/:task_id
public class GetExportSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    GetExportReq req = GetExportReq.newBuilder()
        .taskId("7108646852144136212")
        .build();

    // 发起请求
    GetExportResp resp = client.vc().export().get(req);

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
