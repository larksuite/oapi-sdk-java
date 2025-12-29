package com.lark.oapi.sample.apiall.apaasv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.apaas.v1.model.*;

import java.util.HashMap;

// POST /open-apis/apaas/v1/workspaces/:workspace_id/tables/:table_name/records
public class RecordsPostWorkspaceTableSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        RecordsPostWorkspaceTableReq req = RecordsPostWorkspaceTableReq.newBuilder()
                .workspaceId("workspace_abc")
                .tableName("table_name_1")
                .columns("name,age")
                .onConflict("user_id,product_id")
                .recordsPostWorkspaceTableReqBody(RecordsPostWorkspaceTableReqBody.newBuilder()
                        .records("")
                        .build())
                .build();

        // 发起请求
        RecordsPostWorkspaceTableResp resp = client.apaas().v1().workspaceTable().recordsPost(req);

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
