package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.CreateFunctionalRoleReq;
import com.lark.oapi.service.contact.v3.model.CreateFunctionalRoleReqBody;
import com.lark.oapi.service.contact.v3.model.CreateFunctionalRoleResp;

// POST /open-apis/contact/v3/functional_roles
public class CreateFunctionalRoleSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateFunctionalRoleReq req = CreateFunctionalRoleReq.newBuilder()
                .createFunctionalRoleReqBody(CreateFunctionalRoleReqBody.newBuilder()
                        .roleName("考勤管理员")
                        .build())
                .build();

        // 发起请求
        CreateFunctionalRoleResp resp = client.contact().v3().functionalRole().create(req);

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
