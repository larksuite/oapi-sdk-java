package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.ListOfferReq;
import com.lark.oapi.service.hire.v1.model.ListOfferResp;

// GET /open-apis/hire/v1/offers
public class ListOfferSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListOfferReq req = ListOfferReq.newBuilder()
                .pageToken("1231231987")
                .pageSize(1)
                .talentId("7096320678581242123")
                .userIdType("user_id")
                .build();

        // 发起请求
        ListOfferResp resp = client.hire().offer().list(req);

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
