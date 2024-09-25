package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.ArchiveReportData;
import com.lark.oapi.service.attendance.v1.model.UploadReportArchiveRuleReq;
import com.lark.oapi.service.attendance.v1.model.UploadReportArchiveRuleReqBody;
import com.lark.oapi.service.attendance.v1.model.UploadReportArchiveRuleResp;

// POST /open-apis/attendance/v1/archive_rule/upload_report
public class UploadReportArchiveRuleSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UploadReportArchiveRuleReq req = UploadReportArchiveRuleReq.newBuilder()
                .employeeType("employee_id")
                .uploadReportArchiveRuleReqBody(UploadReportArchiveRuleReqBody.newBuilder()
                        .month("202409")
                        .operatorId("ax11d")
                        .archiveReportDatas(new ArchiveReportData[]{})
                        .archiveRuleId("1")
                        .build())
                .build();

        // 发起请求
        UploadReportArchiveRuleResp resp = client.attendance().v1().archiveRule().uploadReport(req);

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
