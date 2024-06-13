package com.lark.oapi.sample.apiall.searchv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.search.v2.model.*;

import java.util.HashMap;

// DELETE /open-apis/search/v2/data_sources/:data_source_id/items/:item_id
public class DeleteDataSourceItemSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteDataSourceItemReq req = DeleteDataSourceItemReq.newBuilder()
                .dataSourceId("service_ticket")
                .itemId("01010111")
                .build();

        // 发起请求
        DeleteDataSourceItemResp resp = client.search().v2().dataSourceItem().delete(req);

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
