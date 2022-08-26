package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.GetTopUserReportReq;
import com.lark.oapi.service.vc.v1.model.GetTopUserReportResp;

// GET /open-apis/vc/v1/reports/get_top_user
public class GetTopUserReportSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    GetTopUserReportReq req = GetTopUserReportReq.newBuilder()
        .startTime("1608888867")
        .endTime("1608889966")
        .limit(10)
        .orderBy(1)
        .userIdType("user_id")
        .build();

    // 发起请求
    GetTopUserReportResp resp = client.vc().report().getTopUser(req);

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
