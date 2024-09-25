package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.CreateByResumeWebsiteDeliveryReq;
import com.lark.oapi.service.hire.v1.model.CreateByResumeWebsiteDeliveryResp;
import com.lark.oapi.service.hire.v1.model.WebsiteDelivery;
import com.lark.oapi.service.hire.v1.model.WebsiteDeliveryResume;

// POST /open-apis/hire/v1/websites/:website_id/deliveries/create_by_resume
public class CreateByResumeWebsiteDeliverySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateByResumeWebsiteDeliveryReq req = CreateByResumeWebsiteDeliveryReq.newBuilder()
                .websiteId("1618209327096")
                .userIdType("open_id")
                .websiteDelivery(WebsiteDelivery.newBuilder()
                        .jobPostId("6960663240925956636")
                        .resume(WebsiteDeliveryResume.newBuilder().build())
                        .userId("6960663240925956634")
                        .applicationPreferredCityCodeList(new String[]{})
                        .channelId("6891560630172518670")
                        .build())
                .build();

        // 发起请求
        CreateByResumeWebsiteDeliveryResp resp = client.hire().v1().websiteDelivery().createByResume(req);

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
