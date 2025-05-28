package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// PATCH /open-apis/corehr/v2/locations/:location_id/addresses/:address_id
public class PatchLocationAddressSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchLocationAddressReq req = PatchLocationAddressReq.newBuilder()
                .locationId("1616161616")
                .addressId("1515151515")
                .clientToken("12454646")
                .locationAddressUpdate(LocationAddressUpdate.newBuilder()
                        .countryRegionId("6862995757234914824")
                        .regionId("6863326264296474119")
                        .cityId("6863333555859097096")
                        .distinctId("6863333556291110408")
                        .localAddressLine1("丹佛测试地址-纽埃时区")
                        .localAddressLine2("丹佛测试地址-纽埃时区")
                        .localAddressLine3("丹佛测试地址-纽埃时区")
                        .localAddressLine4("丹佛测试地址-纽埃时区")
                        .localAddressLine5("丹佛测试地址-纽埃时区")
                        .localAddressLine6("丹佛测试地址-纽埃时区")
                        .localAddressLine7("丹佛测试地址-纽埃时区")
                        .localAddressLine8("丹佛测试地址-纽埃时区")
                        .localAddressLine9("丹佛测试地址-纽埃时区")
                        .postalCode("611530")
                        .addressTypes(new Enum[]{})
                        .isPrimary(true)
                        .isPublic(true)
                        .build())
                .build();

        // 发起请求
        PatchLocationAddressResp resp = client.corehr().v2().locationAddress().patch(req);

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
