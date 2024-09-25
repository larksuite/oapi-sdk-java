package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.ListAppTableViewReq;
import com.lark.oapi.service.bitable.v1.model.ListAppTableViewResp;

// GET /open-apis/bitable/v1/apps/:app_token/tables/:table_id/views
public class ListAppTableViewSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListAppTableViewReq req = ListAppTableViewReq.newBuilder()
                .appToken("appbcbWCzen6D8dezhoCH2RpMAh")
                .tableId("tblsRc9GRRXKqhvW")
                .pageSize(10)
                .pageToken("vewTpR1urY")
                .userIdType("user_id")
                .build();

        // 发起请求
        ListAppTableViewResp resp = client.bitable().v1().appTableView().list(req);

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
