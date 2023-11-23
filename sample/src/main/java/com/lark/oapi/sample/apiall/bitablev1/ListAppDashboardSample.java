package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.ListAppDashboardReq;
import com.lark.oapi.service.bitable.v1.model.ListAppDashboardResp;

// GET /open-apis/bitable/v1/apps/:app_token/dashboards
public class ListAppDashboardSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListAppDashboardReq req = ListAppDashboardReq.newBuilder()
                .appToken("bascng7vrxcxpig7geggXiCtadY")
                .pageSize(10)
                .pageToken("blknkqrP3RqUkcAW")
                .build();

        // 发起请求
        ListAppDashboardResp resp = client.bitable().v1().appDashboard().list(req);

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
