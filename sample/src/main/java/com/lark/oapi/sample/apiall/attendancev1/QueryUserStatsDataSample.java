package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.QueryUserStatsDataReq;
import com.lark.oapi.service.attendance.v1.model.QueryUserStatsDataReqBody;
import com.lark.oapi.service.attendance.v1.model.QueryUserStatsDataResp;

// POST /open-apis/attendance/v1/user_stats_datas/query
public class QueryUserStatsDataSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryUserStatsDataReq req = QueryUserStatsDataReq.newBuilder()
                .employeeType("employee_id")
                .queryUserStatsDataReqBody(QueryUserStatsDataReqBody.newBuilder()
                        .locale("zh")
                        .statsType("month")
                        .startDate(20210316)
                        .endDate(20210323)
                        .userIds(new String[]{})
                        .needHistory(true)
                        .currentGroupOnly(true)
                        .userId("ec8ddg56")
                        .build())
                .build();

        // 发起请求
        QueryUserStatsDataResp resp = client.attendance().v1().userStatsData().query(req);

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
