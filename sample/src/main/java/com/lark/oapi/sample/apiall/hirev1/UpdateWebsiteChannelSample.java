package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.UpdateWebsiteChannelReq;
import com.lark.oapi.service.hire.v1.model.UpdateWebsiteChannelReqBody;
import com.lark.oapi.service.hire.v1.model.UpdateWebsiteChannelResp;

// PUT /open-apis/hire/v1/websites/:website_id/channels/:channel_id
public class UpdateWebsiteChannelSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateWebsiteChannelReq req = UpdateWebsiteChannelReq.newBuilder()
                .websiteId("1618209327096")
                .channelId("7085989097067563300")
                .updateWebsiteChannelReqBody(UpdateWebsiteChannelReqBody.newBuilder()
                        .channelName("小爱侧推广渠道")
                        .build())
                .build();

        // 发起请求
        UpdateWebsiteChannelResp resp = client.hire().v1().websiteChannel().update(req);

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
