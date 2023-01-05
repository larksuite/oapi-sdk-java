package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.GetFaqReq;
import com.lark.oapi.service.helpdesk.v1.model.GetFaqResp;

// GET /open-apis/helpdesk/v1/faqs/:id
public class GetFaqSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetFaqReq req = GetFaqReq.newBuilder()
                .id("6856395634652479491")
                .build();

        // 发起请求
        GetFaqResp resp = client.helpdesk().faq().get(req);

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
