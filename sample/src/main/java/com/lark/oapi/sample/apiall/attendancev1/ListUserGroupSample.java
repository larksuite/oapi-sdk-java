package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.*;

import java.util.HashMap;

// GET /open-apis/attendance/v1/groups/:group_id/list_user
public class ListUserGroupSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListUserGroupReq req = ListUserGroupReq.newBuilder()
                .groupId("6919358128597097404")
                .employeeType("employee_id")
                .deptType("open_id")
                .pageSize(10)
                .pageToken("92xKiuWrBCSweSZJBSTpag%3D%3D")
                .memberClockType(1)
                .build();

        // 发起请求
        ListUserGroupResp resp = client.attendance().v1().group().listUser(req);

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
