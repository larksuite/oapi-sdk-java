package com.lark.oapi.sample.apiall.apaasv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.apaas.v1.model.*;

import java.util.HashMap;

// GET /open-apis/apaas/v1/applications/:namespace/audit_log/data_change_logs_list
public class DataChangeLogsListApplicationAuditLogSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DataChangeLogsListApplicationAuditLogReq req = DataChangeLogsListApplicationAuditLogReq.newBuilder()
                .namespace("package_aa_bb")
                .quickQuery("Intel Mac OS")
                .pageSize("0")
                .offset("0")
                .from("1723691857002")
                .to("1724296657002")
                .logType("10007")
                .filter("")
                .columns(new String[]{})
                .sortBy("opTime")
                .sortOrder("asc")
                .appType("0")
                .build();

        // 发起请求
        DataChangeLogsListApplicationAuditLogResp resp = client.apaas().v1().applicationAuditLog().dataChangeLogsList(req);

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
