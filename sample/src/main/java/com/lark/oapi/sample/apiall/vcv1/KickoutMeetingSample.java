package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.KickoutMeetingReq;
import com.lark.oapi.service.vc.v1.model.KickoutMeetingReqBody;
import com.lark.oapi.service.vc.v1.model.KickoutMeetingResp;
import com.lark.oapi.service.vc.v1.model.MeetingUser;

// POST /open-apis/vc/v1/meetings/:meeting_id/kickout
public class KickoutMeetingSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    KickoutMeetingReq req = KickoutMeetingReq.newBuilder()
        .meetingId("6911188411932033028")
        .userIdType("user_id")
        .kickoutMeetingReqBody(KickoutMeetingReqBody.newBuilder()
            .kickoutUsers(new MeetingUser[]{})
            .build())
        .build();

    // 发起请求
    KickoutMeetingResp resp = client.vc().meeting().kickout(req);

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
