package com.lark.oapi.sample.apiall.directoryv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.directory.v1.model.*;

import java.util.HashMap;

// POST /open-apis/directory/v1/departments/filter
public class FilterDepartmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        FilterDepartmentReq req = FilterDepartmentReq.newBuilder()
                .employeeIdType("open_id")
                .departmentIdType("open_department_id")
                .filterDepartmentReqBody(FilterDepartmentReqBody.newBuilder()
                        .filter(MultiFilterCondition.newBuilder().build())
                        .requiredFields(new String[]{})
                        .pageRequest(PageCondition.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        FilterDepartmentResp resp = client.directory().v1().department().filter(req);

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
