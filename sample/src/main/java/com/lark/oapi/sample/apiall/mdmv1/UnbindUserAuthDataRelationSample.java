package com.lark.oapi.sample.apiall.mdmv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mdm.v1.model.UnbindUserAuthDataRelationReq;
import com.lark.oapi.service.mdm.v1.model.UnbindUserAuthDataRelationResp;
import com.lark.oapi.service.mdm.v1.model.UserAuthDataRelation;

// POST /open-apis/mdm/v1/user_auth_data_relations/unbind
public class UnbindUserAuthDataRelationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UnbindUserAuthDataRelationReq req = UnbindUserAuthDataRelationReq.newBuilder()
                .userIdType("user_id")
                .userAuthDataRelation(UserAuthDataRelation.newBuilder()
                        .rootDimensionType("zijie")
                        .subDimensionTypes(new String[]{})
                        .authorizedUserIds(new String[]{})
                        .uamsAppId("uams-tenant-test")
                        .build())
                .build();

        // 发起请求
        UnbindUserAuthDataRelationResp resp = client.mdm().userAuthDataRelation().unbind(req);

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
