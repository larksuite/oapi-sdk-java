package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.GetChatAnnouncementReq;
import com.lark.oapi.service.im.v1.model.GetChatAnnouncementResp;

// GET /open-apis/im/v1/chats/:chat_id/announcement
public class GetChatAnnouncementSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetChatAnnouncementReq req = GetChatAnnouncementReq.newBuilder()
                .chatId("oc_5ad11d72b830411d72b836c20")
                .userIdType("open_id")
                .build();

        // 发起请求
        GetChatAnnouncementResp resp = client.im().v1().chatAnnouncement().get(req);

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
