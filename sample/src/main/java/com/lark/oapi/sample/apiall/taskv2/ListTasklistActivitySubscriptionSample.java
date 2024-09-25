package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.ListTasklistActivitySubscriptionReq;
import com.lark.oapi.service.task.v2.model.ListTasklistActivitySubscriptionResp;

// GET /open-apis/task/v2/tasklists/:tasklist_guid/activity_subscriptions
public class ListTasklistActivitySubscriptionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListTasklistActivitySubscriptionReq req = ListTasklistActivitySubscriptionReq.newBuilder()
                .tasklistGuid("d19e3a2a-edc0-4e4e-b7cc-950e162b53ae")
                .limit(50)
                .userIdType("open_id")
                .build();

        // 发起请求
        ListTasklistActivitySubscriptionResp resp = client.task().v2().tasklistActivitySubscription().list(req);

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
