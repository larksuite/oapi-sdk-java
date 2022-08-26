package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.QueryUserReq;
import com.lark.oapi.service.mail.v1.model.QueryUserReqBody;
import com.lark.oapi.service.mail.v1.model.QueryUserResp;

// POST /open-apis/mail/v1/users/query
public class QueryUserSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    QueryUserReq req = QueryUserReq.newBuilder()
        .queryUserReqBody(QueryUserReqBody.newBuilder()
            .emailList(new String[]{})
            .build())
        .build();

    // 发起请求
    QueryUserResp resp = client.mail().user().query(req);

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
