package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/departments/batch_get
public class BatchGetDepartmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchGetDepartmentReq req = BatchGetDepartmentReq.newBuilder()
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .batchGetDepartmentReqBody(BatchGetDepartmentReqBody.newBuilder()
                        .departmentIdList(new String[]{})
                        .fields(new String[]{})
                        .departmentNameList(new String[]{})
                        .build())
                .build();

        // 发起请求
        BatchGetDepartmentResp resp = client.corehr().v2().department().batchGet(req);

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
