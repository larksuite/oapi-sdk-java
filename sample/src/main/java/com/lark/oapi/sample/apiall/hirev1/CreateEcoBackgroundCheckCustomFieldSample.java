package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.CreateEcoBackgroundCheckCustomFieldReq;
import com.lark.oapi.service.hire.v1.model.CreateEcoBackgroundCheckCustomFieldResp;
import com.lark.oapi.service.hire.v1.model.EcoBackgroundCheckCustomField;
import com.lark.oapi.service.hire.v1.model.EcoBackgroundCheckCustomFieldData;

// POST /open-apis/hire/v1/eco_background_check_custom_fields
public class CreateEcoBackgroundCheckCustomFieldSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateEcoBackgroundCheckCustomFieldReq req = CreateEcoBackgroundCheckCustomFieldReq.newBuilder()
                .ecoBackgroundCheckCustomField(EcoBackgroundCheckCustomField.newBuilder()
                        .accountId("6995842370159937061")
                        .customFieldList(new EcoBackgroundCheckCustomFieldData[]{})
                        .build())
                .build();

        // 发起请求
        CreateEcoBackgroundCheckCustomFieldResp resp = client.hire().ecoBackgroundCheckCustomField().create(req);

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
