package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.ListJobRequirementSchemaReq;
import com.lark.oapi.service.hire.v1.model.ListJobRequirementSchemaResp;

// GET /open-apis/hire/v1/job_requirement_schemas
public class ListJobRequirementSchemaSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListJobRequirementSchemaReq req = ListJobRequirementSchemaReq.newBuilder()
                .pageToken("1231231987")
                .pageSize(100)
                .build();

        // 发起请求
        ListJobRequirementSchemaResp resp = client.hire().jobRequirementSchema().list(req);

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
