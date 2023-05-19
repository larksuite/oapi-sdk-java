package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.OfferStatusOfferReq;
import com.lark.oapi.service.hire.v1.model.OfferStatusOfferReqBody;
import com.lark.oapi.service.hire.v1.model.OfferStatusOfferResp;

// PATCH /open-apis/hire/v1/offers/:offer_id/offer_status
public class OfferStatusOfferSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        OfferStatusOfferReq req = OfferStatusOfferReq.newBuilder()
                .offerId("6930815272790114324")
                .offerStatusOfferReqBody(OfferStatusOfferReqBody.newBuilder()
                        .offerStatus(2)
                        .expirationDate("2023-01-01")
                        .terminationReasonIdList(new String[]{})
                        .terminationReasonNote("不符合期望")
                        .build())
                .build();

        // 发起请求
        OfferStatusOfferResp resp = client.hire().offer().offerStatus(req);

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
