package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/custom_orgs/delete_org
public class DeleteOrgCustomOrgSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteOrgCustomOrgReq req = DeleteOrgCustomOrgReq.newBuilder()
                .deleteOrgCustomOrgReqBody(DeleteOrgCustomOrgReqBody.newBuilder()
                        .orgId("6862995757234914824")
                        .objectApiName("apiname__c")
                        .build())
                .build();

        // 发起请求
        DeleteOrgCustomOrgResp resp = client.corehr().v2().customOrg().deleteOrg(req);

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
