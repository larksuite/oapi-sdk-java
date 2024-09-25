package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.CreateCustomFieldOptionReq;
import com.lark.oapi.service.task.v2.model.CreateCustomFieldOptionResp;
import com.lark.oapi.service.task.v2.model.InputOption;

// POST /open-apis/task/v2/custom_fields/:custom_field_guid/options
public class CreateCustomFieldOptionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateCustomFieldOptionReq req = CreateCustomFieldOptionReq.newBuilder()
                .customFieldGuid("b13adf3c-cad6-4e02-8929-550c112b5633")
                .inputOption(InputOption.newBuilder()
                        .name("高优")
                        .colorIndex(10)
                        .insertBefore("2bd905f8-ef38-408b-aa1f-2b2ad33b2913")
                        .insertAfter("b13adf3c-cad6-4e02-8929-550c112b5633")
                        .isHidden(false)
                        .build())
                .build();

        // 发起请求
        CreateCustomFieldOptionResp resp = client.task().v2().customFieldOption().create(req);

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
