package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.ListApplicationFeedbackReq;
import com.lark.oapi.service.application.v6.model.ListApplicationFeedbackResp;

// GET /open-apis/application/v6/applications/:app_id/feedbacks
public class ListApplicationFeedbackSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListApplicationFeedbackReq req = ListApplicationFeedbackReq.newBuilder()
                .appId("cli_9f115af860f7901b")
                .fromDate("2022-01-30")
                .toDate("2022-01-30")
                .feedbackType(1)
                .status(0)
                .userIdType("open_id")
                .pageToken("")
                .pageSize(100)
                .build();

        // 发起请求
        ListApplicationFeedbackResp resp = client.application().applicationFeedback().list(req);

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
