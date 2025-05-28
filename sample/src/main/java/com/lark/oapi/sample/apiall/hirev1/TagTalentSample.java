package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/talents/:talent_id/tag
public class TagTalentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        TagTalentReq req = TagTalentReq.newBuilder()
                .talentId("6960663240925956661")
                .tagTalentReqBody(TagTalentReqBody.newBuilder()
                        .operation(1)
                        .tagIdList(new String[]{})
                        .build())
                .build();

        // 发起请求
        TagTalentResp resp = client.hire().v1().talent().tag(req);

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
