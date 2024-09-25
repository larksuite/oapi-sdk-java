package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.ListUserRoleReq;
import com.lark.oapi.service.hire.v1.model.ListUserRoleResp;

// GET /open-apis/hire/v1/user_roles
public class ListUserRoleSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListUserRoleReq req = ListUserRoleReq.newBuilder()
                .pageToken("eyJvZmZzZXQiOjEwLCJ0aW1lc3RhbXAiOjE2Mjc1NTUyMjM2NzIsImlkIjpudWxsfQ==")
                .pageSize(10)
                .userId("ou_xxxx")
                .roleId("101")
                .updateStartTime("1618500278663")
                .updateEndTime("1618500278663")
                .userIdType("user_id")
                .build();

        // 发起请求
        ListUserRoleResp resp = client.hire().v1().userRole().list(req);

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
