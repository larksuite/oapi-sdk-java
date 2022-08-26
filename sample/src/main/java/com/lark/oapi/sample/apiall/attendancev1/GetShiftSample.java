package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.GetShiftReq;
import com.lark.oapi.service.attendance.v1.model.GetShiftResp;

// GET /open-apis/attendance/v1/shifts/:shift_id
public class GetShiftSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    GetShiftReq req = GetShiftReq.newBuilder()
        .shiftId("6919358778597097404")
        .build();

    // 发起请求
    GetShiftResp resp = client.attendance().shift().get(req);

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
