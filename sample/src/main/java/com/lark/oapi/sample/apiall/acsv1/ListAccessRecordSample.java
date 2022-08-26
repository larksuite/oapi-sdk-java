package com.lark.oapi.sample.apiall.acsv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.acs.v1.model.ListAccessRecordReq;
import com.lark.oapi.service.acs.v1.model.ListAccessRecordResp;

// GET /open-apis/acs/v1/access_records
public class ListAccessRecordSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    ListAccessRecordReq req = ListAccessRecordReq.newBuilder()
        .pageSize(100)
        .pageToken(
            "AQD9/Rn9eij9Pm39ED40/dk53s4Ebp882DYfFaPFbz00L4CMZJrqGdzNyc8BcZtDbwVUvRmQTvyMYicnGWrde9X56TgdBuS+JKiSIkdexPw=")
        .from(1624520521)
        .to(1624520521)
        .deviceId("7091146989218002577")
        .userIdType("user_id")
        .build();

    // 发起请求
    ListAccessRecordResp resp = client.acs().accessRecord().list(req);

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
