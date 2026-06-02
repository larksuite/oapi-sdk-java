package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/custom_org/edit_emp_custom_org
public class EditEmpCustomOrgEmployeeCustomOrgSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        EditEmpCustomOrgEmployeeCustomOrgReq req = EditEmpCustomOrgEmployeeCustomOrgReq.newBuilder()
                .userIdType("people_corehr_id")
                .editEmpCustomOrgEmployeeCustomOrgReqBody(EditEmpCustomOrgEmployeeCustomOrgReqBody.newBuilder()
                        .userId("00067")
                        .objectApiName("custom_org_03")
                        .jobDataCustomOrgId("7293841029445207596")
                        .versionId("7293841029445207593")
                        .customOrgWithRates(new CustomOrgWithRate[]{})
                        .effectiveTime("2024-06-15")
                        .startReason("编辑雇佣信息的自定义组织")
                        .build())
                .build();

        // 发起请求
        EditEmpCustomOrgEmployeeCustomOrgResp resp = client.corehr().v2().employeeCustomOrg().editEmpCustomOrg(req);

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
