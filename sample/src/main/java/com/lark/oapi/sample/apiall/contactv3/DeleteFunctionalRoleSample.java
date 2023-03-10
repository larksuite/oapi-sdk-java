package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.DeleteFunctionalRoleReq;
import com.lark.oapi.service.contact.v3.model.DeleteFunctionalRoleResp;

// DELETE /open-apis/contact/v3/functional_roles/:role_id
public class DeleteFunctionalRoleSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteFunctionalRoleReq req = DeleteFunctionalRoleReq.newBuilder()
                .roleId("7vrj3vk70xk7v5r")
                .build();

        // 发起请求
        DeleteFunctionalRoleResp resp = client.contact().functionalRole().delete(req);

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
