package com.lark.oapi.sample.apiall.apaasv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.apaas.v1.model.*;

import java.util.HashMap;

// POST /open-apis/apaas/v1/user_tasks/:task_id/cc
public class CcUserTaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CcUserTaskReq req = CcUserTaskReq.newBuilder()
                .taskId("1234")
                .ccUserTaskReqBody(CcUserTaskReqBody.newBuilder()
                        .ccUserIds(new String[]{})
                        .operatorUserId("1234")
                        .build())
                .build();

        // 发起请求
        CcUserTaskResp resp = client.apaas().v1().userTask().cc(req);

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
