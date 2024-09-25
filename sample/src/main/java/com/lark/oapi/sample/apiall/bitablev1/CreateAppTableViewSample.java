package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.CreateAppTableViewReq;
import com.lark.oapi.service.bitable.v1.model.CreateAppTableViewResp;
import com.lark.oapi.service.bitable.v1.model.ReqView;

// POST /open-apis/bitable/v1/apps/:app_token/tables/:table_id/views
public class CreateAppTableViewSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateAppTableViewReq req = CreateAppTableViewReq.newBuilder()
                .appToken("appbcbWCzen6D8dezhoCH2RpMAh")
                .tableId("tblsRc9GRRXKqhvW")
                .reqView(ReqView.newBuilder()
                        .viewName("表格视图1")
                        .viewType("grid")
                        .build())
                .build();

        // 发起请求
        CreateAppTableViewResp resp = client.bitable().v1().appTableView().create(req);

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
