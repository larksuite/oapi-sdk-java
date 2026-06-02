package com.lark.oapi.sample.apiall.sparkv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.spark.v1.model.*;

import java.util.HashMap;

// GET /open-apis/spark/v1/apps/:app_id/enums/:enum_name
public class GetEnumDetailAppEnumSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetEnumDetailAppEnumReq req = GetEnumDetailAppEnumReq.newBuilder()
                .appId("app_4jcn5n11bpf5v")
                .enumName("enum_demo_1")
                .env("online")
                .build();

        // 发起请求
        GetEnumDetailAppEnumResp resp = client.spark().v1().appEnum().getEnumDetail(req);

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
