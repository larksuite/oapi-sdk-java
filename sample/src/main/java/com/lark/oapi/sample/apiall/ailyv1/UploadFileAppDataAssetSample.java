package com.lark.oapi.sample.apiall.ailyv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.aily.v1.model.*;

import java.io.File;
import java.util.HashMap;

// POST /open-apis/aily/v1/apps/:app_id/data_assets/upload_file
public class UploadFileAppDataAssetSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        UploadFileAppDataAssetReq req = UploadFileAppDataAssetReq.newBuilder()
                .appId("spring_dsafdsaf__c")
                .tenantType("dev")
                .uploadFileAppDataAssetReqBody(UploadFileAppDataAssetReqBody.newBuilder()
                        .file(file)
                        .build())
                .build();

        // 发起请求
        UploadFileAppDataAssetResp resp = client.aily().v1().appDataAsset().uploadFile(req);

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
