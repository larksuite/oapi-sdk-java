package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/positions
public class CreatePositionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreatePositionReq req = CreatePositionReq.newBuilder()
                .clientToken("1245464678")
                .departmentIdType("people_corehr_department_id")
                .positionCreate(PositionCreate.newBuilder()
                        .code("A01234")
                        .names(new I18n[]{})
                        .descriptions(new I18n[]{})
                        .jobFamilyIds(new String[]{})
                        .costCenterId("4719519211875096301")
                        .jobId("4719519211875096301")
                        .jobLevelIds(new String[]{})
                        .employeeTypeIds(new String[]{})
                        .jobGradeIds(new String[]{})
                        .workLocationIds(new String[]{})
                        .workingHoursTypeId("4719519211875096301")
                        .departmentId("4719519211875096301")
                        .directLeaderId("4719519211875096301")
                        .dottedLineLeaderId("4719519211875096301")
                        .isKeyPosition(true)
                        .effectiveTime("2020-05-01")
                        .customFields(new CustomFieldData[]{})
                        .isPreferManualEncoding(false)
                        .build())
                .build();

        // 发起请求
        CreatePositionResp resp = client.corehr().v2().position().create(req);

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
