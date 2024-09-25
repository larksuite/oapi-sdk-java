package com.lark.oapi.sample.apiall.okrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.okr.v1.model.CreatePeriodReq;
import com.lark.oapi.service.okr.v1.model.CreatePeriodReqBody;
import com.lark.oapi.service.okr.v1.model.CreatePeriodResp;

// POST /open-apis/okr/v1/periods
public class CreatePeriodSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreatePeriodReq req = CreatePeriodReq.newBuilder()
                .createPeriodReqBody(CreatePeriodReqBody.newBuilder()
                        .periodRuleId("6969864184272078374")
                        .startMonth("2022-01")
                        .build())
                .build();

        // 发起请求
        CreatePeriodResp resp = client.okr().v1().period().create(req);

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
