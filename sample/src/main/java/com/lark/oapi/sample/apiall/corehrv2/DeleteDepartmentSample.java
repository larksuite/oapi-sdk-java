package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// DELETE /open-apis/corehr/v2/departments/:department_id
public class DeleteDepartmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteDepartmentReq req = DeleteDepartmentReq.newBuilder()
                .departmentId("1616161616")
                .departmentIdType("open_department_id")
                .build();

        // 发起请求
        DeleteDepartmentResp resp = client.corehr().v2().department().delete(req);

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