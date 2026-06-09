package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/probation/edit
public class EditProbationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        EditProbationReq req = EditProbationReq.newBuilder()
                .userIdType("open_id")
                .editProbationReqBody(EditProbationReqBody.newBuilder()
                        .employmentId("7140964208476371111")
                        .probationStartDate("2024-01-01")
                        .probationExpectedEndDate("2025-01-01")
                        .probationOutcome("passed")
                        .actualProbationEndDate("2025-01-01")
                        .probationExtendExpectedEndDate("2025-01-01")
                        .extendedProbationPeriodDuration(1)
                        .extendedProbationPeriodUnit("day")
                        .notes("试用期表现良好。")
                        .selfReview("试用期表现良好。")
                        .customFields(new CustomFieldData[]{})
                        .build())
                .build();

        // 发起请求
        EditProbationResp resp = client.corehr().v2().probation().edit(req);

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
