package com.lark.oapi.sample.apiall.compensationv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.compensation.v1.model.*;

import java.util.HashMap;

// POST /open-apis/compensation/v1/lump_sum_payment/query
public class QueryLumpSumPaymentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryLumpSumPaymentReq req = QueryLumpSumPaymentReq.newBuilder()
                .pageSize(0)
                .pageToken("")
                .userIdType("open_id")
                .queryLumpSumPaymentReqBody(QueryLumpSumPaymentReqBody.newBuilder()
                        .ids(new String[]{})
                        .uniqueIds(new String[]{})
                        .userIds(new String[]{})
                        .itemIds(new String[]{})
                        .createTimeGte("2023-04-01 12:34:56")
                        .createTimeLte("2023-04-01 12:34:56")
                        .modifyTimeGte("2023-04-01 12:34:56")
                        .modifyTimeLte("2023-04-01 12:34:56")
                        .companyIds(new String[]{})
                        .serviceCompanyIds(new String[]{})
                        .departmentIds(new String[]{})
                        .jobFamilyIds(new String[]{})
                        .jobLevelIds(new String[]{})
                        .workLocationIds(new String[]{})
                        .employeeTypeIds(new String[]{})
                        .onboardDateGte("2023-04-01")
                        .onboardDateLte("2023-04-01")
                        .offboardDateGte("2023-04-01")
                        .offboardDateLte("2023-04-01")
                        .build())
                .build();

        // 发起请求
        QueryLumpSumPaymentResp resp = client.compensation().v1().lumpSumPayment().query(req);

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
