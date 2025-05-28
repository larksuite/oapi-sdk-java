package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.*;

import java.util.HashMap;

// PUT /open-apis/application/v6/applications/:app_id/owner
public class UpdateApplicationOwnerSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateApplicationOwnerReq req = UpdateApplicationOwnerReq.newBuilder()
                .appId("cli_a306c5476fb8d00c")
                .userIdType("open_id")
                .updateApplicationOwnerReqBody(UpdateApplicationOwnerReqBody.newBuilder()
                        .ownerId("ou_84aad35d084aa403a838cf73ee184670")
                        .build())
                .build();

        // 发起请求
        UpdateApplicationOwnerResp resp = client.application().v6().applicationOwner().update(req);

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
