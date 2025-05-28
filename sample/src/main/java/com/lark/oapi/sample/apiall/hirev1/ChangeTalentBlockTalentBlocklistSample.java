package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/talent_blocklist/change_talent_block
public class ChangeTalentBlockTalentBlocklistSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ChangeTalentBlockTalentBlocklistReq req = ChangeTalentBlockTalentBlocklistReq.newBuilder()
                .changeTalentBlockTalentBlocklistReqBody(ChangeTalentBlockTalentBlocklistReqBody.newBuilder()
                        .talentId("6930815272790114325")
                        .option(1)
                        .reason("人才作弊")
                        .build())
                .build();

        // 发起请求
        ChangeTalentBlockTalentBlocklistResp resp = client.hire().v1().talentBlocklist().changeTalentBlock(req);

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
