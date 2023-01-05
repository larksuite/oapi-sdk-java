package com.lark.oapi.sample.apiall.searchv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.search.v2.model.*;

// POST /open-apis/search/v2/schemas
public class CreateSchemaSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateSchemaReq req = CreateSchemaReq.newBuilder()
                .validateOnly(false)
                .schema(Schema.newBuilder()
                        .properties(new SchemaProperty[]{})
                        .display(SchemaDisplay.newBuilder().build())
                        .schemaId("jira_schema")
                        .build())
                .build();

        // 发起请求
        CreateSchemaResp resp = client.search().schema().create(req);

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
