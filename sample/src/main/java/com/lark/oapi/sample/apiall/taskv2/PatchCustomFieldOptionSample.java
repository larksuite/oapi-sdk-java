package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.InputOption;
import com.lark.oapi.service.task.v2.model.PatchCustomFieldOptionReq;
import com.lark.oapi.service.task.v2.model.PatchCustomFieldOptionReqBody;
import com.lark.oapi.service.task.v2.model.PatchCustomFieldOptionResp;

// PATCH /open-apis/task/v2/custom_fields/:custom_field_guid/options/:option_guid
public class PatchCustomFieldOptionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchCustomFieldOptionReq req = PatchCustomFieldOptionReq.newBuilder()
                .customFieldGuid("b13adf3c-cad6-4e02-8929-550c112b5633")
                .optionGuid("b13adf3c-cad6-4e02-8929-550c112b5633")
                .patchCustomFieldOptionReqBody(PatchCustomFieldOptionReqBody.newBuilder()
                        .option(InputOption.newBuilder().build())
                        .updateFields(new String[]{})
                        .build())
                .build();

        // 发起请求
        PatchCustomFieldOptionResp resp = client.task().v2().customFieldOption().patch(req);

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
