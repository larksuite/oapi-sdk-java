package com.lark.oapi.sample.apiall.gray_test_open_sgv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.gray_test_open_sg.v1.model.GetMotoReq;
import com.lark.oapi.service.gray_test_open_sg.v1.model.GetMotoResp;

// HTTP PATH: /open-apis/gray_test_open_sg/v1/motos/:moto_id"
public class GetMotoSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    GetMotoReq req = GetMotoReq.newBuilder()
        .motoId("")
        .bodyLevel("")
        .build();

    // 发起请求
    GetMotoResp resp = client.grayTestOpenSg().moto().get(req);

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
