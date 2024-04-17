package com.lark.oapi.sample.apiall.security_and_compliancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.security_and_compliance.v1.model.ListDataOpenapiLogReq;
import com.lark.oapi.service.security_and_compliance.v1.model.ListDataOpenapiLogResp;
import com.lark.oapi.service.security_and_compliance.v1.model.ListOpenapiLogRequest;

// POST /open-apis/security_and_compliance/v1/openapi_logs/list_data
public class ListDataOpenapiLogSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListDataOpenapiLogReq req = ListDataOpenapiLogReq.newBuilder()
                .listOpenapiLogRequest(ListOpenapiLogRequest.newBuilder()
                        .apiKeys(new String[]{})
                        .startTime(1610613336)
                        .endTime(1610613336)
                        .appId("cli_xxx")
                        .pageSize(20)
                        .pageToken("xxx")
                        .build())
                .build();

        // 发起请求
        ListDataOpenapiLogResp resp = client.securityAndCompliance().v1().openapiLog().listData(req);

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
