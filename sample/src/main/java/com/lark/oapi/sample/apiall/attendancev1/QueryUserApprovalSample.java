package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.QueryUserApprovalReq;
import com.lark.oapi.service.attendance.v1.model.QueryUserApprovalReqBody;
import com.lark.oapi.service.attendance.v1.model.QueryUserApprovalResp;

// POST /open-apis/attendance/v1/user_approvals/query
public class QueryUserApprovalSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryUserApprovalReq req = QueryUserApprovalReq.newBuilder()
                .employeeType("employee_id")
                .queryUserApprovalReqBody(QueryUserApprovalReqBody.newBuilder()
                        .userIds(new String[]{})
                        .checkDateFrom(20190817)
                        .checkDateTo(20190820)
                        .checkDateType("PeriodTime")
                        .status(2)
                        .checkTimeFrom("1566641088")
                        .checkTimeTo("1592561088")
                        .build())
                .build();

        // 发起请求
        QueryUserApprovalResp resp = client.attendance().userApproval().query(req);

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
