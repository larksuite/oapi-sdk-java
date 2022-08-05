package com.lark.oapi.sample.apiall.searchv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.search.v2.model.CreateDataSourceReq;
import com.lark.oapi.service.search.v2.model.CreateDataSourceResp;
import com.lark.oapi.service.search.v2.model.DataSource;
import com.lark.oapi.service.search.v2.model.I18nMeta;

// HTTP PATH: /open-apis/search/v2/data_sources"
public class CreateDataSourceSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateDataSourceReq req = CreateDataSourceReq.newBuilder()
        .dataSource(DataSource.newBuilder()
            .name("")
            .state(0)
            .description("")
            .iconUrl("")
            .template("search_common_card")
            .searchableFields(new String[]{})
            .i18nName(I18nMeta.newBuilder().build())
            .i18nDescription(I18nMeta.newBuilder().build())
            .schemaId("")
            .build())
        .build();

    // 发起请求
    CreateDataSourceResp resp = client.search().dataSource().create(req);

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
