package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/external_offers
public class CreateExternalOfferSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateExternalOfferReq req = CreateExternalOfferReq.newBuilder()
                .externalOffer(ExternalOffer.newBuilder()
                        .externalId("123")
                        .externalApplicationId("7395015673275697419")
                        .bizCreateTime("1721899352428")
                        .owner("张三")
                        .offerStatus("已发送")
                        .attachmentIdList(new String[]{})
                        .build())
                .build();

        // 发起请求
        CreateExternalOfferResp resp = client.hire().v1().externalOffer().create(req);

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
