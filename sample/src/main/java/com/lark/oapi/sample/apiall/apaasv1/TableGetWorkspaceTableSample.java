package com.lark.oapi.sample.apiall.apaasv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.apaas.v1.model.*;

import java.util.HashMap;

// GET /open-apis/apaas/v1/workspaces/:workspace_id/tables/:table_name
public class TableGetWorkspaceTableSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        TableGetWorkspaceTableReq req = TableGetWorkspaceTableReq.newBuilder()
                .workspaceId("workspace_abc")
                .tableName("table_name_1")
                .build();

        // 发起请求
        TableGetWorkspaceTableResp resp = client.apaas().v1().workspaceTable().tableGet(req);

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
