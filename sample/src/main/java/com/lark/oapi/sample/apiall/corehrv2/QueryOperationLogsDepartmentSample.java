package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/departments/query_operation_logs
public class QueryOperationLogsDepartmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryOperationLogsDepartmentReq req = QueryOperationLogsDepartmentReq.newBuilder()
                .pageSize(100)
                .pageToken("2")
                .departmentIdType("people_corehr_department_id")
                .queryOperationLogsDepartmentReqBody(QueryOperationLogsDepartmentReqBody.newBuilder()
                        .departmentIds(new String[]{})
                        .startDate("2023-01-01")
                        .endDate("2024-01-01")
                        .build())
                .build();

        // 发起请求
        QueryOperationLogsDepartmentResp resp = client.corehr().v2().department().queryOperationLogs(req);

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
