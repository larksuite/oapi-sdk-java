package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.CreateWebsiteChannelReq;
import com.lark.oapi.service.hire.v1.model.CreateWebsiteChannelReqBody;
import com.lark.oapi.service.hire.v1.model.CreateWebsiteChannelResp;

// POST /open-apis/hire/v1/websites/:website_id/channels
public class CreateWebsiteChannelSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateWebsiteChannelReq req = CreateWebsiteChannelReq.newBuilder()
                .websiteId("1618209327096")
                .createWebsiteChannelReqBody(CreateWebsiteChannelReqBody.newBuilder()
                        .channelName("小爱侧推广渠道")
                        .build())
                .build();

        // 发起请求
        CreateWebsiteChannelResp resp = client.hire().v1().websiteChannel().create(req);

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
