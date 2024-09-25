package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.DelReportArchiveRuleReq;
import com.lark.oapi.service.attendance.v1.model.DelReportArchiveRuleReqBody;
import com.lark.oapi.service.attendance.v1.model.DelReportArchiveRuleResp;

// POST /open-apis/attendance/v1/archive_rule/del_report
public class DelReportArchiveRuleSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DelReportArchiveRuleReq req = DelReportArchiveRuleReq.newBuilder()
                .employeeType("employee_id")
                .delReportArchiveRuleReqBody(DelReportArchiveRuleReqBody.newBuilder()
                        .month("202409")
                        .operatorId("a111xd")
                        .archiveRuleId("1")
                        .userIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        DelReportArchiveRuleResp resp = client.attendance().v1().archiveRule().delReport(req);

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
