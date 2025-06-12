package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/employees/international_assignments
public class CreateEmployeesInternationalAssignmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateEmployeesInternationalAssignmentReq req = CreateEmployeesInternationalAssignmentReq.newBuilder()
                .clientToken("12454646")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .employeesInternationalAssignmentReq(EmployeesInternationalAssignmentReq.newBuilder()
                        .workLocationId("7127921432117937708")
                        .serviceCompany("7127921432117937708")
                        .workShift("work_shift")
                        .weeklyWorkingHoursV2(8.0)
                        .workingHoursTypeId("7127921432117937708")
                        .employeeTypeId("7127921432117937708")
                        .departmentId("7127921432117937708")
                        .jobId("7127921432117937708")
                        .jobFamilyId("7127921432117937708")
                        .jobLevelId("7127921432117937708")
                        .jobGradeId("7127921432117937708")
                        .compensationType("daily")
                        .directManagerId("7127921432117937708")
                        .dottedLineManagerId("7127921432117937708")
                        .workCalendarId("7127921432117937708")
                        .positionId("7127921432117937708")
                        .employmentId("7127921432117937708")
                        .customFields(new ObjectFieldData[]{})
                        .internationalAssignmentReason("xxx 项目派遣")
                        .description("xxx 项目")
                        .internationalAssignmentExpectedEndDate("2024-01-02")
                        .internationalAssignmentType("global_assignment")
                        .effectiveTime("2024-01-02")
                        .expirationTime("2024-01-02")
                        .build())
                .build();

        // 发起请求
        CreateEmployeesInternationalAssignmentResp resp = client.corehr().v2().employeesInternationalAssignment().create(req);

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
