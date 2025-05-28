package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// PATCH /open-apis/corehr/v2/employees/additional_jobs/:additional_job_id
public class PatchEmployeesAdditionalJobSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchEmployeesAdditionalJobReq req = PatchEmployeesAdditionalJobReq.newBuilder()
                .additionalJobId("12454646")
                .clientToken("12454646")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .employeesAdditionalJobEdit(EmployeesAdditionalJobEdit.newBuilder()
                        .employeeTypeId("6890452208593372679")
                        .workingHoursTypeId("6890452208593372679")
                        .workLocationId("6890452208593372679")
                        .departmentId("6890452208593372679")
                        .jobId("6890452208593372679")
                        .jobLevelId("6890452208593372679")
                        .jobFamilyId("1245678")
                        .startDate("2020-05-01")
                        .endDate("2020-05-02")
                        .directManagerId("6890452208593372680")
                        .dottedLineManagerId("6890452208593372680")
                        .workShift(Enum.newBuilder().build())
                        .compensationType(Enum.newBuilder().build())
                        .serviceCompany("6890452208593372680")
                        .weeklyWorkingHours("5")
                        .workCalendarId("6890452208593372680")
                        .positionId("6890452208593372680")
                        .employeeSubtypeId("6890452208593372680")
                        .build())
                .build();

        // 发起请求
        PatchEmployeesAdditionalJobResp resp = client.corehr().v2().employeesAdditionalJob().patch(req);

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
