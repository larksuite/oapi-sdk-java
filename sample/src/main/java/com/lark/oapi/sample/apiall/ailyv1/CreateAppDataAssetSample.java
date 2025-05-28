package com.lark.oapi.sample.apiall.ailyv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.aily.v1.model.*;

import java.util.HashMap;

// POST /open-apis/aily/v1/apps/:app_id/data_assets
public class CreateAppDataAssetSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateAppDataAssetReq req = CreateAppDataAssetReq.newBuilder()
                .appId("spring_dfasdf__c")
                .tenantType("dev")
                .createAppDataAssetReqBody(CreateAppDataAssetReqBody.newBuilder()
                        .connectType("direct")
                        .sourceType("file")
                        .importKnowledgeSetting(DataAssetImportKnowledgeSetting.newBuilder().build())
                        .description(new HashMap<String, String>())
                        .build())
                .build();

        // 发起请求
        CreateAppDataAssetResp resp = client.aily().v1().appDataAsset().create(req);

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
