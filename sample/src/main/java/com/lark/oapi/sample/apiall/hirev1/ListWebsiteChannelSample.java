package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// GET /open-apis/hire/v1/websites/:website_id/channels
public class ListWebsiteChannelSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListWebsiteChannelReq req = ListWebsiteChannelReq.newBuilder()
                .websiteId("1618209327096")
                .pageSize("100")
                .pageToken("eyJvZmZzZXQiOjEwLCJ0aW1NTUyMjM2NzIsImlkIjpudWxsfQ")
                .build();

        // 发起请求
        ListWebsiteChannelResp resp = client.hire().v1().websiteChannel().list(req);

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
