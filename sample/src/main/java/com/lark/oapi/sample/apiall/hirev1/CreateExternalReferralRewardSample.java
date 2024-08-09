package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/external_referral_rewards
public class CreateExternalReferralRewardSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateExternalReferralRewardReq req = CreateExternalReferralRewardReq.newBuilder()
                .userIdType("user_id")
                .externalReward(ExternalReward.newBuilder()
                        .referralUserId("on_94a1ee5551019f18cd73d9f111898cf2")
                        .createUserId("on_94a1ee5551019f18cd73d9f111898cf2")
                        .confirmUserId("on_94a1ee5551019f18cd73d9f111898cf2")
                        .payUserId("on_94a1ee5551019f18cd73d9f111898cf2")
                        .externalId("6930815272790114324")
                        .applicationId("6930815272790114325")
                        .talentId("6930815272790114326")
                        .jobId("6930815272790114327")
                        .reason("首次推荐")
                        .ruleType(1)
                        .bonus(BonusAmount.newBuilder().build())
                        .stage(1)
                        .createTime("1704720275000")
                        .confirmTime("1704720275000")
                        .payTime("1704720275001")
                        .onboardTime("1704720275002")
                        .conversionTime("1704720275003")
                        .comment("已发放")
                        .build())
                .build();

        // 发起请求
        CreateExternalReferralRewardResp resp = client.hire().v1().externalReferralReward().create(req);

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
