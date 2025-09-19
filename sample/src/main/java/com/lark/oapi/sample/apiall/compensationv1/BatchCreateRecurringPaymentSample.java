package com.lark.oapi.sample.apiall.compensationv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.compensation.v1.model.*;

import java.util.HashMap;

// POST /open-apis/compensation/v1/recurring_payment/batch_create
public class BatchCreateRecurringPaymentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchCreateRecurringPaymentReq req = BatchCreateRecurringPaymentReq.newBuilder()
                .userIdType("user_id")
                .batchCreateRecurringPaymentReqBody(BatchCreateRecurringPaymentReqBody.newBuilder()
                        .records(new RecurringPaymentForCreate[]{})
                        .build())
                .build();

        // 发起请求
        BatchCreateRecurringPaymentResp resp = client.compensation().v1().recurringPayment().batchCreate(req);

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
