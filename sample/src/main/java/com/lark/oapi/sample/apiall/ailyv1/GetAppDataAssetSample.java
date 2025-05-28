package com.lark.oapi.sample.apiall.ailyv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.aily.v1.model.*;

import java.util.HashMap;

// GET /open-apis/aily/v1/apps/:app_id/data_assets/:data_asset_id
public class GetAppDataAssetSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetAppDataAssetReq req = GetAppDataAssetReq.newBuilder()
                .appId("spring_feafdsaf__c")
                .dataAssetId("data_asset_dafefadsaf1")
                .withDataAssetItem(true)
                .withConnectStatus(true)
                .tenantType("dev")
                .build();

        // 发起请求
        GetAppDataAssetResp resp = client.aily().v1().appDataAsset().get(req);

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
