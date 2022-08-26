package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.ChatTopNotice;
import com.lark.oapi.service.im.v1.model.PutTopNoticeChatTopNoticeReq;
import com.lark.oapi.service.im.v1.model.PutTopNoticeChatTopNoticeReqBody;
import com.lark.oapi.service.im.v1.model.PutTopNoticeChatTopNoticeResp;

// POST /open-apis/im/v1/chats/:chat_id/top_notice/put_top_notice
public class PutTopNoticeChatTopNoticeSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    PutTopNoticeChatTopNoticeReq req = PutTopNoticeChatTopNoticeReq.newBuilder()
        .chatId("oc_5ad11d72b830411d72b836c20")
        .putTopNoticeChatTopNoticeReqBody(PutTopNoticeChatTopNoticeReqBody.newBuilder()
            .chatTopNotice(new ChatTopNotice[]{})
            .build())
        .build();

    // 发起请求
    PutTopNoticeChatTopNoticeResp resp = client.im().chatTopNotice().putTopNotice(req);

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
