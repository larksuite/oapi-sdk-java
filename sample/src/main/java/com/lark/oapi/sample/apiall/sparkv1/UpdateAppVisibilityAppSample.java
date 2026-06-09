package com.lark.oapi.sample.apiall.sparkv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.spark.v1.model.*;

import java.util.HashMap;

// PUT /open-apis/spark/v1/apps/:app_id/access-scope
public class UpdateAppVisibilityAppSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateAppVisibilityAppReq req = UpdateAppVisibilityAppReq.newBuilder()
                .appId("app-20240520103000-xyz")
                .userIdType("user_id")
                .updateAppVisibilityAppReqBody(UpdateAppVisibilityAppReqBody.newBuilder()
                        .users(new String[]{})
                        .departments(new String[]{})
                        .chats(new String[]{})
                        .applyConfig(ApplyConfig.newBuilder().build())
                        .requireLogin(false)
                        .scope("")
                        .build())
                .build();

        // 发起请求
        UpdateAppVisibilityAppResp resp = client.spark().v1().app().updateAppVisibility(req);

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
