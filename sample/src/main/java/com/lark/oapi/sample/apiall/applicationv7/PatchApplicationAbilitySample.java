package com.lark.oapi.sample.apiall.applicationv7;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v7.model.*;

import java.util.HashMap;

// PATCH /open-apis/application/v7/applications/:app_id/ability
public class PatchApplicationAbilitySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchApplicationAbilityReq req = PatchApplicationAbilityReq.newBuilder()
                .appId("cli_a42d0b833ab8d01b")
                .patchApplicationAbilityReqBody(PatchApplicationAbilityReqBody.newBuilder()
                        .webApp(AppAbilityWeb.newBuilder().build())
                        .bot(AppAbilityBot.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        PatchApplicationAbilityResp resp = client.application().v7().applicationAbility().patch(req);

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
