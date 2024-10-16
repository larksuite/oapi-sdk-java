package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/external_interviews
public class CreateExternalInterviewSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateExternalInterviewReq req = CreateExternalInterviewReq.newBuilder()
                .externalInterview(ExternalInterview.newBuilder()
                        .externalId("123")
                        .externalApplicationId("6960663240925956437")
                        .participateStatus(1)
                        .beginTime(1618500278)
                        .endTime(1618500278)
                        .interviewAssessments(new ExternalInterviewAssessment[]{})
                        .build())
                .build();

        // 发起请求
        CreateExternalInterviewResp resp = client.hire().v1().externalInterview().create(req);

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
