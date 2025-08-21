package com.lark.oapi.sample.apiall.compensationv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.compensation.v1.model.*;

import java.util.HashMap;

// POST /open-apis/compensation/v1/lump_sum_payment/batch_create
public class BatchCreateLumpSumPaymentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchCreateLumpSumPaymentReq req = BatchCreateLumpSumPaymentReq.newBuilder()
                .userIdType("open_id")
                .batchCreateLumpSumPaymentReqBody(BatchCreateLumpSumPaymentReqBody.newBuilder()
                        .records(new LumpSumPaymentForCreate[]{})
                        .build())
                .build();

        // 发起请求
        BatchCreateLumpSumPaymentResp resp = client.compensation().v1().lumpSumPayment().batchCreate(req);

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
