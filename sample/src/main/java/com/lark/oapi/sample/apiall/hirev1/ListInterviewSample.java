package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.ListInterviewReq;
import com.lark.oapi.service.hire.v1.model.ListInterviewResp;

// GET /open-apis/hire/v1/interviews
public class ListInterviewSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListInterviewReq req = ListInterviewReq.newBuilder()
                .pageSize(10)
                .pageToken("xx")
                .applicationId("6134134355464633")
                .interviewId("6888217964693309704")
                .startTime("1609489908000")
                .endTime("1610489908000")
                .userIdType("user_id")
                .build();

        // 发起请求
        ListInterviewResp resp = client.hire().interview().list(req);

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
