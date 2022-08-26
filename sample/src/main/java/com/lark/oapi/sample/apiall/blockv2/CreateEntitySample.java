package com.lark.oapi.sample.apiall.blockv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.block.v2.model.CreateEntityReq;
import com.lark.oapi.service.block.v2.model.CreateEntityReqBody;
import com.lark.oapi.service.block.v2.model.CreateEntityResp;

// POST /open-apis/block/v2/entities
public class CreateEntitySample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateEntityReq req = CreateEntityReq.newBuilder()
        .createEntityReqBody(CreateEntityReqBody.newBuilder()
            .title("已阅block")
            .blockTypeId("blk_614c1c952f800014b27f87d6")
            .sourceData("")
            .sourceMeta("")
            .version("1")
            .sourceLink("")
            .owner("ou_fa7aa170f92d1615de63371ac425a767")
            .extra("{}")
            .i18nSummary("")
            .i18nPreview("")
            .summary("")
            .preview("")
            .build())
        .build();

    // 发起请求
    CreateEntityResp resp = client.block().entity().create(req);

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
