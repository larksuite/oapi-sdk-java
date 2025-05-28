package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/talent_pools/:talent_pool_id/batch_change_talent_pool
public class BatchChangeTalentPoolTalentPoolSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchChangeTalentPoolTalentPoolReq req = BatchChangeTalentPoolTalentPoolReq.newBuilder()
                .talentPoolId("6930815272790114325")
                .batchChangeTalentPoolTalentPoolReqBody(BatchChangeTalentPoolTalentPoolReqBody.newBuilder()
                        .talentIdList(new String[]{})
                        .optionType(1)
                        .build())
                .build();

        // 发起请求
        BatchChangeTalentPoolTalentPoolResp resp = client.hire().v1().talentPool().batchChangeTalentPool(req);

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
