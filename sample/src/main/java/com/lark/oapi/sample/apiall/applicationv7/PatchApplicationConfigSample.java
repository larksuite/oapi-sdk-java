package com.lark.oapi.sample.apiall.applicationv7;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v7.model.*;

import java.util.HashMap;

// PATCH /open-apis/application/v7/applications/:app_id/config
public class PatchApplicationConfigSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchApplicationConfigReq req = PatchApplicationConfigReq.newBuilder()
                .appId("cli_a306c5476fb8d00c")
                .departmentIdType("open_department_id")
                .userIdType("open_id")
                .patchApplicationConfigReqBody(PatchApplicationConfigReqBody.newBuilder()
                        .scope(AppConfigScope.newBuilder().build())
                        .event(AppConfigEvent.newBuilder().build())
                        .security(AppConfigSecurity.newBuilder().build())
                        .visibility(AppConfigVisibility.newBuilder().build())
                        .contacts(AppConfigContactsRange.newBuilder().build())
                        .eventAndCallbackEncryptStrategy(EventAndCallbackEncryptStrategy.newBuilder().build())
                        .callback(AppConfigCallback.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        PatchApplicationConfigResp resp = client.application().v7().applicationConfig().patch(req);

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
