package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/external_background_checks/batch_query
public class BatchQueryExternalBackgroundCheckSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchQueryExternalBackgroundCheckReq req = BatchQueryExternalBackgroundCheckReq.newBuilder()
                .externalApplicationId("6960663240925956660")
                .pageSize(10)
                .pageToken("eyJvZmZzZXQiOjEwLCJ0aW1lc3RhbXAiOjE2Mjc1NTUyMjM2NzIsImlkIjpudWxsfQ==")
                .batchQueryExternalBackgroundCheckReqBody(BatchQueryExternalBackgroundCheckReqBody.newBuilder()
                        .externalBackgroundCheckIdList(new String[]{})
                        .build())
                .build();

        // 发起请求
        BatchQueryExternalBackgroundCheckResp resp = client.hire().v1().externalBackgroundCheck().batchQuery(req);

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
