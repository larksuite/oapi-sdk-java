package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

// PATCH /open-apis/hire/v1/eco_background_check_packages/batch_update
public class BatchUpdateEcoBackgroundCheckPackageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchUpdateEcoBackgroundCheckPackageReq req = BatchUpdateEcoBackgroundCheckPackageReq.newBuilder()
                .ecoBackgroundCheckPackage(EcoBackgroundCheckPackage.newBuilder()
                        .accountId("ord_id")
                        .packageList(new EcoBackgroundCheckPackageData[]{})
                        .additionalItemList(new EcoBackgroundCheckPackageAdditionalItem[]{})
                        .build())
                .build();

        // 发起请求
        BatchUpdateEcoBackgroundCheckPackageResp resp = client.hire().ecoBackgroundCheckPackage().batchUpdate(req);

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
