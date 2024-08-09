package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v1.model.Enum;

// GET /open-apis/corehr/v1/compensation_standards/match
public class MatchCompensationStandardSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        MatchCompensationStandardReq req = MatchCompensationStandardReq.newBuilder()
                .userIdType("open_id")
                .departmentIdType("people_corehr_department_id")
                .employmentId("7124293751317038636")
                .referenceObjectApi("cpst_item")
                .referenceObjectId("7156853394442044972")
                .departmentId("od-53899868dd0da32292a2d809f0518c8f")
                .workLocationId("7094869485965870636")
                .companyId("7091599096804394540")
                .jobFamilyId("7039313681989502508")
                .jobLevelId("7086415175263258156")
                .employeeTypeId("7039310401359775276")
                .recruitmentType("experienced_professionals")
                .cpstChangeReasonId("6967639606963471117")
                .cpstPlanId("6967639606963471118")
                .cpstSalaryLevelId("6967639606963471119")
                .effectiveTime("1660924800000")
                .build();

        // 发起请求
        MatchCompensationStandardResp resp = client.corehr().v1().compensationStandard().match(req);

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
