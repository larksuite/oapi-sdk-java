package com.lark.oapi.sample.apiall.searchv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.search.v2.model.Acl;
import com.lark.oapi.service.search.v2.model.CreateDataSourceItemReq;
import com.lark.oapi.service.search.v2.model.CreateDataSourceItemResp;
import com.lark.oapi.service.search.v2.model.Item;
import com.lark.oapi.service.search.v2.model.ItemContent;
import com.lark.oapi.service.search.v2.model.ItemMetadata;

// POST /open-apis/search/v2/data_sources/:data_source_id/items
public class CreateDataSourceItemSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateDataSourceItemReq req = CreateDataSourceItemReq.newBuilder()
        .dataSourceId("service_ticket")
        .item(Item.newBuilder()
            .id("")
            .acl(new Acl[]{})
            .metadata(ItemMetadata.newBuilder().build())
            .structuredData("")
            .content(ItemContent.newBuilder().build())
            .build())
        .build();

    // 发起请求
    CreateDataSourceItemResp resp = client.search().dataSourceItem().create(req);

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
