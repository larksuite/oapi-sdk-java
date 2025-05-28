package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/websites/:website_id/deliveries/create_by_attachment
public class CreateByAttachmentWebsiteDeliverySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateByAttachmentWebsiteDeliveryReq req = CreateByAttachmentWebsiteDeliveryReq.newBuilder()
                .websiteId("7047318856652261676")
                .websiteDeliveryAttachment(WebsiteDeliveryAttachment.newBuilder()
                        .jobPostId("6960663240925956636")
                        .userId("6960663240925956634")
                        .resumeFileId("7095614894070434092")
                        .channelId("6891560630172518670")
                        .applicationPreferredCityCodeList(new String[]{})
                        .mobileCountryCode("CN_1")
                        .mobile("182900291190")
                        .email("foo@bytedance.com")
                        .identification(WebsiteDeliveryAttachmentIndentification.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        CreateByAttachmentWebsiteDeliveryResp resp = client.hire().v1().websiteDelivery().createByAttachment(req);

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
