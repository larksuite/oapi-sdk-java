package com.lark.oapi.sample.apiall.mdmv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mdm.v3.model.*;

import java.util.HashMap;

// GET /open-apis/mdm/v3/country_regions
public class ListCountryRegionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListCountryRegionReq req = ListCountryRegionReq.newBuilder()
                .languages(new String[]{})
                .fields(new String[]{})
                .limit(10)
                .offset(0)
                .returnCount(false)
                .pageToken("")
                .listCountryRegionReqBody(ListCountryRegionReqBody.newBuilder()
                        .filter(Filter.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        ListCountryRegionResp resp = client.mdm().v3().countryRegion().list(req);

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
