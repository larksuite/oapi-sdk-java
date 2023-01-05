package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.PatchApplicationFeedbackReq;
import com.lark.oapi.service.application.v6.model.PatchApplicationFeedbackResp;

// PATCH /open-apis/application/v6/applications/:app_id/feedbacks/:feedback_id
public class PatchApplicationFeedbackSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchApplicationFeedbackReq req = PatchApplicationFeedbackReq.newBuilder()
                .appId("cli_9f115af860f7901b")
                .feedbackId("7057888018203574291")
                .userIdType("open_id")
                .status(1)
                .operatorId("ou_9565b69967831233761cc2f11b4c089f")
                .build();

        // 发起请求
        PatchApplicationFeedbackResp resp = client.application().applicationFeedback().patch(req);

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
