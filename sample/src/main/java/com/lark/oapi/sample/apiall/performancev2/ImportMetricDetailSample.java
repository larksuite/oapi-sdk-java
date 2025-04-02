package com.lark.oapi.sample.apiall.performancev2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.performance.v2.model.*;

import java.util.HashMap;

// POST /open-apis/performance/v2/metric_details/import
public class ImportMetricDetailSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ImportMetricDetailReq req = ImportMetricDetailReq.newBuilder()
                .clientToken("12454646")
                .userIdType("open_id")
                .importMetricDetailReqBody(ImportMetricDetailReqBody.newBuilder()
                        .semesterId("7293040702907514899")
                        .importRecordName("API录入")
                        .importedMetrics(new ImportedMetric[]{})
                        .build())
                .build();

        // 发起请求
        ImportMetricDetailResp resp = client.performance().v2().metricDetail().import_(req);

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
