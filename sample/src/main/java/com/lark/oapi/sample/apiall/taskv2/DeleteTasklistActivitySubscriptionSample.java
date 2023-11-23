package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.DeleteTasklistActivitySubscriptionReq;
import com.lark.oapi.service.task.v2.model.DeleteTasklistActivitySubscriptionResp;

// DELETE /open-apis/task/v2/tasklists/:tasklist_guid/activity_subscriptions/:activity_subscription_guid
public class DeleteTasklistActivitySubscriptionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteTasklistActivitySubscriptionReq req = DeleteTasklistActivitySubscriptionReq.newBuilder()
                .tasklistGuid("f5ca6747-5ac3-422e-a97e-972c1b2c24f3")
                .activitySubscriptionGuid("d19e3a2a-edc0-4e4e-b7cc-950e162b53ae")
                .build();

        // 发起请求
        DeleteTasklistActivitySubscriptionResp resp = client.task().v2().tasklistActivitySubscription().delete(req);

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
