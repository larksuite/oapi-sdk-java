package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.FaqImageFaqReq;
import com.lark.oapi.service.helpdesk.v1.model.FaqImageFaqResp;

// GET /open-apis/helpdesk/v1/faqs/:id/image/:image_key
public class FaqImageFaqSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    FaqImageFaqReq req = FaqImageFaqReq.newBuilder()
        .id("12345")
        .imageKey("img_b07ffac0-19c1-48a3-afca-599f8ea825fj")
        .build();

    // 发起请求
    FaqImageFaqResp resp = client.helpdesk().faq().faqImage(req);

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
