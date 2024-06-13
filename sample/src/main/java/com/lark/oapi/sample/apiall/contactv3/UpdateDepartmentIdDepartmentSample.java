package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.*;

import java.util.HashMap;

// PATCH /open-apis/contact/v3/departments/:department_id/update_department_id
public class UpdateDepartmentIdDepartmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateDepartmentIdDepartmentReq req = UpdateDepartmentIdDepartmentReq.newBuilder()
                .departmentId("")
                .departmentIdType("department_id")
                .updateDepartmentIdDepartmentReqBody(UpdateDepartmentIdDepartmentReqBody.newBuilder()
                        .newDepartmentId("")
                        .build())
                .build();

        // 发起请求
        UpdateDepartmentIdDepartmentResp resp = client.contact().v3().department().updateDepartmentId(req);

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
