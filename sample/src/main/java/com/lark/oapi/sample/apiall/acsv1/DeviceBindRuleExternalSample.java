package com.lark.oapi.sample.apiall.acsv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.acs.v1.model.DeviceBindRuleExternalReq;
import com.lark.oapi.service.acs.v1.model.DeviceBindRuleExternalReqBody;
import com.lark.oapi.service.acs.v1.model.DeviceBindRuleExternalResp;

// POST /open-apis/acs/v1/rule_external/device_bind
public class DeviceBindRuleExternalSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeviceBindRuleExternalReq req = DeviceBindRuleExternalReq.newBuilder()
                .deviceBindRuleExternalReqBody(DeviceBindRuleExternalReqBody.newBuilder()
                        .deviceId("6939433228970082593")
                        .ruleIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        DeviceBindRuleExternalResp resp = client.acs().v1().ruleExternal().deviceBind(req);

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
