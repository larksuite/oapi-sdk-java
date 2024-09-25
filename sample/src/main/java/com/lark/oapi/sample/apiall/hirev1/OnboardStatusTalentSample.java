package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.OnboardStatusTalentReq;
import com.lark.oapi.service.hire.v1.model.OnboardStatusTalentReqBody;
import com.lark.oapi.service.hire.v1.model.OnboardStatusTalentResp;

// POST /open-apis/hire/v1/talents/:talent_id/onboard_status
public class OnboardStatusTalentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        OnboardStatusTalentReq req = OnboardStatusTalentReq.newBuilder()
                .talentId("6960663240925956661")
                .onboardStatusTalentReqBody(OnboardStatusTalentReqBody.newBuilder()
                        .operation(1)
                        .onboardTime("1676548784889")
                        .overboardTime("1676548784890")
                        .build())
                .build();

        // 发起请求
        OnboardStatusTalentResp resp = client.hire().v1().talent().onboardStatus(req);

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
