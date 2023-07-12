package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.DisableInformConfig;
import com.lark.oapi.service.vc.v1.model.PatchReserveConfigDisableInformReq;
import com.lark.oapi.service.vc.v1.model.PatchReserveConfigDisableInformReqBody;
import com.lark.oapi.service.vc.v1.model.PatchReserveConfigDisableInformResp;

// PATCH /open-apis/vc/v1/reserve_configs/:reserve_config_id/disable_inform
public class PatchReserveConfigDisableInformSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchReserveConfigDisableInformReq req = PatchReserveConfigDisableInformReq.newBuilder()
                .reserveConfigId("omm_3c5dd7e09bac0c1758fcf9511bd1a771")
                .userIdType("user_id")
                .patchReserveConfigDisableInformReqBody(PatchReserveConfigDisableInformReqBody.newBuilder()
                        .scopeType(2)
                        .disableInform(DisableInformConfig.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        PatchReserveConfigDisableInformResp resp = client.vc().reserveConfigDisableInform().patch(req);

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
