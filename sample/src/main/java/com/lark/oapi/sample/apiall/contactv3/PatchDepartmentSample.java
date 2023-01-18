package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.*;

// PATCH /open-apis/contact/v3/departments/:department_id
public class PatchDepartmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchDepartmentReq req = PatchDepartmentReq.newBuilder()
                .departmentId("D096")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .department(Department.newBuilder()
                        .name("DemoName")
                        .i18nName(DepartmentI18nName.newBuilder().build())
                        .parentDepartmentId("D067")
                        .leaderUserId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
                        .order("100")
                        .unitIds(new String[]{})
                        .createGroupChat(false)
                        .leaders(new DepartmentLeader[]{})
                        .groupChatEmployeeTypes(new Integer[]{})
                        .departmentHrbps(new String[]{})
                        .build())
                .build();

        // 发起请求
        PatchDepartmentResp resp = client.contact().department().patch(req);

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
