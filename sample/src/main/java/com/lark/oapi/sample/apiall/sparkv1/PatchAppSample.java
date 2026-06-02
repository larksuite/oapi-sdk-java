package com.lark.oapi.sample.apiall.sparkv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.spark.v1.model.*;

import java.util.HashMap;

// PATCH /open-apis/spark/v1/apps/:app_id
public class PatchAppSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchAppReq req = PatchAppReq.newBuilder()
                .appId("app_4k6af8utt2s0n")
                .patchAppReqBody(PatchAppReqBody.newBuilder()
                        .name("智能客服助手")
                        .description("提供7×24小时智能对话服务，支持常见问题自动解答与工单流转")
                        .iconUrl("https://example.com/app-icons/customer-service.png")
                        .build())
                .build();

        // 发起请求
        PatchAppResp resp = client.spark().v1().app().patch(req);

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
