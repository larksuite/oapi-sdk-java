package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/workforce_plan_details/batch
public class BatchWorkforcePlanDetailSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchWorkforcePlanDetailReq req = BatchWorkforcePlanDetailReq.newBuilder()
                .pageToken("")
                .pageSize(100)
                .batchWorkforcePlanDetailReqBody(BatchWorkforcePlanDetailReqBody.newBuilder()
                        .workforcePlanId("781234834512")
                        .isCentralizedReportingProject(false)
                        .centralizedReportingProjectId("7140964208476371111")
                        .departmentIds(new String[]{})
                        .employeeTypeIds(new String[]{})
                        .workLocationIds(new String[]{})
                        .jobFamilyIds(new String[]{})
                        .jobLevelIds(new String[]{})
                        .jobIds(new String[]{})
                        .costCenterIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        BatchWorkforcePlanDetailResp resp = client.corehr().v2().workforcePlanDetail().batch(req);

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
