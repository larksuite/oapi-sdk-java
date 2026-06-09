package com.lark.oapi.sample.apiall.trust_partyv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.trust_party.v1.model.*;

import java.util.HashMap;

// GET /open-apis/trust_party/v1/collaboration_tenants/:target_tenant_key/visible_organization
public class VisibleOrganizationCollaborationTenantSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        VisibleOrganizationCollaborationTenantReq req = VisibleOrganizationCollaborationTenantReq.newBuilder()
                .targetTenantKey("4e6ac4d14bcd5071a37a39de902c7141")
                .departmentIdType("department_id")
                .targetDepartmentId("od-4e6ac4d14bcd5071a37a39de902c7141")
                .pageToken("AQD9/Rn9eij9Pm39ED40/TIx6jupqdAcfLY%2B51xMvNU=")
                .pageSize(100)
                .groupIdType("group_id")
                .targetGroupId("od-4e6ac4d14bcd5071a37a39de902c7141")
                .build();

        // 发起请求
        VisibleOrganizationCollaborationTenantResp resp = client.trustParty().v1().collaborationTenant().visibleOrganization(req);

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
