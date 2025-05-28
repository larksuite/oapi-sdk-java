package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/custom_orgs
public class CreateCustomOrgSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateCustomOrgReq req = CreateCustomOrgReq.newBuilder()
                .clientToken("1245464678")
                .userIdType("people_corehr_id")
                .customOrgCreate(CustomOrgCreate.newBuilder()
                        .objectApiName("apiname__c")
                        .names(new I18n[]{})
                        .code("MDPD00000023")
                        .parentId("6862995757234914824")
                        .managerIds(new String[]{})
                        .description(new I18n[]{})
                        .effectiveTime("2020-01-01")
                        .orgRoles(new OrgRoleUpdate[]{})
                        .matchRuleGroups(new MatchRules[]{})
                        .customFields(new CustomFieldData[]{})
                        .build())
                .build();

        // 发起请求
        CreateCustomOrgResp resp = client.corehr().v2().customOrg().create(req);

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
