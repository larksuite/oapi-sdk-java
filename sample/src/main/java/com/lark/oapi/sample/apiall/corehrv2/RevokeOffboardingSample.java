package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/offboardings/revoke
public class RevokeOffboardingSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        RevokeOffboardingReq req = RevokeOffboardingReq.newBuilder()
                .userIdType("people_corehr_id")
                .revokeOffboardingReqBody(RevokeOffboardingReqBody.newBuilder()
                        .offboardingId("7095671727698478604")
                        .operatorId("6982509313466189341")
                        .build())
                .build();

        // 发起请求
        RevokeOffboardingResp resp = client.corehr().v2().offboarding().revoke(req);

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
