package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// GET /open-apis/hire/v1/registration_schemas
public class ListRegistrationSchemaSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListRegistrationSchemaReq req = ListRegistrationSchemaReq.newBuilder()
                .pageSize(10)
                .pageToken("6930815272790114324")
                .scenario(5)
                .build();

        // 发起请求
        ListRegistrationSchemaResp resp = client.hire().v1().registrationSchema().list(req);

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
