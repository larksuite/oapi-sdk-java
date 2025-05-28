package com.lark.oapi.sample.apiall.mdmv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mdm.v3.model.*;

import java.util.HashMap;

// GET /open-apis/mdm/v3/batch_country_region
public class GetBatchCountryRegionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetBatchCountryRegionReq req = GetBatchCountryRegionReq.newBuilder()
                .fields(new String[]{})
                .ids(new String[]{})
                .languages(new String[]{})
                .getBatchCountryRegionReqBody(GetBatchCountryRegionReqBody.newBuilder()
                        .build())
                .build();

        // 发起请求
        GetBatchCountryRegionResp resp = client.mdm().v3().batchCountryRegion().get(req);

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
