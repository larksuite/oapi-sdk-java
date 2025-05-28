package com.lark.oapi.sample.apiall.ailyv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.aily.v1.model.*;

import java.util.HashMap;

// DELETE /open-apis/aily/v1/apps/:app_id/data_assets/:data_asset_id
public class DeleteAppDataAssetSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteAppDataAssetReq req = DeleteAppDataAssetReq.newBuilder()
                .appId("spring_dfadsaf__c")
                .dataAssetId("data_asset_dfadsafe")
                .tenantType("dev")
                .build();

        // 发起请求
        DeleteAppDataAssetResp resp = client.aily().v1().appDataAsset().delete(req);

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
