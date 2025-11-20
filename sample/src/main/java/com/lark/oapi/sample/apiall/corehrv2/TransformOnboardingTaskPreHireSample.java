package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/pre_hires/transform_onboarding_task
public class TransformOnboardingTaskPreHireSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        TransformOnboardingTaskPreHireReq req = TransformOnboardingTaskPreHireReq.newBuilder()
                .transformOnboardingTaskPreHireReqBody(TransformOnboardingTaskPreHireReqBody.newBuilder()
                        .preHireId("7345005664477775407")
                        .taskCode("27691344-699b-47fb-a352-7b41e992a536")
                        .transformType("manual_start_task/submit_task/review_task")
                        .reviewDecision("approve/reject")
                        .reason("信息填写完整，允许通过")
                        .build())
                .build();

        // 发起请求
        TransformOnboardingTaskPreHireResp resp = client.corehr().v2().preHire().transformOnboardingTask(req);

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
