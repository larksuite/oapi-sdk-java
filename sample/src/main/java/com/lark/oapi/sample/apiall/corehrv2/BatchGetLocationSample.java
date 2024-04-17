package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.BatchGetLocationReq;
import com.lark.oapi.service.corehr.v2.model.BatchGetLocationReqBody;
import com.lark.oapi.service.corehr.v2.model.BatchGetLocationResp;

// POST /open-apis/corehr/v2/locations/batch_get
public class BatchGetLocationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchGetLocationReq req = BatchGetLocationReq.newBuilder()
                .batchGetLocationReqBody(BatchGetLocationReqBody.newBuilder()
                        .locationIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        BatchGetLocationResp resp = client.corehr().v2().location().batchGet(req);

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
