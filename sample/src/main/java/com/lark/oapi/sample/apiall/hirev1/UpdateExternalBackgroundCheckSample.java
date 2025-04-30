package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// PUT /open-apis/hire/v1/external_background_checks/:external_background_check_id
public class UpdateExternalBackgroundCheckSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateExternalBackgroundCheckReq req = UpdateExternalBackgroundCheckReq.newBuilder()
                .externalBackgroundCheckId("6960663240925956660")
                .externalBackgroundCheck(ExternalBackgroundCheck.newBuilder()
                        .externalApplicationId("1234111")
                        .date(1626602069393L)
                        .name("测试.pdf")
                        .result("1")
                        .attachmentIdList(new String[]{})
                        .build())
                .build();

        // 发起请求
        UpdateExternalBackgroundCheckResp resp = client.hire().v1().externalBackgroundCheck().update(req);

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
