package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.ReserveMeetingSetting;
import com.lark.oapi.service.vc.v1.model.UpdateReserveReq;
import com.lark.oapi.service.vc.v1.model.UpdateReserveReqBody;
import com.lark.oapi.service.vc.v1.model.UpdateReserveResp;

// PUT /open-apis/vc/v1/reserves/:reserve_id
public class UpdateReserveSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    UpdateReserveReq req = UpdateReserveReq.newBuilder()
        .reserveId("6911188411932033028")
        .userIdType("user_id")
        .updateReserveReqBody(UpdateReserveReqBody.newBuilder()
            .endTime("1608888867")
            .meetingSettings(ReserveMeetingSetting.newBuilder().build())
            .build())
        .build();

    // 发起请求
    UpdateReserveResp resp = client.vc().reserve().update(req);

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
