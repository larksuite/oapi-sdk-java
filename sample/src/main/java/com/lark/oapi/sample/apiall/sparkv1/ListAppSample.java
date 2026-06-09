package com.lark.oapi.sample.apiall.sparkv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.spark.v1.model.*;

import java.util.HashMap;

// GET /open-apis/spark/v1/apps
public class ListAppSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListAppReq req = ListAppReq.newBuilder()
                .pageSize(20)
                .pageToken("eyJwYWdlX251bWJlciI6MiwiY29udGVudF9pZHMiOlsiMTIzNCIsIjU2NzgiXX0=")
                .build();

        // 发起请求
        ListAppResp resp = client.spark().v1().app().list(req);

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
