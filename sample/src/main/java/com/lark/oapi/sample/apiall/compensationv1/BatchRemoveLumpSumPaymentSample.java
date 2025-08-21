package com.lark.oapi.sample.apiall.compensationv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.compensation.v1.model.*;

import java.util.HashMap;

// POST /open-apis/compensation/v1/lump_sum_payment/batch_remove
public class BatchRemoveLumpSumPaymentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchRemoveLumpSumPaymentReq req = BatchRemoveLumpSumPaymentReq.newBuilder()
                .batchRemoveLumpSumPaymentReqBody(BatchRemoveLumpSumPaymentReqBody.newBuilder()
                        .recordIds(new String[]{})
                        .reason("这是个原因")
                        .build())
                .build();

        // 发起请求
        BatchRemoveLumpSumPaymentResp resp = client.compensation().v1().lumpSumPayment().batchRemove(req);

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
