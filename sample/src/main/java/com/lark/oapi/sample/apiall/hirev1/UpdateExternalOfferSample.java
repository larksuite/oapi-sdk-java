package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// PUT /open-apis/hire/v1/external_offers/:external_offer_id
public class UpdateExternalOfferSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateExternalOfferReq req = UpdateExternalOfferReq.newBuilder()
                .externalOfferId("6960663240925956660")
                .externalOffer(ExternalOffer.newBuilder()
                        .externalApplicationId("7395015673275697419")
                        .bizCreateTime("1721899352428")
                        .owner("张三")
                        .offerStatus("已发送")
                        .attachmentIdList(new String[]{})
                        .build())
                .build();

        // 发起请求
        UpdateExternalOfferResp resp = client.hire().v1().externalOffer().update(req);

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
