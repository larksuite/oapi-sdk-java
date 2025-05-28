package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// PUT /open-apis/hire/v1/job_requirements/:job_requirement_id
public class UpdateJobRequirementSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateJobRequirementReq req = UpdateJobRequirementReq.newBuilder()
                .jobRequirementId("623455234")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .jobLevelIdType("people_admin_job_level_id")
                .jobFamilyIdType("people_admin_job_category_id")
                .employeeTypeIdType("people_admin_employee_type_id")
                .jobRequirement(JobRequirement.newBuilder()
                        .name("test")
                        .displayProgress(1)
                        .headCount(11)
                        .recruitmentTypeId("1618209327096")
                        .employeeTypeId("6807409776231254285")
                        .maxLevelId("123")
                        .minLevelId("11")
                        .sequenceId("111")
                        .category(1)
                        .departmentId("1111")
                        .recruiterIdList(new String[]{})
                        .jrHiringManagerIdList(new String[]{})
                        .directLeaderIdList(new String[]{})
                        .startTime("1625729379000")
                        .deadline("1625729379000")
                        .priority(1)
                        .requiredDegree(1)
                        .maxSalary("123")
                        .minSalary("11")
                        .addressId("11")
                        .description("11")
                        .customizedDataList(new JobRequirementCustomizedData[]{})
                        .processType(1)
                        .jobTypeId("6930815272790114324")
                        .jobIdList(new String[]{})
                        .employmentJobId("123")
                        .positionId("123")
                        .updateOption(JobRequirementUpdateOption.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        UpdateJobRequirementResp resp = client.hire().v1().jobRequirement().update(req);

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
