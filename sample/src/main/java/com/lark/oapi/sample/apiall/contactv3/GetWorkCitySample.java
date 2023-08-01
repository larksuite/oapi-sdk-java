package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.GetWorkCityReq;
import com.lark.oapi.service.contact.v3.model.GetWorkCityResp;

// GET /open-apis/contact/v3/work_cities/:work_city_id
public class GetWorkCitySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetWorkCityReq req = GetWorkCityReq.newBuilder()
                .workCityId("dd39369b19b9")
                .build();

        // 发起请求
        GetWorkCityResp resp = client.contact().workCity().get(req);

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
