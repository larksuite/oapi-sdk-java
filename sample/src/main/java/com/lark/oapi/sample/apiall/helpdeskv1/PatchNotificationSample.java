package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.Notification;
import com.lark.oapi.service.helpdesk.v1.model.NotificationChat;
import com.lark.oapi.service.helpdesk.v1.model.NotificationDepartment;
import com.lark.oapi.service.helpdesk.v1.model.NotificationUser;
import com.lark.oapi.service.helpdesk.v1.model.PatchNotificationReq;
import com.lark.oapi.service.helpdesk.v1.model.PatchNotificationResp;

// HTTP PATH: /open-apis/helpdesk/v1/notifications/:notification_id"
public class PatchNotificationSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    PatchNotificationReq req = PatchNotificationReq.newBuilder()
        .notificationId("6985032626234982420")
        .userIdType("user_id")
        .notification(Notification.newBuilder()
            .id("6981801914270744596")
            .jobName("测试推送任务")
            .status(0)
            .createUser(NotificationUser.newBuilder().build())
            .createdAt("1626332244719")
            .updateUser(NotificationUser.newBuilder().build())
            .updatedAt("1626332244719")
            .targetUserCount(1)
            .sentUserCount(1)
            .readUserCount(1)
            .sendAt("1626332244719")
            .pushContent("")
            .pushType(0)
            .pushScopeType(0)
            .newStaffScopeType(0)
            .newStaffScopeDepartmentList(new NotificationDepartment[]{})
            .userList(new NotificationUser[]{})
            .departmentList(new NotificationDepartment[]{})
            .chatList(new NotificationChat[]{})
            .ext("{}")
            .build())
        .build();

    // 发起请求
    PatchNotificationResp resp = client.helpdesk().notification().patch(req);

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
