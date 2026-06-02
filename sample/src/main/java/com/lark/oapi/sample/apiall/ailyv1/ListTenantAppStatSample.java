package com.lark.oapi.sample.apiall.ailyv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.aily.v1.model.*;

import java.util.HashMap;

// GET /open-apis/aily/v1/app_stats
public class ListTenantAppStatSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListTenantAppStatReq req = ListTenantAppStatReq.newBuilder()
                .startAt("1698729600")
                .endAt("1701321599")
                .filterType("all")
                .pageToken("eyJwYWdlX251bWJlciI6MiwiY29udGVudF9pZCI6IjE2OTg3Mjk2MDAifQ==")
                .pageSize(20)
                .build();

        // 发起请求
        ListTenantAppStatResp resp = client.aily().v1().tenantAppStat().list(req);

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
