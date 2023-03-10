package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.GetFunctionalRoleMemberReq;
import com.lark.oapi.service.contact.v3.model.GetFunctionalRoleMemberResp;

// GET /open-apis/contact/v3/functional_roles/:role_id/members/:member_id
public class GetFunctionalRoleMemberSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetFunctionalRoleMemberReq req = GetFunctionalRoleMemberReq.newBuilder()
                .roleId("7vrj3vk70xk7v5r")
                .memberId("od-123456")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .build();

        // 发起请求
        GetFunctionalRoleMemberResp resp = client.contact().functionalRoleMember().get(req);

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
