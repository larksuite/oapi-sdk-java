package com.lark.oapi.sample.apiall.mdmv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mdm.v1.model.BindUserAuthDataRelationReq;
import com.lark.oapi.service.mdm.v1.model.BindUserAuthDataRelationResp;
import com.lark.oapi.service.mdm.v1.model.UserAuthDataRelation;

// POST /open-apis/mdm/v1/user_auth_data_relations/bind
public class BindUserAuthDataRelationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BindUserAuthDataRelationReq req = BindUserAuthDataRelationReq.newBuilder()
                .userIdType("user_id")
                .userAuthDataRelation(UserAuthDataRelation.newBuilder()
                        .rootDimensionType("zijie")
                        .subDimensionTypes(new String[]{})
                        .authorizedUserIds(new String[]{})
                        .uamsAppId("uams-tenant-test")
                        .build())
                .build();

        // 发起请求
        BindUserAuthDataRelationResp resp = client.mdm().userAuthDataRelation().bind(req);

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
