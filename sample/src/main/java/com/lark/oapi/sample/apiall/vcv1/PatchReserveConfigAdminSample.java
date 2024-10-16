package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.*;

import java.util.HashMap;

// PATCH /open-apis/vc/v1/reserve_configs/:reserve_config_id/admin
public class PatchReserveConfigAdminSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchReserveConfigAdminReq req = PatchReserveConfigAdminReq.newBuilder()
                .reserveConfigId("omm_3c5dd7e09bac0c1758fcf9511bd1a771")
                .userIdType("user_id")
                .patchReserveConfigAdminReqBody(PatchReserveConfigAdminReqBody.newBuilder()
                        .scopeType(2)
                        .reserveAdminConfig(ReserveAdminConfig.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        PatchReserveConfigAdminResp resp = client.vc().v1().reserveConfigAdmin().patch(req);

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
