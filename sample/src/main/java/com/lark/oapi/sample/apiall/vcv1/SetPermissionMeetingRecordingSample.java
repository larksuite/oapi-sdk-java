package com.lark.oapi.sample.apiall.vcv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.vc.v1.model.RecordingPermissionObject;
import com.lark.oapi.service.vc.v1.model.SetPermissionMeetingRecordingReq;
import com.lark.oapi.service.vc.v1.model.SetPermissionMeetingRecordingReqBody;
import com.lark.oapi.service.vc.v1.model.SetPermissionMeetingRecordingResp;

// PATCH /open-apis/vc/v1/meetings/:meeting_id/recording/set_permission
public class SetPermissionMeetingRecordingSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    SetPermissionMeetingRecordingReq req = SetPermissionMeetingRecordingReq.newBuilder()
        .meetingId("6911188411932033028")
        .userIdType("user_id")
        .setPermissionMeetingRecordingReqBody(SetPermissionMeetingRecordingReqBody.newBuilder()
            .permissionObjects(new RecordingPermissionObject[]{})
            .build())
        .build();

    // 发起请求
    SetPermissionMeetingRecordingResp resp = client.vc().meetingRecording().setPermission(req);

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
