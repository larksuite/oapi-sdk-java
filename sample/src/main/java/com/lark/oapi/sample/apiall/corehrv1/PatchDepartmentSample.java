package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v1.model.Enum;

// PATCH /open-apis/corehr/v1/departments/:department_id
public class PatchDepartmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchDepartmentReq req = PatchDepartmentReq.newBuilder()
                .departmentId("6969828847121885087")
                .clientToken("12454646")
                .userIdType("people_corehr_id")
                .departmentIdType("people_corehr_department_id")
                .department(Department.newBuilder()
                        .id("4719456877659520852")
                        .subType(Enum.newBuilder().build())
                        .manager("6893013238632416776")
                        .isConfidential(true)
                        .hiberarchyCommon(HiberarchyCommon.newBuilder().build())
                        .effectiveTime("2020-05-01 00:00:00")
                        .customFields(new ObjectFieldData[]{})
                        .costCenterId("7142384817131652652")
                        .staffingModel(Enum.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        PatchDepartmentResp resp = client.corehr().v1().department().patch(req);

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
