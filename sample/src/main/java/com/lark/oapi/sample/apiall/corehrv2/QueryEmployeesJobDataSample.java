package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/employees/job_datas/query
public class QueryEmployeesJobDataSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryEmployeesJobDataReq req = QueryEmployeesJobDataReq.newBuilder()
                .pageSize(100)
                .pageToken("6891251722631890445")
                .userIdType("open_id")
                .departmentIdType("people_corehr_department_id")
                .queryEmployeesJobDataReqBody(QueryEmployeesJobDataReqBody.newBuilder()
                        .getAllVersion(false)
                        .dataDate("2020-01-01")
                        .effectiveDateStart("2020-01-01")
                        .effectiveDateEnd("2020-01-01")
                        .departmentId("6891251722631890445")
                        .employmentIds(new String[]{})
                        .primaryJobData(true)
                        .assignmentStartReasons(new String[]{})
                        .build())
                .build();

        // 发起请求
        QueryEmployeesJobDataResp resp = client.corehr().v2().employeesJobData().query(req);

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
