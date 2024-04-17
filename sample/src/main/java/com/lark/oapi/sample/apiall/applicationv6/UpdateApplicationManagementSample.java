package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.UpdateApplicationManagementReq;
import com.lark.oapi.service.application.v6.model.UpdateApplicationManagementReqBody;
import com.lark.oapi.service.application.v6.model.UpdateApplicationManagementResp;

// PUT /open-apis/application/v6/applications/:app_id/management
public class UpdateApplicationManagementSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateApplicationManagementReq req = UpdateApplicationManagementReq.newBuilder()
                .appId("cli_a4517c8461f8100a")
                .updateApplicationManagementReqBody(UpdateApplicationManagementReqBody.newBuilder()
                        .enable(true)
                        .build())
                .build();

        // 发起请求
        UpdateApplicationManagementResp resp = client.application().v6().applicationManagement().update(req);

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