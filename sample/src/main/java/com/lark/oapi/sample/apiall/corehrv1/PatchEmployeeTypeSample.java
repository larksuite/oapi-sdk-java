package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;

// PATCH /open-apis/corehr/v1/employee_types/:employee_type_id
public class PatchEmployeeTypeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchEmployeeTypeReq req = PatchEmployeeTypeReq.newBuilder()
                .employeeTypeId("6969828847931885087")
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
        PatchEmployeeTypeResp resp = client.corehr().v1().employeeType().patch(req);

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
