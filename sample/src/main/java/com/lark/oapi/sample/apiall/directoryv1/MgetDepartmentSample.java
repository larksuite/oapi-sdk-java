package com.lark.oapi.sample.apiall.directoryv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.directory.v1.model.*;

import java.util.HashMap;

// POST /open-apis/directory/v1/departments/mget
public class MgetDepartmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        MgetDepartmentReq req = MgetDepartmentReq.newBuilder()
                .employeeIdType("open_id")
                .departmentIdType("open_department_id")
                .mgetDepartmentReqBody(MgetDepartmentReqBody.newBuilder()
                        .departmentIds(new String[]{})
                        .requiredFields(new String[]{})
                        .build())
                .build();

        // 发起请求
        MgetDepartmentResp resp = client.directory().v1().department().mget(req);

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
