package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.BatchGetEmployeeReq;
import com.lark.oapi.service.corehr.v2.model.BatchGetEmployeeReqBody;
import com.lark.oapi.service.corehr.v2.model.BatchGetEmployeeResp;

// POST /open-apis/corehr/v2/employees/batch_get
public class BatchGetEmployeeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchGetEmployeeReq req = BatchGetEmployeeReq.newBuilder()
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .batchGetEmployeeReqBody(BatchGetEmployeeReqBody.newBuilder()
                        .fields(new String[]{})
                        .employmentIds(new String[]{})
                        .personIds(new String[]{})
                        .workEmails(new String[]{})
                        .build())
                .build();

        // 发起请求
        BatchGetEmployeeResp resp = client.corehr().v2().employee().batchGet(req);

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
