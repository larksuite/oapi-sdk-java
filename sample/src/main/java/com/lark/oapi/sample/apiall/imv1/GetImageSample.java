package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.GetImageReq;
import com.lark.oapi.service.im.v1.model.GetImageResp;

// HTTP PATH: /open-apis/im/v1/images/:image_key"
public class GetImageSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    GetImageReq req = GetImageReq.newBuilder()
        .imageKey("img_8d5181ca-0aed-40f0-b0d1-b1452132afbg")
        .build();

    // 发起请求
    GetImageResp resp = client.im().image().get(req);

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
