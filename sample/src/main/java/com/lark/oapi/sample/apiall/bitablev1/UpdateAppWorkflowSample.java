package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;

import java.util.HashMap;

// PUT /open-apis/bitable/v1/apps/:app_token/workflows/:workflow_id
public class UpdateAppWorkflowSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateAppWorkflowReq req = UpdateAppWorkflowReq.newBuilder()
                .appToken("appbcbWCzen6D8dezh")
                .workflowId("730887xxxx552638996")
                .updateAppWorkflowReqBody(UpdateAppWorkflowReqBody.newBuilder()
                        .status("Enable")
                        .build())
                .build();

        // 发起请求
        UpdateAppWorkflowResp resp = client.bitable().v1().appWorkflow().update(req);

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
