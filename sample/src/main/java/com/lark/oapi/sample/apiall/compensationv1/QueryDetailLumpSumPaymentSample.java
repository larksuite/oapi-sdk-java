package com.lark.oapi.sample.apiall.compensationv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.compensation.v1.model.*;

import java.util.HashMap;

// POST /open-apis/compensation/v1/lump_sum_payment/query_detail
public class QueryDetailLumpSumPaymentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryDetailLumpSumPaymentReq req = QueryDetailLumpSumPaymentReq.newBuilder()
                .pageSize(0)
                .pageToken("")
                .userIdType("open_id")
                .queryDetailLumpSumPaymentReqBody(QueryDetailLumpSumPaymentReqBody.newBuilder()
                        .ids(new String[]{})
                        .recordIds(new String[]{})
                        .recordUniqueIds(new String[]{})
                        .issuanceWays(new String[]{})
                        .issuanceStatuses(new String[]{})
                        .userIds(new String[]{})
                        .itemIds(new String[]{})
                        .issuanceDateGte("2023-04-01")
                        .issuanceDateLte("2023-04-01")
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
        QueryDetailLumpSumPaymentResp resp = client.compensation().v1().lumpSumPayment().queryDetail(req);

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
