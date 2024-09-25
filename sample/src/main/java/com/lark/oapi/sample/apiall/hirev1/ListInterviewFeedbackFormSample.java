package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.ListInterviewFeedbackFormReq;
import com.lark.oapi.service.hire.v1.model.ListInterviewFeedbackFormResp;

// GET /open-apis/hire/v1/interview_feedback_forms
public class ListInterviewFeedbackFormSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListInterviewFeedbackFormReq req = ListInterviewFeedbackFormReq.newBuilder()
                .interviewFeedbackFormIds(new String[]{})
                .pageSize(0)
                .pageToken("")
                .build();

        // 发起请求
        ListInterviewFeedbackFormResp resp = client.hire().v1().interviewFeedbackForm().list(req);

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
