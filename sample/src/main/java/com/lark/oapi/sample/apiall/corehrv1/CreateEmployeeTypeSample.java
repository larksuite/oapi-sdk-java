package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v1.model.Enum;

// POST /open-apis/corehr/v1/employee_types
public class CreateEmployeeTypeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateEmployeeTypeReq req = CreateEmployeeTypeReq.newBuilder()
                .clientToken("12454646")
                .employeeType(EmployeeType.newBuilder()
                        .name(new I18n[]{})
                        .defaultEmployeeType(true)
                        .active(true)
                        .code("1245")
                        .customFields(new ObjectFieldData[]{})
                        .build())
                .build();

        // 发起请求
        CreateEmployeeTypeResp resp = client.corehr().v1().employeeType().create(req);

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
