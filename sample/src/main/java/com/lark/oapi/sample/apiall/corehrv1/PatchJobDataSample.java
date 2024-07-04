package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v1.model.Enum;

// PATCH /open-apis/corehr/v1/job_datas/:job_data_id
public class PatchJobDataSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchJobDataReq req = PatchJobDataReq.newBuilder()
                .jobDataId("151515")
                .clientToken("12454646")
                .userIdType("people_corehr_id")
                .departmentIdType("people_corehr_department_id")
                .jobData(JobData.newBuilder()
                        .versionId("6890452208593372697")
                        .jobLevelId("6890452208593372679")
                        .jobGradeId("6890452208593372679")
                        .employeeTypeId("6890452208593372679")
                        .workingHoursTypeId("6890452208593372679")
                        .workLocationId("6890452208593372679")
                        .departmentId("6890452208593372679")
                        .jobId("6890452208593372679")
                        .probationStartDate("2018-03-16T00:00:00")
                        .probationEndDate("2019-05-24T00:00:00")
                        .primaryJobData(true)
                        .effectiveTime("2020-05-01 00:00:00")
                        .expirationTime("2020-05-02 00:00:00")
                        .jobFamilyId("1245678")
                        .assignmentStartReason(Enum.newBuilder().build())
                        .probationExpectedEndDate("2006-01-02")
                        .directManagerId("6890452208593372679")
                        .dottedLineManagerIdList(new String[]{})
                        .secondDirectManagerId("6890452208593372679")
                        .costCenterRate(new SupportCostCenterItem[]{})
                        .workShift(Enum.newBuilder().build())
                        .compensationType(Enum.newBuilder().build())
                        .serviceCompany("6890452208593372680")
                        .build())
                .build();

        // 发起请求
        PatchJobDataResp resp = client.corehr().v1().jobData().patch(req);

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
