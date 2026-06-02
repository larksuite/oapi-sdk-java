package com.lark.oapi.sample.apiall.trust_partyv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.trust_party.v1.model.*;

import java.util.HashMap;

// GET /open-apis/trust_party/v1/collaboration_tenants/:target_tenant_key/collaboration_departments/:target_department_id
public class GetCollaborationTenantCollaborationDepartmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetCollaborationTenantCollaborationDepartmentReq req = GetCollaborationTenantCollaborationDepartmentReq.newBuilder()
                .targetTenantKey("4e6ac4d14bcd5071a37a39de902c7141")
                .targetDepartmentId("od-4e6ac4d14bcd5071a37a39de902c7141")
                .targetDepartmentIdType("department_id")
                .build();

        // 发起请求
        GetCollaborationTenantCollaborationDepartmentResp resp = client.trustParty().v1().collaborationTenantCollaborationDepartment().get(req);

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
