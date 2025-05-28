package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// PATCH /open-apis/corehr/v2/custom_orgs/:org_id
public class PatchCustomOrgSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchCustomOrgReq req = PatchCustomOrgReq.newBuilder()
                .orgId("6862995757234914824")
                .clientToken("1245464678")
                .userIdType("people_corehr_id")
                .customOrgUpdate(CustomOrgUpdate.newBuilder()
                        .objectApiName("apiname__c")
                        .names(new I18n[]{})
                        .code("MDPD00000023")
                        .parentId("6862995757234914824")
                        .managerIds(new String[]{})
                        .description(new I18n[]{})
                        .effectiveTime("2020-01-01")
                        .orgRoles(new OrgRoleUpdate[]{})
                        .customFields(new CustomFieldData[]{})
                        .build())
                .build();

        // 发起请求
        PatchCustomOrgResp resp = client.corehr().v2().customOrg().patch(req);

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
