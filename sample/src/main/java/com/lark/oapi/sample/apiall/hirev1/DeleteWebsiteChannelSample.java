package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.DeleteWebsiteChannelReq;
import com.lark.oapi.service.hire.v1.model.DeleteWebsiteChannelResp;

// DELETE /open-apis/hire/v1/websites/:website_id/channels/:channel_id
public class DeleteWebsiteChannelSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteWebsiteChannelReq req = DeleteWebsiteChannelReq.newBuilder()
                .websiteId("1618209327096")
                .channelId("7085989097067563300")
                .build();

        // 发起请求
        DeleteWebsiteChannelResp resp = client.hire().v1().websiteChannel().delete(req);

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
