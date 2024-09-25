package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.ListDepartmentReq;
import com.lark.oapi.service.contact.v3.model.ListDepartmentResp;

// GET /open-apis/contact/v3/departments
public class ListDepartmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListDepartmentReq req = ListDepartmentReq.newBuilder()
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .parentDepartmentId("od-80884c92e43e")
                .fetchChild(false)
                .pageSize(10)
                .pageToken("5bc498db4617")
                .build();

        // 发起请求
        ListDepartmentResp resp = client.contact().v3().department().list(req);

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
