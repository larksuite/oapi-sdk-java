package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.MoveTalentTalentPoolReq;
import com.lark.oapi.service.hire.v1.model.MoveTalentTalentPoolReqBody;
import com.lark.oapi.service.hire.v1.model.MoveTalentTalentPoolResp;

// POST /open-apis/hire/v1/talent_pools/:talent_pool_id/talent_relationship
public class MoveTalentTalentPoolSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        MoveTalentTalentPoolReq req = MoveTalentTalentPoolReq.newBuilder()
                .talentPoolId("6930815272790114325")
                .moveTalentTalentPoolReqBody(MoveTalentTalentPoolReqBody.newBuilder()
                        .talentId("6930815272790114324")
                        .addType(1)
                        .build())
                .build();

        // 发起请求
        MoveTalentTalentPoolResp resp = client.hire().v1().talentPool().moveTalent(req);

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
