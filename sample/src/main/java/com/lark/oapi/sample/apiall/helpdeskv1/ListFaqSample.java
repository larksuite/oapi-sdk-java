package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.ListFaqReq;
import com.lark.oapi.service.helpdesk.v1.model.ListFaqResp;

// HTTP PATH: /open-apis/helpdesk/v1/faqs"
public class ListFaqSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    ListFaqReq req = ListFaqReq.newBuilder()
        .categoryId("")
        .status("")
        .search("")
        .pageToken("")
        .pageSize(20)
        .build();

    // 发起请求
    ListFaqResp resp = client.helpdesk().faq().list(req);

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
