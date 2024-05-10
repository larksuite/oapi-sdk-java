package com.lark.oapi.sample.apiall.searchv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.search.v2.model.*;

import java.util.HashMap;

// GET /open-apis/search/v2/data_sources
public class ListDataSourceSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListDataSourceReq req = ListDataSourceReq.newBuilder()
                .view(0)
                .pageSize(10)
                .pageToken("PxZFma9OIRhdBlT/dOYNiu2Ro8F2WAhcby7OhOijfljZ")
                .build();

        // 发起请求
        ListDataSourceResp resp = client.search().v2().dataSource().list(req);

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
