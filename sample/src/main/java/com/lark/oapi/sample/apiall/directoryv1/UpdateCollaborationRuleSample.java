package com.lark.oapi.sample.apiall.directoryv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.directory.v1.model.*;

import java.util.HashMap;

// PUT /open-apis/directory/v1/collaboration_rules/:collaboration_rule_id
public class UpdateCollaborationRuleSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateCollaborationRuleReq req = UpdateCollaborationRuleReq.newBuilder()
                .collaborationRuleId("12121")
                .targetTenantKey("test_key")
                .updateCollaborationRuleReqBody(UpdateCollaborationRuleReqBody.newBuilder()
                        .subjects(CollaborationRuleEntities.newBuilder().build())
                        .objects(CollaborationRuleEntities.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        UpdateCollaborationRuleResp resp = client.directory().v1().collaborationRule().update(req);

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
