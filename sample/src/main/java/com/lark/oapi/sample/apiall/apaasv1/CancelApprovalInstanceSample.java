package com.lark.oapi.sample.apiall.apaasv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.apaas.v1.model.*;

import java.util.HashMap;

// POST /open-apis/apaas/v1/approval_instances/:approval_instance_id/cancel
public class CancelApprovalInstanceSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CancelApprovalInstanceReq req = CancelApprovalInstanceReq.newBuilder()
                .approvalInstanceId("1788173550023689")
                .cancelApprovalInstanceReqBody(CancelApprovalInstanceReqBody.newBuilder()
                        .userId("")
                        .opinion("撤销了")
                        .build())
                .build();

        // 发起请求
        CancelApprovalInstanceResp resp = client.apaas().v1().approvalInstance().cancel(req);

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
