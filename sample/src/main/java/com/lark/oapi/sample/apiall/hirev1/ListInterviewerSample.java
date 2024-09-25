package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.ListInterviewerReq;
import com.lark.oapi.service.hire.v1.model.ListInterviewerResp;

// GET /open-apis/hire/v1/interviewers
public class ListInterviewerSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListInterviewerReq req = ListInterviewerReq.newBuilder()
                .pageSize(0)
                .pageToken("")
                .userIds(new String[]{})
                .verifyStatus(1)
                .earliestUpdateTime("1714374796615")
                .latestUpdateTime("1714374796616")
                .userIdType("user_id")
                .build();

        // 发起请求
        ListInterviewerResp resp = client.hire().v1().interviewer().list(req);

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
