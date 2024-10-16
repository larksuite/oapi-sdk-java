package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.*;

import java.util.HashMap;

// PATCH /open-apis/task/v2/custom_fields/:custom_field_guid
public class PatchCustomFieldSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchCustomFieldReq req = PatchCustomFieldReq.newBuilder()
                .customFieldGuid("5ffbe0ca-6600-41e0-a634-2b38cbcf13b8")
                .userIdType("open_id")
                .patchCustomFieldReqBody(PatchCustomFieldReqBody.newBuilder()
                        .customField(InputCustomField.newBuilder().build())
                        .updateFields(new String[]{})
                        .build())
                .build();

        // 发起请求
        PatchCustomFieldResp resp = client.task().v2().customField().patch(req);

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
