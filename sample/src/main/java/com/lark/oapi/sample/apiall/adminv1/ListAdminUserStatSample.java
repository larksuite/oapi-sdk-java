package com.lark.oapi.sample.apiall.adminv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.admin.v1.model.ListAdminUserStatReq;
import com.lark.oapi.service.admin.v1.model.ListAdminUserStatResp;

// GET /open-apis/admin/v1/admin_user_stats
public class ListAdminUserStatSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListAdminUserStatReq req = ListAdminUserStatReq.newBuilder()
                .userIdType("user_id")
                .departmentIdType("open_department_id")
                .startDate("2020-02-15")
                .endDate("2020-02-15")
                .departmentId("od-382e2793cfc9471f892e8a672987654c")
                .userId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
                .pageSize(10)
                .pageToken("2")
                .targetGeo("cn")
                .build();

        // 发起请求
        ListAdminUserStatResp resp = client.admin().v1().adminUserStat().list(req);

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
