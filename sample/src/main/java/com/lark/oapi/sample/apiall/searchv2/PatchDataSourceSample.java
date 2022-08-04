package com.lark.oapi.sample.apiall.searchv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.search.v2.model.I18nMeta;
import com.lark.oapi.service.search.v2.model.ItemMetadata;
import com.lark.oapi.service.search.v2.model.PatchDataSourceReq;
import com.lark.oapi.service.search.v2.model.PatchDataSourceReqBody;
import com.lark.oapi.service.search.v2.model.PatchDataSourceResp;

// HTTP PATH: /open-apis/search/v2/data_sources/:data_source_id"
public class PatchDataSourceSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    PatchDataSourceReq req = PatchDataSourceReq.newBuilder()
        .dataSourceId("数据源")
        .patchDataSourceReqBody(PatchDataSourceReqBody.newBuilder()
            .name("")
            .state(0)
            .description("")
            .iconUrl("")
            .i18nName(ItemMetadata.newBuilder().build())
            .i18nDescription(I18nMeta.newBuilder().build())
            .build())
        .build();

    // 发起请求
    PatchDataSourceResp resp = client.search().dataSource().patch(req);

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
