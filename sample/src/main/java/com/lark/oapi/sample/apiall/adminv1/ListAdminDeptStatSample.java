package com.lark.oapi.sample.apiall.adminv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.admin.v1.model.*;

import java.util.HashMap;

// GET /open-apis/admin/v1/admin_dept_stats
public class ListAdminDeptStatSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListAdminDeptStatReq req = ListAdminDeptStatReq.newBuilder()
                .departmentIdType("open_department_id")
                .startDate("2020-02-15")
                .endDate("2020-02-15")
                .departmentId("od-382e2793cfc9471f892e8a672987654c")
                .containsChildDept(false)
                .pageSize(10)
                .pageToken("2")
                .targetGeo("cn")
                .withProductVersion(true)
                .build();

        // 发起请求
        ListAdminDeptStatResp resp = client.admin().v1().adminDeptStat().list(req);

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
