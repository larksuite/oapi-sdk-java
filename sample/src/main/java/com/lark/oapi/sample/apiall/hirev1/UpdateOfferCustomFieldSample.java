package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

// PUT /open-apis/hire/v1/offer_custom_fields/:offer_custom_field_id
public class UpdateOfferCustomFieldSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateOfferCustomFieldReq req = UpdateOfferCustomFieldReq.newBuilder()
                .offerCustomFieldId("6906755946257615112")
                .offerCustomField(OfferCustomField.newBuilder()
                        .name(I18n.newBuilder().build())
                        .config(OfferCustomFieldConfig.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        UpdateOfferCustomFieldResp resp = client.hire().v1().offerCustomField().update(req);

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
