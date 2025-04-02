package com.lark.oapi.sample.apiall.payrollv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.payroll.v1.model.*;

import java.util.HashMap;

// POST /open-apis/payroll/v1/payment_detail/query
public class QueryPaymentDetailSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryPaymentDetailReq req = QueryPaymentDetailReq.newBuilder()
                .queryPaymentDetailReqBody(QueryPaymentDetailReqBody.newBuilder()
                        .pageIndex(100)
                        .pageSize(0)
                        .acctItemIds(new String[]{})
                        .employeeIds(new String[]{})
                        .payPeriodStartDate("2024-01-01")
                        .payPeriodEndDate("2024-01-31")
                        .activityIds(new String[]{})
                        .includeSegmentData(false)
                        .build())
                .build();

        // 发起请求
        QueryPaymentDetailResp resp = client.payroll().v1().paymentDetail().query(req);

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
