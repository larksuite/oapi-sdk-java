package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/employees/additional_jobs/batch
public class BatchEmployeesAdditionalJobSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchEmployeesAdditionalJobReq req = BatchEmployeesAdditionalJobReq.newBuilder()
                .pageSize(100)
                .pageToken("Njg5MTI1MTcyMjYzMTg5MDQ0NQ==")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .batchEmployeesAdditionalJobReqBody(BatchEmployeesAdditionalJobReqBody.newBuilder()
                        .employmentIds(new String[]{})
                        .additionalJobIds(new String[]{})
                        .startDate(EmployeesAdditionalJobBatchReqDate.newBuilder().build())
                        .endDate(EmployeesAdditionalJobBatchReqDate.newBuilder().build())
                        .dataDate("2024-01-02")
                        .isEffective(true)
                        .build())
                .build();

        // 发起请求
        BatchEmployeesAdditionalJobResp resp = client.corehr().v2().employeesAdditionalJob().batch(req);

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
