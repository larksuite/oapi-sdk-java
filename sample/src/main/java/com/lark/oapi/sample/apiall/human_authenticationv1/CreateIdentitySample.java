package com.lark.oapi.sample.apiall.human_authenticationv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.human_authentication.v1.model.CreateIdentityReq;
import com.lark.oapi.service.human_authentication.v1.model.CreateIdentityReqBody;
import com.lark.oapi.service.human_authentication.v1.model.CreateIdentityResp;

// POST /open-apis/human_authentication/v1/identities
public class CreateIdentitySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateIdentityReq req = CreateIdentityReq.newBuilder()
                .userId("ou_2eb5483cb377daa5054bc6f86e2089a5")
                .userIdType("open_id")
                .createIdentityReqBody(CreateIdentityReqBody.newBuilder()
                        .identityName("张三")
                        .identityCode("4xxxxxxxx")
                        .mobile("13xxxxxxx")
                        .build())
                .build();

        // 发起请求
        CreateIdentityResp resp = client.humanAuthentication().identity().create(req);

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
