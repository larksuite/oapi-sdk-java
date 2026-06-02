package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// PATCH /open-apis/corehr/v2/positions/:position_id
public class PatchPositionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchPositionReq req = PatchPositionReq.newBuilder()
                .positionId("6862995757234914824")
                .clientToken("1245464678")
                .departmentIdType("people_corehr_department_id")
                .positionUpdate(PositionUpdate.newBuilder()
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
        PatchPositionResp resp = client.corehr().v2().position().patch(req);

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
