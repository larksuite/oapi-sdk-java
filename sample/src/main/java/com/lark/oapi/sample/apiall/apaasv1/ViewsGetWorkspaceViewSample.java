package com.lark.oapi.sample.apiall.apaasv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.apaas.v1.model.*;

import java.util.HashMap;

// GET /open-apis/apaas/v1/workspaces/:workspace_id/views/:view_name/records
public class ViewsGetWorkspaceViewSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ViewsGetWorkspaceViewReq req = ViewsGetWorkspaceViewReq.newBuilder()
                .workspaceId("workspace_abc")
                .viewName("view_name_1")
                .pageSize(10)
                .pageToken("")
                .select("_id,_created_at,name")
                .filter("age=gt.10")
                .order("age.desc,score.asc")
                .build();

        // 发起请求
        ViewsGetWorkspaceViewResp resp = client.apaas().v1().workspaceView().viewsGet(req);

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
