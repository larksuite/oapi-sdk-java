package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/applications/:application_id/cancel_onboard
public class CancelOnboardApplicationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CancelOnboardApplicationReq req = CancelOnboardApplicationReq.newBuilder()
                .applicationId("1111111111")
                .cancelOnboardApplicationReqBody(CancelOnboardApplicationReqBody.newBuilder()
                        .terminationType(1)
                        .terminationReasonIdList(new String[]{})
                        .terminationReasonNotes("测试")
                        .build())
                .build();

        // 发起请求
        CancelOnboardApplicationResp resp = client.hire().v1().application().cancelOnboard(req);

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
