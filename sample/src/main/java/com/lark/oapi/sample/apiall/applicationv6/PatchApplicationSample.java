package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.Application;
import com.lark.oapi.service.application.v6.model.PatchApplicationReq;
import com.lark.oapi.service.application.v6.model.PatchApplicationResp;

// HTTP PATH: /open-apis/application/v6/applications/:app_id"
public class PatchApplicationSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    PatchApplicationReq req = PatchApplicationReq.newBuilder()
        .appId("cli_9b445f5258795107")
        .lang("zh_cn")
        .application(Application.newBuilder()
            .commonCategories(new String[]{})
            .build())
        .build();

    // 发起请求
    PatchApplicationResp resp = client.application().application().patch(req);

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
