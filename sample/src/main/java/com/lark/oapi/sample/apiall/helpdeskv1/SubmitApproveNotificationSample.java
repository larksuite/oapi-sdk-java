package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.*;

import java.util.HashMap;

// POST /open-apis/helpdesk/v1/notifications/:notification_id/submit_approve
public class SubmitApproveNotificationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SubmitApproveNotificationReq req = SubmitApproveNotificationReq.newBuilder()
                .notificationId("6985032626234982420")
                .submitApproveNotificationReqBody(SubmitApproveNotificationReqBody.newBuilder()
                        .reason("测试发送消息")
                        .build())
                .build();

        // 发起请求
        SubmitApproveNotificationResp resp = client.helpdesk().v1().notification().submitApprove(req);

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
