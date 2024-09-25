package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.GetSubregionReq;
import com.lark.oapi.service.corehr.v1.model.GetSubregionResp;

// GET /open-apis/corehr/v1/subregions/:subregion_id
public class GetSubregionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetSubregionReq req = GetSubregionReq.newBuilder()
                .subregionId("67489937334909845")
                .build();

        // 发起请求
        GetSubregionResp resp = client.corehr().v1().subregion().get(req);

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
