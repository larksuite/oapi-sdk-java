package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.GetDailyReportReq;
import com.lark.oapi.service.vc.v1.model.GetDailyReportResp;

// HTTP PATH: /open-apis/vc/v1/reports/get_daily"
public class GetDailyReportSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    GetDailyReportReq req = GetDailyReportReq.newBuilder()
        .startTime("1608888867")
        .endTime("1608888966")
        .build();

    // 发起请求
    GetDailyReportResp resp = client.vc().report().getDaily(req);

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
