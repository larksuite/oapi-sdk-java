package com.lark.oapi.sample.apiall.acsv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.acs.v1.model.DeleteRuleExternalReq;
import com.lark.oapi.service.acs.v1.model.DeleteRuleExternalResp;

// DELETE /open-apis/acs/v1/rule_external
public class DeleteRuleExternalSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteRuleExternalReq req = DeleteRuleExternalReq.newBuilder()
                .ruleId("7298933941867135276")
                .build();

        // 发起请求
        DeleteRuleExternalResp resp = client.acs().v1().ruleExternal().delete(req);

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
