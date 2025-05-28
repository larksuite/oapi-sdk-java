package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v1.model.Enum;

// POST /open-apis/corehr/v1/security_groups/query
public class QuerySecurityGroupSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QuerySecurityGroupReq req = QuerySecurityGroupReq.newBuilder()
                .departmentIdType("people_corehr_department_id")
                .querySecurityGroupReqBody(QuerySecurityGroupReqBody.newBuilder()
                        .itemList(new BpRoleOrganization[]{})
                        .updatedAtGte("1729773628")
                        .updatedAtLte("1729773628")
                        .build())
                .build();

        // 发起请求
        QuerySecurityGroupResp resp = client.corehr().v1().securityGroup().query(req);

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
