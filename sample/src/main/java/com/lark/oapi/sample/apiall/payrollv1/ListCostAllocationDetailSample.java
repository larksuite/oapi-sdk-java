package com.lark.oapi.sample.apiall.payrollv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.payroll.v1.model.*;

import java.util.HashMap;

// GET /open-apis/payroll/v1/cost_allocation_details
public class ListCostAllocationDetailSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListCostAllocationDetailReq req = ListCostAllocationDetailReq.newBuilder()
                .pageSize(50)
                .pageToken("")
                .costAllocationPlanId("72131231231231231")
                .payPeriod("2024-06")
                .reportType(0)
                .build();

        // 发起请求
        ListCostAllocationDetailResp resp = client.payroll().v1().costAllocationDetail().list(req);

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
