package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.*;

import java.util.HashMap;

// GET /open-apis/contact/v3/functional_roles/:role_id/members
public class ListFunctionalRoleMemberSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListFunctionalRoleMemberReq req = ListFunctionalRoleMemberReq.newBuilder()
                .roleId("7vrj3vk70xk7v5r")
                .pageSize(20)
                .pageToken("dawdewd")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .build();

        // 发起请求
        ListFunctionalRoleMemberResp resp = client.contact().v3().functionalRoleMember().list(req);

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
