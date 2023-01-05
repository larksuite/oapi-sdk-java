package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.DeleteTopNoticeChatTopNoticeReq;
import com.lark.oapi.service.im.v1.model.DeleteTopNoticeChatTopNoticeResp;

// POST /open-apis/im/v1/chats/:chat_id/top_notice/delete_top_notice
public class DeleteTopNoticeChatTopNoticeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteTopNoticeChatTopNoticeReq req = DeleteTopNoticeChatTopNoticeReq.newBuilder()
                .chatId("oc_5ad11d72b830411d72b836c20")
                .build();

        // 发起请求
        DeleteTopNoticeChatTopNoticeResp resp = client.im().chatTopNotice().deleteTopNotice(req);

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
