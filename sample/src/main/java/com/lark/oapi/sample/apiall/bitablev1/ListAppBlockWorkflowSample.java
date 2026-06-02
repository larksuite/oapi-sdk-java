package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;

import java.util.HashMap;

// GET /open-apis/bitable/v1/apps/:app_token/block_workflows
public class ListAppBlockWorkflowSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListAppBlockWorkflowReq req = ListAppBlockWorkflowReq.newBuilder()
                .appToken("U9sGw5wyoiOIqdk1C4mcbYmMnbt")
                .build();

        // 发起请求
        ListAppBlockWorkflowResp resp = client.bitable().v1().appBlockWorkflow().list(req);

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
