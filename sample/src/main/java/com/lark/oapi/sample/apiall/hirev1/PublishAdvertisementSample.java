package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.PublishAdvertisementReq;
import com.lark.oapi.service.hire.v1.model.PublishAdvertisementReqBody;
import com.lark.oapi.service.hire.v1.model.PublishAdvertisementResp;

// POST /open-apis/hire/v1/advertisements/:advertisement_id/publish
public class PublishAdvertisementSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PublishAdvertisementReq req = PublishAdvertisementReq.newBuilder()
                .advertisementId("6960663240925956660")
                .publishAdvertisementReqBody(PublishAdvertisementReqBody.newBuilder()
                        .jobChannelId("6960663240925956631")
                        .build())
                .build();

        // 发起请求
        PublishAdvertisementResp resp = client.hire().v1().advertisement().publish(req);

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
