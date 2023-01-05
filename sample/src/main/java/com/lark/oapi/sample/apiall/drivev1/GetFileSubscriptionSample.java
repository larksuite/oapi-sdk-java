package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.FileSubscription;
import com.lark.oapi.service.drive.v1.model.GetFileSubscriptionReq;
import com.lark.oapi.service.drive.v1.model.GetFileSubscriptionResp;

// GET /open-apis/drive/v1/files/:file_token/subscriptions/:subscription_id
public class GetFileSubscriptionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetFileSubscriptionReq req = GetFileSubscriptionReq.newBuilder()
                .fileToken("doxcnxxxxxxxxxxxxxxxxxxxxxx")
                .subscriptionId("1234567890987654321")
                .fileSubscription(FileSubscription.newBuilder()
                        .subscriptionId("1234567890987654321")
                        .subscriptionType("comment_update")
                        .isSubcribe(true)
                        .fileType("doc")
                        .build())
                .build();

        // 发起请求
        GetFileSubscriptionResp resp = client.drive().fileSubscription().get(req);

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
