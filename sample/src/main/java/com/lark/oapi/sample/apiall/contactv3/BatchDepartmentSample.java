package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.BatchDepartmentReq;
import com.lark.oapi.service.contact.v3.model.BatchDepartmentResp;

// GET /open-apis/contact/v3/departments/batch
public class BatchDepartmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchDepartmentReq req = BatchDepartmentReq.newBuilder()
                .departmentIds(new String[]{})
                .departmentIdType("open_department_id")
                .userIdType("open_id")
                .build();

        // 发起请求
        BatchDepartmentResp resp = client.contact().department().batch(req);

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
