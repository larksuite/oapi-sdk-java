package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/background_check_orders/batch_query
public class BatchQueryBackgroundCheckOrderSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchQueryBackgroundCheckOrderReq req = BatchQueryBackgroundCheckOrderReq.newBuilder()
                .userIdType("open_id")
                .pageToken("eyJvZmZzZXQiOjEsInRpbWVzdGFtcCI6MTY0MDc2NTYzMjA4OCwiaWQiOm51bGx9")
                .pageSize(10)
                .batchQueryBackgroundCheckOrderReqBody(BatchQueryBackgroundCheckOrderReqBody.newBuilder()
                        .backgroundCheckOrderIdList(new String[]{})
                        .updateStartTime("1618500278663")
                        .updateEndTime("1618500278663")
                        .beginStartTime("1618500278663")
                        .beginEndTime("1618500278663")
                        .applicationId("7398493486516799788")
                        .orderStatus("2")
                        .build())
                .build();

        // 发起请求
        BatchQueryBackgroundCheckOrderResp resp = client.hire().v1().backgroundCheckOrder().batchQuery(req);

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
