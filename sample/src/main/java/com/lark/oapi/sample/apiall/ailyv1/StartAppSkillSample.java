package com.lark.oapi.sample.apiall.ailyv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.aily.v1.model.*;

import java.util.HashMap;

// POST /open-apis/aily/v1/apps/:app_id/skills/:skill_id/start
public class StartAppSkillSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        StartAppSkillReq req = StartAppSkillReq.newBuilder()
                .appId("spring_xxx__c")
                .skillId("skill_6cc6166178ca")
                .startAppSkillReqBody(StartAppSkillReqBody.newBuilder()
                        .globalVariable(SkillGlobalVariable.newBuilder().build())
                        .input("")
                        .build())
                .build();

        // 发起请求
        StartAppSkillResp resp = client.aily().v1().appSkill().start(req);

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
