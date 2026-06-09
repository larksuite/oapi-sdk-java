package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// GET /open-apis/corehr/v2/custom_org/querybyid
public class QuerybyidEmployeeCustomOrgSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QuerybyidEmployeeCustomOrgReq req = QuerybyidEmployeeCustomOrgReq.newBuilder()
                .jobDataCustomOrgId("7293841029445207596")
                .versionId(new String[]{})
                .objectApiName("custom_org_03")
                .userIdType("people_corehr_id")
                .build();

        // 发起请求
        QuerybyidEmployeeCustomOrgResp resp = client.corehr().v2().employeeCustomOrg().querybyid(req);

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
