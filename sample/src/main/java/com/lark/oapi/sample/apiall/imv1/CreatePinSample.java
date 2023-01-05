package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.CreatePinReq;
import com.lark.oapi.service.im.v1.model.CreatePinReqBody;
import com.lark.oapi.service.im.v1.model.CreatePinResp;

// POST /open-apis/im/v1/pins
public class CreatePinSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreatePinReq req = CreatePinReq.newBuilder()
                .createPinReqBody(CreatePinReqBody.newBuilder()
                        .messageId("om_dc13264520392913993dd051dba21dcf")
                        .build())
                .build();

        // 发起请求
        CreatePinResp resp = client.im().pin().create(req);

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
