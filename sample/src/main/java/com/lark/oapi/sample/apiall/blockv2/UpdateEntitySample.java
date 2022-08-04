package com.lark.oapi.sample.apiall.blockv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.block.v2.model.UpdateEntityReq;
import com.lark.oapi.service.block.v2.model.UpdateEntityResp;

// HTTP PATH: /open-apis/block/v2/entities/:block_id"
public class UpdateEntitySample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    UpdateEntityReq req = UpdateEntityReq.newBuilder()
        .blockId("7794641623571830467")
        .build();

    // 发起请求
    UpdateEntityResp resp = client.block().entity().update(req);

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
