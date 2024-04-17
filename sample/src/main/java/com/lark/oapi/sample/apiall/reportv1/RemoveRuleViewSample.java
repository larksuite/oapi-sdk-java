package com.lark.oapi.sample.apiall.reportv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.report.v1.model.RemoveRuleViewReq;
import com.lark.oapi.service.report.v1.model.RemoveRuleViewReqBody;
import com.lark.oapi.service.report.v1.model.RemoveRuleViewResp;

// POST /open-apis/report/v1/rules/:rule_id/views/remove
public class RemoveRuleViewSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        RemoveRuleViewReq req = RemoveRuleViewReq.newBuilder()
                .ruleId("6894419345318182122")
                .userIdType("user_id")
                .removeRuleViewReqBody(RemoveRuleViewReqBody.newBuilder()
                        .userIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        RemoveRuleViewResp resp = client.report().v1().ruleView().remove(req);

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
