package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// PUT /open-apis/corehr/v2/processes/:process_id/approvers/:approver_id
public class UpdateProcessApproverSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateProcessApproverReq req = UpdateProcessApproverReq.newBuilder()
                .processId("7328345170959681068")
                .approverId("7328345235136726572")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .processApprover(ProcessApprover.newBuilder()
                        .status(2)
                        .userId("ou_91791271921729102012")
                        .systemApproval(false)
                        .reason("原因自定义字符串")
                        .fieldValuesV2(new ProcessFormVariableV2[]{})
                        .build())
                .build();

        // 发起请求
        UpdateProcessApproverResp resp = client.corehr().v2().processApprover().update(req);

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
