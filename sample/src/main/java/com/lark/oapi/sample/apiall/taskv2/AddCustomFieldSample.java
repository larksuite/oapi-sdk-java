package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.*;

import java.util.HashMap;

// POST /open-apis/task/v2/custom_fields/:custom_field_guid/add
public class AddCustomFieldSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        AddCustomFieldReq req = AddCustomFieldReq.newBuilder()
                .customFieldGuid("0110a4bd-f24b-4a93-8c1a-1732b94f9593")
                .addCustomFieldReqBody(AddCustomFieldReqBody.newBuilder()
                        .resourceType("tasklist")
                        .resourceId("0110a4bd-f24b-4a93-8c1a-1732b94f9593")
                        .build())
                .build();

        // 发起请求
        AddCustomFieldResp resp = client.task().v2().customField().add(req);

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
