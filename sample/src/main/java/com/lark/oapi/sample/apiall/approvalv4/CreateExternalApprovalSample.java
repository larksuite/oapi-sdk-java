package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.*;

import java.util.HashMap;

// POST /open-apis/approval/v4/external_approvals
public class CreateExternalApprovalSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateExternalApprovalReq req = CreateExternalApprovalReq.newBuilder()
                .departmentIdType("open_department_id")
                .userIdType("user_id")
                .externalApproval(ExternalApproval.newBuilder()
                        .approvalName("E78F1022-A166-447C-8320-E151DA90D70F")
                        .approvalCode("permission_test")
                        .groupCode("work_group")
                        .groupName("@i18n@2")
                        .description("@i18n@2")
                        .external(ApprovalCreateExternal.newBuilder().build())
                        .viewers(new ApprovalCreateViewers[]{})
                        .i18nResources(new I18nResource[]{})
                        .managers(new String[]{})
                        .build())
                .build();

        // 发起请求
        CreateExternalApprovalResp resp = client.approval().v4().externalApproval().create(req);

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
