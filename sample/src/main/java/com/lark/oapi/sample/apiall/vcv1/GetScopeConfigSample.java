package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.GetScopeConfigReq;
import com.lark.oapi.service.vc.v1.model.GetScopeConfigResp;

// GET /open-apis/vc/v1/scope_config
public class GetScopeConfigSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetScopeConfigReq req = GetScopeConfigReq.newBuilder()
                .scopeType(1)
                .scopeId("omm_608d34d82d531b27fa993902d350a307")
                .userIdType("user_id")
                .build();

        // 发起请求
        GetScopeConfigResp resp = client.vc().v1().scopeConfig().get(req);

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
