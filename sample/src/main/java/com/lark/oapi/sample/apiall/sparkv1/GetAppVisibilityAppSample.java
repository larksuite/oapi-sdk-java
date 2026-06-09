package com.lark.oapi.sample.apiall.sparkv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.spark.v1.model.*;

import java.util.HashMap;

// GET /open-apis/spark/v1/apps/:app_id/access-scope
public class GetAppVisibilityAppSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetAppVisibilityAppReq req = GetAppVisibilityAppReq.newBuilder()
                .appId("app_4k6af8utt2s0n")
                .userIdType("user_id")
                .build();

        // 发起请求
        GetAppVisibilityAppResp resp = client.spark().v1().app().getAppVisibility(req);

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
