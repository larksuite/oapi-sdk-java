package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// GET /open-apis/corehr/v2/employees/international_assignments
public class ListEmployeesInternationalAssignmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListEmployeesInternationalAssignmentReq req = ListEmployeesInternationalAssignmentReq.newBuilder()
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .pageSize(200)
                .pageToken("123456")
                .employmentIds(new String[]{})
                .internationalAssignmentIds(new String[]{})
                .effectiveTime("")
                .expirationTime("")
                .employmentStatusList(new String[]{})
                .workLocationIdList(new String[]{})
                .departmentIdList(new String[]{})
                .directManagerIdList(new String[]{})
                .dottedLineManagerIdList(new String[]{})
                .positionIdList(new String[]{})
                .jobIdList(new String[]{})
                .jobFamilyIdList(new String[]{})
                .jobLevelIdList(new String[]{})
                .jobGradeIdList(new String[]{})
                .workingHoursTypeIdList(new String[]{})
                .serviceCompanyList(new String[]{})
                .weeklyWorkingHoursV2(10.0)
                .workShiftList(new String[]{})
                .compensationTypeList(new String[]{})
                .internationalAssignmentExpectedEndDate("")
                .internationalAssignmentStatusList(new String[]{})
                .internationalAssignmentTypeList(new String[]{})
                .workCalendarIdList(new String[]{})
                .build();

        // 发起请求
        ListEmployeesInternationalAssignmentResp resp = client.corehr().v2().employeesInternationalAssignment().list(req);

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
