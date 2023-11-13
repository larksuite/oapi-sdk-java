package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

// PATCH /open-apis/hire/v1/employees/:employee_id
public class PatchEmployeeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchEmployeeReq req = PatchEmployeeReq.newBuilder()
                .employeeId("123")
                .userIdType("open_id")
                .departmentIdType("people_admin_department_id")
                .changeEmployeeStage(ChangeEmployeeStage.newBuilder()
                        .operation(1)
                        .conversionInfo(EmployeeConversionInfo.newBuilder().build())
                        .overboardInfo(EmployeeOverboardInfo.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        PatchEmployeeResp resp = client.hire().employee().patch(req);

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
