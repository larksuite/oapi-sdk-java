package com.lark.oapi.sample.apiall.compensationv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.compensation.v1.model.*;

import java.util.HashMap;

// POST /open-apis/compensation/v1/recurring_payment/batch_remove
public class BatchRemoveRecurringPaymentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchRemoveRecurringPaymentReq req = BatchRemoveRecurringPaymentReq.newBuilder()
                .batchRemoveRecurringPaymentReqBody(BatchRemoveRecurringPaymentReqBody.newBuilder()
                        .recordIds(new String[]{})
                        .reason("这是个删除原因")
                        .build())
                .build();

        // 发起请求
        BatchRemoveRecurringPaymentResp resp = client.compensation().v1().recurringPayment().batchRemove(req);

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
