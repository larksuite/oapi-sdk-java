package com.lark.oapi.sample.apiall.searchv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.search.v2.model.PatchSchemaReq;
import com.lark.oapi.service.search.v2.model.PatchSchemaReqBody;
import com.lark.oapi.service.search.v2.model.PatchSchemaResp;
import com.lark.oapi.service.search.v2.model.SchemaDisplay;

// HTTP PATH: /open-apis/search/v2/schemas/:schema_id"
public class PatchSchemaSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    PatchSchemaReq req = PatchSchemaReq.newBuilder()
        .schemaId("custom_schema_id")
        .patchSchemaReqBody(PatchSchemaReqBody.newBuilder()
            .display(SchemaDisplay.newBuilder().build())
            .build())
        .build();

    // 发起请求
    PatchSchemaResp resp = client.search().schema().patch(req);

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
