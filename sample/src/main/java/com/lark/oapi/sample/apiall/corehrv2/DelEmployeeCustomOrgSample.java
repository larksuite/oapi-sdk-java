package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/custom_org/del
public class DelEmployeeCustomOrgSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DelEmployeeCustomOrgReq req = DelEmployeeCustomOrgReq.newBuilder()
                .userIdType("people_corehr_id")
                .delEmployeeCustomOrgReqBody(DelEmployeeCustomOrgReqBody.newBuilder()
                        .userId("7358801371828602412")
                        .jobDataCustomOrgId("7293841029445207596")
                        .versionId("7293841029445207593")
                        .objectApiName("custom_org_03")
                        .build())
                .build();

        // 发起请求
        DelEmployeeCustomOrgResp resp = client.corehr().v2().employeeCustomOrg().del(req);

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
