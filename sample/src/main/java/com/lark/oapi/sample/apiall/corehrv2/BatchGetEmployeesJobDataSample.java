package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/employees/job_datas/batch_get
public class BatchGetEmployeesJobDataSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchGetEmployeesJobDataReq req = BatchGetEmployeesJobDataReq.newBuilder()
                .userIdType("open_id")
                .departmentIdType("people_corehr_department_id")
                .batchGetEmployeesJobDataReqBody(BatchGetEmployeesJobDataReqBody.newBuilder()
                        .employmentIds(new String[]{})
                        .getAllVersion(false)
                        .effectiveDateStart("2020-01-01")
                        .effectiveDateEnd("2020-01-01")
                        .dataDate("2020-01-01")
                        .primaryJobData(true)
                        .assignmentStartReasons(new String[]{})
                        .build())
                .build();

        // 发起请求
        BatchGetEmployeesJobDataResp resp = client.corehr().v2().employeesJobData().batchGet(req);

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
