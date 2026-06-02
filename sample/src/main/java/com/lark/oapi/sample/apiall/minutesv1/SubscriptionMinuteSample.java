package com.lark.oapi.sample.apiall.minutesv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.minutes.v1.model.*;

import java.util.HashMap;

// POST /open-apis/minutes/v1/minutes/subscription
public class SubscriptionMinuteSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SubscriptionMinuteReq req = SubscriptionMinuteReq.newBuilder()
                .subscriptionMinuteReqBody(SubscriptionMinuteReqBody.newBuilder()
                        .eventType("minutes.minute.generated_v1")
                        .build())
                .build();

        // 发起请求
        SubscriptionMinuteResp resp = client.minutes().v1().minute().subscription(req);

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
