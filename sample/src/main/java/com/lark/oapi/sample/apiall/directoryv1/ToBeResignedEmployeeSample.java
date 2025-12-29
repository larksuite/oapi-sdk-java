package com.lark.oapi.sample.apiall.directoryv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.directory.v1.model.*;

import java.util.HashMap;

// PATCH /open-apis/directory/v1/employees/:employee_id/to_be_resigned
public class ToBeResignedEmployeeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ToBeResignedEmployeeReq req = ToBeResignedEmployeeReq.newBuilder()
                .employeeId("cad2cafa")
                .employeeIdType("open_id")
                .departmentIdType("open_department_id")
                .toBeResignedEmployeeReqBody(ToBeResignedEmployeeReqBody.newBuilder()
                        .employee(SetEmployeePreResigned.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        ToBeResignedEmployeeResp resp = client.directory().v1().employee().toBeResigned(req);

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
