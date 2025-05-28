package com.lark.oapi.sample.apiall.ailyv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.aily.v1.model.*;

import java.util.HashMap;

// GET /open-apis/aily/v1/apps/:app_id/data_assets
public class ListAppDataAssetSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListAppDataAssetReq req = ListAppDataAssetReq.newBuilder()
                .appId("spring_5862e4fea8__c")
                .pageSize(0)
                .pageToken("")
                .keyword("电影")
                .dataAssetIds(new String[]{})
                .dataAssetTagIds(new String[]{})
                .withDataAssetItem(false)
                .withConnectStatus(false)
                .build();

        // 发起请求
        ListAppDataAssetResp resp = client.aily().v1().appDataAsset().list(req);

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
