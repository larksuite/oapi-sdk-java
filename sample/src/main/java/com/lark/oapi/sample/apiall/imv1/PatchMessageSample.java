package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.PatchMessageReq;
import com.lark.oapi.service.im.v1.model.PatchMessageReqBody;
import com.lark.oapi.service.im.v1.model.PatchMessageResp;

// PATCH /open-apis/im/v1/messages/:message_id
public class PatchMessageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchMessageReq req = PatchMessageReq.newBuilder()
                .messageId("om_dc13264520392913993dd051dba21dcf")
                .patchMessageReqBody(PatchMessageReqBody.newBuilder()
                        .content("参考链接")
                        .build())
                .build();

        // 发起请求
        PatchMessageResp resp = client.im().v1().message().patch(req);

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
