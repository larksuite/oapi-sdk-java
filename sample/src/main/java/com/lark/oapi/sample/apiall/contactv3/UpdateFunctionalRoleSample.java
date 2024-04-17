package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.UpdateFunctionalRoleReq;
import com.lark.oapi.service.contact.v3.model.UpdateFunctionalRoleReqBody;
import com.lark.oapi.service.contact.v3.model.UpdateFunctionalRoleResp;

// PUT /open-apis/contact/v3/functional_roles/:role_id
public class UpdateFunctionalRoleSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateFunctionalRoleReq req = UpdateFunctionalRoleReq.newBuilder()
                .roleId("7vrj3vk70xk7v5r")
                .updateFunctionalRoleReqBody(UpdateFunctionalRoleReqBody.newBuilder()
                        .roleName("考勤管理员")
                        .build())
                .build();

        // 发起请求
        UpdateFunctionalRoleResp resp = client.contact().v3().functionalRole().update(req);

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
