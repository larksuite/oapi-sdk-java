package com.lark.oapi.sample.apiall.ehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.ehr.v1.model.ListEmployeeReq;
import com.lark.oapi.service.ehr.v1.model.ListEmployeeResp;

// GET /open-apis/ehr/v1/employees
public class ListEmployeeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListEmployeeReq req = ListEmployeeReq.newBuilder()
                .view("basic")
                .status(new Integer[]{})
                .type(new Integer[]{})
                .startTime("1608690517811")
                .endTime("1608690517811")
                .userIdType("user_id")
                .userIds(new String[]{})
                .pageToken("10")
                .pageSize(10)
                .build();

        // 发起请求
        ListEmployeeResp resp = client.ehr().employee().list(req);

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
